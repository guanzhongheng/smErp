package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.TInStock;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
public interface TInStockMapper {

    TInStock get(String id);

    List<TInStock> findList(TInStock tInStock);

    List<TInStock> findAllList();

    int insert(TInStock tInStock);

    int insertBatch(List<TInStock> tInStocks);

    int update(TInStock tInStock);

    int delete(TInStock tInStock);

}