package com.lcyzh.nmerp.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Author ljk
 * Date  2019-07-02
 */
public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;
    private String ordCode;
    private Character paymentPeriod;
    private Integer finishedPeriod;
    private Integer overdueNum;
    private Double repayAmount;
    private Double unRepayAmount;
    private Double invoicedAmount;
    private Double unInvoicedAmount;
    private Date createTime;
    private Date updateTime;


    public Payment() {
    }

    public void setOrdCode(String ordCode) {
        this.ordCode = ordCode;
    }

    public String getOrdCode() {
        return ordCode;
    }

    public void setPaymentPeriod(Character paymentPeriod) {
        this.paymentPeriod = paymentPeriod;
    }

    public Character getPaymentPeriod() {
        return paymentPeriod;
    }

    public void setFinishedPeriod(Integer finishedPeriod) {
        this.finishedPeriod = finishedPeriod;
    }

    public Integer getFinishedPeriod() {
        return finishedPeriod;
    }

    public void setOverdueNum(Integer overdueNum) {
        this.overdueNum = overdueNum;
    }

    public Integer getOverdueNum() {
        return overdueNum;
    }

    public void setRepayAmount(Double repayAmount) {
        this.repayAmount = repayAmount;
    }

    public Double getRepayAmount() {
        return repayAmount;
    }

    public void setUnRepayAmount(Double unRepayAmount) {
        this.unRepayAmount = unRepayAmount;
    }

    public Double getUnRepayAmount() {
        return unRepayAmount;
    }

    public void setInvoicedAmount(Double invoicedAmount) {
        this.invoicedAmount = invoicedAmount;
    }

    public Double getInvoicedAmount() {
        return invoicedAmount;
    }

    public void setUnInvoicedAmount(Double unInvoicedAmount) {
        this.unInvoicedAmount = unInvoicedAmount;
    }

    public Double getUnInvoicedAmount() {
        return unInvoicedAmount;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

}