package com.lcyzh.nmerp.service;

import com.lcyzh.nmerp.entity.PrimaryContact;

import java.util.List;

/**
* Author ljk
* Date  2019-07-01
*/
public interface IPrimaryContactService {
    PrimaryContact get(String id);

    List<PrimaryContact> findList(PrimaryContact primaryContact);

    List<PrimaryContact> findAllList();

    int insert(PrimaryContact primaryContact);

    int insertBatch(List<PrimaryContact> primaryContacts);

    int update(PrimaryContact primaryContact);

    int delete(PrimaryContact primaryContact);

}
