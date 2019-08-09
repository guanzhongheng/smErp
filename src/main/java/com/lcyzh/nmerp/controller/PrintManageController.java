package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.common.lang.DateUtils;
import com.lcyzh.nmerp.constant.Constants;
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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
       // 获取订单详情
        List<OrderItemVo> orderItemVos =   orderService.findItemsByOrdCode(outItemVoList.get(0).getOrdCode());

        List<OrderItemVo> newItems = doProcessOrder(outItemVoList,orderItemVos);

        model.addAttribute("nowTime", DateUtils.getDate());
        model.addAttribute("userName",currentUser.getName());
        model.addAttribute("customer",customer);
        model.addAttribute("order",order);
        model.addAttribute("orderItem",newItems);
        getTotalInfo(model,doProcessOrder(outItemVoList,orderItemVos));
        return "modules/print/outStockInvoice";
    }

    public List<OrderItemVo> doProcessOrder(List<OutItemVo> outItemVoList,List<OrderItemVo> oldOrderItem){
        List<OrderItemVo> list = new ArrayList<>();
        Map<String,Long> ite = new HashMap<>();
        if(!StringUtils.isEmpty(outItemVoList)){
            for(OutItemVo vo : outItemVoList){
                String newName = vo.getOrdCode() + vo.getItemOwner() + vo.getItemName();
                if(ite.get(newName) == null){
                    ite.put(newName,1L);
                }else{
                    Long n = ite.get(newName) + 1L;
                    ite.put(newName,n);
                }
            }
        }
        if(!StringUtils.isEmpty(oldOrderItem)){
            for(OrderItemVo vo : oldOrderItem){
                String newName = vo.getOrdCode() + vo.getItemOwner() + vo.getItemName();
                if(ite.get(newName) != null && !list.contains(vo)){
                    vo.setItemNum(ite.get(newName));
                    list.add(vo);
                }
            }
        }
        return list;
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
                    return i.getItemWeight();
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
        ProdPlanVo prodPlan = planService.findByProdPanCode(prodPlanCode);
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
        ProdPlanVo prodPlan = planService.findByProdPanCode(prodPlanCode);
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

//        Double totalMj = orderItemVos.stream().mapToDouble(i -> (i.getItemTotalSq()==null?0: i.getItemTotalSq())).sum();
        Double totalMj = orderItemVos.stream().mapToDouble(i->((i.getItemPriceType().equals(Constants.PROD_PRICE_TYPE_SQ)&&i.getItemTotalSq()!=null)?i.getItemTotalSq():0)).sum();
//        Double totalZl = orderItemVos.stream().mapToDouble(i -> i.getItemTotalWeight()==null?0: i.getItemTotalWeight()).sum();
        Double totalZl = orderItemVos.stream().mapToDouble(i -> ((i.getItemPriceType().equals(Constants.PROD_PRICE_TYPE_WEIGHT)&&i.getItemTotalWeight()!=null)?i.getItemTotalWeight():0)).sum();
        Double totalNum = orderItemVos.stream().mapToDouble(i -> i.getItemNum()==null?0: i.getItemNum()).sum();

        double totoalPriceByMj = 0d;
        double totalPriceByZL = 0d;
      if(orderItemVos!=null && !orderItemVos.isEmpty()){
          for (OrderItemVo item: orderItemVos){
              if(item.getItemPriceType().equals(Constants.PROD_PRICE_TYPE_WEIGHT)){
                  totalPriceByZL += item.getItemNum() * item.getItemPrice() * item.getItemWeight();
              }else{
                  totoalPriceByMj += item.getItemNum() * item.getItemPrice() *(item.getItemLenth()*item.getItemWidth());
              }
          }
      }

        double totalPrice = totoalPriceByMj + totalPriceByZL;
        model.addAttribute("totalMj",totalMj);
        model.addAttribute("totalZl",totalZl);
        model.addAttribute("totalNum",totalNum);
        model.addAttribute("totalPrice",totalPrice);
    }
}
