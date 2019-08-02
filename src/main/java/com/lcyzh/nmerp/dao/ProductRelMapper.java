package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.ProductRel;

public interface ProductRelMapper {

   ProductRel selectByPrimaryId(String customCode);

   int insert(ProductRel productRel);

   int deleteByPrimaryId(String customCode);
}
