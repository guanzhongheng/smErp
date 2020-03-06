package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.TStock;
import com.lcyzh.nmerp.model.vo.OutStockDetailVo;
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

    TStock findById(Long id);

    //List<TStock> findList(TStock tStock);
    List<StockQueryVo> findList(StockQueryVo vo);

    int insert(TStock tStock);

    int insertBatch(List<TStock> tStocks);

    List<TStock> getByBarCode(String barCode);

    StockVo findByBarCode(String barCode);

    int updateByOutCode(Map<String, Object> map);

    List<TStock> findByOutCode(String outCode);

    int updateStock(TStock tStock);
}