package com.lcyzh.nmerp.model.vo;

import java.util.Date;

/**
 * @Project : nm-erp
 * @Description : TODO
 * @Author : lijinku
 * @Iteration : 1.0
 * @Date : 2019/7/7  12:57 AM
 * @ModificationHistory Who          When          What
 * ----------   ------------- -----------------------------------
 * lijinku          2019/07/07    create
 */
public class CusFollowDetailVo {
    //客户资料编号
    private String cusCode;
    //员工编号
    private String empCode;
    //跟进时间
    private Date followTime;
    //跟进内容
    private String followDetail;
    //跟进类型
    private Long followType;
    //备注
    private String remark;

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

    public Long getFollowType() {
        return followType;
    }

    public void setFollowType(Long followType) {
        this.followType = followType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}