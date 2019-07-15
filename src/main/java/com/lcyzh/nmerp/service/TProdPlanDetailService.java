package com.lcyzh.nmerp.service;

import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.entity.TProdPlanDetail;
import com.lcyzh.nmerp.model.vo.ProdPlanDetailVo;

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

    /**
     * @Description: 机台查看生产任务列表
     *
     */
    Page<ProdPlanDetailVo> findProdTaskPage(Page<ProdPlanDetailVo> page, ProdPlanDetailVo vo);

    /**
     * @Description: 查看生产任务明细
     */
    ProdPlanDetailVo findProdTask(ProdPlanDetailVo vo);
    //List<TProdPlanDetail> findList(TProdPlanDetail tProdPlanDetail);
    //
    //int insert(TProdPlanDetail tProdPlanDetail);
    //
    //int insertBatch(List<TProdPlanDetail> tProdPlanDetails);
    //
    //int update(TProdPlanDetail tProdPlanDetail);


}
