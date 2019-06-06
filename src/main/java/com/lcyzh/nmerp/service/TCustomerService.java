package com.lcyzh.nmerp.service;

import com.lcyzh.nmerp.entity.TCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
public interface TCustomerService {
    TCustomer get(String id);

    List<TCustomer> findList(TCustomer tCustomer);

    List<TCustomer> findAllList();

    int insert(TCustomer tCustomer);

    int insertBatch(List<TCustomer> tCustomers);

    int update(TCustomer tCustomer);

    int delete(TCustomer tCustomer);

}
