package com.lcyzh.nmerp.service;

import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.entity.TProdPlan;
import com.lcyzh.nmerp.model.vo.OrderItemVo;
import com.lcyzh.nmerp.model.vo.ProdPlanVo;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
public interface TProdPlanService {

    /**
     * 多条件查询生产计划单
     */
    List<ProdPlanVo> findPage(Page<ProdPlanVo> page, ProdPlanVo vo);

    /**
     * 生产计划单编辑（修改配方、自动下发开关设置）
     */
    int update(TProdPlan prodPlan);

    /**
     * @Description: 根据产品计划编号查找产品计划信息
     * @Param: [prodPlanCode]
     * @return: com.lcyzh.nmerp.entity.TProdPlan
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/4 10:54 PM
     */
    ProdPlanVo findByProdPanCode(String prodPlanCode);


    ProdPlanVo findByProdPanCodes(String prodPlanCodes);
    //
    //
    ///**
    // * @Description: 多条件查看产品计划列表
    // * @Param: [tProdPlan]
    // * @return: java.util.List<com.lcyzh.nmerp.entity.TProdPlan>
    // * @Author: lijinku
    // * @Iteration : 1.0
    // * @Date: 2019/7/4 10:54 PM
    // */
    //Page<ProdPlanDetailVo> findPage(Page<ProdPlanDetailVo> page,ProdPlanDetailVo vo);
    //
    ///**
    // * @Description: 保存产品计划信息
    // * @Param: [tProdPlan]
    // * @return: int
    // * @Author: lijinku
    // * @Iteration : 1.0
    // * @Date: 2019/7/4 10:55 PM
    // */
    //int save(TProdPlan tProdPlan);
    //
    /**
     * @Description: 创建生产计划
     * @Param: [ordCode, items]
     * @return: int
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/4 11:32 PM
     */
    int createProdPlan(List<OrderItemVo> items);
    //
    ///**
    // * @Description: 根据产品计划编号获取产品计划详情
    // * @Param: [planCode]
    // * @return: java.util.List<com.lcyzh.nmerp.entity.TProdPlanDetail>
    // * @Author: lijinku
    // * @Iteration : 1.0
    // * @Date: 2019/7/5 12:46 AM
    // */
    //List<TProdPlanDetail> findByPlanCode(String planCode);

}
