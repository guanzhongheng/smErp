package com.lcyzh.nmerp.service.entity;

import java.io.Serializable;
import java.util.Date;

/**
* Author ljk
* Date  2019-07-01
*/
public class SysUser implements Serializable {
    private static final long serialVersionUID = 1L;
    private String userCode;
    private String loginCode;
    private String userName;
    private String password;
    private String email;
    private String mobile;
    private String phone;
    private Character sex;
    private String avatar;
    private String sign;
    private String userType;
    private Character mgrType;
    private Character status;
    private String createBy;
    private Date createTime;
    private Date updateDate;
    private String updateBy;
    private String remarks;


    public SysUser(){
    }

    public void setUserCode (String userCode) {this.userCode = userCode;} 
    public String getUserCode(){ return userCode;} 
    public void setLoginCode (String loginCode) {this.loginCode = loginCode;} 
    public String getLoginCode(){ return loginCode;} 
    public void setUserName (String userName) {this.userName = userName;} 
    public String getUserName(){ return userName;} 
    public void setPassword (String password) {this.password = password;} 
    public String getPassword(){ return password;} 
    public void setEmail (String email) {this.email = email;} 
    public String getEmail(){ return email;} 
    public void setMobile (String mobile) {this.mobile = mobile;} 
    public String getMobile(){ return mobile;} 
    public void setPhone (String phone) {this.phone = phone;} 
    public String getPhone(){ return phone;} 
    public void setSex (Character sex) {this.sex = sex;} 
    public Character getSex(){ return sex;} 
    public void setAvatar (String avatar) {this.avatar = avatar;} 
    public String getAvatar(){ return avatar;} 
    public void setSign (String sign) {this.sign = sign;} 
    public String getSign(){ return sign;} 
    public void setUserType (String userType) {this.userType = userType;} 
    public String getUserType(){ return userType;} 
    public void setMgrType (Character mgrType) {this.mgrType = mgrType;} 
    public Character getMgrType(){ return mgrType;} 
    public void setStatus (Character status) {this.status = status;} 
    public Character getStatus(){ return status;} 
    public void setCreateBy (String createBy) {this.createBy = createBy;} 
    public String getCreateBy(){ return createBy;} 
    public void setCreateTime (Date createTime) {this.createTime = createTime;} 
    public Date getCreateTime(){ return createTime;} 
    public void setUpdateDate (Date updateDate) {this.updateDate = updateDate;} 
    public Date getUpdateDate(){ return updateDate;} 
    public void setUpdateBy (String updateBy) {this.updateBy = updateBy;} 
    public String getUpdateBy(){ return updateBy;} 
    public void setRemarks (String remarks) {this.remarks = remarks;} 
    public String getRemarks(){ return remarks;} 

}