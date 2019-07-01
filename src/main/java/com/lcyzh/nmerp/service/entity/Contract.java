package com.lcyzh.nmerp.service.entity;

import java.io.Serializable;
import java.util.Date;

/**
* Author ljk
* Date  2019-07-01
*/
public class Contract implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String contCode;
    private String contManager;
    private String contSignDate;
    private String contAttach;
    private Character contStatus;
    private Date createTime;
    private Date updateTime;


    public Contract(){
    }

    public void setId (Long id) {this.id = id;} 
    public Long getId(){ return id;} 
    public void setContCode (String contCode) {this.contCode = contCode;} 
    public String getContCode(){ return contCode;} 
    public void setContManager (String contManager) {this.contManager = contManager;} 
    public String getContManager(){ return contManager;} 
    public void setContSignDate (String contSignDate) {this.contSignDate = contSignDate;} 
    public String getContSignDate(){ return contSignDate;} 
    public void setContAttach (String contAttach) {this.contAttach = contAttach;} 
    public String getContAttach(){ return contAttach;} 
    public void setContStatus (Character contStatus) {this.contStatus = contStatus;} 
    public Character getContStatus(){ return contStatus;} 
    public void setCreateTime (Date createTime) {this.createTime = createTime;} 
    public Date getCreateTime(){ return createTime;} 
    public void setUpdateTime (Date updateTime) {this.updateTime = updateTime;} 
    public Date getUpdateTime(){ return updateTime;} 

}