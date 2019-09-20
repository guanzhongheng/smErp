package com.lcyzh.nmerp.model.vo;

/**
 * @Project : nm-erp
 * @Description : 生产计划导出条件对象
 * @Author : wsm
 * @Iteration : 1.0
 * @Date : 2019/9/8  2:15 AM
 * @ModificationHistory Who          When          What
 * ----------   ------------- -----------------------------------
 * wsm          2019/09/08    create
 */
public class ProdPlanExportVo {
    private Long prodVariety;
    private Long prodCgyCode;
    private String prodColor;
    private String cusCode;
    private Double widthMin;
    private Double widthMax;
    private String startDate;
    private String endDate;

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

    public String getCusCode() {
        return cusCode;
    }

    public void setCusCode(String cusCode) {
        this.cusCode = cusCode;
    }

    public Double getWidthMin() {
        return widthMin;
    }

    public void setWidthMin(Double widthMin) {
        this.widthMin = widthMin;
    }

    public Double getWidthMax() {
        return widthMax;
    }

    public void setWidthMax(Double widthMax) {
        this.widthMax = widthMax;
    }

    public Long getProdVariety() {
        return prodVariety;
    }

    public void setProdVariety(Long prodVariety) {
        this.prodVariety = prodVariety;
    }

    public Long getProdCgyCode() {
        return prodCgyCode;
    }

    public void setProdCgyCode(Long prodCgyCode) {
        this.prodCgyCode = prodCgyCode;
    }

    public String getProdColor() {
        return prodColor;
    }

    public void setProdColor(String prodColor) {
        this.prodColor = prodColor;
    }
}
