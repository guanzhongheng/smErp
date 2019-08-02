package com.lcyzh.nmerp.service.impl;

import com.lcyzh.nmerp.constant.Constants;
import com.lcyzh.nmerp.controller.system.util.SysDictUtils;
import com.lcyzh.nmerp.dao.TCustomerMapper;
import com.lcyzh.nmerp.dao.TOrderItemMapper;
import com.lcyzh.nmerp.dao.TOrderMapper;
import com.lcyzh.nmerp.dao.TStockMapper;
import com.lcyzh.nmerp.model.vo.CustomerQueryVo;
import com.lcyzh.nmerp.model.vo.OrderItemVo;
import com.lcyzh.nmerp.model.vo.OrderQueryVo;
import com.lcyzh.nmerp.model.vo.StockQueryVo;
import com.lcyzh.nmerp.service.IReportService;
import com.lcyzh.nmerp.utils.DictUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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
            });
            vo.setOrderItemVos(orderItemVos);
            return vo;
        }
        return null;
    }
}