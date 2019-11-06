package com.lcyzh.nmerp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.constant.Constants;
import com.lcyzh.nmerp.controller.system.util.SysDictUtils;
import com.lcyzh.nmerp.dao.TProductMapper;
import com.lcyzh.nmerp.entity.ProductRel;
import com.lcyzh.nmerp.entity.TProduct;
import com.lcyzh.nmerp.entity.sys.Dict;
import com.lcyzh.nmerp.model.vo.ProductVo;
import com.lcyzh.nmerp.service.TProductService;
import com.lcyzh.nmerp.utils.DictUtils;
import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author ljk
 * Date  2019-06-06
 */
@Service
public class TProductServiceImpl implements TProductService {
    @Autowired
    private TProductMapper tProductMapper;

    @Override
    public ProductVo get(Long id) {
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
        if (!products.isEmpty()) {
            list = products.stream().map(vo -> {
                ProductVo productVo = new ProductVo();
                BeanUtils.copyProperties(vo, productVo);
                productVo.setId("" + vo.getId());
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
        int res = tProductMapper.insert(tProduct);
        if (res > 0) {
            DictUtils.getProdMaps().put(String.valueOf(tProduct.getProdCgyCode()) + tProduct.getProdVariety() + tProduct.getProdColor(), tProduct);
        }
        return res;
    }

    @Override
    public int insertBatch(List<TProduct> tProducts) {
        return tProductMapper.insertBatch(tProducts);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    @Override
    public int save(TProduct product) {
        if (product.getProdCode() == null) {
            return -3;
        }
        Date current = new Date();
        int res;
        if (product.getId() != null) {

           // if (po != null && po.getProdVariety().equals(product.getProdVariety()) && po.getProdCgyCode().equals(product.getProdCgyCode()) && po.getProdColor().equals(product.getProdColor())) {
                TProduct prod = new TProduct();
                prod.setId(product.getId());
                prod.setProdName(product.getProdName());
                prod.setProdGuidePrice(product.getProdGuidePrice());
                prod.setProdPriceType(product.getProdPriceType());
                prod.setProdThick(product.getProdThick());
                prod.setProdUnit(product.getProdUnit());
                prod.setProdDensity(product.getProdDensity());
                res = tProductMapper.update(prod);
                if (res > 0) {
                    TProduct po = tProductMapper.get(product.getId());
                    DictUtils.getProdMaps().put(String.valueOf(po.getProdCgyCode()) + po.getProdVariety() + po.getProdColor(), po);
                }

        } else {
            TProduct po = tProductMapper.findByUqKey(product);
            if (po != null) {
                res = -2;
            } else {
                TProduct pt = tProductMapper.findByProdCode(product.getProdCode());
                if (pt != null) {
                    return -4;
                }
                product.setCreateTime(current);
                res = tProductMapper.insert(product);
            }
            if (res > 0) {
                DictUtils.getProdMaps().put(String.valueOf(product.getProdCgyCode()) + product.getProdVariety() + product.getProdColor(), product);
            }
        }
        return res;
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
    public List<ProductVo> findPage(Page<ProductVo> page, TProduct tProduct) {
        PageHelper.startPage(page.getPageNo(), page.getPageSize());
        List<TProduct> list = tProductMapper.findList(tProduct);
        List<ProductVo> vos = productConversion(list);
        PageInfo<TProduct> p = new PageInfo<>(list);
        page.setTotal(p.getTotal());
        return vos;
    }

    @Override
    public boolean prodCodeIsExistence(String code) {
        Integer count = tProductMapper.getCntByCode(code);
        return count > 0;
    }

}
