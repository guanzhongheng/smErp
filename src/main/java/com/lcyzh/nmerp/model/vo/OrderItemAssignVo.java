package com.lcyzh.nmerp.model.vo;

/**
 * @Project : nm-erp
 * @Description : TODO
 * @Author : lijinku
 * @Iteration : 1.0
 * @Date : 2019/6/27  9:42 PM
 * @ModificationHistory Who          When          What
 * ----------   ------------- -----------------------------------
 * lijinku          2019/06/27    create
 */
public class OrderItemAssignVo {
    private Long ordItemId;
    private String macCode;
    private Double itemNum;
    private String itemUnit;

    public Long getOrdItemId() {
        return ordItemId;
    }

    public void setOrdItemId(Long ordItemId) {
        this.ordItemId = ordItemId;
    }

    public String getMacCode() {
        return macCode;
    }

    public void setMacCode(String macCode) {
        this.macCode = macCode;
    }

    public Double getItemNum() {
        return itemNum;
    }

    public void setItemNum(Double itemNum) {
        this.itemNum = itemNum;
    }

    public String getItemUnit() {
        return itemUnit;
    }

    public void setItemUnit(String itemUnit) {
        this.itemUnit = itemUnit;
    }
}