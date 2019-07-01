package com.lcyzh.nmerp.service.entity;

import java.io.Serializable;
import java.util.Date;

/**
* Author ljk
* Date  2019-07-01
*/
public class PrimaryContact implements Serializable {
    private static final long serialVersionUID = 1L;
    private String cusCode;
    private String contactName;
    private Character contactSex;
    private String contactBirth;
    private String contactRole;
    private String department;
    private String contactPhone;
    private String fixedPhone;
    private String contactAddress;
    private String contactEmail;
    private String remark;
    private Date createTime;
    private Date updateTime;


    public PrimaryContact(){
    }

    public void setCusCode (String cusCode) {this.cusCode = cusCode;} 
    public String getCusCode(){ return cusCode;} 
    public void setContactName (String contactName) {this.contactName = contactName;} 
    public String getContactName(){ return contactName;} 
    public void setContactSex (Character contactSex) {this.contactSex = contactSex;} 
    public Character getContactSex(){ return contactSex;} 
    public void setContactBirth (String contactBirth) {this.contactBirth = contactBirth;} 
    public String getContactBirth(){ return contactBirth;} 
    public void setContactRole (String contactRole) {this.contactRole = contactRole;} 
    public String getContactRole(){ return contactRole;} 
    public void setDepartment (String department) {this.department = department;} 
    public String getDepartment(){ return department;} 
    public void setContactPhone (String contactPhone) {this.contactPhone = contactPhone;} 
    public String getContactPhone(){ return contactPhone;} 
    public void setFixedPhone (String fixedPhone) {this.fixedPhone = fixedPhone;} 
    public String getFixedPhone(){ return fixedPhone;} 
    public void setContactAddress (String contactAddress) {this.contactAddress = contactAddress;} 
    public String getContactAddress(){ return contactAddress;} 
    public void setContactEmail (String contactEmail) {this.contactEmail = contactEmail;} 
    public String getContactEmail(){ return contactEmail;} 
    public void setRemark (String remark) {this.remark = remark;} 
    public String getRemark(){ return remark;} 
    public void setCreateTime (Date createTime) {this.createTime = createTime;} 
    public Date getCreateTime(){ return createTime;} 
    public void setUpdateTime (Date updateTime) {this.updateTime = updateTime;} 
    public Date getUpdateTime(){ return updateTime;} 

}