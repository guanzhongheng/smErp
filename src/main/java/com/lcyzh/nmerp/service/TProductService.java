package com.lcyzh.nmerp.service;

import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.entity.TProduct;
import com.lcyzh.nmerp.model.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
public interface TProductService {
    ProductVo get(String id);

    List<ProductVo> findList(TProduct tProduct);

    List<ProductVo> findAllList();

    int insert(TProduct tProduct);

    int insertBatch(List<TProduct> tProducts);

    int update(TProduct tProduct);

    int delete(TProduct tProduct);

    Page<ProductVo> findPage(Page<ProductVo> tProductPage, TProduct tProduct);
}
