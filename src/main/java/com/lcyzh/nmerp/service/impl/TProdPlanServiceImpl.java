package com.lcyzh.nmerp.service.impl;

import com.github.pagehelper.PageHelper;
import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.constant.Constants;
import com.lcyzh.nmerp.controller.system.util.UserUtils;
import com.lcyzh.nmerp.dao.*;
import com.lcyzh.nmerp.entity.*;
import com.lcyzh.nmerp.model.vo.OrderItemAssignVo;
import com.lcyzh.nmerp.model.vo.OrderItemVo;
import com.lcyzh.nmerp.model.vo.ProdPlanDetailVo;
import com.lcyzh.nmerp.service.TProdPlanService;
import com.lcyzh.nmerp.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Author ljk
 * Date  2019-06-06
 */
@Service
public class TProdPlanServiceImpl implements TProdPlanService {
    @Autowired
    private TProdPlanMapper tProdPlanMapper;
    @Autowired
    private TProdPlanDetailMapper prodPlanDetailMapper;
    @Autowired
    private TMachineInfoMapper machineInfoMapper;

    @Override
    public TProdPlan findByProdPanCode(String prodPlanCode) {
        return tProdPlanMapper.findByProdPanCode(prodPlanCode);
    }

    @Override
    public Page<ProdPlanDetailVo> findPage(Page<ProdPlanDetailVo> page,ProdPlanDetailVo vo) {
        PageHelper.startPage(page.getPageNo(),page.getPageSize());
        List<ProdPlanDetailVo> list = tProdPlanMapper.findList(vo);
        //获取产品信息
        page.setList(list);
        return page;
    }

    @Override
    public int save(TProdPlan prodPlan) {
        int res = -1;
        if (prodPlan != null) {
            Date current = new Date();
            if (prodPlan != null) {
                res = tProdPlanMapper.update(prodPlan);
            } else {
                res = tProdPlanMapper.insert(prodPlan);
            }
        }
        return res;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    @Override
    public int createProdPlan(List<OrderItemVo> items) {
        int res = -1;
        List<TProdPlan> addList = new ArrayList<>();
        List<TProdPlan> updateList = new ArrayList<>();
        List<TProdPlanDetail> prodPlanDetails = new ArrayList<>();
        if(items != null && !items.isEmpty()) {
            List<TMachineInfo> machineInfos = machineInfoMapper.findAllList();
            //机台支持宽度与code对应关系
            Map<String, String> macMap = new HashMap<>(16);
            for(TMachineInfo machineInfo : machineInfos) {
                macMap.put(machineInfo.getMinWidth() + "-" + machineInfo.getMaxWidth(), machineInfo.getMacCode());
            }
            List<TProdPlan> prodPlans = tProdPlanMapper.findAllList();
            Map<String, TProdPlan> ppMap = new HashMap<>(16);
            if(!prodPlans.isEmpty()) {
                for(TProdPlan prodPlan : prodPlans) {
                    ppMap.put(prodPlan.getProdVariety()+"|"+prodPlan.getProdColor()+"|"+prodPlan.getMacCode(),
                            prodPlan);
                }
            }
            String key;
            String macCode;
            for(OrderItemVo item : items) {
                macCode = getMacCode(macMap,item.getItemWidth());
                key = item.getItemVariety()+"|"+item.getItemColor()+"|"+macCode;
                TProdPlan prodPlan;
                if(ppMap.containsKey(key)) {
                    //计划单包含该类品种和颜色的产品，更新数量
                    prodPlan = ppMap.get(key);
                    prodPlan.setTotalQuantity(prodPlan.getTotalQuantity() + item.getItemNum());
                    if(prodPlan.getIsAuto() == 1) {
                        //自动下发开启
                        prodPlan.setQuantity(prodPlan.getQuantity() + item.getItemNum());
                        prodPlanDetails.add(buildProdPlanDetail(prodPlan.getProdPlanCode(), item, '1'));
                    }else{
                        prodPlanDetails.add(buildProdPlanDetail(prodPlan.getProdPlanCode(), item, '0'));
                    }
                    updateList.add(prodPlan);
                }else{
                    //不包含在计划单内，新建
                    prodPlan = new TProdPlan();
                    prodPlan.setTotalQuantity(item.getItemNum());
                    //自动下发默认关闭
                    prodPlan.setIsAuto('0');
                    prodPlan.setQuantity(0L);
                    prodPlan.setProdColor(item.getItemColor());
                    prodPlan.setProdPlanCode(StringUtils.genFixPreFixStr(Constants.PROD_PLAN_PRE_FIX));
                    prodPlan.setMacCode(macCode);
                    prodPlan.setProdVariety(item.getItemVariety());
                    addList.add(prodPlan);
                    ppMap.put(prodPlan.getProdVariety()+"|"+prodPlan.getProdColor()+"|"+prodPlan.getMacCode(),
                            prodPlan);
                    prodPlanDetails.add(buildProdPlanDetail(prodPlan.getProdPlanCode(), item, '0'));
                }
            }
        }
        if(!addList.isEmpty()) {
            res = tProdPlanMapper.insertBatch(addList);
        }
        if(res > 0 && !updateList.isEmpty()) {
            res = tProdPlanMapper.updateBatch(updateList);
        }else{
            //计划单插入失败
            res = -1;
        }
        if(res > 0 && !prodPlanDetails.isEmpty()) {
            res = prodPlanDetailMapper.insertBatch(prodPlanDetails);
        }else{
            //计划单更新失败
            res = -2;
        }
        return res;
    }

    /**
     * 构建产品计划明细
     * @param prodPlanCode
     * @param vo
     * @param character 0-待确认；1-下发生产
     * @return TProdPlanDetail
     */
    private TProdPlanDetail buildProdPlanDetail(String prodPlanCode, OrderItemVo vo, Character character) {
        TProdPlanDetail detail = new TProdPlanDetail();
        detail.setProdPlanCode(prodPlanCode);
        detail.setItemNum(vo.getItemNum());
        detail.setItemCgyCode(vo.getItemCgyCode());
        detail.setItemCode(vo.getItemCode());
        detail.setItemLenth(vo.getItemLenth());
        detail.setItemThick(vo.getItemThick());
        detail.setItemTotalSq(vo.getItemTotalSq());
        detail.setItemTotalWeight(vo.getItemTotalWeight());
        detail.setItemUnit(vo.getItemUnit());
        detail.setItemVariety(vo.getItemVariety());
        detail.setItemWidth(vo.getItemWidth());
        detail.setItemYbType(vo.getItemYbType());
        detail.setItemYcType(vo.getItemYcType());
        detail.setOrdCode(vo.getOrdCode());
        detail.setItemStatus(character);
        detail.setOrderItemId(vo.getItemId());
        return detail;
    }

    private String getMacCode(Map<String, String> map, Double width) {
        String macCode="";
        for(Map.Entry<String, String> entry : map.entrySet()){
            String[] keys = entry.getKey().split("-");
            if(Double.valueOf(keys[0]) < width && Double.valueOf(keys[1]) > width) {
                macCode = entry.getValue();
                break;
            }
        }
        return macCode;
    }


    @Override
    public List<TProdPlanDetail> findByPlanCode(String planCode) {
        TProdPlanDetail planDetail = new TProdPlanDetail();
        planDetail.setProdPlanCode(planCode);
        return prodPlanDetailMapper.findList(planDetail);
    }

}
