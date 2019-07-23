package com.lcyzh.nmerp.service;

import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.entity.TStock;
import com.lcyzh.nmerp.model.vo.StockQueryVo;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
public interface TStockService {

    TStock get(String id);

    TStock findById(Long id);

    //List<TStock> findList(TStock tStock);

    int insert(TStock tStock);

    int insertBatch(List<TStock> tStocks);

    //补标签查询
    List<StockQueryVo> findList(Page<StockQueryVo> page, StockQueryVo vo);

}
