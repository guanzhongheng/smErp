package com.lcyzh.nmerp.service;

import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.entity.TFormula;
import com.lcyzh.nmerp.model.vo.FormulaVo;

import java.util.List;

/**
* Author ljk
* Date  2019-07-26
*/
public interface ITFormulaService {

    TFormula findByCode(String fCode);

    List<TFormula> findList(TFormula tFormula);

    List<TFormula> findAllList();

    int insert(TFormula tFormula);

    int insertBatch(List<TFormula> tFormulas);

    int update(TFormula tFormula);

    int delete(TFormula tFormula);

    Page<FormulaVo> findPage(Page<FormulaVo> page, TFormula tFormula);

}
