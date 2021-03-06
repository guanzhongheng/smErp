package com.lcyzh.nmerp.model.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project : nm-erp
 * @Description : TODO
 * @Author : lijinku
 * @Iteration : 1.0
 * @Date : 2019/6/19  5:41 PM
 * @ModificationHistory Who          When          What
 * ----------   ------------- -----------------------------------
 * lijinku          2019/06/19    create
 */
public class OrderAddBatchVo {
    private String ordTitle;
    //订单收货地址
    private String ordAddress;
    //客户名称
    private String cusName;
    //代理商名称
    private String proxyName;
    //订单交付日期
    private String deliveryDate;
    //客户联系电话
    private String phone;

    private String remarks;

    private List<OrderItemVo> itemVos = new ArrayList<>();

    public String getOrdTitle() {
        return ordTitle;
    }

    public void setOrdTitle(String ordTitle) {
        this.ordTitle = ordTitle;
    }

    public String getOrdAddress() {
        return ordAddress;
    }

    public void setOrdAddress(String ordAddress) {
        this.ordAddress = ordAddress;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getProxyName() {
        return proxyName;
    }

    public void setProxyName(String proxyName) {
        this.proxyName = proxyName;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public List<OrderItemVo> getItemVos() {
        return itemVos;
    }

    public void setItemVos(List<OrderItemVo> itemVos) {
        this.itemVos = itemVos;
    }
}