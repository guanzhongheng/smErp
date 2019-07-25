package com.lcyzh.nmerp.component;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.jxls.reader.ReaderBuilder;
import org.jxls.reader.XLSReader;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

import java.io.*;
import java.util.Map;

/**
 * @Project : nm-erp
 * @Description : TODO
 * @Author : lijinku
 * @Iteration : 1.0
 * @Date : 2019/6/20  2:11 PM
 * @ModificationHistory Who          When          What
 * ----------   ------------- -----------------------------------
 * lijinku          2019/06/20    create
 */
@Slf4j
@Component
public class ParseExcelService {

    /**
     * 解析Excel
     *
     * @param xmlConfigName        xml配置（字段和Excel单元格的映射）
     * @param mpf 上传的文件
     * @param beans                解析后的数据
     */
    public void parseExcel(String xmlConfigName, MultipartFile mpf, Map<String, Object> beans) {
        InputStream inputStream = null;
        FileInputStream xmlConfig = null;
        InputStream is = null;
        InputStream inputXML = null;
        InputStream inputXLS = null;
        try {
            //上传的文件流
            inputStream = mpf.getInputStream();
            //xml配置的文件流
            is = this.getClass().getClassLoader().getResourceAsStream(xmlConfigName);
//            xmlConfig =new FileInputStream(abpath);
//            xmlConfig = new FileInputStream(xmlConfigName);
            //执行解析
            inputXML = new BufferedInputStream(is);
            XLSReader mainReader = ReaderBuilder.buildFromXML(inputXML);
            inputXLS = new BufferedInputStream(inputStream);
            mainReader.read(inputXLS, beans);
        } catch (InvalidFormatException e) {
            log.error("无效格式异常:", e);
        } catch (FileNotFoundException e) {
            log.error("文件未找到:", e);
        } catch (IOException e) {
            log.error("IO流异常:", e);
        } catch (SAXException e) {
            log.error("SAX解析异常:", e);
        } finally {
            try {
                if (inputXLS != null)
                    inputXLS.close();
                if (inputXML != null)
                    inputXML.close();
                if (xmlConfig != null)
                    xmlConfig.close();
                if (inputStream != null)
                    inputStream.close();
                if(is!=null){
                    is.close();
                }
            } catch (IOException e) {
                log.error("parse excel error", e);
            }
        }
    }

}
