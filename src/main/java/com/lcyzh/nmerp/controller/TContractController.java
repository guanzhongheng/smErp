package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.entity.TContract;
import com.lcyzh.nmerp.service.TContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author ljk
 * Date  2019-06-06
 */
@Controller
@RequestMapping(value = "/contract")
public class TContractController {
    @Autowired
    private TContractService tContractService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<TContract> list() {
        List<TContract> tContracts = tContractService.findAllList();
        return tContracts;
    }

    @RequestMapping(value = {"/get"}, method = RequestMethod.GET)
    public Object get(@RequestParam String id) {
        TContract tContract = tContractService.get(id);
        return tContract;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestBody TContract tContract) {
        if (tContractService.insert(tContract) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/insertBatch", method = RequestMethod.POST)
    public String insertBatch(@RequestBody List<TContract> tContracts) {
        if (tContractService.insertBatch(tContracts) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestBody TContract tContract) {
        if (tContractService.update(tContract) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestBody TContract tContract) {
        if (tContractService.delete(tContract) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

}
