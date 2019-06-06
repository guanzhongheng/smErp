package com.lcyzh.nmerp.service;

import com.lcyzh.nmerp.entity.TProdPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
public interface TProdPlanService {
    TProdPlan get(String id);

    List<TProdPlan> findList(TProdPlan tProdPlan);

    List<TProdPlan> findAllList();

    int insert(TProdPlan tProdPlan);

    int insertBatch(List<TProdPlan> tProdPlans);

    int update(TProdPlan tProdPlan);

    int delete(TProdPlan tProdPlan);

}
