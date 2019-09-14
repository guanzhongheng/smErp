package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.TEquipment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 项目名称：nm-erp
 * 类 名 称：TEquipmentMapper
 * 类 描 述：TODO
 * 创建时间：2019/9/11 2:01 PM
 * 创 建 人：guan
 */
@Repository
public interface TEquipmentMapper {

    List<TEquipment> findList(TEquipment tEquipment);

    TEquipment findById(Long eqId);

    int getCount(@Param("macAddress") String macAddress);

    int checkMacAddress(@Param("macAddress") String macAddress);

    int insert(TEquipment tFormula);

    int update(TEquipment tFormula);

    int delete(TEquipment tFormula);
}
