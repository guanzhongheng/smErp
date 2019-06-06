package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.TCustomer;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
public interface TCustomerMapper {

    TCustomer get(String id);

    List<TCustomer> findList(TCustomer tCustomer);

    List<TCustomer> findAllList();

    int insert(TCustomer tCustomer);

    int insertBatch(List<TCustomer> tCustomers);

    int update(TCustomer tCustomer);

    int delete(TCustomer tCustomer);

}