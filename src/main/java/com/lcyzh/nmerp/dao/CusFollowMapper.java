package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.CusFollow;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* Author ljk
* Date  2019-07-01
*/
@Repository
public interface CusFollowMapper {

    CusFollow get(String id);

    List<CusFollow> findList(CusFollow cusFollow);

    List<CusFollow> findAllList();

    int insert(CusFollow cusFollow);

    int insertBatch(List<CusFollow> cusFollows);

    int update(CusFollow cusFollow);

    int delete(CusFollow cusFollow);

}