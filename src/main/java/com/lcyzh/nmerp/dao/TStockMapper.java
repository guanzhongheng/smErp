package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.TStock;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
@Repository
public interface TStockMapper {

    TStock get(String id);

    List<TStock> findList(TStock tStock);

    List<TStock> findAllList();

    int insert(TStock tStock);

    int insertBatch(List<TStock> tStocks);

    int update(TStock tStock);

    int delete(TStock tStock);

    List<TStock> getByBarCode(String barCode);
}