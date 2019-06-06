package com.lcyzh.nmerp.service;

import com.lcyzh.nmerp.entity.TProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
public interface TProductService {
    TProduct get(String id);

    List<TProduct> findList(TProduct tProduct);

    List<TProduct> findAllList();

    int insert(TProduct tProduct);

    int insertBatch(List<TProduct> tProducts);

    int update(TProduct tProduct);

    int delete(TProduct tProduct);

}
