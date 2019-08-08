package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.constant.Constants;
import com.lcyzh.nmerp.controller.common.BaseController;
import com.lcyzh.nmerp.entity.TMachineInfo;
import com.lcyzh.nmerp.entity.TRawMaterial;
import com.lcyzh.nmerp.model.vo.*;
import com.lcyzh.nmerp.service.ITFormulaService;
import com.lcyzh.nmerp.service.TRawMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Author ljk
 * Date  2019-06-06
 */
@Controller
@RequestMapping(value = "/tRawMaterial")
public class TRawMaterialController extends BaseController {
    @Autowired
    private TRawMaterialService rawMaterialService;
    @Autowired
    private ITFormulaService formulaService;

    @RequestMapping(value = {"list", ""})
    public String list(@ModelAttribute("rawMaterial") TRawMaterial rawMaterial,Model model, HttpServletRequest request, HttpServletResponse response) {
        Page<TRawMaterial> page = new Page<>(request, response);
        List<TRawMaterial> list = rawMaterialService.findAllList();
        page.setCount(list.size());
        page.setList(list);
        model.addAttribute("page", page);
        return "modules/crm/rawMaterialList";
    }

    @RequestMapping(value = {"get"}, method = RequestMethod.GET)
    public String get(@ModelAttribute("rawMaterial") TRawMaterial rawMaterial, Model model) {
        TRawMaterial rawMaterialInfo = new TRawMaterial();
        if(rawMaterial.getId() != null){
            rawMaterialInfo = rawMaterialService.get(rawMaterial.getId().toString());
        }
        model.addAttribute("rawMaterial",rawMaterialInfo);
        model.addAttribute("rawMaterialId",rawMaterialInfo.getId());
        return "modules/crm/rawMaterialForm";
    }

    @RequestMapping(value = {"/getByFormula"})
    @ResponseBody
    public List<RawMaterialVo> getByFormula( String fCode, String key) {
        // TODO 流程未通
        FormulaVo formulaVo = formulaService.findByCode(fCode);
        List<RawMaterialVo> rawMaterialList = formulaVo.getContext().get(key).getRawMaterialVos();
//        List<RawMaterialVo> rawMaterialList = new ArrayList<>();
//        if (fCode.equals("0001")) {
//            RawMaterialVo vo = new RawMaterialVo();
//            vo.setRawmName("原料一");
//            vo.setWeight("1吨");
//            rawMaterialList.add(vo);
//            vo = new RawMaterialVo();
//            vo.setRawmName("原料er");
//            vo.setWeight("1.63333吨");
//            rawMaterialList.add(vo);
//            vo = new RawMaterialVo();
//            vo.setRawmName("sd电视机分子");
//            vo.setWeight("1.双方都");
//            rawMaterialList.add(vo);
//        } else if (fCode.equals("0002")){
//            RawMaterialVo vo = new RawMaterialVo();
//            vo.setRawmName("2原料一");
//            vo.setWeight("21吨");
//            rawMaterialList.add(vo);
//            vo = new RawMaterialVo();
//            vo.setRawmName("2原料er");
//            vo.setWeight("21.63333吨");
//            rawMaterialList.add(vo);
//            vo = new RawMaterialVo();
//            vo.setRawmName("2sd电视机分子");
//            vo.setWeight("212.双方都");
//            rawMaterialList.add(vo);
//    }

        return rawMaterialList;
    }

    @RequestMapping(value = "addForm")
    public String form(@ModelAttribute("rawMaterial") TRawMaterial rawMaterial, Model model) {
        model.addAttribute("rawMaterial", rawMaterial);
        return "modules/crm/rawMaterialForm";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@ModelAttribute("rawMaterial") TRawMaterial rawMaterial, Model model, RedirectAttributes redirectAttributes) {
        if (!beanValidator(model, rawMaterial)){
            return get(rawMaterial, model);
        }
        if(rawMaterial.getId() != null){
            if (rawMaterialService.update(rawMaterial) > 0) {
                addMessage(redirectAttributes, "更新原料成功");
            } else {
                addMessage(redirectAttributes, "更新原料失败");
            }
        }else{
            if (rawMaterialService.insert(rawMaterial) > 0) {
                addMessage(redirectAttributes, "新增原料成功");
            } else {
                addMessage(redirectAttributes, "新增原料失败");
            }
        }
        return "redirect:/tRawMaterial/list";
    }

    @RequestMapping(value = "/insertBatch", method = RequestMethod.POST)
    public String insertBatch(@RequestBody List<TRawMaterial> tRawMaterials) {
        if (rawMaterialService.insertBatch(tRawMaterials) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestBody TRawMaterial tRawMaterial) {
        if (rawMaterialService.update(tRawMaterial) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/delete")
    public String delete( TRawMaterial tRawMaterial, RedirectAttributes redirectAttributes) {
        if (rawMaterialService.delete(tRawMaterial) > 0) {

            return "redirect:/tRawMaterial/list";
        } else {
            addMessage(redirectAttributes, "删除原料失败");
            return "redirect:/tRawMaterial/list";
        }

    }

}
