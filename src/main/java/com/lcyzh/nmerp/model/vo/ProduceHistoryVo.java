package com.lcyzh.nmerp.model.vo;

/**
 * 项目名称：nm-erp
 * 类 名 称：ProduceHistoryVo
 * 类 描 述：产品历史追踪信息类
 * 创建时间：2019/12/6 11:52 AM
 * 创 建 人：guan
 */
public class ProduceHistoryVo extends StockVo{

    private String proxyName;

    private String ordCreateBy;

    private String ordUpdateBy;

    private String ordApprovalBy;

    private String seCode;

    private String stockCreateBy;

    private String stockUpdateBy;

    private String status;

    private String itemPrice;

    private String remarks;

    private String itemPriceType;

    private String formula;

    private String carNo;

    private String receiver;

    private String phone;

    public String getProxyName() {
        return proxyName;
    }

    public void setProxyName(String proxyName) {
        this.proxyName = proxyName;
    }

    public String getOrdCreateBy() {
        return ordCreateBy;
    }

    public void setOrdCreateBy(String ordCreateBy) {
        this.ordCreateBy = ordCreateBy;
    }

    public String getOrdUpdateBy() {
        return ordUpdateBy;
    }

    public void setOrdUpdateBy(String ordUpdateBy) {
        this.ordUpdateBy = ordUpdateBy;
    }

    public String getOrdApprovalBy() {
        return ordApprovalBy;
    }

    public void setOrdApprovalBy(String ordApprovalBy) {
        this.ordApprovalBy = ordApprovalBy;
    }

    public String getSeCode() {
        return seCode;
    }

    public void setSeCode(String seCode) {
        this.seCode = seCode;
    }


    public String getStockCreateBy() {
        return stockCreateBy;
    }

    public void setStockCreateBy(String stockCreateBy) {
        this.stockCreateBy = stockCreateBy;
    }

    public String getStockUpdateBy() {
        return stockUpdateBy;
    }

    public void setStockUpdateBy(String stockUpdateBy) {
        this.stockUpdateBy = stockUpdateBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getItemPriceType() {
        return itemPriceType;
    }

    public void setItemPriceType(String itemPriceType) {
        this.itemPriceType = itemPriceType;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
