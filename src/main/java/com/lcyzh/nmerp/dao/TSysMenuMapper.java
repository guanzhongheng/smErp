package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.TSysMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TSysMenuMapper {

    List<TSysMenu> findByUserId(Integer userId);
}
