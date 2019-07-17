<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>全部客户</title>
    <script type="text/javascript">
        function page(n,s){
            debugger;
            if(n) $("#pageNo").val(n);
            if(s) $("#pageSize").val(s);
            $("#searchForm").attr("action","${ctx}/tProduct/stockHistoryList");
            $("#searchForm").submit();
            return false;
        }
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="/tProduct/stockHistoryList">产品生产历史</a></li>
</ul>
<form:form id="searchForm" modelAttribute="prodHistroyVo" action="${ctx}/tProduct/stockHistoryList" method="post"
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
            <th>产品品种</th>
            <th>产品类别</th>
            <th>产品颜色</th>
            <th>产品重量</th>
            <th>产品数量</th>
            <th>生产机台</th>
            <th>产品归属人</th>
            <th>入库时间</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.list}" var="cus">
            <tr>
                <td>${cus.ordCode}</td>
                <td>${fns:getValueByDictKey(cus.prodVariety)}</td>
                <td>${fns:getValueByDictKey(cus.prodCgyCode)}</td>
                <td>${fns:getDictLabel('prod_color',cus.itemColor,'无')}</td>
                <td>${cus.itemTotalWeight}</td>
                <td>${cus.itemNum}</td>
                <td>${cus.macCode}</td>
                <td>${cus.itemOwner}</td>
                <td>${cus.createTime}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="pagination">${page}</div>

</div>
</body>
</html>