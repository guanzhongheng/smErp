package com.lcyzh.nmerp.service.impl;

import com.lcyzh.nmerp.dao.CusEmpRelMapper;
import com.lcyzh.nmerp.entity.CusEmpRel;
import com.lcyzh.nmerp.service.ICusEmpRelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Author ljk
* Date  2019-07-01
*/
@Service
public class CusEmpRelServiceImpl implements ICusEmpRelService {
    @Autowired
    private CusEmpRelMapper cusEmpRelMapper;

    @Override
    public CusEmpRel get(String id){
        return cusEmpRelMapper.get(id);
    }

    @Override
    public List<CusEmpRel> findList(CusEmpRel cusEmpRel) {
        return cusEmpRelMapper.findList(cusEmpRel);
    }

    @Override
    public List<CusEmpRel> findAllList() {
        return cusEmpRelMapper.findAllList();
    }

    @Override
    public int insert(CusEmpRel cusEmpRel) {
        return cusEmpRelMapper.insert(cusEmpRel);
    }

    @Override
    public int insertBatch(List<CusEmpRel> cusEmpRels){
        return cusEmpRelMapper.insertBatch(cusEmpRels);
    }

    @Override
    public int update(CusEmpRel cusEmpRel) {
        return cusEmpRelMapper.update(cusEmpRel);
    }

    @Override
    public int delete(CusEmpRel cusEmpRel) {
        return cusEmpRelMapper.delete(cusEmpRel);
    }

}
