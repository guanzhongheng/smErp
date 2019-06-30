package com.lcyzh.nmerp.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 项目名称：nm-erp
 * 类 名 称：DecoratorController
 * 类 描 述：TODO
 * 创建时间：2019/6/28 3:12 PM
 * 创 建 人：guan
 */
@Controller
@RequestMapping("decoratorFilter")
public class DecoratorController {

    @RequestMapping("default")
    public String decorator() {

        return "layouts/default";
    }

    @RequestMapping("newLayout")
    public String newLayout() {

        return "layouts/newLayout";
    }

    @RequestMapping("blank")
    public String blank() {
        return "layouts/blank";
    }
}
