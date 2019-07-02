package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.Customer;
import com.lcyzh.nmerp.model.vo.CustomerQueryVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
@Repository
public interface TCustomerMapper {

    Customer findByCusName(String cusName);

    List<CustomerQueryVo> findList(CustomerQueryVo tCustomer);

    int insert(Customer tCustomer);

    int insertBatch(List<Customer> tCustomers);

    int update(Customer tCustomer);

    int updateBatch(List<Customer> cusList);
}