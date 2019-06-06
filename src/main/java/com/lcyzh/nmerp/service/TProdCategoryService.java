package com.lcyzh.nmerp.service;

import com.lcyzh.nmerp.entity.TProdCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
public interface TProdCategoryService {
    TProdCategory get(String id);

    List<TProdCategory> findList(TProdCategory tProdCategory);

    List<TProdCategory> findAllList();

    int insert(TProdCategory tProdCategory);

    int insertBatch(List<TProdCategory> tProdCategorys);

    int update(TProdCategory tProdCategory);

    int delete(TProdCategory tProdCategory);

}
