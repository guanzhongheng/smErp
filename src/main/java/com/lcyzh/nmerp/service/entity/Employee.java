package com.lcyzh.nmerp.service.entity;

import java.io.Serializable;
import java.util.Date;

/**
* Author ljk
* Date  2019-07-01
*/
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private String empCode;
    private String empName;
    private String birth;
    private Character empGrade;
    private String department;
    private String empPhone;
    private String empEmail;
    private String empAddress;
    private Date createTime;
    private Date updateTime;


    public Employee(){
    }

    public void setEmpCode (String empCode) {this.empCode = empCode;} 
    public String getEmpCode(){ return empCode;} 
    public void setEmpName (String empName) {this.empName = empName;} 
    public String getEmpName(){ return empName;} 
    public void setBirth (String birth) {this.birth = birth;} 
    public String getBirth(){ return birth;} 
    public void setEmpGrade (Character empGrade) {this.empGrade = empGrade;} 
    public Character getEmpGrade(){ return empGrade;} 
    public void setDepartment (String department) {this.department = department;} 
    public String getDepartment(){ return department;} 
    public void setEmpPhone (String empPhone) {this.empPhone = empPhone;} 
    public String getEmpPhone(){ return empPhone;} 
    public void setEmpEmail (String empEmail) {this.empEmail = empEmail;} 
    public String getEmpEmail(){ return empEmail;} 
    public void setEmpAddress (String empAddress) {this.empAddress = empAddress;} 
    public String getEmpAddress(){ return empAddress;} 
    public void setCreateTime (Date createTime) {this.createTime = createTime;} 
    public Date getCreateTime(){ return createTime;} 
    public void setUpdateTime (Date updateTime) {this.updateTime = updateTime;} 
    public Date getUpdateTime(){ return updateTime;} 

}