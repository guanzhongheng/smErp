package com.lcyzh.nmerp.service.entity;

import java.io.Serializable;
import java.util.Date;

/**
* Author ljk
* Date  2019-07-01
*/
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    private String cusCode;
    private String cusName;
    private Character cusStatus;
    private Double cusGrade;
    private Character cusType;
    private String industry;
    private String cusAddress;
    private Character cusSource;
    private String remark;
    private Date createTime;
    private Date updateTime;


    public Customer(){
    }

    public void setCusCode (String cusCode) {this.cusCode = cusCode;} 
    public String getCusCode(){ return cusCode;} 
    public void setCusName (String cusName) {this.cusName = cusName;} 
    public String getCusName(){ return cusName;} 
    public void setCusStatus (Character cusStatus) {this.cusStatus = cusStatus;} 
    public Character getCusStatus(){ return cusStatus;} 
    public void setCusGrade (Double cusGrade) {this.cusGrade = cusGrade;} 
    public Double getCusGrade(){ return cusGrade;} 
    public void setCusType (Character cusType) {this.cusType = cusType;} 
    public Character getCusType(){ return cusType;} 
    public void setIndustry (String industry) {this.industry = industry;} 
    public String getIndustry(){ return industry;} 
    public void setCusAddress (String cusAddress) {this.cusAddress = cusAddress;} 
    public String getCusAddress(){ return cusAddress;} 
    public void setCusSource (Character cusSource) {this.cusSource = cusSource;} 
    public Character getCusSource(){ return cusSource;} 
    public void setRemark (String remark) {this.remark = remark;} 
    public String getRemark(){ return remark;} 
    public void setCreateTime (Date createTime) {this.createTime = createTime;} 
    public Date getCreateTime(){ return createTime;} 
    public void setUpdateTime (Date updateTime) {this.updateTime = updateTime;} 
    public Date getUpdateTime(){ return updateTime;} 

}