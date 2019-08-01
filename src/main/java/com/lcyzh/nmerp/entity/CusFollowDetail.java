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
    private String cusCode;
    private String empCode;
    private Date followTime;
    private String followDetail;
    private String followTitle;
    private String remark;
    private Date createTime;


    public CusFollowDetail() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCusCode() {
        return cusCode;
    }

    public void setCusCode(String cusCode) {
        this.cusCode = cusCode;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public Date getFollowTime() {
        return followTime;
    }

    public void setFollowTime(Date followTime) {
        this.followTime = followTime;
    }

    public String getFollowDetail() {
        return followDetail;
    }

    public void setFollowDetail(String followDetail) {
        this.followDetail = followDetail;
    }

    public String getFollowTitle() {
        return followTitle;
    }

    public void setFollowTitle(String followTitle) {
        this.followTitle = followTitle;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}