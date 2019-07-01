package com.lcyzh.nmerp.service.entity;

import java.io.Serializable;
import java.util.Date;

/**
* Author ljk
* Date  2019-07-01
*/
public class ReturnMaterDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String returnCode;
    private String rawmCode;
    private Double returnNum;
    private Date createTime;


    public ReturnMaterDetail(){
    }

    public void setId (Long id) {this.id = id;} 
    public Long getId(){ return id;} 
    public void setReturnCode (String returnCode) {this.returnCode = returnCode;} 
    public String getReturnCode(){ return returnCode;} 
    public void setRawmCode (String rawmCode) {this.rawmCode = rawmCode;} 
    public String getRawmCode(){ return rawmCode;} 
    public void setReturnNum (Double returnNum) {this.returnNum = returnNum;} 
    public Double getReturnNum(){ return returnNum;} 
    public void setCreateTime (Date createTime) {this.createTime = createTime;} 
    public Date getCreateTime(){ return createTime;} 

}