package com.lcyzh.nmerp.service.impl;

import com.lcyzh.nmerp.dao.TMachineInfoMapper;
import com.lcyzh.nmerp.entity.TMachineInfo;
import com.lcyzh.nmerp.service.TMachineInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
@Service
public class TMachineInfoServiceImpl implements TMachineInfoService{
    @Autowired
    private TMachineInfoMapper tMachineInfoMapper;

    @Override
    public TMachineInfo get(String id){
        return tMachineInfoMapper.get(id);
    }

    @Override
    public List<TMachineInfo> findList(TMachineInfo tMachineInfo) {
        return tMachineInfoMapper.findList(tMachineInfo);
    }

    @Override
    public List<TMachineInfo> findAllList() {
        return tMachineInfoMapper.findAllList();
    }

    @Override
    public int insert(TMachineInfo tMachineInfo) {
        return tMachineInfoMapper.insert(tMachineInfo);
    }

    @Override
    public int insertBatch(List<TMachineInfo> tMachineInfos){
        return tMachineInfoMapper.insertBatch(tMachineInfos);
    }

    @Override
    public int update(TMachineInfo tMachineInfo) {
        return tMachineInfoMapper.update(tMachineInfo);
    }

    @Override
    public int delete(TMachineInfo tMachineInfo) {
        return tMachineInfoMapper.delete(tMachineInfo);
    }

}
