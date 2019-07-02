package com.lcyzh.nmerp.service;

import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.entity.TOrder;
import com.lcyzh.nmerp.entity.TOrderItem;
import com.lcyzh.nmerp.model.vo.OrderAddModifyVo;
import com.lcyzh.nmerp.model.vo.OrderItemAssignVo;
import com.lcyzh.nmerp.model.vo.OrderQueryVo;

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
    List<TOrderItem> findByOrdCode(String ordCode);

    /**
     * @Description: 产品计划分配
     * @Param: [voList, ordCode]
     * @return: int
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 10:53 AM
     */
    int ordProduceAssign(List<OrderItemAssignVo> voList,String ordCode);

    /**
     * @Description: 多条件分页查询
     * @Param: [page, order]
     * @return: com.lcyzh.nmerp.common.persistence.Page<com.lcyzh.nmerp.model.vo.OrderQueryVo>
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 10:53 AM
     */
    Page<OrderQueryVo> findPage(Page<OrderQueryVo> page, OrderQueryVo order);

    int insert(OrderAddModifyVo vo);

    /**
     * @Description: 批量录入订单
     * @Param: [voList]
     * @return: int
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 10:53 AM
     */
    int insertBatch(List<OrderAddModifyVo> voList);

    int update(TOrder tOrder);

    int delete(TOrder tOrder);

}
