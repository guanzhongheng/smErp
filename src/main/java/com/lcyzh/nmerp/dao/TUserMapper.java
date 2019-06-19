package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.TUser;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
public interface TUserMapper {

    TUser get(String id);

    List<TUser> findList(TUser tUser);

    List<TUser> findAllList();

    int insert(TUser tUser);

    int insertBatch(List<TUser> tUsers);

    int update(TUser tUser);

    int delete(TUser tUser);

}