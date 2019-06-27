package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.TProdPlan;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
@Repository
public interface TProdPlanMapper {

    TProdPlan get(String id);

    List<TProdPlan> findList(TProdPlan tProdPlan);

    List<TProdPlan> findAllList();

    int insert(TProdPlan tProdPlan);

    int insertBatch(List<TProdPlan> tProdPlans);

    int update(TProdPlan tProdPlan);

    int delete(TProdPlan tProdPlan);

}