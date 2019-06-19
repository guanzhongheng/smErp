package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.entity.TCustomer;
import com.lcyzh.nmerp.service.TCustomerService;
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
@RequestMapping(value = "/tCustomer")
public class TCustomerController {
    @Autowired
    private TCustomerService tCustomerService;

    @RequestMapping(value = {"/list", ""}, method = RequestMethod.GET)
    public Object list() {
        List<TCustomer> tCustomers = tCustomerService.findAllList();
        return tCustomers;
    }

    @RequestMapping(value = {"/get"}, method = RequestMethod.GET)
    public Object get(@RequestParam String id) {
        TCustomer tCustomer = tCustomerService.get(id);
        return tCustomer;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestBody TCustomer tCustomer) {
        if (tCustomerService.insert(tCustomer) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/insertBatch", method = RequestMethod.POST)
    public String insertBatch(@RequestBody List<TCustomer> tCustomers) {
        if (tCustomerService.insertBatch(tCustomers) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestBody TCustomer tCustomer) {
        if (tCustomerService.update(tCustomer) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestBody TCustomer tCustomer) {
        if (tCustomerService.delete(tCustomer) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

}
