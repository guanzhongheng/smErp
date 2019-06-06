package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.TOutStock;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
public interface TOutStockMapper {

    TOutStock get(String id);

    List<TOutStock> findList(TOutStock tOutStock);

    List<TOutStock> findAllList();

    int insert(TOutStock tOutStock);

    int insertBatch(List<TOutStock> tOutStocks);

    int update(TOutStock tOutStock);

    int delete(TOutStock tOutStock);

}