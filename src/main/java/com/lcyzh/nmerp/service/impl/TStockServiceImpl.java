package com.lcyzh.nmerp.service.impl;

import com.lcyzh.nmerp.dao.TStockMapper;
import com.lcyzh.nmerp.entity.TStock;
import com.lcyzh.nmerp.service.TStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
@Service
public class TStockServiceImpl implements TStockService{
    @Autowired
    private TStockMapper tStockMapper;

    @Override
    public TStock get(String id){
        return tStockMapper.get(id);
    }

    @Override
    public List<TStock> findList(TStock tStock) {
        return tStockMapper.findList(tStock);
    }

    @Override
    public List<TStock> findAllList() {
        return tStockMapper.findAllList();
    }

    @Override
    public int insert(TStock tStock) {
        return tStockMapper.insert(tStock);
    }

    @Override
    public int insertBatch(List<TStock> tStocks){
        return tStockMapper.insertBatch(tStocks);
    }

    @Override
    public int update(TStock tStock) {
        return tStockMapper.update(tStock);
    }

    @Override
    public int delete(TStock tStock) {
        return tStockMapper.delete(tStock);
    }

}
