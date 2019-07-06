package com.lcyzh.nmerp.service.impl;

import com.github.pagehelper.PageHelper;
import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.constant.Constants;
import com.lcyzh.nmerp.controller.system.util.UserUtils;
import com.lcyzh.nmerp.dao.*;
import com.lcyzh.nmerp.entity.TOrder;
import com.lcyzh.nmerp.entity.TProdPlan;
import com.lcyzh.nmerp.entity.TProdPlanDetail;
import com.lcyzh.nmerp.entity.TProdplanExe;
import com.lcyzh.nmerp.model.vo.OrderItemAssignVo;
import com.lcyzh.nmerp.model.vo.OrderItemVo;
import com.lcyzh.nmerp.model.vo.ProdPlanDetailVo;
import com.lcyzh.nmerp.service.TProdPlanService;
import com.lcyzh.nmerp.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author ljk
 * Date  2019-06-06
 */
@Service
public class TProdPlanServiceImpl implements TProdPlanService {
    @Autowired
    private TProdPlanMapper tProdPlanMapper;
    @Autowired
    private TProdPlanDetailMapper prodPlanDetailMapper;
    @Autowired
    private TProdplanExeMapper tProdplanExeMapper;
    @Autowired
    private TOrderMapper tOrderMapper;

    @Override
    public TProdPlan findByProdPanCode(String prodPlanCode) {
        return tProdPlanMapper.findById(prodPlanCode);
    }

    @Override
    public TProdPlan findByOrdCode(String ordCode) {
        return tProdPlanMapper.findByOrdCode(ordCode);
    }

    @Override
    public Page<ProdPlanDetailVo> findPage(Page<ProdPlanDetailVo> page,ProdPlanDetailVo vo) {
        PageHelper.startPage(page.getPageNo(),page.getPageSize());
        List<ProdPlanDetailVo> list = tProdPlanMapper.findList(vo);
        //获取产品信息
        page.setList(list);
        return page;
    }

    @Override
    public int save(TProdPlan prodPlan) {
        int res = -1;
        if (prodPlan != null) {
            Date current = new Date();
            if (prodPlan != null) {
                prodPlan.setUpdateTime(current);
                res = tProdPlanMapper.update(prodPlan);
            } else {
                prodPlan.setCreateTime(current);
                res = tProdPlanMapper.insert(prodPlan);
            }
        }
        return res;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    @Override
    public int createProdPlan(String ordCode, String ordDeliveryDate, List<OrderItemVo> items) {
        int res = -1;
        if (StringUtils.isNotEmpty(ordCode) && items != null && !items.isEmpty()) {
            Date current = new Date();
            //生成产品计划
            String planCode = StringUtils.genFixPreFixStr(Constants.PROD_PLAN_PRE_FIX);
            TProdPlan tProdPlan = buildProdPlan(ordCode, items, planCode, current);
            res = tProdPlanMapper.insert(tProdPlan);
            if (res > 0) {
                List<TProdPlanDetail> prdPlanDetails = items.stream().map(item -> {
                    TProdPlanDetail planDetail = buildProdPlanDetail(item, planCode, ordDeliveryDate, current);
                    return planDetail;
                }).collect(Collectors.toList());

                res = prodPlanDetailMapper.insertBatch(prdPlanDetails);
                if (res > 0) {
                    TOrder tOrder = new TOrder();
                    tOrder.setOrdCode(ordCode);
                    tOrder.setOrdStatus(Constants.ORD_STATUS_ASSIGNED);
                    tOrder.setUpdateTime(current);
                    res = tOrderMapper.update(tOrder);
                }
            }

        }
        return res;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    @Override
    public int adjustProdPlanDate(String prodPlanCode, Long itemId, String eaListDate, String latestDate) {
        int res = -1;
        if (prodPlanCode != null) {
            Date current = new Date();
            TProdPlanDetail planDetail = new TProdPlanDetail();
            planDetail.setProdPlanCode(prodPlanCode);
            planDetail.setOrdItemId(itemId);
            planDetail.setElstFinishDate(eaListDate);
            planDetail.setLatestFinishDate(latestDate);
            planDetail.setUpdateTime(current);
            res = prodPlanDetailMapper.update(planDetail);
        }
        return res;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    @Override
    public int prodPlanExeAssign(List<OrderItemAssignVo> voList) {
        int res = -1;
        if (voList != null && !voList.isEmpty()) {
            Date current = new Date();
            List<TProdplanExe> prodplanExes = voList.stream().map(vo -> {
                TProdplanExe prodplanExe = new TProdplanExe();
                prodplanExe.setOrdItemId(vo.getOrdItemId());
                prodplanExe.setItemNum(vo.getItemNum());
                prodplanExe.setItemUnit(vo.getItemUnit());
                prodplanExe.setStatus('0');
                prodplanExe.setMacCode(vo.getMacCode());
                prodplanExe.setItemFinishNum(0.0);
                prodplanExe.setCreateTime(current);
                return prodplanExe;
            }).collect(Collectors.toList());
            res = tProdplanExeMapper.insertBatch(prodplanExes);
        }
        return res;
    }

    @Override
    public List<TProdPlanDetail> findByPlanCode(String planCode) {
        TProdPlanDetail planDetail = new TProdPlanDetail();
        planDetail.setProdPlanCode(planCode);
        return prodPlanDetailMapper.findList(planDetail);
    }

    /**
     * @Description: 构建产品计划明细
     * @Param: [item, planCode, ordDeliveryDate, current]
     * @return: com.lcyzh.nmerp.entity.TProdPlanDetail
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/4 11:46 PM
     */
    private TProdPlanDetail buildProdPlanDetail(OrderItemVo item, String planCode, String ordDeliveryDate, Date current) {
        TProdPlanDetail planDetail = new TProdPlanDetail();
        planDetail.setOrdItemId(item.getItemId());
        planDetail.setProdPlanCode(planCode);
        planDetail.setItemNum(item.getItemNum());
        planDetail.setItemFinishNum(0.0);
        planDetail.setElstFinishDate(ordDeliveryDate);
        planDetail.setLatestFinishDate(ordDeliveryDate);
        planDetail.setCreateTime(current);
        return planDetail;
    }

    /**
     * @Description: 构建产品计划信息
     * @Param: [ordCode, items, planCode, current]
     * @return: com.lcyzh.nmerp.entity.TProdPlan
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/4 11:38 PM
     */
    private TProdPlan buildProdPlan(String ordCode, List<OrderItemVo> items, String planCode, Date current) {
        TProdPlan tProdPlan = new TProdPlan();
        tProdPlan.setProdPlanCode(planCode);
        tProdPlan.setOrdCode(ordCode);
        tProdPlan.setItemCgyNum(items.size());
        tProdPlan.setFinishCgyNum(0);
        tProdPlan.setOperEmpCode(UserUtils.getUser().getId());
        tProdPlan.setPlanStatus('0');
        tProdPlan.setCreateTime(current);
        return tProdPlan;
    }


}
