package com.lcyzh.nmerp.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.constant.Constants;
import com.lcyzh.nmerp.dao.TFormulaMapper;
import com.lcyzh.nmerp.entity.TFormula;
import com.lcyzh.nmerp.model.vo.FormulaDetailVo;
import com.lcyzh.nmerp.model.vo.FormulaVo;
import com.lcyzh.nmerp.service.ITFormulaService;
import com.lcyzh.nmerp.utils.DictUtils;
import com.lcyzh.nmerp.utils.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.*;
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
        if(!StringUtils.isBlank(formula.getfContext())) {
            JSONObject jsonObject = JSON.parseObject(formula.getfContext());
            Map<String, FormulaDetailVo> context = new HashMap<>();
            for(String key : jsonObject.keySet()) {
                context.put(key, toJavaBean(new FormulaDetailVo(), jsonObject.getJSONObject(key)));
            }
            formulaVo.setContext(context);
        }
        return formulaVo;
    }

    public static FormulaDetailVo toJavaBean(FormulaDetailVo javabean, JSONObject data) {
        Method[] methods = javabean.getClass().getDeclaredMethods();
        for (Method method : methods) {
            try {
                if (method.getName().startsWith("set")) {
                    String field = method.getName(); //set()
                    field = field.substring(field.indexOf("set") + 3);//
                    field = field.toLowerCase().charAt(0) + field.substring(1);//
                    method.invoke(javabean, new Object[]
                            {
                                    data.get(field)
                            });
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return javabean;
    }

    @Override
    public List<FormulaVo> findList(TFormula tFormula) {
        List<TFormula> list = tFormulaMapper.findList(tFormula);
        List<FormulaVo> vos = list.stream().map(item ->{
            FormulaVo vo = new FormulaVo();
            BeanUtils.copyProperties(item, vo);
            vo.setProdCgyCodeValue(DictUtils.getValueByDictKey(vo.getProdCgyCode()));
            vo.setProdVarietyValue(DictUtils.getValueByDictKey(vo.getProdVariety()));
            JSONObject jsonObject = JSON.parseObject(item.getfContext());
            Map<String, FormulaDetailVo> context = new HashMap<>();
            for(String key : jsonObject.keySet()) {
                context.put(key, toJavaBean(new FormulaDetailVo(), jsonObject.getJSONObject(key)));
            }
            vo.setContext(context);
            return vo;
        }).collect(Collectors.toList());
        return vos;
    }

    @Override
    public List<TFormula> findAllList() {
        return tFormulaMapper.findAllList();
    }

    @Override
    public String insert(TFormula tFormula) {
        String fCode = StringUtils.genFixPreFixStr(Constants.FORMULA_FIX);
        tFormula.setfCode(fCode);
        tFormula.setCreateDate(new Date());
        tFormula.setDelFlag('0');
        int result = tFormulaMapper.insert(tFormula);
        if(result > 0){
            return fCode;
        }
        return null;
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
