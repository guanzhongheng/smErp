package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.common.lang.StringUtils;
import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.controller.common.BaseController;
import com.lcyzh.nmerp.entity.Customer;
import com.lcyzh.nmerp.model.vo.CustomerAddModifyVo;
import com.lcyzh.nmerp.model.vo.OrderItemVo;
import com.lcyzh.nmerp.service.TCustomerService;
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


    @ModelAttribute
    public CustomerAddModifyVo get(@RequestParam(required=false) String cusCode) {
        if (StringUtils.isNotBlank(cusCode)){
            return customerService.findModifyInfoByCusCode(cusCode);
        }else{
            return new CustomerAddModifyVo();
        }
    }


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
    public String customerInfo(Model model){
        // Page<Customer> page = commentService.findPage(new Page<Comment>(request, response), comment);
        Page<Customer> page = new Page<Customer>();
        model.addAttribute("page", page);
        return "modules/crm/customerInfo";
    }

    @RequestMapping(value = {"customer_delete"})
    public String delete(String cusCode, RedirectAttributes redirectAttributes){
        if(StringUtils.isEmpty(cusCode)){
            addMessage(redirectAttributes, "删除失败");
            return "redirect:/modules/crm/customerList";
        }
        List<String> list = new ArrayList<>();
        list.add(cusCode);
        customerService.delete(list);
        return "redirect:/modules/crm/customerList";
    }

}
