package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.entity.TMachineInfo;
import com.lcyzh.nmerp.service.TMachineInfoService;
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
@RequestMapping(value = "/tMachineInfo")
public class TMachineInfoController {
    @Autowired
    private TMachineInfoService tMachineInfoService;

    @RequestMapping(value = {"/list", ""}, method = RequestMethod.GET)
    public Object list() {
        List<TMachineInfo> tMachineInfos = tMachineInfoService.findAllList();
        return tMachineInfos;
    }

    @RequestMapping(value = {"/get"}, method = RequestMethod.GET)
    public Object get(@RequestParam String id) {
        TMachineInfo tMachineInfo = tMachineInfoService.get(id);
        return tMachineInfo;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestBody TMachineInfo tMachineInfo) {
        if (tMachineInfoService.insert(tMachineInfo) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/insertBatch", method = RequestMethod.POST)
    public String insertBatch(@RequestBody List<TMachineInfo> tMachineInfos) {
        if (tMachineInfoService.insertBatch(tMachineInfos) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestBody TMachineInfo tMachineInfo) {
        if (tMachineInfoService.update(tMachineInfo) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestBody TMachineInfo tMachineInfo) {
        if (tMachineInfoService.delete(tMachineInfo) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

}
