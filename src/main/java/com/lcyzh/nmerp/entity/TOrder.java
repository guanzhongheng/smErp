package com.lcyzh.nmerp.entity;


import java.util.Date;

/**
 * Author ljk
 * Date  2019-06-06
 */
public class TOrder{
    //订单编号
    private String ordCode;
    //客户资料编号
    private String cusCode;
    //代理商名称
    private String proxyName;
    //订单标题
    private String ordTitle;
    //订单总金额
    private Double ordTotalAmount;
    //订单类型
    private Long ordType;
    //订单签订日期
    private String ordSignDate;
    //订单状态 0-新建 1-已审批 2-排产 3-完成 4-拒绝
    private Character ordStatus;
    private String ordDeliveryDate;
    //付款方式 0-新建 1-待审批 2-排产 3-完成 4-拒绝
    private Character payType;
    //支付状态 0-现金支付 1-电子转账
    private Character payStatus;
    //客户签约人
    private String cusContractor;
    //公司签约人
    private String comContractor;
    //合同附件
    private String contAttachUrl;
    //备注
    private String remarks;
    private Date createTime;
    private Date updateTime;

    public String getOrdCode() {
        return ordCode;
    }

    public void setOrdCode(String ordCode) {
        this.ordCode = ordCode;
    }

    public String getCusCode() {
        return cusCode;
    }

    public void setCusCode(String cusCode) {
        this.cusCode = cusCode;
    }

    public String getProxyName() {
        return proxyName;
    }

    public void setProxyName(String proxyName) {
        this.proxyName = proxyName;
    }

    public String getOrdTitle() {
        return ordTitle;
    }

    public void setOrdTitle(String ordTitle) {
        this.ordTitle = ordTitle;
    }

    public Double getOrdTotalAmount() {
        return ordTotalAmount;
    }

    public void setOrdTotalAmount(Double ordTotalAmount) {
        this.ordTotalAmount = ordTotalAmount;
    }


    public String getOrdSignDate() {
        return ordSignDate;
    }

    public void setOrdSignDate(String ordSignDate) {
        this.ordSignDate = ordSignDate;
    }

    public Character getOrdStatus() {
        return ordStatus;
    }

    public void setOrdStatus(Character ordStatus) {
        this.ordStatus = ordStatus;
    }

    public String getOrdDeliveryDate() {
        return ordDeliveryDate;
    }

    public void setOrdDeliveryDate(String ordDeliveryDate) {
        this.ordDeliveryDate = ordDeliveryDate;
    }

    public Long getOrdType() {
        return ordType;
    }

    public void setOrdType(Long ordType) {
        this.ordType = ordType;
    }

    public String getCusContractor() {
        return cusContractor;
    }

    public void setCusContractor(String cusContractor) {
        this.cusContractor = cusContractor;
    }

    public String getComContractor() {
        return comContractor;
    }

    public void setComContractor(String comContractor) {
        this.comContractor = comContractor;
    }

    public String getContAttachUrl() {
        return contAttachUrl;
    }

    public void setContAttachUrl(String contAttachUrl) {
        this.contAttachUrl = contAttachUrl;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setPayType(Character payType) {
        this.payType = payType;
    }

    public Character getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Character payStatus) {
        this.payStatus = payStatus;
    }
}