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


    /**
     * 客户跟踪-保存
     * @param cusIds
     * @param remarks
     * @return
     */
    @RequestMapping(value = "saveFollow")
    @ResponseBody
    public String savePoolCustomer(String cusCode,String followTitle,String followRemarks) {


        return "success";
    }


    /**
     * 任务分配
     * @return
     */
    @RequestMapping(value = "saveTaskInfo")
    @ResponseBody
    public String saveTaskInfo(String taskIds,String devInfo,Integer followRemarks) {


        return "success";
    }

    /**
     * 流程审批处理
     * @return
     */
    @RequestMapping(value = "inventoryInfo")
    @ResponseBody
    public String inventoryInfo(String taskIds,String devInfo,Integer followRemarks) {


        return "success";
    }
}
