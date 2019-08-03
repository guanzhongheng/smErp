package com.lcyzh.nmerp.controller.system;

import com.lcyzh.nmerp.controller.common.BaseController;
import com.lcyzh.nmerp.controller.system.util.SysDictUtils;
import com.lcyzh.nmerp.controller.system.util.UserUtils;
import com.lcyzh.nmerp.entity.sys.Dict;
import com.lcyzh.nmerp.model.vo.CusFollowDetailVo;
import com.lcyzh.nmerp.model.vo.CustomerUpdateVo;
import com.lcyzh.nmerp.service.ICusFollowService;
import com.lcyzh.nmerp.service.TCustomerService;
import com.lcyzh.nmerp.service.security.SystemAuthorizingRealm.Principal;
import com.lcyzh.nmerp.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private TCustomerService customerService;
    @Autowired
    private ICusFollowService cusFollowService;


    /**
     * 添加归属人
     *
     * @return
     */
    @RequestMapping(value = "addBlongPerson")
    @ResponseBody
    public String saveFlowEmp(String cusIds, String empCode, String remark) {
        int res = customerService.addAttributor(cusIds, empCode, remark);
        if (res < 1) {
            return "error";
        }
        return "success";
    }

    /**
     * 转移客户-保存
     *
     * @return
     */
    @RequestMapping(value = "saveTransfer")
    @ResponseBody
    public String saveTransfer(CustomerUpdateVo vo) {
        int res = customerService.updateBatch(vo);
        if (res < 1) {
            return "error";
        }
        return "success";
    }

    /**
     * 转移公海-保存
     *
     * @param cusIds
     * @param remarks
     * @return
     */
    @RequestMapping(value = "savePoolCustomer")
    @ResponseBody
    public String savePoolCustomer(CustomerUpdateVo vo) {
        int res = customerService.updateBatch(vo);
        if (res < 1) {
            return "error";
        }
        return "success";
    }


    /**
     * 客户跟踪-保存
     *
     * @return
     */
    @RequestMapping(value = "saveFollow")
    @ResponseBody
    public String savePoolCustomer(String cusCode, String followTime, String followTitle, String followRemarks) {
        CusFollowDetailVo detailVo = new CusFollowDetailVo();
        detailVo.setCusCode(cusCode);
        detailVo.setFollowTime(DateUtil.fomatDateFixFormat(followTime));
        detailVo.setFollowTitle(followTitle);
        detailVo.setFollowDetail(followRemarks);
        Principal principal = UserUtils.getPrincipal();
        detailVo.setEmpCode(principal.getId());
        cusFollowService.save(detailVo);

        return "success";
    }


    /**
     * 任务分配
     *
     * @return
     */
    @RequestMapping(value = "saveTaskInfo")
    @ResponseBody
    public String saveTaskInfo(String taskIds, String devInfo, Integer followRemarks) {


        return "success";
    }

    /**
     * 流程审批处理
     *
     * @return
     */
    @RequestMapping(value = "inventoryInfo")
    @ResponseBody
    public String inventoryInfo(String taskIds, String devInfo, Integer followRemarks) {


        return "success";
    }

    /**
     * 获取字典信息
     *
     * @return
     */
    @RequestMapping(value = "ajaxDictInfo")
    @ResponseBody
    public Map<String, Object> getDictInfo() {
        Map<String, Object> map = new HashMap<>();
        List<Dict> ycType = SysDictUtils.getDictList("prod_ycType");
        List<Dict> ybType = SysDictUtils.getDictList("prod_ybType");
        map.put("ycType", ycType);
        map.put("ybType", ybType);
        return map;
    }


    @RequestMapping("orderFileUpload")
    @ResponseBody
    public String caseFileUpload(@RequestParam("file") MultipartFile multipartFile) {

        return "";
    }
}
