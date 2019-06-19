package com.lcyzh.nmerp.service.impl;

import com.lcyzh.nmerp.dao.TOutStockDetailMapper;
import com.lcyzh.nmerp.entity.TOutStockDetail;
import com.lcyzh.nmerp.service.TOutStockDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
@Service
public class TOutStockDetailServiceImpl implements TOutStockDetailService{
    @Autowired
    private TOutStockDetailMapper tOutStockDetailMapper;

    @Override
    public TOutStockDetail get(String id){
        return tOutStockDetailMapper.get(id);
    }

    @Override
    public List<TOutStockDetail> findList(TOutStockDetail tOutStockDetail) {
        return tOutStockDetailMapper.findList(tOutStockDetail);
    }

    @Override
    public List<TOutStockDetail> findAllList() {
        return tOutStockDetailMapper.findAllList();
    }

    @Override
    public int insert(TOutStockDetail tOutStockDetail) {
        return tOutStockDetailMapper.insert(tOutStockDetail);
    }

    @Override
    public int insertBatch(List<TOutStockDetail> tOutStockDetails){
        return tOutStockDetailMapper.insertBatch(tOutStockDetails);
    }

    @Override
    public int update(TOutStockDetail tOutStockDetail) {
        return tOutStockDetailMapper.update(tOutStockDetail);
    }

    @Override
    public int delete(TOutStockDetail tOutStockDetail) {
        return tOutStockDetailMapper.delete(tOutStockDetail);
    }

}
