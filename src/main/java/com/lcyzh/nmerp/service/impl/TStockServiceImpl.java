package com.lcyzh.nmerp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.dao.TStockMapper;
import com.lcyzh.nmerp.entity.TStock;
import com.lcyzh.nmerp.model.vo.StockQueryVo;
import com.lcyzh.nmerp.service.TStockService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
* Author ljk
* Date  2019-06-06
*/
@Service
public class TStockServiceImpl implements TStockService{

    @Autowired
    private TStockMapper tStockMapper;

    @Override
    public TStock findById(Long id) {
        return tStockMapper.findById(id);
    }

    @Override
    public TStock get(String id){
        return tStockMapper.get(id);
    }

    //@Override
    //public List<TStock> findList(TStock tStock) {
    //    return tStockMapper.findList(tStock);
    //}

    @Override
    public int insert(TStock tStock) {
        return tStockMapper.insert(tStock);
    }

    @Override
    public int insertBatch(List<TStock> tStocks){
        return tStockMapper.insertBatch(tStocks);
    }

    @Override
    public List<StockQueryVo> findList(Page<StockQueryVo> page, StockQueryVo vo) {
        if(vo.getStartDate() == null || vo.getStartDate().length() == 0) {
            vo.setStartDate(LocalDate.now().minusMonths(3).toString());
        }
        if(vo.getEndDate() == null || vo.getEndDate().length() == 0) {
            vo.setEndDate(LocalDate.now().plusDays(1).toString());
        }
        PageHelper.startPage(page.getPageNo(),page.getPageSize());
        List<StockQueryVo> list = tStockMapper.findList(vo);
        PageInfo<StockQueryVo> pageInfo = new PageInfo<>(list);
        page.setTotal(pageInfo.getTotal());
        return list;
    }

}
