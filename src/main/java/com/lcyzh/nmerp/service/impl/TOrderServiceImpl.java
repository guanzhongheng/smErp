package com.lcyzh.nmerp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.constant.Constants;
import com.lcyzh.nmerp.controller.system.util.SysDictUtils;
import com.lcyzh.nmerp.dao.PrimaryContactMapper;
import com.lcyzh.nmerp.dao.TCustomerMapper;
import com.lcyzh.nmerp.dao.TOrderItemMapper;
import com.lcyzh.nmerp.dao.TOrderMapper;
import com.lcyzh.nmerp.entity.*;
import com.lcyzh.nmerp.entity.sys.Dict;
import com.lcyzh.nmerp.model.vo.OrderAddBatchVo;
import com.lcyzh.nmerp.model.vo.OrderAddModifyVo;
import com.lcyzh.nmerp.model.vo.OrderItemVo;
import com.lcyzh.nmerp.model.vo.OrderQueryVo;
import com.lcyzh.nmerp.service.TOrderService;
import com.lcyzh.nmerp.service.TProdPlanService;
import com.lcyzh.nmerp.utils.DateUtils;
import com.lcyzh.nmerp.utils.DictUtils;
import com.lcyzh.nmerp.utils.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<OrderItemVo> findByOrdCode(String ordCode) {
        List<OrderItemVo> list = tOrderItemMapper.findByOrdCode(ordCode);
        list.stream().forEach(vo -> {
            vo.setItemUnitValue(DictUtils.getDictValueMaps().get(vo.getItemUnit()));
            vo.setItemCgyCodeValue(DictUtils.getDictValueMaps().get(vo.getItemCgyCode()));
            vo.setItemVaritemValue(DictUtils.getDictValueMaps().get(vo.getItemVariety()));
            vo.setItemPriceTypeValue(DictUtils.getDictValueMaps().get(vo.getItemPriceType()));
            vo.setItemColorValue(SysDictUtils.getDictLabel(vo.getItemColor(), "prod_color", ""));
        });
        return list;
    }

    @Override
    public List<OrderQueryVo> findPage(Page<OrderQueryVo> page, OrderQueryVo order) {
        PageHelper.startPage(page.getPageNo(), page.getPageSize());
        List<OrderQueryVo> list = tOrderMapper.findList(order);
        list.stream().forEach(vo -> {
            vo.setOrdStatusValue(DictUtils.getDictValueMaps().get(vo.getOrdStatus()));
            vo.setPayTypeValue(DictUtils.getDictValueMaps().get(vo.getPayType()));
            vo.setPayStatusValue(DictUtils.getDictValueMaps().get(vo.getPayStatus()));
        });
//        page.setCount(list.size());
//        page.setList(list);
        return list;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    @Override
    public int insert(OrderAddBatchVo vo) {
        //生成订单信息，及订单明细;如果合同号不存在，则生成新的合同，存在则关联合同号
        Date date = new Date();
        TOrder tOrder = new TOrder();

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
            cusCode = StringUtils.genFixPreFixStr(Constants.CUS_PRE_FIX);
            tCustomer.setCusCode(cusCode);
            tCustomerMapper.insert(tCustomer);
        }
        tOrder.setCusCode(cusCode);
        tOrder.setOrdTitle("新建");
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
            List<TOrderItem> orderItems = new ArrayList<>(itemVos.size());
            for (OrderItemVo itv : itemVos) {
                TOrderItem tOrderItem = new TOrderItem();
                tOrderItem.setCreateTime(date);
                String prodCgy = StringUtils.parseDictKey(itv.getItemCgyCodeValue()).toString();
                String prodVerity = StringUtils.parseDictKey(itv.getItemVaritemValue()).toString();
                tOrderItem.setOrdCode(tOrder.getOrdCode());
                TProduct product = DictUtils.getProdCodeByProdCgyAndVari(prodCgy + prodVerity);
                if (product != null) {
                    tOrderItem.setItemCode(product.getProdCode());
                    tOrderItem.setItemUnit(product.getProdUnit());
                    tOrderItem.setItemPrice(product.getProdGuidePrice());
                    tOrderItem.setItemPriceType(product.getProdPriceType());
                }
                tOrderItem.setItemColor(StringUtils.parseColorDictKey(itv.getItemColor()));
                tOrderItem.setItemLenth(itv.getItemLenth());
                if (tOrderItem.getItemPriceType() != null) {
                    if (tOrderItem.getItemPriceType().equals(Constants.PROD_PRICE_TYPE_WEIGHT)) {
                        if (itv.getItemWeight() != null) {
                            tOrderItem.setItemWeight(itv.getItemWeight());
                            tOrderItem.setItemTotalWeight(itv.getItemWeight() * itv.getItemNum());
                            if (product != null) {
                                totalAmount += product.getProdGuidePrice() * tOrderItem.getItemTotalWeight();
                            }

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
                orderItems.add(tOrderItem);

            }
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
            String ordCode = StringUtils.genFixPreFixStr(Constants.ORD_PRE_FIX);
            Date current = new Date();
            TOrder order = buildOrderPoFromVo(ordAddModifyVo, current);
            if (StringUtils.isNotEmpty(ordAddModifyVo.getOrdCode())) {
                res = tOrderMapper.update(order);
            } else {
                order.setOrdCode(ordCode);
                order.setOrdStatus(Constants.ORD_STATUS_NEW);
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
            vo.setOrdTypeValue(DictUtils.getDictValueMaps().get(vo.getOrdType()));
            vo.setPayTypeValue(DictUtils.getDictValueMaps().get(vo.getPayType()));
            vo.setPayStatusValue(DictUtils.getDictValueMaps().get(vo.getPayStatus()));
        }
        return vo;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    @Override
    public int save(List<OrderItemVo> list) {
        String ordCode = list.get(0).getOrdCode();
        Date date = new Date();
        TOrder order = new TOrder();
        order.setOrdCode(ordCode);
        Double amount = 0d;
        List<TOrderItem> orderItems = new ArrayList<>();
        for (OrderItemVo vo : list) {
            TOrderItem orderItem = new TOrderItem();
            BeanUtils.copyProperties(vo, orderItem);
            orderItem.setCreateTime(date);
            orderItems.add(orderItem);
            if (vo.getItemPriceType().equals(Constants.PROD_PRICE_TYPE_SQ)) {
                amount += vo.getItemPrice() * vo.getItemTotalSq();
            } else if (vo.getItemPriceType().equals(Constants.PROD_PRICE_TYPE_WEIGHT)) {
                amount += vo.getItemPrice() * vo.getItemTotalWeight();
            }
        }
        order.setOrdTotalAmount(amount);
        order.setUpdateTime(date);
        tOrderItemMapper.deleteByOrdCode(ordCode);
        tOrderItemMapper.insertBatch(orderItems);
        return tOrderMapper.update(order);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    @Override
    public int orderAssign(String ordCode, int state) {
        TOrder order = new TOrder();
        order.setOrdCode(ordCode);
        if (state == 0) {
            order.setOrdStatus(Constants.ORD_STATUS_ASSIGNED);
        } else if (state == 1) {
            order.setOrdStatus(Constants.ORD_STATUS_ABORT);
        }
        if (tOrderMapper.update(order) > 0) {
            if (state == 0) {
                //审批通过，加入生产计划
                List<OrderItemVo> list = tOrderItemMapper.findByOrdCode(ordCode);
                return prodPlanService.createProdPlan(list);
            }
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public int detele(String ordCode) {
        int res = -1;
        res = tOrderMapper.delete(ordCode);
        if (res > 0) {
            tOrderItemMapper.deleteByOrdCode(ordCode);
        }
        return res;
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
