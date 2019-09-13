package com.lcyzh.nmerp.service;

import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.entity.TEquipment;

import java.util.List;

/**
 * 项目名称：nm-erp
 * 类 名 称：TEquipmentService
 * 类 描 述：TODO
 * 创建时间：2019/9/11 2:33 PM
 * 创 建 人：guan
 */
public interface TEquipmentService {

    List<TEquipment> findPageList(Page<TEquipment> page, TEquipment tEquipment);

    TEquipment findById(Long eqId);

    int getCount(String macAddress);

    int insert(TEquipment tFormula);

    int update(TEquipment tFormula);

    int delete(TEquipment tFormula);
}
