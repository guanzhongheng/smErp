package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.constant.Constants;
import com.lcyzh.nmerp.controller.common.BaseController;
import com.lcyzh.nmerp.controller.system.util.SysDictUtils;
import com.lcyzh.nmerp.controller.system.util.UserUtils;
import com.lcyzh.nmerp.entity.*;
import com.lcyzh.nmerp.model.vo.*;
import com.lcyzh.nmerp.service.*;
import com.lcyzh.nmerp.utils.Arith;
import com.lcyzh.nmerp.utils.DictUtils;
import com.lcyzh.nmerp.utils.StringUtils;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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
    public String prodPlanDetail(String prodPlanCode, Model model, HttpServletRequest request, HttpServletResponse response){
        ProdPlanListVo prodPlanList = new ProdPlanListVo();
        prodPlanList.setProdPlanCode(prodPlanCode);
        List<TProdPlanDetail> list = prodPlanDetailService.findListByProdPlanCodes(prodPlanList);
        model.addAttribute("list",list);
        // 统计计算理论重量
        doTheoryCalculation(list,model);
        model.addAttribute("prodPlan",prodPlanService.findByProdPanCodes(prodPlanCode));
        model.addAttribute("macList",machineInfoService.findAllList());
        // add formula by zj 0802
        model.addAttribute("formulaList",formulaService.findAllList());

        return "modules/crm/producePlanDetail";
    }

    /**
     * @Description: 跳转到生产计划详情页面
     * @Param: [vo, prodPlanCode, model, request, response]
     * @return: java.lang.String
     * @Author: wsm
     * @Iteration : 1.0
     * @Date: 2019/7/16 9:14 AM
     */
    @RequestMapping(value = {"producePlan/detailList"})
    public String prodPlanDetailList(@ModelAttribute("vo") ProdPlanListVo vo, Model model, HttpServletRequest request, HttpServletResponse response){

        List<TProdPlanDetail> list = prodPlanDetailService.findListByProdPlanCodes(vo);
        model.addAttribute("list",list);
        // 统计计算理论重量
        doTheoryCalculation(list,model);
        model.addAttribute("prodPlan",prodPlanService.findByProdPanCodes(vo.getProdPlanCode()));

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
     * TODO 修改 保存配方信息到订单详情产品中
     */
    @RequestMapping(value = {"producePlan/update"})
    @ResponseBody
    public String prodPlanUpdate(@RequestBody TProdPlan prodPlan){
        TProdPlan plan = new TProdPlan();
        plan.setProdPlanCode(prodPlan.getProdPlanCode());
        plan.setFormula(prodPlan.getFormula());
        if(StringUtils.isNotEmpty(prodPlan.getPlanDetailIds()) && prodPlan.getPlanDetailIds().endsWith(",")){
            plan.setPlanDetailIds(prodPlan.getPlanDetailIds().substring(0,prodPlan.getPlanDetailIds().length()-1));
        }else{
            plan.setPlanDetailIds("");
        }
        try {
            int result = prodPlanService.update(plan);
            if(result > 0){
                return "1";
            }else{
                return "0";
            }
        }catch (Exception e){
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
    public String prodDetail(Model model,ProdPlanDetailVo detail, HttpServletRequest request, HttpServletResponse response){
        List<String> nList = new ArrayList<>();
        nList.add(detail.getProdPlanDetailId().toString());
        // 获取任务列表
        List<ProdPlanDetailVo> prodPlanDetails = prodPlanDetailService.getTaskDetailInfos(nList);
        // 获取生产任务产品信息
        doSetObjectInfo(detail.getProdPlanDetailId(),model);
        doTheoryCalculationForPdNew(prodPlanDetails);
        model.addAttribute("planList",prodPlanDetails);
        model.addAttribute("planDetail",detail);
        model.addAttribute("allPlanIds",detail.getProdPlanDetailId());
        return "modules/crm/produceDetail";
    }

    /**
     * 获取生产界面第一个处理的产品类型
     * @param id
     * @param model
     */
    public void doSetObjectInfo(Long id, Model model){
        ProdPlanDetailVo vo = new ProdPlanDetailVo();
        vo.setProdPlanDetailId(id);
        ProdPlanDetailVo voFromDb = prodPlanDetailService.findProdTask(vo);
        voFromDb.setItemYcLenth(voFromDb.getItemLenth()); // 默认等于实际长度
        String n = SysDictUtils.getDictDesc(voFromDb.getItemYcType(),Constants.PROD_YC_TYPE,"");
        if(n!= null && n.length() > 0 && StringUtils.isNumber(n)){
            Double d = Double.parseDouble(n);
            Double sj = Arith.mul(voFromDb.getItemLenth(),d);
            voFromDb.setItemYcLenth(Arith.round(sj,4));
        }
        if(voFromDb.getItemDensity() != null && voFromDb.getItemDensity() > 0){
            Double mkfm = Arith.div(1,Arith.mul(voFromDb.getItemDensity(),voFromDb.getItemThick()));
            Double mkto = Arith.div(voFromDb.getItemWidth(),mkfm,4);
            voFromDb.setItemMickWeight(mkto * 1000);
        }else{
            voFromDb.setItemMickWeight(0d);

        }
        model.addAttribute("detail",voFromDb);
        model.addAttribute("orderItem",orderItemService.getById(voFromDb.getOrderItemId()));
    }

    /**
     * @Description: 批量选择任务单处理方式
     * @Param: [model, request, response]
     * @return: java.lang.String
     * @Author: wsm
     * @Iteration : 1.0
     * @Date: 2019/7/16 9:15 AM
     */
    @RequestMapping(value = {"produce/infoList"})
    public String prodDetails(Model model,ProdPlanDetailVo detail,HttpServletRequest request, HttpServletResponse response){
        // 判定获取信息
        if(StringUtils.isNotEmpty(detail.getProdPlanDetailIds()) && detail.getProdPlanDetailIds().length() > 1){
            String[] nIds = detail.getProdPlanDetailIds().split(",");
            List<ProdPlanDetailVo> prodPlanDetails = prodPlanDetailService.getTaskDetailInfos(Arrays.asList(nIds));
            Long oldId = Long.parseLong(nIds[0]);
            doSetObjectInfo(oldId,model);
            doTheoryCalculationForPdNew(prodPlanDetails);
            model.addAttribute("planList",prodPlanDetails);
            model.addAttribute("allPlanIds",detail.getProdPlanDetailIds());
            model.addAttribute("planDetail",detail);
            return "modules/crm/produceDetail";
        }else{
            return "redirect:crm/produce/list";
        }
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

    /**
     * @Description: 批量撤销生产任务
     * @Param: [id]
     * @return: java.lang.String
     * @Author: wsm
     * @Iteration : 1.0
     * @Date: 2019/9/1 9:57 PM
     */
    @RequestMapping(value = {"produce/cancleList"})
    public String prodListCancle(String ids){
        prodPlanDetailService.cancelProdPlanDetailByIds(ids);
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

        OrderQueryVo order = orderService.findByOrdeCode(voInDB.getOrdCode());
        voInDB.setCusName(order.getCusName());

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
        Double w = Arith.sub(print.getItemWeight(),print.getItemTareWeight());
        print.setTrueWeight(Arith.round(w,2));
        model.addAttribute("user",UserUtils.getUser());
        model.addAttribute("vo",print);
        return "modules/crm/stockPrint";
    }

    @RequestMapping(value = {"produce/printCert"})
    public String rePrint(String type, Model model,
                          HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        ProdPlanDetailVo print = (ProdPlanDetailVo)session.getAttribute(UserUtils.getUser().getId());
        setUseTime(print);
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
        }else if("light".equals(type)){
            pageStr = "modules/crm/stockCertificateLight";
        }
        return pageStr;
    }

    @RequestMapping(value = {"produce/rePrint"})
    public String rePrint(Long stockId, Model model, HttpServletRequest request, HttpServletResponse response){
        TStock stock = stockService.findById(stockId);
        ProdPlanDetailVo print = new ProdPlanDetailVo();
        BeanUtils.copyProperties(stock, print);

        OrderQueryVo order = orderService.findByOrdeCode(stock.getOrdCode());
        print.setCusName(order.getCusName());

        TOrderItem orderItem = orderItemService.getById(stock.getOrderItemId());
        print.setItemPriceType(orderItem.getItemPriceType());

        print.setItemColorValue(SysDictUtils.getDictLabel(print.getItemColor(), Constants.PROD_COLOR, ""));

        Double w = Arith.sub(print.getItemWeight(),print.getItemTareWeight());
        print.setTrueWeight(Arith.round(w,2));
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

        TOrderItem orderItem = orderItemService.getById(stock.getOrderItemId());
        print.setItemPriceType(orderItem.getItemPriceType());
        setUseTime(print);
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
        }else if("light".equals(type)){
            pageStr = "modules/crm/stockCertificateLight";
        }
        return pageStr;
    }
    // 获取产品推荐使用时间
    public void setUseTime(ProdPlanDetailVo print){
        if(print.getItemVariety() != null){
           String name = DictUtils.getValueByDictKey(print.getItemVariety());
           if(name.indexOf("两年") > -1){
               print.setUseTime("24个月");
           }else if(name.indexOf("超长寿") > -1){
               print.setUseTime("36个月");
           }else if(name.indexOf("大姜膜") > -1){
               print.setUseTime("6个月");
           }else if(name.indexOf("单防膜") > -1 || name.indexOf("普通地膜") > -1){
               print.setUseTime("3个月");
           }else{
               print.setUseTime("12个月");
           }
        }
    }
    // 产品信息追踪
    @RequestMapping(value = {"history/find"})
    public String findProdForHistory(@ModelAttribute("vo") ProduceHistoryVo vo,Model model){
        if(StringUtils.isNotEmpty(vo.getBarCode())){
            ProduceHistoryVo prodInfo = prodPlanDetailService.findProdForHistory(vo.getBarCode());
            // itemWidth/(1/(itemDensity*itemThick))
            if(prodInfo != null && prodInfo.getProdDensity() != null && prodInfo.getItemThick() != null && prodInfo.getItemWidth() != null){
                Double mkfm = Arith.div(1,Arith.mul(prodInfo.getProdDensity(),prodInfo.getItemThick()));
                Double mkto = Arith.div(prodInfo.getItemWidth(),mkfm,4);
                prodInfo.setItemMickWeight(Arith.round((mkto * 1000),4));
            }
            model.addAttribute("prod",prodInfo);
        }else{
            model.addAttribute("prod",new ProduceHistoryVo());
        }
        return  "modules/crm/prodHistoryInfo";
    }


    // 计算理论重量值
    public void doTheoryCalculation(List<TProdPlanDetail> list,Model model){
        if(!CollectionUtils.isEmpty(list)){
            Double totalWi = 0d;
            list.forEach(n->{
                Double mj = Arith.mul(n.getItemLenth(),n.getItemWidth());
                Double mjt = Arith.mul(mj,n.getItemNum());
                Double fm = Arith.div(1,Arith.mul(n.getItemDensity(),n.getItemThick()));
                Double to = Arith.div(mjt,fm,4);
                n.setTheoryWeight(to);
            });
            totalWi = list.stream().mapToDouble(i->i.getTheoryWeight()).sum();
            model.addAttribute("theoryTotalWeight",Arith.round(totalWi,4));
        }
    }

    // 计算理论重量值
    public void doTheoryCalculationForPdNew(List<ProdPlanDetailVo> list){
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
        }
    }
}
