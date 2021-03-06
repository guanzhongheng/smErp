package com.lcyzh.nmerp.service;

import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.model.vo.OrderAddBatchVo;
import com.lcyzh.nmerp.model.vo.OrderAddModifyVo;
import com.lcyzh.nmerp.model.vo.OrderItemVo;
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
    List<OrderItemVo> findItemsByOrdCode(String ordCode);

    List<OrderItemVo> findItemsByOrdCodeForPrint(String ordCode);


    /**
     * @Description: 多条件分页查询
     * @Param: [page, order]
     * @return: com.lcyzh.nmerp.common.persistence.Page<com.lcyzh.nmerp.model.vo.OrderQueryVo>
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 10:53 AM
     */
    List<OrderQueryVo> findPage(Page<OrderQueryVo> page, OrderQueryVo order);

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
     * @Description: 手录订单
     * @Param: [ordAddModifyVo]
     * @return: int
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/4 11:22 AM
     */
    int save(OrderAddModifyVo ordAddModifyVo);

    /**
     * @Description: 根据订单号查询可修改信息
     * @Param: [ordCode]
     * @return: com.lcyzh.nmerp.model.vo.OrderAddModifyVo
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/4 1:39 PM
     */
    OrderAddModifyVo findModifyInfoByOrdCode(String ordCode);

    /**
     * 订单明细添加
     */
    int save(List<OrderItemVo> list);

    /**
     * 订单明细添加
     */
    int updatePrice(List<OrderItemVo> list);

    /**
     * @Description: 订单审批
     * @Param: ordCode：订单编号
     * ordCode: state 0-审批通过 1-审批不通过
     */
    int orderAssign(String ordCode, int state);

    /**
     * 订单删除
     */
    int detele(String ordCode);

    /**
     * @Description: 根据订单编号查订单信息
     * @Param: [ordCode]
     * @return: com.lcyzh.nmerp.entity.TOrder
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/8/2 12:01 AM
     */
    OrderQueryVo findByOrdeCode(String ordCode);



}
