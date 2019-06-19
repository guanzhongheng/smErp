package com.lcyzh.nmerp.service;

import com.lcyzh.nmerp.entity.TRetrunProdDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
public interface TRetrunProdDetailService {
    TRetrunProdDetail get(String id);

    List<TRetrunProdDetail> findList(TRetrunProdDetail tRetrunProdDetail);

    List<TRetrunProdDetail> findAllList();

    int insert(TRetrunProdDetail tRetrunProdDetail);

    int insertBatch(List<TRetrunProdDetail> tRetrunProdDetails);

    int update(TRetrunProdDetail tRetrunProdDetail);

    int delete(TRetrunProdDetail tRetrunProdDetail);

}
