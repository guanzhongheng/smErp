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

}