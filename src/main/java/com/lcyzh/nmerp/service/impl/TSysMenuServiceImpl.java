package com.lcyzh.nmerp.service.impl;

import com.lcyzh.nmerp.dao.TSysMenuMapper;
import com.lcyzh.nmerp.entity.TSysMenu;
import com.lcyzh.nmerp.service.TSysMenuService;
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
public class TSysMenuServiceImpl implements TSysMenuService {
    @Autowired
    private TSysMenuMapper sysMenuMapper;

    @Override
    public List<TSysMenu> findByUserId(Integer userId) {
        return sysMenuMapper.findByUserId(userId);
    }
}
