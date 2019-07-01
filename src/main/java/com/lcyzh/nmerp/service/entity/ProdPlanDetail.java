package com.lcyzh.nmerp.service.entity;

import java.io.Serializable;
import java.util.Date;

/**
* Author ljk
* Date  2019-07-01
*/
public class ProdPlanDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long ordItemId;
    private String prodPlanCode;
    private Double leastTime;
    private Double mostTime;
    private Date createTime;


    public ProdPlanDetail(){
    }

    public void setOrdItemId (Long ordItemId) {this.ordItemId = ordItemId;} 
    public Long getOrdItemId(){ return ordItemId;} 
    public void setProdPlanCode (String prodPlanCode) {this.prodPlanCode = prodPlanCode;} 
    public String getProdPlanCode(){ return prodPlanCode;} 
    public void setLeastTime (Double leastTime) {this.leastTime = leastTime;} 
    public Double getLeastTime(){ return leastTime;} 
    public void setMostTime (Double mostTime) {this.mostTime = mostTime;} 
    public Double getMostTime(){ return mostTime;} 
    public void setCreateTime (Date createTime) {this.createTime = createTime;} 
    public Date getCreateTime(){ return createTime;} 

}