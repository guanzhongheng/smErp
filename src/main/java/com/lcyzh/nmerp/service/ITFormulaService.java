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

    FormulaVo findByCode(String fCode);

    List<FormulaVo> findList(TFormula tFormula);

    List<TFormula> findAllList();

    String insert(TFormula tFormula);

    int insertBatch(List<TFormula> tFormulas);

    int update(TFormula tFormula);

    int delete(TFormula tFormula);

    Page<FormulaVo> findPage(Page<FormulaVo> page, TFormula tFormula);

}
