package com.lcyzh.nmerp.service.impl;

import com.github.pagehelper.PageHelper;
import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.constant.Constants;
import com.lcyzh.nmerp.dao.PrimaryContactMapper;
import com.lcyzh.nmerp.dao.TCustomerMapper;
import com.lcyzh.nmerp.dao.TOrderItemMapper;
import com.lcyzh.nmerp.dao.TOrderMapper;
import com.lcyzh.nmerp.entity.Customer;
import com.lcyzh.nmerp.entity.PrimaryContact;
import com.lcyzh.nmerp.entity.TOrder;
import com.lcyzh.nmerp.entity.TOrderItem;
import com.lcyzh.nmerp.entity.sys.Dict;
import com.lcyzh.nmerp.model.vo.OrderAddBatchVo;
import com.lcyzh.nmerp.model.vo.OrderAddModifyVo;
import com.lcyzh.nmerp.model.vo.OrderItemVo;
import com.lcyzh.nmerp.model.vo.OrderQueryVo;
import com.lcyzh.nmerp.service.TOrderService;
import com.lcyzh.nmerp.service.TProdPlanService;
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
    @Autowired
    private PrimaryContactMapper primaryContactMapper;

    @Override
    public List<OrderItemVo> findByOrdCode(String ordCode) {
        List<OrderItemVo> list = tOrderItemMapper.findByOrdCode(ordCode);
        list.stream().forEach(vo->{
            vo.setItemUnitValue(DictUtils.getDictValueMaps().get(vo.getItemUnit()));
            vo.setItemCgyCodeValue(DictUtils.getDictValueMaps().get(vo.getItemCgyCode()));
            vo.setItemPriceTypeValue(DictUtils.getDictValueMaps().get(vo.getItemPriceType()));
        });
        return list;
    }
    @Override
    public Page<OrderQueryVo> findPage(Page<OrderQueryVo> page, OrderQueryVo order) {
        PageHelper.startPage(page.getPageNo(),page.getPageSize());
        List<OrderQueryVo> list = tOrderMapper.findList(order);
        list.stream().forEach(vo->{
            vo.setOrdStatusValue(DictUtils.getDictValueMaps().get(vo.getOrdStatus()));
            vo.setPayTypeValue(DictUtils.getDictValueMaps().get(vo.getPayType()));
            vo.setPayStatusValue(DictUtils.getDictValueMaps().get(vo.getPayStatus()));
        });
        page.setList(list);
        return page;
    }

    //@Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    //@Override
    //public int insert(OrderAddBatchVo vo) {
    //    //生成订单信息，及订单明细;如果合同号不存在，则生成新的合同，存在则关联合同号
    //    Date date = new Date();
    //    Customer cus = tCustomerMapper.findByCusName(vo.getCusName());
    //    if (cus == null) {
    //        cus = new Customer();
    //        cus.setCusName(vo.getCusName());
    //        cus.setCreateTime(date);
    //        cus.setCusAddress(vo.getOrdAddress());
    //        cus.setCusCode(StringUtils.genFixPreFixStr(Constants.CUS_PRE_FIX));
    //        tCustomerMapper.insert(cus);
    //        PrimaryContact contact = new PrimaryContact();
    //        contact.setCusCode(cus.getCusCode());
    //        contact.setContactName(vo.getCusName());
    //        contact.setContactPhone(vo.getPhone());
    //        contact.setUpdateTime(date);
    //        primaryContactMapper.insert(contact);
    //    }
    //    String ordCode = StringUtils.genFixPreFixStr(Constants.ORD_PRE_FIX);
    //    TOrder tOrder = new TOrder();
    //    tOrder.setCusCode(cus.getCusCode());
    //    tOrder.setOrdDeliveryDate(vo.getDeliveryDate());
    //    tOrder.setProxyName(vo.getProxyName());
    //    tOrder.setOrdCode(ordCode);
    //    //根据客户资料类型设置订单状态
    //    if (cus.getCusStatus().equals(Constants.CUS_STATUS_SPEC)) {
    //        tOrder.setOrdStatus(Constants.ORD_STATUS_TOASSIGN);
    //        //生成产品计划
    //        prodPlanService.createProdPlan(ordCode,vo.getDeliveryDate(),vo.getItemVos());
    //    } else {
    //        tOrder.setOrdStatus(Constants.ORD_STATUS_NEW);
    //    }
    //    tOrder.setCreateTime(date);
    //    List<OrderItemVo> itemVos = vo.getItemVos();
    //    if (itemVos != null && !itemVos.isEmpty()) {
    //        List<TOrderItem> orderItems = itemVos.stream().map(itv -> {
    //            TOrderItem tOrderItem = buildOrderItemFromVo(itv, ordCode, date);
    //            return tOrderItem;
    //
    //        }).collect(Collectors.toList());
    //        tOrderItemMapper.insertBatch(orderItems);
    //    }
    //    return tOrderMapper.insert(tOrder);
    //}
    //
    ///**
    // * @Description: 订单实体转换
    // * @Param: [itv, ordCode, date]
    // * @return: com.lcyzh.nmerp.entity.TOrderItem
    // * @Author: lijinku
    // * @Iteration : 1.0
    // * @Date: 2019/7/4 10:36 PM
    // */
    //private TOrderItem buildOrderItemFromVo(OrderItemVo itv, String ordCode, Date date) {
    //    TOrderItem tOrderItem = new TOrderItem();
    //    tOrderItem.setCreateTime(date);
    //    tOrderItem.setItemCode(ordCode);
    //    tOrderItem.setItemCode(itv.getItemCode());
    //    tOrderItem.setItemColor(itv.getItemColor());
    //    tOrderItem.setItemLenth(itv.getItemLenth());
    //    tOrderItem.setItemNum(itv.getItemNum());
    //    tOrderItem.setItemOwner(itv.getItemOwner());
    //    tOrderItem.setItemThick(itv.getItemThick());
    //    tOrderItem.setItemUnit(itv.getItemUnit());
    //    tOrderItem.setItemWidth(itv.getItemWidth());
    //    tOrderItem.setRemark(itv.getRemark());
    //    return tOrderItem;
    //}
    //
    //@Override
    //public int insertBatch(List<OrderAddBatchVo> voList) {
    //    List<TOrder> orders = new ArrayList<>(voList.size());
    //    return tOrderMapper.insertBatch(orders);
    //}
    //
    //@Override
    //public int update(TOrder tOrder) {
    //    return tOrderMapper.update(tOrder);
    //}
    //
    //@Override
    //public int delete(TOrder tOrder) {
    //    return tOrderMapper.delete(tOrder);
    //}
    //
    @Override
    public int save(OrderAddModifyVo ordAddModifyVo) {
        int res = -1;
        if (ordAddModifyVo != null) {
            Date current = new Date();
            TOrder order = buildOrderPoFromVo(ordAddModifyVo, current);
            if (StringUtils.isNotEmpty(ordAddModifyVo.getOrdCode())) {
                res = tOrderMapper.update(order);
            } else {
                Customer cus = tCustomerMapper.findById(ordAddModifyVo.getCusCode());
                if (cus != null) {
                    order.setOrdCode(StringUtils.genFixPreFixStr(Constants.ORD_PRE_FIX));
                    if (cus.getCusStatus().equals(Constants.CUS_STATUS_SPEC)) {
                        order.setOrdStatus(Constants.ORD_STATUS_ASSIGNED);
                    } else if (cus.getCusStatus().equals(Constants.CUS_STATUS_BH)) {
                        return res;
                    } else {
                        order.setOrdStatus(Constants.ORD_STATUS_NEW);
                    }
                    res = tOrderMapper.insert(order);
                }
            }

        }

        return res;
    }

    @Override
    public OrderAddModifyVo findModifyInfoByOrdCode(String ordCode) {
        OrderAddModifyVo vo = tOrderMapper.findModifyInfoByOrdCode(ordCode);
        vo.setOrdTypeValue(DictUtils.getDictValueMaps().get(vo.getOrdType()));
        vo.setPayTypeValue(DictUtils.getDictValueMaps().get(vo.getPayType()));
        vo.setPayStatusValue(DictUtils.getDictValueMaps().get(vo.getPayStatus()));
        return vo;
    }

    @Override
    public int save(List<OrderItemVo> list) {
        Date date = new Date();
        List<TOrderItem> orderItems = list.stream().map(vo ->{
            TOrderItem orderItem = new TOrderItem();
            BeanUtils.copyProperties(vo, orderItem);
            orderItem.setCreateTime(date);
            return orderItem;
        }).collect(Collectors.toList());
        return tOrderItemMapper.insertBatch(orderItems);
    }

    //
    ///**
    // * @Description: 构建po
    // * @Param: [ordAddModifyVo, current]
    // * @return: void
    // * @Author: lijinku
    // * @Iteration : 1.0
    // * @Date: 2019/7/4 11:45 AM
    // */
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
