package com.lcyzh.nmerp.service;

import com.lcyzh.nmerp.entity.TOrderItem;

/**
 * @Project : nm-erp
 * @Description : 订单内产品相关接口
 * @Author : wsm
 * @Iteration : 1.0
 * @Date : 2019/8/29  2:48 PM
 * @ModificationHistory Who          When          What
 * ----------   ------------- -----------------------------------
 * wsm          2019/08/29    create
 */
public interface TOrderItemService {
    TOrderItem getById(Long id);
}
