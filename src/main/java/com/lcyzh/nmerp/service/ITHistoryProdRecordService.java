package com.lcyzh.nmerp.service;

import com.lcyzh.nmerp.entity.THistoryProdRecord;

import java.util.List;

/**
* Author ljk
* Date  2019-07-15
*/
public interface ITHistoryProdRecordService {
    THistoryProdRecord findById(String id);

    List<THistoryProdRecord> findList(THistoryProdRecord tHistoryProdRecord);

    List<THistoryProdRecord> findAllList();

    int insert(THistoryProdRecord tHistoryProdRecord);

    int insertBatch(List<THistoryProdRecord> tHistoryProdRecords);

    int update(THistoryProdRecord tHistoryProdRecord);

    int delete(THistoryProdRecord tHistoryProdRecord);

}
