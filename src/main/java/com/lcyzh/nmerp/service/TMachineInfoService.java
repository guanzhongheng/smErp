package com.lcyzh.nmerp.service;

import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.entity.TMachineInfo;
import com.lcyzh.nmerp.model.vo.MachineInfoVo;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
public interface TMachineInfoService {
    TMachineInfo findById(Long id);

    TMachineInfo getByCode(String macCode);

    List<TMachineInfo> findList(TMachineInfo tMachineInfo);

    List<TMachineInfo> findAllList();

    int insert(TMachineInfo tMachineInfo);

    int insertBatch(List<TMachineInfo> tMachineInfos);

    int update(TMachineInfo tMachineInfo);

    int delete(TMachineInfo tMachineInfo);

    Page<MachineInfoVo> findPage(Page<MachineInfoVo> machineInfoVoPage, TMachineInfo tMachineInfo);

    boolean macCodeIsExistence(String code);
}
