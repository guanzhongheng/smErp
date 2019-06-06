package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.entity.TUser;
import com.lcyzh.nmerp.service.TUserService;
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
@RequestMapping(value = "/tUser")
public class TUserController {
    @Autowired
    private TUserService tUserService;

    @RequestMapping(value = {"/list", ""}, method = RequestMethod.GET)
    public Object list() {
        List<TUser> tUsers = tUserService.findAllList();
        return tUsers;
    }

    @RequestMapping(value = {"/get"}, method = RequestMethod.GET)
    public Object get(@RequestParam String id) {
        TUser tUser = tUserService.get(id);
        return tUser;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestBody TUser tUser) {
        if (tUserService.insert(tUser) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/insertBatch", method = RequestMethod.POST)
    public String insertBatch(@RequestBody List<TUser> tUsers) {
        if (tUserService.insertBatch(tUsers) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestBody TUser tUser) {
        if (tUserService.update(tUser) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestBody TUser tUser) {
        if (tUserService.delete(tUser) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

}
