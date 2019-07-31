package com.lcyzh.nmerp.service;

import com.lcyzh.nmerp.model.vo.CustomerQueryVo;
import com.lcyzh.nmerp.model.vo.OrderQueryVo;
import com.lcyzh.nmerp.model.vo.StockQueryVo;

import java.util.List;

public interface IReportService {
    List<StockQueryVo> queryStockList(StockQueryVo vo);

    List<CustomerQueryVo> queryCustomerList(CustomerQueryVo customer);

    OrderQueryVo queryOrderInfo(String ordCode);
}
