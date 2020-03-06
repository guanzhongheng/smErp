package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.TInStockDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
@Repository
public interface TInStockDetailMapper {

    TInStockDetail get(String id);

    List<TInStockDetail> findList(TInStockDetail tInStockDetail);

    List<TInStockDetail> findAllList();

    int insert(TInStockDetail tInStockDetail);

    int insertBatch(List<TInStockDetail> tInStockDetails);

    int update(TInStockDetail tInStockDetail);

    int delete(TInStockDetail tInStockDetail);

}