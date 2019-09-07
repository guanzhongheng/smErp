package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.model.vo.*;
import com.lcyzh.nmerp.service.IReportService;
import com.lcyzh.nmerp.utils.DateUtil;
import com.lcyzh.nmerp.utils.JxlsExcelView;
import org.jxls.common.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class ExportController {
    private static String TEMPLATE_PATH = "jxls/template/";
    @Autowired
    private IReportService reportService;

    /**
     * 库存列表信息导出
     * @param response
     * @return
     */
    @RequestMapping(value = "/export/stock")
    public ModelAndView stockExport(HttpServletResponse response, StockQueryVo vo){
        List<StockQueryVo> vos = reportService.queryStockList(vo);
        Context context = new Context();
        context.putVar("stockList", vos);
        return new ModelAndView(
                new JxlsExcelView(TEMPLATE_PATH + "stock.xlsx", "库存列表-"+ DateUtil.date2Str(new Date(),"yyyy-MM-dd"), context));
    }

    /**
     * 客户列表信息导出
     */

    @RequestMapping(value = "/export/customer",method = RequestMethod.GET)
    public ModelAndView customerExport(HttpServletResponse response, CustomerQueryVo customer){
        List<CustomerQueryVo> vos = reportService.queryCustomerList(customer);
        Context context = new Context();
        context.putVar("customerList", vos);
        return new ModelAndView(
                new JxlsExcelView(TEMPLATE_PATH + "customer.xlsx", "客户列表-"+ DateUtil.date2Str(new Date(),"yyyy-MM-dd"), context));
    }

    /**
     * 订单信息导出
     */
    @RequestMapping(value = "/export/orderInfo",method = RequestMethod.GET)
    public ModelAndView orderInfoExport(HttpServletResponse response, String ordCode){
        OrderQueryVo orderQueryVo = reportService.queryOrderInfo(ordCode);
        Context context = new Context();
        context.putVar("orderInfo", orderQueryVo.getOrderItemVos());
        return new ModelAndView(
                new JxlsExcelView(TEMPLATE_PATH + "orderInfo.xlsx", "订单-" +orderQueryVo.getOrdTitle() + "-" + DateUtil.date2Str(new Date(),"yyyy-MM-dd"), context));
    }

    /**
     * 生产计划导出
     */
    @RequestMapping(value = "/export/prodPlan",method = RequestMethod.GET)
    public ModelAndView prodPlanExport(HttpServletResponse response, ProdPlanExportVo exportVo){
        Map<String,Object> result = reportService.queryProdPlanDetailList(exportVo);
        Context context = new Context();
        context.putVar("result", result);
        return new ModelAndView(
                new JxlsExcelView(TEMPLATE_PATH + "prodplan.xlsx", "生产计划-" + DateUtil.date2Str(new Date(),"yyyy-MM-dd HH:mm:ss"), context));
    }

//    /**
//     * 生产计划导出
//     */
//    @RequestMapping(value = "/export/prodPlan",method = RequestMethod.GET)
//    public ModelAndView prodPlanExport(HttpServletResponse response, String prodPlanCode){
//        Map<String,Object> result = reportService.queryProdPlanDetailList(prodPlanCode);
//        Context context = new Context();
//        context.putVar("result", result);
//        return new ModelAndView(
//                new JxlsExcelView(TEMPLATE_PATH + "prodplan.xlsx", "生产计划-" + DateUtil.date2Str(new Date(),"yyyy-MM-dd HH-mm-ss"), context));
//    }
}