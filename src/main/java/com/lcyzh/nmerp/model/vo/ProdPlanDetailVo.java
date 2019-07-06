package com.lcyzh.nmerp.model.vo;

import com.lcyzh.nmerp.common.persistence.DataEntity;

/**
 * @Project : nm-erp
 * @Description : TODO
 * @Author : lijinku
 * @Iteration : 1.0
 * @Date : 2019/7/6  4:24 PM
 * @ModificationHistory Who          When          What
 * ----------   ------------- -----------------------------------
 * lijinku          2019/07/06    create
 */
public class ProdPlanDetailVo extends DataEntity<ProdPlanDetailVo> {
    //'订单编号'
    private String ordCode;
    //'订单标题'
    private String ordTitle;
    //'产品编号'
    private String itemCode;
    //产品名称
    private String itemName;
    //产品规格
    private Long itemSpec;
    //'产品数量'
    private Double itemNum;
    //产品已分配数量
    private Double itemAssignNum;
    //'产品单位'
    private Long itemUnit;

    public String getOrdCode() {
        return ordCode;
    }

    public void setOrdCode(String ordCode) {
        this.ordCode = ordCode;
    }

    public String getOrdTitle() {
        return ordTitle;
    }

    public void setOrdTitle(String ordTitle) {
        this.ordTitle = ordTitle;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Long getItemSpec() {
        return itemSpec;
    }

    public void setItemSpec(Long itemSpec) {
        this.itemSpec = itemSpec;
    }

    public Double getItemNum() {
        return itemNum;
    }

    public void setItemNum(Double itemNum) {
        this.itemNum = itemNum;
    }

    public Double getItemAssignNum() {
        return itemAssignNum;
    }

    public void setItemAssignNum(Double itemAssignNum) {
        this.itemAssignNum = itemAssignNum;
    }

    public Long getItemUnit() {
        return itemUnit;
    }

    public void setItemUnit(Long itemUnit) {
        this.itemUnit = itemUnit;
    }
}