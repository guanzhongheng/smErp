package com.lcyzh.nmerp.service.entity;

import java.io.Serializable;
import java.util.Date;

/**
* Author ljk
* Date  2019-07-01
*/
public class ProdCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String cgyCode;
    private String cgyName;
    private String parentCgyCode;
    private Date createTime;


    public ProdCategory(){
    }

    public void setId (Long id) {this.id = id;} 
    public Long getId(){ return id;} 
    public void setCgyCode (String cgyCode) {this.cgyCode = cgyCode;} 
    public String getCgyCode(){ return cgyCode;} 
    public void setCgyName (String cgyName) {this.cgyName = cgyName;} 
    public String getCgyName(){ return cgyName;} 
    public void setParentCgyCode (String parentCgyCode) {this.parentCgyCode = parentCgyCode;} 
    public String getParentCgyCode(){ return parentCgyCode;} 
    public void setCreateTime (Date createTime) {this.createTime = createTime;} 
    public Date getCreateTime(){ return createTime;} 

}