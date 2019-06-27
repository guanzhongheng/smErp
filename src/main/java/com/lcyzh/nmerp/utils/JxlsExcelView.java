package com.lcyzh.nmerp.utils;

import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

public class JxlsExcelView extends AbstractView {
    private static final String CONTENT_TYPE = "application/vnd.ms-excel";

    private String templatePath;

    private String exportFileName;

    private Context context;

    /**
     * @param templatePath 模版相对于当前classpath路径
     * @param exportFileName 导出文件名
     */
    public JxlsExcelView(String templatePath, String exportFileName,Context context) {
        this.templatePath = templatePath;
        this.exportFileName = exportFileName;
        this.context = context;
        setContentType(CONTENT_TYPE);
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
                                           HttpServletResponse response) throws Exception {

        InputStream is = null;
        OutputStream os = null;

        os = response.getOutputStream();
        response.setContentType(getContentType());

        // 解决导出文件名中文乱码
        String filename = new String(exportFileName.getBytes("gb2312"), "iso8859-1");
        response.setHeader("content-disposition", "attachment;filename=" + filename + ".xlsx");

        // 获取excel模板
        is = JxlsExcelView.class.getClassLoader().getResourceAsStream(templatePath);

        //转换成excel并输出

        // 获取excel模板
        is = JxlsExcelView.class.getClassLoader().getResourceAsStream(templatePath);

        //转换成excel并输出
        JxlsHelper.getInstance().processTemplate(is, os, context);
        os.flush();
        os.close();
        is.close();
    }
}
