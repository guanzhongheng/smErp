package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.TProdPlan;
import com.lcyzh.nmerp.model.vo.ProdPlanVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
@Repository
public interface TProdPlanMapper {

    //TProdPlan findByProdPanCode(String prodPlanCode);

    List<ProdPlanVo> findList(ProdPlanVo vo);

    int insert(TProdPlan tProdPlan);

    int insertBatch(List<TProdPlan> tProdPlans);

    int update(TProdPlan tProdPlan);

    List<TProdPlan> findAllList();

    int updateBatch(List<TProdPlan> updateList);
}