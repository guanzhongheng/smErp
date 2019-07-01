package com.lcyzh.nmerp.service.impl;

import com.lcyzh.nmerp.dao.CusFollowMapper;
import com.lcyzh.nmerp.entity.CusFollow;
import com.lcyzh.nmerp.service.ICusFollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Author ljk
* Date  2019-07-01
*/
@Service
public class CusFollowServiceImpl implements ICusFollowService {
    @Autowired
    private CusFollowMapper cusFollowMapper;

    @Override
    public CusFollow get(String id){
        return cusFollowMapper.get(id);
    }

    @Override
    public List<CusFollow> findList(CusFollow cusFollow) {
        return cusFollowMapper.findList(cusFollow);
    }

    @Override
    public List<CusFollow> findAllList() {
        return cusFollowMapper.findAllList();
    }

    @Override
    public int insert(CusFollow cusFollow) {
        return cusFollowMapper.insert(cusFollow);
    }

    @Override
    public int insertBatch(List<CusFollow> cusFollows){
        return cusFollowMapper.insertBatch(cusFollows);
    }

    @Override
    public int update(CusFollow cusFollow) {
        return cusFollowMapper.update(cusFollow);
    }

    @Override
    public int delete(CusFollow cusFollow) {
        return cusFollowMapper.delete(cusFollow);
    }

}
