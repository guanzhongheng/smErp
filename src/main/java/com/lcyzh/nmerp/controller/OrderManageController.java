package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.controller.common.BaseController;
import com.lcyzh.nmerp.model.vo.OrderAddBatchVo;
import com.lcyzh.nmerp.model.vo.OrderAddModifyVo;
import com.lcyzh.nmerp.service.TOrderService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 项目名称：nm-erp
 * 类 名 称：OrderManageController
 * 类 描 述：TODO
 * 创建时间：2019/6/30 1:11 AM
 * 创 建 人：guan
 */
@Controller
@RequestMapping("order")
public class OrderManageController extends BaseController {

    @Autowired
    private TOrderService orderService;

    @ModelAttribute
    public OrderAddModifyVo get(@RequestParam(required=false) String ordCode) {
        if (StringUtils.isNotBlank(ordCode)){
            OrderAddModifyVo modifyInfoByOrdCode = orderService.findModifyInfoByOrdCode(ordCode);
            return modifyInfoByOrdCode;
        }else{
            return new OrderAddModifyVo();
        }
    }

    @RequestMapping(value = "order_add")
    public String orderAdd(@ModelAttribute("orderAddModifyVo") OrderAddModifyVo ordAddModifyVo, Model model){
        model.addAttribute("orderAddModifyVo",ordAddModifyVo);
        return "modules/crm/orderAdd";
    }

    @RequestMapping(value = {"order_save"})
    public String orderAdd(OrderAddModifyVo ordAddModifyVo, Model model, RedirectAttributes redirectAttributes){
        if (!beanValidator(model, ordAddModifyVo)){
            return orderAdd(ordAddModifyVo, model);
        }
        orderService.save(ordAddModifyVo);
        addMessage(redirectAttributes, "保存订单'" + ordAddModifyVo.getOrdTitle() + "'成功");

        model.addAttribute("orderAddModifyVo",ordAddModifyVo);
        return "modules/crm/orderAdd";
    }


}
