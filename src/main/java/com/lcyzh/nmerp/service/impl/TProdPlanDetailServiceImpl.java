package com.lcyzh.nmerp.service.impl;

import com.lcyzh.nmerp.dao.TProdPlanDetailMapper;
import com.lcyzh.nmerp.entity.TProdPlanDetail;
import com.lcyzh.nmerp.service.TProdPlanDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
@Service
public class TProdPlanDetailServiceImpl implements TProdPlanDetailService{
    @Autowired
    private TProdPlanDetailMapper tProdPlanDetailMapper;

    @Override
    public TProdPlanDetail get(String id){
        return tProdPlanDetailMapper.get(id);
    }

    @Override
    public List<TProdPlanDetail> findList(TProdPlanDetail tProdPlanDetail) {
        return tProdPlanDetailMapper.findList(tProdPlanDetail);
    }

    @Override
    public List<TProdPlanDetail> findAllList() {
        return tProdPlanDetailMapper.findAllList();
    }

    @Override
    public int insert(TProdPlanDetail tProdPlanDetail) {
        return tProdPlanDetailMapper.insert(tProdPlanDetail);
    }

    @Override
    public int insertBatch(List<TProdPlanDetail> tProdPlanDetails){
        return tProdPlanDetailMapper.insertBatch(tProdPlanDetails);
    }

    @Override
    public int update(TProdPlanDetail tProdPlanDetail) {
        return tProdPlanDetailMapper.update(tProdPlanDetail);
    }

    @Override
    public int delete(TProdPlanDetail tProdPlanDetail) {
        return tProdPlanDetailMapper.delete(tProdPlanDetail);
    }

}
