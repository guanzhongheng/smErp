package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.service.TInStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author ljk
 * Date  2019-06-06
 */
@RestController
@RequestMapping(value = "/tInStock")
public class TInStockController {
    @Autowired
    private TInStockService tInStockService;


}
