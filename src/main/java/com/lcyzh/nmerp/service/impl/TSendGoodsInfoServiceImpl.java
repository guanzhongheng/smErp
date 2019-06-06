package com.lcyzh.nmerp.service.impl;

import com.lcyzh.nmerp.dao.TSendGoodsInfoMapper;
import com.lcyzh.nmerp.entity.TSendGoodsInfo;
import com.lcyzh.nmerp.service.TSendGoodsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
@Service
public class TSendGoodsInfoServiceImpl implements TSendGoodsInfoService{
    @Autowired
    private TSendGoodsInfoMapper tSendGoodsInfoMapper;

    @Override
    public TSendGoodsInfo get(String id){
        return tSendGoodsInfoMapper.get(id);
    }

    @Override
    public List<TSendGoodsInfo> findList(TSendGoodsInfo tSendGoodsInfo) {
        return tSendGoodsInfoMapper.findList(tSendGoodsInfo);
    }

    @Override
    public List<TSendGoodsInfo> findAllList() {
        return tSendGoodsInfoMapper.findAllList();
    }

    @Override
    public int insert(TSendGoodsInfo tSendGoodsInfo) {
        return tSendGoodsInfoMapper.insert(tSendGoodsInfo);
    }

    @Override
    public int insertBatch(List<TSendGoodsInfo> tSendGoodsInfos){
        return tSendGoodsInfoMapper.insertBatch(tSendGoodsInfos);
    }

    @Override
    public int update(TSendGoodsInfo tSendGoodsInfo) {
        return tSendGoodsInfoMapper.update(tSendGoodsInfo);
    }

    @Override
    public int delete(TSendGoodsInfo tSendGoodsInfo) {
        return tSendGoodsInfoMapper.delete(tSendGoodsInfo);
    }

}
