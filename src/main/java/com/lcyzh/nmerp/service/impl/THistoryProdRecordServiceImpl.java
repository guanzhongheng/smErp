package com.lcyzh.nmerp.service.impl;

import com.github.pagehelper.PageHelper;
import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.dao.THistoryProdRecordMapper;
import com.lcyzh.nmerp.entity.THistoryProdRecord;
import com.lcyzh.nmerp.model.vo.HistoryPordRecordVo;
import com.lcyzh.nmerp.service.ITHistoryProdRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
    public Page<HistoryPordRecordVo> findPage(Page<HistoryPordRecordVo> page, HistoryPordRecordVo vo) {
        PageHelper.startPage(page.getPageNo(),page.getPageSize());
        if(vo.getStartDate() == null || vo.getStartDate().length() == 0) {
            vo.setStartDate(LocalDate.now().minusMonths(1).toString());
            vo.setEndDate(LocalDate.now().toString());
        }
        List<HistoryPordRecordVo> list = tHistoryProdRecordMapper.findListVo(vo);
        page.setList(list);
        return page;
    }

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
