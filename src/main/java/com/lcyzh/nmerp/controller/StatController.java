package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.model.vo.ProdPlanVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 项目名称：nm-erp
 * 类 名 称：StatController
 * 类 描 述：TODO
 * 创建时间：2019/7/31 12:06 PM
 * 创 建 人：guan
 */
@Controller
@RequestMapping("sta")
public class StatController {

    @RequestMapping(value = {"orderSta"})
    public String prodPlanDetail(Model model, HttpServletRequest request, HttpServletResponse response){
        return "modules/statistic/orderSta";
    }
}
