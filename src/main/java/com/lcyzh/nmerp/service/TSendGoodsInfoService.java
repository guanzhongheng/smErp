package com.lcyzh.nmerp.service;

import com.lcyzh.nmerp.entity.TSendGoodsInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
public interface TSendGoodsInfoService {
    TSendGoodsInfo get(String id);

    List<TSendGoodsInfo> findList(TSendGoodsInfo tSendGoodsInfo);

    List<TSendGoodsInfo> findAllList();

    int insert(TSendGoodsInfo tSendGoodsInfo);

    int insertBatch(List<TSendGoodsInfo> tSendGoodsInfos);

    int update(TSendGoodsInfo tSendGoodsInfo);

    int delete(TSendGoodsInfo tSendGoodsInfo);

}
