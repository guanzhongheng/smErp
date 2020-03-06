package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.TRetrunProdDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
@Repository
public interface TRetrunProdDetailMapper {

    TRetrunProdDetail get(String id);

    List<TRetrunProdDetail> findList(TRetrunProdDetail tRetrunProdDetail);

    List<TRetrunProdDetail> findAllList();

    int insert(TRetrunProdDetail tRetrunProdDetail);

    int insertBatch(List<TRetrunProdDetail> tRetrunProdDetails);

    int update(TRetrunProdDetail tRetrunProdDetail);

    int delete(TRetrunProdDetail tRetrunProdDetail);

}