package com.lcyzh.nmerp.service;

import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.entity.Customer;
import com.lcyzh.nmerp.model.vo.CustomerAddModifyVo;
import com.lcyzh.nmerp.model.vo.CustomerQueryVo;
import com.lcyzh.nmerp.model.vo.CustomerUpdateVo;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
public interface TCustomerService {

    List<CustomerQueryVo> findPage(Page<CustomerQueryVo> page, CustomerQueryVo customer);

    int save(CustomerAddModifyVo tCustomer);

    int updateBatch(CustomerUpdateVo vo);

    int delete(List<String> cusCodeList);

    int addAttributor(String cusIds,String empCode,String remark);

    CustomerAddModifyVo findModifyInfoByCusCode(String cusCode);
}
