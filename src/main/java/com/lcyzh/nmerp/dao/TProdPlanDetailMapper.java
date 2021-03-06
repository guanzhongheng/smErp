package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.TProdPlanDetail;
import com.lcyzh.nmerp.model.vo.ProdPlanDetailVo;
import com.lcyzh.nmerp.model.vo.ProdPlanExportVo;
import com.lcyzh.nmerp.model.vo.ProdPlanListVo;
import com.lcyzh.nmerp.model.vo.ProduceHistoryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
@Repository
public interface TProdPlanDetailMapper {

    TProdPlanDetail findById(Long id);

    List<ProdPlanDetailVo> findList(ProdPlanDetailVo vo);

    int insert(TProdPlanDetail tProdPlanDetail);

    int insertBatch(List<TProdPlanDetail> tProdPlanDetails);

    int update(TProdPlanDetail tProdPlanDetail);

    List<TProdPlanDetail> findListByProdPlanCode(String prodPlanCode);

    List<TProdPlanDetail> findListBySections(ProdPlanExportVo exportVo);

    int delete(Long id);
    int updateByIds(@Param("ids") List<String> ids,
                    @Param("thresholdUp") Double thresholdUp,
                    @Param("thresholdDown") Double thresholdDown);

    List<TProdPlanDetail> findByIds(@Param("ids") List<String> ids);

    List<TProdPlanDetail> findByProdPlanCode(@Param("code") String code);

    List<TProdPlanDetail> findListByProdPlanCodes(ProdPlanListVo vo);

    List<ProdPlanDetailVo> getTaskDetailInfos(@Param("ids") List<String> ids);

    int updateNumForDelete(String ordCode);

    int deleteForOrdCode(String ordCode);

    ProduceHistoryVo getProdInfobybarCode(@Param("barCode") String barCode);
}