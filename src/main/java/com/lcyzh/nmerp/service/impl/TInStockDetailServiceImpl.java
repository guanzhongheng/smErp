package com.lcyzh.nmerp.service.impl;

import com.lcyzh.nmerp.dao.TInStockDetailMapper;
import com.lcyzh.nmerp.entity.TInStockDetail;
import com.lcyzh.nmerp.service.TInStockDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
@Service
public class TInStockDetailServiceImpl implements TInStockDetailService{
    @Autowired
    private TInStockDetailMapper tInStockDetailMapper;

    @Override
    public TInStockDetail get(String id){
        return tInStockDetailMapper.get(id);
    }

    @Override
    public List<TInStockDetail> findList(TInStockDetail tInStockDetail) {
        return tInStockDetailMapper.findList(tInStockDetail);
    }

    @Override
    public List<TInStockDetail> findAllList() {
        return tInStockDetailMapper.findAllList();
    }

    @Override
    public int insert(TInStockDetail tInStockDetail) {
        return tInStockDetailMapper.insert(tInStockDetail);
    }

    @Override
    public int insertBatch(List<TInStockDetail> tInStockDetails){
        return tInStockDetailMapper.insertBatch(tInStockDetails);
    }

    @Override
    public int update(TInStockDetail tInStockDetail) {
        return tInStockDetailMapper.update(tInStockDetail);
    }

    @Override
    public int delete(TInStockDetail tInStockDetail) {
        return tInStockDetailMapper.delete(tInStockDetail);
    }

}
