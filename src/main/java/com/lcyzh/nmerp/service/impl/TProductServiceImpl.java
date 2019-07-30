package com.lcyzh.nmerp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.constant.Constants;
import com.lcyzh.nmerp.controller.system.util.SysDictUtils;
import com.lcyzh.nmerp.dao.TProductMapper;
import com.lcyzh.nmerp.entity.TProduct;
import com.lcyzh.nmerp.entity.sys.Dict;
import com.lcyzh.nmerp.model.vo.ProductVo;
import com.lcyzh.nmerp.service.TProductService;
import com.lcyzh.nmerp.utils.DictUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
* Author ljk
* Date  2019-06-06
*/
@Service
public class TProductServiceImpl implements TProductService{
    @Autowired
    private TProductMapper tProductMapper;

    @Override
    public ProductVo get(String id){
        TProduct product = tProductMapper.get(id);
        ProductVo vo = new ProductVo();
        BeanUtils.copyProperties(product, vo);
        vo.setProdCgyCodeValue(DictUtils.getDictValueMaps().get(vo.getProdCgyCode()));
        vo.setProdVarietyValue(DictUtils.getDictValueMaps().get(vo.getProdVariety()));
        vo.setProdPriceTypeValue(DictUtils.getDictValueMaps().get(vo.getProdPriceType()));
        vo.setProdUnitValue(DictUtils.getDictValueMaps().get(vo.getProdUnit()));
        return vo;
    }

    @Override
    public List<ProductVo> findList(TProduct tProduct) {
        List<TProduct> list = tProductMapper.findList(tProduct);
        return productConversion(list);
    }

    @Override
    public List<ProductVo> findAllList() {
        List<TProduct> products = tProductMapper.findAllList();
        return productConversion(products);
    }

    private List<ProductVo> productConversion(List<TProduct> products) {
        List<ProductVo> list = new ArrayList<>(products.size());
        if(!products.isEmpty()) {
            list = products.stream().map(vo->{
                ProductVo productVo = new ProductVo();
                BeanUtils.copyProperties(vo, productVo);
                productVo.setProdCgyCodeValue(DictUtils.getDictValueMaps().get(vo.getProdCgyCode()));
                productVo.setProdVarietyValue(DictUtils.getDictValueMaps().get(vo.getProdVariety()));
                productVo.setProdPriceTypeValue(DictUtils.getDictValueMaps().get(vo.getProdPriceType()));
                productVo.setProdUnitValue(DictUtils.getDictValueMaps().get(vo.getProdUnit()));
                productVo.setProdColorValue(SysDictUtils.getDictLabel(vo.getProdColor(), Constants.PROD_COLOR, ""));
                return productVo;
            }).collect(Collectors.toList());
        }
        return list;
    }

    @Override
    public int insert(TProduct tProduct) {
        tProduct.setCreateTime(new Date());
        return tProductMapper.insert(tProduct);
    }

    @Override
    public int insertBatch(List<TProduct> tProducts){
        return tProductMapper.insertBatch(tProducts);
    }

    @Override
    public int update(TProduct tProduct) {
        return tProductMapper.update(tProduct);
    }

    @Override
    public int delete(TProduct tProduct) {
        return tProductMapper.delete(tProduct);
    }

    @Override
    public Page<ProductVo> findPage(Page<ProductVo> page, TProduct tProduct) {
        PageHelper.startPage(page.getPageNo(),page.getPageSize());
        List<TProduct> list = tProductMapper.findList(tProduct);
        List<ProductVo> vos = productConversion(list);
        PageInfo<TProduct> p = new PageInfo<>(list);
        page.setCount(p.getTotal());
        page.setList(vos);
        return page;
    }

}
