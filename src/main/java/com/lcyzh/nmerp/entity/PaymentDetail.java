package com.lcyzh.nmerp.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Author ljk
 * Date  2019-07-02
 */
public class PaymentDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String ordCode;
    private Double repayAmount;
    private Character isInvoiced;
    private Long payType;
    private Date createTime;


    public PaymentDetail() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setOrdCode(String ordCode) {
        this.ordCode = ordCode;
    }

    public String getOrdCode() {
        return ordCode;
    }

    public void setRepayAmount(Double repayAmount) {
        this.repayAmount = repayAmount;
    }

    public Double getRepayAmount() {
        return repayAmount;
    }

    public void setIsInvoiced(Character isInvoiced) {
        this.isInvoiced = isInvoiced;
    }

    public Character getIsInvoiced() {
        return isInvoiced;
    }

    public void setPayType(Long payType) {
        this.payType = payType;
    }

    public Long getPayType() {
        return payType;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

}