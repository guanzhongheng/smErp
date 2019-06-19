package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.entity.TOrder;
import com.lcyzh.nmerp.service.TOrderService;
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
@RequestMapping(value = "/tOrder")
public class TOrderController {
    @Autowired
    private TOrderService tOrderService;

    @RequestMapping(value = {"/list", ""}, method = RequestMethod.GET)
    public Object list() {
        List<TOrder> tOrders = tOrderService.findAllList();
        return tOrders;
    }

    @RequestMapping(value = {"/get"}, method = RequestMethod.GET)
    public Object get(@RequestParam String id) {
        TOrder tOrder = tOrderService.get(id);
        return tOrder;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestBody TOrder tOrder) {
        if (tOrderService.insert(tOrder) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/insertBatch", method = RequestMethod.POST)
    public String insertBatch(@RequestBody List<TOrder> tOrders) {
        if (tOrderService.insertBatch(tOrders) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestBody TOrder tOrder) {
        if (tOrderService.update(tOrder) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestBody TOrder tOrder) {
        if (tOrderService.delete(tOrder) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

}
