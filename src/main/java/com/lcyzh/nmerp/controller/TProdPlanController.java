package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.entity.TProdPlan;
import com.lcyzh.nmerp.service.TProdPlanService;
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
@RequestMapping(value = "/tProdPlan")
public class TProdPlanController {
    @Autowired
    private TProdPlanService tProdPlanService;

    @RequestMapping(value = {"/list", ""}, method = RequestMethod.GET)
    public Object list() {
        List<TProdPlan> tProdPlans = tProdPlanService.findAllList();
        return tProdPlans;
    }

    @RequestMapping(value = {"/get"}, method = RequestMethod.GET)
    public Object get(@RequestParam String id) {
        TProdPlan tProdPlan = tProdPlanService.get(id);
        return tProdPlan;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestBody TProdPlan tProdPlan) {
        if (tProdPlanService.insert(tProdPlan) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/insertBatch", method = RequestMethod.POST)
    public String insertBatch(@RequestBody List<TProdPlan> tProdPlans) {
        if (tProdPlanService.insertBatch(tProdPlans) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestBody TProdPlan tProdPlan) {
        if (tProdPlanService.update(tProdPlan) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestBody TProdPlan tProdPlan) {
        if (tProdPlanService.delete(tProdPlan) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

}
