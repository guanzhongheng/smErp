package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.constant.Constants;
import com.lcyzh.nmerp.dao.TCustomerMapper;
import com.lcyzh.nmerp.model.vo.*;
import com.lcyzh.nmerp.service.IReportService;
import com.lcyzh.nmerp.service.TOrderService;
import com.lcyzh.nmerp.service.TOutStockService;
import com.lcyzh.nmerp.utils.Arith;
import com.lcyzh.nmerp.utils.DateUtil;
import com.lcyzh.nmerp.utils.JxlsExcelView;
import org.jxls.common.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
public class ExportController {
    private static String TEMPLATE_PATH = "jxls/template/";
    @Autowired
    private IReportService reportService;
    @Autowired
    private TOrderService orderService;
    @Autowired
    private TOutStockService outStockService;
    @Autowired
    private TCustomerMapper tCustomerMapper;

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
     * TODO 设计产品编码 待确认
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

    /**
     * 生产计划导出
     */
    @RequestMapping(value = "/export/prodPlanDetail",method = RequestMethod.GET)
    public ModelAndView prodPlanExport(HttpServletResponse response, String ids){

        Map<String,Object> result = reportService.getProdPlanDetailList(ids);
        Context context = new Context();
        context.putVar("result", result);
        return new ModelAndView(
                new JxlsExcelView(TEMPLATE_PATH + "prodplan.xlsx", "自选生产计划-" + DateUtil.date2Str(new Date(),"yyyy-MM-dd HH:mm:ss"), context));
    }
    /**
     * 生产计划导出
     */
    @RequestMapping(value = "/export/prodPlanOverDetail",method = RequestMethod.GET)
    public ModelAndView prodPlanOverExport(HttpServletResponse response, String prodPlanCode){

        Map<String,Object> result = reportService.getProdPlanOverList(prodPlanCode);
        Context context = new Context();
        context.putVar("result", result);
        return new ModelAndView(
                new JxlsExcelView(TEMPLATE_PATH + "prodplan.xlsx", "自选生产计划-" + DateUtil.date2Str(new Date(),"yyyy-MM-dd HH:mm:ss"), context));
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


    @RequestMapping(value = "/export/outOrderInfo", method = RequestMethod.GET)
    public ModelAndView outOrderImportExcel(String outCode, HttpServletResponse response){
        List<OrderItemVo> newItems = new ArrayList<>();
        // 获取出库单关联详情
        List<OutItemVo> outItemVoList = outStockService.findItemByOutCode(outCode);
        if(!CollectionUtils.isEmpty(outItemVoList)){
            Map<String,Integer> orderCodes = new HashMap<>();
            for(OutItemVo vo : outItemVoList){
                if(orderCodes.get(vo.getOrdCode()) == null){
                    orderCodes.put(vo.getOrdCode(),1);
                }
            }
            List<OrderItemVo> orderItemVos = new ArrayList<>();
            for(String key : orderCodes.keySet()){
                // 获取订单详情
                List<OrderItemVo> orderItemVo =   orderService.findItemsByOrdCodeForPrint(key);
                orderItemVos.addAll(orderItemVo);
            }
            newItems = doProcessOrderInfo(outItemVoList,orderItemVos);
        }
        Map<String,Object> result = new HashMap<>();
        result.put("orderInfo",newItems);
        getTotalInfo(result,newItems);

        Context context = new Context();
        context.putVar("result", result);
        return new ModelAndView(
                new JxlsExcelView(TEMPLATE_PATH + "outOrderInfo.xlsx", "出库单据-" + DateUtil.date2Str(new Date(),"yyyy-MM-dd HH:mm:ss"), context));
    }

    public List<OrderItemVo> doProcessOrderInfo(List<OutItemVo> outItemList,List<OrderItemVo> oldOrderItem){
        List<OrderItemVo> orderList = new ArrayList<>();
        Map<String,Long> ite = new HashMap<>();
        Map<String,Double> iteWightInfo = new HashMap<>();
        if(!StringUtils.isEmpty(outItemList)){
            for(OutItemVo vo : outItemList){
                String newName = vo.getOrdCode() + vo.getItemOwner() + vo.getProdVarietyValue() + vo.getProdCgyCodeValue() + vo.getProdColorValue() + vo.getItemLenth()  + vo.getItemWidth() + vo.getItemThick()+vo.getItemPriceType();
                if(ite.get(newName) == null){
                    ite.put(newName,1L);
                    iteWightInfo.put(newName,vo.getItemWeight());
                }else{
                    Long n = ite.get(newName) + 1L;
                    Double d = Arith.add(iteWightInfo.get(newName),vo.getItemWeight());
                    ite.put(newName,n);
                    iteWightInfo.put(newName,d);
                }
            }
        }
        if(!StringUtils.isEmpty(oldOrderItem)){
            for(OrderItemVo vo : oldOrderItem){
                String newName = vo.getOrdCode() + vo.getItemOwner() + vo.getItemVaritemValue() + vo.getItemCgyCodeValue() + vo.getItemColorValue() + vo.getItemLenth()+ vo.getItemWidth()+ vo.getItemThick() + vo.getItemPriceType();
                if(ite.get(newName) != null && !orderList.contains(vo)){
                    if(ite.get(newName) > vo.getItemNum()){
                        Long newNum = ite.get(newName) - vo.getItemNum();
                        ite.put(newName,newNum);
                    }else{
                        vo.setItemNum(ite.get(newName));
                    }
                    Double mj = vo.getItemNum() * vo.getItemLenth() * vo.getItemWidth();
                    vo.setItemTotalSq(Arith.round(mj,4));
                    vo.setItemTotalWeight(iteWightInfo.get(newName));
                    String priceTypeValue = vo.getItemPriceTypeValue().replace("(加厚)","").replace("(减薄)","");
                    vo.setItemPriceTypeValue(priceTypeValue);
                    orderList.add(vo);
                }
            }
        }
        return orderList;
    }

    public void getTotalInfo(Map<String,Object> result,List<OrderItemVo> orderItemVos){
        Double totalMj = orderItemVos.stream().mapToDouble(i->(((i.getItemPriceType().equals(Constants.PROD_PRICE_TYPE_SQ)
                || i.getItemPriceType().equals(Constants.PROD_PRICE_TYPE_SQ_JB)
                || i.getItemPriceType().equals(Constants.PROD_PRICE_TYPE_SQ_JH))&&i.getItemTotalSq()!=null)?i.getItemTotalSq():0)).sum();
        Double totalZl = orderItemVos.stream().mapToDouble(i -> (((i.getItemPriceType().equals(Constants.PROD_PRICE_TYPE_WEIGHT)
                || i.getItemPriceType().equals(Constants.PROD_PRICE_TYPE_WEIGHT_JH)
                || i.getItemPriceType().equals(Constants.PROD_PRICE_TYPE_WEIGHT_JB) )&&i.getItemTotalWeight()!=null)?i.getItemTotalWeight():0)).sum();
        Long totalNum = orderItemVos.stream().mapToLong(i -> i.getItemNum()==null?0: i.getItemNum()).sum();
        orderItemVos.forEach(n->{
            if(n.getItemPriceType() == 141002 || n.getItemPriceType() == 141004 || n.getItemPriceType() == 141006){
                n.setShowTotalPrice(Arith.round(Arith.mul(n.getItemTotalSq(),n.getItemPrice()),4));
            }else{
                n.setShowTotalPrice(Arith.round(Arith.mul(n.getItemTotalWeight(),n.getItemPrice()),4));
            }
        });

        double totoalPriceByMj = 0d;
        double totalPriceByZL = 0d;
        if(orderItemVos!=null && !orderItemVos.isEmpty()){
            for (OrderItemVo item: orderItemVos){
                if(item.getItemPriceType().equals(Constants.PROD_PRICE_TYPE_WEIGHT)
                        || item.getItemPriceType().equals(Constants.PROD_PRICE_TYPE_WEIGHT_JB)
                        || item.getItemPriceType().equals(Constants.PROD_PRICE_TYPE_WEIGHT_JH)){
                    totalPriceByZL += item.getItemPrice() * item.getItemTotalWeight();
                }else{
                    totoalPriceByMj += item.getItemNum() * item.getItemPrice() *(item.getItemLenth()*item.getItemWidth());
                }
            }
        }

        double totalPrice = Arith.add(totoalPriceByMj,totalPriceByZL);
        result.put("totalMj",Arith.round(totalMj,4));
        result.put("totalZl",Arith.round(totalZl,4));
        result.put("totalNum",totalNum);
        result.put("totalPrice",Arith.round(totalPrice,4));
    }
}