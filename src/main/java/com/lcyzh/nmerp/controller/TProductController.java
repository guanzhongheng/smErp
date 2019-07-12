package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.controller.common.BaseController;
import com.lcyzh.nmerp.entity.TProduct;
import com.lcyzh.nmerp.model.vo.ProductVo;
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
    @RequestMapping(value = {"/list", ""})
    public String list(@ModelAttribute("tProduct") TProduct tProduct, Model model, HttpServletRequest request, HttpServletResponse response) {
        Page<ProductVo> page = tProductService.findPage(new Page<ProductVo>(request, response), tProduct);
        model.addAttribute("page", page);
        return "modules/crm/prodDictList";
    }

    /**
     * 新增/修改页面流转
     * @param
     * @return
     */
    @RequestMapping(value = {"get"}, method = RequestMethod.GET)
    public String get(@ModelAttribute("tProduct") TProduct tProduct,Model model) {
        ProductVo newTProduct = new ProductVo();
        if(tProduct.getId() != null){
            newTProduct = tProductService.get(tProduct.getId().toString());
        }
        model.addAttribute("tProduct",newTProduct);
        model.addAttribute("prodId",tProduct.getId());
        return "modules/crm/prodDictForm";
    }


    @RequestMapping("insert")
    public String insert(TProduct tProduct,Model model,RedirectAttributes redirectAttributes) {
        if (!beanValidator(model, tProduct)){
            return get(tProduct, model);
        }
        if(tProduct.getId() != null){
            if (tProductService.update(tProduct) > 0) {
                addMessage(redirectAttributes, "更新产品:'" + tProduct.getProdName() + "'成功");
            } else {
                addMessage(redirectAttributes, "更新产品:'" + tProduct.getProdName() + "'失败");
            }
        }else{
            if (tProductService.insert(tProduct) > 0) {
                addMessage(redirectAttributes, "保存产品:'" + tProduct.getProdName() + "'成功");
            } else {
                addMessage(redirectAttributes, "保存产品:'" + tProduct.getProdName() + "'失败");
            }
        }
        return "redirect:/tProduct/list";
    }



    @RequestMapping(value = "/insertBatch")
    public String insertBatch(List<TProduct> tProducts) {
        if (tProductService.insertBatch(tProducts) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/update")
    public String update(TProduct tProduct) {
        if (tProductService.update(tProduct) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/delete")
    public String delete(TProduct tProduct, RedirectAttributes redirectAttributes) {
        if (tProductService.delete(tProduct) > 0) {
            addMessage(redirectAttributes, "删除失败");
            return "redirect:/tProduct/list";
        } else {
            return "redirect:/tProduct/list";
        }
    }

}
