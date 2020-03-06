package com.lcyzh.nmerp.service;

import com.lcyzh.nmerp.entity.TReturnMaterDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
public interface TReturnMaterDetailService {
    TReturnMaterDetail get(String id);

    List<TReturnMaterDetail> findList(TReturnMaterDetail tReturnMaterDetail);

    List<TReturnMaterDetail> findAllList();

    int insert(TReturnMaterDetail tReturnMaterDetail);

    int insertBatch(List<TReturnMaterDetail> tReturnMaterDetails);

    int update(TReturnMaterDetail tReturnMaterDetail);

    int delete(TReturnMaterDetail tReturnMaterDetail);

}
