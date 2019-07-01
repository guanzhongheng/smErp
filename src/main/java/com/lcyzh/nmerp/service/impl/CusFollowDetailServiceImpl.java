package com.lcyzh.nmerp.service.impl;

import com.lcyzh.nmerp.dao.CusFollowDetailMapper;
import com.lcyzh.nmerp.entity.CusFollowDetail;
import com.lcyzh.nmerp.service.ICusFollowDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Author ljk
* Date  2019-07-01
*/
@Service
public class CusFollowDetailServiceImpl implements ICusFollowDetailService {
    @Autowired
    private CusFollowDetailMapper cusFollowDetailMapper;

    @Override
    public CusFollowDetail get(String id){
        return cusFollowDetailMapper.get(id);
    }

    @Override
    public List<CusFollowDetail> findList(CusFollowDetail cusFollowDetail) {
        return cusFollowDetailMapper.findList(cusFollowDetail);
    }

    @Override
    public List<CusFollowDetail> findAllList() {
        return cusFollowDetailMapper.findAllList();
    }

    @Override
    public int insert(CusFollowDetail cusFollowDetail) {
        return cusFollowDetailMapper.insert(cusFollowDetail);
    }

    @Override
    public int insertBatch(List<CusFollowDetail> cusFollowDetails){
        return cusFollowDetailMapper.insertBatch(cusFollowDetails);
    }

    @Override
    public int update(CusFollowDetail cusFollowDetail) {
        return cusFollowDetailMapper.update(cusFollowDetail);
    }

    @Override
    public int delete(CusFollowDetail cusFollowDetail) {
        return cusFollowDetailMapper.delete(cusFollowDetail);
    }

}
