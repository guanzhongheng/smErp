package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.TProdPlanDetail;
import com.lcyzh.nmerp.model.vo.ProdPlanDetailVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
@Repository
public interface TProdPlanDetailMapper {

    TProdPlanDetail findById(String ordItemId);

    List<ProdPlanDetailVo> findList(ProdPlanDetailVo vo);

    int insert(TProdPlanDetail tProdPlanDetail);

    int insertBatch(List<TProdPlanDetail> tProdPlanDetails);

    int update(TProdPlanDetail tProdPlanDetail);

    List<TProdPlanDetail> findListByProdPlanCode(String prodPlanCode);

    int updateByIds(List<String> ids);

    int deleteByCode(String prodPlanCode);
}