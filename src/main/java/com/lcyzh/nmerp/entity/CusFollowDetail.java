package com.lcyzh.nmerp.entity;

import java.io.Serializable;
import java.util.Date;

/**
* Author ljk
* Date  2019-07-01
*/
public class CusFollowDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String followId;
    private String empCode;
    private Date followTime;
    private String followDetail;
    private String remark;
    private Date createTime;


    public CusFollowDetail(){
    }

    public void setId (Long id) {this.id = id;} 
    public Long getId(){ return id;} 
    public void setFollowId (String followId) {this.followId = followId;} 
    public String getFollowId(){ return followId;} 
    public void setEmpCode (String empCode) {this.empCode = empCode;} 
    public String getEmpCode(){ return empCode;} 
    public void setFollowTime (Date followTime) {this.followTime = followTime;} 
    public Date getFollowTime(){ return followTime;} 
    public void setFollowDetail (String followDetail) {this.followDetail = followDetail;} 
    public String getFollowDetail(){ return followDetail;} 
    public void setRemark (String remark) {this.remark = remark;} 
    public String getRemark(){ return remark;} 
    public void setCreateTime (Date createTime) {this.createTime = createTime;} 
    public Date getCreateTime(){ return createTime;} 

}