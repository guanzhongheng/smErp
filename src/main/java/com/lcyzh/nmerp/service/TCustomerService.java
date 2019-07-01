package com.lcyzh.nmerp.service;

import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.entity.Customer;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
public interface TCustomerService {

    List<Customer> findList(Customer tCustomer);

    Page<Customer> findPage(Page<Customer> page,Customer customer);

    int insert(Customer tCustomer);

    int insertBatch(List<Customer> tCustomers);

    int update(Customer tCustomer);

    int delete(Customer tCustomer);

}
