package com.lcyzh.nmerp.service.entity;

import java.io.Serializable;
import java.util.Date;

/**
* Author ljk
* Date  2019-07-01
*/
public class ProdplanExe implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long ordItemId;
    private String macCode;
    private Double itemNum;
    private String itemUnit;
    private Date updateTime;
    private Character status;
    private Date finishTime;
    private Date createTime;


    public ProdplanExe(){
    }

    public void setId (Long id) {this.id = id;} 
    public Long getId(){ return id;} 
    public void setOrdItemId (Long ordItemId) {this.ordItemId = ordItemId;} 
    public Long getOrdItemId(){ return ordItemId;} 
    public void setMacCode (String macCode) {this.macCode = macCode;} 
    public String getMacCode(){ return macCode;} 
    public void setItemNum (Double itemNum) {this.itemNum = itemNum;} 
    public Double getItemNum(){ return itemNum;} 
    public void setItemUnit (String itemUnit) {this.itemUnit = itemUnit;} 
    public String getItemUnit(){ return itemUnit;} 
    public void setUpdateTime (Date updateTime) {this.updateTime = updateTime;} 
    public Date getUpdateTime(){ return updateTime;} 
    public void setStatus (Character status) {this.status = status;} 
    public Character getStatus(){ return status;} 
    public void setFinishTime (Date finishTime) {this.finishTime = finishTime;} 
    public Date getFinishTime(){ return finishTime;} 
    public void setCreateTime (Date createTime) {this.createTime = createTime;} 
    public Date getCreateTime(){ return createTime;} 

}