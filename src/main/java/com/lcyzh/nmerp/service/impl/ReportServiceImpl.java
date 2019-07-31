package com.lcyzh.nmerp.service.impl;

import com.lcyzh.nmerp.dao.TCustomerMapper;
import com.lcyzh.nmerp.dao.TStockMapper;
import com.lcyzh.nmerp.model.vo.CustomerQueryVo;
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

    @Override
    public List<StockQueryVo> queryStockList(StockQueryVo vo) {
        //设置导出查询条件
        /*
        .........
         */
        return tStockMapper.findList(vo);
    }

    @Override
    public List<CustomerQueryVo> queryCustomerList(CustomerQueryVo customer) {
        List<CustomerQueryVo> listPo = tCustomerMapper.findList(customer);
        if (listPo != null && !listPo.isEmpty()) {
            listPo.forEach(po -> {
                po.setCusGradeValue(DictUtils.getValueByDictKey(po.getCusGrade()));
                po.setCusSourceValue(DictUtils.getValueByDictKey(po.getCusSource()));
                po.setCusStatusValue(DictUtils.getValueByDictKey(po.getCusStatus()));
            });
        }
        return listPo;
    }
}