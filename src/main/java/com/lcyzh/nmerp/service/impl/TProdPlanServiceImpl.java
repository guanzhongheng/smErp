package com.lcyzh.nmerp.service.impl;

import com.lcyzh.nmerp.dao.TProdPlanMapper;
import com.lcyzh.nmerp.entity.TProdPlan;
import com.lcyzh.nmerp.service.TProdPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
@Service
public class TProdPlanServiceImpl implements TProdPlanService{
    @Autowired
    private TProdPlanMapper tProdPlanMapper;

    @Override
    public TProdPlan get(String id){
        return tProdPlanMapper.get(id);
    }

    @Override
    public List<TProdPlan> findList(TProdPlan tProdPlan) {
        return tProdPlanMapper.findList(tProdPlan);
    }

    @Override
    public List<TProdPlan> findAllList() {
        return tProdPlanMapper.findAllList();
    }

    @Override
    public int insert(TProdPlan tProdPlan) {
        return tProdPlanMapper.insert(tProdPlan);
    }

    @Override
    public int insertBatch(List<TProdPlan> tProdPlans){
        return tProdPlanMapper.insertBatch(tProdPlans);
    }

    @Override
    public int update(TProdPlan tProdPlan) {
        return tProdPlanMapper.update(tProdPlan);
    }

    @Override
    public int delete(TProdPlan tProdPlan) {
        return tProdPlanMapper.delete(tProdPlan);
    }

}
