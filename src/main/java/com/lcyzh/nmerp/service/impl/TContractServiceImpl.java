package com.lcyzh.nmerp.service.impl;

import com.lcyzh.nmerp.dao.TContractMapper;
import com.lcyzh.nmerp.entity.TContract;
import com.lcyzh.nmerp.service.TContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author ljk
 * Date  2019-06-06
 */
@Service
public class TContractServiceImpl implements TContractService {
    @Autowired
    private TContractMapper tContractMapper;

    @Override
    public TContract get(String id) {
        return tContractMapper.get(id);
    }

    @Override
    public List<TContract> findList(TContract tContract) {
        return tContractMapper.findList(tContract);
    }

    @Override
    public List<TContract> findAllList() {
        return tContractMapper.findAllList();
    }

    @Override
    public int insert(TContract tContract) {
        return tContractMapper.insert(tContract);
    }

    @Override
    public int insertBatch(List<TContract> tContracts) {
        return tContractMapper.insertBatch(tContracts);
    }

    @Override
    public int update(TContract tContract) {
        return tContractMapper.update(tContract);
    }

    @Override
    public int delete(TContract tContract) {
        return tContractMapper.delete(tContract);
    }

}
