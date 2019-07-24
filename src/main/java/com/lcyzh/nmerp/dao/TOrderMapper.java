package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.TOrder;
import com.lcyzh.nmerp.model.vo.OrderAddModifyVo;
import com.lcyzh.nmerp.model.vo.OrderQueryVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author ljk
 * Date  2019-06-06
 */
@Repository
public interface TOrderMapper {

    OrderQueryVo findByPrimaryKey(String ordCode);

    List<OrderQueryVo> findList(OrderQueryVo tOrder);

    List<TOrder> findAllList();

    int insert(TOrder tOrder);

    int insertBatch(List<TOrder> tOrders);

    int update(TOrder tOrder);

    int delete(String tOrder);

    OrderAddModifyVo findModifyInfoByOrdCode(String ordCode);

    int updateBatchOutNumByOrdCode(List<TOrder> orders);
}