package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.controller.common.BaseController;
import com.lcyzh.nmerp.controller.system.util.SysDictUtils;
import com.lcyzh.nmerp.dao.TCustomerMapper;
import com.lcyzh.nmerp.entity.TProduct;
import com.lcyzh.nmerp.entity.sys.Dict;
import com.lcyzh.nmerp.model.vo.CustomerQueryVo;
import com.lcyzh.nmerp.model.vo.OrderAddBatchVo;
import com.lcyzh.nmerp.model.vo.OrderAddModifyVo;
import com.lcyzh.nmerp.service.TOrderService;
import com.lcyzh.nmerp.service.TProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * 项目名称：nm-erp
 * 类 名 称：OrderManageController
 * 类 描 述：TODO
 * 创建时间：2019/6/30 1:11 AM
 * 创 建 人：guan
 */
@Controller
@RequestMapping("order")
public class OrderManageController extends BaseController {

    @Autowired
    private TOrderService orderService;

    @Autowired
    private TProductService productService;
    @Autowired
    private TCustomerMapper tCustomerMapper;

    @ModelAttribute
    public OrderAddModifyVo get(@RequestParam(required=false) String ordCode) {
        if (StringUtils.isNotBlank(ordCode)){
            //OrderAddModifyVo modifyInfoByOrdCode = orderService.findModifyInfoByOrdCode(ordCode);
            //return modifyInfoByOrdCode;
            return null;
        }else{
            return new OrderAddModifyVo();
        }
    }

    @RequestMapping(value = "order_add")
    public String orderAdd(@ModelAttribute("orderAddModifyVo") OrderAddModifyVo ordAddModifyVo, Model model){
        // 获取用户列表
        List<CustomerQueryVo> listPo = tCustomerMapper.findList(null);
        model.addAttribute("customers",listPo);
        model.addAttribute("orderAddModifyVo",ordAddModifyVo);
        return "modules/crm/orderAdd";
    }

    @RequestMapping(value = {"order_save"})
    public String orderAdd(OrderAddModifyVo ordAddModifyVo, Model model, RedirectAttributes redirectAttributes){
        if (!beanValidator(model, ordAddModifyVo)){
            return orderAdd(ordAddModifyVo, model);
        }
       // orderService.save(ordAddModifyVo);
        addMessage(redirectAttributes, "保存订单'" + ordAddModifyVo.getOrdTitle() + "'成功");

        model.addAttribute("orderAddModifyVo",ordAddModifyVo);
        return "modules/crm/orderAdd";
    }

    /**
     * 订单详情-产品添加
     * @return
     */
    @RequestMapping(value = {"prodDetailList"})
    public String prodDetailList(String ordCode,Model model){
        model.addAttribute("ordCode", ordCode);
        // 获取所有产品信息
        List<TProduct> list = productService.findAllList();
        // 获取颜色
        List<Dict> colorList = SysDictUtils.getDictList("prod_color");
        model.addAttribute("prod",list);
        model.addAttribute("color",colorList);

        return "modules/crm/prodDetailList";
    }

}
