package com.lcyzh.nmerp.service;

import com.lcyzh.nmerp.entity.TOutStock;
import com.lcyzh.nmerp.model.vo.ConcreteProdVo;
import com.lcyzh.nmerp.model.vo.OutItemVo;
import com.lcyzh.nmerp.model.vo.OutStockDetailVo;
import com.lcyzh.nmerp.model.vo.OutStockVo;

import java.util.List;

/**
 * Author ljk
 * Date  2019-06-06
 */
public interface TOutStockService {

    /**
     * @Description: 根据出库单查询已出库的产品
     * @Param: [outCode]
     * @return: java.util.List<com.lcyzh.nmerp.model.vo.OutItemVo>
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/3 4:02 PM
     */
    List<OutItemVo> findOutItemsByOutCode(String outCode);

    /**
     * @Description: 根据出库单概况信息查看
     * @Param: [outCode]
     * @return: com.lcyzh.nmerp.entity.TOutStock
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 10:48 AM
     */
    TOutStock findByOutCode(String outCode);

    /**
     * @Description: 根据订单号查看出库信息（有可能一个订单包含在多个出库单里）
     * @Param: [ordCode]
     * @return: com.lcyzh.nmerp.entity.TOutStock
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 10:48 AM
     */
    List<TOutStock> findByOrdCode(String ordCode);

    /**
     * @Description: 多条件查询
     * @Param: [tOutStock]
     * @return: java.util.List<com.lcyzh.nmerp.entity.TOutStock>
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 10:48 AM
     */
    List<TOutStock> findList(TOutStock tOutStock);

    /**
     * @Description: 出库记录
     * @Param: [vo]
     * @return: int
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 10:49 AM
     */
    int insertStore(OutStockDetailVo vo);

    /**
     * @Description: 创建出库单并返回
     * @Param: [applyUserId, remark]
     * @return: java.lang.String
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 10:47 AM
     */
    String createAndReturnOutCode(Long applyUserId, String remark);

    /**
     * @Description: 更新出库信息
     * @Param: [tOutStock]
     * @return: int
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 10:50 AM
     */
    int update(OutStockVo tOutStock);

    /**
     * @Description: 删除出库记录：分三种，删除该入库单中的一条记录；或者删除一个订单的所有，或者删除整个出库单
     * @Param: [vo]
     * @return: int
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 10:50 AM
     */
    int delete(OutStockVo vo);

    /**
     * @Description: 根据条形码查看具体的信息
     * @Param: [barCode]
     * @return: com.lcyzh.nmerp.model.vo.ConcreteProdVo
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/3 2:43 PM
     */
    ConcreteProdVo findByBarCode(String barCode);

}
