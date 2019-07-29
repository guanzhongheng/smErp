package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.TFormula;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* Author ljk
* Date  2019-07-26
*/
@Repository
public interface TFormulaMapper {

    TFormula findByCode(String fCode);

    List<TFormula> findList(TFormula tFormula);

    List<TFormula> findAllList();

    int insert(TFormula tFormula);

    int insertBatch(List<TFormula> tFormulas);

    int update(TFormula tFormula);

    int delete(TFormula tFormula);

}