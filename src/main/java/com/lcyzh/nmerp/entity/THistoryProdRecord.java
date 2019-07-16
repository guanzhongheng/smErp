package com.lcyzh.nmerp.entity;

import java.io.Serializable;
import java.util.Date;

/**
* Author ljk
* Date  2019-07-15
*/
public class THistoryProdRecord implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String ordCode;
    private Long orderItemId;
    private Date createTime;
    private String macCode;
    private String itemColor;
    private String itemOwner;
    private Long itemVariety;
    private Long itemCgyCode;
    private String itemYcType;
    private String itemYbType;
    private Double itemTotalSq;
    private Double itemTotalWeight;
    private Long itemNum;
    private Double itemThick;
    private Double itemWidth;
    private Double itemLenth;
    private String itemCode;


    public THistoryProdRecord(){
    }

    public void setId (Long id) {this.id = id;} 
    public Long getId(){ return id;} 
    public void setOrdCode (String ordCode) {this.ordCode = ordCode;} 
    public String getOrdCode(){ return ordCode;} 
    public void setOrderItemId (Long orderItemId) {this.orderItemId = orderItemId;} 
    public Long getOrderItemId(){ return orderItemId;} 
    public void setCreateTime (Date createTime) {this.createTime = createTime;} 
    public Date getCreateTime(){ return createTime;} 
    public void setMacCode (String macCode) {this.macCode = macCode;} 
    public String getMacCode(){ return macCode;} 
    public void setItemColor (String itemColor) {this.itemColor = itemColor;} 
    public String getItemColor(){ return itemColor;} 
    public void setItemOwner (String itemOwner) {this.itemOwner = itemOwner;} 
    public String getItemOwner(){ return itemOwner;} 
    public void setItemVariety (Long itemVariety) {this.itemVariety = itemVariety;} 
    public Long getItemVariety(){ return itemVariety;} 
    public void setItemCgyCode (Long itemCgyCode) {this.itemCgyCode = itemCgyCode;} 
    public Long getItemCgyCode(){ return itemCgyCode;} 
    public void setItemYcType (String itemYcType) {this.itemYcType = itemYcType;} 
    public String getItemYcType(){ return itemYcType;} 
    public void setItemYbType (String itemYbType) {this.itemYbType = itemYbType;} 
    public String getItemYbType(){ return itemYbType;} 
    public void setItemTotalSq (Double itemTotalSq) {this.itemTotalSq = itemTotalSq;} 
    public Double getItemTotalSq(){ return itemTotalSq;} 
    public void setItemTotalWeight (Double itemTotalWeight) {this.itemTotalWeight = itemTotalWeight;} 
    public Double getItemTotalWeight(){ return itemTotalWeight;} 
    public void setItemNum (Long itemNum) {this.itemNum = itemNum;} 
    public Long getItemNum(){ return itemNum;} 
    public void setItemThick (Double itemThick) {this.itemThick = itemThick;} 
    public Double getItemThick(){ return itemThick;} 
    public void setItemWidth (Double itemWidth) {this.itemWidth = itemWidth;} 
    public Double getItemWidth(){ return itemWidth;} 
    public void setItemLenth (Double itemLenth) {this.itemLenth = itemLenth;} 
    public Double getItemLenth(){ return itemLenth;} 
    public void setItemCode (String itemCode) {this.itemCode = itemCode;} 
    public String getItemCode(){ return itemCode;} 

}