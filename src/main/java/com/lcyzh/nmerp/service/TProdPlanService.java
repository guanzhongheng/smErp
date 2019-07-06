package com.lcyzh.nmerp.service;

import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.entity.TProdPlan;
import com.lcyzh.nmerp.entity.TProdPlanDetail;
import com.lcyzh.nmerp.model.vo.OrderItemAssignVo;
import com.lcyzh.nmerp.model.vo.OrderItemVo;
import com.lcyzh.nmerp.model.vo.ProdPlanDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
public interface TProdPlanService {

    /**
     * @Description: 根据产品计划编号查找产品计划信息
     * @Param: [prodPlanCode]
     * @return: com.lcyzh.nmerp.entity.TProdPlan
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/4 10:54 PM
     */
    TProdPlan findByProdPanCode(String prodPlanCode);


    /**
     * @Description: 根据订单编号查找产品计划信息
     * @Param: [prodPlanCode]
     * @return: com.lcyzh.nmerp.entity.TProdPlan
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/4 10:54 PM
     */
    TProdPlan findByOrdCode(String ordCode);

    /**
     * @Description: 多条件查看产品计划列表
     * @Param: [tProdPlan]
     * @return: java.util.List<com.lcyzh.nmerp.entity.TProdPlan>
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/4 10:54 PM
     */
    Page<ProdPlanDetailVo> findPage(Page<ProdPlanDetailVo> page,ProdPlanDetailVo vo);

    /**
     * @Description: 保存产品计划信息
     * @Param: [tProdPlan]
     * @return: int
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/4 10:55 PM
     */
    int save(TProdPlan tProdPlan);

    /**
     * @Description: 创建生产计划
     * @Param: [ordCode, items]
     * @return: int
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/4 11:32 PM
     */
    int createProdPlan(String ordCode,String ordDeliveryDate, List<OrderItemVo> items);


    /**
     * @Description: 调整生产计划完成日期：当itemId为null时，更新该订单号下所有，否则更新一条
     * @Param: [prodPlanCode, itemId, eaListDate, latestDate]
     * @return: int
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/5 12:17 AM
     */
    int adjustProdPlanDate(String prodPlanCode,Long itemId,String eaListDate,String latestDate);


    /**
     * @Description: 产品计划执行分配
     * @Param: [voList]
     * @return: int
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/5 12:45 AM
     */
    int prodPlanExeAssign(List<OrderItemAssignVo> voList);

    /**
     * @Description: 根据产品计划编号获取产品计划详情
     * @Param: [planCode]
     * @return: java.util.List<com.lcyzh.nmerp.entity.TProdPlanDetail>
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/5 12:46 AM
     */
    List<TProdPlanDetail> findByPlanCode(String planCode);


}
