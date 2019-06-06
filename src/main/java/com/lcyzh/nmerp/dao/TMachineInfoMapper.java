package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.TMachineInfo;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
public interface TMachineInfoMapper {

    TMachineInfo get(String id);

    List<TMachineInfo> findList(TMachineInfo tMachineInfo);

    List<TMachineInfo> findAllList();

    int insert(TMachineInfo tMachineInfo);

    int insertBatch(List<TMachineInfo> tMachineInfos);

    int update(TMachineInfo tMachineInfo);

    int delete(TMachineInfo tMachineInfo);

}