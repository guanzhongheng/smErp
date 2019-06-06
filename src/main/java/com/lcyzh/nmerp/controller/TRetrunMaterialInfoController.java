package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.entity.TRetrunMaterialInfo;
import com.lcyzh.nmerp.service.TRetrunMaterialInfoService;
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
@RequestMapping(value = "/tRetrunMaterialInfo")
public class TRetrunMaterialInfoController {
    @Autowired
    private TRetrunMaterialInfoService tRetrunMaterialInfoService;

    @RequestMapping(value = {"/list", ""}, method = RequestMethod.GET)
    public Object list() {
        List<TRetrunMaterialInfo> tRetrunMaterialInfos = tRetrunMaterialInfoService.findAllList();
        return tRetrunMaterialInfos;
    }

    @RequestMapping(value = {"/get"}, method = RequestMethod.GET)
    public Object get(@RequestParam String id) {
        TRetrunMaterialInfo tRetrunMaterialInfo = tRetrunMaterialInfoService.get(id);
        return tRetrunMaterialInfo;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestBody TRetrunMaterialInfo tRetrunMaterialInfo) {
        if (tRetrunMaterialInfoService.insert(tRetrunMaterialInfo) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/insertBatch", method = RequestMethod.POST)
    public String insertBatch(@RequestBody List<TRetrunMaterialInfo> tRetrunMaterialInfos) {
        if (tRetrunMaterialInfoService.insertBatch(tRetrunMaterialInfos) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestBody TRetrunMaterialInfo tRetrunMaterialInfo) {
        if (tRetrunMaterialInfoService.update(tRetrunMaterialInfo) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestBody TRetrunMaterialInfo tRetrunMaterialInfo) {
        if (tRetrunMaterialInfoService.delete(tRetrunMaterialInfo) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

}
