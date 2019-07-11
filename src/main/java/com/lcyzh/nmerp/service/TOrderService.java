package com.lcyzh.nmerp.service;

import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.entity.TOrder;
import com.lcyzh.nmerp.model.vo.*;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
public interface TOrderService {

    /**
     * @Description: 根据订单号查询订单详情
     * @Param: [ordCode]
     * @return: java.util.List<com.lcyzh.nmerp.entity.TOrderItem>
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 11:16 AM
     */
    List<OrderItemVo> findByOrdCode(String ordCode);


    /**
     * @Description: 多条件分页查询
     * @Param: [page, order]
     * @return: com.lcyzh.nmerp.common.persistence.Page<com.lcyzh.nmerp.model.vo.OrderQueryVo>
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 10:53 AM
     */
    Page<OrderQueryVo> findPage(Page<OrderQueryVo> page, OrderQueryVo order);

    /**
     * @Description: 订单批量导入
     * @Param: [vo]
     * @return: int
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/4 6:06 PM
     */
    int insert(OrderAddBatchVo vo);

    /**
     * @Description: 批量录入订单
     * @Param: [voList]
     * @return: int
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 10:53 AM
     */
    //int insertBatch(List<OrderAddBatchVo> voList);
    //
    ///**
    // * @Description: 订单更新
    // * @Param: [tOrder]
    // * @return: int
    // * @Author: lijinku
    // * @Iteration : 1.0
    // * @Date: 2019/7/4 6:06 PM
    // */
    //int update(TOrder tOrder);
    //
    //int delete(TOrder tOrder);
    //
    ///**
    // * @Description: 手录订单
    // * @Param: [ordAddModifyVo]
    // * @return: int
    // * @Author: lijinku
    // * @Iteration : 1.0
    // * @Date: 2019/7/4 11:22 AM
    // */
    //int save(OrderAddModifyVo ordAddModifyVo);
    //
    ///**
    // * @Description: 根据订单号查询可修改信息
    // * @Param: [ordCode]
    // * @return: com.lcyzh.nmerp.model.vo.OrderAddModifyVo
    // * @Author: lijinku
    // * @Iteration : 1.0
    // * @Date: 2019/7/4 1:39 PM
    // */
    //OrderAddModifyVo findModifyInfoByOrdCode(String ordCode);
}
