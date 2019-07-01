package com.lcyzh.nmerp.service.impl;

import com.lcyzh.nmerp.dao.PrimaryContactMapper;
import com.lcyzh.nmerp.entity.PrimaryContact;
import com.lcyzh.nmerp.service.IPrimaryContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Author ljk
* Date  2019-07-01
*/
@Service
public class PrimaryContactServiceImpl implements IPrimaryContactService{
    @Autowired
    private PrimaryContactMapper primaryContactMapper;

    @Override
    public PrimaryContact get(String id){
        return primaryContactMapper.get(id);
    }

    @Override
    public List<PrimaryContact> findList(PrimaryContact primaryContact) {
        return primaryContactMapper.findList(primaryContact);
    }

    @Override
    public List<PrimaryContact> findAllList() {
        return primaryContactMapper.findAllList();
    }

    @Override
    public int insert(PrimaryContact primaryContact) {
        return primaryContactMapper.insert(primaryContact);
    }

    @Override
    public int insertBatch(List<PrimaryContact> primaryContacts){
        return primaryContactMapper.insertBatch(primaryContacts);
    }

    @Override
    public int update(PrimaryContact primaryContact) {
        return primaryContactMapper.update(primaryContact);
    }

    @Override
    public int delete(PrimaryContact primaryContact) {
        return primaryContactMapper.delete(primaryContact);
    }

}
