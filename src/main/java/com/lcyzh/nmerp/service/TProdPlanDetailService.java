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

    /**
     * 根据计划单号查询明细数据
     */
    List<TProdPlanDetail> findListByProdPlanCode(String prodPlanCode);

    /**
     * 批量下发生产，状态由待确认改为下发生产
     */
    int updateByIds(String id);



    //List<TProdPlanDetail> findList(TProdPlanDetail tProdPlanDetail);
    //
    //int insert(TProdPlanDetail tProdPlanDetail);
    //
    //int insertBatch(List<TProdPlanDetail> tProdPlanDetails);
    //
    //int update(TProdPlanDetail tProdPlanDetail);


}
