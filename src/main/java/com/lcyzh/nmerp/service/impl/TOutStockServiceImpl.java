package com.lcyzh.nmerp.service.impl;

import com.lcyzh.nmerp.dao.TOutStockMapper;
import com.lcyzh.nmerp.entity.TOutStock;
import com.lcyzh.nmerp.service.TOutStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
@Service
public class TOutStockServiceImpl implements TOutStockService{
    @Autowired
    private TOutStockMapper tOutStockMapper;

    @Override
    public TOutStock get(String id){
        return tOutStockMapper.get(id);
    }

    @Override
    public List<TOutStock> findList(TOutStock tOutStock) {
        return tOutStockMapper.findList(tOutStock);
    }

    @Override
    public List<TOutStock> findAllList() {
        return tOutStockMapper.findAllList();
    }

    @Override
    public int insert(TOutStock tOutStock) {
        return tOutStockMapper.insert(tOutStock);
    }

    @Override
    public int insertBatch(List<TOutStock> tOutStocks){
        return tOutStockMapper.insertBatch(tOutStocks);
    }

    @Override
    public int update(TOutStock tOutStock) {
        return tOutStockMapper.update(tOutStock);
    }

    @Override
    public int delete(TOutStock tOutStock) {
        return tOutStockMapper.delete(tOutStock);
    }

}
