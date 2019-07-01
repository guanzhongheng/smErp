package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.TOrderItem;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
@Repository
public interface TOrderItemMapper {

    List<TOrderItem> findList(TOrderItem tOrderItem);

    List<TOrderItem> findAllList();

    int insert(TOrderItem tOrderItem);

    int insertBatch(List<TOrderItem> tOrderItems);

    int update(TOrderItem tOrderItem);

    int delete(TOrderItem tOrderItem);

    List<TOrderItem> findByOrdCode(String ordCode);
}