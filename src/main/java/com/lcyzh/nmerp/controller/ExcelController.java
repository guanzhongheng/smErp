package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.component.ParseExcelService;
import com.lcyzh.nmerp.controller.common.BaseController;
import com.lcyzh.nmerp.entity.ExcelHead;
import com.lcyzh.nmerp.model.vo.OrderAddBatchVo;
import com.lcyzh.nmerp.service.TOrderService;
import com.lcyzh.nmerp.service.TOutStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Project : nm-erp
 * @Description : TODO
 * @Author : lijinku
 * @Iteration : 1.0
 * @Date : 2019/6/20  2:19 PM
 * @ModificationHistory Who          When          What
 * ----------   ------------- -----------------------------------
 * lijinku          2019/06/20    create
 */
@Controller
public class ExcelController extends BaseController {
    @Autowired
    private ParseExcelService parseExcelService;
    @Autowired
    private TOrderService tOrderService;
    @Value("${template.path}")
    private String xmlConfigPath;

    @GetMapping("/upload")
    public String upload() {
        return "upload";
    }

    @RequestMapping(value = "/order/import", method = RequestMethod.POST)
    @ResponseBody
    public String importExcel(@RequestParam(required = true) MultipartFile file, HttpServletRequest request,
                              Model model, RedirectAttributes redirectAttributes) {
        String fileName = file.getOriginalFilename().toLowerCase();
        if (!fileName.endsWith(".xls") && !fileName.endsWith(".xlsx")) {
            throw new RuntimeException("请上传Excel文件");
        }
        //获取文件
        //获取xml文件头配置(我的xml文件是放在/config/import/point目录下的)
        String xmlConfigName = String.format("%s%s", xmlConfigPath, "point-head.xml");
        Map<String, Object> beans = new HashMap<>();
        ExcelHead excelHead = new ExcelHead();
        beans.put("excelHead", excelHead);
        //解析文件头
        this.parseExcelService.parseExcel(xmlConfigName, file, beans);
        if (!excelHead.getPoint().equals(excelHead.getHead())) {
            throw new RuntimeException("模板错误");
        }
        //获取文件体信息
        xmlConfigName = String.format("%s%s", xmlConfigPath, "point-body.xml");
        OrderAddBatchVo ord = new OrderAddBatchVo();
        beans.clear();
        beans.put("ord", ord);
        //解析文件体
        parseExcelService.parseExcel(xmlConfigName, file, beans);
        try {
           this.tOrderService.insert(ord);
            addMessage(redirectAttributes,"导入成功!");
            return "success";
        }catch (Exception e){
            addMessage(redirectAttributes,"导入失败:" + e.getMessage());
            return e.getMessage();
        }
    }




}