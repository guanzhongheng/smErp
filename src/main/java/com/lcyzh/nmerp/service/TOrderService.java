package com.lcyzh.nmerp.service;

import com.lcyzh.nmerp.common.persistence.Page;
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

    List<TOrder> findList(TOrder tOrder);

    List<TOrderItem> findByOrdCode(String ordCode);

    int ordProduceAssign(List<OrderItemAssignVo> voList,String ordCode);

    Page<TOrder> findPage(Page<TOrder> page,TOrder order);

    int insert(OrderVo vo);

    int insertBatch(List<OrderVo> voList);

    int update(TOrder tOrder);

    int delete(TOrder tOrder);

}
