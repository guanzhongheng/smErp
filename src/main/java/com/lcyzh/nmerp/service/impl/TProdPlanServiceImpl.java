package com.lcyzh.nmerp.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.constant.Constants;
import com.lcyzh.nmerp.dao.*;
import com.lcyzh.nmerp.entity.*;
import com.lcyzh.nmerp.model.vo.FormulaDetailVo;
import com.lcyzh.nmerp.model.vo.FormulaVo;
import com.lcyzh.nmerp.model.vo.OrderItemVo;
import com.lcyzh.nmerp.model.vo.ProdPlanVo;
import com.lcyzh.nmerp.service.TProdPlanService;
import com.lcyzh.nmerp.utils.DictUtils;
import com.lcyzh.nmerp.utils.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;
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
    @Autowired
    private TFormulaMapper tFormulaMapper;
    @Value("${yb.type}")
    private String ybType;


    @Override
    public ProdPlanVo findByProdPanCode(String prodPlanCode) {
        ProdPlanVo prodPlanVo = new ProdPlanVo();
        TProdPlan prodPlan = tProdPlanMapper.findByProdPanCode(prodPlanCode);
        BeanUtils.copyProperties(prodPlan, prodPlanVo);
        if(prodPlanVo.getFormula() != null && !prodPlanVo.getFormula().isEmpty()) {
            JSONObject jsonObject = JSON.parseObject(prodPlanVo.getFormula());
            Map<String, FormulaDetailVo> context = new HashMap<>();
            for(String key : jsonObject.keySet()) {
                context.put(key, toJavaBean(new FormulaDetailVo(), jsonObject.getJSONObject(key)));
            }
            prodPlanVo.setContext(context);
        }
        return prodPlanVo;
    }

    public static FormulaDetailVo toJavaBean(FormulaDetailVo javabean, JSONObject data) {
        Method[] methods = javabean.getClass().getDeclaredMethods();
        for (Method method : methods) {
            try {
                if (method.getName().startsWith("set")) {
                    String field = method.getName(); //set()
                    field = field.substring(field.indexOf("set") + 3);//
                    field = field.toLowerCase().charAt(0) + field.substring(1);//
                    method.invoke(javabean, new Object[]
                            {
                                    data.get(field)
                            });
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return javabean;
    }

    @Override
    public List<ProdPlanVo> findPage(Page<ProdPlanVo> page, ProdPlanVo vo) {
        PageHelper.startPage(page.getPageNo(),page.getPageSize());
        List<ProdPlanVo> list = tProdPlanMapper.findList(vo);
        PageInfo<ProdPlanVo> pageInfo = new PageInfo<>(list);
        page.setTotal(pageInfo.getTotal());
        return list;
    }

    @Override
    public int update(TProdPlan prodPlan) {
        return tProdPlanMapper.update(prodPlan);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    @Override
    public int createProdPlan(List<OrderItemVo> items) {
        List<OrderItemVo> items4Yb = items.stream().filter(item -> item.getItemYbType().equals(ybType)).collect(Collectors.toList());
        if(items4Yb != null && !items4Yb.isEmpty() && createProdPlan(items4Yb, true) > 0){
            items = items.stream().filter(item -> !item.getItemYbType().equals(ybType)).collect(Collectors.toList());

           return createProdPlan(items, false);
        }
        return -1;
    }

    public int createProdPlan(List<OrderItemVo> items, boolean flag) {
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
                    if(flag) {
                        ppMap.put(prodPlan.getProdCgyCode()+"|"+prodPlan.getProdVariety()+"|"+prodPlan.getProdColor()+"|"+prodPlan.getMacCode()+"|"+prodPlan.getProdYbType(),
                                prodPlan);
                    }else{
                        ppMap.put(prodPlan.getProdCgyCode()+"|"+prodPlan.getProdVariety()+"|"+prodPlan.getProdColor()+"|"+prodPlan.getMacCode(),
                                prodPlan);
                    }
                }
            }
            Map<String, TProdPlan> ppMapNew = new HashMap<>(16);
            Map<String, TProdPlan> ppMapUpdate = new HashMap<>(16);
            String key;
            String macCode;
            for(OrderItemVo item : items) {
                macCode = getMacCode(macMap,item.getItemWidth());
                if(flag) {
                    key = item.getItemCgyCode()+"|"+item.getItemVariety()+"|"+item.getItemColor()+"|"+macCode+"|"+item.getItemYbType();
                }else{
                    key = item.getItemCgyCode()+"|"+item.getItemVariety()+"|"+item.getItemColor()+"|"+macCode;
                }
                TProdPlan prodPlan;
                if(ppMap.containsKey(key)) {
                    //计划单包含该类品种和颜色的产品，更新数量
                    prodPlan = ppMap.get(key);
                    prodPlan.setTotalQuantity(prodPlan.getTotalQuantity() + item.getItemNum());
                    if(prodPlan.getIsAuto() == 1) {
                        //自动下发开启
                        prodPlan.setQuantity(prodPlan.getQuantity() + item.getItemNum());
                        prodPlanDetails.add(buildProdPlanDetail(macCode, prodPlan.getProdPlanCode(), item, '1'));
                    }else{
                        prodPlanDetails.add(buildProdPlanDetail(macCode, prodPlan.getProdPlanCode(), item, '0'));
                    }
                    ppMapUpdate.put(key, prodPlan);
                }else{
                    //不包含在计划单内，新建
                    if(ppMapNew.containsKey(key)) {
                        prodPlan = ppMapNew.get(key);
                        prodPlan.setTotalQuantity(prodPlan.getTotalQuantity() + item.getItemNum());
                        if(prodPlan.getIsAuto() == 1) {
                            //自动下发开启
                            prodPlan.setQuantity(prodPlan.getQuantity() + item.getItemNum());
                            prodPlanDetails.add(buildProdPlanDetail(macCode, prodPlan.getProdPlanCode(), item, '1'));
                        }else{
                            prodPlanDetails.add(buildProdPlanDetail(macCode, prodPlan.getProdPlanCode(), item, '0'));
                        }
                        ppMapNew.put(key, prodPlan);
                    }else{
                        prodPlan = new TProdPlan();
                        prodPlan.setTotalQuantity(item.getItemNum());
                        //自动下发默认关闭
                        prodPlan.setIsAuto('0');
                        prodPlan.setQuantity(0L);
                        prodPlan.setProdColor(item.getItemColor());
                        prodPlan.setProdPlanCode(StringUtils.genFixPreFixStr(Constants.PROD_PLAN_PRE_FIX));
                        prodPlan.setMacCode(macCode);
                        prodPlan.setProdVariety(item.getItemVariety());
                        prodPlan.setProdCgyCode(item.getItemCgyCode());
                        if(flag) {
                            prodPlan.setProdYbType(item.getItemYbType());
                            ppMapNew.put(prodPlan.getProdCgyCode()+"|"+prodPlan.getProdVariety()+"|"+prodPlan.getProdColor()+"|"+prodPlan.getMacCode()+"|"+prodPlan.getProdYbType(),
                                    prodPlan);
                        }else{
                            ppMapNew.put(prodPlan.getProdCgyCode()+"|"+prodPlan.getProdVariety()+"|"+prodPlan.getProdColor()+"|"+prodPlan.getMacCode(),
                                    prodPlan);

                        }
                        prodPlanDetails.add(buildProdPlanDetail(macCode,prodPlan.getProdPlanCode(), item, '0'));
                    }
                }
            }
            if(ppMapNew.size() > 0) {
                for(TProdPlan value : ppMapNew.values()) {
                    addList.add(value);
                }
                res = tProdPlanMapper.insertBatch(addList);
            }
            if(ppMapUpdate.size() > 0) {
                for(TProdPlan value : ppMapUpdate.values()) {
                    updateList.add(value);
                }
                res = tProdPlanMapper.updateBatch(updateList);
            }
            if(res > 0 && !prodPlanDetails.isEmpty()) {
                res = prodPlanDetailMapper.insertBatch(prodPlanDetails);
            }
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
    private TProdPlanDetail buildProdPlanDetail(String macCode, String prodPlanCode, OrderItemVo vo, Character character) {
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
        detail.setItemOwner(vo.getItemOwner());
        detail.setItemColor(vo.getItemColor());
        detail.setMacCode(macCode);
        detail.setItemPriceType(vo.getItemPriceType());
        detail.setItemRemarks(vo.getItemRemarks());
        return detail;
    }

    private String getMacCode(Map<String, String> map, Double width) {
        String macCode="";
        for(Map.Entry<String, String> entry : map.entrySet()){
            String[] keys = entry.getKey().split("-");
            if(Double.valueOf(keys[0]) <= width && Double.valueOf(keys[1]) >= width) {
                macCode = entry.getValue();
                break;
            }
        }
        return macCode;
    }


}
