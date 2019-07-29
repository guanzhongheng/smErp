package com.lcyzh.nmerp.service.impl;

import com.lcyzh.nmerp.dao.TFormulaMapper;
import com.lcyzh.nmerp.entity.TFormula;
import com.lcyzh.nmerp.service.ITFormulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
* Author ljk
* Date  2019-07-26
*/
@Service
public class TFormulaServiceImpl implements ITFormulaService {
    @Autowired
    private TFormulaMapper tFormulaMapper;

    @Override
    public TFormula findByCode(String fCode){
        return tFormulaMapper.findByCode(fCode);
    }

    @Override
    public List<TFormula> findList(TFormula tFormula) {
        return tFormulaMapper.findList(tFormula);
    }

    @Override
    public List<TFormula> findAllList() {
        return tFormulaMapper.findAllList();
    }

    @Override
    public int insert(TFormula tFormula) {
        tFormula.setCreateDate(new Date());
        return tFormulaMapper.insert(tFormula);
    }

    @Override
    public int insertBatch(List<TFormula> tFormulas){
        return tFormulaMapper.insertBatch(tFormulas);
    }

    @Override
    public int update(TFormula tFormula) {
        tFormula.setUpdateDate(new Date());
        return tFormulaMapper.update(tFormula);
    }

    @Override
    public int delete(TFormula tFormula) {
        return tFormulaMapper.delete(tFormula);
    }

}
