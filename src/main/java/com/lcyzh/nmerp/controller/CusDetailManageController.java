package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.common.lang.StringUtils;
import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.controller.common.BaseController;
import com.lcyzh.nmerp.model.vo.CustomerAddModifyVo;
import com.lcyzh.nmerp.model.vo.OrderItemVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 项目名称：nm-erp
 * 类 名 称：CusDetailManageController
 * 类 描 述：TODO
 * 创建时间：2019/7/3 2:51 PM
 * 创 建 人：guan
 */
@Controller
@RequestMapping("cus/customer")
public class CusDetailManageController extends BaseController {

    @ModelAttribute
    public OrderItemVo get(@RequestParam(required=false) String cusCode) {
        if (StringUtils.isNotBlank(cusCode)){
            return new OrderItemVo();
        }else{
            return new OrderItemVo();
        }
    }

    /**
     * 订单产品详情
     * @param item
     * @param model
     * @return
     */
    @RequestMapping(value = {"prodDetailList"})
    public String prodDetailList(@ModelAttribute("orderItem") OrderItemVo item, Model model, HttpServletRequest request, HttpServletResponse response){
        Page<OrderItemVo> page = null;
        model.addAttribute("orderId",item.getItemCode());
        model.addAttribute("page", page);
        return "modules/crm/prodDetailList";
    }
}
