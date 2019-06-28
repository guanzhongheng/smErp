package com.lcyzh.nmerp.service.impl;

import com.lcyzh.nmerp.constant.Constants;
import com.lcyzh.nmerp.dao.TBarCodeInfoMapper;
import com.lcyzh.nmerp.dao.TOutStockDetailMapper;
import com.lcyzh.nmerp.dao.TOutStockMapper;
import com.lcyzh.nmerp.entity.TBarCodeInfo;
import com.lcyzh.nmerp.entity.TOutStock;
import com.lcyzh.nmerp.entity.TOutStockDetail;
import com.lcyzh.nmerp.model.vo.OutStockDetailVo;
import com.lcyzh.nmerp.model.vo.OutStockVo;
import com.lcyzh.nmerp.service.TOutStockService;
import com.lcyzh.nmerp.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

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
//    @Autowired
//    private TOutStockMapper tOutStockMapper;
//    @Autowired
//    private TOutStockDetailMapper tOutStockDetailMapper;
//    @Autowired
//    private TBarCodeInfoMapper tBarCodeInfoMapper;
//
//    @Override
//    public TOutStock findByOutCode(String outCode) {
//        return tOutStockMapper.findByPrimaryKey(outCode);
//    }
//
//    @Override
//    public TOutStock findByOrdCode(String ordCode) {
//        return tOutStockMapper.findByOrdCode(ordCode);
//    }
//
//    @Override
//    public List<TOutStock> findList(TOutStock tOutStock) {
//        return tOutStockMapper.findList(tOutStock);
//    }
//
//    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
//    @Override
//    public int insertStore(OutStockDetailVo vo) {
//        Date current = new Date();
//        TOutStock outStock = new TOutStock();
//        outStock.setOutCode(vo.getOutCode());
//        outStock.setOutCount(1);
//        outStock.setUpdateTime(current);
//        int res = tOutStockMapper.update(outStock);
//        if (res > 0) {
//            TOutStockDetail outStockDetail = new TOutStockDetail();
//            outStockDetail.setOutCode(vo.getOutCode());
//            outStockDetail.setBarCode(vo.getBarCode());
//            outStockDetail.setQualityStatus(vo.getQualityStatus());
//            outStockDetail.setQualityUsCode(vo.getQualityUsCode());
//            outStockDetail.setCreateTime(current);
//            res = tOutStockDetailMapper.insert(outStockDetail);
//            if (res > 0) {
//                TBarCodeInfo barCodeInfo = new TBarCodeInfo();
//                barCodeInfo.setBarCode(vo.getBarCode());
//                barCodeInfo.setStatus('1');
//                barCodeInfo.setUpdateTime(current);
//                res = tBarCodeInfoMapper.update(barCodeInfo);
//            }
//        }
//
//        return res;
//    }
//
//    @Override
//    public String createAndReturnOutCode(Long applyUserId, String remark) {
//        TOutStock tOutStock = new TOutStock();
//        String outCode = StringUtils.genFixPreFixStr(Constants.OUT_STORE_PRE_FIX);
//        tOutStock.setOutCode(outCode);
//        tOutStock.setOutCount(0);
//        tOutStock.setRemark(remark);
//        tOutStock.setApplyUserId(applyUserId);
//        tOutStockMapper.insert(tOutStock);
//        return outCode;
//    }
//
//
//    @Override
//    public int update(OutStockVo vo) {
//        TOutStock tOutStock = new TOutStock();
//        if (vo.getOrdCode() != null) {
//            TOutStock dbOutStock = tOutStockMapper.findByPrimaryKey(vo.getOutCode());
//            if (dbOutStock != null) {
//                if (dbOutStock.getOrdCode() != null) {
//                    tOutStock.setOrdCode(dbOutStock.getOrdCode() + vo.getOrdCode() + ",");
//                }else {
//                    tOutStock.setOrdCode(vo.getOrdCode()+",");
//                }
//            }
//        }
//        tOutStock.setRemark(vo.getRemark());
//        tOutStock.setOperUserId(vo.getOperUserId());
//        tOutStock.setUpdateTime(new Date());
//        return tOutStockMapper.update(tOutStock);
//    }
//
//    /**
//     * @Description: 删除：分三种，删除该入库单中的一条记录；或者删除一个订单的所有，或者删除整个出库单
//     * @Param: [tOutStock]
//     * @return: int
//     * @Author: lijinku
//     * @Iteration : 1.0
//     * @Date: 2019/6/27 11:49 AM
//     */
//    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
//    @Override
//    public int delete(OutStockVo vo) {
//        int res = -1;
//        if (vo.getBarCode() != null) {
//            Date current = new Date();
//            if (vo.getBarCode() != null) {
//                //删除一条记录
//                TBarCodeInfo barCodeInf = new TBarCodeInfo();
//                barCodeInf.setBarCode(vo.getBarCode());
//                barCodeInf.setStatus('0');
//                barCodeInf.setUpdateTime(current);
//                res = tBarCodeInfoMapper.update(barCodeInf);
//                TOutStock tOutStock = new TOutStock();
//                tOutStock.setOutCode(vo.getOutCode());
//                tOutStock.setOutCount(-1);
//                tOutStock.setUpdateTime(current);
//                if (res > 0) {
//                    tOutStockMapper.update(tOutStock);
//                }
//            } else {
//                List<OutStockVo> list = tOutStockDetailMapper.findListByCondition(vo.getOutCode(), vo.getOrdCode(), vo.getItemId());
//                if (list != null && !list.isEmpty()) {
//                    List<TBarCodeInfo> barCodeList = list.stream().map(oc -> {
//                                TBarCodeInfo barCodeInfo = new TBarCodeInfo();
//                                barCodeInfo.setBarCode(oc.getBarCode());
//                                barCodeInfo.setStatus('0');
//                                return barCodeInfo;
//                            }
//                    ).collect(Collectors.toList());
//                    res = tBarCodeInfoMapper.updateBatch(barCodeList);
//                    if (!(vo.getItemId() == null && vo.getOrdCode() == null)) {
//                        if (vo.getOrdCode() != null) {
//                            TOutStock dbOutStock = tOutStockMapper.findByPrimaryKey(vo.getOutCode());
//                            if (dbOutStock != null) {
//                                String ordCodeStr = dbOutStock.getOrdCode();
//                                String[] ordCodes = ordCodeStr.split(",");
//                                StringBuilder sb = new StringBuilder(60);
//                                if (ordCodes != null && ordCodes.length > 0) {
//                                    for (String ord : ordCodes) {
//                                        if (ord != null && !ord.equals(vo.getOrdCode())) {
//                                            sb.append(ord).append(",");
//                                        }
//                                    }
//                                }
//
//                                if (res > 0) {
//                                    TOutStock tOutStock = new TOutStock();
//                                    tOutStock.setOutCode(vo.getOutCode());
//                                    tOutStock.setOrdCode(sb.toString());
//                                    tOutStock.setOutCount(-res);
//                                    tOutStock.setUpdateTime(current);
//                                    res = tOutStockMapper.update(tOutStock);
//                                }
//                            }
//                        } else {
//                            if (res > 0) {
//                                res = tOutStockMapper.delete(vo.getOutCode());
//                            }
//                        }
//                    }
//
//                }
//            }
//        }
//        return res;
//    }


    @Override
    public TOutStock get(String id) {
        return null;
    }

    @Override
    public List<TOutStock> findList(TOutStock tOutStock) {
        return null;
    }

    @Override
    public List<TOutStock> findAllList() {
        return null;
    }

    @Override
    public int insert(TOutStock tOutStock) {
        return 0;
    }

    @Override
    public int insertBatch(List<TOutStock> tOutStocks) {
        return 0;
    }

    @Override
    public int update(TOutStock tOutStock) {
        return 0;
    }

    @Override
    public int delete(TOutStock tOutStock) {
        return 0;
    }
}
