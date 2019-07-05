package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.common.lang.StringUtils;
import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.controller.common.BaseController;
import com.lcyzh.nmerp.model.vo.CustomerAddModifyVo;
import com.lcyzh.nmerp.model.vo.OrderItemVo;
import com.lcyzh.nmerp.service.TOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 项目名称：nm-erp
 * 类 名 称：CusDetailManageController
 * 类 描 述：TODO
 * 创建时间：2019/7/3 2:51 PM
 * 创 建 人：guan
 */
@Controller
@RequestMapping("order/item")
public class OrdDetailManageController extends BaseController {

    @Autowired
    private TOrderService orderService;

    @ModelAttribute
    public OrderItemVo get(@RequestParam(required = false) String cusCode) {
        if (StringUtils.isNotBlank(cusCode)) {
            return new OrderItemVo();
        } else {
            return new OrderItemVo();
        }
    }

    @RequestMapping("findItemsById")
    @ResponseBody
    public List<OrderItemVo> findItemsByOrdCode(String ordCode) {
        List<OrderItemVo> list = orderService.findByOrdCode(ordCode);
        return list;
    }

    /**
     * 订单产品详情
     *
     * @param ordCode
     * @param model
     * @return
     */
    @RequestMapping(value = {"prodDetailList"})
    public String prodDetailList(String ordCode, Model model, HttpServletRequest request, HttpServletResponse response) {
        model.addAttribute("ordCode", ordCode);
        return "modules/crm/prodDetailList";
    }
}
