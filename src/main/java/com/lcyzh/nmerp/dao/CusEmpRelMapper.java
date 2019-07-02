package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.CusEmpRel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* Author ljk
* Date  2019-07-01
*/
@Repository
public interface CusEmpRelMapper {

    List<CusEmpRel> findList(CusEmpRel cusEmpRel);

    List<CusEmpRel> findAllList();

    int insert(CusEmpRel cusEmpRel);

    int insertBatch(List<CusEmpRel> cusEmpRels);

    int update(CusEmpRel cusEmpRel);

    int delete(List<String> cusCodeList);

    int updateBatch(List<CusEmpRel> cusEmpRelList);
}