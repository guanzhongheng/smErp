package com.lcyzh.nmerp.service;

import com.lcyzh.nmerp.entity.TRawMaterial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
public interface TRawMaterialService {
    TRawMaterial get(String id);

    List<TRawMaterial> findList(TRawMaterial tRawMaterial);

    List<TRawMaterial> findAllList();

    int insert(TRawMaterial tRawMaterial);

    int insertBatch(List<TRawMaterial> tRawMaterials);

    int update(TRawMaterial tRawMaterial);

    int delete(TRawMaterial tRawMaterial);
    
    boolean rawmCodeIsExistence(String code);

}
