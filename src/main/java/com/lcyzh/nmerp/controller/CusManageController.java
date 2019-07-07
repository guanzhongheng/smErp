package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.common.lang.StringUtils;
import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.controller.common.BaseController;
import com.lcyzh.nmerp.entity.CusFollowDetail;
import com.lcyzh.nmerp.entity.Customer;
import com.lcyzh.nmerp.entity.TOrder;
import com.lcyzh.nmerp.model.vo.CusFollowDetailVo;
import com.lcyzh.nmerp.model.vo.CustomerAddModifyVo;
import com.lcyzh.nmerp.model.vo.OrderItemVo;
import com.lcyzh.nmerp.model.vo.OrderQueryVo;
import com.lcyzh.nmerp.service.ICusFollowService;
import com.lcyzh.nmerp.service.TCustomerService;
import com.lcyzh.nmerp.service.TOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


/**
 * 项目名称：nm-erp
 * 类 名 称：CusManageController
 * 类 描 述：TODO
 * 创建时间：2019/6/29 10:16 PM
 * 创 建 人：guan
 */
@Controller
@RequestMapping("cus")
public class CusManageController  extends BaseController {

    @Autowired
    private TCustomerService customerService;

    @Autowired
    private ICusFollowService cusFollowService;

    @Autowired
    private TOrderService orderService;

    @ModelAttribute
    public CustomerAddModifyVo get(@RequestParam(required=false) String cusCode) {
        if (StringUtils.isNotBlank(cusCode)){
            return customerService.findModifyInfoByCusCode(cusCode);
        }else{
            return new CustomerAddModifyVo();
        }
    }
    /**=================================客户相关操作======================================**/

    @RequestMapping(value = {"customer_add"})
    public String customerAdd(@ModelAttribute("customerAddModifyVo") CustomerAddModifyVo customerAddModifyVo,Model model){
        model.addAttribute("customerAddModifyVo",customerAddModifyVo);
        return "modules/crm/customerAdd";
    }


    @RequestMapping(value = {"customer_save"})
    public String customerAdd(CustomerAddModifyVo customerAddModifyVo, Model model, RedirectAttributes redirectAttributes){
        if (!beanValidator(model, customerAddModifyVo)){
            return customerAdd(customerAddModifyVo, model);
        }
        customerService.save(customerAddModifyVo);
        addMessage(redirectAttributes, "保存客户'" + customerAddModifyVo.getCusName() + "'成功");
        return "redirect:/crm/customer/list?repage";
    }


    @RequestMapping(value = {"customer_info"})
    public String customerInfo(@ModelAttribute("customerAddModifyVo") CustomerAddModifyVo customerAddModifyVo,Model model){
        // 根据客户编码code获取跟进清单

        CusFollowDetail cusFollowDetail = new CusFollowDetail();
        cusFollowDetail.setCusCode(customerAddModifyVo.getCusCode());
        List<CusFollowDetail> list = cusFollowService.findList(cusFollowDetail);

        model.addAttribute("customerAddModifyVo",customerAddModifyVo);
        model.addAttribute("follow",list);
        return "modules/crm/customerInfo";
    }

    @RequestMapping(value = {"customer_delete"})
    public String delete(String cusCode, RedirectAttributes redirectAttributes){
        if(StringUtils.isEmpty(cusCode)){
            addMessage(redirectAttributes, "删除失败");
            return "redirect:/crm/customer/list?repage";
        }
        List<String> list = new ArrayList<>();
        list.add(cusCode);
        customerService.delete(list);
        return "redirect:/crm/customer/list?repage";
    }



    /**=================================订单相关操作======================================**/

    /**
     * 订单详情
     * @param order
     * @param model
     * @return
     */
    @RequestMapping(value = {"order/info"})
    public String orderInfo(@ModelAttribute("order") OrderQueryVo order, Model model){


        return "modules/crm/orderInfo";
    }


    /**
     * 订单审批状态修改
     */
    @RequestMapping(value = {"orderStatus_update"})
    public String updateStatus(String ordCode,Long ordStatus,RedirectAttributes redirectAttributes){
        if(StringUtils.isEmpty(ordCode) || ordStatus == null){
            addMessage(redirectAttributes, "审批失败");
            return "redirect:/crm/customer/list?repage";
        }
        TOrder order = new TOrder();
        order.setOrdCode(ordCode);
        order.setOrdStatus(ordStatus);
        orderService.update(order);
        return "redirect:/crm/approval/list?repage";
    }

}
