package com.lcyzh.nmerp.service.entity;

import java.io.Serializable;
import java.util.Date;

/**
* Author ljk
* Date  2019-07-01
*/
public class CusFollow implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long followId;
    private String cusCode;
    private Date latestFollowTime;
    private Date createTime;


    public CusFollow(){
    }

    public void setFollowId (Long followId) {this.followId = followId;} 
    public Long getFollowId(){ return followId;} 
    public void setCusCode (String cusCode) {this.cusCode = cusCode;} 
    public String getCusCode(){ return cusCode;} 
    public void setLatestFollowTime (Date latestFollowTime) {this.latestFollowTime = latestFollowTime;} 
    public Date getLatestFollowTime(){ return latestFollowTime;} 
    public void setCreateTime (Date createTime) {this.createTime = createTime;} 
    public Date getCreateTime(){ return createTime;} 

}