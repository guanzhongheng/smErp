package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.TCustomer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
@Repository
public interface TCustomerMapper {

    TCustomer get(String id);

    TCustomer findByCusName(String cusName);

    List<TCustomer> findList(TCustomer tCustomer);

    List<TCustomer> findAllList();

    int insert(TCustomer tCustomer);

    int insertBatch(List<TCustomer> tCustomers);

    int update(TCustomer tCustomer);

    int delete(TCustomer tCustomer);

}