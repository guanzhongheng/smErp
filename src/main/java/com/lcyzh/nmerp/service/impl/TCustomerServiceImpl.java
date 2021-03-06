package com.lcyzh.nmerp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.constant.Constants;
import com.lcyzh.nmerp.dao.*;
import com.lcyzh.nmerp.entity.*;
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

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    @Autowired
    private CusFollowDetailMapper cusFollowDetailMapper;


    @Override
    public List<CustomerQueryVo> findPage(Page<CustomerQueryVo> page, CustomerQueryVo vo) {
        PageHelper.startPage(page.getPageNo(),page.getPageSize());
        List<CustomerQueryVo> listPo = tCustomerMapper.findList(vo);
        if (listPo != null && !listPo.isEmpty()) {
            listPo.forEach(po -> {
                po.setCusGradeValue(DictUtils.getValueByDictKey(po.getCusGrade()));
                po.setCusSourceValue(DictUtils.getValueByDictKey(po.getCusSource()));
                po.setCusStatusValue(DictUtils.getValueByDictKey(po.getCusStatus()));
            });
        }

        PageInfo<CustomerQueryVo> pageInfo = new PageInfo<>(listPo);
        page.setTotal(pageInfo.getTotal());
        return listPo;
    }


    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    @Override
    public int save(CustomerAddModifyVo vo) {
        int res = -1;
        if (vo != null) {
            //校验
            if(vo.getCusStatus().equals(Constants.CUS_STATUS_FLLOW)&&vo.getEmpCode()==null){
                return res;
            }
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
                            if(res>0){
                                CusFollowDetail followDetail = new CusFollowDetail();
                                followDetail.setCusCode(cusCode);
                                followDetail.setEmpCode(vo.getFollowEmpCode());
                                followDetail.setFollowTime(current);
                                followDetail.setCreateTime(current);
                                followDetail.setFollowDetail(vo.getFollowDetail());
                                cusFollowDetailMapper.insert(followDetail);
                            }
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
        customer.setCusAddress(vo.getCusAddress());
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

    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    @Override
    public int addAttributor(String cusIds, String empCode, String remark) {
        int res = -1;
        if(StringUtils.isBlank(cusIds) || StringUtils.isBlank(empCode)){
            return  res;
        }
        String[] cusIdArray = cusIds.split(",");
        List<String> list = Arrays.stream(cusIdArray).filter(arr -> StringUtils.isNotBlank(arr)).collect(Collectors.toList());
        Date current = new Date();
        if(list!=null&&!list.isEmpty()){
            List<Customer> customerList = new ArrayList<>(list.size());
            List<CusEmpRel> cusEmpRels = new ArrayList<>(list.size());
            list.forEach(str->{
                Customer customer = new Customer();
                customer.setCusCode(str);
                customer.setCusStatus(Constants.CUS_STATUS_FLLOW);
                customer.setUpdateTime(current);
                customerList.add(customer);
                CusEmpRel cusEmpRel = new CusEmpRel();
                cusEmpRel.setEmpCode(empCode);
                cusEmpRel.setCusCode(str);
                cusEmpRel.setCreateTime(current);
                cusEmpRels.add(cusEmpRel);
            });
            tCustomerMapper.updateBatch(customerList);
            res = cusEmpRelMapper.insertBatch(cusEmpRels);
        }
        return res;
    }


    @Override
    public CustomerAddModifyVo findModifyInfoByCusCode(String cusCode) {
        return tCustomerMapper.findModifyInfoByCusCode(cusCode);
    }
}
