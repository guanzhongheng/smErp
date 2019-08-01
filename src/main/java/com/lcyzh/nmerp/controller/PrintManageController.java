package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.common.lang.DateUtils;
import com.lcyzh.nmerp.controller.common.BaseController;
import com.lcyzh.nmerp.controller.system.util.UserUtils;
import com.lcyzh.nmerp.dao.TCustomerMapper;
import com.lcyzh.nmerp.entity.TOutStock;
import com.lcyzh.nmerp.entity.TProdPlan;
import com.lcyzh.nmerp.entity.TProdPlanDetail;
import com.lcyzh.nmerp.entity.sys.User;
import com.lcyzh.nmerp.model.vo.*;
import com.lcyzh.nmerp.service.TOrderService;
import com.lcyzh.nmerp.service.TOutStockService;
import com.lcyzh.nmerp.service.TProdPlanDetailService;
import com.lcyzh.nmerp.service.TProdPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 项目名称：nm-erp
 * 类 名 称：PrintManageController
 * 类 描 述：TODO
 * 创建时间：2019/7/16 2:46 PM
 * 创 建 人：guan
 */
@Controller
@RequestMapping("print")
public class PrintManageController extends BaseController {

    @Autowired
    private TOrderService orderService;

    @Autowired
    private TOutStockService outStockService;

    @Autowired
    private TCustomerMapper tCustomerMapper;

    @Autowired
    private TProdPlanService planService;

    @Autowired
    private TProdPlanDetailService prodPlanDetailService;

    /**
     * 收据打印
     * @param ordCode
     * @param model
     * @return
     */
    @RequestMapping(value = "order_print")
    public String orderPrint(String ordCode, Model model){
        User currentUser = UserUtils.getUser();

        // 获取订单信息
        OrderAddModifyVo order =  orderService.findModifyInfoByOrdCode(ordCode);
        // 获取客户信息
        CustomerAddModifyVo customer = tCustomerMapper.findModifyInfoByCusCode(order.getCusCode());
        // 获取订单详情
        List<OrderItemVo> orderItemVos =   orderService.findItemsByOrdCode(ordCode);
        model.addAttribute("nowTime", DateUtils.getDate());
        model.addAttribute("userName",currentUser.getName());
        model.addAttribute("customer",customer);
        model.addAttribute("order",order);
        model.addAttribute("orderItem",orderItemVos);
        getTotalInfo(model,orderItemVos);
        return "modules/print/orderInvoice";
    }

    /**
     * 出库收据打印
     * @param outCode
     * @param model
     * @return
     */
    @RequestMapping(value = "outStockInvoice_print")
    public String outStockInvoicePrint(String outCode, Model model){
        User currentUser = UserUtils.getUser();
        // 获取出库单关联详情
        List<OutItemVo> outItemVoList = outStockService.findItemByOutCode(outCode);
        // 获取订单信息
        OrderQueryVo order = orderService.findByOrdeCode(outItemVoList.get(0).getOrdCode());
        // 获取客户信息
        CustomerAddModifyVo customer = tCustomerMapper.findModifyInfoByCusCode(order.getCusCode());
//        // 获取订单详情
//        List<OrderItemVo> orderItemVos =   orderService.findItemsByOrdCode(ordCode);

        model.addAttribute("nowTime", DateUtils.getDate());
        model.addAttribute("userName",currentUser.getName());
        model.addAttribute("customer",customer);
        model.addAttribute("outItemVoList",outItemVoList);
        model.addAttribute("order",order);
//        getTotalInfo(model,orderItemVos);
        return "modules/print/outStockInvoice";
    }


    /**
     * 打印出库清单
     */
    @RequestMapping("outStock_print")
    public String outStockList(String outCode,Model model){
        // 获取发货联系人相关信息
        TOutStock outStock = outStockService.findByCode(outCode);
        List<StockRecordVo> list = outStockService.getOutStockList(outCode);
        Double totalMj = 0d;
        Double totalZl = 0d;
        Double totalNum = 0d;
        if(!CollectionUtils.isEmpty(list)){
            totalMj  = list.stream().mapToDouble(i -> {
                if(i.getItemLenth() != null && i.getItemWidth() != null && i.getItemThick() != null){
                    return i.getItemLenth() * i.getItemWidth() * i.getItemThick() * i.getItemNum();
                }else{
                    return 0d;
                }
            }).sum();
            totalZl = list.stream().mapToDouble(i -> {
                if(i.getItemWeight() != null){
                    return i.getItemWeight() * i.getItemNum();
                }else{
                    return 0d;
                }
            }).sum();

            totalNum = list.stream().mapToDouble(i -> {
                if(i.getItemNum() != null){
                    return i.getItemNum();
                }else{
                    return 0d;
                }
            }).sum();

        }

        User user = UserUtils.getUser();
        // 获取发货清单表
        model.addAttribute("stock",outStock);
        model.addAttribute("totalMj",totalMj);
        model.addAttribute("totalZl",totalZl);
        model.addAttribute("totalNum",totalNum);
        model.addAttribute("stockDetails",list);
        model.addAttribute("user",user.getName());
        model.addAttribute("time",DateUtils.getDate());
        return "modules/print/deliveryNode";
    }

    /**
     * 打印配方信息
     * @param prodPlanCode
     * @param model
     * @return
     */
    @RequestMapping("remark_print")
    public String prodRemarkInfo(String prodPlanCode,Model model){
        TProdPlan prodPlan = planService.findByProdPanCode(prodPlanCode);
        model.addAttribute("prod",prodPlan);
        return "modules/print/prodFormula";
    }

    /**
     * 打印生产清单
     * @param prodPlanCode
     * @param model
     * @return
     */
    @RequestMapping("prodProduce_print")
    public String prodProduceList(String prodPlanCode,Model model){
        TProdPlan prodPlan = planService.findByProdPanCode(prodPlanCode);
        List<TProdPlanDetail> details = prodPlanDetailService.findListByProdPlanCode(prodPlanCode);

        Double totalMj = details.stream().mapToDouble(i -> i.getItemTotalSq()==null?0: i.getItemTotalSq()).sum();
        Double totalZl = details.stream().mapToDouble(i -> i.getItemTotalWeight()==null?0: i.getItemTotalWeight()).sum();
        Double totalNum = details.stream().mapToDouble(i -> i.getItemNum()==null?0: i.getItemNum()).sum();
        Double totalLength = details.stream().mapToDouble(i -> i.getItemLenth()==null?0: i.getItemLenth()).sum();
        model.addAttribute("prod",prodPlan);
        model.addAttribute("details",details);
        model.addAttribute("totalMj",totalMj);
        model.addAttribute("totalZl",totalZl);
        model.addAttribute("totalNum",totalNum);
        model.addAttribute("totalLength",totalLength);
        model.addAttribute("time",DateUtils.getDate());
        model.addAttribute("name",UserUtils.getUser().getName());
        return "modules/print/produceList";
    }

    /**
     * 统计计算
     * @param model
     * @param orderItemVos
     */
    public void getTotalInfo(Model model,List<OrderItemVo> orderItemVos){

        Double totalMj = orderItemVos.stream().mapToDouble(i -> i.getItemTotalSq()==null?0: i.getItemTotalSq()).sum();
        Double totalZl = orderItemVos.stream().mapToDouble(i -> i.getItemTotalWeight()==null?0: i.getItemTotalWeight()).sum();
        Double totalNum = orderItemVos.stream().mapToDouble(i -> i.getItemNum()==null?0: i.getItemNum()).sum();
        Double totalPrice = orderItemVos.stream().mapToDouble(i -> {
           return i.getItemNum()*i.getItemPrice();
        }).sum();
        model.addAttribute("totalMj",totalMj);
        model.addAttribute("totalZl",totalZl);
        model.addAttribute("totalNum",totalNum);
        model.addAttribute("totalPrice",totalPrice);
    }
}
