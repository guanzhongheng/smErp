package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.TOutStockDetail;
import com.lcyzh.nmerp.model.vo.OutItemVo;
import com.lcyzh.nmerp.model.vo.OutStockVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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
}