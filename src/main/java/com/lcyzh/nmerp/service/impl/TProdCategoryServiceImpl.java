package com.lcyzh.nmerp.service.impl;

import com.lcyzh.nmerp.dao.TProdCategoryMapper;
import com.lcyzh.nmerp.entity.TProdCategory;
import com.lcyzh.nmerp.service.TProdCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
@Service
public class TProdCategoryServiceImpl implements TProdCategoryService{
    @Autowired
    private TProdCategoryMapper tProdCategoryMapper;

    @Override
    public TProdCategory get(String id){
        return tProdCategoryMapper.get(id);
    }

    @Override
    public List<TProdCategory> findList(TProdCategory tProdCategory) {
        return tProdCategoryMapper.findList(tProdCategory);
    }

    @Override
    public List<TProdCategory> findAllList() {
        return tProdCategoryMapper.findAllList();
    }

    @Override
    public int insert(TProdCategory tProdCategory) {
        return tProdCategoryMapper.insert(tProdCategory);
    }

    @Override
    public int insertBatch(List<TProdCategory> tProdCategorys){
        return tProdCategoryMapper.insertBatch(tProdCategorys);
    }

    @Override
    public int update(TProdCategory tProdCategory) {
        return tProdCategoryMapper.update(tProdCategory);
    }

    @Override
    public int delete(TProdCategory tProdCategory) {
        return tProdCategoryMapper.delete(tProdCategory);
    }

}
