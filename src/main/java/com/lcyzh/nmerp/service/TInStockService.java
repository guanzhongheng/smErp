package com.lcyzh.nmerp.service;

import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.model.vo.InStockItemVo;
import com.lcyzh.nmerp.model.vo.ProdInvInfoVo;

import java.util.List;

/**
* Author ljk
* Date  2019-06-06
*/
public interface TInStockService {

    /**
     * @Description: 分页查询产品信息
     * @Param: []
     * @return: com.lcyzh.nmerp.common.persistence.Page<com.lcyzh.nmerp.model.vo.ProdInvInfoVo>
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/6 10:31 PM
     */
    Page<ProdInvInfoVo> findProdInvInfoList(Page<ProdInvInfoVo> page);

    /**
     * @Description: 产品入库
     * @Param: [vo]
     * @return: int
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/5 10:58 AM
     */
    int goodWareHouse(InStockItemVo vo);

    /**
     * @Description: 多条件查询入库记录
     * @Param: [vo]
     * @return: java.util.List<com.lcyzh.nmerp.model.vo.InStockItemVo>
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/5 10:58 AM
     */
    List<InStockItemVo> findByCondition(InStockItemVo vo);

}
