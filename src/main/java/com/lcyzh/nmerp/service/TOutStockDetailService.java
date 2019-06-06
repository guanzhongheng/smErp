package com.lcyzh.nmerp.service;

import com.lcyzh.nmerp.entity.TOutStockDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
public interface TOutStockDetailService {
    TOutStockDetail get(String id);

    List<TOutStockDetail> findList(TOutStockDetail tOutStockDetail);

    List<TOutStockDetail> findAllList();

    int insert(TOutStockDetail tOutStockDetail);

    int insertBatch(List<TOutStockDetail> tOutStockDetails);

    int update(TOutStockDetail tOutStockDetail);

    int delete(TOutStockDetail tOutStockDetail);

}
