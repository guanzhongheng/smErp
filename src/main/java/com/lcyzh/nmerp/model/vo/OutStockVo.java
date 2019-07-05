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
    //出库编号
    private String outCode;
    //订单编号
    private String ordCode;
    //商品id
    private Long itemId;
    //条形码
    private String barCode;
    //操作员工编号
    private String operEmpCode;
    //出库状态:0-新建；1-出库审核；2-出库完成
    private Character status;
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

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}