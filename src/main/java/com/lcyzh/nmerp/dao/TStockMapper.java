package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.TStock;
import com.lcyzh.nmerp.model.vo.StockQueryVo;
import com.lcyzh.nmerp.model.vo.StockVo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
* Author ljk
* Date  2019-06-06
*/
@Repository
public interface TStockMapper {

    TStock get(String id);

    //List<TStock> findList(TStock tStock);
    List<TStock> findList(StockQueryVo vo);

    int insert(TStock tStock);

    int insertBatch(List<TStock> tStocks);

    List<TStock> getByBarCode(String barCode);

    StockVo findByBarCode(String barCode);

    List<StockVo> findOutItemsByOutCode(String outCode);

    int updateByOutCode(Map<String, Object> map);
}