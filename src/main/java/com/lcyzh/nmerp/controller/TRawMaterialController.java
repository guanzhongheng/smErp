package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.entity.TRawMaterial;
import com.lcyzh.nmerp.service.TRawMaterialService;
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
@RequestMapping(value = "/tRawMaterial")
public class TRawMaterialController {
    @Autowired
    private TRawMaterialService tRawMaterialService;

    @RequestMapping(value = {"/list", ""}, method = RequestMethod.GET)
    public Object list() {
        List<TRawMaterial> tRawMaterials = tRawMaterialService.findAllList();
        return tRawMaterials;
    }

    @RequestMapping(value = {"/get"}, method = RequestMethod.GET)
    public Object get(@RequestParam String id) {
        TRawMaterial tRawMaterial = tRawMaterialService.get(id);
        return tRawMaterial;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestBody TRawMaterial tRawMaterial) {
        if (tRawMaterialService.insert(tRawMaterial) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/insertBatch", method = RequestMethod.POST)
    public String insertBatch(@RequestBody List<TRawMaterial> tRawMaterials) {
        if (tRawMaterialService.insertBatch(tRawMaterials) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestBody TRawMaterial tRawMaterial) {
        if (tRawMaterialService.update(tRawMaterial) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestBody TRawMaterial tRawMaterial) {
        if (tRawMaterialService.delete(tRawMaterial) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

}
