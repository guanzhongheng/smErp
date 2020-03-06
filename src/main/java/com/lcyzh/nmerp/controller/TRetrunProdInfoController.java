package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.entity.TRetrunProdInfo;
import com.lcyzh.nmerp.service.TRetrunProdInfoService;
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
@RequestMapping(value = "/tRetrunProdInfo")
public class TRetrunProdInfoController {
    @Autowired
    private TRetrunProdInfoService tRetrunProdInfoService;

    @RequestMapping(value = {"/list", ""}, method = RequestMethod.GET)
    public Object list() {
        List<TRetrunProdInfo> tRetrunProdInfos = tRetrunProdInfoService.findAllList();
        return tRetrunProdInfos;
    }

    @RequestMapping(value = {"/get"}, method = RequestMethod.GET)
    public Object get(@RequestParam String id) {
        TRetrunProdInfo tRetrunProdInfo = tRetrunProdInfoService.get(id);
        return tRetrunProdInfo;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestBody TRetrunProdInfo tRetrunProdInfo) {
        if (tRetrunProdInfoService.insert(tRetrunProdInfo) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/insertBatch", method = RequestMethod.POST)
    public String insertBatch(@RequestBody List<TRetrunProdInfo> tRetrunProdInfos) {
        if (tRetrunProdInfoService.insertBatch(tRetrunProdInfos) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestBody TRetrunProdInfo tRetrunProdInfo) {
        if (tRetrunProdInfoService.update(tRetrunProdInfo) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestBody TRetrunProdInfo tRetrunProdInfo) {
        if (tRetrunProdInfoService.delete(tRetrunProdInfo) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

}
