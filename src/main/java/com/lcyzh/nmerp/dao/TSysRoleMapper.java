package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.TSysRole;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TSysRoleMapper {

    List<TSysRole> findByUserId(Integer userId);
}
