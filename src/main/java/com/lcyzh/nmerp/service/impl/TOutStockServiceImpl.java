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
import com.lcyzh.nmerp.utils.Arith;
import com.lcyzh.nmerp.utils.DictUtils;
import com.lcyzh.nmerp.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Author ljk
 * Date  2019-06-06
 */
@Slf4j
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
    @Autowired
    private TProductMapper productMapper;

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
    public String createOutCodeForApp(String cusCode,String cusName, String carNo, String applyUserId) {
        // 校验当前车牌号+关联用户是否存在 如果存在则不能创建出库单
        int num = tOutStockMapper.checkInfo(cusCode,carNo);
        if(num > 0){
            return "-1";
        }
        TOutStock tOutStock = new TOutStock();
        String outCode = StringUtils.genFixPreFixStr(Constants.OUT_STORE_PRE_FIX);
        tOutStock.setOutCode(outCode);
        tOutStock.setCusName(cusName);
        tOutStock.setCusCode(cusCode);
        tOutStock.setCarNo(carNo);
        tOutStock.setOutStatus('0');
        tOutStock.setCreateTime(new Date());
        tOutStock.setCreateBy(applyUserId);
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

        OrderQueryVo order = tOrderMapper.findByPrimaryKey(vo.getOrdCode());
        outStockDetailVo.setCusCode(order.getCusCode());

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
        if(tOutStock == null || tOutStock.getOutCode() == null) {
            log.error("出库参数不能为空！");
            return -1;
        }
        TOutStock outStock = tOutStockMapper.findByOutCode(tOutStock.getOutCode());
        if(outStock.getOutStatus().equals('2')) {
            log.info("该出库单已经出库！");
            return -2;
        }
        Date date = new Date();
        User currUser = UserUtils.getUser();
        //已审批，出库
        tOutStock.setOutStatus('2');
        tOutStock.setUpdateTime(date);
        tOutStock.setUpdateBy(currUser.getLoginName());
        tOutStockMapper.update(tOutStock);
        //更新订单出库数量 + 增加订单状态判定
        List<TStock> list = tStockMapper.findByOutCode(tOutStock.getOutCode());

        List<CommonVo> stList = tOutStockMapper.checkOrderStatus(tOutStock.getOutCode());
        Map<String,Integer> stMap = new HashMap<>();
        if(!CollectionUtils.isEmpty(stList)){
            for(CommonVo c : stList){
                if (stMap.containsKey(c.getCode())) {
                    stMap.put(c.getCode(), stMap.get(c.getCode()) + c.getNum());
                } else {
                    stMap.put(c.getCode(), c.getNum());
                }
            }
        }

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
            // 出库的数量等于订单剩余未出库数量 则更新订单状态
            if(stMap.get(entry.getKey()) != null && (stMap.get(entry.getKey())-entry.getValue()) == 0L){
                order.setOrdStatus(100005L); //标记订单完成
            }
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
    public int doOutStockDetailNew(String barCode, String carNo) {
        Map<String, Object> map = new HashMap<>(8);
        map.put("barCode", barCode);
        map.put("carNo", carNo);
        TOutStock outStock = tOutStockMapper.isOutStockExist(map);
        if(outStock != null) {
            map.put("outCode", outStock.getOutCode());
            TOutStockDetail outStockDetail = tOutStockDetailMapper.findOne(map);
            if(outStockDetail != null) {
                return 0;
            }else{
                outStockDetail = new TOutStockDetail();
                outStockDetail.setBarCode(barCode);
                outStockDetail.setOutCode(outStock.getOutCode());
                return tOutStockDetailMapper.insert(outStockDetail);
            }
        }else{
            return -1;
        }
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
                    TProduct prodduct = DictUtils.getProdCodeByProdCgyAndVari(sto.getItemCgyCode().toString() + sto.getItemVariety() + sto.getItemColor() + sto.getItemThick() + sto.getItemPriceType());
                    if(prodduct == null){
                        prodduct = reloadProdAndGetProd(sto);
                    }
                    outItemVo.setItemName(prodduct.getProdName());
                    outItemVo.setProdColorValue(SysDictUtils.getDictLabel(sto.getItemColor(), "prod_color", ""));
                    outItemVo.setProdCgyCodeValue(DictUtils.getValueByDictKey(sto.getItemCgyCode()));
                    outItemVo.setProdVarietyValue(DictUtils.getValueByDictKey(sto.getItemVariety()));
                    Double weight = Arith.sub(sto.getItemWeight(),sto.getItemTareWeight()); // 获取产品净重信息
                    outItemVo.setItemWeight(weight);
                    outItemVo.setOrdCode(sto.getOrdCode());
                    outItemVo.setItemPriceType(sto.getItemPriceType());
                    return outItemVo;
                }).collect(Collectors.toList());
                return itemVos;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return null;
    }

    @Override
    public List<OutStockDetailVo> getOutStockDetailInfos(Page<OutStockDetailVo> page,String outCode) {
        PageHelper.startPage(page.getPageNo(), page.getPageSize());
        List<OutStockDetailVo> list = tOutStockDetailMapper.getOutStockDetailInfos(outCode);

        PageInfo<OutStockDetailVo> pageInfo = new PageInfo<>(list);
        page.setTotal(pageInfo.getTotal());
        return list;
    }

    @Override
    public List<OutStockDetailVo> getOutStockDetailInfos(String outCode) {
        return tOutStockDetailMapper.getOutStockDetailInfos(outCode);
    }

    @Override
    public List<String> findOutCarList() {
        return tOutStockMapper.findOutCarList();
    }

    public TProduct reloadProdAndGetProd(TStock sto){
        DictUtils.getProdMaps().clear();
        List<TProduct> prods = productMapper.findAllList();
        if (prods != null && !prods.isEmpty()) {
            Map<String, TProduct> prodMaps = DictUtils.getProdMaps();
            prods.forEach(prod -> {
                String key = String.valueOf(prod.getProdCgyCode()) + prod.getProdVariety() + prod.getProdColor() + prod.getProdThick() + prod.getProdPriceType();
                prodMaps.put(key, prod);
            });
        }
        TProduct prodduct = DictUtils.getProdCodeByProdCgyAndVari(sto.getItemCgyCode().toString() + sto.getItemVariety() + sto.getItemColor() + sto.getItemThick() + sto.getItemPriceType());
        return prodduct;
    }
}