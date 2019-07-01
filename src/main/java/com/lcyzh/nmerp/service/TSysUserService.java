package com.lcyzh.nmerp.service;

import com.lcyzh.nmerp.entity.TSysUser;

public interface TSysUserService {


    TSysUser findByUserName(String username);
}
