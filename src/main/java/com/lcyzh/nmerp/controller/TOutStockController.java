package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.entity.TOutStock;
import com.lcyzh.nmerp.model.vo.OutStockVo;
import com.lcyzh.nmerp.model.vo.StockVo;
import com.lcyzh.nmerp.service.TOutStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
     * @Description: 查询未完成的出库单
     * @Param: []
     * @return: java.util.List<com.lcyzh.nmerp.entity.TOutStock>
     * @Author: wsm
     * @Iteration : 1.0
     * @Date: 2019/7/3 11:41 PM
     */
//    @RequestMapping(value = {"/getList"}, method = RequestMethod.GET)
//    public List<TOutStock> findList(){
//        TOutStock tOutStock = new TOutStock();
//        tOutStock.setOutStatus('0');
//        return tOutStockService.findList(tOutStock);
//    }

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
        return tOutStockService.createAndReturnOutCode("admin","无");
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
    public StockVo getDetail(String barCode){
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
    public List<StockVo> detailList(String outCode){
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
    @ResponseBody
    public String doOutStock(TOutStock tOutStock){
        Integer result = tOutStockService.doOutStock(tOutStock);
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
        Integer result = 0;
        if(barCode != null && !barCode.equals("")){
            result = tOutStockService.deleteDetail(barCode);
        }
        if(outCode != null && !outCode.equals("")){
            result = tOutStockService.delete(outCode);
        }
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
        Integer result = tOutStockService.updateStatus(outCode,'1');
        return String.valueOf(result);
    }
}
