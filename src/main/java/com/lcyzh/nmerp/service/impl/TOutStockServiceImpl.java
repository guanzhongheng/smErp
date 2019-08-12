package com.lcyzh.nmerp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.constant.Constants;
import com.lcyzh.nmerp.controller.system.util.SysDictUtils;
import com.lcyzh.nmerp.controller.system.util.UserUtils;
import com.lcyzh.nmerp.dao.*;
import com.lcyzh.nmerp.entity.*;
import com.lcyzh.nmerp.entity.sys.User;
import com.lcyzh.nmerp.model.vo.*;
import com.lcyzh.nmerp.service.TOutStockService;
import com.lcyzh.nmerp.utils.DictUtils;
import com.lcyzh.nmerp.utils.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
    @Autowired
    private TOrderMapper tOrderMapper;

    @Override
    public List<TOutStock> findListNew() {
        return tOutStockMapper.findListNew();
    }

    @Override
    public int updateStatus(String outCode, Character status) {
        Map<String, Object> map = new HashMap<>();
        map.put("outCode", outCode);
        map.put("outStatus", status);
        return tOutStockMapper.updateStatus(map);
    }

    @Override
    public TOutStock findByCode(String outCode) {
        return tOutStockMapper.findByOutCode(outCode);
    }

    @Override
    public List<OutStockDetailVo> findOutItemsByOutCode(String outCode) {
        List<OutStockDetailVo> vos = tOutStockDetailMapper.findOutItemsByOutCode(outCode);
        vos.forEach(vo ->{
            vo.setItemCgyCodeValue(DictUtils.getValueByDictKey(vo.getItemCgyCode()));
            vo.setItemVarietyValue(DictUtils.getValueByDictKey(vo.getItemVariety()));
            vo.setItemColorValue(SysDictUtils.getDictLabel(vo.getItemColor(), Constants.PROD_COLOR, ""));
            vo.setItemYbTypeValue(SysDictUtils.getDictLabel(vo.getItemYbType(), Constants.PROD_YB_TYPE, ""));
            vo.setItemYcTypeValue(SysDictUtils.getDictLabel(vo.getItemYcType(), Constants.PROD_YC_TYPE, ""));
        });
        return vos;
    }

    @Override
    public List<OutStockVo> findList(Page<OutStockVo> page, OutStockVo vo) {
        if (vo.getStartDate() == null || vo.getStartDate().length() == 0) {
            vo.setStartDate(LocalDate.now().minusDays(7).toString());
        }
        if (vo.getEndDate() == null || vo.getEndDate().length() == 0) {
            vo.setEndDate(LocalDate.now().plusDays(1).toString());
        }
        PageHelper.startPage(page.getPageNo(), page.getPageSize());
        List<TOutStock> list = tOutStockMapper.findList(vo);
        List<OutStockVo> vos = list.stream().map(tOutStock -> {
            OutStockVo outStockVo = new OutStockVo();
            BeanUtils.copyProperties(tOutStock, outStockVo);
            return outStockVo;
        }).collect(Collectors.toList());
        PageInfo<TOutStock> pageInfo = new PageInfo<>(list);
        page.setTotal(pageInfo.getTotal());
        return vos;
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
    public OutStockDetailVo findByBarCode(String barCode) {
        OutStockDetailVo outStockDetailVo = new OutStockDetailVo();
        StockVo vo = tStockMapper.findByBarCode(barCode);
        vo.setItemCgyCodeValue(DictUtils.getValueByDictKey(vo.getItemCgyCode()));
        vo.setItemUnitValue(DictUtils.getValueByDictKey(vo.getItemUnit()));
        vo.setItemVarietyValue(DictUtils.getValueByDictKey(vo.getItemVariety()));
        BeanUtils.copyProperties(vo, outStockDetailVo);
        List<TOutStockDetail> list = tOutStockDetailMapper.findByBarCode(barCode);
        if (!list.isEmpty()) {
            outStockDetailVo.setIsOut('1');
        } else {
            outStockDetailVo.setIsOut('0');
        }
        outStockDetailVo.setItemColorValue(SysDictUtils.getDictLabel(outStockDetailVo.getItemColor(), Constants.PROD_COLOR, ""));
        outStockDetailVo.setItemYbTypeValue(SysDictUtils.getDictLabel(outStockDetailVo.getItemYbType(), Constants.PROD_YB_TYPE, ""));
        outStockDetailVo.setItemYcTypeValue(SysDictUtils.getDictLabel(outStockDetailVo.getItemYcType(), Constants.PROD_YC_TYPE, ""));
        return outStockDetailVo;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    @Override
    public Integer doOutStock(TOutStock tOutStock) {
        Date date = new Date();
        User currUser = UserUtils.getUser();
        //已审批，出库
        tOutStock.setOutStatus('2');
        tOutStock.setUpdateTime(date);
        tOutStock.setUpdateBy(currUser.getLoginName());
        tOutStockMapper.update(tOutStock);
        //更新订单出库数量
        List<TStock> list = tStockMapper.findByOutCode(tOutStock.getOutCode());
        Map<String, Long> ordMap = new HashMap<>(list.size());
        String ordCode;
        for (TStock tStock : list) {
            ordCode = tStock.getOrdCode();
            if (ordMap.containsKey(ordCode)) {
                ordMap.put(ordCode, ordMap.get(ordCode) + 1);
            } else {
                ordMap.put(ordCode, 1L);
            }
        }
        List<TOrder> orders = new ArrayList<>(ordMap.size());
        for (Map.Entry<String, Long> entry : ordMap.entrySet()) {
            TOrder order = new TOrder();
            order.setOrdCode(entry.getKey());
            order.setOrdOutNum(entry.getValue());
            orders.add(order);
        }
        tOrderMapper.updateBatchOutNumByOrdCode(orders);
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

    @Override
    public List<OutItemVo> findItemByOutCode(String outCode) {
        List<TStock> list = tStockMapper.findByOutCode(outCode);
        // TODO 异常处理 临时
        try {
            if (list != null && !list.isEmpty()) {
                List<OutItemVo> itemVos = list.stream().map(sto -> {
                    OutItemVo outItemVo = new OutItemVo();
                    outItemVo.setItemOwner(sto.getItemOwner());
                    outItemVo.setItemLenth(sto.getItemLenth());
                    outItemVo.setItemWidth(sto.getItemWidth());
                    outItemVo.setItemThick(sto.getItemThick());
                    TProduct prodduct = DictUtils.getProdCodeByProdCgyAndVari(sto.getItemVariety() + sto.getItemCgyCode().toString() + sto.getItemColor());
                    outItemVo.setItemName(prodduct.getProdName());
                    outItemVo.setProdColorValue(SysDictUtils.getDictLabel(sto.getItemColor(), "prod_color", ""));
                    outItemVo.setProdCgyCodeValue(DictUtils.getValueByDictKey(sto.getItemCgyCode()));
                    outItemVo.setProdVarietyValue(DictUtils.getValueByDictKey(sto.getItemVariety()));
                    outItemVo.setOrdCode(sto.getOrdCode());
                    return outItemVo;
                }).collect(Collectors.toList());
                return itemVos;
            }
        }catch (Exception e){
            return null;
        }

        return null;
    }
}