package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.entity.TOutStockDetail;
import com.lcyzh.nmerp.service.TOutStockDetailService;
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
@RequestMapping(value = "/tOutStockDetail")
public class TOutStockDetailController {
    @Autowired
    private TOutStockDetailService tOutStockDetailService;

    @RequestMapping(value = {"/list", ""}, method = RequestMethod.GET)
    public Object list() {
        List<TOutStockDetail> tOutStockDetails = tOutStockDetailService.findAllList();
        return tOutStockDetails;
    }

    @RequestMapping(value = {"/get"}, method = RequestMethod.GET)
    public Object get(@RequestParam String id) {
        TOutStockDetail tOutStockDetail = tOutStockDetailService.get(id);
        return tOutStockDetail;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestBody TOutStockDetail tOutStockDetail) {
        if (tOutStockDetailService.insert(tOutStockDetail) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/insertBatch", method = RequestMethod.POST)
    public String insertBatch(@RequestBody List<TOutStockDetail> tOutStockDetails) {
        if (tOutStockDetailService.insertBatch(tOutStockDetails) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestBody TOutStockDetail tOutStockDetail) {
        if (tOutStockDetailService.update(tOutStockDetail) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestBody TOutStockDetail tOutStockDetail) {
        if (tOutStockDetailService.delete(tOutStockDetail) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

}
