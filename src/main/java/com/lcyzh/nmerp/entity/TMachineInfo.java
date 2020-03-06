package com.lcyzh.nmerp.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Author ljk
 * Date  2019-06-06
 */
public class TMachineInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String macCode;
    private String prodCodes;
    private Double minWidth;
    private Double maxWidth;
    private Date createTime;
    private Date updateTime;


    public TMachineInfo(){
    }

    public void setId (Long id) {this.id = id;}
    public Long getId(){ return id;}
    public void setMacCode (String macCode) {this.macCode = macCode;}
    public String getMacCode(){ return macCode;}
    public void setProdCodes (String prodCodes) {this.prodCodes = prodCodes;}
    public String getProdCodes(){ return prodCodes;}
    public void setMinWidth (Double minWidth) {this.minWidth = minWidth;}
    public Double getMinWidth(){ return minWidth;}
    public void setMaxWidth (Double maxWidth) {this.maxWidth = maxWidth;}
    public Double getMaxWidth(){ return maxWidth;}
    public void setCreateTime (Date createTime) {this.createTime = createTime;}
    public Date getCreateTime(){ return createTime;}
    public void setUpdateTime (Date updateTime) {this.updateTime = updateTime;}
    public Date getUpdateTime(){ return updateTime;}

}