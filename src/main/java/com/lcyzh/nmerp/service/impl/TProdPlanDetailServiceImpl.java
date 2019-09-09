package com.lcyzh.nmerp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.constant.Constants;
import com.lcyzh.nmerp.dao.*;
import com.lcyzh.nmerp.entity.*;
import com.lcyzh.nmerp.model.vo.ProdPlanDetailVo;
import com.lcyzh.nmerp.service.TProdPlanDetailService;
import com.lcyzh.nmerp.utils.IdGen;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
@Service
public class TProdPlanDetailServiceImpl implements TProdPlanDetailService{
    @Autowired
    private TProdPlanDetailMapper tProdPlanDetailMapper;
    @Autowired
    private TStockMapper tStockMapper;
    @Autowired
    private THistoryProdRecordMapper tHistoryProdRecordMapper;
    @Autowired
    private TProdPlanMapper tProdPlanMapper;
    @Autowired
    private TOrderItemMapper tOrderItemMapper;
    @Autowired
    private TOrderMapper tOrderMapper;

    @Override
    public List<TProdPlanDetail> findListByProdPlanCode(String prodPlanCode) {
        return tProdPlanDetailMapper.findListByProdPlanCode(prodPlanCode);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    @Override
    public int updateByIds(String id,Double thresholdUp,Double thresholdDown) {
        if(id!=null && id.length() != 0) {
            List<String> ids = Arrays.asList(id.trim().split(","));
            List<TProdPlanDetail> list = tProdPlanDetailMapper.findByIds(ids);
            TProdPlan tProdPlan = tProdPlanMapper.findByProdPanCode(list.get(0).getProdPlanCode());
            long quantity = 0;
            for(TProdPlanDetail ppd : list) {
                quantity += ppd.getItemNum();
            }
            tProdPlan.setQuantity(quantity);
            tProdPlan.setTotalQuantity(0L);
            tProdPlanMapper.updateAddNum(tProdPlan);
            return tProdPlanDetailMapper.updateByIds(ids,thresholdUp,thresholdDown);
        }else{
            return -1;
        }
    }

    @Override
    public List<ProdPlanDetailVo> findProdTaskPage(Page<ProdPlanDetailVo> page, ProdPlanDetailVo vo) {
        PageHelper.startPage(page.getPageNo(),page.getPageSize());
        //查询已经下发生产的
        vo.setItemStatus('1');
        List<ProdPlanDetailVo> list = tProdPlanDetailMapper.findList(vo);
        PageInfo<ProdPlanDetailVo> pageInfo = new PageInfo<>(list);
        page.setTotal(pageInfo.getTotal());
        return list;
    }

    @Override
    public ProdPlanDetailVo findProdTask(ProdPlanDetailVo vo) {
        if(vo.getProdPlanDetailId() != null) {
            return tProdPlanDetailMapper.findList(vo).get(0);
        }
        return null;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    @Override
    public ProdPlanDetailVo labelAndInStock(ProdPlanDetailVo vo) {
        Date date = new Date();
        //生成条形码字符串
        String barCode = getBarCode(IdGen.getNetBarCode(11));
        vo.setBarCode(barCode);
        vo.setItemNum(vo.getItemNum() - 1);
        TOrderItem tOrderItem = tOrderItemMapper.get(vo.getOrderItemId());
        if(vo.getItemNum() > 0) {
            //该商品还没有生产完，更新计划单明细件数
            TProdPlanDetail prodPlanDetail = new TProdPlanDetail();
            BeanUtils.copyProperties(vo, prodPlanDetail);
            prodPlanDetail.setId(vo.getProdPlanDetailId());
            tProdPlanDetailMapper.update(prodPlanDetail);
            if(!Constants.ORD_PROD_STATUS_PROCESSING.equals(tOrderItem.getItemStatus())) {
                tOrderItem.setItemStatus(Constants.ORD_PROD_STATUS_PROCESSING);
                tOrderItemMapper.update(tOrderItem);
            }
        }else if(vo.getItemNum() == 0){
            //该商品生产完，更新计划单，将明细单该记录移到生产记录表
            THistoryProdRecord historyProdRecord = new THistoryProdRecord();
            BeanUtils.copyProperties(vo, historyProdRecord);
            historyProdRecord.setItemNum(tOrderItem.getItemNum());
            historyProdRecord.setCreateTime(date);
            tOrderItem.setItemStatus(Constants.ORD_PROD_STATUS_END);
            tOrderItemMapper.update(tOrderItem);
            tHistoryProdRecordMapper.insert(historyProdRecord);
            tProdPlanDetailMapper.delete(vo.getProdPlanDetailId());
        }
        //更新计划单产品总数量与下发生产数量
        TProdPlan prodPlan = new TProdPlan();
        prodPlan.setProdPlanCode(vo.getProdPlanCode());
        prodPlan.setTotalQuantity(1L);
        prodPlan.setQuantity(1L);
        tProdPlanMapper.updateNum(prodPlan);
        //入库
        TStock tStock = new TStock();
        BeanUtils.copyProperties(vo, tStock);
        tStock.setCreateTime(date);
        tStock.setStatus('0');
        if(vo.getItemSq() == null || vo.getItemSq().length() == 0) {
            tStock.setItemSq(vo.getItemLenth() * vo.getItemWidth());
        }
        tStockMapper.insert(tStock);

        vo.setCreateTime(date);
        return vo;
    }
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    @Override
    public boolean cancelProdPlanDetailByID(Long id) {
        TProdPlanDetail ppd = tProdPlanDetailMapper.findById(id);
        //删除生产计划明细
        tProdPlanDetailMapper.delete(id);
        //更新生产计划
        TProdPlan prodPlan = new TProdPlan();
        prodPlan.setProdPlanCode(ppd.getProdPlanCode());
        prodPlan.setTotalQuantity(ppd.getItemNum());
        prodPlan.setQuantity(ppd.getItemNum());
        tProdPlanMapper.updateNum(prodPlan);
        if(ppd.getItemStatus().equals('0')) {
            // 未下发生产产品撤销
            //删除订单明细
            tOrderItemMapper.deleteById(ppd.getOrderItemId());
            // 更新订单数量
            TOrder order = new TOrder();
            order.setOrdCode(ppd.getOrdCode());
            order.setOrdTotalNum(ppd.getItemNum());
            tOrderMapper.updateOrderNum(order);
        }else if(ppd.getItemStatus().equals('1')){
            //已发下生产产品撤销(为生产完成)
            //更新订单明细
            TOrderItem orderItem = new TOrderItem();
            orderItem.setId(ppd.getOrderItemId());
            orderItem.setItemNum(ppd.getItemNum());
            tOrderItemMapper.updateNum(orderItem);
            // 更新订单数量
            TOrder order = new TOrder();
            order.setOrdCode(ppd.getOrdCode());
            order.setOrdTotalNum(ppd.getItemNum());
            tOrderMapper.updateOrderNum(order);
        }
        return true;
    }

    public String getBarCode(String barCode){
        List<TStock> list = tStockMapper.getByBarCode(barCode);
        if(!list.isEmpty()) {
            barCode = getBarCode(IdGen.getNetBarCode(11));
        }
        return barCode;
    }


    //@Override
    //public List<TProdPlanDetail> findList(TProdPlanDetail tProdPlanDetail) {
    //    return tProdPlanDetailMapper.findList(tProdPlanDetail);
    //}
    //
    //@Override
    //public int insert(TProdPlanDetail tProdPlanDetail) {
    //    return tProdPlanDetailMapper.insert(tProdPlanDetail);
    //}
    //
    //@Override
    //public int insertBatch(List<TProdPlanDetail> tProdPlanDetails){
    //    return tProdPlanDetailMapper.insertBatch(tProdPlanDetails);
    //}
    //
    //@Override
    //public int update(TProdPlanDetail tProdPlanDetail) {
    //    return tProdPlanDetailMapper.update(tProdPlanDetail);
    //}

}
