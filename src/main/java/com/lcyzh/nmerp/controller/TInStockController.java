package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.entity.TInStock;
import com.lcyzh.nmerp.service.TInStockService;
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
@RequestMapping(value = "/tInStock")
public class TInStockController {
    @Autowired
    private TInStockService tInStockService;

    @RequestMapping(value = {"/list", ""}, method = RequestMethod.GET)
    public Object list() {
        List<TInStock> tInStocks = tInStockService.findAllList();
        return tInStocks;
    }

    @RequestMapping(value = {"/get"}, method = RequestMethod.GET)
    public Object get(@RequestParam String id) {
        TInStock tInStock = tInStockService.get(id);
        return tInStock;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestBody TInStock tInStock) {
        if (tInStockService.insert(tInStock) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/insertBatch", method = RequestMethod.POST)
    public String insertBatch(@RequestBody List<TInStock> tInStocks) {
        if (tInStockService.insertBatch(tInStocks) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestBody TInStock tInStock) {
        if (tInStockService.update(tInStock) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestBody TInStock tInStock) {
        if (tInStockService.delete(tInStock) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

}
