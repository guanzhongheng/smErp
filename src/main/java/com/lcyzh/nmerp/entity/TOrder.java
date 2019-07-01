package com.lcyzh.nmerp.entity;

import com.lcyzh.nmerp.common.persistence.DataEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Date;

/**
 * Author ljk
 * Date  2019-06-06
 */
public class TOrder extends DataEntity<TOrder> {
    private String ordCode;
    private String ordTitle;
    private Double ordTotalAmount;
    private Long ordType;
    private String ordSignDate;
    private Long ordStatus;
    private String ordDeliveryDate;
    private Long payType;
    private String cusContractor;
    private String comContractor;
    private String contAttachUrl;
    private Date createTime;
    private Date updateTime;

    public String getOrdCode() {
        return ordCode;
    }

    public void setOrdCode(String ordCode) {
        this.ordCode = ordCode;
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

    public Long getOrdType() {
        return ordType;
    }

    public void setOrdType(Long ordType) {
        this.ordType = ordType;
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
}