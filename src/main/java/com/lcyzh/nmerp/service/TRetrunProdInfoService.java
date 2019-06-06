package com.lcyzh.nmerp.service;

import com.lcyzh.nmerp.entity.TRetrunProdInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
public interface TRetrunProdInfoService {
    TRetrunProdInfo get(String id);

    List<TRetrunProdInfo> findList(TRetrunProdInfo tRetrunProdInfo);

    List<TRetrunProdInfo> findAllList();

    int insert(TRetrunProdInfo tRetrunProdInfo);

    int insertBatch(List<TRetrunProdInfo> tRetrunProdInfos);

    int update(TRetrunProdInfo tRetrunProdInfo);

    int delete(TRetrunProdInfo tRetrunProdInfo);

}
