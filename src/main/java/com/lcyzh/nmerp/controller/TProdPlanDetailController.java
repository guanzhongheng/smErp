package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.entity.TProdPlanDetail;
import com.lcyzh.nmerp.service.TProdPlanDetailService;
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
@RequestMapping(value = "/tProdPlanDetail")
public class TProdPlanDetailController {
    @Autowired
    private TProdPlanDetailService tProdPlanDetailService;

    @RequestMapping(value = {"/list", ""}, method = RequestMethod.GET)
    public Object list() {
        List<TProdPlanDetail> tProdPlanDetails = tProdPlanDetailService.findAllList();
        return tProdPlanDetails;
    }

    @RequestMapping(value = {"/get"}, method = RequestMethod.GET)
    public Object get(@RequestParam String id) {
        TProdPlanDetail tProdPlanDetail = tProdPlanDetailService.get(id);
        return tProdPlanDetail;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestBody TProdPlanDetail tProdPlanDetail) {
        if (tProdPlanDetailService.insert(tProdPlanDetail) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/insertBatch", method = RequestMethod.POST)
    public String insertBatch(@RequestBody List<TProdPlanDetail> tProdPlanDetails) {
        if (tProdPlanDetailService.insertBatch(tProdPlanDetails) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestBody TProdPlanDetail tProdPlanDetail) {
        if (tProdPlanDetailService.update(tProdPlanDetail) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestBody TProdPlanDetail tProdPlanDetail) {
        if (tProdPlanDetailService.delete(tProdPlanDetail) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

}
