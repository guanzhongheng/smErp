package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.TOutStock;
import com.lcyzh.nmerp.model.vo.CommonVo;
import com.lcyzh.nmerp.model.vo.OutStockVo;
import com.lcyzh.nmerp.model.vo.StockRecordVo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
* Author ljk
* Date  2019-06-06
*/
@Repository
public interface TOutStockMapper {

    TOutStock findByPrimaryKey(String outCode);

    List<TOutStock> findByOrdCode(String ordCode);

    List<TOutStock> findList(OutStockVo vo);

    int insert(TOutStock tOutStock);

    int update(TOutStock tOutStock);

    int delete(String outCode);

    TOutStock findByOutCode(String outCode);

    //int delete(String outCode);

    List<StockRecordVo> getOutStockList(OutStockVo vo);

    List<TOutStock> findListNew();

    int updateStatus(Map<String, Object> map);

    List<CommonVo> checkOrderStatus(String outCode);

    TOutStock isOutStockExist(Map<String, Object> map);
}