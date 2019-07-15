package com.lcyzh.nmerp.service.impl;

import com.lcyzh.nmerp.dao.THistoryProdRecordMapper;
import com.lcyzh.nmerp.entity.THistoryProdRecord;
import com.lcyzh.nmerp.service.ITHistoryProdRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Author ljk
* Date  2019-07-15
*/
@Service
public class THistoryProdRecordServiceImpl implements ITHistoryProdRecordService {
    @Autowired
    private THistoryProdRecordMapper tHistoryProdRecordMapper;

    @Override
    public THistoryProdRecord findById(String id){
        return tHistoryProdRecordMapper.findById(id);
    }

    @Override
    public List<THistoryProdRecord> findList(THistoryProdRecord tHistoryProdRecord) {
        return tHistoryProdRecordMapper.findList(tHistoryProdRecord);
    }

    @Override
    public List<THistoryProdRecord> findAllList() {
        return tHistoryProdRecordMapper.findAllList();
    }

    @Override
    public int insert(THistoryProdRecord tHistoryProdRecord) {
        return tHistoryProdRecordMapper.insert(tHistoryProdRecord);
    }

    @Override
    public int insertBatch(List<THistoryProdRecord> tHistoryProdRecords){
        return tHistoryProdRecordMapper.insertBatch(tHistoryProdRecords);
    }

    @Override
    public int update(THistoryProdRecord tHistoryProdRecord) {
        return tHistoryProdRecordMapper.update(tHistoryProdRecord);
    }

    @Override
    public int delete(THistoryProdRecord tHistoryProdRecord) {
        return tHistoryProdRecordMapper.delete(tHistoryProdRecord);
    }

}
