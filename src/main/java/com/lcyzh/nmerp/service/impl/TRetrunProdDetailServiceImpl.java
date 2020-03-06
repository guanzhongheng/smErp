package com.lcyzh.nmerp.service.impl;

import com.lcyzh.nmerp.dao.TRetrunProdDetailMapper;
import com.lcyzh.nmerp.entity.TRetrunProdDetail;
import com.lcyzh.nmerp.service.TRetrunProdDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
@Service
public class TRetrunProdDetailServiceImpl implements TRetrunProdDetailService{
    @Autowired
    private TRetrunProdDetailMapper tRetrunProdDetailMapper;

    @Override
    public TRetrunProdDetail get(String id){
        return tRetrunProdDetailMapper.get(id);
    }

    @Override
    public List<TRetrunProdDetail> findList(TRetrunProdDetail tRetrunProdDetail) {
        return tRetrunProdDetailMapper.findList(tRetrunProdDetail);
    }

    @Override
    public List<TRetrunProdDetail> findAllList() {
        return tRetrunProdDetailMapper.findAllList();
    }

    @Override
    public int insert(TRetrunProdDetail tRetrunProdDetail) {
        return tRetrunProdDetailMapper.insert(tRetrunProdDetail);
    }

    @Override
    public int insertBatch(List<TRetrunProdDetail> tRetrunProdDetails){
        return tRetrunProdDetailMapper.insertBatch(tRetrunProdDetails);
    }

    @Override
    public int update(TRetrunProdDetail tRetrunProdDetail) {
        return tRetrunProdDetailMapper.update(tRetrunProdDetail);
    }

    @Override
    public int delete(TRetrunProdDetail tRetrunProdDetail) {
        return tRetrunProdDetailMapper.delete(tRetrunProdDetail);
    }

}
