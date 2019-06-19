package com.lcyzh.nmerp.service.impl;

import com.lcyzh.nmerp.dao.TOrderItemMapper;
import com.lcyzh.nmerp.entity.TOrderItem;
import com.lcyzh.nmerp.service.TOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
@Service
public class TOrderItemServiceImpl implements TOrderItemService{
    @Autowired
    private TOrderItemMapper tOrderItemMapper;

    @Override
    public TOrderItem get(String id){
        return tOrderItemMapper.get(id);
    }

    @Override
    public List<TOrderItem> findList(TOrderItem tOrderItem) {
        return tOrderItemMapper.findList(tOrderItem);
    }

    @Override
    public List<TOrderItem> findAllList() {
        return tOrderItemMapper.findAllList();
    }

    @Override
    public int insert(TOrderItem tOrderItem) {
        return tOrderItemMapper.insert(tOrderItem);
    }

    @Override
    public int insertBatch(List<TOrderItem> tOrderItems){
        return tOrderItemMapper.insertBatch(tOrderItems);
    }

    @Override
    public int update(TOrderItem tOrderItem) {
        return tOrderItemMapper.update(tOrderItem);
    }

    @Override
    public int delete(TOrderItem tOrderItem) {
        return tOrderItemMapper.delete(tOrderItem);
    }

}
