package com.lcyzh.nmerp.service.entity;

import java.io.Serializable;
import java.util.Date;

/**
* Author ljk
* Date  2019-07-01
*/
public class InStock implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String inCode;
    private Character inStatus;
    private Long applyUserId;
    private Long operUserId;
    private String remark;
    private Date createTime;
    private Date updateTime;


    public InStock(){
    }

    public void setId (Long id) {this.id = id;} 
    public Long getId(){ return id;} 
    public void setInCode (String inCode) {this.inCode = inCode;} 
    public String getInCode(){ return inCode;} 
    public void setInStatus (Character inStatus) {this.inStatus = inStatus;} 
    public Character getInStatus(){ return inStatus;} 
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