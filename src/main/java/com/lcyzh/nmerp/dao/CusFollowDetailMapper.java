package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.CusFollowDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* Author ljk
* Date  2019-07-01
*/
@Repository
public interface CusFollowDetailMapper {

    CusFollowDetail get(String id);

    List<CusFollowDetail> findList(CusFollowDetail cusFollowDetail);

    int insert(CusFollowDetail cusFollowDetail);

}