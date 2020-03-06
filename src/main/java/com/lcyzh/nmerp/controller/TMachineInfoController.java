package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.controller.common.BaseController;
import com.lcyzh.nmerp.entity.TMachineInfo;
import com.lcyzh.nmerp.entity.TProduct;
import com.lcyzh.nmerp.model.vo.MachineInfoVo;
import com.lcyzh.nmerp.model.vo.ProductVo;
import com.lcyzh.nmerp.model.vo.StockQueryVo;
import com.lcyzh.nmerp.service.TMachineInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Author ljk
 * Date  2019-06-06
 */
@Controller
@RequestMapping(value = "/tMachineInfo")
public class TMachineInfoController  extends BaseController {
    @Autowired
    private TMachineInfoService tMachineInfoService;

    @RequestMapping(value = {"/list", ""})
    public String list(@ModelAttribute("machine")TMachineInfo machine, Model model, HttpServletRequest request, HttpServletResponse response) {
        Page<MachineInfoVo> page = new Page<>(request, response);
        List<MachineInfoVo> list = tMachineInfoService.findPage(page, machine);
        page.setCount(list.size());
        page.setList(list);
        model.addAttribute("page", page);

        return "modules/crm/machineList";
    }

    @RequestMapping(value = {"/get"}, method = RequestMethod.GET)
    public String get(@ModelAttribute("machine") TMachineInfo machine, Model model) {
        TMachineInfo machineInfo = new TMachineInfo();
        if(machine.getId() != null){
            machineInfo = tMachineInfoService.findById(machine.getId());
        }
        model.addAttribute("machine",machineInfo);
        model.addAttribute("machineId",machineInfo.getId());
        return "modules/crm/machineForm";
    }

    @RequestMapping(value = "addForm")
    public String form(@ModelAttribute("machine") TMachineInfo machine, Model model) {
        model.addAttribute("machine", machine);
        return "modules/crm/machineForm";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@ModelAttribute("machine") TMachineInfo machine, Model model, RedirectAttributes redirectAttributes) {

        if (!beanValidator(model, machine)){
            return get(machine, model);
        }
        if(machine.getId() != null){
            if (tMachineInfoService.update(machine) > 0) {
                addMessage(redirectAttributes, "更新设备成功");
            } else {
                addMessage(redirectAttributes, "更新设备失败");
            }
        }else{
            if (tMachineInfoService.insert(machine) > 0) {
                addMessage(redirectAttributes, "新增设备成功");
            } else {
                addMessage(redirectAttributes, "新增设备失败");
            }
        }
        return "redirect:/tMachineInfo/list";
    }

    @RequestMapping(value = "/insertBatch", method = RequestMethod.POST)
    public String insertBatch(@RequestBody List<TMachineInfo> tMachineInfos) {
        if (tMachineInfoService.insertBatch(tMachineInfos) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestBody TMachineInfo tMachineInfo) {
        if (tMachineInfoService.update(tMachineInfo) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/delete")
    public String delete( TMachineInfo tMachineInfo, RedirectAttributes redirectAttributes) {
        if (tMachineInfoService.delete(tMachineInfo) > 0) {
            return "redirect:/tMachineInfo/list";
        } else {
            addMessage(redirectAttributes, "删除设备失败");
            return "redirect:/tMachineInfo/list";
        }
    }

}
