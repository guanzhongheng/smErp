package com.lcyzh.nmerp.service.impl;

import com.lcyzh.nmerp.dao.TRawMaterialMapper;
import com.lcyzh.nmerp.entity.TRawMaterial;
import com.lcyzh.nmerp.service.TRawMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
@Service
public class TRawMaterialServiceImpl implements TRawMaterialService{
    @Autowired
    private TRawMaterialMapper tRawMaterialMapper;

    @Override
    public TRawMaterial get(String id){
        return tRawMaterialMapper.get(id);
    }

    @Override
    public List<TRawMaterial> findList(TRawMaterial tRawMaterial) {
        return tRawMaterialMapper.findList(tRawMaterial);
    }

    @Override
    public List<TRawMaterial> findAllList() {
        return tRawMaterialMapper.findAllList();
    }

    @Override
    public int insert(TRawMaterial tRawMaterial) {
        tRawMaterial.setCreateTime(new Date());
        return tRawMaterialMapper.insert(tRawMaterial);
    }

    @Override
    public int insertBatch(List<TRawMaterial> tRawMaterials){
        return tRawMaterialMapper.insertBatch(tRawMaterials);
    }

    @Override
    public int update(TRawMaterial tRawMaterial) {
        tRawMaterial.setUpdateTime(new Date());
        return tRawMaterialMapper.update(tRawMaterial);
    }

    @Override
    public int delete(TRawMaterial tRawMaterial) {
        return tRawMaterialMapper.delete(tRawMaterial);
    }

    @Override
    public boolean rawmCodeIsExistence(String code) {
        Integer count = tRawMaterialMapper.findCntByCode(code);
        return count > 0;
    }

}
