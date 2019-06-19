package com.lcyzh.nmerp.service;

import com.lcyzh.nmerp.entity.TProdPlanDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
public interface TProdPlanDetailService {
    TProdPlanDetail get(String id);

    List<TProdPlanDetail> findList(TProdPlanDetail tProdPlanDetail);

    List<TProdPlanDetail> findAllList();

    int insert(TProdPlanDetail tProdPlanDetail);

    int insertBatch(List<TProdPlanDetail> tProdPlanDetails);

    int update(TProdPlanDetail tProdPlanDetail);

    int delete(TProdPlanDetail tProdPlanDetail);

}
