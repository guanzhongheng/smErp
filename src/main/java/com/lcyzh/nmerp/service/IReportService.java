package com.lcyzh.nmerp.service;

import com.lcyzh.nmerp.model.vo.*;

import java.util.List;
import java.util.Map;

public interface IReportService {
    List<StockQueryVo> queryStockList(StockQueryVo vo);

    List<CustomerQueryVo> queryCustomerList(CustomerQueryVo customer);

    OrderQueryVo queryOrderInfo(String ordCode);

    Map<String,Object> queryProdPlanDetailList(ProdPlanExportVo exportVo);

    Map<String,Object> getProdPlanDetailList(String ids);

    Map<String,Object> getProdPlanOverList(String prodPlanCode);


}
