package com.lcyzh.nmerp.service.impl;

import com.lcyzh.nmerp.dao.TInStockMapper;
import com.lcyzh.nmerp.entity.TInStock;
import com.lcyzh.nmerp.service.TInStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
@Service
public class TInStockServiceImpl implements TInStockService{
    @Autowired
    private TInStockMapper tInStockMapper;

    @Override
    public TInStock get(String id){
        return tInStockMapper.get(id);
    }

    @Override
    public List<TInStock> findList(TInStock tInStock) {
        return tInStockMapper.findList(tInStock);
    }

    @Override
    public List<TInStock> findAllList() {
        return tInStockMapper.findAllList();
    }

    @Override
    public int insert(TInStock tInStock) {
        return tInStockMapper.insert(tInStock);
    }

    @Override
    public int insertBatch(List<TInStock> tInStocks){
        return tInStockMapper.insertBatch(tInStocks);
    }

    @Override
    public int update(TInStock tInStock) {
        return tInStockMapper.update(tInStock);
    }

    @Override
    public int delete(TInStock tInStock) {
        return tInStockMapper.delete(tInStock);
    }

}
