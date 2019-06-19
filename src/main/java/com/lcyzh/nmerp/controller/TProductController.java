package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.entity.TProduct;
import com.lcyzh.nmerp.service.TProductService;
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
@RequestMapping(value = "/tProduct")
public class TProductController {
    @Autowired
    private TProductService tProductService;

    @RequestMapping(value = {"/list", ""}, method = RequestMethod.GET)
    public Object list() {
        List<TProduct> tProducts = tProductService.findAllList();
        return tProducts;
    }

    @RequestMapping(value = {"/get"}, method = RequestMethod.GET)
    public Object get(@RequestParam String id) {
        TProduct tProduct = tProductService.get(id);
        return tProduct;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestBody TProduct tProduct) {
        if (tProductService.insert(tProduct) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/insertBatch", method = RequestMethod.POST)
    public String insertBatch(@RequestBody List<TProduct> tProducts) {
        if (tProductService.insertBatch(tProducts) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestBody TProduct tProduct) {
        if (tProductService.update(tProduct) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestBody TProduct tProduct) {
        if (tProductService.delete(tProduct) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

}
