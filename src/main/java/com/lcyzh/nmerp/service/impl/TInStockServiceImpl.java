package com.lcyzh.nmerp.service.impl;

import com.github.pagehelper.PageHelper;
import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.dao.TBarCodeInfoMapper;
import com.lcyzh.nmerp.dao.TInStockMapper;
import com.lcyzh.nmerp.entity.TBarCodeInfo;
import com.lcyzh.nmerp.entity.TInStock;
import com.lcyzh.nmerp.model.vo.InStockItemVo;
import com.lcyzh.nmerp.model.vo.ProdInvInfoVo;
import com.lcyzh.nmerp.service.TInStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author ljk
 * Date  2019-06-06
 */
@Service
public class TInStockServiceImpl implements TInStockService {
    @Autowired
    private TBarCodeInfoMapper barCodeInfoMapper;


    @Override
    public Page<ProdInvInfoVo> findProdInvInfoList(Page<ProdInvInfoVo> page) {
        PageHelper.startPage(page.getPageNo(),page.getPageSize());
        List<ProdInvInfoVo> list = barCodeInfoMapper.findInvInfoList();
        //转换产品字典
        page.setList(list);
        return page;
    }

    @Override
    public int goodWareHouse(InStockItemVo vo) {
        int res = -1;
        if (vo.getBarCode() != null && vo.getOrdCode() != null && vo.getItemId() != null && vo.getNum() != null && !(vo.getNum().doubleValue() == 0)) {
            Date current = new Date();
            TBarCodeInfo barCodeInfo = new TBarCodeInfo();
            barCodeInfo.setBarCode(vo.getBarCode());
            barCodeInfo.setItemId(vo.getItemId());
            barCodeInfo.setOrdCode(vo.getOrdCode());
            barCodeInfo.setStatus('0');
            barCodeInfo.setNum(vo.getNum());
            barCodeInfo.setCreateTime(current);
            res = barCodeInfoMapper.insert(barCodeInfo);
        }
        return res;
    }

    @Override
    public List<InStockItemVo> findByCondition(InStockItemVo vo) {
        if (vo != null) {
            TBarCodeInfo barCodeInfo = new TBarCodeInfo();
            barCodeInfo.setBarCode(vo.getBarCode());
            barCodeInfo.setOrdCode(vo.getOrdCode());
            barCodeInfo.setStatus(vo.getStatus());
            barCodeInfo.setItemId(vo.getItemId());
            List<TBarCodeInfo> list = barCodeInfoMapper.findList(barCodeInfo);
            if (list != null && !list.isEmpty()) {
                //缺字典转换：产品根据Id转换，单位转换
                List<InStockItemVo> listVo = list.stream().map(barCodeInf -> {
                    InStockItemVo itemVo = new InStockItemVo();
                    itemVo.setBarCode(barCodeInf.getBarCode());
                    itemVo.setItemId(barCodeInf.getItemId());
                    itemVo.setNum(barCodeInf.getNum());
                    itemVo.setUnit(barCodeInf.getItemId());
                    return itemVo;
                }).collect(Collectors.toList());

                return listVo;
            }

        }
        return null;
    }

}
