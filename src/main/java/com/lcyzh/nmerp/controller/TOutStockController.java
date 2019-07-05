package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.entity.TOutStock;
import com.lcyzh.nmerp.model.vo.ConcreteProdVo;
import com.lcyzh.nmerp.model.vo.OutItemVo;
import com.lcyzh.nmerp.model.vo.OutStockDetailVo;
import com.lcyzh.nmerp.model.vo.OutStockVo;
import com.lcyzh.nmerp.service.TOutStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author ljk
 * Date  2019-06-06
 */
@RestController
@RequestMapping(value = "/tOutStock")
public class TOutStockController {
    @Autowired
    private TOutStockService tOutStockService;

    /**
     * @Description: 查询昨天到今天的未完成的出库单
     * @Param: []
     * @return: java.util.List<com.lcyzh.nmerp.entity.TOutStock>
     * @Author: wsm
     * @Iteration : 1.0
     * @Date: 2019/7/3 11:41 PM
     */
    @RequestMapping(value = {"/getList"}, method = RequestMethod.GET)
    public List<TOutStock> findList(){
        TOutStock tOutStock = new TOutStock();
        tOutStock.setOutStatus('0');
        tOutStock.setDays(1);
        return tOutStockService.findList(tOutStock);
    }

    /**
     * @Description: 新增出库单
     * @Param: []
     * @return: void
     * @Author: wsm
     * @Iteration : 1.0
     * @Date: 2019/7/3 11:47 PM
     */
    @RequestMapping(value = {"/create"}, method = RequestMethod.POST)
    public String addOutStock(){
        return tOutStockService.createAndReturnOutCode("1","无");
    }

    /**
     * @Description: 根据条码查询产品信息
     * @Param: [barCode]
     * @return: com.lcyzh.nmerp.model.vo.ConcreteProdVo
     * @Author: wsm
     * @Iteration : 1.0
     * @Date: 2019/7/3 11:49 PM
     */
    @RequestMapping(value = {"/getProd"}, method = RequestMethod.GET)
    public ConcreteProdVo getDetail(String barCode){
        return tOutStockService.findByBarCode(barCode);
    }

    /**
     * @Description: 根据出库单号查询该出库单下已包含的产品列表
     * @Param: [outCode]
     * @return: java.util.List<com.lcyzh.nmerp.model.vo.OutItemVo>
     * @Author: wsm
     * @Iteration : 1.0
     * @Date: 2019/7/3 11:52 PM
     */
    @RequestMapping(value = {"/getDetailList"}, method = RequestMethod.GET)
    public List<OutItemVo> detailList(String outCode){
        return tOutStockService.findOutItemsByOutCode(outCode);
    }

    /**
     * @Description: 执行出库
     * @Param: [barCode, outCode]
     * @return: java.lang.String
     * @Author: wsm
     * @Iteration : 1.0
     * @Date: 2019/7/5 11:31 AM
     */
    @RequestMapping(value = {"/doOutStock"}, method = RequestMethod.POST)
    public String doOutStock(String barCode,String outCode){
        OutStockDetailVo vo = new OutStockDetailVo();
        vo.setBarCode(barCode);
        vo.setOutCode(outCode);
        Integer result = tOutStockService.insertStore(vo);
        return String.valueOf(result);
    }

    /**
     * @Description: 根据传入的code删除对应的资源
     * @Param: [barCode, outCode]
     * @return: java.lang.String
     * @Author: wsm
     * @Iteration : 1.0
     * @Date: 2019/7/5 11:31 AM
     */
    @RequestMapping(value = {"/deleteByCode"}, method = RequestMethod.POST)
    public String deleteByCode(String barCode,String outCode){
        OutStockVo vo = new OutStockVo();
        vo.setBarCode(barCode);
        vo.setOutCode(outCode);
        Integer result = tOutStockService.delete(vo);
        return String.valueOf(result);
    }

    /**
     * @Description: 出库单完结
     * @Param: [outCode]
     * @return: java.lang.String
     * @Author: wsm
     * @Iteration : 1.0
     * @Date: 2019/7/5 3:24 PM
     */
    @RequestMapping(value = {"/finishOutStock"}, method = RequestMethod.POST)
    public String finishOutStock(String outCode){
        OutStockVo outStock = new OutStockVo();
        outStock.setOutCode(outCode);
        outStock.setStatus('1');
        Integer result = tOutStockService.update(outStock);
        return String.valueOf(result);
    }
}
