package com.lcyzh.nmerp.service.impl;

import com.lcyzh.nmerp.constant.Constants;
import com.lcyzh.nmerp.dao.TContractMapper;
import com.lcyzh.nmerp.dao.TCustomerMapper;
import com.lcyzh.nmerp.dao.TOrderItemMapper;
import com.lcyzh.nmerp.dao.TOrderMapper;
import com.lcyzh.nmerp.entity.TContract;
import com.lcyzh.nmerp.entity.TCustomer;
import com.lcyzh.nmerp.entity.TOrder;
import com.lcyzh.nmerp.entity.TOrderItem;
import com.lcyzh.nmerp.model.vo.OrderItemVo;
import com.lcyzh.nmerp.model.vo.OrderVo;
import com.lcyzh.nmerp.service.TOrderService;
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
    private TContractMapper tContractMapper;
    @Autowired
    private TCustomerMapper tCustomerMapper;

    @Override
    public TOrder get(String id) {
        return tOrderMapper.get(id);
    }

    @Override
    public List<TOrder> findList(TOrder tOrder) {
        return tOrderMapper.findList(tOrder);
    }

    @Override
    public List<TOrder> findAllList() {
        return tOrderMapper.findAllList();
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    @Override
    public int insert(OrderVo vo) {
        //生成订单信息，及订单明细;如果合同号不存在，则生成新的合同，存在则关联合同号
        Date date = new Date();
        TOrder tOrder = new TOrder();
        String contCode = vo.getContCode();
        if (contCode == null) {
            contCode = StringUtils.genFixPreFixStr(Constants.CONT_PRE_FIX);
            TContract tContract = new TContract();
            tContract.setContCode(contCode);
            tContract.setContStatus(Constants.CONT_STATUS_NEW);
            tContract.setCreateTime(date);
            tContractMapper.insert(tContract);
        }
        tOrder.setContCode(contCode);
        TCustomer cus = tCustomerMapper.findByCusName(vo.getCusName());
        String cusCode;
        if (cus != null) {
            cusCode = cus.getCusCode();
        } else {
            TCustomer tCustomer = new TCustomer();
            tCustomer.setCusName(vo.getCusName());
            tCustomer.setCreateTime(date);
            tCustomer.setCusAddress(vo.getOrdAddress());
            cusCode = StringUtils.genFixPreFixStr(Constants.CUS_PRE_FIX);
            tOrder.setCusCode(cusCode);
            tCustomer.setCusCode(cusCode);
        }
        tOrder.setCusCode(cusCode);
        tOrder.setDeliveryDate(vo.getDeliveryDate());
        tOrder.setOrdAddress(vo.getOrdAddress());
        tOrder.setOrdCode(StringUtils.genFixPreFixStr(Constants.ORD_PRE_FIX));
        //根据客户资料类型设置订单状态
        if (cus.getStatus().equals(Constants.CUS_STATUS_SPEC)) {
            tOrder.setOrdStatus(Constants.ORD_STATUS_UN_ASSIGN);
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
    public int insertBatch(List<OrderVo> voList) {
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

}
