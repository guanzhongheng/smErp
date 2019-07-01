package com.lcyzh.nmerp.service;

import com.lcyzh.nmerp.entity.TSysMenu;

import java.util.List;

public interface TSysMenuService {

    List<TSysMenu> findByUserId(Integer userId);
}
