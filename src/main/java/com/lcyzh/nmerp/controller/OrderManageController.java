package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.controller.common.BaseController;
import com.lcyzh.nmerp.entity.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 项目名称：nm-erp
 * 类 名 称：OrderManageController
 * 类 描 述：TODO
 * 创建时间：2019/6/30 1:11 AM
 * 创 建 人：guan
 */
@Controller
@RequestMapping("order")
public class OrderManageController extends BaseController {

    @RequestMapping(value = "order_add")
    public String orderAdd( Model model){
        //   Page<Customer> page = commentService.findPage(new Page<Comment>(request, response), comment);
        Page<Customer> page = new Page<Customer>();
        model.addAttribute("page", page);
        return "modules/crm/orderAdd";
    }
}
