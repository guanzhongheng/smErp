package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.TProdCategory;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
public interface TProdCategoryMapper {

    TProdCategory get(String id);

    List<TProdCategory> findList(TProdCategory tProdCategory);

    List<TProdCategory> findAllList();

    int insert(TProdCategory tProdCategory);

    int insertBatch(List<TProdCategory> tProdCategorys);

    int update(TProdCategory tProdCategory);

    int delete(TProdCategory tProdCategory);

}