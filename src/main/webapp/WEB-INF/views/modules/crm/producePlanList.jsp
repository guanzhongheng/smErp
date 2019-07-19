<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>生产计划表</title>
    <script type="text/javascript">
        function page(n,s){
            debugger;
            if(n) $("#pageNo").val(n);
            if(s) $("#pageSize").val(s);
            $("#searchForm").attr("action","${ctx}/crm/producePlan/list");
            $("#searchForm").submit();
            return false;
        }
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active">当前生产计划</li>
</ul>
<form:form id="searchForm" modelAttribute="vo" action="${ctx}/crm/producePlan/list" method="post"
           class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <ul class="ul-form">
        <li>
            &nbsp;&nbsp;
            <form:select path="prodVariety" class="input-medium" placeholder="品种">
                <form:option value="" label=""/>
                <form:options items="${fns:getCusDictList(148000)}" itemLabel="label" itemValue="value" htmlEscape="false"/>
            </form:select>
        </li>
        <li>
            &nbsp;&nbsp;
            <form:select path="prodCgyCode" class="input-medium" placeholder="类别">
                <form:option value="" label=""/>
                <form:options items="${fns:getCusDictList(149000)}" itemLabel="label" itemValue="value" htmlEscape="false"/>
            </form:select>
        </li>
        <li>
            &nbsp;&nbsp;
            <form:select path="prodColor" class="input-medium" placeholder="颜色">
                <form:option value="" label=""/>
                <form:options items="${fns:getDictList('prod_color')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
            </form:select>
        </li>
        <li>
            &nbsp;&nbsp;
            <form:select path="macCode" class="input-medium" placeholder="机台">
                <form:option value="" label=""/>
                <form:options items="${macList}" itemLabel="macCode" itemValue="macCode" htmlEscape="false"/>
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
            <th>品种</th>
            <th>类别</th>
            <th>机台</th>
            <th>颜色</th>
            <th>总数量</th>
            <th>已下发生产数量</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.list}" var="pp">
            <tr>
                <td>${fns:getValueByDictKey(pp.prodVariety)}</td>
                <td>${fns:getValueByDictKey(pp.prodCgyCode)}</td>
                <td>${pp.macCode}</td>
                <td>${fns:getDictValue(pp.prodColor, 'prod_color', defaultValue)}</td>
                <td>${pp.totalQuantity}</td>
                <td>${pp.quantity}</td>
                <td><a href="${ctx}/produce/producePlan/info?prodPlanCode=${pp.prodPlanCode}"><i class="icon-pencil">&nbsp;详情</i></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="pagination">${page}</div>

    <script>


    </script>
</div>
</body>
</html>