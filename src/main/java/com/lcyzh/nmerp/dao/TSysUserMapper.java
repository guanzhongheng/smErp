package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.TSysUser;
import org.springframework.stereotype.Repository;

@Repository
public interface TSysUserMapper {

    TSysUser findByUserName(String username);
}
