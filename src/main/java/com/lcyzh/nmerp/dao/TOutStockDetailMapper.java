package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.TOutStockDetail;
import com.lcyzh.nmerp.model.vo.OutStockDetailVo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Author ljk
 * Date  2019-06-06
 */
@Repository
public interface TOutStockDetailMapper {

    List<TOutStockDetail> findAllList();

    int insert(TOutStockDetail tOutStockDetail);

    int insertBatch(List<TOutStockDetail> tOutStockDetails);

    List<TOutStockDetail> findList(TOutStockDetail tOutStockDetail);

    void deleteByOutCode(String outCode);

    int deleteByBarCode(String barCode);

    List<OutStockDetailVo> findOutItemsByOutCode(String outCode);

    List<TOutStockDetail> findByBarCode(String barCode);

    List<OutStockDetailVo> getOutStockDetailInfos(String outCode);

    TOutStockDetail findOne(Map<String, Object> map);
}