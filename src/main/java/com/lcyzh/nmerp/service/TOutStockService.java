package com.lcyzh.nmerp.service;

import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.entity.TOutStock;
import com.lcyzh.nmerp.entity.TOutStockDetail;
import com.lcyzh.nmerp.model.vo.OutStockDetailVo;
import com.lcyzh.nmerp.model.vo.OutStockVo;
import com.lcyzh.nmerp.model.vo.StockRecordVo;
import com.lcyzh.nmerp.model.vo.StockVo;

import java.util.List;

/**
 * Author ljk
 * Date  2019-06-06
 */
public interface TOutStockService {

    /**
     * 查询新建出库单列表
     */
    List<TOutStock> findListNew();
    /**
     * 出库单更改状态 0-新建；1-待审批；2-已审批
     */
    int updateStatus(String outCode, Character status);
    /**
     * 根据outCode查询出库单
     */
    TOutStock findByCode(String outCode);

    /**
     * @Description: 根据出库单查询已出库的产品
     * @Param: [outCode]
     * @return: java.util.List<com.lcyzh.nmerp.model.vo.OutItemVo>
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/3 4:02 PM
     */
    List<OutStockDetailVo> findOutItemsByOutCode(String outCode);


    /**
     * @Description: 多条件查询
     * @Param: [tOutStock]
     * @return: java.util.List<com.lcyzh.nmerp.entity.TOutStock>
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 10:48 AM
     */
    Page<OutStockVo> findList(Page<OutStockVo> page, OutStockVo vo);



    /**
     * @Description: 出库记录
     * @Param: [vo]
     * @return: int
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 10:49 AM
     */
   // int insertStore(OutStockDetailVo vo);

    /**
     * @Description: 创建出库单并返回
     * @Param: [applyUserId, remark]
     * @return: java.lang.String
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 10:47 AM
     */
    String createAndReturnOutCode(String applyUserId, String remark);

    /**
     * @Description: 根据条形码查看具体的信息
     * @Param: [barCode]
     * @return: com.lcyzh.nmerp.model.vo.ConcreteProdVo
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/3 2:43 PM
     */
    OutStockDetailVo findByBarCode(String barCode);

    /**
     * 出库
     * @param tOutStock
     * @return
     */
    Integer doOutStock(TOutStock tOutStock);


    /**
     * 添加出库单明细
     */
    int addOutStockDetail(TOutStockDetail tOutStockDetail);

    /**
     * 出库单删除
     */
    int delete(String outCode);

    /**
     * 出库单明细删除
     */
    int deleteDetail(String barCode);


    /**
     * 获取
     * @param outCode
     * @return
     */
    List<StockRecordVo> getOutStockList(String outCode);
}
