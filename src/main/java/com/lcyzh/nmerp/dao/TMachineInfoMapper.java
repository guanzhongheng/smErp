package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.TMachineInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
@Repository
public interface TMachineInfoMapper {

    TMachineInfo findById(Long id);

    List<TMachineInfo> findList(TMachineInfo tMachineInfo);

    List<TMachineInfo> findAllList();

    int insert(TMachineInfo tMachineInfo);

    int insertBatch(List<TMachineInfo> tMachineInfos);

    int update(TMachineInfo tMachineInfo);

    int delete(TMachineInfo tMachineInfo);

    TMachineInfo getByCode(String macCode);

    Integer getCntByCode(String code);
}