package com.lcyzh.nmerp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.dao.TEquipmentMapper;
import com.lcyzh.nmerp.entity.TEquipment;
import com.lcyzh.nmerp.service.TEquipmentService;
import com.lcyzh.nmerp.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 项目名称：nm-erp
 * 类 名 称：TEquipmentServiceImpl
 * 类 描 述：TODO
 * 创建时间：2019/9/11 2:50 PM
 * 创 建 人：guan
 */
@Service
public class TEquipmentServiceImpl implements TEquipmentService {

    @Autowired
    private TEquipmentMapper tEquipmentMapper;

    @Override
    public List<TEquipment> findPageList(Page<TEquipment> page, TEquipment tEquipment) {
        PageHelper.startPage(page.getPageNo(), page.getPageSize());
        List<TEquipment> list = tEquipmentMapper.findList(tEquipment);
        PageInfo<TEquipment> pageInfo = new PageInfo<>(list);
        page.setTotal(pageInfo.getTotal());
        return list;
    }

    @Override
    public TEquipment findById(Long eqId) {
        return tEquipmentMapper.findById(eqId);
    }

    @Override
    public int getCount(String macAddress) {
        return tEquipmentMapper.getCount(macAddress);
    }

    @Override
    public int insert(TEquipment tEquipment) {
        int co = tEquipmentMapper.checkMacAddress(tEquipment.getMacAddress());
        if(co <= 0){
            tEquipment.setCreateTime(new Date());
            return tEquipmentMapper.insert(tEquipment);
        }else{
            return -2;
        }
    }

    @Override
    public int update(TEquipment tEquipment) {
        return tEquipmentMapper.update(tEquipment);
    }

    @Override
    public int delete(TEquipment tEquipment) {
        return tEquipmentMapper.delete(tEquipment);
    }
}
