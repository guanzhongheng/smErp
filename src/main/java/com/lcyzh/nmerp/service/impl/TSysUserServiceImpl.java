package com.lcyzh.nmerp.service.impl;

import com.lcyzh.nmerp.dao.TSysUserMapper;
import com.lcyzh.nmerp.entity.TSysUser;
import com.lcyzh.nmerp.service.TSysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Project :
 * @Description :
 * @Author :
 * @Iteration :
 * @Date :
 * @ModificationHistory Who          When          What
 */
@Service
public class TSysUserServiceImpl implements TSysUserService {
    @Autowired
    private TSysUserMapper sysUserMapper;
    @Override
    public TSysUser findByUserName(String username) {
        return null;
    }
}
