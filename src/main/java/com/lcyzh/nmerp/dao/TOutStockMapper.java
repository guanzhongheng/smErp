package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.TOutStock;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
@Repository
public interface TOutStockMapper {

    TOutStock findByPrimaryKey(String outCode);

    TOutStock findByOrdCode(String ordCode);

    List<TOutStock> findList(TOutStock tOutStock);

    int insert(TOutStock tOutStock);

    int update(TOutStock tOutStock);

    int delete(String barCode);

}