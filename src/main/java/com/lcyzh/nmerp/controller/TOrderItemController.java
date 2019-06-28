package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.entity.TOrderItem;
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
@RequestMapping(value = "/tOrderItem")
public class TOrderItemController {
//    @Autowired
//    private TOrderItemService tOrderItemService;
//
//    @RequestMapping(value = {"/list", ""}, method = RequestMethod.GET)
//    public Object list() {
//        List<TOrderItem> tOrderItems = tOrderItemService.findAllList();
//        return tOrderItems;
//    }
//
//    @RequestMapping(value = {"/get"}, method = RequestMethod.GET)
//    public Object get(@RequestParam String id) {
//        TOrderItem tOrderItem = tOrderItemService.get(id);
//        return tOrderItem;
//    }
//
//    @RequestMapping(value = "/insert", method = RequestMethod.POST)
//    public String insert(@RequestBody TOrderItem tOrderItem) {
//        if (tOrderItemService.insert(tOrderItem) > 0) {
//            return "success";
//        } else {
//            return "failed";
//        }
//    }
//
//    @RequestMapping(value = "/insertBatch", method = RequestMethod.POST)
//    public String insertBatch(@RequestBody List<TOrderItem> tOrderItems) {
//        if (tOrderItemService.insertBatch(tOrderItems) > 0) {
//            return "success";
//        } else {
//            return "failed";
//        }
//    }
//
//    @RequestMapping(value = "/update", method = RequestMethod.POST)
//    public String update(@RequestBody TOrderItem tOrderItem) {
//        if (tOrderItemService.update(tOrderItem) > 0) {
//            return "success";
//        } else {
//            return "failed";
//        }
//    }
//
//    @RequestMapping(value = "/delete", method = RequestMethod.POST)
//    public String delete(@RequestBody TOrderItem tOrderItem) {
//        if (tOrderItemService.delete(tOrderItem) > 0) {
//            return "success";
//        } else {
//            return "failed";
//        }
//    }

}
