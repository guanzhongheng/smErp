package com.lcyzh.nmerp.model.vo;

/**
 * @Project : nm-erp
 * @Description : TODO
 * @Author : lijinku
 * @Iteration : 1.0
 * @Date : 2019/7/1  6:09 PM
 * @ModificationHistory Who          When          What
 * ----------   ------------- -----------------------------------
 * lijinku          2019/07/01    create
 */
public class CustomerUpdateVo {

    //客户编号,多个客户编号用逗号隔开
    private String cusCodes;
    //备注
    private String remark;
    //员工编号
    private String empCode;

    public String getCusCodes() {
        return cusCodes;
    }

    public void setCusCodes(String cusCodes) {
        this.cusCodes = cusCodes;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

}