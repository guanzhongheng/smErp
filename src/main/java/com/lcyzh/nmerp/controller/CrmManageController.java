package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.controller.common.BaseController;
import com.lcyzh.nmerp.entity.Customer;
import com.lcyzh.nmerp.entity.TOrder;
import com.lcyzh.nmerp.service.TCustomerService;
import com.lcyzh.nmerp.service.TOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 项目名称：nm-erp
 * 类 名 称：CrmManageController
 * 类 描 述：TODO
 * 创建时间：2019/6/28 8:29 PM
 * 创 建 人：guan
 */
@Controller
@RequestMapping("crm")
public class CrmManageController extends BaseController {
    @Autowired
    private TCustomerService customerService;
    @Autowired
    private TOrderService orderService;

    @RequestMapping(value = {"test"})
    public String test(){
        return "modules/crm/customerTest";
    }

    @RequestMapping(value = {"customer/list", "customer"})
    public String list(Customer customer, Model model, HttpServletRequest request, HttpServletResponse response){
        Page<Customer> page = customerService.findPage(new Page<Customer>(request, response), customer);
        model.addAttribute("page", page);
        return "modules/crm/customerList";
    }


    @RequestMapping(value = {"order/list", "order"})
    public String orderList(@ModelAttribute("order") TOrder order, Model model){
        //   Page<Customer> page = commentService.findPage(new Page<Comment>(request, response), comment);
        Page<Customer> page = new Page<Customer>();
        model.addAttribute("page", page);
        return "modules/crm/orderList";
    }

}
