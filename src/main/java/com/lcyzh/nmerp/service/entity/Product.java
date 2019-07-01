package com.lcyzh.nmerp.service.entity;

import java.io.Serializable;
import java.util.Date;

/**
* Author ljk
* Date  2019-07-01
*/
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String prodCode;
    private String prodName;
    private String prodCgyCode;
    private String prodSpec;
    private Date createTime;
    private Character prodType;


    public Product(){
    }

    public void setId (Long id) {this.id = id;} 
    public Long getId(){ return id;} 
    public void setProdCode (String prodCode) {this.prodCode = prodCode;} 
    public String getProdCode(){ return prodCode;} 
    public void setProdName (String prodName) {this.prodName = prodName;} 
    public String getProdName(){ return prodName;} 
    public void setProdCgyCode (String prodCgyCode) {this.prodCgyCode = prodCgyCode;} 
    public String getProdCgyCode(){ return prodCgyCode;} 
    public void setProdSpec (String prodSpec) {this.prodSpec = prodSpec;} 
    public String getProdSpec(){ return prodSpec;} 
    public void setCreateTime (Date createTime) {this.createTime = createTime;} 
    public Date getCreateTime(){ return createTime;} 
    public void setProdType (Character prodType) {this.prodType = prodType;} 
    public Character getProdType(){ return prodType;} 

}