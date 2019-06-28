package com.lcyzh.nmerp.service;

import com.lcyzh.nmerp.entity.TOrder;
import com.lcyzh.nmerp.entity.TOrderItem;
import com.lcyzh.nmerp.model.vo.OrderItemAssignVo;
import com.lcyzh.nmerp.model.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
public interface TOrderService {

    TOrder get(String id);

    List<TOrder> findList(TOrder tOrder);

    List<TOrder> findAllList();

    int insert(TOrder tOrder);

    int insertBatch(List<TOrder> tOrders);

    int update(TOrder tOrder);

    int delete(TOrder tOrder);

}
