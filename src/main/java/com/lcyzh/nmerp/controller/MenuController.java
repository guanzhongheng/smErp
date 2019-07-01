package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.controller.common.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 项目名称：nm-erp
 * 类 名 称：MenuController
 * 类 描 述：TODO
 * 创建时间：2019/7/1 5:01 PM
 * 创 建 人：guan
 */
@Controller
@RequestMapping("sys/menu")
public class MenuController extends BaseController {

    @RequestMapping(value = "tree")
    public String tree() {
        return "modules/sys/menuTree";
    }
}
