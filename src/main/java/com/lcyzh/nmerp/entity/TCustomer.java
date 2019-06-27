package com.lcyzh.nmerp.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Date;

/**
 * Author ljk
 * Date  2019-06-06
 */
public class TCustomer implements Serializable {
    private static final long serialVersionUID = 1L;
    private String cusCode;
    private String cusName;
    private Character cusGrade;
    private Character status;
    private String cusPhone;
    private String cusBirth;
    private String cusAddress;
    private Date createTime;
    private Date updateTime;


    public TCustomer() {
    }


    public void setCusCode(String cusCode) {
        this.cusCode = cusCode;
    }

    public String getCusCode() {
        return cusCode;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusGrade(Character cusGrade) {
        this.cusGrade = cusGrade;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Character getCusGrade() {
        return cusGrade;
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone;
    }

    public String getCusPhone() {
        return cusPhone;
    }

    public void setCusBirth(String cusBirth) {
        this.cusBirth = cusBirth;
    }

    public String getCusBirth() {
        return cusBirth;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }

    public String getCusAddress() {
        return cusAddress;
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