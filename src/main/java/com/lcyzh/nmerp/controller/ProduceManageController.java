package com.lcyzh.nmerp.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lcyzh.nmerp.constant.Constants;
import com.lcyzh.nmerp.controller.common.BaseController;
import com.lcyzh.nmerp.controller.system.util.SysDictUtils;
import com.lcyzh.nmerp.controller.system.util.UserUtils;
import com.lcyzh.nmerp.entity.TProdPlan;
import com.lcyzh.nmerp.entity.TStock;
import com.lcyzh.nmerp.model.vo.LabelPrint;
import com.lcyzh.nmerp.model.vo.ProdPlanDetailVo;
import com.lcyzh.nmerp.model.vo.ProdPlanVo;
import com.lcyzh.nmerp.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        model.addAttribute("list",prodPlanDetailService.findListByProdPlanCode(prodPlanCode));
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
    public String prodPlanUpdate(@ModelAttribute("vo") ProdPlanVo vo){
        TProdPlan plan = new TProdPlan();
        plan.setProdPlanCode(vo.getProdPlanCode());
        plan.setFormula(vo.getFormula());
        int result = prodPlanService.update(plan);
        return "redirect:/produce/producePlan/info?prodPlanCode="+vo.getProdPlanCode();
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
    public String producePlanDetailUpdate(String ids){
        int result = prodPlanDetailService.updateByIds(ids);
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
    public String prodDetail(Long id, Model model, HttpServletRequest request, HttpServletResponse response){
        ProdPlanDetailVo vo = new ProdPlanDetailVo();
        vo.setProdPlanDetailId(id);
        model.addAttribute("detail",prodPlanDetailService.findProdTask(vo));
        return "modules/crm/produceDetail";
    }

    @RequestMapping(value = {"produce/inStock"})
    @ResponseBody
    public ProdPlanDetailVo doInStock(Long id,Double weight,Double tare,
                                      HttpServletRequest request){
        ProdPlanDetailVo vo = new ProdPlanDetailVo();
        vo.setProdPlanDetailId(id);

        ProdPlanDetailVo voInDB = prodPlanDetailService.findProdTask(vo);
        voInDB.setItemWeight(weight);
        voInDB.setItemTareWeight(tare);

        ProdPlanDetailVo result = prodPlanDetailService.labelAndInStock(voInDB);
        result.setItemColorValue(SysDictUtils.getDictLabel(result.getItemColor(), Constants.PROD_COLOR, ""));

        HttpSession session = request.getSession();
        session.setAttribute(result.getMacCode(),result);

        return result;
    }

    @RequestMapping(value = {"produce/doPrint"})
    public String doPrint(String macCode, Model model, HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        ProdPlanDetailVo print = (ProdPlanDetailVo)session.getAttribute(macCode);

        model.addAttribute("vo",print);
        return "modules/crm/stockPrint";
    }

    @RequestMapping(value = {"produce/printCert"})
    public String rePrint(String macCode, String type, Model model,
                          HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        ProdPlanDetailVo print = (ProdPlanDetailVo)session.getAttribute(macCode);

        model.addAttribute("user",UserUtils.getUser());
        model.addAttribute("vo",print);
        String pageStr = "";
        if("red".equals(type)){
            pageStr = "modules/crm/stockCertificateRed";
        }else if("green".equals(type)){
            pageStr = "modules/crm/stockCertificateGreen";
        }
        return pageStr;
    }

    @RequestMapping(value = {"produce/rePrint"})
    public String rePrint(Long stockId, Model model, HttpServletRequest request, HttpServletResponse response){
        TStock stock = stockService.findById(stockId);
        ProdPlanDetailVo print = new ProdPlanDetailVo();
        BeanUtils.copyProperties(stock, print);
        print.setItemColorValue(SysDictUtils.getDictLabel(print.getItemColor(), Constants.PROD_COLOR, ""));

        model.addAttribute("vo",print);
        return "modules/crm/stockPrint";
    }
}
