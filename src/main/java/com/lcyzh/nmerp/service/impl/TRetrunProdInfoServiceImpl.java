package com.lcyzh.nmerp.service.impl;

import com.lcyzh.nmerp.dao.TRetrunProdInfoMapper;
import com.lcyzh.nmerp.entity.TRetrunProdInfo;
import com.lcyzh.nmerp.service.TRetrunProdInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
@Service
public class TRetrunProdInfoServiceImpl implements TRetrunProdInfoService{
    @Autowired
    private TRetrunProdInfoMapper tRetrunProdInfoMapper;

    @Override
    public TRetrunProdInfo get(String id){
        return tRetrunProdInfoMapper.get(id);
    }

    @Override
    public List<TRetrunProdInfo> findList(TRetrunProdInfo tRetrunProdInfo) {
        return tRetrunProdInfoMapper.findList(tRetrunProdInfo);
    }

    @Override
    public List<TRetrunProdInfo> findAllList() {
        return tRetrunProdInfoMapper.findAllList();
    }

    @Override
    public int insert(TRetrunProdInfo tRetrunProdInfo) {
        return tRetrunProdInfoMapper.insert(tRetrunProdInfo);
    }

    @Override
    public int insertBatch(List<TRetrunProdInfo> tRetrunProdInfos){
        return tRetrunProdInfoMapper.insertBatch(tRetrunProdInfos);
    }

    @Override
    public int update(TRetrunProdInfo tRetrunProdInfo) {
        return tRetrunProdInfoMapper.update(tRetrunProdInfo);
    }

    @Override
    public int delete(TRetrunProdInfo tRetrunProdInfo) {
        return tRetrunProdInfoMapper.delete(tRetrunProdInfo);
    }

}
