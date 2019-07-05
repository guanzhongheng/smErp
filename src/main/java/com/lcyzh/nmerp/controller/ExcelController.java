package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.component.ParseExcelService;
import com.lcyzh.nmerp.service.TOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
public class ExcelController {
    @Autowired
    private ParseExcelService parseExcelService;
    @Autowired
    private TOrderService tOrderService;

    @GetMapping("/upload")
    public String upload() {
        return "upload";
    }

//    @RequestMapping(value = "/import", method = RequestMethod.POST)
//    @Transactional
//    public String importExcel(@RequestParam(required = true) MultipartFile file, HttpServletRequest request) {
//        String fileName = file.getOriginalFilename().toLowerCase();
//        if (!fileName.endsWith(".xls") && !fileName.endsWith(".xlsx")) {
//            throw new RuntimeException("请上传Excel文件");
//        }
//        //获取文件
//        //获取xml文件头配置(我的xml文件是放在/config/import/point目录下的)
//        String xmlConfigPath = String.format("%s%s", request.getServletContext().getRealPath("/"), "/config/import/point/");
//        String xmlConfigName = String.format("%s%s", xmlConfigPath, "point-head.xml");
//        Map<String, Object> beans = new HashMap<>();
//        ExcelHead excelHead = new ExcelHead();
//        beans.put("excelHead", excelHead);
//        //解析文件头
//        this.parseExcelService.parseExcel(xmlConfigName, file, beans);
//        if (!excelHead.getPoint().equals(excelHead.getHead())) {
//            throw new RuntimeException("模板错误");
//        }
//        //获取文件体信息
//        xmlConfigName = String.format("%s%s", xmlConfigPath, "point-body.xml");
//        OrderAddBatchVo ord = new OrderAddBatchVo();
//        beans.clear();
//        beans.put("ord", ord);
//        //解析文件体
//        parseExcelService.parseExcel(xmlConfigName, file, beans);
//        this.tOrderService.insert(ord);
//        return "index";
//    }
}