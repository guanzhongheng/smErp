package com.lcyzh.nmerp.service.impl;

import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.dao.TCustomerMapper;
import com.lcyzh.nmerp.entity.Customer;
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
    public List<Customer> findList(Customer tCustomer) {
        return tCustomerMapper.findList(tCustomer);
    }

    @Override
    public Page<Customer> findPage(Page<Customer> page, Customer customer) {
        customer.setPage(page);
        List<Customer> list = tCustomerMapper.findList(customer);
        page.setList(list);
        return page;
    }


    @Override
    public int insert(Customer tCustomer) {
        return tCustomerMapper.insert(tCustomer);
    }

    @Override
    public int insertBatch(List<Customer> tCustomers){
        return tCustomerMapper.insertBatch(tCustomers);
    }

    @Override
    public int update(Customer tCustomer) {
        return tCustomerMapper.update(tCustomer);
    }

    @Override
    public int delete(Customer tCustomer) {
        return tCustomerMapper.delete(tCustomer);
    }

}
