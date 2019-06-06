package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.entity.TProdCategory;
import com.lcyzh.nmerp.service.TProdCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Author ljk
 * Date  2019-06-06
 */
@RestController
@RequestMapping(value = "/tProdCategory")
public class TProdCategoryController {
    @Autowired
    private TProdCategoryService tProdCategoryService;

    @RequestMapping(value = {"/list", ""}, method = RequestMethod.GET)
    public Object list() {
        List<TProdCategory> tProdCategorys = tProdCategoryService.findAllList();
        return tProdCategorys;
    }

    @RequestMapping(value = {"/get"}, method = RequestMethod.GET)
    public Object get(@RequestParam String id) {
        TProdCategory tProdCategory = tProdCategoryService.get(id);
        return tProdCategory;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestBody TProdCategory tProdCategory) {
        if (tProdCategoryService.insert(tProdCategory) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/insertBatch", method = RequestMethod.POST)
    public String insertBatch(@RequestBody List<TProdCategory> tProdCategorys) {
        if (tProdCategoryService.insertBatch(tProdCategorys) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestBody TProdCategory tProdCategory) {
        if (tProdCategoryService.update(tProdCategory) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestBody TProdCategory tProdCategory) {
        if (tProdCategoryService.delete(tProdCategory) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

}
