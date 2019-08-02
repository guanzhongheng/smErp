package com.lcyzh.nmerp.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.dao.TFormulaMapper;
import com.lcyzh.nmerp.entity.TFormula;
import com.lcyzh.nmerp.model.vo.FormulaDetailVo;
import com.lcyzh.nmerp.model.vo.FormulaVo;
import com.lcyzh.nmerp.service.ITFormulaService;
import com.lcyzh.nmerp.utils.DictUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
* Author ljk
* Date  2019-07-26
*/
@Service
public class TFormulaServiceImpl implements ITFormulaService {
    @Autowired
    private TFormulaMapper tFormulaMapper;

    @Override
    public FormulaVo findByCode(String fCode){
        TFormula formula = tFormulaMapper.findByCode(fCode);
        FormulaVo formulaVo = new FormulaVo();
        BeanUtils.copyProperties(formula, formulaVo);
        formulaVo.setProdCgyCodeValue(DictUtils.getValueByDictKey(formulaVo.getProdCgyCode()));
        formulaVo.setProdVarietyValue(DictUtils.getValueByDictKey(formulaVo.getProdVariety()));
        Map<String, FormulaDetailVo> context = new HashMap<>();
        context = JSON.parseObject(formula.getfContext(), context.getClass());
        formulaVo.setContext(context);
        return formulaVo;
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

    @Override
    public Page<FormulaVo> findPage(Page<FormulaVo> page, TFormula tFormula) {
        PageHelper.startPage(page.getPageNo(),page.getPageSize());
        List<TFormula> formulas = tFormulaMapper.findList(tFormula);
        if(formulas != null && !formulas.isEmpty()) {
            List<FormulaVo> formulaVos = formulas.stream().map(formula ->{
                FormulaVo formulaVo = new FormulaVo();
                BeanUtils.copyProperties(formula, formulaVo);
                formulaVo.setProdCgyCodeValue(DictUtils.getValueByDictKey(formulaVo.getProdCgyCode()));
                formulaVo.setProdVarietyValue(DictUtils.getValueByDictKey(formulaVo.getProdVariety()));
                return formulaVo;
            }).collect(Collectors.toList());
            PageInfo<FormulaVo> p = new PageInfo<>(formulaVos);
            page.setCount(p.getTotal());
            page.setList(formulaVos);
            return page;
        }
        return null;
    }

}
