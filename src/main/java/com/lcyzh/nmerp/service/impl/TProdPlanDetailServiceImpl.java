package com.lcyzh.nmerp.service.impl;

import com.lcyzh.nmerp.dao.TProdPlanDetailMapper;
import com.lcyzh.nmerp.entity.TProdPlanDetail;
import com.lcyzh.nmerp.service.TProdPlanDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
@Service
public class TProdPlanDetailServiceImpl implements TProdPlanDetailService{
    @Autowired
    private TProdPlanDetailMapper tProdPlanDetailMapper;

    @Override
    public List<TProdPlanDetail> findListByProdPlanCode(String prodPlanCode) {
        return tProdPlanDetailMapper.findListByProdPlanCode(prodPlanCode);
    }

    @Override
    public int updateByIds(String id) {
        return tProdPlanDetailMapper.updateByIds(Arrays.asList(id.split(",")));
    }


    //@Override
    //public List<TProdPlanDetail> findList(TProdPlanDetail tProdPlanDetail) {
    //    return tProdPlanDetailMapper.findList(tProdPlanDetail);
    //}
    //
    //@Override
    //public int insert(TProdPlanDetail tProdPlanDetail) {
    //    return tProdPlanDetailMapper.insert(tProdPlanDetail);
    //}
    //
    //@Override
    //public int insertBatch(List<TProdPlanDetail> tProdPlanDetails){
    //    return tProdPlanDetailMapper.insertBatch(tProdPlanDetails);
    //}
    //
    //@Override
    //public int update(TProdPlanDetail tProdPlanDetail) {
    //    return tProdPlanDetailMapper.update(tProdPlanDetail);
    //}

}
