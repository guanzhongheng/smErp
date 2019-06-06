package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.TStock;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
public interface TStockMapper {

    TStock get(String id);

    List<TStock> findList(TStock tStock);

    List<TStock> findAllList();

    int insert(TStock tStock);

    int insertBatch(List<TStock> tStocks);

    int update(TStock tStock);

    int delete(TStock tStock);

}