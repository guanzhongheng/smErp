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
    ProductVo get(Long id);

    List<ProductVo> findList(TProduct tProduct);

    List<ProductVo> findAllList();

    int insert(TProduct tProduct);

    int insertBatch(List<TProduct> tProducts);

    /**
     * @Description: 保存产品信息
     * @Param: [product]
     * @return: int
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/8/2 4:05 PM
     */
    int save(TProduct product);

    int update(TProduct tProduct);

    int delete(TProduct tProduct);

    List<ProductVo> findPage(Page<ProductVo> tProductPage, TProduct tProduct);

    boolean prodCodeIsExistence(String code);


}
