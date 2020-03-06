package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.TSendGoodsInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
@Repository
public interface TSendGoodsInfoMapper {

    TSendGoodsInfo get(String id);

    List<TSendGoodsInfo> findList(TSendGoodsInfo tSendGoodsInfo);

    List<TSendGoodsInfo> findAllList();

    int insert(TSendGoodsInfo tSendGoodsInfo);

    int insertBatch(List<TSendGoodsInfo> tSendGoodsInfos);

    int update(TSendGoodsInfo tSendGoodsInfo);

    int delete(TSendGoodsInfo tSendGoodsInfo);

}