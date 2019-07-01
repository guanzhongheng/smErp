package com.lcyzh.nmerp.service.entity;

import java.io.Serializable;
import java.util.Date;

/**
* Author ljk
* Date  2019-07-01
*/
public class MachineInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String macCode;
    private String prodCodes;
    private Date createTime;
    private Date updateTime;


    public MachineInfo(){
    }

    public void setId (Long id) {this.id = id;} 
    public Long getId(){ return id;} 
    public void setMacCode (String macCode) {this.macCode = macCode;} 
    public String getMacCode(){ return macCode;} 
    public void setProdCodes (String prodCodes) {this.prodCodes = prodCodes;} 
    public String getProdCodes(){ return prodCodes;} 
    public void setCreateTime (Date createTime) {this.createTime = createTime;} 
    public Date getCreateTime(){ return createTime;} 
    public void setUpdateTime (Date updateTime) {this.updateTime = updateTime;} 
    public Date getUpdateTime(){ return updateTime;} 

}