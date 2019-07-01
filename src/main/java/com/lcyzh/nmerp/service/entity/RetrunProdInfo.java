package com.lcyzh.nmerp.service.entity;

import java.io.Serializable;
import java.util.Date;

/**
* Author ljk
* Date  2019-07-01
*/
public class RetrunProdInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String returnCode;
    private Long launchUserId;
    private Character returnType;
    private Character status;
    private String remark;
    private Date createTime;
    private Date updateTime;


    public RetrunProdInfo(){
    }

    public void setId (Long id) {this.id = id;} 
    public Long getId(){ return id;} 
    public void setReturnCode (String returnCode) {this.returnCode = returnCode;} 
    public String getReturnCode(){ return returnCode;} 
    public void setLaunchUserId (Long launchUserId) {this.launchUserId = launchUserId;} 
    public Long getLaunchUserId(){ return launchUserId;} 
    public void setReturnType (Character returnType) {this.returnType = returnType;} 
    public Character getReturnType(){ return returnType;} 
    public void setStatus (Character status) {this.status = status;} 
    public Character getStatus(){ return status;} 
    public void setRemark (String remark) {this.remark = remark;} 
    public String getRemark(){ return remark;} 
    public void setCreateTime (Date createTime) {this.createTime = createTime;} 
    public Date getCreateTime(){ return createTime;} 
    public void setUpdateTime (Date updateTime) {this.updateTime = updateTime;} 
    public Date getUpdateTime(){ return updateTime;} 

}