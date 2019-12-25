package com.lcyzh.nmerp.service.impl;

import com.lcyzh.nmerp.constant.Constants;
import com.lcyzh.nmerp.controller.system.util.SysDictUtils;
import com.lcyzh.nmerp.dao.*;
import com.lcyzh.nmerp.entity.TProdPlanDetail;
import com.lcyzh.nmerp.model.vo.*;
import com.lcyzh.nmerp.service.IReportService;
import com.lcyzh.nmerp.utils.Arith;
import com.lcyzh.nmerp.utils.DictUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;

import java.util.*;


@Service
public class ReportServiceImpl implements IReportService {
    @Autowired
    private TStockMapper tStockMapper;
    @Autowired
    private TCustomerMapper tCustomerMapper;
    @Autowired
    private TOrderMapper tOrderMapper;
    @Autowired
    private TOrderItemMapper tOrderItemMapper;
    @Autowired
    private TProdPlanDetailMapper tProdPlanDetailMapper;

    @Override
    public List<StockQueryVo> queryStockList(StockQueryVo vo) {
        //设置导出查询条件
        /*
        .........
         */
        List<StockQueryVo> vos = tStockMapper.findList(vo);
        vos.stream().forEach(item ->{
            item.setItemCgyCodeValue(DictUtils.getValueByDictKey(item.getItemCgyCode()));
            item.setItemVarietyValue(DictUtils.getValueByDictKey(item.getItemVariety()));
            item.setItemColorValue(SysDictUtils.getDictLabel(item.getItemColor(), Constants.PROD_COLOR, ""));
            item.setItemYbTypeValue(SysDictUtils.getDictLabel(item.getItemYbType(), Constants.PROD_YB_TYPE, ""));
            item.setItemYcTypeValue(SysDictUtils.getDictLabel(item.getItemYcType(), Constants.PROD_YC_TYPE, ""));
        });
        return vos;
    }

    @Override
    public List<CustomerQueryVo> queryCustomerList(CustomerQueryVo customer) {
        List<CustomerQueryVo> listPo = tCustomerMapper.findList(customer);
        if (listPo != null && !listPo.isEmpty()) {
            listPo.stream().forEach(po -> {
                po.setCusGradeValue(DictUtils.getValueByDictKey(po.getCusGrade()));
                po.setCusSourceValue(DictUtils.getValueByDictKey(po.getCusSource()));
                po.setCusStatusValue(DictUtils.getValueByDictKey(po.getCusStatus()));
            });
        }
        return listPo;
    }

    @Override
    public OrderQueryVo queryOrderInfo(String ordCode) {
        OrderQueryVo vo = new OrderQueryVo();
        vo.setOrdCode(ordCode);
        List<OrderQueryVo> list = tOrderMapper.findList(vo);
        if(list != null && !list.isEmpty()) {
            vo = list.get(0);
            vo.setOrdStatusValue(DictUtils.getValueByDictKey(vo.getOrdStatus()));
            vo.setPayTypeValue(DictUtils.getValueByDictKey(vo.getPayType()));
            vo.setPayStatusValue(DictUtils.getValueByDictKey(vo.getPayStatus()));
            List<OrderItemVo> orderItemVos = tOrderItemMapper.findByOrdCode(ordCode);
            orderItemVos.stream().forEach(item -> {
                item.setItemUnitValue(DictUtils.getValueByDictKey(item.getItemUnit()));
                item.setItemCgyCodeValue(DictUtils.getValueByDictKey(item.getItemCgyCode()));
                item.setItemVaritemValue(DictUtils.getValueByDictKey(item.getItemVariety()));
                item.setItemPriceTypeValue(DictUtils.getValueByDictKey(item.getItemPriceType()));
                item.setItemStatusValue(DictUtils.getValueByDictKey(item.getItemStatus()));
                item.setItemColorValue(SysDictUtils.getDictLabel(item.getItemColor(), Constants.PROD_COLOR, ""));
                item.setItemYbTypeValue(SysDictUtils.getDictLabel(item.getItemYbType(), Constants.PROD_YB_TYPE, ""));
                item.setItemYcTypeValue(SysDictUtils.getDictLabel(item.getItemYcType(), Constants.PROD_YC_TYPE, ""));
                if(item.getItemPriceType().equals(Constants.PROD_PRICE_TYPE_WEIGHT)
                        || item.getItemPriceType().equals(Constants.PROD_PRICE_TYPE_WEIGHT_JH)
                        || item.getItemPriceType().equals(Constants.PROD_PRICE_TYPE_WEIGHT_JB)){
                    item.setTotalPrice(Arith.round(item.getItemPrice()*item.getTotalStocktWeight(),4));
                }else{
                    item.setTotalPrice(Arith.round(item.getItemNum()*item.getItemPrice()*item.getItemLenth()*item.getItemWidth(),4));
                }
            });
            vo.setOrderItemVos(orderItemVos);
            return vo;
        }
        return null;
    }

    @Override
    public Map<String,Object> queryProdPlanDetailList(ProdPlanExportVo exportVo) {
        List<TProdPlanDetail> list = tProdPlanDetailMapper.findListBySections(exportVo);

//        List<ProdPlanDetailVo> detailVoList = new ArrayList<>();
//        Map<String,Object> result = new HashMap<>();
//
//        if(list != null && !list.isEmpty()){
//            Double totalWi = doTheoryCalculation(list);
//            list.stream().forEach(model ->{
//                ProdPlanDetailVo vo = new ProdPlanDetailVo();
//                BeanUtils.copyProperties(model, vo);
//                vo.setOrderTitle(model.getOrdTitle());
//                vo.setItemVarietyValue(DictUtils.getValueByDictKey(vo.getItemVariety()));
//                vo.setItemCgyCodeValue(DictUtils.getValueByDictKey(vo.getItemCgyCode()));
//                vo.setItemColorValue(SysDictUtils.getDictLabel(vo.getItemColor(), Constants.PROD_COLOR, ""));
//                vo.setItemYbTypeValue(SysDictUtils.getDictLabel(vo.getItemYbType(), Constants.PROD_YB_TYPE, ""));
//                vo.setItemYcTypeValue(SysDictUtils.getDictLabel(vo.getItemYcType(), Constants.PROD_YC_TYPE, ""));
//                vo.setItemStatusValue(transItemStatus(vo.getItemStatus()));
//                detailVoList.add(vo);
//            });
//            result.put("totalWi",totalWi);
//            result.put("detailVoList",detailVoList);
//        }
        return getProdPlanDetailInfs(list);
    }

    public Map<String, Object> getProdPlanDetailInfs(List<TProdPlanDetail> list){

        List<ProdPlanDetailVo> detailVoList = new ArrayList<>();
        Map<String,Object> result = new HashMap<>();

        if(list != null && !list.isEmpty()){
            Double totalWi = doTheoryCalculation(list);
            list.stream().forEach(model ->{
                ProdPlanDetailVo vo = new ProdPlanDetailVo();
                BeanUtils.copyProperties(model, vo);
                vo.setOrderTitle(model.getOrdTitle());
                vo.setItemVarietyValue(DictUtils.getValueByDictKey(vo.getItemVariety()));
                vo.setItemCgyCodeValue(DictUtils.getValueByDictKey(vo.getItemCgyCode()));
                vo.setItemColorValue(SysDictUtils.getDictLabel(vo.getItemColor(), Constants.PROD_COLOR, ""));
                vo.setItemYbTypeValue(SysDictUtils.getDictLabel(vo.getItemYbType(), Constants.PROD_YB_TYPE, ""));
                vo.setItemYcTypeValue(SysDictUtils.getDictLabel(vo.getItemYcType(), Constants.PROD_YC_TYPE, ""));
                vo.setItemStatusValue(transItemStatus(vo.getItemStatus()));
                detailVoList.add(vo);
            });
            result.put("totalWi",totalWi);
            result.put("detailVoList",detailVoList);
        }
        return result;
    }

    @Override
    public Map<String, Object> getProdPlanDetailList(String ids) {
        if(ids != null && ids.length() > 0){
            List<String> idList = Arrays.asList(ids.trim().split(","));
            List<TProdPlanDetail> list = tProdPlanDetailMapper.findByIds(idList);
            return getProdPlanDetailInfs(list);
        }
        return null;
    }

    @Override
    public Map<String, Object> getProdPlanOverList(String prodPlanCode) {

        return getProdPlanDetailInfs(tProdPlanDetailMapper.findByProdPlanCode(prodPlanCode));
    }

    private String transItemStatus(Character itemStatus){
        if(itemStatus != null){
            if(itemStatus == '0'){
                return "待确认";
            }else if (itemStatus == '1'){
                return "已下发";
            }else if (itemStatus == '2'){
                return "已完成";
            }
        }
        return null;
    }

    // 计算理论重量值
    public Double doTheoryCalculation(List<TProdPlanDetail> list){
        if(!CollectionUtils.isEmpty(list)){
            Double totalWi = 0d;
            list.forEach(n->{
                Double mj = Arith.mul(n.getItemLenth(),n.getItemWidth());
                Double mjt = Arith.mul(mj,n.getItemNum());
                Double fm = 0d;
                if(n.getItemDensity() == null || n.getItemThick() == null){
                    fm = 0d;
                }else{
                    fm = Arith.div(1,Arith.mul(n.getItemDensity(),n.getItemThick()));
                    Double to = Arith.div(mjt,fm,4);
                    n.setTheoryWeight(to);
                }
            });
            totalWi = list.stream().mapToDouble(i->i.getTheoryWeight() == null?0:i.getTheoryWeight()).sum();
            return totalWi;
        }
        return null;
    }
}