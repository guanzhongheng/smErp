package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.constant.Constants;
import com.lcyzh.nmerp.controller.common.BaseController;
import com.lcyzh.nmerp.controller.system.util.SysDictUtils;
import com.lcyzh.nmerp.controller.system.util.UserUtils;
import com.lcyzh.nmerp.entity.TOrder;
import com.lcyzh.nmerp.entity.TProdPlan;
import com.lcyzh.nmerp.entity.TProdPlanDetail;
import com.lcyzh.nmerp.entity.TStock;
import com.lcyzh.nmerp.model.vo.OrderQueryVo;
import com.lcyzh.nmerp.model.vo.ProdPlanDetailVo;
import com.lcyzh.nmerp.model.vo.ProdPlanExportVo;
import com.lcyzh.nmerp.model.vo.ProdPlanVo;
import com.lcyzh.nmerp.service.*;
import com.lcyzh.nmerp.utils.Arith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Project : nm-erp
 * @Description : TODO
 * @Author : wsm
 * @Iteration : 1.0
 * @Date : 2019/7/13  1:10 PM
 * @ModificationHistory Who          When          What
 * ----------   ------------- -----------------------------------
 * wsm          2019/07/13    create
 */
@Controller
@RequestMapping("produce")
public class ProduceManageController extends BaseController {
    @Autowired
    private TProdPlanService prodPlanService;
    @Autowired
    private TProdPlanDetailService prodPlanDetailService;
    @Autowired
    private TMachineInfoService machineInfoService;
    @Autowired
    private TStockService stockService;
    @Autowired
    private ITFormulaService formulaService;
    @Autowired
    private TRawMaterialService rawMaterialService;
    @Autowired
    private TOrderService orderService;
    @Autowired
    private TOrderItemService orderItemService;
    /**
     * @Description: 跳转到生产计划详情页面
     * @Param: [vo, prodPlanCode, model, request, response]
     * @return: java.lang.String
     * @Author: wsm
     * @Iteration : 1.0
     * @Date: 2019/7/16 9:14 AM
     */
    @RequestMapping(value = {"producePlan/info"})
    public String prodPlanDetail(@ModelAttribute("vo") ProdPlanVo vo, String prodPlanCode, Model model, HttpServletRequest request, HttpServletResponse response){
        List<TProdPlanDetail> list = prodPlanDetailService.findListByProdPlanCode(prodPlanCode);
        model.addAttribute("list",list);
        // 统计计算理论重量
        doTheoryCalculation(list,model);
        model.addAttribute("prodPlan",prodPlanService.findByProdPanCode(prodPlanCode));
        model.addAttribute("macList",machineInfoService.findAllList());
        // add formula by zj 0802
        model.addAttribute("formulaList",formulaService.findAllList());

        return "modules/crm/producePlanDetail";
    }

    /**
     * @Description: 修改生产计划的配方信息
     * @Param: [vo, request, response]
     * @return: java.lang.String
     * @Author: wsm
     * @Iteration : 1.0
     * @Date: 2019/7/16 9:14 AM
     */
    @RequestMapping(value = {"producePlan/update"})
    @ResponseBody
    public String prodPlanUpdate(@RequestBody TProdPlan prodPlan){
        TProdPlan plan = new TProdPlan();
        plan.setProdPlanCode(prodPlan.getProdPlanCode());
        plan.setFormula(prodPlan.getFormula());
        int result = prodPlanService.update(plan);
        if(result > 0){
            return "1";
        }else{
            return "0";
        }
    }

    /**
     * @Description: 批量下发生产任务到机台
     * @Param: [ids]
     * @return: java.lang.String
     * @Author: wsm
     * @Iteration : 1.0
     * @Date: 2019/7/16 9:19 AM
     */
    @RequestMapping(value = {"producePlanDetail/updateBatch"})
    @ResponseBody
    public String producePlanDetailUpdate(String ids,Double thresholdUp,Double thresholdDown){
        int result = prodPlanDetailService.updateByIds(ids,thresholdUp,thresholdDown);
        return String.valueOf(result);
    }

    /**
     * @Description: 跳转到车间机台的生产任务详情页面
     * @Param: [model, request, response]
     * @return: java.lang.String
     * @Author: wsm
     * @Iteration : 1.0
     * @Date: 2019/7/16 9:15 AM
     */
    @RequestMapping(value = {"produce/info"})
    public String prodDetail(Long id, Model model,ProdPlanDetailVo detail, HttpServletRequest request, HttpServletResponse response){
        ProdPlanDetailVo vo = new ProdPlanDetailVo();
        vo.setProdPlanDetailId(id);

        ProdPlanDetailVo voFromDb = prodPlanDetailService.findProdTask(vo);
        if(voFromDb.getItemDensity() != null && voFromDb.getItemDensity() > 0){
            Double mkfm = Arith.div(1,Arith.mul(voFromDb.getItemDensity(),voFromDb.getItemThick()));
            Double mkto = Arith.div(voFromDb.getItemWidth(),mkfm,4);
            voFromDb.setItemMickWeight(mkto * 1000);
        }else{
            voFromDb.setItemMickWeight(0d);
        }
        model.addAttribute("detail",voFromDb);

        model.addAttribute("orderItem",orderItemService.getById(voFromDb.getOrderItemId()));
        return "modules/crm/produceDetail";
    }

    /**
     * @Description: 撤销生产任务
     * @Param: [id]
     * @return: java.lang.String
     * @Author: wsm
     * @Iteration : 1.0
     * @Date: 2019/9/1 9:57 PM
     */
    @RequestMapping(value = {"produce/cancle"})
    public String prodCancle(Long id){
        prodPlanDetailService.cancelProdPlanDetailByID(id);
        return "redirect:/crm/produceCancle/list?repage";
    }

    @RequestMapping(value = {"produce/inStock"})
    @ResponseBody
    public ProdPlanDetailVo doInStock(Long id,Double weight,Double tare,String seCode,
                                      HttpServletRequest request){
        ProdPlanDetailVo vo = new ProdPlanDetailVo();
        vo.setProdPlanDetailId(id);

        ProdPlanDetailVo voInDB = prodPlanDetailService.findProdTask(vo);
        if(weight == null || weight.equals("NaN")){
            weight = Double.valueOf("0.00");
        }
        if(tare == null || tare.equals("NaN")){
            tare = Double.valueOf("0.00");
        }
        if(seCode == null){
            seCode = "";
        }
        voInDB.setItemWeight(weight);
        voInDB.setItemTareWeight(tare);
        voInDB.setSeCode(seCode);
        ProdPlanDetailVo result = prodPlanDetailService.labelAndInStock(voInDB);
        result.setItemColorValue(SysDictUtils.getDictLabel(result.getItemColor(), Constants.PROD_COLOR, ""));

        HttpSession session = request.getSession();
        session.setAttribute(UserUtils.getUser().getId(),result);

        return result;
    }

    @RequestMapping(value = {"produce/doPrint"})
    public String doPrint(Model model, HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        ProdPlanDetailVo print = (ProdPlanDetailVo)session.getAttribute(UserUtils.getUser().getId());
        model.addAttribute("user",UserUtils.getUser());
        model.addAttribute("vo",print);
        return "modules/crm/stockPrint";
    }

    @RequestMapping(value = {"produce/printCert"})
    public String rePrint(String type, Model model,
                          HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        ProdPlanDetailVo print = (ProdPlanDetailVo)session.getAttribute(UserUtils.getUser().getId());

        model.addAttribute("user",UserUtils.getUser());
        model.addAttribute("vo",print);
        String pageStr = "";
        if("red".equals(type)){
            pageStr = "modules/crm/stockCertificateRed";
        }else if("green".equals(type)){
            pageStr = "modules/crm/stockCertificateGreen";
        }else if("yellow".equals(type)){
            pageStr = "modules/crm/stockCertificateYellow";
        }else if("new".equals(type)){
            pageStr = "modules/crm/stockCertificateNew";
        }
        return pageStr;
    }

    @RequestMapping(value = {"produce/rePrint"})
    public String rePrint(Long stockId, Model model, HttpServletRequest request, HttpServletResponse response){
        TStock stock = stockService.findById(stockId);
        ProdPlanDetailVo print = new ProdPlanDetailVo();
        BeanUtils.copyProperties(stock, print);

        OrderQueryVo order = orderService.findByOrdeCode(stock.getOrdCode());
        print.setProxyName(order.getProxyName());

        print.setItemColorValue(SysDictUtils.getDictLabel(print.getItemColor(), Constants.PROD_COLOR, ""));
        model.addAttribute("user",UserUtils.getUser());
        model.addAttribute("vo",print);
        return "modules/crm/stockPrint";
    }

    @RequestMapping(value = {"produce/rePrintCert"})
    public String rePrintCert(Long stockId,String type, Model model,
                          HttpServletRequest request, HttpServletResponse response){
        TStock stock = stockService.findById(stockId);
        ProdPlanDetailVo print = new ProdPlanDetailVo();
        BeanUtils.copyProperties(stock, print);

        OrderQueryVo order = orderService.findByOrdeCode(stock.getOrdCode());
        print.setProxyName(order.getProxyName());

        model.addAttribute("user",UserUtils.getUser());
        model.addAttribute("vo",print);
        String pageStr = "";
        if("red".equals(type)){
            pageStr = "modules/crm/stockCertificateRed";
        }else if("green".equals(type)){
            pageStr = "modules/crm/stockCertificateGreen";
        }else if("yellow".equals(type)){
            pageStr = "modules/crm/stockCertificateYellow";
        }else if("new".equals(type)){
            pageStr = "modules/crm/stockCertificateNew";
        }
        return pageStr;
    }

    // 计算理论重量值
    public void doTheoryCalculation(List<TProdPlanDetail> list,Model model){
        if(!CollectionUtils.isEmpty(list)){
            Double totalWi = 0d;
            list.forEach(n->{
                Double mj = Arith.mul(n.getItemLenth(),n.getItemWidth());
                Double mjt = Arith.mul(mj,n.getItemNum());
                Double fm = Arith.div(1,Arith.mul(0.95,n.getItemThick()));
                Double to = Arith.div(mjt,fm,4);
                n.setTheoryWeight(to);
            });
            totalWi = list.stream().mapToDouble(i->i.getTheoryWeight()).sum();
            model.addAttribute("theoryTotalWeight",totalWi);
        }
    }
}
