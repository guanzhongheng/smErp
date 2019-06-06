package com.lcyzh.nmerp.service;

import com.lcyzh.nmerp.entity.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
public interface TUserService {
    TUser get(String id);

    List<TUser> findList(TUser tUser);

    List<TUser> findAllList();

    int insert(TUser tUser);

    int insertBatch(List<TUser> tUsers);

    int update(TUser tUser);

    int delete(TUser tUser);

}
