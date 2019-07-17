package com.lcyzh.nmerp.model.vo;

import com.lcyzh.nmerp.common.persistence.DataEntity;

/**
 * 项目名称：nm-erp
 * 类 名 称：ProdHistroyVo
 * 类 描 述：TODO
 * 创建时间：2019/7/15 7:26 PM
 * 创 建 人：guan
 */
public class ProdHistroyVo extends DataEntity<ProdHistroyVo> {

    private String ordCode;

    private String prodName;

    private String startDate;

    private String endDate;

    //类别
    private Long prodCgyCode;

    //品种、性质
    private Long prodVariety;

    private String itemColor;

    private String workbench;

    private String createTime;

    private Long itemNum;

    public String getOrdCode() {
        return ordCode;
    }

    public void setOrdCode(String ordCode) {
        this.ordCode = ordCode;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
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

    public Long getProdCgyCode() {
        return prodCgyCode;
    }

    public void setProdCgyCode(Long prodCgyCode) {
        this.prodCgyCode = prodCgyCode;
    }

    public Long getProdVariety() {
        return prodVariety;
    }

    public void setProdVariety(Long prodVariety) {
        this.prodVariety = prodVariety;
    }

    public String getItemColor() {
        return itemColor;
    }

    public void setItemColor(String itemColor) {
        this.itemColor = itemColor;
    }

    public String getWorkbench() {
        return workbench;
    }

    public void setWorkbench(String workbench) {
        this.workbench = workbench;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Long getItemNum() {
        return itemNum;
    }

    public void setItemNum(Long itemNum) {
        this.itemNum = itemNum;
    }
}
