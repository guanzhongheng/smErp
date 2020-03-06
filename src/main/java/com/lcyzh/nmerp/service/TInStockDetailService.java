package com.lcyzh.nmerp.service;

import com.lcyzh.nmerp.entity.TInStockDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
public interface TInStockDetailService {
    TInStockDetail get(String id);

    List<TInStockDetail> findList(TInStockDetail tInStockDetail);

    List<TInStockDetail> findAllList();

    int insert(TInStockDetail tInStockDetail);

    int insertBatch(List<TInStockDetail> tInStockDetails);

    int update(TInStockDetail tInStockDetail);

    int delete(TInStockDetail tInStockDetail);

}
