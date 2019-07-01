package com.lcyzh.nmerp.service.entity;

import java.io.Serializable;
import java.util.Date;

/**
* Author ljk
* Date  2019-07-01
*/
public class OutStock implements Serializable {
    private static final long serialVersionUID = 1L;
    private String outCode;
    private String ordCode;
    private Character outStatus;
    private Long applyUserId;
    private Long operUserId;
    private String remark;
    private Date createTime;
    private Date updateTime;


    public OutStock(){
    }

    public void setOutCode (String outCode) {this.outCode = outCode;} 
    public String getOutCode(){ return outCode;} 
    public void setOrdCode (String ordCode) {this.ordCode = ordCode;} 
    public String getOrdCode(){ return ordCode;} 
    public void setOutStatus (Character outStatus) {this.outStatus = outStatus;} 
    public Character getOutStatus(){ return outStatus;} 
    public void setApplyUserId (Long applyUserId) {this.applyUserId = applyUserId;} 
    public Long getApplyUserId(){ return applyUserId;} 
    public void setOperUserId (Long operUserId) {this.operUserId = operUserId;} 
    public Long getOperUserId(){ return operUserId;} 
    public void setRemark (String remark) {this.remark = remark;} 
    public String getRemark(){ return remark;} 
    public void setCreateTime (Date createTime) {this.createTime = createTime;} 
    public Date getCreateTime(){ return createTime;} 
    public void setUpdateTime (Date updateTime) {this.updateTime = updateTime;} 
    public Date getUpdateTime(){ return updateTime;} 

}