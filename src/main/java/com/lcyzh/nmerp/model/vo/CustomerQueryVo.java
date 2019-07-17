package com.lcyzh.nmerp.model.vo;

import com.lcyzh.nmerp.common.persistence.DataEntity;
import com.lcyzh.nmerp.common.persistence.Page;

import java.util.Date;

/**
 * @Project : nm-erp
 * @Description : TODO
 * @Author : lijinku
 * @Iteration : 1.0
 * @Date : 2019/7/1  3:55 PM
 * @ModificationHistory Who          When          What
 * ----------   ------------- -----------------------------------
 * lijinku          2019/07/01    create
 */
public class CustomerQueryVo extends DataEntity<CustomerQueryVo> {

    //客户编号
    private String cusCode;
    //客户名称
    private String cusName;
    //客户状态-字典
    private Long cusStatus;
    //客户状态值
    private String cusStatusValue;
    //客户星级-字典
    private Long cusGrade;
    //客户星级值
    private String cusGradeValue;
    //客户涞源-字典
    private Long cusSource;
    //客户来源
    private String cusSourceValue;
    //客户类型
    private Long cusType;
    //所属行业
    private String industry;
    //首要联系人姓名
    private String primaryContactorName;
    //首要联系人电话
    private String primaryContactorPhone;
    //最后跟进日期
    private Date lastFollowDate;
    //为跟进天数
    private int unFollowDays;
    //0-未跟进；1-正在跟进
    private Integer followType;

    public String getCusCode() {
        return cusCode;
    }

    public void setCusCode(String cusCode) {
        this.cusCode = cusCode;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public Long getCusStatus() {
        return cusStatus;
    }

    public void setCusStatus(Long cusStatus) {
        this.cusStatus = cusStatus;
    }

    public String getCusStatusValue() {
        return cusStatusValue;
    }

    public void setCusStatusValue(String cusStatusValue) {
        this.cusStatusValue = cusStatusValue;
    }

    public Long getCusGrade() {
        return cusGrade;
    }

    public void setCusGrade(Long cusGrade) {
        this.cusGrade = cusGrade;
    }

    public String getCusGradeValue() {
        return cusGradeValue;
    }

    public void setCusGradeValue(String cusGradeValue) {
        this.cusGradeValue = cusGradeValue;
    }

    public String getPrimaryContactorName() {
        return primaryContactorName;
    }

    public void setPrimaryContactorName(String primaryContactorName) {
        this.primaryContactorName = primaryContactorName;
    }

    public String getPrimaryContactorPhone() {
        return primaryContactorPhone;
    }

    public void setPrimaryContactorPhone(String primaryContactorPhone) {
        this.primaryContactorPhone = primaryContactorPhone;
    }

    public Date getLastFollowDate() {
        return lastFollowDate;
    }

    public void setLastFollowDate(Date lastFollowDate) {
        this.lastFollowDate = lastFollowDate;
    }

    public int getUnFollowDays() {
        return unFollowDays;
    }

    public void setUnFollowDays(int unFollowDays) {
        this.unFollowDays = unFollowDays;
    }

    public Long getCusSource() {
        return cusSource;
    }

    public void setCusSource(Long cusSource) {
        this.cusSource = cusSource;
    }

    public Long getCusType() {
        return cusType;
    }

    public void setCusType(Long cusType) {
        this.cusType = cusType;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getCusSourceValue() {
        return cusSourceValue;
    }

    public void setCusSourceValue(String cusSourceValue) {
        this.cusSourceValue = cusSourceValue;
    }

    public Integer getFollowType() {
        return followType;
    }

    public void setFollowType(Integer followType) {
        this.followType = followType;
    }
}