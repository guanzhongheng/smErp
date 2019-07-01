package com.lcyzh.nmerp.service.entity;

import java.io.Serializable;
import java.util.Date;

/**
* Author ljk
* Date  2019-07-01
*/
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    private String ordCode;
    private String ordTitle;
    private Double ordTotalAmount;
    private Character ordType;
    private String ordSignDate;
    private Character ordStatus;
    private String ordDeliveryDate;
    private Character payType;
    private String cusContractor;
    private String comContractor;
    private String contAttachUrl;
    private Date createTime;
    private Date updateTime;


    public Order(){
    }

    public void setOrdCode (String ordCode) {this.ordCode = ordCode;} 
    public String getOrdCode(){ return ordCode;} 
    public void setOrdTitle (String ordTitle) {this.ordTitle = ordTitle;} 
    public String getOrdTitle(){ return ordTitle;} 
    public void setOrdTotalAmount (Double ordTotalAmount) {this.ordTotalAmount = ordTotalAmount;} 
    public Double getOrdTotalAmount(){ return ordTotalAmount;} 
    public void setOrdType (Character ordType) {this.ordType = ordType;} 
    public Character getOrdType(){ return ordType;} 
    public void setOrdSignDate (String ordSignDate) {this.ordSignDate = ordSignDate;} 
    public String getOrdSignDate(){ return ordSignDate;} 
    public void setOrdStatus (Character ordStatus) {this.ordStatus = ordStatus;} 
    public Character getOrdStatus(){ return ordStatus;} 
    public void setOrdDeliveryDate (String ordDeliveryDate) {this.ordDeliveryDate = ordDeliveryDate;} 
    public String getOrdDeliveryDate(){ return ordDeliveryDate;} 
    public void setPayType (Character payType) {this.payType = payType;} 
    public Character getPayType(){ return payType;} 
    public void setCusContractor (String cusContractor) {this.cusContractor = cusContractor;} 
    public String getCusContractor(){ return cusContractor;} 
    public void setComContractor (String comContractor) {this.comContractor = comContractor;} 
    public String getComContractor(){ return comContractor;} 
    public void setContAttachUrl (String contAttachUrl) {this.contAttachUrl = contAttachUrl;} 
    public String getContAttachUrl(){ return contAttachUrl;} 
    public void setCreateTime (Date createTime) {this.createTime = createTime;} 
    public Date getCreateTime(){ return createTime;} 
    public void setUpdateTime (Date updateTime) {this.updateTime = updateTime;} 
    public Date getUpdateTime(){ return updateTime;} 

}