package com.lcyzh.nmerp.service;

import com.lcyzh.nmerp.entity.CusFollowDetail;

import java.util.List;

/**
* Author ljk
* Date  2019-07-01
*/
public interface ICusFollowDetailService {
    CusFollowDetail get(String id);

    List<CusFollowDetail> findList(CusFollowDetail cusFollowDetail);

    List<CusFollowDetail> findAllList();

    int insert(CusFollowDetail cusFollowDetail);

    int insertBatch(List<CusFollowDetail> cusFollowDetails);

    int update(CusFollowDetail cusFollowDetail);

    int delete(CusFollowDetail cusFollowDetail);

}
