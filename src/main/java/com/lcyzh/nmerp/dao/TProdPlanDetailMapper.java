package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.TProdPlanDetail;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
public interface TProdPlanDetailMapper {

    TProdPlanDetail get(String id);

    List<TProdPlanDetail> findList(TProdPlanDetail tProdPlanDetail);

    List<TProdPlanDetail> findAllList();

    int insert(TProdPlanDetail tProdPlanDetail);

    int insertBatch(List<TProdPlanDetail> tProdPlanDetails);

    int update(TProdPlanDetail tProdPlanDetail);

    int delete(TProdPlanDetail tProdPlanDetail);

}