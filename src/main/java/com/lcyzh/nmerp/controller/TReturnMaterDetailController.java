package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.entity.TReturnMaterDetail;
import com.lcyzh.nmerp.service.TReturnMaterDetailService;
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
@RequestMapping(value = "/tReturnMaterDetail")
public class TReturnMaterDetailController {
    @Autowired
    private TReturnMaterDetailService tReturnMaterDetailService;

    @RequestMapping(value = {"/list", ""}, method = RequestMethod.GET)
    public Object list() {
        List<TReturnMaterDetail> tReturnMaterDetails = tReturnMaterDetailService.findAllList();
        return tReturnMaterDetails;
    }

    @RequestMapping(value = {"/get"}, method = RequestMethod.GET)
    public Object get(@RequestParam String id) {
        TReturnMaterDetail tReturnMaterDetail = tReturnMaterDetailService.get(id);
        return tReturnMaterDetail;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestBody TReturnMaterDetail tReturnMaterDetail) {
        if (tReturnMaterDetailService.insert(tReturnMaterDetail) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/insertBatch", method = RequestMethod.POST)
    public String insertBatch(@RequestBody List<TReturnMaterDetail> tReturnMaterDetails) {
        if (tReturnMaterDetailService.insertBatch(tReturnMaterDetails) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestBody TReturnMaterDetail tReturnMaterDetail) {
        if (tReturnMaterDetailService.update(tReturnMaterDetail) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestBody TReturnMaterDetail tReturnMaterDetail) {
        if (tReturnMaterDetailService.delete(tReturnMaterDetail) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

}
