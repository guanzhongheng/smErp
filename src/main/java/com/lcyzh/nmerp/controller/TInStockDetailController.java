package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.entity.TInStockDetail;
import com.lcyzh.nmerp.service.TInStockDetailService;
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
@RequestMapping(value = "/tInStockDetail")
public class TInStockDetailController {
    @Autowired
    private TInStockDetailService tInStockDetailService;

    @RequestMapping(value = {"/list", ""}, method = RequestMethod.GET)
    public Object list() {
        List<TInStockDetail> tInStockDetails = tInStockDetailService.findAllList();
        return tInStockDetails;
    }

    @RequestMapping(value = {"/get"}, method = RequestMethod.GET)
    public Object get(@RequestParam String id) {
        TInStockDetail tInStockDetail = tInStockDetailService.get(id);
        return tInStockDetail;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestBody TInStockDetail tInStockDetail) {
        if (tInStockDetailService.insert(tInStockDetail) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/insertBatch", method = RequestMethod.POST)
    public String insertBatch(@RequestBody List<TInStockDetail> tInStockDetails) {
        if (tInStockDetailService.insertBatch(tInStockDetails) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestBody TInStockDetail tInStockDetail) {
        if (tInStockDetailService.update(tInStockDetail) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestBody TInStockDetail tInStockDetail) {
        if (tInStockDetailService.delete(tInStockDetail) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

}
