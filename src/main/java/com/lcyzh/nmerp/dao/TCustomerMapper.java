package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
@Repository
public interface TCustomerMapper {

    Customer get(String id);

    Customer findByCusName(String cusName);

    List<Customer> findList(Customer tCustomer);

    List<Customer> findAllList();

    int insert(Customer tCustomer);

    int insertBatch(List<Customer> tCustomers);

    int update(Customer tCustomer);

    int delete(Customer tCustomer);

}