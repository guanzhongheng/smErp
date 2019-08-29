package com.lcyzh.nmerp.service;

import com.lcyzh.nmerp.dao.TOrderItemMapper;
import com.lcyzh.nmerp.entity.TOrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Project : nm-erp
 * @Description : TODO
 * @Author : wsm
 * @Iteration : 1.0
 * @Date : 2019/8/29  2:50 PM
 * @ModificationHistory Who          When          What
 * ----------   ------------- -----------------------------------
 * wsm          2019/08/29    create
 */
@Service
public class TOrderItemServiceImpl implements TOrderItemService {
    @Autowired
    private TOrderItemMapper tOrderItemMapper;
    @Override
    public TOrderItem getById(Long id) {
        return tOrderItemMapper.get(id);
    }
}
