package com.lcyzh.nmerp.service;

import com.lcyzh.nmerp.entity.TOrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
public interface TOrderItemService {
    TOrderItem get(String id);

    List<TOrderItem> findList(TOrderItem tOrderItem);

    List<TOrderItem> findAllList();

    int insert(TOrderItem tOrderItem);

    int insertBatch(List<TOrderItem> tOrderItems);

    int update(TOrderItem tOrderItem);

    int delete(TOrderItem tOrderItem);

}
