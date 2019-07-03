package com.lcyzh.nmerp.model.vo;

/**
 * @Project : nm-erp
 * @Description : TODO
 * @Author : lijinku
 * @Iteration : 1.0
 * @Date : 2019/6/27  11:52 AM
 * @ModificationHistory Who          When          What
 * ----------   ------------- -----------------------------------
 * lijinku          2019/06/27    create
 */
public class OutStockVo {
    private String outCode;
    private String ordCode;
    private Long itemId;
    private String barCode;
    private String operEmpCode;
    private String remark;

    public String getOutCode() {
        return outCode;
    }

    public void setOutCode(String outCode) {
        this.outCode = outCode;
    }

    public String getOrdCode() {
        return ordCode;
    }

    public void setOrdCode(String ordCode) {
        this.ordCode = ordCode;
    }

    public String getBarCode() {
        return barCode;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getOperEmpCode() {
        return operEmpCode;
    }

    public void setOperEmpCode(String operEmpCode) {
        this.operEmpCode = operEmpCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}