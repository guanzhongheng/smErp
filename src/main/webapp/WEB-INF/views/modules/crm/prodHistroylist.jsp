<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>全部客户</title>
    <script type="text/javascript">
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/tProduct/histroyList">产品历史</a></li>
</ul>
<form:form id="searchForm" modelAttribute="prodHistroyVo" action="${ctx}/tProduct/histroyList" method="post"
           class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <ul class="ul-form">
        <li>
            <form:input path="ordCode" htmlEscape="false" maxlength="200"
                        class="input-medium" placeholder="订单编号"/>
        </li>
        <li>
            &nbsp;&nbsp;
            <form:input path="prodName" htmlEscape="false" maxlength="200" class="input-medium" placeholder="产品名称"/>
        </li>
        <li>
            &nbsp;&nbsp;
            <input id="startDate" name="startDate" placeholder="入库开始时间" type="text" readonly="readonly" maxlength="20"
                   class="input-small Wdate"
                   value="" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
            ～
            <input id="endDate" name="endDate" placeholder="入库结束时间" type="text" readonly="readonly" maxlength="20"
                   class="input-small Wdate"
                   value="" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
        </li>
        &nbsp;&nbsp;
        <li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
    </ul>
</form:form>
<div class="control-group">
    <table id="contentTable" class="table table-striped table-bordered table-condensed">
        <thead>
        <tr>
            <th>订单编号</th>
            <th>产品名称</th>
            <th>产品类别</th>
            <th>产品品种</th>
            <th>产品颜色</th>
            <th>生产机台</th>
            <th>入库时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.list}" var="cus">
            <tr>
                <td>${cus.contCode}</td>
                <td>${cus.prodName}</td>
                <td>${fns:getValueByDictKey(cus.prodCgyCode)}</td>
                <td>${fns:getValueByDictKey(cus.prodVariety)}</td>
                <td>${cus.itemColor}</td>
                <td>${cus.createTime}</td>
                <td>
                    <a href="#"><i class="icon-pencil">&nbsp;详情</i></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="pagination">${page}</div>

</div>
</body>
</html>