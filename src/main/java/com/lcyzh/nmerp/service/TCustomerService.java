package com.lcyzh.nmerp.service;

import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.model.vo.CustomerAddModifyVo;
import com.lcyzh.nmerp.model.vo.CustomerQueryVo;
import com.lcyzh.nmerp.model.vo.CustomerUpdateVo;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
public interface TCustomerService {

    Page<CustomerQueryVo> findPage(Page<CustomerQueryVo> page, CustomerQueryVo customer);

    int insert(CustomerAddModifyVo tCustomer);

    int update(CustomerAddModifyVo vo);

    int updateBatch(CustomerUpdateVo vo);

    int delete(List<String> cusCodeList);

}
