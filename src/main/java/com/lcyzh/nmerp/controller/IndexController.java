package com.lcyzh.nmerp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * @Project : nm-erp
 * @Description : TODO
 * @Author : lijinku
 * @Iteration : 1.0
 * @Date : 2019/6/15  3:33 PM
 * @ModificationHistory Who          When          What
 * ----------   ------------- -----------------------------------
 * lijinku          2019/06/15    create
 */
@Controller
public class IndexController {


    @GetMapping("/webSocket")
    public ModelAndView goToWeight(){
        ModelAndView mav=new ModelAndView("socket");
//        mav.addObject("uid", RandomUtil.randomNumbers(6));
        return mav;
    }



}
