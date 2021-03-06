package com.lcyzh.nmerp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
            vo.setStartDate(LocalDate.now().minusMonths(1).toString() + " 06:00:00");
        }
        if(vo.getEndDate() == null || vo.getEndDate().length() == 0) {
            vo.setEndDate(LocalDate.now().plusDays(1).toString() + " 23:59:59");
        }
        List<HistoryPordRecordVo> list = tHistoryProdRecordMapper.findListVo(vo);

        PageInfo<HistoryPordRecordVo> p = new PageInfo<>(list);
        page.setTotal(p.getTotal());
        page.setCount(list.size());
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
