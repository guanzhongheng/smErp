package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.PrimaryContact;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* Author ljk
* Date  2019-07-01
*/
@Repository
public interface PrimaryContactMapper {

    PrimaryContact get(String id);

    List<PrimaryContact> findList(PrimaryContact primaryContact);

    List<PrimaryContact> findAllList();

    int insert(PrimaryContact primaryContact);

    int insertBatch(List<PrimaryContact> primaryContacts);

    int update(PrimaryContact primaryContact);

    int delete(PrimaryContact primaryContact);

}