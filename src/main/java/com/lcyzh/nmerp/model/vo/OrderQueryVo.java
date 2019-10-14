package com.lcyzh.nmerp.model.vo;

import com.github.pagehelper.Page;
import com.lcyzh.nmerp.common.persistence.DataEntity;

import java.util.List;

/**
 * @Project : nm-erp
 * @Description :
 * @Author : lijinku
 * @Iteration : 1.0
 * @Date : 2019/7/2  10:03 AM
 * @ModificationHistory Who          When          What
 * ----------   ------------- -----------------------------------
 * lijinku          2019/07/02    create
 */
public class OrderQueryVo{
    //订单编号
    private String ordCode;
    //客户资料编号
    private String cusCode;
    //客户名称
    private String cusName;
    //上级名称
    private String proxyName;
    //订单标题
    private String ordTitle;
    //订单总金额
    private Double ordTotalAmount;
    //订单类型-字典
    private Long ordType;
    //订单类型值
    private String ordTypeValue;
    //订单签订日期
    private String ordSignDate;
    //订单状态-字典
    private Long ordStatus;
    //订单状态值
    private String ordStatusValue;
    //订单交付日期
    private String ordDeliveryDate;
    //付款方式-字典
    private Long payType;
    //付款方式值
    private String payTypeValue;
    //支付状态-字典
    private Long payStatus;
    //支付状态值
    private String payStatusValue;
    //已回款金额
    private Double repayAmount;
    //已开票金额
    private Double invoicedAmount;
    //逾期数
    private Integer overdueNum;
    //0-未跟进；1-正在跟进
    private Integer followType;
    //订单产品总数量
    private Long ordTotalNum;
    //订单产品总面积
    private Double ordTotalSq;
    //订单产品总重量
    private Double ordTotalWeight;
    //订单产品出库数量
    private Long ordOutNum;
    // 入库产品数量
    private Long totalNum = 0L;
    // 入库产品总价格
    private Double totalPrice = 0.0000;

    // 根据入库重量汇总价格
    private Double totalWtPrice = 0.0000;

    // 根据入库面积汇总价格
    private Double totalSqPrice = 0.0000;

    private String remarks;

    // 是否用于统计
    private Integer isTj;

    private Double orderPrice;

    private String startDate;

    private String endDate;

    // 订单状态判定 是否出库完成
    private String isOver;

    public String getIsOver() {
        return isOver;
    }

    public void setIsOver(String isOver) {
        this.isOver = isOver;
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

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getIsTj() {
        return isTj;
    }

    public void setIsTj(Integer isTj) {
        this.isTj = isTj;
    }

    public Double getTotalWtPrice() {
        return totalWtPrice;
    }

    public void setTotalWtPrice(Double totalWtPrice) {
        this.totalWtPrice = totalWtPrice;
    }

    public Double getTotalSqPrice() {
        return totalSqPrice;
    }

    public void setTotalSqPrice(Double totalSqPrice) {
        this.totalSqPrice = totalSqPrice;
    }

    //订单产品明细
    private List<OrderItemVo> orderItemVos;

    public Long getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Long totalNum) {
        this.totalNum = totalNum;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public OrderQueryVo(){
        super();
    }

    public String getOrdCode() {
        return ordCode;
    }

    public void setOrdCode(String ordCode) {
        this.ordCode = ordCode;
    }

    public String getCusCode() {
        return cusCode;
    }

    public void setCusCode(String cusCode) {
        this.cusCode = cusCode;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getProxyName() {
        return proxyName;
    }

    public void setProxyName(String proxyName) {
        this.proxyName = proxyName;
    }

    public String getOrdTitle() {
        return ordTitle;
    }

    public void setOrdTitle(String ordTitle) {
        this.ordTitle = ordTitle;
    }

    public Double getOrdTotalAmount() {
        return ordTotalAmount;
    }

    public void setOrdTotalAmount(Double ordTotalAmount) {
        this.ordTotalAmount = ordTotalAmount;
    }

    public Long getOrdType() {
        return ordType;
    }

    public void setOrdType(Long ordType) {
        this.ordType = ordType;
    }

    public String getOrdTypeValue() {
        return ordTypeValue;
    }

    public void setOrdTypeValue(String ordTypeValue) {
        this.ordTypeValue = ordTypeValue;
    }

    public String getOrdSignDate() {
        return ordSignDate;
    }

    public void setOrdSignDate(String ordSignDate) {
        this.ordSignDate = ordSignDate;
    }

    public Long getOrdStatus() {
        return ordStatus;
    }

    public void setOrdStatus(Long ordStatus) {
        this.ordStatus = ordStatus;
    }

    public String getOrdStatusValue() {
        return ordStatusValue;
    }

    public void setOrdStatusValue(String ordStatusValue) {
        this.ordStatusValue = ordStatusValue;
    }

    public String getOrdDeliveryDate() {
        return ordDeliveryDate;
    }

    public void setOrdDeliveryDate(String ordDeliveryDate) {
        this.ordDeliveryDate = ordDeliveryDate;
    }

    public Long getPayType() {
        return payType;
    }

    public void setPayType(Long payType) {
        this.payType = payType;
    }

    public String getPayTypeValue() {
        return payTypeValue;
    }

    public void setPayTypeValue(String payTypeValue) {
        this.payTypeValue = payTypeValue;
    }

    public Double getRepayAmount() {
        return repayAmount;
    }

    public void setRepayAmount(Double repayAmount) {
        this.repayAmount = repayAmount;
    }

    public Double getInvoicedAmount() {
        return invoicedAmount;
    }

    public void setInvoicedAmount(Double invoicedAmount) {
        this.invoicedAmount = invoicedAmount;
    }

    public Integer getOverdueNum() {
        return overdueNum;
    }

    public void setOverdueNum(Integer overdueNum) {
        this.overdueNum = overdueNum;
    }

    public Integer getFollowType() {
        return followType;
    }

    public void setFollowType(Integer followType) {
        this.followType = followType;
    }

    public Long getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Long payStatus) {
        this.payStatus = payStatus;
    }

    public String getPayStatusValue() {
        return payStatusValue;
    }

    public void setPayStatusValue(String payStatusValue) {
        this.payStatusValue = payStatusValue;
    }

    public Long getOrdTotalNum() {
        return ordTotalNum;
    }

    public void setOrdTotalNum(Long ordTotalNum) {
        this.ordTotalNum = ordTotalNum;
    }

    public Double getOrdTotalSq() {
        return ordTotalSq;
    }

    public void setOrdTotalSq(Double ordTotalSq) {
        this.ordTotalSq = ordTotalSq;
    }

    public Double getOrdTotalWeight() {
        return ordTotalWeight;
    }

    public void setOrdTotalWeight(Double ordTotalWeight) {
        this.ordTotalWeight = ordTotalWeight;
    }

    public Long getOrdOutNum() {
        return ordOutNum;
    }

    public void setOrdOutNum(Long ordOutNum) {
        this.ordOutNum = ordOutNum;
    }

    public List<OrderItemVo> getOrderItemVos() {
        return orderItemVos;
    }

    public void setOrderItemVos(List<OrderItemVo> orderItemVos) {
        this.orderItemVos = orderItemVos;
    }
}