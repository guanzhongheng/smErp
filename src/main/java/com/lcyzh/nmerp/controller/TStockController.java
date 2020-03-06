package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.entity.TStock;
import com.lcyzh.nmerp.service.TStockService;
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
@RequestMapping(value = "/tStock")
public class TStockController {
    @Autowired
    private TStockService tStockService;

    @RequestMapping(value = {"/get"}, method = RequestMethod.GET)
    public Object get(@RequestParam String id) {
        TStock tStock = tStockService.get(id);
        return tStock;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestBody TStock tStock) {
        if (tStockService.insert(tStock) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/insertBatch", method = RequestMethod.POST)
    public String insertBatch(@RequestBody List<TStock> tStocks) {
        if (tStockService.insertBatch(tStocks) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

}
