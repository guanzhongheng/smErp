package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.controller.common.BaseController;
import com.lcyzh.nmerp.entity.TProdPlan;
import com.lcyzh.nmerp.model.vo.ProdPlanDetailVo;
import com.lcyzh.nmerp.model.vo.ProdPlanVo;
import com.lcyzh.nmerp.service.TMachineInfoService;
import com.lcyzh.nmerp.service.TProdPlanDetailService;
import com.lcyzh.nmerp.service.TProdPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    public ProdPlanDetailVo doInStock(Long id,String weight){
        ProdPlanDetailVo vo = new ProdPlanDetailVo();
        vo.setProdPlanDetailId(id);

        ProdPlanDetailVo voInDB = prodPlanDetailService.findProdTask(vo);
        voInDB.setItemWeight(weight);

        ProdPlanDetailVo result = prodPlanDetailService.labelAndInStock(voInDB);
        return result;
    }
}
