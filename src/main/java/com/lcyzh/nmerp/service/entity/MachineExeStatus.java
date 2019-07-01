package com.lcyzh.nmerp.service.entity;

import java.io.Serializable;
import java.util.Date;

/**
* Author ljk
* Date  2019-07-01
*/
public class MachineExeStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    private String macCode;
    private Character status;
    private Date createTime;
    private Date updateTime;


    public MachineExeStatus(){
    }

    public void setMacCode (String macCode) {this.macCode = macCode;} 
    public String getMacCode(){ return macCode;} 
    public void setStatus (Character status) {this.status = status;} 
    public Character getStatus(){ return status;} 
    public void setCreateTime (Date createTime) {this.createTime = createTime;} 
    public Date getCreateTime(){ return createTime;} 
    public void setUpdateTime (Date updateTime) {this.updateTime = updateTime;} 
    public Date getUpdateTime(){ return updateTime;} 

}