package com.lcyzh.nmerp.model.vo;

/**
 * @Project : nm-erp
 * @Description : TODO
 * @Author : lijinku
 * @Iteration : 1.0
 * @Date : 2019/7/1  5:33 PM
 * @ModificationHistory Who          When          What
 * ----------   ------------- -----------------------------------
 * lijinku          2019/07/01    create
 */
public class CustomerAddModifyVo {
    //客户编号-更新时存在
    private String cusCode;
    //客户名称
    private String cusName;
    //客户状态-字典
    private Long cusStatus;
    //客户星级-字典
    private Long cusGrade;
    //客户来源-字典
    private Long cusSource;
    //客户类型
    private Long cusType;
    //公司地址
    private String cusAddress;
    //所属行业
    private String industry;
    //首要联系人姓名
    private String primaryContactorName;
    //首要联系人电话
    private String primaryContactorPhone;
    //首要联系人生日
    private String primaryContactorBirth;
    //首要联系人角色
    private String primaryContactorRole;
    //首要联系人所属部门
    private String primaryContactorDepartment;
    //首要联系人固话
    private String primaryContactorFixedPhone;
    //首要联系人地址
    private String primaryContactorAddress;
    //首要联系人电子邮件
    private String primaryContactorEmail;
    //首要联系人性别
    private Long primaryContactorSex;
    //员工编号
    private String empCode;

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


    public Long getCusGrade() {
        return cusGrade;
    }

    public void setCusGrade(Long cusGrade) {
        this.cusGrade = cusGrade;
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

    public String getPrimaryContactorBirth() {
        return primaryContactorBirth;
    }

    public void setPrimaryContactorBirth(String primaryContactorBirth) {
        this.primaryContactorBirth = primaryContactorBirth;
    }

    public String getPrimaryContactorRole() {
        return primaryContactorRole;
    }

    public void setPrimaryContactorRole(String primaryContactorRole) {
        this.primaryContactorRole = primaryContactorRole;
    }

    public String getPrimaryContactorDepartment() {
        return primaryContactorDepartment;
    }

    public void setPrimaryContactorDepartment(String primaryContactorDepartment) {
        this.primaryContactorDepartment = primaryContactorDepartment;
    }

    public String getPrimaryContactorFixedPhone() {
        return primaryContactorFixedPhone;
    }

    public void setPrimaryContactorFixedPhone(String primaryContactorFixedPhone) {
        this.primaryContactorFixedPhone = primaryContactorFixedPhone;
    }

    public String getPrimaryContactorAddress() {
        return primaryContactorAddress;
    }

    public void setPrimaryContactorAddress(String primaryContactorAddress) {
        this.primaryContactorAddress = primaryContactorAddress;
    }

    public String getPrimaryContactorEmail() {
        return primaryContactorEmail;
    }

    public void setPrimaryContactorEmail(String primaryContactorEmail) {
        this.primaryContactorEmail = primaryContactorEmail;
    }

    public String getCusAddress() {
        return cusAddress;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }

    public Long getPrimaryContactorSex() {
        return primaryContactorSex;
    }

    public void setPrimaryContactorSex(Long primaryContactorSex) {
        this.primaryContactorSex = primaryContactorSex;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }
}