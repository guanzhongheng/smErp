package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.common.lang.DateUtils;
import com.lcyzh.nmerp.controller.common.BaseController;
import com.lcyzh.nmerp.controller.system.util.UserUtils;
import com.lcyzh.nmerp.dao.TCustomerMapper;
import com.lcyzh.nmerp.entity.sys.User;
import com.lcyzh.nmerp.model.vo.CustomerAddModifyVo;
import com.lcyzh.nmerp.model.vo.OrderAddModifyVo;
import com.lcyzh.nmerp.model.vo.OrderItemVo;
import com.lcyzh.nmerp.service.TOrderService;
import com.lcyzh.nmerp.service.TProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    private TProductService productService;

    @Autowired
    private TCustomerMapper tCustomerMapper;
    @RequestMapping(value = "order_print")
    public String orderPrint(String ordCode, Model model){
        User currentUser = UserUtils.getUser();

        // 获取订单信息
        OrderAddModifyVo order =  orderService.findModifyInfoByOrdCode(ordCode);
        // 获取客户信息
        CustomerAddModifyVo customer = tCustomerMapper.findModifyInfoByCusCode(order.getCusCode());
        // 获取订单详情
        List<OrderItemVo> orderItemVos =   orderService.findByOrdCode(ordCode);
        model.addAttribute("nowTime", DateUtils.getDate());
        model.addAttribute("userName",currentUser.getName());
        model.addAttribute("customer",customer);
        model.addAttribute("order",order);
        model.addAttribute("orderItem",orderItemVos);
        getTotalInfo(model,orderItemVos);
        return "modules/print/orderInvoice";
    }


    /**
     * 统计计算
     * @param model
     * @param orderItemVos
     */
    public void getTotalInfo(Model model,List<OrderItemVo> orderItemVos){

        Double totalMj = orderItemVos.stream().mapToDouble(i -> i.getItemTotalSq()==null?0: i.getItemTotalSq()).sum();
        Double totalZl = orderItemVos.stream().mapToDouble(i -> i.getItemTotalWeight()==null?0: i.getItemTotalWeight()).sum();
        Double totalPrice = orderItemVos.stream().mapToDouble(i -> {
           return i.getItemNum()*i.getItemPrice();
        }).sum();
        model.addAttribute("totalMj",totalMj);
        model.addAttribute("totalZl",totalZl);
        model.addAttribute("totalPrice",totalPrice);
    }
}
