package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.TReturnMaterDetail;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
public interface TReturnMaterDetailMapper {

    TReturnMaterDetail get(String id);

    List<TReturnMaterDetail> findList(TReturnMaterDetail tReturnMaterDetail);

    List<TReturnMaterDetail> findAllList();

    int insert(TReturnMaterDetail tReturnMaterDetail);

    int insertBatch(List<TReturnMaterDetail> tReturnMaterDetails);

    int update(TReturnMaterDetail tReturnMaterDetail);

    int delete(TReturnMaterDetail tReturnMaterDetail);

}