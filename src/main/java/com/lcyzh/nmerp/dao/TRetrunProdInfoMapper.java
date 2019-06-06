package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.TRetrunProdInfo;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
public interface TRetrunProdInfoMapper {

    TRetrunProdInfo get(String id);

    List<TRetrunProdInfo> findList(TRetrunProdInfo tRetrunProdInfo);

    List<TRetrunProdInfo> findAllList();

    int insert(TRetrunProdInfo tRetrunProdInfo);

    int insertBatch(List<TRetrunProdInfo> tRetrunProdInfos);

    int update(TRetrunProdInfo tRetrunProdInfo);

    int delete(TRetrunProdInfo tRetrunProdInfo);

}