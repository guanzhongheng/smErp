package com.lcyzh.nmerp.model.vo;

/**
 * @Project :
 * @Description :补签查询vo
 * @Author :
 * @Iteration :
 * @Date :
 * @ModificationHistory Who          When          What
 */
public class StockQueryVo {
    //订单编号（模糊匹配）
    private String ordCode;
    //产品类别
    private Long itemCgyCode;
    //产品品种
    private Long itemVariety;
    //开始时间
    private String startDate;
    //结束时间
    private String endDate;

    public String getOrdCode() {
        return ordCode;
    }

    public void setOrdCode(String ordCode) {
        this.ordCode = ordCode;
    }

    public Long getItemCgyCode() {
        return itemCgyCode;
    }

    public void setItemCgyCode(Long itemCgyCode) {
        this.itemCgyCode = itemCgyCode;
    }

    public Long getItemVariety() {
        return itemVariety;
    }

    public void setItemVariety(Long itemVariety) {
        this.itemVariety = itemVariety;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
