package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.TDict;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TDictMapper {

    List<TDict> findList();
}
