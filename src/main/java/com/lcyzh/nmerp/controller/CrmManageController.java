package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.common.lang.StringUtils;
import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.constant.Constants;
import com.lcyzh.nmerp.controller.common.BaseController;
import com.lcyzh.nmerp.controller.system.util.UserUtils;
import com.lcyzh.nmerp.dao.TCustomerMapper;
import com.lcyzh.nmerp.entity.TFormula;
import com.lcyzh.nmerp.entity.TOutStock;
import com.lcyzh.nmerp.entity.TProdPlanDetail;
import com.lcyzh.nmerp.entity.sys.Role;
import com.lcyzh.nmerp.entity.sys.User;
import com.lcyzh.nmerp.model.vo.*;
import com.lcyzh.nmerp.service.*;
import com.lcyzh.nmerp.service.security.SystemService;
import com.lcyzh.nmerp.utils.Arith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Comparator;
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

    @Autowired
    private SystemService systemService;
    @Autowired
    private ITFormulaService formulaService;
    @Autowired
    private TCustomerMapper tCustomerMapper;
    /**========================客户相关流转==============================**/

    @RequestMapping(value = {"customer/list"})
    public String list(@ModelAttribute("customer") CustomerQueryVo customer, Model model, HttpServletRequest request, HttpServletResponse response){
        Page<CustomerQueryVo> page = new Page<>(request, response);
        if(customer.getFollowType()!=null && customer.getFollowType()==1){
            customer.setCusStatus(Constants.CUS_STATUS_FLLOW);
        }
        customer.setCusName(StringUtils.trimToNull(customer.getCusName()));
        List<CustomerQueryVo> list = customerService.findPage(page, customer);
        page.setCount(list.size());
        page.setList(list);
        model.addAttribute("page", page);
        return "modules/crm/customerList";
    }

    @RequestMapping(value = {"customer/poollist"})
    public String customerPoolList(@ModelAttribute("customer") CustomerQueryVo customer, Model model, HttpServletRequest request, HttpServletResponse response){
        customer.setCusStatus(Constants.CUS_STATUS_UNFLLOW);
        Page<CustomerQueryVo> page = new Page<>(request, response);
        List<CustomerQueryVo> list = customerService.findPage(page, customer);
        page.setCount(list.size());
        page.setList(list);
        model.addAttribute("page", page);
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
        List<User> userList = systemService.findUser(new User());
        model.addAttribute("userList",userList);
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
        Page<OrderQueryVo> page = new Page<>(request, response);
        List<OrderQueryVo> list = orderService.findPage(page, order);
        doCalOrderInfo(list,model);
        page.setCount(list.size());
        page.setList(list);
        model.addAttribute("page", page);
        model.addAttribute("userId",UserUtils.getUser().getId());
        return "modules/crm/orderList";
    }
    /**
     * 订单上传
     * @return
     */
    @RequestMapping(value = {"order/upload"})
    public String orderList(){
        return "modules/crm/orderFileUpload";
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
        Page<OrderQueryVo> page = new Page<>(request, response);
        List<OrderQueryVo> list = orderService.findPage(page, order);
        page.setCount(list.size());
        page.setList(list);
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
        Page<OrderQueryVo> page = new Page<>(request, response);
        List<OrderQueryVo> list = orderService.findPage(page, order);
        page.setCount(list.size());
        page.setList(list);
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
        Page<StockQueryVo> page = new Page<>(request, response);
        List<StockQueryVo> list = stockService.findList(page,stockQueryVo);
        page.setCount(list.size());
        page.setList(list);
        doCalInventoryInfo(list,model);
        User user = UserUtils.getUser();
        if(!CollectionUtils.isEmpty(user.getRoleList())){
            model.addAttribute("role", user.getRoleList().get(0));
        }
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
        Page<OutStockVo> page = new Page<>(request, response);
        List<OutStockVo> list = outStockService.findList(page, outStockVo);
        page.setCount(list.size());
        page.setList(list);
        model.addAttribute("page", page);
        return "modules/crm/outStockList";
    }

    /**
     * 出库清单列表页面流转
     * @param model
     * @return
     */
    @RequestMapping(value = {"inventory/outStockDetail"})
    public String outStockDetail(String outCode, Model model) {
        TOutStock outStock = outStockService.findByCode(outCode);
        model.addAttribute("outStock",outStock);
        List<OutStockDetailVo> list = outStockService.getOutStockDetailInfos(outCode);
        doCalOutStock(list,model);
        model.addAttribute("list", list);
        return "modules/crm/outStockListDetail";
    }


    /**
     * 产品清单列表页面流转
     * @param model
     * @return
     */
    @RequestMapping(value = {"inventory/prodStockList"})
    public String prodStockList(@ModelAttribute("orderQueryVo") OrderQueryVo orderQueryVo, Model model, HttpServletRequest request, HttpServletResponse response) {
        Page<OrderQueryVo> page = new Page<>(request, response);
        orderQueryVo.setIsTj(1);
        List<OrderQueryVo> list = orderService.findPage(page,orderQueryVo);
        page.setCount(list.size());
        page.setList(list);
        // 获取统计数据信息
        doCalculationTotal(list,model);
        model.addAttribute("page", page);
        return "modules/crm/prodStockList";
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
        Page<ProdPlanVo> page = new Page<>(request, response);
        List<ProdPlanVo> list = prodPlanService.findPage(page,vo);
        page.setCount(list.size());
        page.setList(list);
        model.addAttribute("page", page);
        model.addAttribute("macList",machineInfoService.findAllList());
        return "modules/crm/producePlanList";
    }

    @RequestMapping("producePlan/export")
    public String producePlanExport(HttpServletRequest request, ProdPlanExportVo exportVo, Model model){
        model.addAttribute("exportVo",new ProdPlanExportVo());
        List<CustomerQueryVo> listPo = tCustomerMapper.findList(null);
        model.addAttribute("customers",listPo);
        return "modules/crm/producePlanExport";
    }

    /**
     * @Description: 生产列表
     * @Param: [vo, model, request, response]
     * @return: java.lang.String
     * @Author: wsm
     * @Iteration : 1.0TOutStockVo
     * @Date: 2019/7/11 11:11 AM
     */
    @RequestMapping(value = {"produce/list","vo"})
    public String produceList(@ModelAttribute("vo") ProdPlanDetailVo vo, Model model, HttpServletRequest request, HttpServletResponse response) {
        Page<ProdPlanDetailVo> page = new Page<>(request, response);
        List<ProdPlanDetailVo> list = prodPlanDetailService.findProdTaskPage(page, vo);
        doTheoryCalculationForPd(list,model);
        page.setCount(list.size());
        page.setList(list);
        model.addAttribute("page", page);
        model.addAttribute("macList", machineInfoService.findAllList());
        return "modules/crm/produceList";
    }

    @RequestMapping(value = {"produceCancle/list","vo"})
    public String produceCancleList(@ModelAttribute("vo") ProdPlanDetailVo vo, Model model, HttpServletRequest request, HttpServletResponse response) {
        Page<ProdPlanDetailVo> page = new Page<>(request, response);
        List<ProdPlanDetailVo> list = prodPlanDetailService.findProdTaskPage(page, vo);
        doTheoryCalculationForPd(list,model);
        page.setCount(list.size());
        page.setList(list);
        model.addAttribute("page", page);
        model.addAttribute("macList", machineInfoService.findAllList());
        return "modules/crm/produceCancleList";
    }


    /**========================配方管理相关流转==============================**/
    /**
     * 配方列表
     */
    @RequestMapping(value = {"formula/list"})
    public String formulaList(@ModelAttribute("formula") TFormula formula, Model model, HttpServletRequest request, HttpServletResponse response) {
        Page<FormulaVo> page = new Page<>(request, response);
        model.addAttribute("page", formulaService.findPage(page,formula));
        return "modules/crm/formulaList";
    }

    // 计算理论重量值
    public void doTheoryCalculationForPd(List<ProdPlanDetailVo> list, Model model){
        if(!CollectionUtils.isEmpty(list)){
            Double totalWi = 0d;
            list.forEach(n->{
                Double mj = Arith.mul(n.getItemLenth(),n.getItemWidth());
                Double mjt = Arith.mul(mj,n.getItemNum());
                Double fm = Arith.div(1,Arith.mul(n.getItemDensity(),n.getItemThick()));
                Double to = Arith.div(mjt,fm,4);
                if(n.getItemDensity() != null && n.getItemDensity() > 0){
                    Double mkfm = Arith.div(1,Arith.mul(n.getItemDensity(),n.getItemThick()));
                    Double mkto = Arith.div(n.getItemWidth(),mkfm,4);
                    n.setItemMickWeight(Arith.round((mkto * 1000),4));
                }else{
                    n.setItemMickWeight(0d);
                }
                n.setTheoryWeight(to);
            });
            list.sort(Comparator.comparing(ProdPlanDetailVo::getItemWidth).thenComparing(ProdPlanDetailVo::getItemMickWeight));
            totalWi = list.stream().mapToDouble(i->i.getTheoryWeight()).sum();
            model.addAttribute("theoryTotalWeight",Arith.round(totalWi,4));
        }
    }


    public void doCalculationTotal(List<OrderQueryVo> list, Model model){
        Double totalWeight = list.stream().mapToDouble(i->i.getOrdTotalWeight() == null?0:i.getOrdTotalWeight()).sum();
        Double totalMj = list.stream().mapToDouble(i->i.getOrdTotalSq() == null?0:i.getOrdTotalSq   ()).sum();
        Double orderNum = list.stream().mapToDouble(i->i.getOrdTotalNum() == null?0:i.getOrdTotalNum()).sum();
        Double invNum = list.stream().mapToDouble(i->i.getTotalNum() == null?0:i.getTotalNum()).sum();

        Double invWeightPrice = list.stream().mapToDouble(i->i.getTotalWtPrice() == null?0:i.getTotalWtPrice()).sum();
        Double invMjprice = list.stream().mapToDouble(i->i.getTotalSqPrice() == null?0:i.getTotalSqPrice()).sum();
        Double invTotalprice = list.stream().mapToDouble(i->i.getTotalPrice() == null?0:i.getTotalPrice()).sum();
        Double outNum = list.stream().mapToDouble(i->i.getOrdOutNum() == null?0:i.getOrdOutNum()).sum();
        Double unOutNum = list.stream().mapToDouble(i->{
            if(Arith.sub(i.getOrdTotalNum(),i.getOrdOutNum()) > 0){
                return Arith.sub(i.getOrdTotalNum(),i.getOrdOutNum());
            }else{
                return 0;
            }
        }).sum();

        model.addAttribute("totalWeight",Arith.round(totalWeight,4));
        model.addAttribute("totalMj",Arith.round(totalMj,4));
        model.addAttribute("orderNum",Arith.round(orderNum,4));
        model.addAttribute("invNum",Arith.round(invNum,4));
        model.addAttribute("invWeightPrice",Arith.round(invWeightPrice,4));
        model.addAttribute("invMjprice",Arith.round(invMjprice,4));
        model.addAttribute("outNum",Arith.round(outNum,4));
        model.addAttribute("unOutNum",Arith.round(unOutNum,4));
        model.addAttribute("invTotalprice",Arith.round(invTotalprice,4));
    }

    public void doCalOrderInfo(List<OrderQueryVo> list,Model model){
        Double totalPrice = list.stream().mapToDouble(i->i.getOrderPrice() == null?0:i.getOrderPrice()).sum();
        model.addAttribute("totalPrice",Arith.round(totalPrice,4));
    }

    public void doCalInventoryInfo(List<StockQueryVo> list,Model model){
        Double totalWeight = list.stream().mapToDouble(i->i.getItemWeight() == null?0:i.getItemWeight()).sum();
        model.addAttribute("totalWeight",Arith.round(totalWeight,4));
    }

    public void doCalOutStock(List<OutStockDetailVo> list,Model model){
        Double totalWeight = list.stream().mapToDouble(i->i.getItemWeight() == null?0:i.getItemWeight()).sum();
        Double totalPrice = list.stream().mapToDouble(i->i.getPrice() == null?0:i.getPrice()).sum();
        model.addAttribute("totalWeight",Arith.round(totalWeight,4));
        model.addAttribute("totalPrice",Arith.round(totalPrice,4));

    }

    @RequestMapping(value = "updateStockInfo")
    public String updateStockInfo(HttpServletRequest request, Model model){
        model.addAttribute("stockId",request.getParameter("stockId"));
        return "modules/crm/stockWeightUp";
    }


}
