<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
    <title>产品操作</title>

    <link rel="stylesheet" href="/static/common/customize.css">
    <script type="text/javascript">

    </script>
</head>
<body>
<%--<ul class="nav nav-tabs">--%>
    <%--<li><a href="${ctx}/tProduct/list/">产品列表</a></li>--%>
    <%--<li class="active"><a href="${ctx}/tProduct/get?id=">产品操作</a></li>--%>
<%--</ul><br/>--%>



<div class="tabs-container" style="padding: 20px 20px;">
    <div class="panel panel-default" style="border-color: #50B0E6; border-style: solid; border-width: 1px; border-radius:5px 5px 5px 5px;">
        <div class="panel-heading" style="background-color: #50B0E6">
            <h3 class="panel-title global-panel-title" >
                产品操作
            </h3>
            <code class="pull-right" style="margin-top: -33px; margin-right: 8px"><span style="color: red; ">*</span>
                <small>为必填项</small>
            </code>
        </div>
        <div class="panel-body" style="padding: 10px 10px 0px 10px;">

            <form:form id="inputForm" modelAttribute="tProduct" action="${ctx}/tProduct/insert" method="post" class="form-horizontal">
                <input name="id" id="id" type="hidden" value="${prodId}">
                <sys:message content="${message}"/>
                <%--<div class="row">--%>
                    <%--<div class="col-sm-12">--%>
                        <%--<div class="hr-line-dashed"></div>--%>
                        <%--<div class="form-group">--%>

                            <%--<label class="col-md-2 control-label order-detail-label-margin" style="text-align: right"><i style="color: red">*</i>--%>
                                <%--产品编码:--%>
                            <%--</label>--%>
                            <%--<label class="col-md-2 control-label order-label-input-width">--%>
                                <%--<form:input path="prodCode" htmlEscape="false"--%>
                                            <%--class="form-control global-input order-label-input-width" placeholder="产品编码"/>--%>
                            <%--</label>--%>

                            <%--<label class="col-md-2 control-label  order-detail-label-margin order-input-width" style="text-align: right">--%>
                                <%--产品名称:--%>
                            <%--</label>--%>
                            <%--<label class="col-md-2 control-label order-input-width " style="text-align: left">--%>
                                <%--<form:input path="prodName" htmlEscape="false"--%>
                                            <%--class="form-control global-input order-label-input-width" placeholder="产品名称"/>--%>
                            <%--</label>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>







                <div class="control-group">
                    <label class="control-label"><i style="color: red">*</i>&nbsp;产品编码:</label>
                    <div class="controls">
                        <form:input path="prodCode" htmlEscape="false" maxlength="50" class="required"/>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <i style="color: red">*</i>&nbsp;产品名称:&nbsp;&nbsp;&nbsp;&nbsp;
                        <form:input path="prodName" htmlEscape="false" maxlength="50" class="required"/>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label"><i style="color: red"></i>&nbsp;产品品种:</label>
                    <div class="controls">
                        <form:select path="prodCgyCode" class="input-medium" cssStyle="width: 220px" placeholder="产品品种">
                            <form:option value="" label=""/>
                            <form:options items="${fns:getCusDictList(148000)}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                        </form:select>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <i style="color: white">*</i>&nbsp;产品类别:&nbsp;&nbsp;&nbsp;&nbsp;
                        <form:select path="prodVariety" class="input-medium" cssStyle="width: 220px" placeholder="产品类别">
                            <form:option value="" label=""/>
                            <form:options items="${fns:getCusDictList(149000)}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                        </form:select>
                    </div>
                </div>
                <%--<div class="control-group">--%>
                    <%--<label class="control-label">产品名称:</label>--%>
                    <%--<div class="controls">--%>
                        <%--<form:input path="prodName" htmlEscape="false" maxlength="50" class="required"/>--%>
                        <%--<span class="help-inline"><font color="red">*</font> </span>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<div class="control-group">--%>
                    <%--<label class="control-label">产品品种:</label>--%>
                    <%--<div class="controls">--%>
                        <%--<form:select path="prodCgyCode" class="input-medium" placeholder="产品品种">--%>
                            <%--<form:option value="" label=""/>--%>
                            <%--<form:options items="${fns:getCusDictList(148000)}" itemLabel="label" itemValue="value" htmlEscape="false"/>--%>
                        <%--</form:select>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<div class="control-group">--%>
                    <%--<label class="control-label">产品类别:</label>--%>
                    <%--<div class="controls">--%>
                        <%--<form:select path="prodVariety" class="input-medium" placeholder="产品类别">--%>
                            <%--<form:option value="" label=""/>--%>
                            <%--<form:options items="${fns:getCusDictList(149000)}" itemLabel="label" itemValue="value" htmlEscape="false"/>--%>
                        <%--</form:select>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <div class="control-group">
                    <label class="control-label"><i style="color: red"></i>&nbsp;产品颜色:</label>
                    <div class="controls">
                        <form:select path="prodColor" class="input-medium" cssStyle="width: 220px" placeholder="颜色">
                            <form:option value="" label=""/>
                            <form:options items="${fns:getDictList('prod_color')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                        </form:select>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <i style="color: white">*</i>&nbsp;产品厚度:&nbsp;&nbsp;&nbsp;&nbsp;
                        <form:input path="prodThick" htmlEscape="false" maxlength="100" class="required"/>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label"><i style="color: red"></i>&nbsp;产品单位:</label>
                    <div class="controls">
                        <form:select path="prodUnit" class="input-medium" cssStyle="width: 220px" placeholder="产品单位">
                            <form:option value="" label=""/>
                            <form:options items="${fns:getCusDictList(142000)}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                        </form:select>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <i style="color: white">*</i>&nbsp;计价方式:&nbsp;&nbsp;&nbsp;&nbsp;
                        <form:select path="prodPriceType" class="input-medium" cssStyle="width: 220px" placeholder="计价方式">
                            <form:option value="" label=""/>
                            <form:options items="${fns:getCusDictList(141000)}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                        </form:select>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label"><i style="color: red"></i>&nbsp;参考单价:</label>
                    <div class="controls">
                        <form:input path="prodGuidePrice" htmlEscape="false" maxlength="100" class="required"/>

                    </div>
                </div>
                <div class="">
                    <input id="btnSubmit" class="btn btn-primary"
                           style="width: 180px;font-size: 18px;height: 40px;margin-left: 179px;margin-bottom: 10px;"
                           type="submit" value="保  存"/>
                    <input id="btnCancel" class="btn" type="button"
                           style="width: 180px;font-size: 18px;height: 40px;margin-left: 95px;margin-bottom: 10px;"
                           value="返  回" onclick="history.go(-1)"/>

                </div>
                <%--<div class="control-group">--%>
                    <%--<label class="control-label">产品颜色:</label>--%>
                    <%--<div class="controls">--%>
                        <%--<form:select path="prodColor" class="input-medium" placeholder="颜色">--%>
                            <%--<form:option value="" label=""/>--%>
                            <%--<form:options items="${fns:getDictList('prod_color')}" itemLabel="label" itemValue="value" htmlEscape="false"/>--%>
                        <%--</form:select>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<div class="control-group">--%>
                    <%--<label class="control-label">产品厚度:</label>--%>
                    <%--<div class="controls">--%>
                        <%--<form:input path="prodThick" htmlEscape="false" maxlength="100" class="required"/>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<div class="control-group">--%>
                    <%--<label class="control-label">产品单位:</label>--%>
                    <%--<div class="controls">--%>
                        <%--<form:select path="prodUnit" class="input-medium" placeholder="产品单位">--%>
                            <%--<form:option value="" label=""/>--%>
                            <%--<form:options items="${fns:getCusDictList(142000)}" itemLabel="label" itemValue="value" htmlEscape="false"/>--%>
                        <%--</form:select>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<div class="control-group">--%>
                    <%--<label class="control-label">计价方式:</label>--%>
                    <%--<div class="controls">--%>
                        <%--<form:select path="prodPriceType" class="input-medium" placeholder="计价方式">--%>
                            <%--<form:option value="" label=""/>--%>
                            <%--<form:options items="${fns:getCusDictList(141000)}" itemLabel="label" itemValue="value" htmlEscape="false"/>--%>
                        <%--</form:select>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<div class="control-group">--%>
                    <%--<label class="control-label">参考单价:</label>--%>
                    <%--<div class="controls">--%>
                        <%--<form:input path="prodGuidePrice" htmlEscape="false" maxlength="100" class="required"/>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<div class="form-actions">--%>
                    <%--<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;--%>
                    <%--<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>--%>
                <%--</div>--%>
            </form:form>

        </div>
    </div>
</div>






</body>
</html>