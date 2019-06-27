package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.TProduct;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
@Repository
public interface TProductMapper {

    TProduct get(String id);

    List<TProduct> findList(TProduct tProduct);

    List<TProduct> findAllList();

    int insert(TProduct tProduct);

    int insertBatch(List<TProduct> tProducts);

    int update(TProduct tProduct);

    int delete(TProduct tProduct);

}