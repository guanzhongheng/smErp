package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.entity.TOutStock;
import com.lcyzh.nmerp.service.TOutStockService;
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
@RequestMapping(value = "/tOutStock")
public class TOutStockController {
    @Autowired
    private TOutStockService tOutStockService;

    @RequestMapping(value = {"/list", ""}, method = RequestMethod.GET)
    public Object list() {
        List<TOutStock> tOutStocks = tOutStockService.findAllList();
        return tOutStocks;
    }

    @RequestMapping(value = {"/get"}, method = RequestMethod.GET)
    public Object get(@RequestParam String id) {
        TOutStock tOutStock = tOutStockService.get(id);
        return tOutStock;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestBody TOutStock tOutStock) {
        if (tOutStockService.insert(tOutStock) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/insertBatch", method = RequestMethod.POST)
    public String insertBatch(@RequestBody List<TOutStock> tOutStocks) {
        if (tOutStockService.insertBatch(tOutStocks) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestBody TOutStock tOutStock) {
        if (tOutStockService.update(tOutStock) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestBody TOutStock tOutStock) {
        if (tOutStockService.delete(tOutStock) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

}
