package com.lcyzh.nmerp.service.impl;

import com.lcyzh.nmerp.dao.TOrderMapper;
import com.lcyzh.nmerp.entity.TOrder;
import com.lcyzh.nmerp.service.TOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
@Service
public class TOrderServiceImpl implements TOrderService{
    @Autowired
    private TOrderMapper tOrderMapper;

    @Override
    public TOrder get(String id){
        return tOrderMapper.get(id);
    }

    @Override
    public List<TOrder> findList(TOrder tOrder) {
        return tOrderMapper.findList(tOrder);
    }

    @Override
    public List<TOrder> findAllList() {
        return tOrderMapper.findAllList();
    }

    @Override
    public int insert(TOrder tOrder) {
        return tOrderMapper.insert(tOrder);
    }

    @Override
    public int insertBatch(List<TOrder> tOrders){
        return tOrderMapper.insertBatch(tOrders);
    }

    @Override
    public int update(TOrder tOrder) {
        return tOrderMapper.update(tOrder);
    }

    @Override
    public int delete(TOrder tOrder) {
        return tOrderMapper.delete(tOrder);
    }

}
