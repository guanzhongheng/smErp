package com.lcyzh.nmerp.service.impl;

import com.lcyzh.nmerp.constant.Constants;
import com.lcyzh.nmerp.dao.TBarCodeInfoMapper;
import com.lcyzh.nmerp.dao.TOrderMapper;
import com.lcyzh.nmerp.dao.TOutStockDetailMapper;
import com.lcyzh.nmerp.dao.TOutStockMapper;
import com.lcyzh.nmerp.entity.TBarCodeInfo;
import com.lcyzh.nmerp.entity.TOutStock;
import com.lcyzh.nmerp.entity.TOutStockDetail;
import com.lcyzh.nmerp.model.vo.*;
import com.lcyzh.nmerp.service.TOutStockService;
import com.lcyzh.nmerp.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
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
    private TOutStockDetailMapper tOutStockDetailMapper;
    @Autowired
    private TBarCodeInfoMapper tBarCodeInfoMapper;
    @Autowired
    private TOrderMapper tOrderMapper;

    @Override
    public List<OutItemVo> findOutItemsByOutCode(String outCode) {
        return tOutStockDetailMapper.findOutItemsByOutCode(outCode);
    }

    @Override
    public TOutStock findByOutCode(String outCode) {
        return tOutStockMapper.findByPrimaryKey(outCode);
    }

    @Override
    public List<TOutStock> findByOrdCode(String ordCode) {
        return tOutStockMapper.findByOrdCode(ordCode);
    }

    @Override
    public List<TOutStock> findList(TOutStock tOutStock) {
        return tOutStockMapper.findList(tOutStock);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    @Override
    public int insertStore(OutStockDetailVo vo) {
        int res = -1;
        if (vo != null) {
            Date current = new Date();
            TBarCodeInfo barCodeInfo = new TBarCodeInfo();
            barCodeInfo.setBarCode(vo.getBarCode());
            barCodeInfo.setStatus('1');
            barCodeInfo.setStatusParam('0');
            barCodeInfo.setUpdateTime(current);
            res = tBarCodeInfoMapper.update(barCodeInfo);
            if (res > 0) {
                TOutStock outStock = new TOutStock();
                outStock.setOutCode(vo.getOutCode());
                outStock.setOutCount(1);
                outStock.setUpdateTime(current);
                res = tOutStockMapper.update(outStock);
                if (res > 0) {
                    TOutStockDetail outStockDetail = new TOutStockDetail();
                    outStockDetail.setOutCode(vo.getOutCode());
                    outStockDetail.setBarCode(vo.getBarCode());
                    outStockDetail.setQualityStatus(vo.getQualityStatus());
                    outStockDetail.setQualityUsCode(vo.getQualityUsCode());
                    outStockDetail.setCreateTime(current);
                    res = tOutStockDetailMapper.insert(outStockDetail);
                }
            }

        }

        return res;
    }


    @Override
    public String createAndReturnOutCode(String applyEmpCode, String remark) {
        TOutStock tOutStock = new TOutStock();
        String outCode = StringUtils.genFixPreFixStr(Constants.OUT_STORE_PRE_FIX);
        tOutStock.setOutCode(outCode);
        tOutStock.setOutCount(0);
        tOutStock.setOutStatus('0');
        tOutStock.setRemark(remark);
        tOutStock.setCreateTime(new Date());
        tOutStock.setApplyEmpCode(applyEmpCode);
        tOutStockMapper.insert(tOutStock);
        return outCode;
    }


    @Override
    public int update(OutStockVo vo) {
        int res = -1;
        if (vo != null) {
            TOutStock tOutStock = new TOutStock();
            if (vo.getOrdCode() != null) {
                TOutStock dbOutStock = tOutStockMapper.findByPrimaryKey(vo.getOutCode());
                if (dbOutStock != null) {
                    if (dbOutStock.getOrdCode() != null) {
                        tOutStock.setOrdCode(dbOutStock.getOrdCode() + vo.getOrdCode() + ",");
                    } else {
                        tOutStock.setOrdCode(vo.getOrdCode() + ",");
                    }
                }
            }
            tOutStock.setOutStatus(vo.getStatus());
            tOutStock.setRemark(vo.getRemark());
            tOutStock.setOperEmpCode(vo.getOperEmpCode());
            tOutStock.setUpdateTime(new Date());
            res = tOutStockMapper.update(tOutStock);
        }
        return res;
    }

    /**
     * @Description: 删除：分三种，删除该入库单中的一条记录；或者删除一个订单的所有，或者删除整个出库单
     * @Param: [tOutStock]
     * @return: int
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/6/27 11:49 AM
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    @Override
    public int delete(OutStockVo vo) {
        int res = -1;
        if (vo.getOutCode() != null) {
            Date current = new Date();
            if (vo.getBarCode() != null) {
                //删除一条记录
                TBarCodeInfo barCodeInf = new TBarCodeInfo();
                barCodeInf.setBarCode(vo.getBarCode());
                barCodeInf.setStatus('0');
                barCodeInf.setUpdateTime(current);
                res = tBarCodeInfoMapper.update(barCodeInf);
                if (res > 0) {
                    TOutStock tOutStock = new TOutStock();
                    tOutStock.setOutCode(vo.getOutCode());
                    tOutStock.setOutCount(-1);
                    tOutStock.setUpdateTime(current);
                    tOutStockDetailMapper.deleteByBarCode(vo.getBarCode());
                    tOutStockMapper.update(tOutStock);
                }
            } else {
                List<OutStockVo> list = tOutStockDetailMapper.findListByCondition(vo.getOutCode(), vo.getOrdCode(), vo.getItemId());
                final List<String> bcList = new ArrayList<>(list.size());
                if (list != null && !list.isEmpty()) {
                    List<TBarCodeInfo> barCodeList = list.stream().map(oc -> {
                                TBarCodeInfo barCodeInfo = new TBarCodeInfo();
                                barCodeInfo.setBarCode(oc.getBarCode());
                                barCodeInfo.setStatus('0');
                                bcList.add(oc.getBarCode());
                                return barCodeInfo;
                            }
                    ).collect(Collectors.toList());
                    res = tBarCodeInfoMapper.updateBatch(barCodeList);
                    if (!(vo.getItemId() == null && vo.getOrdCode() == null)) {
                        if (vo.getOrdCode() != null) {
                            TOutStock dbOutStock = tOutStockMapper.findByPrimaryKey(vo.getOutCode());
                            if (dbOutStock != null) {
                                String ordCodeStr = dbOutStock.getOrdCode();
                                String[] ordCodes = ordCodeStr.split(",");
                                StringBuilder sb = new StringBuilder(60);
                                if (ordCodes != null && ordCodes.length > 0) {
                                    for (String ord : ordCodes) {
                                        if (ord != null && !ord.equals(vo.getOrdCode())) {
                                            sb.append(ord).append(",");
                                        }
                                    }
                                }

                                if (res > 0) {
                                    TOutStock tOutStock = new TOutStock();
                                    tOutStock.setOutCode(vo.getOutCode());
                                    tOutStock.setOrdCode(sb.toString());
                                    tOutStock.setOutCount(-res);
                                    tOutStock.setUpdateTime(current);
                                    tOutStockMapper.update(tOutStock);
                                }
                            }
                        }

                    }
                }

                if (vo.getOutCode() != null && vo.getItemId() == null && vo.getOrdCode() == null) {
                    res = tOutStockMapper.delete(vo.getOutCode());
                }

                if (bcList != null && !bcList.isEmpty()) {
                    res = tOutStockDetailMapper.deleteByBatch(bcList);
                }

            }
        }
        return res;
    }

    @Override
    public ConcreteProdVo findByBarCode(String barCode) {
        ConcreteProdVo entity = tBarCodeInfoMapper.findDetailByPrimaryKey(barCode);
        if (entity != null && entity.getItemNum() != null && entity.getCcProdNum() != null) {
            entity.setRemainProdNum(entity.getItemNum().doubleValue() - entity.getCcProdNum());
        }


        if (entity.getOrdCode() != null) {
            OrderQueryVo queryVo = tOrderMapper.findByPrimaryKey(entity.getOrdCode());
            if (queryVo != null) {
                entity.setProxyName(queryVo.getProxyName());
                entity.setCusName(queryVo.getCusName());
            }
        }
        return entity;
    }


}
