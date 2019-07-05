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

    List<TProdPlanDetail> findList(TProdPlanDetail tProdPlanDetail);

    int insert(TProdPlanDetail tProdPlanDetail);

    int insertBatch(List<TProdPlanDetail> tProdPlanDetails);

    int update(TProdPlanDetail tProdPlanDetail);


}
