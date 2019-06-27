package com.lcyzh.nmerp.model.vo;

/**
 * @Project : nm-erp
 * @Description : TODO
 * @Author : lijinku
 * @Iteration : 1.0
 * @Date : 2019/6/27  11:32 AM
 * @ModificationHistory Who          When          What
 * ----------   ------------- -----------------------------------
 * lijinku          2019/06/27    create
 */
public class OutStockDetailVo {
    private Long id;
    private String outCode;
    private String barCode;
    private Character qualityStatus;
    private String qualityUsCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOutCode() {
        return outCode;
    }

    public void setOutCode(String outCode) {
        this.outCode = outCode;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public Character getQualityStatus() {
        return qualityStatus;
    }

    public void setQualityStatus(Character qualityStatus) {
        this.qualityStatus = qualityStatus;
    }

    public String getQualityUsCode() {
        return qualityUsCode;
    }

    public void setQualityUsCode(String qualityUsCode) {
        this.qualityUsCode = qualityUsCode;
    }
}