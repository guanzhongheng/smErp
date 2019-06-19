package com.lcyzh.nmerp.service;

import com.lcyzh.nmerp.entity.TContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
public interface TContractService {
    TContract get(String id);

    List<TContract> findList(TContract tContract);

    List<TContract> findAllList();

    int insert(TContract tContract);

    int insertBatch(List<TContract> tContracts);

    int update(TContract tContract);

    int delete(TContract tContract);

}
