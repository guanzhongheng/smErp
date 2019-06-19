package com.lcyzh.nmerp.service.impl;

import com.lcyzh.nmerp.dao.TCustomerMapper;
import com.lcyzh.nmerp.entity.TCustomer;
import com.lcyzh.nmerp.service.TCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
@Service
public class TCustomerServiceImpl implements TCustomerService{
    @Autowired
    private TCustomerMapper tCustomerMapper;

    @Override
    public TCustomer get(String id){
        return tCustomerMapper.get(id);
    }

    @Override
    public List<TCustomer> findList(TCustomer tCustomer) {
        return tCustomerMapper.findList(tCustomer);
    }

    @Override
    public List<TCustomer> findAllList() {
        return tCustomerMapper.findAllList();
    }

    @Override
    public int insert(TCustomer tCustomer) {
        return tCustomerMapper.insert(tCustomer);
    }

    @Override
    public int insertBatch(List<TCustomer> tCustomers){
        return tCustomerMapper.insertBatch(tCustomers);
    }

    @Override
    public int update(TCustomer tCustomer) {
        return tCustomerMapper.update(tCustomer);
    }

    @Override
    public int delete(TCustomer tCustomer) {
        return tCustomerMapper.delete(tCustomer);
    }

}
