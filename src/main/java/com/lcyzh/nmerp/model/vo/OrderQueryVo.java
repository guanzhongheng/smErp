package com.lcyzh.nmerp.model.vo;

import com.lcyzh.nmerp.common.persistence.DataEntity;

/**
 * @Project : nm-erp
 * @Description :
 * @Author : lijinku
 * @Iteration : 1.0
 * @Date : 2019/7/2  10:03 AM
 * @ModificationHistory Who          When          What
 * ----------   ------------- -----------------------------------
 * lijinku          2019/07/02    create
 */
public class OrderQueryVo extends DataEntity<OrderQueryVo> {
    //订单编号
    private String ordCode;
    //客户资料编号
    private String cusCode;
    //客户名称
    private String cusName;
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
    //订单状态-字典
    private Long ordStatus;
    //订单状态值
    private String ordStatusValue;
    //订单交付日期
    private String ordDeliveryDate;
    //付款方式-字典
    private Long payType;
    //付款方式值
    private String payTypeValue;
    //已回款金额
    private Double repayAmount;
    //已开票金额
    private Double invoicedAmount;
    //逾期数
    private Integer overdueNum;
    //0-未跟进；1-正在跟进
    private Integer followType;

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

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
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

    public String getOrdTypeValue() {
        return ordTypeValue;
    }

    public void setOrdTypeValue(String ordTypeValue) {
        this.ordTypeValue = ordTypeValue;
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

    public String getOrdStatusValue() {
        return ordStatusValue;
    }

    public void setOrdStatusValue(String ordStatusValue) {
        this.ordStatusValue = ordStatusValue;
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

    public String getPayTypeValue() {
        return payTypeValue;
    }

    public void setPayTypeValue(String payTypeValue) {
        this.payTypeValue = payTypeValue;
    }

    public Double getRepayAmount() {
        return repayAmount;
    }

    public void setRepayAmount(Double repayAmount) {
        this.repayAmount = repayAmount;
    }

    public Double getInvoicedAmount() {
        return invoicedAmount;
    }

    public void setInvoicedAmount(Double invoicedAmount) {
        this.invoicedAmount = invoicedAmount;
    }

    public Integer getOverdueNum() {
        return overdueNum;
    }

    public void setOverdueNum(Integer overdueNum) {
        this.overdueNum = overdueNum;
    }

    public Integer getFollowType() {
        return followType;
    }

    public void setFollowType(Integer followType) {
        this.followType = followType;
    }
}