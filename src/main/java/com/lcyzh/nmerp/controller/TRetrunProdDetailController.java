package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.entity.TRetrunProdDetail;
import com.lcyzh.nmerp.service.TRetrunProdDetailService;
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
@RequestMapping(value = "/tRetrunProdDetail")
public class TRetrunProdDetailController {
    @Autowired
    private TRetrunProdDetailService tRetrunProdDetailService;

    @RequestMapping(value = {"/list", ""}, method = RequestMethod.GET)
    public Object list() {
        List<TRetrunProdDetail> tRetrunProdDetails = tRetrunProdDetailService.findAllList();
        return tRetrunProdDetails;
    }

    @RequestMapping(value = {"/get"}, method = RequestMethod.GET)
    public Object get(@RequestParam String id) {
        TRetrunProdDetail tRetrunProdDetail = tRetrunProdDetailService.get(id);
        return tRetrunProdDetail;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestBody TRetrunProdDetail tRetrunProdDetail) {
        if (tRetrunProdDetailService.insert(tRetrunProdDetail) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/insertBatch", method = RequestMethod.POST)
    public String insertBatch(@RequestBody List<TRetrunProdDetail> tRetrunProdDetails) {
        if (tRetrunProdDetailService.insertBatch(tRetrunProdDetails) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestBody TRetrunProdDetail tRetrunProdDetail) {
        if (tRetrunProdDetailService.update(tRetrunProdDetail) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestBody TRetrunProdDetail tRetrunProdDetail) {
        if (tRetrunProdDetailService.delete(tRetrunProdDetail) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

}
