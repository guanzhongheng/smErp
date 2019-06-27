package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.TBarCodeInfo;

import java.util.List;

public interface TBarCodeInfoMapper {

    int insert(TBarCodeInfo entry);

    int update(TBarCodeInfo entry);

    List<TBarCodeInfo> findBySelectKey(TBarCodeInfo entry);

    TBarCodeInfo findByPrimaryKey(TBarCodeInfo entry);
}
