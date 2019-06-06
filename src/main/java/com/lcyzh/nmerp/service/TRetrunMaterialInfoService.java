package com.lcyzh.nmerp.service;

import com.lcyzh.nmerp.entity.TRetrunMaterialInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
public interface TRetrunMaterialInfoService {
    TRetrunMaterialInfo get(String id);

    List<TRetrunMaterialInfo> findList(TRetrunMaterialInfo tRetrunMaterialInfo);

    List<TRetrunMaterialInfo> findAllList();

    int insert(TRetrunMaterialInfo tRetrunMaterialInfo);

    int insertBatch(List<TRetrunMaterialInfo> tRetrunMaterialInfos);

    int update(TRetrunMaterialInfo tRetrunMaterialInfo);

    int delete(TRetrunMaterialInfo tRetrunMaterialInfo);

}
