package com.lcyzh.nmerp.service.impl;

import com.lcyzh.nmerp.constant.Constants;
import com.lcyzh.nmerp.dao.*;
import com.lcyzh.nmerp.entity.*;
import com.lcyzh.nmerp.model.vo.OrderItemAssignVo;
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
//    @Autowired
//    private TOrderMapper tOrderMapper;
//    @Autowired
//    private TOrderItemMapper tOrderItemMapper;
//    @Autowired
//    private TContractMapper tContractMapper;
//    @Autowired
//    private TCustomerMapper tCustomerMapper;
//    @Autowired
//    private TProdplanExeMapper tProdplanExeMapper;
//
//
//    @Override
//    public List<TOrder> findList(TOrder tOrder) {
//        return tOrderMapper.findList(tOrder);
//    }
//
//    @Override
//    public List<TOrderItem> findByOrdCode(String ordCode) {
//        return tOrderItemMapper.findByOrdCode(ordCode);
//    }
//
//    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
//    @Override
//    public int ordProduceAssign(List<OrderItemAssignVo> voList,String ordCode) {
//        int res = -1;
//        if(voList!=null && !voList.isEmpty()){
//            Date current = new Date();
//            List<TProdplanExe> prodplanExes = voList.stream().map(vo -> {
//                TProdplanExe prodplanExe = new TProdplanExe();
//                prodplanExe.setOrdItemId(vo.getOrdItemId());
//                prodplanExe.setItemNum(vo.getItemNum());
//                prodplanExe.setItemUnit(vo.getItemUnit());
//                prodplanExe.setStatus('0');
//                prodplanExe.setMacCode(vo.getMacCode());
//                prodplanExe.setCreateTime(current);
//                return prodplanExe;
//            }).collect(Collectors.toList());
//            res = tProdplanExeMapper.insertBatch(prodplanExes);
//            if(res>0){
//                TOrder tOrder = new TOrder();
//                tOrder.setOrdCode(ordCode);
//                tOrder.setOrdStatus(Constants.ORD_STATUS_ASSIGNED);
//                tOrder.setUpdateTime(current);
//                res =tOrderMapper.update(tOrder);
//            }
//        }
//        return res;
//    }
//
//    @Override
//    public List<TOrder> findAllList() {
//        return tOrderMapper.findAllList();
//    }
//
//    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
//    @Override
//    public int insert(OrderVo vo) {
//        //生成订单信息，及订单明细;如果合同号不存在，则生成新的合同，存在则关联合同号
//        Date date = new Date();
//        TOrder tOrder = new TOrder();
//        String contCode = vo.getContCode();
//        if (contCode == null) {
//            contCode = StringUtils.genFixPreFixStr(Constants.CONT_PRE_FIX);
//            TContract tContract = new TContract();
//            tContract.setContCode(contCode);
//            tContract.setContStatus(Constants.CONT_STATUS_NEW);
//            tContract.setCreateTime(date);
//            tContractMapper.insert(tContract);
//        }
//        tOrder.setContCode(contCode);
//        TCustomer cus = tCustomerMapper.findByCusName(vo.getCusName());
//        String cusCode;
//        if (cus != null) {
//            cusCode = cus.getCusCode();
//        } else {
//            TCustomer tCustomer = new TCustomer();
//            tCustomer.setCusName(vo.getCusName());
//            tCustomer.setCreateTime(date);
//            tCustomer.setCusAddress(vo.getOrdAddress());
//            cusCode = StringUtils.genFixPreFixStr(Constants.CUS_PRE_FIX);
//            tOrder.setCusCode(cusCode);
//            tCustomer.setCusCode(cusCode);
//        }
//        tOrder.setCusCode(cusCode);
//        tOrder.setDeliveryDate(vo.getDeliveryDate());
//        tOrder.setOrdAddress(vo.getOrdAddress());
//        tOrder.setOrdCode(StringUtils.genFixPreFixStr(Constants.ORD_PRE_FIX));
//        //根据客户资料类型设置订单状态
//        if (cus.getStatus().equals(Constants.CUS_STATUS_SPEC)) {
//            tOrder.setOrdStatus(Constants.ORD_STATUS_TOASSIGN);
//        } else {
//            tOrder.setOrdStatus(Constants.ORD_STATUS_NEW);
//        }
//        tOrder.setCreateTime(date);
//        List<OrderItemVo> itemVos = vo.getItemVos();
//        if (itemVos != null && !itemVos.isEmpty()) {
//            List<TOrderItem> orderItems = itemVos.stream().map(itv -> {
//                TOrderItem tOrderItem = new TOrderItem();
//                tOrderItem.setCreateTime(date);
//                tOrderItem.setItemCode(tOrder.getOrdCode());
//                tOrderItem.setItemCode(itv.getItemCode());
//                tOrderItem.setItemColor(itv.getItemColor());
//                tOrderItem.setItemLenth(itv.getItemLenth());
//                tOrderItem.setItemNum(itv.getItemNum());
//                tOrderItem.setItemOwner(itv.getItemOwner());
//                tOrderItem.setItemThick(itv.getItemThick());
//                tOrderItem.setItemUnit(itv.getItemUnit());
//                tOrderItem.setItemWidth(itv.getItemWidth());
//                tOrderItem.setRemark(itv.getRemark());
//                return tOrderItem;
//
//            }).collect(Collectors.toList());
//            tOrderItemMapper.insertBatch(orderItems);
//        }
//        return tOrderMapper.insert(tOrder);
//    }
//
//    @Override
//    public int insertBatch(List<OrderVo> voList) {
//        List<TOrder> orders = new ArrayList<>(voList.size());
//        return tOrderMapper.insertBatch(orders);
//    }
//
//    @Override
//    public int update(TOrder tOrder) {
//        return tOrderMapper.update(tOrder);
//    }
//
//    @Override
//    public int delete(TOrder tOrder) {
//        return tOrderMapper.delete(tOrder);
//    }


    @Override
    public TOrder get(String id) {
        return null;
    }

    @Override
    public List<TOrder> findList(TOrder tOrder) {
        return null;
    }

    @Override
    public List<TOrder> findAllList() {
        return null;
    }

    @Override
    public int insert(TOrder tOrder) {
        return 0;
    }

    @Override
    public int insertBatch(List<TOrder> tOrders) {
        return 0;
    }

    @Override
    public int update(TOrder tOrder) {
        return 0;
    }

    @Override
    public int delete(TOrder tOrder) {
        return 0;
    }
}
