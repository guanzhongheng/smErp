package com.lcyzh.nmerp.entity;

import com.lcyzh.nmerp.common.persistence.DataEntity;

import java.util.Date;

/**
 * Author ljk
 * Date  2019-07-01
 */
public class Customer {
    private static final long serialVersionUID = 1L;
    private String cusCode;
    private String cusName;
    private Long cusStatus;
    private Long cusGrade;
    private Long cusType;
    private String industry;
    private String cusAddress;
    private Long cusSource;
    private String remark;
    private Date createTime;
    private Date updateTime;

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

    public Long getCusStatus() {
        return cusStatus;
    }

    public void setCusStatus(Long cusStatus) {
        this.cusStatus = cusStatus;
    }

    public Long getCusGrade() {
        return cusGrade;
    }

    public void setCusGrade(Long cusGrade) {
        this.cusGrade = cusGrade;
    }

    public Long getCusType() {
        return cusType;
    }

    public void setCusType(Long cusType) {
        this.cusType = cusType;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getCusAddress() {
        return cusAddress;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }

    public Long getCusSource() {
        return cusSource;
    }

    public void setCusSource(Long cusSource) {
        this.cusSource = cusSource;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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