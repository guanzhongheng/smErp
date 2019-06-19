package com.lcyzh.nmerp.service.impl;

import com.lcyzh.nmerp.dao.TReturnMaterDetailMapper;
import com.lcyzh.nmerp.entity.TReturnMaterDetail;
import com.lcyzh.nmerp.service.TReturnMaterDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
@Service
public class TReturnMaterDetailServiceImpl implements TReturnMaterDetailService{
    @Autowired
    private TReturnMaterDetailMapper tReturnMaterDetailMapper;

    @Override
    public TReturnMaterDetail get(String id){
        return tReturnMaterDetailMapper.get(id);
    }

    @Override
    public List<TReturnMaterDetail> findList(TReturnMaterDetail tReturnMaterDetail) {
        return tReturnMaterDetailMapper.findList(tReturnMaterDetail);
    }

    @Override
    public List<TReturnMaterDetail> findAllList() {
        return tReturnMaterDetailMapper.findAllList();
    }

    @Override
    public int insert(TReturnMaterDetail tReturnMaterDetail) {
        return tReturnMaterDetailMapper.insert(tReturnMaterDetail);
    }

    @Override
    public int insertBatch(List<TReturnMaterDetail> tReturnMaterDetails){
        return tReturnMaterDetailMapper.insertBatch(tReturnMaterDetails);
    }

    @Override
    public int update(TReturnMaterDetail tReturnMaterDetail) {
        return tReturnMaterDetailMapper.update(tReturnMaterDetail);
    }

    @Override
    public int delete(TReturnMaterDetail tReturnMaterDetail) {
        return tReturnMaterDetailMapper.delete(tReturnMaterDetail);
    }

}
