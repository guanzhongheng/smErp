<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
    <title>产品操作</title>
    <script type="text/javascript">

    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li><a href="${ctx}/tProduct/list/">产品操作</a></li>
    <li class="active"><a href="${ctx}/tProduct/get?id=">用户操作</a></li>
</ul><br/>
<form:form id="inputForm" modelAttribute="tProduct" action="${ctx}/tProduct/insert" method="post" class="form-horizontal">
    <form:hidden path="id"/>
    <sys:message content="${message}"/>
    <div class="control-group">
        <label class="control-label">产品编码:</label>
        <div class="controls">
            <form:input path="prodCode" htmlEscape="false" maxlength="50" class="required"/>
            <span class="help-inline"><font color="red">*</font> </span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">产品名称:</label>
        <div class="controls">
            <form:input path="prodName" htmlEscape="false" maxlength="50" class="required"/>
            <span class="help-inline"><font color="red">*</font> </span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">产品类型:</label>
        <div class="controls">
            <form:select path="prodCgyCode" class="input-medium" placeholder="产品类型">
                <form:option value="" label=""/>
                <form:options items="${fns:getCusDictList(105000)}" itemLabel="label" itemValue="value" htmlEscape="false"/>
            </form:select>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">产品品种:</label>
        <div class="controls">
            <form:select path="prodVariety" class="input-medium" placeholder="产品类型">
                <form:option value="" label=""/>
                <form:options items="${fns:getCusDictList(105000)}" itemLabel="label" itemValue="value" htmlEscape="false"/>
            </form:select>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">产品厚度:</label>
        <div class="controls">
            <form:input path="prodThick" htmlEscape="false" maxlength="100" class="email"/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">参考价格:</label>
        <div class="controls">
            <form:input path="prodGuidePrice" htmlEscape="false" maxlength="100" class="email"/>
        </div>
    </div>
    <div class="form-actions">
        <input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
        <input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
    </div>
</form:form>
</body>
</html>