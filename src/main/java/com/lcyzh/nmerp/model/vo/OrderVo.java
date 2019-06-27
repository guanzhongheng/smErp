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
public class OrderVo {
    private String ordCode;
    private String contCode;
    private String ordAddress;
    private String cusName;
    private Character ordStatus;
    private String deliveryDate;
    private String phone;
    private String remark;
    private List<OrderItemVo> itemVos = new ArrayList<>();

    public String getOrdCode() {
        return ordCode;
    }

    public void setOrdCode(String ordCode) {
        this.ordCode = ordCode;
    }

    public String getContCode() {
        return contCode;
    }

    public void setContCode(String contCode) {
        this.contCode = contCode;
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

    public Character getOrdStatus() {
        return ordStatus;
    }

    public void setOrdStatus(Character ordStatus) {
        this.ordStatus = ordStatus;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<OrderItemVo> getItemVos() {
        return itemVos;
    }

    public void setItemVos(List<OrderItemVo> itemVos) {
        this.itemVos = itemVos;
    }
}