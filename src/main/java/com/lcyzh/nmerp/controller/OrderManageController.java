package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.controller.common.BaseController;
import com.lcyzh.nmerp.controller.system.util.SysDictUtils;
import com.lcyzh.nmerp.dao.TCustomerMapper;
import com.lcyzh.nmerp.entity.TProduct;
import com.lcyzh.nmerp.entity.sys.Dict;
import com.lcyzh.nmerp.model.vo.*;
import com.lcyzh.nmerp.service.TCustomerService;
import com.lcyzh.nmerp.service.TOrderService;
import com.lcyzh.nmerp.service.TProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            OrderAddModifyVo modifyInfoByOrdCode = orderService.findModifyInfoByOrdCode(ordCode);
            return modifyInfoByOrdCode;
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
        String orderCodeInfo = ordAddModifyVo.getOrdCode();
        orderService.save(ordAddModifyVo);
        addMessage(redirectAttributes, "保存订单'" + ordAddModifyVo.getOrdTitle() + "'成功");
        model.addAttribute("orderAddModifyVo",ordAddModifyVo);
        if(StringUtils.isNotBlank(orderCodeInfo)){
            return "redirect:/crm/order/list";
        }
        return "redirect:/order/order_add?ordCode=" + ordAddModifyVo.getOrdCode();
    }

    /**
     * 订单详情-产品添加crm
     * @return
     */
    @RequestMapping(value = {"prodDetailList"})
    public String prodDetailList(String ordCode,Model model){
        model.addAttribute("ordCode", ordCode);
        // 获取所有产品信息
        List<ProductVo> list = productService.findAllList();
        // 获取颜色
        List<Dict> colorList = SysDictUtils.getDictList("prod_color");
        model.addAttribute("prod",list);
        model.addAttribute("color",colorList);

        return "modules/crm/prodDetailList";
    }

    @RequestMapping(value = "update_orderPrice")
    public String updateOrderPrice(String ordCode,Model model){
        model.addAttribute("ordCode", ordCode);
        List<ProductVo> list = productService.findAllList();
        model.addAttribute("prod",list);
        return "modules/crm/prodDetailPrice";
    }


    /**
     * 订单详情-产品添加
     * @return
     */
    @RequestMapping(value = {"orderDetailBatchSave"})
    @ResponseBody
    public Map<String,Object> orderDetailBatchSave(@RequestBody List<OrderItemVo> list){
        Map<String,Object> map = new HashMap<>();
        map.put("res","success");
        if(CollectionUtils.isEmpty(list)){
            map.put("res","error");
        }else{
            int res = orderService.save(list);
            if(res < 1){
                map.put("res","error");
            }
        }
        return map;
    }

    /**
     * 订单详情-产品添加
     * @return
     */
    @RequestMapping(value = {"orderDetailBatchUpdatePrice"})
    @ResponseBody
    public Map<String,Object> orderDetailBatchUpdatePrice(@RequestBody List<OrderItemVo> list){
        Map<String,Object> map = new HashMap<>();
        map.put("res","success");
        if(CollectionUtils.isEmpty(list)){
            map.put("res","error");
        }else{
            int res = orderService.updatePrice(list);
            if(res < 1){
                map.put("res","error");
            }
        }
        return map;
    }

    @RequestMapping(value = "order_delete")
    public String delete(String ordCode, RedirectAttributes redirectAttributes) {
        int res = orderService.detele(ordCode);
        if(res == -2){
            addMessage(redirectAttributes, "已经下发,已经存在生产入库不能删除！");
            return "redirect:/crm/order/list";
        }
        if(res < 1){
            addMessage(redirectAttributes, "删除失败");
            return "redirect:/crm/order/list";
        }
        return "redirect:/crm/order/list";
    }




}
