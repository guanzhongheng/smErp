package com.lcyzh.nmerp.service;

import com.lcyzh.nmerp.entity.TSysRole;

import java.util.List;

public interface TSysRoleService {

    List<TSysRole> findByUserId(Integer userId);
}
