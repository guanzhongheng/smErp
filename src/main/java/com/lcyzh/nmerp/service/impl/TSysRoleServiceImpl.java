package com.lcyzh.nmerp.service.impl;

import com.lcyzh.nmerp.dao.TSysRoleMapper;
import com.lcyzh.nmerp.entity.TSysRole;
import com.lcyzh.nmerp.service.TSysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Project :
 * @Description :
 * @Author :
 * @Iteration :
 * @Date :
 * @ModificationHistory Who          When          What
 */
@Service
public class TSysRoleServiceImpl implements TSysRoleService {
    @Autowired
    private TSysRoleMapper sysRoleMapper;

    @Override
    public List<TSysRole> findByUserId(Integer userId) {
        return sysRoleMapper.findByUserId(userId);
    }
}
