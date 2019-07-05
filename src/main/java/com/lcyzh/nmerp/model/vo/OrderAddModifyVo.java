package com.lcyzh.nmerp.model.vo;

/**
 * @Project : nm-erp
 * @Description : TODO
 * @Author : lijinku
 * @Iteration : 1.0
 * @Date : 2019/7/4  11:09 AM
 * @ModificationHistory Who          When          What
 * ----------   ------------- -----------------------------------
 * lijinku          2019/07/04    create
 */
public class OrderAddModifyVo {

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
    //订单状态
    private Long ordStatus;
    //订单交货期
    private String ordDeliveryDate;
    //支付类型
    private Long payType;
    //客户签约人
    private String cusContractor;
    //我方签约人
    private String comContractor;
    //合同附件
    private String contAttachUrl;
    //订单备注
    private String remark;

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

    public Long getOrdType() {
        return ordType;
    }

    public void setOrdType(Long ordType) {
        this.ordType = ordType;
    }

    public String getOrdSignDate() {
        return ordSignDate;
    }

    public void setOrdSignDate(String ordSignDate) {
        this.ordSignDate = ordSignDate;
    }

    public Long getOrdStatus() {
        return ordStatus;
    }

    public void setOrdStatus(Long ordStatus) {
        this.ordStatus = ordStatus;
    }

    public String getOrdDeliveryDate() {
        return ordDeliveryDate;
    }

    public void setOrdDeliveryDate(String ordDeliveryDate) {
        this.ordDeliveryDate = ordDeliveryDate;
    }

    public Long getPayType() {
        return payType;
    }

    public void setPayType(Long payType) {
        this.payType = payType;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}