package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.service.IDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Project : nm-erp
 * @Description : TODO
 * @Author : lijinku
 * @Iteration : 1.0
 * @Date : 2019/9/14  9:59 PM
 * @ModificationHistory Who          When          What
 * ----------   ------------- -----------------------------------
 * lijinku          2019/09/14    create
 */
@Controller
@RequestMapping("dict")
public class MyDictController {

    @Autowired
    private IDictService dictService;

    @RequestMapping(value = "/reload", method = RequestMethod.GET)
    public void reload() {
        dictService.loadDictData();
    }
}