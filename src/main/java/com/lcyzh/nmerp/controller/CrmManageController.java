package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.constant.Constants;
import com.lcyzh.nmerp.controller.common.BaseController;
import com.lcyzh.nmerp.model.vo.*;
import com.lcyzh.nmerp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
    @Autowired
    private TProdPlanService prodPlanService;
    @Autowired
    private TProdPlanDetailService prodPlanDetailService;
    @Autowired
    private TInStockService inStockService;
    @Autowired
    private TMachineInfoService machineInfoService;
    @Autowired
    private TOutStockService outStockService;
    @Autowired
    private TStockService stockService;


    /**========================客户相关流转==============================**/

    @RequestMapping(value = {"customer/list"})
    public String list(@ModelAttribute("customer") CustomerQueryVo customer, Model model, HttpServletRequest request, HttpServletResponse response){
        customer.setPageSize(2);
        Page<CustomerQueryVo> page = customerService.findPage(new Page<CustomerQueryVo>(request, response), customer);
        model.addAttribute("page", page);
        return "modules/crm/customerList";
    }

    @RequestMapping(value = {"customer/poollist"})
    public String customerPoolList(@ModelAttribute("customer") CustomerQueryVo customer, Model model, HttpServletRequest request, HttpServletResponse response){
        customer.setFollowType(0);
        Page<CustomerQueryVo> pageRes = customerService.findPage(new Page<CustomerQueryVo>(request,response), customer);
        model.addAttribute("page", pageRes);
        return "modules/crm/customerPoolList";
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


    /**========================订单相关流转==============================**/
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


    /**========================流程\任务相关流转==============================**/
    /**
     * 审批列表
     * @param model
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = {"approval/list"})
    public String taskApproval(@ModelAttribute("order") OrderQueryVo order,Model model, HttpServletRequest request, HttpServletResponse response){
        // 获取需要审批的产品清单列表
        order.setOrdStatus(Constants.ORD_STATUS_NEW);
        Page<OrderQueryVo> page = orderService.findPage(new Page<OrderQueryVo>(request, response), order);
        model.addAttribute("page", page);
        return "modules/crm/taskApproval";
    }

    /**
     * 任务分配列表
     * @param model
     * @return
     */
    @RequestMapping(value = {"order/taskList"})
    public String taskList(@ModelAttribute("order") OrderQueryVo order, Model model, HttpServletRequest request, HttpServletResponse response){
        order.setOrdStatus(Constants.ORD_STATUS_ASSIGNED);
        Page<OrderQueryVo> page = orderService.findPage(new Page<OrderQueryVo>(request, response), order);
        model.addAttribute("page", page);
        return "modules/crm/taskList";
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



    /**========================仓库相关流转==============================**/

    /**
     * 库存列表
     * @param model
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = {"inventory/list"})
    public String inventoryList(StockQueryVo stockQueryVo,Model model, HttpServletRequest request, HttpServletResponse response){
        Page<StockQueryVo> page = stockService.findList(new Page<StockQueryVo>(request, response),stockQueryVo);
        model.addAttribute("page", page);
        return "modules/crm/inventoryList";
    }

    /**
     * 出库详情
     * @param model
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = {"inventory/info"})
    public String inventoryInfo( Model model, HttpServletRequest request, HttpServletResponse response){
        // Page<CustomerQueryVo> page = customerService.findPage(new Page<CustomerQueryVo>(request, response), barCodeInfo);
        Page<CustomerQueryVo> page = null;
        model.addAttribute("page", page);
        return "modules/crm/inventoryInfo";
    }

    /**
     * 出库清单列表页面流转
     * @param model
     * @return
     */
    @RequestMapping(value = {"inventory/outStockList"})
    public String outStockList(@ModelAttribute("outStockVo") OutStockVo outStockVo, Model model, HttpServletRequest request, HttpServletResponse response) {
        Page<OutStockVo> page = outStockService.findList(new Page<OutStockVo>(request, response), outStockVo);
        model.addAttribute("page", page);
        return "modules/crm/outStockList";
    }

    /**========================生产计划相关流转==============================**/
    /**
     * @Description: 生产计划列表
     * @Param: [vo, model, request, response]
     * @return: java.lang.String
     * @Author: wsm
     * @Iteration : 1.0
     * @Date: 2019/7/11 11:11 AM
     */
    @RequestMapping(value = {"producePlan/list","vo"})
    public String prodPlanList(@ModelAttribute("vo") ProdPlanVo vo, Model model, HttpServletRequest request, HttpServletResponse response){
        Page<ProdPlanVo> page = prodPlanService.findPage(new Page<ProdPlanVo>(request,response),vo);
        model.addAttribute("page", page);
        model.addAttribute("macList",machineInfoService.findAllList());
        return "modules/crm/producePlanList";
    }

    /**
     * @Description: 生产列表
     * @Param: [vo, model, request, response]
     * @return: java.lang.String
     * @Author: wsm
     * @Iteration : 1.0
     * @Date: 2019/7/11 11:11 AM
     */
    @RequestMapping(value = {"produce/list","vo"})
    public String produceList(@ModelAttribute("vo") ProdPlanDetailVo vo, Model model, HttpServletRequest request, HttpServletResponse response) {
        Page<ProdPlanDetailVo> page = prodPlanDetailService.findProdTaskPage(new Page<ProdPlanDetailVo>(request, response), vo);
        model.addAttribute("page", page);
        model.addAttribute("macList", machineInfoService.findAllList());
        return "modules/crm/produceList";
    }

    /**
     * 出库清单列表页面流转
     * @param model
     * @return
     */
    @RequestMapping(value = {"inventory/outStockDetail"})
    public String outStockDetail(String outCode, Model model) {
       // OutStockVo outStockVo = outStockService.
        List<StockVo> stockVos = outStockService.findOutItemsByOutCode(outCode);
        model.addAttribute("outCode",outCode);
        model.addAttribute("stocks", stockVos);
        return "modules/crm/outStockListDetail";
    }

}
