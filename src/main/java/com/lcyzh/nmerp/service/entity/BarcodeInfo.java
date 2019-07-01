package com.lcyzh.nmerp.service.entity;

import java.io.Serializable;
import java.util.Date;

/**
* Author ljk
* Date  2019-07-01
*/
public class BarcodeInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String barCode;
    private String ordCode;
    private Long itemId;
    private Double num;
    private String unit;
    private Character status;
    private Date createTime;
    private Date updateTime;


    public BarcodeInfo(){
    }

    public void setBarCode (String barCode) {this.barCode = barCode;} 
    public String getBarCode(){ return barCode;} 
    public void setOrdCode (String ordCode) {this.ordCode = ordCode;} 
    public String getOrdCode(){ return ordCode;} 
    public void setItemId (Long itemId) {this.itemId = itemId;} 
    public Long getItemId(){ return itemId;} 
    public void setNum (Double num) {this.num = num;} 
    public Double getNum(){ return num;} 
    public void setUnit (String unit) {this.unit = unit;} 
    public String getUnit(){ return unit;} 
    public void setStatus (Character status) {this.status = status;} 
    public Character getStatus(){ return status;} 
    public void setCreateTime (Date createTime) {this.createTime = createTime;} 
    public Date getCreateTime(){ return createTime;} 
    public void setUpdateTime (Date updateTime) {this.updateTime = updateTime;} 
    public Date getUpdateTime(){ return updateTime;} 

}