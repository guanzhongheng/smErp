package com.lcyzh.nmerp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.constant.Constants;
import com.lcyzh.nmerp.controller.system.util.SysDictUtils;
import com.lcyzh.nmerp.dao.TMachineInfoMapper;
import com.lcyzh.nmerp.dao.TProductMapper;
import com.lcyzh.nmerp.entity.TMachineInfo;
import com.lcyzh.nmerp.entity.TProduct;
import com.lcyzh.nmerp.model.vo.MachineInfoVo;
import com.lcyzh.nmerp.model.vo.ProductVo;
import com.lcyzh.nmerp.service.TMachineInfoService;
import com.lcyzh.nmerp.utils.DictUtils;
import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
* Author ljk
* Date  2019-06-06
*/
@Service
public class TMachineInfoServiceImpl implements TMachineInfoService{
    @Autowired
    private TMachineInfoMapper tMachineInfoMapper;

    @Autowired
    private TProductMapper tProductMapper;

    @Override
    public TMachineInfo findById(Long id){
        return tMachineInfoMapper.findById(id);
    }

    @Override
    public TMachineInfo getByCode(String macCode) {
        return tMachineInfoMapper.getByCode(macCode);
    }

    @Override
    public List<TMachineInfo> findList(TMachineInfo tMachineInfo) {
        return tMachineInfoMapper.findList(tMachineInfo);
    }

    @Override
    public List<TMachineInfo> findAllList() {
        return tMachineInfoMapper.findAllList();
    }

    @Override
    public int insert(TMachineInfo tMachineInfo) {
        tMachineInfo.setCreateTime(new Date());
        return tMachineInfoMapper.insert(tMachineInfo);
    }

    @Override
    public int insertBatch(List<TMachineInfo> tMachineInfos){
        return tMachineInfoMapper.insertBatch(tMachineInfos);
    }

    @Override
    public int update(TMachineInfo tMachineInfo) {
        return tMachineInfoMapper.update(tMachineInfo);
    }

    @Override
    public int delete(TMachineInfo tMachineInfo) {
        return tMachineInfoMapper.delete(tMachineInfo);
    }

    @Override
    public Page<MachineInfoVo> findPage(Page<MachineInfoVo> page, TMachineInfo tMachineInfo) {
        PageHelper.startPage(page.getPageNo(),page.getPageSize());
        List<TMachineInfo> list = tMachineInfoMapper.findList(tMachineInfo);
        List<MachineInfoVo> vos = list.stream().map(item ->{
            MachineInfoVo vo = new MachineInfoVo();
            BeanUtils.copyProperties(item, vo);
            if(!vo.getProdCodes().equals("0")) {
                List<TProduct> products = tProductMapper.findListByCodes(Arrays.asList(vo.getProdCodes().split(",")));
                List<ProductVo> productVos = products.stream().map(product->{
                    ProductVo productVo = new ProductVo();
                    BeanUtils.copyProperties(product, productVo);
                    productVo.setId("" + product.getId());
                    productVo.setProdCgyCodeValue(DictUtils.getDictValueMaps().get(product.getProdCgyCode()));
                    productVo.setProdVarietyValue(DictUtils.getDictValueMaps().get(product.getProdVariety()));
                    productVo.setProdPriceTypeValue(DictUtils.getDictValueMaps().get(product.getProdPriceType()));
                    productVo.setProdUnitValue(DictUtils.getDictValueMaps().get(product.getProdUnit()));
                    productVo.setProdColorValue(SysDictUtils.getDictLabel(product.getProdColor(), Constants.PROD_COLOR, ""));
                    return productVo;
                }).collect(Collectors.toList());
                vo.setProductVos(productVos);
            }
            return vo;
        }).collect(Collectors.toList());
        PageInfo<MachineInfoVo> p = new PageInfo<>(vos);
        page.setCount(p.getTotal());
        page.setList(vos);
        return page;
    }

}
