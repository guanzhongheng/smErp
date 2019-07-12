package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.controller.common.BaseController;
import com.lcyzh.nmerp.entity.TProduct;
import com.lcyzh.nmerp.service.TProductService;
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
@RequestMapping(value = "/tProduct")
public class TProductController extends BaseController {
    @Autowired
    private TProductService tProductService;

    /**
     * 列表页面流转
     * @param tProduct
     * @param model
     * @return
     */
    @RequestMapping(value = {"/list", ""}, method = RequestMethod.GET)
    public String list(@ModelAttribute("tProduct") TProduct tProduct, Model model, HttpServletRequest request, HttpServletResponse response) {
        Page<TProduct> page = tProductService.findPage(new Page<TProduct>(request, response), tProduct);
        model.addAttribute("page", page);
        return "modules/crm/prodDictList";
    }

    /**
     * 新增/修改页面流转
     * @param id
     * @return
     */
    @RequestMapping(value = {"/get"}, method = RequestMethod.GET)
    public String get(@ModelAttribute("tProduct") TProduct tProduct,Model model) {
        TProduct newTProduct = new TProduct();
        if(tProduct.getId() != null){
            newTProduct = tProductService.get(tProduct.getId().toString());
        }
        model.addAttribute("tProduct",newTProduct);
        model.addAttribute("prodId",tProduct.getId());
        return "modules/crm/prodDictForm";
    }


    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public String insert(@RequestBody TProduct tProduct) {
        if (tProductService.insert(tProduct) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/insertBatch", method = RequestMethod.POST)
    @ResponseBody
    public String insertBatch(@RequestBody List<TProduct> tProducts) {
        if (tProductService.insertBatch(tProducts) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public String update(@RequestBody TProduct tProduct) {
        if (tProductService.update(tProduct) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestBody TProduct tProduct, RedirectAttributes redirectAttributes) {
        if (tProductService.delete(tProduct) > 0) {
            addMessage(redirectAttributes, "删除失败");
            return "redirect:/tProduct/list";
        } else {
            return "redirect:/tProduct/list";
        }
    }

}
