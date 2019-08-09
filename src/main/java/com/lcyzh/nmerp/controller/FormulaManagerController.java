package com.lcyzh.nmerp.controller;

import com.alibaba.fastjson.JSONObject;
import com.lcyzh.nmerp.controller.common.BaseController;
import com.lcyzh.nmerp.controller.system.util.SysDictUtils;
import com.lcyzh.nmerp.entity.TFormula;
import com.lcyzh.nmerp.entity.TRawMaterial;
import com.lcyzh.nmerp.entity.sys.Dict;
import com.lcyzh.nmerp.model.vo.FormulaDetailVo;
import com.lcyzh.nmerp.model.vo.FormulaVo;
import com.lcyzh.nmerp.service.ITFormulaService;
import com.lcyzh.nmerp.service.TRawMaterialService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Project : nm-erp
 * @Description : 配方管理控制层
 * @Author : wsm
 * @Iteration : 1.0
 * @Date : 2019/8/2  6:07 PM
 * @ModificationHistory Who          When          What
 * ----------   ------------- -----------------------------------
 * wsm          2019/08/02    create
 */
@Controller
@RequestMapping("formula")
public class FormulaManagerController extends BaseController {
    @Autowired
    private ITFormulaService formulaService;
    @Autowired
    private TRawMaterialService rawMaterialService;

    @RequestMapping(value = {"addOrUpdate"})
    public String addOrUpdate(String fCode, Model model){
        if(fCode != null && !"".equals(fCode)){
            model.addAttribute("fCode",fCode);
            model.addAttribute("formula",formulaService.findByCode(fCode));
        }
        return "modules/crm/formulaAdd";
    }

    @RequestMapping(value = {"save"})
    public String save(@ModelAttribute("formula") FormulaVo formula, Model model,HttpServletRequest request, HttpServletResponse response){
        int result = 0;

        TFormula tFormula = new TFormula();
        BeanUtils.copyProperties(formula, tFormula);

        if(formula.getfCode() != null && !"".equals(formula.getfCode())){
            result = formulaService.update(tFormula);
            model.addAttribute("fCode",tFormula.getfCode());
        }else{
            model.addAttribute("fCode",formulaService.insert(tFormula));
        }
        return "modules/crm/formulaAdd";
    }

    @RequestMapping(value = {"updateDetail"})
    public String updateDetail(String fCode, String type,Model model){
        if(fCode != null && !"".equals(fCode)){
            model.addAttribute("fCode",fCode);
            FormulaVo vo = formulaService.findByCode(fCode);
            if(vo.getContext() != null){
                FormulaDetailVo detailVo = vo.getContext().get(type);
                if(detailVo != null){
                    model.addAttribute("detail",detailVo);
                }
            }
        }
        model.addAttribute("rmList",rawMaterialService.findAllList());
        model.addAttribute("type",type);
        return "modules/crm/formulaDetailEdit";
    }

    @RequestMapping(value = {"detailSave"})
    public String detailSave(@ModelAttribute("detailVo") FormulaDetailVo detailVo,@ModelAttribute("fCode") String fCode,
                             @ModelAttribute("type") String type, Model model,
                             HttpServletRequest request, HttpServletResponse response){
        int result = 0;
        FormulaVo vo = formulaService.findByCode(fCode);
        Map<String, FormulaDetailVo> context = vo.getContext();

        if(context == null){
            context = new HashMap<>();
            context.put(type,detailVo);
        } else {
            if( vo.getContext().get(type) != null){
                context.remove(type);
                context.put(type,detailVo);
            }else{
                context.put(type,detailVo);
            }
        }

        TFormula formula = new TFormula();
        formula.setfCode(fCode);
        formula.setfContext(JSONObject.toJSONString(context));

        result = formulaService.update(formula);

        model.addAttribute("type",type);
        model.addAttribute("fCode",fCode);
        return "redirect:/formula/updateDetail?fCode="+fCode+"&type="+type;
    }

    /**
     * 获取原料列表
     */
    @RequestMapping(value = "ajaxRmList")
    @ResponseBody
    public List<TRawMaterial> ajaxRmList() {
        return rawMaterialService.findAllList();
    }
}
