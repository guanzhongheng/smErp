package com.lcyzh.nmerp.service.entity;

import java.io.Serializable;
import java.util.Date;

/**
* Author ljk
* Date  2019-07-01
*/
public class Stock implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String prodCode;
    private Double stockNum;
    private Double avalStockNum;
    private String stockUnit;
    private Date createTime;
    private Date updateTime;


    public Stock(){
    }

    public void setId (Long id) {this.id = id;} 
    public Long getId(){ return id;} 
    public void setProdCode (String prodCode) {this.prodCode = prodCode;} 
    public String getProdCode(){ return prodCode;} 
    public void setStockNum (Double stockNum) {this.stockNum = stockNum;} 
    public Double getStockNum(){ return stockNum;} 
    public void setAvalStockNum (Double avalStockNum) {this.avalStockNum = avalStockNum;} 
    public Double getAvalStockNum(){ return avalStockNum;} 
    public void setStockUnit (String stockUnit) {this.stockUnit = stockUnit;} 
    public String getStockUnit(){ return stockUnit;} 
    public void setCreateTime (Date createTime) {this.createTime = createTime;} 
    public Date getCreateTime(){ return createTime;} 
    public void setUpdateTime (Date updateTime) {this.updateTime = updateTime;} 
    public Date getUpdateTime(){ return updateTime;} 

}