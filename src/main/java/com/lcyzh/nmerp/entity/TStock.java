package com.lcyzh.nmerp.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Date;

/**
* Author ljk
* Date  2019-07-15
*/
public class TStock implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String barCode;
    private String ordCode;
    private Long orderItemId;
    private String itemCode;
    private Double itemLenth;
    private Double itemWidth;
    private Double itemThick;
    private Double itemWeight;
    private Double itemSq;
    private Character status;
    private Date createTime;
    private Date updateTime;
    private String itemOwner;
    private String itemYcType;
    private String itemYbType;
    private Long itemCgyCode;
    private Long itemVariety;
    private Long itemUnit;
    private String itemColor;
    private String macCode;

    public TStock(){
    }

    public void setId (Long id) {this.id = id;}
    public Long getId(){ return id;} 
    public void setBarCode (String barCode) {this.barCode = barCode;}
    public String getBarCode(){ return barCode;}
    public void setOrdCode (String ordCode) {this.ordCode = ordCode;} 
    public String getOrdCode(){ return ordCode;}
    public Long getOrderItemId() {
        return orderItemId;
    }
    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }
    public void setItemCode (String itemCode) {this.itemCode = itemCode;}
    public String getItemCode(){ return itemCode;} 
    public void setItemLenth (Double itemLenth) {this.itemLenth = itemLenth;} 
    public Double getItemLenth(){ return itemLenth;} 
    public void setItemWidth (Double itemWidth) {this.itemWidth = itemWidth;} 
    public Double getItemWidth(){ return itemWidth;} 
    public void setItemThick (Double itemThick) {this.itemThick = itemThick;} 
    public Double getItemThick(){ return itemThick;} 
    public void setItemWeight (Double itemWeight) {this.itemWeight = itemWeight;} 
    public Double getItemWeight(){ return itemWeight;} 
    public void setItemSq (Double itemSq) {this.itemSq = itemSq;} 
    public Double getItemSq(){ return itemSq;} 
    public void setStatus (Character status) {this.status = status;} 
    public Character getStatus(){ return status;} 
    public void setCreateTime (Date createTime) {this.createTime = createTime;} 
    public Date getCreateTime(){ return createTime;} 
    public void setUpdateTime (Date updateTime) {this.updateTime = updateTime;} 
    public Date getUpdateTime(){ return updateTime;} 
    public void setItemOwner (String itemOwner) {this.itemOwner = itemOwner;} 
    public String getItemOwner(){ return itemOwner;} 
    public void setItemYcType (String itemYcType) {this.itemYcType = itemYcType;} 
    public String getItemYcType(){ return itemYcType;} 
    public void setItemYbType (String itemYbType) {this.itemYbType = itemYbType;} 
    public String getItemYbType(){ return itemYbType;} 
    public void setItemCgyCode (Long itemCgyCode) {this.itemCgyCode = itemCgyCode;} 
    public Long getItemCgyCode(){ return itemCgyCode;} 
    public void setItemVariety (Long itemVariety) {this.itemVariety = itemVariety;} 
    public Long getItemVariety(){ return itemVariety;} 
    public void setItemUnit (Long itemUnit) {this.itemUnit = itemUnit;} 
    public Long getItemUnit(){ return itemUnit;} 
    public void setItemColor (String itemColor) {this.itemColor = itemColor;} 
    public String getItemColor(){ return itemColor;}
    public String getMacCode() { return macCode; }
    public void setMacCode(String macCode) { this.macCode = macCode; }
}