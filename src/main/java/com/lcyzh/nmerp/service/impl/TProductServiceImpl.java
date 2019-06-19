package com.lcyzh.nmerp.service.impl;

import com.lcyzh.nmerp.dao.TProductMapper;
import com.lcyzh.nmerp.entity.TProduct;
import com.lcyzh.nmerp.service.TProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
@Service
public class TProductServiceImpl implements TProductService{
    @Autowired
    private TProductMapper tProductMapper;

    @Override
    public TProduct get(String id){
        return tProductMapper.get(id);
    }

    @Override
    public List<TProduct> findList(TProduct tProduct) {
        return tProductMapper.findList(tProduct);
    }

    @Override
    public List<TProduct> findAllList() {
        return tProductMapper.findAllList();
    }

    @Override
    public int insert(TProduct tProduct) {
        return tProductMapper.insert(tProduct);
    }

    @Override
    public int insertBatch(List<TProduct> tProducts){
        return tProductMapper.insertBatch(tProducts);
    }

    @Override
    public int update(TProduct tProduct) {
        return tProductMapper.update(tProduct);
    }

    @Override
    public int delete(TProduct tProduct) {
        return tProductMapper.delete(tProduct);
    }

}
