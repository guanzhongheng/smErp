package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.TRawMaterial;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
@Repository
public interface TRawMaterialMapper {

    TRawMaterial get(String id);

    List<TRawMaterial> findList(TRawMaterial tRawMaterial);

    List<TRawMaterial> findAllList();

    int insert(TRawMaterial tRawMaterial);

    int insertBatch(List<TRawMaterial> tRawMaterials);

    int update(TRawMaterial tRawMaterial);

    int delete(TRawMaterial tRawMaterial);

    Integer getCntByCode(String code);
}