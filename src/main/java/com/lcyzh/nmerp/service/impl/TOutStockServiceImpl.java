package com.lcyzh.nmerp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.constant.Constants;
import com.lcyzh.nmerp.controller.system.util.UserUtils;
import com.lcyzh.nmerp.dao.*;
import com.lcyzh.nmerp.entity.TOutStock;
import com.lcyzh.nmerp.entity.TOutStockDetail;
import com.lcyzh.nmerp.entity.sys.User;
import com.lcyzh.nmerp.model.vo.*;
import com.lcyzh.nmerp.service.TOutStockService;
import com.lcyzh.nmerp.utils.DictUtils;
import com.lcyzh.nmerp.utils.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Author ljk
 * Date  2019-06-06
 */
@Service
public class TOutStockServiceImpl implements TOutStockService {
    @Autowired
    private TOutStockMapper tOutStockMapper;
    @Autowired
    private TStockMapper tStockMapper;
    @Autowired
    private TOutStockDetailMapper tOutStockDetailMapper;

    @Override
    public TOutStock findByCode(String outCode) {
        return tOutStockMapper.findByOutCode(outCode);
    }

    @Override
    public List<StockVo> findOutItemsByOutCode(String outCode) {
        return tStockMapper.findOutItemsByOutCode(outCode);
    }

    @Override
    public Page<OutStockVo> findList(Page<OutStockVo> page, OutStockVo vo) {
        PageHelper.startPage(page.getPageNo(), page.getPageSize());
        if (vo.getStartDate() == null || vo.getStartDate().length() == 0) {
            vo.setStartDate(LocalDate.now().minusDays(7).toString());
        }
        if (vo.getEndDate() == null || vo.getEndDate().length() == 0) {
            vo.setEndDate(LocalDate.now().plusDays(1).toString());
        }
        List<TOutStock> list = tOutStockMapper.findList(vo);
        List<OutStockVo> vos = list.stream().map(tOutStock -> {
            OutStockVo outStockVo = new OutStockVo();
            BeanUtils.copyProperties(tOutStock, outStockVo);
            return outStockVo;
        }).collect(Collectors.toList());

        PageInfo<TOutStock> p = new PageInfo<>(list);
        page.setCount(p.getTotal());

        page.setList(vos);
        return page;
    }

    //@Override
    //public List<TOutStock> findList(TOutStock tOutStock) {
    //    return tOutStockMapper.findList(tOutStock);
    //}

    @Override
    public String createAndReturnOutCode(String createBy, String remark) {
        TOutStock tOutStock = new TOutStock();
        String outCode = StringUtils.genFixPreFixStr(Constants.OUT_STORE_PRE_FIX);
        tOutStock.setOutCode(outCode);
        tOutStock.setOutStatus('0');
        tOutStock.setCreateTime(new Date());
        tOutStock.setCreateBy(createBy);
        tOutStockMapper.insert(tOutStock);
        return outCode;
    }

    @Override
    public StockVo findByBarCode(String barCode) {
        StockVo vo = tStockMapper.findByBarCode(barCode);
        vo.setItemCgyCodeValue(DictUtils.getValueByDictKey(vo.getItemCgyCode()));
        vo.setItemUnitValue(DictUtils.getValueByDictKey(vo.getItemUnit()));
        vo.setItemVarietyValue(DictUtils.getValueByDictKey(vo.getItemVariety()));
        return vo;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    @Override
    public Integer doOutStock(TOutStock tOutStock) {
        Date date = new Date();
        User currUser = UserUtils.getUser();
        //已审批，出库
        tOutStock.setOutStatus('1');
        tOutStock.setUpdateTime(date);
        tOutStock.setUpdateBy(currUser.getLoginName());
        tOutStockMapper.update(tOutStock);
        Map<String, Object> map = new HashMap<>();
        map.put("status", 1);
        map.put("updateTime", date);
        map.put("outCode", tOutStock.getOutCode());
        return tStockMapper.updateByOutCode(map);
    }

    @Override
    public int addOutStockDetail(TOutStockDetail tOutStockDetail) {
        List<TOutStockDetail> list = tOutStockDetailMapper.findList(tOutStockDetail);
        if (!list.isEmpty()) {
            //该产品已经添加出库单
            return 2;
        }
        return tOutStockDetailMapper.insert(tOutStockDetail);
    }

    @Override
    public int delete(String outCode) {
        tOutStockDetailMapper.deleteByOutCode(outCode);
        return tOutStockMapper.delete(outCode);
    }

    @Override
    public int deleteDetail(String barCode) {
        return tOutStockDetailMapper.deleteByBarCode(barCode);


    }
    @Override
    public List<StockRecordVo> getOutStockList(String outCode) {
        OutStockVo vo = new OutStockVo();
        vo.setOutCode(outCode);
        return tOutStockMapper.getOutStockList(vo);
    }
}