package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.TProduct;
import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
@Repository
public interface TProductMapper {

    TProduct get(Long id);

    List<TProduct> findList(TProduct tProduct);

    List<TProduct> findAllList();

    int insert(TProduct tProduct);

    int insertBatch(List<TProduct> tProducts);

    int update(TProduct tProduct);

    int delete(TProduct tProduct);

    TProduct findByUqKey(@Param("prodCgyCode") Long prodCgyCode,@Param("prodVariety") Long prodVariety, @Param("prodColor") String prodColor);

    List<TProduct> findListByCodes(List<String> codes);
}