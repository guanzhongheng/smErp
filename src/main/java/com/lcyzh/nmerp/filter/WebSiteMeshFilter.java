package com.lcyzh.nmerp.filter;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

/**
 * 项目名称：nm-erp
 * 类 名 称：WebSiteMeshFilter
 * 类 描 述：TODO
 * 创建时间：2019/6/28 2:38 PM
 * 创 建 人：guan
 */
public class WebSiteMeshFilter extends ConfigurableSiteMeshFilter {

    /**
     * decoratorPath 第一个参数配置被模板装饰的页面  第二个参数为模板页
     * @param builder
     */
    @Override
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
        builder.addDecoratorPath("/sys/*", "/decoratorFilter/default")
                .addDecoratorPath("/crm/*", "/decoratorFilter/default")
                .addDecoratorPath("/tProduct/*", "/decoratorFilter/default")
                .addDecoratorPath("/order/*","/decoratorFilter/newLayout")
                .addDecoratorPath("/cus/*","/decoratorFilter/newLayout")
                .addDecoratorPath("/produce/*","/decoratorFilter/newLayout")
                .addDecoratorPath("crm/order/prodDetailList","/decoratorFilter/newLayout")
               // .addDecoratorPath("/", "/decoratorFilter/blank")
                .addDecoratorPath("/*", "/decoratorFilter/blank")
                .addDecoratorPath("/common/*", "/decoratorFilter/blank")
                .addExcludedPath("/logout").addExcludedPath("/crm/test")
                .addExcludedPath("/crmAjax/*").addExcludedPath("/sys/menu/tree");
    }
}
