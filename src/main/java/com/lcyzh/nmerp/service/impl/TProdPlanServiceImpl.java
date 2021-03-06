package com.lcyzh.nmerp.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.constant.Constants;
import com.lcyzh.nmerp.controller.system.util.UserUtils;
import com.lcyzh.nmerp.dao.TFormulaMapper;
import com.lcyzh.nmerp.dao.TMachineInfoMapper;
import com.lcyzh.nmerp.dao.TProdPlanDetailMapper;
import com.lcyzh.nmerp.dao.TProdPlanMapper;
import com.lcyzh.nmerp.entity.TMachineInfo;
import com.lcyzh.nmerp.entity.TProdPlan;
import com.lcyzh.nmerp.entity.TProdPlanDetail;
import com.lcyzh.nmerp.entity.sys.User;
import com.lcyzh.nmerp.model.vo.FormulaDetailVo;
import com.lcyzh.nmerp.model.vo.OrderItemVo;
import com.lcyzh.nmerp.model.vo.ProdPlanVo;
import com.lcyzh.nmerp.service.TProdPlanService;
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

    @Override
    public ProdPlanVo findByProdPanCodes(String prodPlanCodes) {
        String[] codes = prodPlanCodes.split(",");
        List<String> list = Arrays.asList(codes);
        return  tProdPlanMapper.findProdPanByCodes(list);
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
        List<ProdPlanVo> list = tProdPlanMapper.findPlanList(vo);
        PageInfo<ProdPlanVo> pageInfo = new PageInfo<>(list);
        page.setTotal(pageInfo.getTotal());
        return list;
    }

    /**
     * 增加配方信息存入 订单信息
     * @param prodPlan
     * @return
     */
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public int update(TProdPlan prodPlan) {
        // 更新配方信息到对应订单下产品
        User sysUser = UserUtils.getUser();
        String[] details = prodPlan.getPlanDetailIds().split(",");
        if(details != null && details.length > 0){
            List<String> list = Arrays.asList(details);
            int re = tFormulaMapper.updateByDetails(list,prodPlan.getFormula(),sysUser.getId());
            if(re <= 0){
                throw new RuntimeException("订单配方信息更新失败!");
            }
            return 1;
        }else{
            return -1;
        }
    }


    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    @Override
    public int createProdPlan(List<OrderItemVo> items) {
        if(ybType != null && ybType.length() > 0){
            String[] ybs = ybType.split(",");
            int ret = 1;
            for(String yb : ybs){
                List<OrderItemVo> items4Yb = items.stream().filter(item -> yb.equals(item.getItemYbType())).collect(Collectors.toList());
                items.removeAll(items4Yb);
                if(items4Yb != null && !items4Yb.isEmpty()){
                    int r = createProdPlan(items4Yb, false);
                    if(r <= 0){
                        ret = -1;
                        break;
                    }
                }
            }
            if(ret > 0 && items.size() > 0){
                items.forEach(n->n.setItemYbType("0"));
                ret =  createProdPlan(items, true);
            }
            if(ret <= 0){
                throw new NullPointerException();
            }
            return 1;
        }else{
            items.forEach(n->n.setItemYbType("0"));
            return createProdPlan(items, true);
        }

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
                    ppMap.put(prodPlan.getProdCgyCode()+"|"+prodPlan.getProdVariety()+"|"+prodPlan.getProdColor()+"|"+prodPlan.getMacCode()+"|"+prodPlan.getProdYbType(),
                            prodPlan);
                }
            }
            Map<String, TProdPlan> ppMapNew = new HashMap<>(16);
            Map<String, TProdPlan> ppMapUpdate = new HashMap<>(16);
            String key;
            String macCode;
            for(OrderItemVo item : items) {
                macCode = getMacCode(macMap,item.getItemWidth());
                if(flag) {
                    key = item.getItemCgyCode()+"|"+item.getItemVariety()+"|"+item.getItemColor()+"|"+macCode+"|0";
                }else{
                    key = item.getItemCgyCode()+"|"+item.getItemVariety()+"|"+item.getItemColor()+"|"+macCode+"|"+item.getItemYbType();
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
                            prodPlan.setProdYbType("0");
                            prodPlan.setIsYb("0");
                            ppMapNew.put(prodPlan.getProdCgyCode()+"|"+prodPlan.getProdVariety()+"|"+prodPlan.getProdColor()+"|"+prodPlan.getMacCode()+"|0",
                                    prodPlan);
                        }else{
                            prodPlan.setProdYbType(item.getItemYbType());
                            prodPlan.setIsYb("1");
                            ppMapNew.put(prodPlan.getProdCgyCode()+"|"+prodPlan.getProdVariety()+"|"+prodPlan.getProdColor()+"|"+prodPlan.getMacCode()+"|"+prodPlan.getProdYbType(),
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
