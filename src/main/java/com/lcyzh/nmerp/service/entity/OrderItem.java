package com.lcyzh.nmerp.service.entity;

import java.io.Serializable;
import java.util.Date;

/**
* Author ljk
* Date  2019-07-01
*/
public class OrderItem implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long ordCode;
    private String itemCode;
    private String itemUnit;
    private Double itemLenth;
    private Double itemWidth;
    private Double itemThick;
    private String itemColor;
    private Double itemNum;
    private String superOwner;
    private String itemOwner;
    private String remark;
    private Double itemPrice;
    private Date createTime;


    public OrderItem(){
    }

    public void setId (Long id) {this.id = id;} 
    public Long getId(){ return id;} 
    public void setOrdCode (Long ordCode) {this.ordCode = ordCode;} 
    public Long getOrdCode(){ return ordCode;} 
    public void setItemCode (String itemCode) {this.itemCode = itemCode;} 
    public String getItemCode(){ return itemCode;} 
    public void setItemUnit (String itemUnit) {this.itemUnit = itemUnit;} 
    public String getItemUnit(){ return itemUnit;} 
    public void setItemLenth (Double itemLenth) {this.itemLenth = itemLenth;} 
    public Double getItemLenth(){ return itemLenth;} 
    public void setItemWidth (Double itemWidth) {this.itemWidth = itemWidth;} 
    public Double getItemWidth(){ return itemWidth;} 
    public void setItemThick (Double itemThick) {this.itemThick = itemThick;} 
    public Double getItemThick(){ return itemThick;} 
    public void setItemColor (String itemColor) {this.itemColor = itemColor;} 
    public String getItemColor(){ return itemColor;} 
    public void setItemNum (Double itemNum) {this.itemNum = itemNum;} 
    public Double getItemNum(){ return itemNum;} 
    public void setSuperOwner (String superOwner) {this.superOwner = superOwner;} 
    public String getSuperOwner(){ return superOwner;} 
    public void setItemOwner (String itemOwner) {this.itemOwner = itemOwner;} 
    public String getItemOwner(){ return itemOwner;} 
    public void setRemark (String remark) {this.remark = remark;} 
    public String getRemark(){ return remark;} 
    public void setItemPrice (Double itemPrice) {this.itemPrice = itemPrice;} 
    public Double getItemPrice(){ return itemPrice;} 
    public void setCreateTime (Date createTime) {this.createTime = createTime;} 
    public Date getCreateTime(){ return createTime;} 

}