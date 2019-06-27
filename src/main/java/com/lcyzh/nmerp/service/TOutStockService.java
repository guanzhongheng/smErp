package com.lcyzh.nmerp.service;

import com.lcyzh.nmerp.entity.TOutStock;
import com.lcyzh.nmerp.model.vo.OutStockDetailVo;
import com.lcyzh.nmerp.model.vo.OutStockVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
public interface TOutStockService {

    TOutStock findByOutCode(String outCode);

    TOutStock findByOrdCode(String ordCode);

    List<TOutStock> findList(TOutStock tOutStock);

    int insertStore(OutStockDetailVo vo);

    String createAndReturnOutCode(Long applyUserId,String remark);

    int update(OutStockVo vo);

    int delete(OutStockVo vo);

}
