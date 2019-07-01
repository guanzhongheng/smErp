package com.lcyzh.nmerp.controller.system;

import com.lcyzh.nmerp.controller.common.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 项目名称：nm-erp
 * 类 名 称：CrmAjaxManageController
 * 类 描 述：TODO
 * 创建时间：2019/6/30 5:04 PM
 * 创 建 人：guan
 */
@Controller
@RequestMapping("crmAjax")
public class CrmAjaxManageController extends BaseController {


    /**
     * 转移客户-保存
     * @param cusIds
     * @param userId
     * @param remarks
     * @return
     */
    @RequestMapping(value = "saveTransfer")
    @ResponseBody
    public String saveTransfer(String cusIds,String userId,String remarks) {


        return "success";
    }

    /**
     * 转移公海-保存
     * @param cusIds
     * @param remarks
     * @return
     */
    @RequestMapping(value = "savePoolCustomer")
    @ResponseBody
    public String savePoolCustomer(String cusIds,String remarks) {


        return "success";
    }
}
