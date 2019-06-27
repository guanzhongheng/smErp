package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.TProdPlanDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
@Repository
public interface TProdPlanDetailMapper {

    TProdPlanDetail get(String id);

    List<TProdPlanDetail> findList(TProdPlanDetail tProdPlanDetail);

    List<TProdPlanDetail> findAllList();

    int insert(TProdPlanDetail tProdPlanDetail);

    int insertBatch(List<TProdPlanDetail> tProdPlanDetails);

    int update(TProdPlanDetail tProdPlanDetail);

    int delete(TProdPlanDetail tProdPlanDetail);

}