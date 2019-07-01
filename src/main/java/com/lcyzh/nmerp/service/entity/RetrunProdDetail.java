package com.lcyzh.nmerp.service.entity;

import java.io.Serializable;
import java.util.Date;

/**
* Author ljk
* Date  2019-07-01
*/
public class RetrunProdDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String returnCode;
    private String prodCode;
    private Double prodNum;
    private String prodSpec;
    private Date createTime;


    public RetrunProdDetail(){
    }

    public void setId (Long id) {this.id = id;} 
    public Long getId(){ return id;} 
    public void setReturnCode (String returnCode) {this.returnCode = returnCode;} 
    public String getReturnCode(){ return returnCode;} 
    public void setProdCode (String prodCode) {this.prodCode = prodCode;} 
    public String getProdCode(){ return prodCode;} 
    public void setProdNum (Double prodNum) {this.prodNum = prodNum;} 
    public Double getProdNum(){ return prodNum;} 
    public void setProdSpec (String prodSpec) {this.prodSpec = prodSpec;} 
    public String getProdSpec(){ return prodSpec;} 
    public void setCreateTime (Date createTime) {this.createTime = createTime;} 
    public Date getCreateTime(){ return createTime;} 

}