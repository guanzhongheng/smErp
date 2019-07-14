package com.lcyzh.nmerp.service.impl;

import com.github.pagehelper.PageHelper;
import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.constant.Constants;
import com.lcyzh.nmerp.controller.system.util.SysDictUtils;
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
import java.util.function.ObjDoubleConsumer;
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
    private TProdPlanService prodPlanService;

    @Override
    public List<OrderItemVo> findByOrdCode(String ordCode) {
        List<OrderItemVo> list = tOrderItemMapper.findByOrdCode(ordCode);
        list.stream().forEach(vo->{
            vo.setItemUnitValue(DictUtils.getDictValueMaps().get(vo.getItemUnit()));
            vo.setItemCgyCodeValue(DictUtils.getDictValueMaps().get(vo.getItemCgyCode()));
            vo.setItemVaritemValue(DictUtils.getDictValueMaps().get(vo.getItemVariety()));
            vo.setItemPriceTypeValue(DictUtils.getDictValueMaps().get(vo.getItemPriceType()));
            vo.setItemColorValue(SysDictUtils.getDictLabel(vo.getItemColor(),"prod_color",""));
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
                res = tOrderMapper.insert(order);
            }
            if(res > 0) {
                ordAddModifyVo.setOrdCode(ordCode);
            }
        }

        return res;
    }

    @Override
    public OrderAddModifyVo findModifyInfoByOrdCode(String ordCode) {
        OrderAddModifyVo vo = tOrderMapper.findModifyInfoByOrdCode(ordCode);
        if(vo != null){
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
        for(OrderItemVo vo : list) {
            TOrderItem orderItem = new TOrderItem();
            BeanUtils.copyProperties(vo, orderItem);
            orderItem.setCreateTime(date);
            orderItems.add(orderItem);
            if(vo.getItemPriceType().equals(Constants.PROD_PRICE_TYPE_SQ)) {
                amount += vo.getItemPrice() * vo.getItemTotalSq();
            }else if(vo.getItemPriceType().equals(Constants.PROD_PRICE_TYPE_WEIGHT)) {
                amount += vo.getItemPrice() * vo.getItemTotalWeight();
            }
        }
        order.setOrdTotalAmount(amount);
        order.setUpdateTime(date);
        tOrderItemMapper.deleteByOrdCode(ordCode);
        tOrderItemMapper.insertBatch(orderItems);
        return tOrderMapper.update(order);
    }

    @Override
    public int orderAssign(String ordCode, int state) {
        TOrder order = new TOrder();
        order.setOrdCode(ordCode);
        if(state == 0) {
            order.setOrdStatus(Constants.ORD_STATUS_ASSIGNED);
        }else if(state == 1) {
            order.setOrdStatus(Constants.ORD_STATUS_ABORT);
        }
        if(tOrderMapper.update(order) > 0){
            if(state == 0) {
                //审批通过，加入生产计划
                List<OrderItemVo> list = tOrderItemMapper.findByOrdCode(ordCode);
                return prodPlanService.createProdPlan(list);
            }
            return 1;
        }else{
            return -1;
        }
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
