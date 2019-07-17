package com.lcyzh.nmerp.service;

import com.lcyzh.nmerp.entity.TMachineInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
public interface TMachineInfoService {
    TMachineInfo get(String id);

    TMachineInfo getByCode(String macCode);

    List<TMachineInfo> findList(TMachineInfo tMachineInfo);

    List<TMachineInfo> findAllList();

    int insert(TMachineInfo tMachineInfo);

    int insertBatch(List<TMachineInfo> tMachineInfos);

    int update(TMachineInfo tMachineInfo);

    int delete(TMachineInfo tMachineInfo);

}
