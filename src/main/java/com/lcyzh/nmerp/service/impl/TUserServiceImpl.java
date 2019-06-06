package com.lcyzh.nmerp.service.impl;

import com.lcyzh.nmerp.dao.TUserMapper;
import com.lcyzh.nmerp.entity.TUser;
import com.lcyzh.nmerp.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
@Service
public class TUserServiceImpl implements TUserService{
    @Autowired
    private TUserMapper tUserMapper;

    @Override
    public TUser get(String id){
        return tUserMapper.get(id);
    }

    @Override
    public List<TUser> findList(TUser tUser) {
        return tUserMapper.findList(tUser);
    }

    @Override
    public List<TUser> findAllList() {
        return tUserMapper.findAllList();
    }

    @Override
    public int insert(TUser tUser) {
        return tUserMapper.insert(tUser);
    }

    @Override
    public int insertBatch(List<TUser> tUsers){
        return tUserMapper.insertBatch(tUsers);
    }

    @Override
    public int update(TUser tUser) {
        return tUserMapper.update(tUser);
    }

    @Override
    public int delete(TUser tUser) {
        return tUserMapper.delete(tUser);
    }

}
