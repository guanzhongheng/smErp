package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.controller.common.BaseController;
import com.lcyzh.nmerp.entity.TEquipment;
import com.lcyzh.nmerp.service.TEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 项目名称：nm-erp
 * 类 名 称：TEquipmentController
 * 类 描 述：TODO
 * 创建时间：2019/9/11 2:31 PM
 * 创 建 人：guan
 */
@Controller
@RequestMapping("equipment")
public class TEquipmentController extends BaseController {


    @Autowired
    private TEquipmentService equipmentService;

    @RequestMapping(value = {"list"})
    public String list(@ModelAttribute("equipment") TEquipment equipment, Model model, HttpServletRequest request, HttpServletResponse response){
        Page<TEquipment> page = new Page<>(request, response);
        List<TEquipment> list = equipmentService.findPageList(page, equipment);
        page.setCount(list.size());
        page.setList(list);
        model.addAttribute("page", page);
        return "modules/crm/equipmentList";
    }

    /**
     * 修改跳转
     * @param equipment
     * @param model
     * @return
     */
    @RequestMapping(value = {"/get"}, method = RequestMethod.GET)
    public String get(@ModelAttribute("equipment") TEquipment equipment, Model model) {
        TEquipment machineInfo = new TEquipment();
        if(equipment.getEqId() != null){
            machineInfo = equipmentService.findById(equipment.getEqId());
        }
        model.addAttribute("equipment",machineInfo);
        model.addAttribute("eqId",equipment.getEqId());
        return "modules/crm/equipmentForm";
    }

    /**
     * 新增
     * @param equipment
     * @param model
     * @return
     */
    @RequestMapping(value = "addForm")
    public String form(@ModelAttribute("equipment") TEquipment equipment, Model model) {
        model.addAttribute("equipment", equipment);
        return "modules/crm/equipmentForm";
    }

    @RequestMapping(value = "save")
    public String save(TEquipment equipment, HttpServletRequest request, Model model, RedirectAttributes redirectAttributes){
        if(equipment.getEqId() != null && equipment.getEqId() > 0){
            // 更新数据
            int res = equipmentService.update(equipment);
            if(res > 0){
                addMessage(redirectAttributes, "修改设备信息'" + equipment.getMacAddress() + "'成功");

            }else{
                addMessage(redirectAttributes, "修改设备信息'" + equipment.getMacAddress() + "'失败");
            }
        }else{
            int res = equipmentService.insert(equipment);
            if(res > 0){
                addMessage(redirectAttributes, "保存设备信息'" + equipment.getMacAddress() + "'成功");
            }else if(res == -2){
                addMessage(redirectAttributes, "设备信息'" + equipment.getMacAddress() + "'已经存在");
            }else{
                addMessage(redirectAttributes, "保存设备信息'" + equipment.getMacAddress() + "'失败");
            }
        }
        return "redirect:/equipment/list";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@ModelAttribute("equipment") TEquipment equipment, RedirectAttributes redirectAttributes) {
        if (equipmentService.delete(equipment) > 0) {
            return "redirect:/equipment/list";
        } else {
            addMessage(redirectAttributes, "删除设备失败");
            return "redirect:/equipment/list";
        }
    }

}
