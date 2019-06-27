package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.TOrder;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
@Repository
public interface TOrderMapper {

    List<TOrder> findList(TOrder tOrder);

    List<TOrder> findAllList();

    int insert(TOrder tOrder);

    int insertBatch(List<TOrder> tOrders);

    int update(TOrder tOrder);

    int delete(TOrder tOrder);

}