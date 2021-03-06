package com.lcyzh.nmerp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.constant.Constants;
import com.lcyzh.nmerp.controller.system.util.SysDictUtils;
import com.lcyzh.nmerp.controller.system.util.UserUtils;
import com.lcyzh.nmerp.dao.*;
import com.lcyzh.nmerp.entity.Customer;
import com.lcyzh.nmerp.entity.TOrder;
import com.lcyzh.nmerp.entity.TOrderItem;
import com.lcyzh.nmerp.entity.TProduct;
import com.lcyzh.nmerp.entity.sys.User;
import com.lcyzh.nmerp.model.vo.OrderAddBatchVo;
import com.lcyzh.nmerp.model.vo.OrderAddModifyVo;
import com.lcyzh.nmerp.model.vo.OrderItemVo;
import com.lcyzh.nmerp.model.vo.OrderQueryVo;
import com.lcyzh.nmerp.service.TOrderService;
import com.lcyzh.nmerp.service.TProdPlanService;
import com.lcyzh.nmerp.utils.Arith;
import com.lcyzh.nmerp.utils.DateUtils;
import com.lcyzh.nmerp.utils.DictUtils;
import com.lcyzh.nmerp.utils.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Author ljk
 * Date  2019-06-06
 */
@Service
public class TOrderServiceImpl implements TOrderService {
    @Autowired
    private TOrderMapper tOrderMapper;
    @Autowired
    private TOrderItemMapper tOrderItemMapper;
    @Autowired
    private TCustomerMapper tCustomerMapper;
    @Autowired
    private TProdPlanService prodPlanService;
    @Autowired
    private TProductMapper tProductMapper;
    @Autowired
    private TProdPlanDetailMapper tProdPlanDetailMapper;

    @Override
    public List<OrderItemVo> findItemsByOrdCode(String ordCode) {
        List<OrderItemVo> list = tOrderItemMapper.findByOrdCode(ordCode);
        list.stream().forEach(vo -> {
            vo.setItemUnitValue(DictUtils.getValueByDictKey(vo.getItemUnit()));
            vo.setItemCgyCodeValue(DictUtils.getValueByDictKey(vo.getItemCgyCode()));
            vo.setItemVaritemValue(DictUtils.getValueByDictKey(vo.getItemVariety()));
            if (vo.getItemPriceType().equals(Constants.PROD_PRICE_TYPE_WEIGHT)
                    || vo.getItemPriceType().equals(Constants.PROD_PRICE_TYPE_WEIGHT_JH)
                    || vo.getItemPriceType().equals(Constants.PROD_PRICE_TYPE_WEIGHT_JB)) {
                vo.setItemPriceTypeValue("按重量");
            } else {
                vo.setItemPriceTypeValue("按面积");
            }

            vo.setItemStatusValue(DictUtils.getValueByDictKey(vo.getItemStatus()));
            vo.setItemColorValue(SysDictUtils.getDictLabel(vo.getItemColor(), "prod_color", ""));
            Integer num = tProductMapper.checkOrderDetail(vo.getItemId());
            if(num > 0){
                vo.setIsShowPrice(1);
            }else{
                vo.setIsShowPrice(0);
            }
        });
        return list;
    }

    @Override
    public List<OrderItemVo> findItemsByOrdCodeForPrint(String ordCode) {
        List<OrderItemVo> list = tOrderItemMapper.findByOrdCodeForPrint(ordCode);
        list.stream().forEach(vo -> {
            vo.setItemUnitValue(DictUtils.getValueByDictKey(vo.getItemUnit()));
            vo.setItemCgyCodeValue(DictUtils.getValueByDictKey(vo.getItemCgyCode()));
            vo.setItemVaritemValue(DictUtils.getValueByDictKey(vo.getItemVariety()));
            if (vo.getItemPriceType().equals(Constants.PROD_PRICE_TYPE_WEIGHT)
                    || vo.getItemPriceType().equals(Constants.PROD_PRICE_TYPE_WEIGHT_JH)
                    || vo.getItemPriceType().equals(Constants.PROD_PRICE_TYPE_WEIGHT_JB)) {
                vo.setItemPriceTypeValue("按重量");
            } else {
                vo.setItemPriceTypeValue("按面积");
            }

            vo.setItemStatusValue(DictUtils.getValueByDictKey(vo.getItemStatus()));
            vo.setItemColorValue(SysDictUtils.getDictLabel(vo.getItemColor(), "prod_color", ""));
            Integer num = tProductMapper.checkOrderDetail(vo.getItemId());
            if(num > 0){
                vo.setIsShowPrice(1);
            }else{
                vo.setIsShowPrice(0);
            }
        });
        return list;
    }

    @Override
    public List<OrderQueryVo> findPage(Page<OrderQueryVo> page, OrderQueryVo order) {
        PageHelper.startPage(page.getPageNo(), page.getPageSize());
        List<OrderQueryVo> list = tOrderMapper.findList(order);
        list.stream().forEach(vo -> {
            vo.setOrdStatusValue(DictUtils.getValueByDictKey(vo.getOrdStatus()));
            vo.setPayTypeValue(DictUtils.getValueByDictKey(vo.getPayType()));
            vo.setPayStatusValue(DictUtils.getValueByDictKey(vo.getPayStatus()));
            Map<String, Object> res = tOrderItemMapper.getOrderStockInfo(vo.getOrdCode());
            if (res != null && res.size() > 0) {
                if (res.get("totalNum") != null) {
                    vo.setTotalNum((Long) res.get("totalNum"));
                }
                if (res.get("totalPrice") != null) {
                    vo.setTotalPrice((Double) res.get("totalPrice"));
                }
                if (res.get("totalwight") != null) {
                    vo.setOrdTotalWeight((Double) res.get("totalwight"));
                }
                if (res.get("totalSq") != null) {
                    vo.setOrdTotalSq((Double) res.get("totalSq"));
                }
                if (res.get("totalWtPrice") != null) {
                    vo.setTotalWtPrice((Double) res.get("totalWtPrice"));
                }
                if (res.get("totalSqPrice") != null) {
                    vo.setTotalSqPrice((Double) res.get("totalSqPrice"));
                }
            }
            Map<String, Object> tp = tOrderItemMapper.getOrderItemInfo(vo.getOrdCode());
            if (tp != null && tp.size() > 0) {
                if (tp.get("price") != null) {
                    Double showPrice = Arith.add((Double) tp.get("price"), vo.getTotalWtPrice());
                    vo.setOrderPrice(Arith.round(showPrice, 4));
                }
            }
        });
        PageInfo<OrderQueryVo> pageInfo = new PageInfo<>(list);
        page.setTotal(pageInfo.getTotal());
        return list;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    @Override
    public int insert(OrderAddBatchVo vo) {
        //生成订单信息，及订单明细;如果合同号不存在，则生成新的合同，存在则关联合同号
        Date date = new Date();
        TOrder tOrder = new TOrder();
        User sysUser = UserUtils.getUser();
        tOrder.setCreateBy(sysUser.getId());
        tOrder.setUpdateBy(sysUser.getId());
        Customer cus = tCustomerMapper.findByCusName(vo.getCusName());
        String cusCode;
        if (cus != null) {
            cusCode = cus.getCusCode();
        } else {
            Customer tCustomer = new Customer();
            tCustomer.setCusName(vo.getCusName());
            tCustomer.setCusGrade(Constants.CUS_GRADE_ONE);
            tCustomer.setCreateTime(date);
            tCustomer.setCusAddress(vo.getOrdAddress());
            tCustomer.setCusStatus(Constants.CUS_STATUS_NEW);
            cusCode = StringUtils.genFixPreFixStr(Constants.CUS_PRE_FIX);
            tCustomer.setCusCode(cusCode);
            tCustomerMapper.insert(tCustomer);
        }
        tOrder.setCusCode(cusCode);
        if(StringUtils.isEmpty(vo.getOrdTitle())){
            tOrder.setOrdTitle(vo.getCusName() + "订单");
        }else{
            tOrder.setOrdTitle(vo.getOrdTitle());
        }
        tOrder.setOrdType(Constants.PAY_TYPE_EFT);
        tOrder.setOrdDeliveryDate(vo.getDeliveryDate());
        tOrder.setProxyName(vo.getProxyName());
        tOrder.setOrdSignDate(DateUtils.formatDate(date));
        tOrder.setOrdCode(StringUtils.genFixPreFixStr(Constants.ORD_PRE_FIX));
        //根据客户资料类型设置订单状态
//        if(cus.getCusGrade().equals(Constants.CUS_GRADE_FIVE)){
//            tOrder.setOrdStatus(Constants.ORD_STATUS_ASSIGNED);
//        }else{
        tOrder.setOrdStatus(Constants.ORD_STATUS_NEW);
//        }
        tOrder.setCreateTime(date);
        List<OrderItemVo> itemVos = vo.getItemVos();
        if (itemVos != null && !itemVos.isEmpty()) {
            double totalAmount = 0.0;
            double totalSq = 0.0;
            double totalWeight = 0.0;
            long totalNum = 0;
            int line = 0;
            List<TOrderItem> orderItems = new ArrayList<>(itemVos.size());
            for (OrderItemVo itv : itemVos) {
                line++;
                TOrderItem tOrderItem = new TOrderItem();
                tOrderItem.setCreateTime(date);
                String prodCgy = StringUtils.parseDictKey(itv.getItemCgyCodeValue()).toString();
                String prodVerity = StringUtils.parseDictKey(itv.getItemVaritemValue()).toString();
                String prodColor = StringUtils.parseColorDictKey(itv.getItemColorValue());
                String thick = String.valueOf(itv.getItemThick());
                String priceType = StringUtils.parseDictKey(itv.getItemPriceTypeValue()).toString();


                tOrderItem.setOrdCode(tOrder.getOrdCode());
                TProduct product = DictUtils.getProdCodeByProdCgyAndVari(prodCgy + prodVerity + prodColor + thick + priceType);
                if (product != null) {
                    tOrderItem.setItemCode(product.getProdCode());
                    tOrderItem.setItemUnit(product.getProdUnit());
                    tOrderItem.setItemPrice(product.getProdGuidePrice());
                    tOrderItem.setItemPriceType(product.getProdPriceType());
                    tOrderItem.setItemColor(prodColor);

                } else {
                    throw new RuntimeException("第" + line + "行，产品【产品类别：" + itv.getItemCgyCodeValue()
                            + ",产品品种:" + itv.getItemVaritemValue()
                            + ",产品颜色:" + itv.getItemColorValue()
                            + ",产品厚度:" + itv.getItemThick()
                            + ",产品计价方式:" + itv.getItemPriceTypeValue()
                            + "】不存在！");
                }
                tOrderItem.setItemLenth(itv.getItemLenth());
                if (tOrderItem.getItemPriceType() != null) {
                    if (tOrderItem.getItemPriceType().equals(Constants.PROD_PRICE_TYPE_WEIGHT)
                            || tOrderItem.getItemPriceType().equals(Constants.PROD_PRICE_TYPE_WEIGHT_JH)
                            || tOrderItem.getItemPriceType().equals(Constants.PROD_PRICE_TYPE_WEIGHT_JB)) {
                        if (itv.getItemWeight() != null || "".equals(itv.getItemWeight())) {
                            tOrderItem.setItemWeight(itv.getItemWeight());
                            tOrderItem.setItemTotalWeight(itv.getItemWeight() * itv.getItemNum());
                            if (product != null) {
                                totalAmount += product.getProdGuidePrice() * tOrderItem.getItemTotalWeight();
                            }
                        }else{
                            tOrderItem.setItemWeight(0d);
                            tOrderItem.setItemTotalWeight(0d);
                        }
                    } else {
                        if (itv.getItemLenth() != null && itv.getItemWidth() != null) {
                            tOrderItem.setItemTotalSq(itv.getItemLenth() * itv.getItemWidth());
                            if (product != null) {
                                totalAmount += product.getProdGuidePrice() * tOrderItem.getItemTotalSq();
                            }
                        }
                    }
                }
                tOrderItem.setItemNum(itv.getItemNum());
                tOrderItem.setItemOwner(itv.getItemOwner());
                tOrderItem.setItemThick(itv.getItemThick());
                tOrderItem.setItemUnit(StringUtils.parseDictKey(itv.getItemUnitValue()));
                tOrderItem.setItemWidth(itv.getItemWidth());
                tOrderItem.setItemYbType(StringUtils.parseDictKey(itv.getItemYbType()).toString());
                tOrderItem.setItemStatus(Constants.ORD_PROD_STATUS_NEW);
                tOrderItem.setItemRemarks(itv.getItemRemarks());
                tOrderItem.setItemOutNum(0L);
                orderItems.add(tOrderItem);
                if (tOrderItem.getItemTotalSq() != null && tOrderItem.getItemTotalSq() > 0d) {
                    totalSq += tOrderItem.getItemTotalSq();
                }
                if (tOrderItem.getItemTotalWeight() != null && tOrderItem.getItemTotalWeight() > 0d) {
                    totalWeight += tOrderItem.getItemTotalWeight();
                }
                if (tOrderItem.getItemNum() != null && tOrderItem.getItemNum() > 0d) {
                    totalNum += tOrderItem.getItemNum();
                }
            }
            tOrder.setOrdTotalNum(totalNum);
            tOrder.setOrdTotalSq(totalSq);
            tOrder.setOrdTotalWeight(totalWeight);
            tOrder.setOrdOutNum(0L);
            tOrder.setOrdTotalAmount(totalAmount);
            tOrderItemMapper.insertBatch(orderItems);
        }
        return tOrderMapper.insert(tOrder);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    @Override
    public int save(OrderAddModifyVo ordAddModifyVo) {
        int res = -1;
        if (ordAddModifyVo != null) {
            User sysUser = UserUtils.getUser();
            String ordCode = StringUtils.genFixPreFixStr(Constants.ORD_PRE_FIX);
            Date current = new Date();
            TOrder order = buildOrderPoFromVo(ordAddModifyVo, current);
            if (StringUtils.isNotEmpty(ordAddModifyVo.getOrdCode())) {
                order.setUpdateBy(sysUser.getId());
                res = tOrderMapper.update(order);
            } else {
                order.setOrdCode(ordCode);
                //初始化数据
                order.setOrdStatus(Constants.ORD_STATUS_NEW);
                order.setOrdTotalWeight(0d);
                order.setOrdTotalSq(0d);
                order.setOrdTotalNum(0L);
                order.setOrdOutNum(0L);
                order.setCreateBy(sysUser.getId());
                order.setUpdateBy(sysUser.getId());
                res = tOrderMapper.insert(order);
            }
            if (res > 0) {
                ordAddModifyVo.setOrdCode(ordCode);
            }
        }

        return res;
    }

    @Override
    public OrderAddModifyVo findModifyInfoByOrdCode(String ordCode) {
        OrderAddModifyVo vo = tOrderMapper.findModifyInfoByOrdCode(ordCode);
        if (vo != null) {
            vo.setOrdTypeValue(DictUtils.getValueByDictKey(vo.getOrdType()));
            vo.setPayTypeValue(DictUtils.getValueByDictKey(vo.getPayType()));
            vo.setPayStatusValue(DictUtils.getValueByDictKey(vo.getPayStatus()));
        }
        return vo;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    @Override
    public int save(List<OrderItemVo> list) {
        User sysUser = UserUtils.getUser();
        String ordCode = list.get(0).getOrdCode();
        Date date = new Date();
        TOrder order = new TOrder();
        order.setOrdCode(ordCode);
        Double amount = 0d;
        Double totalSq = 0d;
        Double totalWeight = 0d;
        Long totalNum = 0L;
        List<TOrderItem> orderItems = new ArrayList<>();
        for (OrderItemVo vo : list) {
            TOrderItem orderItem = new TOrderItem();
            BeanUtils.copyProperties(vo, orderItem);
            orderItem.setCreateTime(date);
            orderItem.setItemStatus(Constants.ORD_PROD_STATUS_NEW);
            orderItem.setItemOutNum(0L);
            orderItems.add(orderItem);
            if(vo.getItemTotalWeight() == null){
                vo.setItemTotalWeight(0d);
            }
            if (vo.getItemPriceType().equals(Constants.PROD_PRICE_TYPE_SQ)
                    || vo.getItemPriceType().equals(Constants.PROD_PRICE_TYPE_SQ_JH)
                    || vo.getItemPriceType().equals(Constants.PROD_PRICE_TYPE_SQ_JB)) {
                amount += vo.getItemPrice() * vo.getItemTotalSq();
                totalSq += orderItem.getItemTotalSq();
            } else if (vo.getItemPriceType().equals(Constants.PROD_PRICE_TYPE_WEIGHT)
                    || vo.getItemPriceType().equals(Constants.PROD_PRICE_TYPE_WEIGHT_JH)
                    || vo.getItemPriceType().equals(Constants.PROD_PRICE_TYPE_WEIGHT_JB)) {
                amount += vo.getItemPrice() * vo.getItemTotalWeight();
                totalWeight += orderItem.getItemTotalWeight();
            }
            totalNum += orderItem.getItemNum();
        }
        order.setOrdTotalNum(totalNum);
        order.setOrdTotalSq(totalSq);
        order.setOrdTotalWeight(totalWeight);
        order.setOrdTotalAmount(amount);
        order.setUpdateTime(date);
        order.setUpdateBy(sysUser.getId());
        tOrderItemMapper.deleteByOrdCode(ordCode);
        tOrderItemMapper.insertBatch(orderItems);
        return tOrderMapper.update(order);
    }

    @Override
    public int updatePrice(List<OrderItemVo> list) {
        User sysUser = UserUtils.getUser();
        String ordCode = list.get(0).getOrdCode();
        Date date = new Date();
        TOrder order = new TOrder();
        order.setOrdCode(ordCode);
        Double amount = 0d;
        List<TOrderItem> orderItems = new ArrayList<>();
        TOrderItem orderItem;
        for (OrderItemVo vo : list) {
            orderItem = new TOrderItem();
            orderItem.setId(vo.getItemId());
            orderItem.setItemPrice(vo.getItemPrice());
            orderItems.add(orderItem);

            if (vo.getItemPriceType().equals(Constants.PROD_PRICE_TYPE_SQ)
                    || vo.getItemPriceType().equals(Constants.PROD_PRICE_TYPE_SQ_JH)
                    || vo.getItemPriceType().equals(Constants.PROD_PRICE_TYPE_SQ_JB)) {
                amount += vo.getItemPrice() * vo.getItemTotalSq();
            } else if (vo.getItemPriceType().equals(Constants.PROD_PRICE_TYPE_WEIGHT)
                    || vo.getItemPriceType().equals(Constants.PROD_PRICE_TYPE_WEIGHT_JH)
                    || vo.getItemPriceType().equals(Constants.PROD_PRICE_TYPE_WEIGHT_JB)) {
                amount += vo.getItemPrice() * vo.getItemTotalWeight();
            }
        }
        order.setOrdTotalAmount(amount);
        order.setUpdateTime(date);
        order.setUpdateBy(sysUser.getId());
        tOrderItemMapper.updateBatch(orderItems);
        return tOrderMapper.update(order);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    @Override
    public int orderAssign(String ordCode, int state) {
        User sysUser = UserUtils.getUser();
        TOrder order = new TOrder();
        order.setOrdCode(ordCode);
        order.setApprovalBy(sysUser.getId());
        if (state == 0) {
            order.setOrdStatus(Constants.ORD_STATUS_ASSIGNED);
        } else if (state == 1) {
            order.setOrdStatus(Constants.ORD_STATUS_ABORT);
        }
        if (tOrderMapper.updateOrderStatus(order) > 0 && updateProdStatusByOrdCode(ordCode, Constants.ORD_PROD_STATUS_WAIT) > 0) {
            if (state == 0) {
                //审批通过，加入生产计划
                List<OrderItemVo> list = tOrderItemMapper.findByOrdCode(ordCode);
                int re = prodPlanService.createProdPlan(list);
                if (re <= 0) {
                    // 处理失败抛出异常 保证审核状态的回滚
                    throw new NullPointerException();
                }
                return 1;
            }
            return 1;
        } else {
            return -1;
        }
    }

    public int updateProdStatusByOrdCode(String ordCode, Long status) {
        Map<String, Object> map = new HashMap<>();
        map.put("ordCode", ordCode);
        map.put("status", status);
        return tOrderItemMapper.updateProdStatusByOrdCode(map);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    @Override
    public int detele(String ordCode) {
        int res = -1;
        // 判定是否可以删除 可删除逻辑1、订单下发产品，或者已经存在入库产品的则不给予删除
        if(tOrderMapper.checkOrderItemPaln(ordCode) > 0 || tOrderMapper.checkOrderItemInfo(ordCode) > 0){
            //不给予删除
            res = -2;
        }else{
            res = tOrderMapper.delete(ordCode);
            if (res > 0) {
                tOrderItemMapper.deleteByOrdCode(ordCode);
            }
            // 同步减少待生产信息
            if(tProdPlanDetailMapper.updateNumForDelete(ordCode) > 0) {
                tProdPlanDetailMapper.deleteForOrdCode(ordCode);
            }
        }
        return res;
    }

    @Override
    public OrderQueryVo findByOrdeCode(String ordCode) {
        return tOrderMapper.findByPrimaryKey(ordCode);
    }

    /**
     * @Description: 构建po
     * @Param: [ordAddModifyVo, current]
     * @return: void
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/4 11:45 AM
     */
    private TOrder buildOrderPoFromVo(OrderAddModifyVo ordAddModifyVo, Date current) {
        TOrder tOrder = new TOrder();
        tOrder.setOrdCode(ordAddModifyVo.getOrdCode());
        tOrder.setProxyName(ordAddModifyVo.getProxyName());
        tOrder.setCusCode(ordAddModifyVo.getCusCode());
        tOrder.setOrdDeliveryDate(ordAddModifyVo.getOrdDeliveryDate());
        tOrder.setComContractor(ordAddModifyVo.getComContractor());
        tOrder.setCusContractor(ordAddModifyVo.getCusContractor());
        tOrder.setOrdSignDate(ordAddModifyVo.getOrdSignDate());
        tOrder.setOrdStatus(ordAddModifyVo.getOrdStatus());
        tOrder.setOrdTitle(ordAddModifyVo.getOrdTitle());
        tOrder.setOrdType(ordAddModifyVo.getOrdType());
        tOrder.setRemarks(ordAddModifyVo.getRemarks());
        tOrder.setCreateTime(current);
        tOrder.setUpdateTime(current);
        return tOrder;
    }

}
