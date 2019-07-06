package com.lcyzh.nmerp.service;

import com.lcyzh.nmerp.entity.CusFollow;
import com.lcyzh.nmerp.entity.CusFollowDetail;
import com.lcyzh.nmerp.model.vo.CusFollowDetailVo;

import java.util.List;

/**
* Author ljk
* Date  2019-07-01
*/
public interface ICusFollowService {

    List<CusFollowDetail> findList(CusFollowDetail vo);

    int save(CusFollowDetailVo vo);

    List<CusFollow> findList(CusFollow cusFollow);

    List<CusFollow> findAllList();

    int insert(CusFollow cusFollow);

    int update(CusFollow cusFollow);

    int delete(CusFollow cusFollow);

}
