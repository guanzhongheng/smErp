package com.lcyzh.nmerp.service.impl;

import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.constant.Constants;
import com.lcyzh.nmerp.dao.*;
import com.lcyzh.nmerp.entity.*;
import com.lcyzh.nmerp.model.vo.*;
import com.lcyzh.nmerp.service.TOrderService;
import com.lcyzh.nmerp.utils.DictUtils;
import com.lcyzh.nmerp.utils.StringUtils;
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
    private TProdplanExeMapper tProdplanExeMapper;
    @Autowired
    private PrimaryContactMapper primaryContactMapper;

    @Override
    public List<OrderItemVo> findByOrdCode(String ordCode) {
        return tOrderItemMapper.findByOrdCode(ordCode);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    @Override
    public int ordProduceAssign(List<OrderItemAssignVo> voList, String ordCode) {
        int res = -1;
        if (voList != null && !voList.isEmpty()) {
            Date current = new Date();
            List<TProdplanExe> prodplanExes = voList.stream().map(vo -> {
                TProdplanExe prodplanExe = new TProdplanExe();
                prodplanExe.setOrdItemId(vo.getOrdItemId());
                prodplanExe.setItemNum(vo.getItemNum());
                prodplanExe.setItemUnit(vo.getItemUnit());
                prodplanExe.setStatus('0');
                prodplanExe.setMacCode(vo.getMacCode());
                prodplanExe.setCreateTime(current);
                return prodplanExe;
            }).collect(Collectors.toList());
            res = tProdplanExeMapper.insertBatch(prodplanExes);
            if (res > 0) {
                TOrder tOrder = new TOrder();
                tOrder.setOrdCode(ordCode);
                tOrder.setOrdStatus(Constants.ORD_STATUS_ASSIGNED);
                tOrder.setUpdateTime(current);
                res = tOrderMapper.update(tOrder);
            }
        }
        return res;
    }

    @Override
    public Page<OrderQueryVo> findPage(Page<OrderQueryVo> page, OrderQueryVo order) {
        order.setPage(page);
        List<OrderQueryVo> list = tOrderMapper.findList(order);
        list.stream().forEach(vo-> vo.setOrdStatusValue(DictUtils.getDictValueMaps().get(vo.getOrdStatus())));
        page.setList(list);
        return page;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    @Override
    public int insert(OrderAddBatchVo vo) {
        //生成订单信息，及订单明细;如果合同号不存在，则生成新的合同，存在则关联合同号
        Date date = new Date();
        Customer cus = tCustomerMapper.findByCusName(vo.getCusName());
        if (cus == null) {
            cus = new Customer();
            cus.setCusName(vo.getCusName());
            cus.setCreateTime(date);
            cus.setCusAddress(vo.getOrdAddress());
            cus.setCusCode(StringUtils.genFixPreFixStr(Constants.CUS_PRE_FIX));
            PrimaryContact contact = new PrimaryContact();
            contact.setCusCode(cus.getCusCode());
            contact.setContactName(vo.getCusName());
            contact.setContactPhone(vo.getPhone());
            contact.setUpdateTime(date);
            primaryContactMapper.insert(contact);
        }
        TOrder tOrder = new TOrder();
        tOrder.setCusCode(cus.getCusCode());
        tOrder.setOrdDeliveryDate(vo.getDeliveryDate());
        tOrder.setProxyName(vo.getProxyName());
        tOrder.setOrdCode(StringUtils.genFixPreFixStr(Constants.ORD_PRE_FIX));
        //根据客户资料类型设置订单状态
        if (cus.getCusStatus().equals(Constants.CUS_STATUS_SPEC)) {
            tOrder.setOrdStatus(Constants.ORD_STATUS_TOASSIGN);
        } else {
            tOrder.setOrdStatus(Constants.ORD_STATUS_NEW);
        }
        tOrder.setCreateTime(date);
        List<OrderItemVo> itemVos = vo.getItemVos();
        if (itemVos != null && !itemVos.isEmpty()) {
            List<TOrderItem> orderItems = itemVos.stream().map(itv -> {
                TOrderItem tOrderItem = new TOrderItem();
                tOrderItem.setCreateTime(date);
                tOrderItem.setItemCode(tOrder.getOrdCode());
                tOrderItem.setItemCode(itv.getItemCode());
                tOrderItem.setItemColor(itv.getItemColor());
                tOrderItem.setItemLenth(itv.getItemLenth());
                tOrderItem.setItemNum(itv.getItemNum());
                tOrderItem.setItemOwner(itv.getItemOwner());
                tOrderItem.setItemThick(itv.getItemThick());
                tOrderItem.setItemUnit(itv.getItemUnit());
                tOrderItem.setItemWidth(itv.getItemWidth());
                tOrderItem.setRemark(itv.getRemark());
                return tOrderItem;

            }).collect(Collectors.toList());
            tOrderItemMapper.insertBatch(orderItems);
        }
        return tOrderMapper.insert(tOrder);
    }

    @Override
    public int insertBatch(List<OrderAddBatchVo> voList) {
        List<TOrder> orders = new ArrayList<>(voList.size());
        return tOrderMapper.insertBatch(orders);
    }

    @Override
    public int update(TOrder tOrder) {
        return tOrderMapper.update(tOrder);
    }

    @Override
    public int delete(TOrder tOrder) {
        return tOrderMapper.delete(tOrder);
    }

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
                if(cus!=null){
                    order.setOrdCode(StringUtils.genFixPreFixStr(Constants.ORD_PRE_FIX));
                    if(cus.getCusStatus().equals(Constants.CUS_STATUS_SPEC)){
                        order.setOrdStatus(Constants.ORD_STATUS_TOASSIGN);
                    }else if(cus.getCusStatus().equals(Constants.CUS_STATUS_BH)){
                        return  res;
                    }else {
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
        return tOrderMapper.findModifyInfoByOrdCode(ordCode);
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
        tOrder.setRemark(ordAddModifyVo.getRemark());
        tOrder.setCreateTime(current);
        tOrder.setUpdateTime(current);
        return tOrder;
    }

}
