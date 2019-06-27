package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.TRetrunMaterialInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
@Repository
public interface TRetrunMaterialInfoMapper {

    TRetrunMaterialInfo get(String id);

    List<TRetrunMaterialInfo> findList(TRetrunMaterialInfo tRetrunMaterialInfo);

    List<TRetrunMaterialInfo> findAllList();

    int insert(TRetrunMaterialInfo tRetrunMaterialInfo);

    int insertBatch(List<TRetrunMaterialInfo> tRetrunMaterialInfos);

    int update(TRetrunMaterialInfo tRetrunMaterialInfo);

    int delete(TRetrunMaterialInfo tRetrunMaterialInfo);

}