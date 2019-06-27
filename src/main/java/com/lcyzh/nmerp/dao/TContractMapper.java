package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.TContract;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
@Repository
public interface TContractMapper {

    TContract get(String id);

    List<TContract> findList(TContract tContract);

    List<TContract> findAllList();

    int insert(TContract tContract);

    int insertBatch(List<TContract> tContracts);

    int update(TContract tContract);

    int delete(TContract tContract);

}