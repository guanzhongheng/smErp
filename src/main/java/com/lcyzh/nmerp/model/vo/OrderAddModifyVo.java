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
    // 客户名称
    private String cusName;
    //代理商名称
    private String proxyName;
    //订单标题
    private String ordTitle;
    //订单总金额
    private Double ordTotalAmount;
    //订单类型-字典
    private Long ordType;
    //订单类型值
    private String ordTypeValue;
    //订单签订日期
    private String ordSignDate;
    //订单状态
    private Long ordStatus;
    //订单交货期
    private String ordDeliveryDate;
    //支付类型-字典
    private Long payType;
    //支付类型值
    private String payTypeValue;
    //支付状态-字典
    private Long payStatus;
    //支付状态值
    private String payStatusValue;
    //客户签约人
    private String cusContractor;
    //我方签约人
    private String comContractor;
    //合同附件
    private String contAttachUrl;
    //订单备注
    private String remarks;
    //订单产品总数量
    private Long ordTotalNum;
    //订单产品总面积
    private Double ordTotalSq;
    //订单产品总重量
    private Double ordTotalWeight;
    //订单产品出库数量
    private Long ordOutNum;

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getOrdTypeValue() {
        return ordTypeValue;
    }

    public void setOrdTypeValue(String ordTypeValue) {
        this.ordTypeValue = ordTypeValue;
    }

    public String getPayTypeValue() {
        return payTypeValue;
    }

    public void setPayTypeValue(String payTypeValue) {
        this.payTypeValue = payTypeValue;
    }

    public Long getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Long payStatus) {
        this.payStatus = payStatus;
    }

    public String getPayStatusValue() {
        return payStatusValue;
    }

    public void setPayStatusValue(String payStatusValue) {
        this.payStatusValue = payStatusValue;
    }

    public Long getOrdTotalNum() {
        return ordTotalNum;
    }

    public void setOrdTotalNum(Long ordTotalNum) {
        this.ordTotalNum = ordTotalNum;
    }

    public Double getOrdTotalSq() {
        return ordTotalSq;
    }

    public void setOrdTotalSq(Double ordTotalSq) {
        this.ordTotalSq = ordTotalSq;
    }

    public Double getOrdTotalWeight() {
        return ordTotalWeight;
    }

    public void setOrdTotalWeight(Double ordTotalWeight) {
        this.ordTotalWeight = ordTotalWeight;
    }

    public Long getOrdOutNum() {
        return ordOutNum;
    }

    public void setOrdOutNum(Long ordOutNum) {
        this.ordOutNum = ordOutNum;
    }
}