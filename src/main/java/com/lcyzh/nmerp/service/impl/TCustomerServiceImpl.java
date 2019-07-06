package com.lcyzh.nmerp.service.impl;

import com.github.pagehelper.PageHelper;
import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.constant.Constants;
import com.lcyzh.nmerp.dao.CusEmpRelMapper;
import com.lcyzh.nmerp.dao.CusFollowMapper;
import com.lcyzh.nmerp.dao.PrimaryContactMapper;
import com.lcyzh.nmerp.dao.TCustomerMapper;
import com.lcyzh.nmerp.entity.CusEmpRel;
import com.lcyzh.nmerp.entity.CusFollow;
import com.lcyzh.nmerp.entity.Customer;
import com.lcyzh.nmerp.entity.PrimaryContact;
import com.lcyzh.nmerp.model.vo.CustomerAddModifyVo;
import com.lcyzh.nmerp.model.vo.CustomerQueryVo;
import com.lcyzh.nmerp.model.vo.CustomerUpdateVo;
import com.lcyzh.nmerp.service.TCustomerService;
import com.lcyzh.nmerp.utils.DictUtils;
import com.lcyzh.nmerp.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author ljk
 * Date  2019-06-06
 */
@Service
public class TCustomerServiceImpl implements TCustomerService {
    @Autowired
    private TCustomerMapper tCustomerMapper;
    @Autowired
    private PrimaryContactMapper primaryContactMapper;
    @Autowired
    private CusEmpRelMapper cusEmpRelMapper;
    @Autowired
    private CusFollowMapper cusFollowMapper;


    @Override
    public Page<CustomerQueryVo> findPage(Page<CustomerQueryVo> page, CustomerQueryVo vo) {
        PageHelper.startPage(vo.getPageNo(),vo.getPageSize());
        List<CustomerQueryVo> listPo = tCustomerMapper.findList(vo);
        if (listPo != null && !listPo.isEmpty()) {
            listPo.forEach(po -> {
                po.setCusGradeValue(DictUtils.getValueByDictKey(po.getCusGrade()));
                po.setCusSourceValue(DictUtils.getValueByDictKey(po.getCusSource()));
                po.setCusStatusValue(DictUtils.getValueByDictKey(po.getCusStatus()));
            });
        }
        page.setList(listPo);
        return page;
    }


    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    @Override
    public int save(CustomerAddModifyVo vo) {
        int res = -1;
        if (vo != null) {
            Date current = new Date();
            Customer customer = buidCustomerFromVo(vo, current);
            if (StringUtils.isNotEmpty(vo.getCusCode())) {
                res = tCustomerMapper.update(customer);
                if (res > 0) {
                    PrimaryContact primaryContact = buidPrimaryContractor(vo, vo.getCusCode(), current);
                    res = primaryContactMapper.update(primaryContact);
                }
            } else {
                String cusCode = StringUtils.genFixPreFixStr(Constants.CUS_PRE_FIX);
                customer.setCusCode(cusCode);
                res = tCustomerMapper.insert(customer);
                if (res > 0) {
                    PrimaryContact primaryContact = buidPrimaryContractor(vo, cusCode, current);
                    res = primaryContactMapper.insert(primaryContact);
                    if (res > 0) {
                        CusEmpRel cusEmpRel = buildCusEmpRelFromVo(vo, cusCode, current);
                        res = cusEmpRelMapper.insert(cusEmpRel);
                        if (res > 0) {
                            CusFollow cusFollow = new CusFollow();
                            cusFollow.setCusCode(cusCode);
                            cusFollow.setLatestFollowTime(current);
                            cusFollow.setCreateTime(current);
                            res = cusFollowMapper.insert(cusFollow);
                        }
                    }
                }
            }
        }

        return res;
    }

    private CusEmpRel buildCusEmpRelFromVo(CustomerAddModifyVo vo, String cusCode, Date current) {
        CusEmpRel cusEmpRel = new CusEmpRel();
        cusEmpRel.setCusCode(cusCode);
        cusEmpRel.setEmpCode(vo.getEmpCode());
        cusEmpRel.setCreateTime(current);
        cusEmpRel.setUpdateTime(current);
        return cusEmpRel;
    }

    private PrimaryContact buidPrimaryContractor(CustomerAddModifyVo vo, String cusCode, Date current) {
        PrimaryContact primaryContact = new PrimaryContact();
        primaryContact.setCusCode(cusCode);
        primaryContact.setContactAddress(vo.getPrimaryContactorAddress());
        primaryContact.setContactBirth(vo.getPrimaryContactorBirth());
        primaryContact.setContactEmail(vo.getPrimaryContactorEmail());
        primaryContact.setContactName(vo.getPrimaryContactorName());
        primaryContact.setContactPhone(vo.getPrimaryContactorPhone());
        primaryContact.setContactRole(vo.getPrimaryContactorRole());
        primaryContact.setContactSex(vo.getPrimaryContactorSex());
        primaryContact.setFixedPhone(vo.getPrimaryContactorFixedPhone());
        primaryContact.setDepartment(vo.getPrimaryContactorDepartment());
        primaryContact.setRemark(vo.getPrimaryContactorRemark());
        primaryContact.setCreateTime(current);
        primaryContact.setUpdateTime(current);
        return primaryContact;
    }


    /**
     * @Description: Vo转换实体po
     * @Param: [vo]
     * @return: com.lcyzh.nmerp.entity.Customer
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/1 4:18 PM
     */
    private Customer buidCustomerFromVo(CustomerAddModifyVo vo, Date current) {
        Customer customer = new Customer();
        customer.setCusCode(vo.getCusCode());
        customer.setCusSource(vo.getCusSource());
        customer.setCusName(vo.getCusName());
        customer.setCusGrade(vo.getCusGrade());
        customer.setCusType(vo.getCusType());
        customer.setIndustry(vo.getIndustry());
        customer.setRemark(vo.getRemarks());
        customer.setCusStatus(vo.getCusStatus());
        customer.setUpdateTime(current);
        customer.setCreateTime(current);
        return customer;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    @Override
    public int updateBatch(CustomerUpdateVo vo) {
        int res = -1;
        if (vo != null && vo.getCusCodes() != null) {
            String[] cusCodes = vo.getCusCodes().split(",");
            if (cusCodes != null && cusCodes.length > 0) {
                Date current = new Date();
                List<String> cusCodeList = Arrays.asList(cusCodes);
                if (vo.getEmpCode() != null) {
                    //转移客户
                    List<CusEmpRel> cusEmpRelList = cusCodeList.stream().map(cusCode -> {
                        CusEmpRel cusEmpRel = new CusEmpRel();
                        cusEmpRel.setCusCode(cusCode);
                        cusEmpRel.setEmpCode(vo.getEmpCode());
                        cusEmpRel.setUpdateTime(current);
                        return cusEmpRel;
                    }).collect(Collectors.toList());
                    res = cusEmpRelMapper.updateBatch(cusEmpRelList);
                } else {
                    res = cusEmpRelMapper.delete(cusCodeList);
                    if (res > 0) {
                        List<Customer> cusList = cusCodeList.stream().map(cusCode -> {
                            Customer customer = new Customer();
                            customer.setCusCode(cusCode);
                            customer.setCusStatus(Constants.CUS_STATUS_UNFLLOW);
                            customer.setUpdateTime(current);
                            return customer;
                        }).collect(Collectors.toList());

                        res = tCustomerMapper.updateBatch(cusList);
                    }
                }

            }
        }
        return res;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    @Override
    public int delete(List<String> cusCodeList) {
        int res = -1;
        if (cusCodeList != null && !cusCodeList.isEmpty()) {
            List<Customer> cusList = cusCodeList.stream().map(cusCode -> {
                Customer customer = new Customer();
                customer.setCusCode(cusCode);
                customer.setCusStatus(Constants.CUS_STATUS_BH);
                customer.setUpdateTime(new Date());
                return customer;
            }).collect(Collectors.toList());

            res = tCustomerMapper.updateBatch(cusList);

        }
        return res;
    }


    @Override
    public CustomerAddModifyVo findModifyInfoByCusCode(String cusCode) {
        return tCustomerMapper.findModifyInfoByCusCode(cusCode);
    }
}
