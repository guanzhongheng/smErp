package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.common.lang.StringUtils;
import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.controller.common.BaseController;
import com.lcyzh.nmerp.entity.Customer;
import com.lcyzh.nmerp.entity.TBarCodeInfo;
import com.lcyzh.nmerp.model.vo.CustomerQueryVo;
import com.lcyzh.nmerp.model.vo.OrderQueryVo;
import com.lcyzh.nmerp.service.TCustomerService;
import com.lcyzh.nmerp.service.TOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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


    @RequestMapping(value = {"customer/list"})
    public String list(@ModelAttribute("customer") CustomerQueryVo customer, Model model, HttpServletRequest request, HttpServletResponse response){
        Page<CustomerQueryVo> page = customerService.findPage(new Page<CustomerQueryVo>(request, response), customer);
        model.addAttribute("page", page);
        return "modules/crm/customerList";
    }

    @RequestMapping(value = {"customer/poollist"})
    public String customerPoolList(@ModelAttribute("customer") CustomerQueryVo customer, Model model, HttpServletRequest request, HttpServletResponse response){
        customer.setFollowType(0);
        Page<CustomerQueryVo> page = customerService.findPage(new Page<CustomerQueryVo>(request, response), customer);
        model.addAttribute("page", page);
        return "modules/crm/customerPoolList";
    }

    @RequestMapping(value = {"order/taskList"})
    public String taskList(@ModelAttribute("order") OrderQueryVo order, Model model, HttpServletRequest request, HttpServletResponse response){
        // 获取通过审批后的产品清单列表
        Page<OrderQueryVo> page = orderService.findPage(new Page<OrderQueryVo>(request, response), order);
        model.addAttribute("page", page);
        return "modules/crm/taskList";
    }


    /**
     * 订单列表
     * @param order
     * @param model
     * @return
     */
    @RequestMapping(value = {"order/list", "order"})
    public String orderList(@ModelAttribute("order") OrderQueryVo order, Model model, HttpServletRequest request, HttpServletResponse response){
        Page<OrderQueryVo> page = orderService.findPage(new Page<OrderQueryVo>(request, response), order);
        model.addAttribute("page", page);
        return "modules/crm/orderList";
    }

    /**
     * 转移客户
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("formSubmit")
    public String fromInfo(HttpServletRequest request, Model model){
        model.addAttribute("ids",request.getParameter("ids"));
        return "modules/crm/formSubmit";
    }

    /**
     * 任务分配详情
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("taskForm")
    public String taskForm(HttpServletRequest request, Model model){
        model.addAttribute("taskIds",request.getParameter("ids"));
        return "modules/crm/taskForm";
    }

    /**
     * 转移到公海
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("poolRemark")
    public String poolRemark(HttpServletRequest request, Model model){
        model.addAttribute("ids",request.getParameter("ids"));
        return "modules/crm/poolRemark";
    }

    /**
     * 客户跟踪记录
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("followInfo")
    public String followInfo(HttpServletRequest request, Model model){
        model.addAttribute("cusCode",request.getParameter("cusCode"));
        return "modules/crm/followInfo";
    }


    @RequestMapping(value = {"inventory/list"})
    public String inventoryList(TBarCodeInfo barCodeInfo, Model model, HttpServletRequest request, HttpServletResponse response){
       // Page<CustomerQueryVo> page = customerService.findPage(new Page<CustomerQueryVo>(request, response), barCodeInfo);
        Page<CustomerQueryVo> page = null;
        model.addAttribute("page", page);
        return "modules/crm/inventoryList";
    }

    @RequestMapping(value = {"inventory/info"})
    public String inventoryInfo( Model model, HttpServletRequest request, HttpServletResponse response){
        // Page<CustomerQueryVo> page = customerService.findPage(new Page<CustomerQueryVo>(request, response), barCodeInfo);
        Page<CustomerQueryVo> page = null;
        model.addAttribute("page", page);
        return "modules/crm/inventoryInfo";
    }


}
