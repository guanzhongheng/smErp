package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.entity.TSendGoodsInfo;
import com.lcyzh.nmerp.service.TSendGoodsInfoService;
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
@RequestMapping(value = "/tSendGoodsInfo")
public class TSendGoodsInfoController {
    @Autowired
    private TSendGoodsInfoService tSendGoodsInfoService;

    @RequestMapping(value = {"/list", ""}, method = RequestMethod.GET)
    public Object list() {
        List<TSendGoodsInfo> tSendGoodsInfos = tSendGoodsInfoService.findAllList();
        return tSendGoodsInfos;
    }

    @RequestMapping(value = {"/get"}, method = RequestMethod.GET)
    public Object get(@RequestParam String id) {
        TSendGoodsInfo tSendGoodsInfo = tSendGoodsInfoService.get(id);
        return tSendGoodsInfo;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestBody TSendGoodsInfo tSendGoodsInfo) {
        if (tSendGoodsInfoService.insert(tSendGoodsInfo) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/insertBatch", method = RequestMethod.POST)
    public String insertBatch(@RequestBody List<TSendGoodsInfo> tSendGoodsInfos) {
        if (tSendGoodsInfoService.insertBatch(tSendGoodsInfos) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestBody TSendGoodsInfo tSendGoodsInfo) {
        if (tSendGoodsInfoService.update(tSendGoodsInfo) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestBody TSendGoodsInfo tSendGoodsInfo) {
        if (tSendGoodsInfoService.delete(tSendGoodsInfo) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

}
