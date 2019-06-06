package com.lcyzh.nmerp.service.impl;

import com.lcyzh.nmerp.dao.TRetrunMaterialInfoMapper;
import com.lcyzh.nmerp.entity.TRetrunMaterialInfo;
import com.lcyzh.nmerp.service.TRetrunMaterialInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
@Service
public class TRetrunMaterialInfoServiceImpl implements TRetrunMaterialInfoService{
    @Autowired
    private TRetrunMaterialInfoMapper tRetrunMaterialInfoMapper;

    @Override
    public TRetrunMaterialInfo get(String id){
        return tRetrunMaterialInfoMapper.get(id);
    }

    @Override
    public List<TRetrunMaterialInfo> findList(TRetrunMaterialInfo tRetrunMaterialInfo) {
        return tRetrunMaterialInfoMapper.findList(tRetrunMaterialInfo);
    }

    @Override
    public List<TRetrunMaterialInfo> findAllList() {
        return tRetrunMaterialInfoMapper.findAllList();
    }

    @Override
    public int insert(TRetrunMaterialInfo tRetrunMaterialInfo) {
        return tRetrunMaterialInfoMapper.insert(tRetrunMaterialInfo);
    }

    @Override
    public int insertBatch(List<TRetrunMaterialInfo> tRetrunMaterialInfos){
        return tRetrunMaterialInfoMapper.insertBatch(tRetrunMaterialInfos);
    }

    @Override
    public int update(TRetrunMaterialInfo tRetrunMaterialInfo) {
        return tRetrunMaterialInfoMapper.update(tRetrunMaterialInfo);
    }

    @Override
    public int delete(TRetrunMaterialInfo tRetrunMaterialInfo) {
        return tRetrunMaterialInfoMapper.delete(tRetrunMaterialInfo);
    }

}
