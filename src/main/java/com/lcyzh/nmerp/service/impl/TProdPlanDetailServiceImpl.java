package com.lcyzh.nmerp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lcyzh.nmerp.common.persistence.Page;
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

    @Override
    public List<TProdPlanDetail> findListByProdPlanCode(String prodPlanCode) {
        return tProdPlanDetailMapper.findListByProdPlanCode(prodPlanCode);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    @Override
    public int updateByIds(String id) {
        if(id!=null && id.length() != 0) {
            List<String> ids = Arrays.asList(id.trim().split(","));
            TProdPlanDetail tProdPlanDetail = tProdPlanDetailMapper.findById(Long.valueOf(ids.get(0)));
            TProdPlan tProdPlan = tProdPlanMapper.findByProdPanCode(tProdPlanDetail.getProdPlanCode());
            tProdPlan.setQuantity(Long.valueOf(ids.size()));
            tProdPlan.setTotalQuantity(0L);
            tProdPlanMapper.updateAddNum(tProdPlan);
            return tProdPlanDetailMapper.updateByIds(ids);
        }else{
            return -1;
        }
    }

    @Override
    public Page<ProdPlanDetailVo> findProdTaskPage(Page<ProdPlanDetailVo> page, ProdPlanDetailVo vo) {
        PageHelper.startPage(page.getPageNo(),page.getPageSize());
        //查询已经下发生产的
        vo.setItemStatus('1');
        List<ProdPlanDetailVo> list = tProdPlanDetailMapper.findList(vo);



        PageInfo<ProdPlanDetailVo> p = new PageInfo<>(list);
        page.setCount(p.getTotal());


        page.setList(list);
        return page;
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
        String barCode = getBarCode(IdGen.getNetBarCode());
        vo.setBarCode(barCode);
        vo.setItemNum(vo.getItemNum() - 1);
        if(vo.getItemNum() > 0) {
            //该商品还没有生产完，更新计划单明细件数
            TProdPlanDetail prodPlanDetail = new TProdPlanDetail();
            BeanUtils.copyProperties(vo, prodPlanDetail);
            tProdPlanDetailMapper.update(prodPlanDetail);
        }else if(vo.getItemNum() == 0){
            //该商品生产完，更新计划单，将明细单该记录移到生产记录表
            THistoryProdRecord historyProdRecord = new THistoryProdRecord();
            BeanUtils.copyProperties(vo, historyProdRecord);
            TOrderItem tOrderItem = tOrderItemMapper.get(historyProdRecord.getOrderItemId());
            historyProdRecord.setItemNum(tOrderItem.getItemNum());
            historyProdRecord.setCreateTime(date);
            TProdPlan prodPlan = new TProdPlan();
            prodPlan.setProdPlanCode(vo.getProdPlanCode());
            prodPlan.setTotalQuantity(1L);
            prodPlan.setQuantity(1L);
            tHistoryProdRecordMapper.insert(historyProdRecord);
            tProdPlanMapper.updateNum(prodPlan);
            tProdPlanDetailMapper.deleteByCode(vo.getProdPlanCode());
        }
        //入库
        TStock tStock = new TStock();
        BeanUtils.copyProperties(vo, tStock);
        tStock.setCreateTime(date);
        tStock.setStatus('0');
        if(vo.getItemSq() == null || vo.getItemSq().length() == 0) {
            tStock.setItemSq(vo.getItemLenth() * vo.getItemWidth());
        }
        tStockMapper.insert(tStock);
        return vo;
    }

    public String getBarCode(String barCode){
        List<TStock> list = tStockMapper.getByBarCode(barCode);
        if(!list.isEmpty()) {
            barCode = getBarCode(IdGen.getNetBarCode());
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
