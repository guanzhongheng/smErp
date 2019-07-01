package com.lcyzh.nmerp.service;

import com.lcyzh.nmerp.entity.CusEmpRel;

import java.util.List;

/**
* Author ljk
* Date  2019-07-01
*/
public interface ICusEmpRelService {
    CusEmpRel get(String id);

    List<CusEmpRel> findList(CusEmpRel cusEmpRel);

    List<CusEmpRel> findAllList();

    int insert(CusEmpRel cusEmpRel);

    int insertBatch(List<CusEmpRel> cusEmpRels);

    int update(CusEmpRel cusEmpRel);

    int delete(CusEmpRel cusEmpRel);

}
