package com.lcyzh.nmerp.service.impl;

import com.lcyzh.nmerp.constant.Constants;
import com.lcyzh.nmerp.dao.TContractMapper;
import com.lcyzh.nmerp.entity.TContract;
import com.lcyzh.nmerp.model.vo.ContractVo;
import com.lcyzh.nmerp.service.TContractService;
import com.lcyzh.nmerp.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public int insert(ContractVo vo) {
        Date current = new Date();
        TContract tContract = new TContract();
        tContract.setContCode(StringUtils.genFixPreFixStr(Constants.CONT_PRE_FIX));
        tContract.setContAttach(vo.getContAttach());
        tContract.setContManager(vo.getContManager());
        tContract.setContSignDate(vo.getContSignDate());
        tContract.setContStatus('0');
        tContract.setCreateTime(current);
        return tContractMapper.insert(tContract);
    }

    @Override
    public int insertBatch(List<TContract> tContracts) {
        return tContractMapper.insertBatch(tContracts);
    }

    @Override
    public int update(ContractVo vo) {
        Date date = new Date();
        TContract tContract = new TContract();
        tContract.setContCode(vo.getContCode());
        tContract.setContAttach(vo.getContAttach());
        tContract.setContManager(vo.getContManager());
        tContract.setContSignDate(vo.getContSignDate());
        tContract.setContStatus(Constants.CONT_STATUS_FINISH);
        tContract.setUpdateTime(date);
        return tContractMapper.update(tContract);
    }

    @Override
    public int delete(TContract tContract) {
        return tContractMapper.delete(tContract);
    }

}
