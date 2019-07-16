package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.THistoryProdRecord;
import com.lcyzh.nmerp.model.vo.HistoryPordRecordVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* Author ljk
* Date  2019-07-15
*/
@Repository
public interface THistoryProdRecordMapper {

    THistoryProdRecord findById(String id);

    List<THistoryProdRecord> findList(THistoryProdRecord tHistoryProdRecord);

    List<THistoryProdRecord> findAllList();

    int insert(THistoryProdRecord tHistoryProdRecord);

    int insertBatch(List<THistoryProdRecord> tHistoryProdRecords);

    int update(THistoryProdRecord tHistoryProdRecord);

    int delete(THistoryProdRecord tHistoryProdRecord);

    List<HistoryPordRecordVo> findListVo(HistoryPordRecordVo vo);
}