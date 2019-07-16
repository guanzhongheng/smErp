<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>库存列表</title>
    <script type="text/javascript">
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/crm/inventory/list/">库存列表</a></li>
    <%--<li><a href="${ctx}/crm/inventory/info/">出库清单</a></li>--%>
</ul>
<form:form id="searchForm" modelAttribute="stockQueryVo" action="${ctx}/crm/inventory/list" method="post"
           class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <ul class="ul-form">
        <li>
            <form:input path="ordCode" htmlEscape="false" maxlength="200" class="input-medium" placeholder="订单编号"/>
        </li>
        <li>
        &nbsp;&nbsp;
        <form:select path="itemCgyCode" class="input-medium" placeholder="产品类型">
            <form:option value="" label=""/>
            <form:options items="${fns:getCusDictList(149000)}" itemLabel="label" itemValue="value" htmlEscape="false"/>
        </form:select>
        </li>
        <li>
            &nbsp;&nbsp;
            <form:select path="itemVariety" class="input-medium" placeholder="产品品种">
                <form:option value="" label=""/>
                <form:options items="${fns:getCusDictList(148000)}" itemLabel="label" itemValue="value" htmlEscape="false"/>
            </form:select>
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
            <th>条形码号</th>
            <th>归属人</th>
            <th>产品类别</th>
            <th>产品品种</th>
            <th>产品颜色</th>
            <th>长</th>
            <th>宽</th>
            <th>厚</th>
            <th>重量</th>
            <th>压边类型</th>
            <th>计价方式</th>
            <th>单价</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.list}" var="cus">
            <tr>
                <td>${cus.ordCode}</td>
                <td>${cus.barCode}</td>
                <td>${cus.itemOwner}</td>
                <td>${fns:getValueByDictKey(cus.prodCgyCode)}</td>
                <td>${fns:getValueByDictKey(cus.prodVariety)}</td>
                <td>${fns:getDictLabel('prod_color',cus.itemColor,'无')}</td>
                <td>${cus.itemLenth}</td>
                <td>${cus.itemWidth}</td>
                <td>${cus.itemThick}</td>
                <td>${cus.itemWeight}</td>
                <td>${fns:getDictLabel('prod_ybType',cus.itemYbType,'无')}</td>
                <td>${fns:getDictLabel('prod_ycType',cus.itemYcType,'无')}</td>
                <td>${cus.itemUnit}</td>
                <td><a href="#">补签</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="pagination">${page}</div>


</div>
</body>
</html>