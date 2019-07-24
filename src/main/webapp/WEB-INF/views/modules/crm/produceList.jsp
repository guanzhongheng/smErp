<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>产品生产表</title>
    <script type="text/javascript">
        function page(n,s){
            debugger;
            if(n) $("#pageNo").val(n);
            if(s) $("#pageSize").val(s);
            $("#searchForm").attr("action","${ctx}/crm/produce/list");
            $("#searchForm").submit();
            return false;
        }
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="#">生产任务</a></li>
</ul>
<form:form id="searchForm" modelAttribute="vo" action="${ctx}/crm/produce/list" method="post"
           class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <ul class="ul-form">
        <li>
            &nbsp;&nbsp;
            <form:select path="itemVariety" class="input-medium" placeholder="品种">
                <form:option value="" label=""/>
                <form:options items="${fns:getCusDictList(148000)}" itemLabel="label" itemValue="value" htmlEscape="false"/>
            </form:select>
        </li>
        <li>
            &nbsp;&nbsp;
            <form:select path="itemCgyCode" class="input-medium" placeholder="类别">
                <form:option value="" label=""/>
                <form:options items="${fns:getCusDictList(149000)}" itemLabel="label" itemValue="value" htmlEscape="false"/>
            </form:select>
        </li>
        <li>
            &nbsp;&nbsp;
            <form:select path="itemColor" class="input-medium" placeholder="颜色">
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
<div class="control-group" style="overflow-x: auto; overflow-y: auto;">
        <table id="contentTable" class="table table-striped table-bordered table-condensed" style=" table-layout: fixed;">
            <thead>
            <tr>
                <th style="width: 150px">订单号</th>
                <th style="width: 150px">产品编号</th>
                <th style="width: 60px">所属人</th>
                <th style="width: 80px">机台编号</th>
                <th style="width: 80px">品种</th>
                <th style="width: 80px">类别</th>
                <th style="width: 60px">颜色</th>
                <th style="width: 60px">长度(m)</th>
                <th style="width: 60px">宽度(m)</th>
                <th style="width: 60px">厚度(m)</th>
                <th style="width: 60px">数量</th>
                <th style="width: 60px">重量</th>
                <th style="width: 60px">面积(㎡)</th>
                <th style="width: 80px">压边类型</th>
                <th style="width: 100px">延长米计算方式</th>
                <th style="width: 50px">状态</th>
                <th style="width: 50px">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${page.list}" var="vo">
                <tr>
                    <td>${vo.ordCode}</td>
                    <td>${vo.itemCode}</td>
                    <td>${vo.itemOwner}</td>
                    <td>${vo.macCode}</td>
                    <td>${fns:getValueByDictKey(vo.itemVariety)}</td>
                    <td>${fns:getValueByDictKey(vo.itemCgyCode)}</td>
                    <td>${fns:getDictValue(vo.itemColor, 'prod_color', defaultValue)}</td>
                    <td>${vo.itemLenth}</td>
                    <td>${vo.itemWidth}</td>
                    <td>${vo.itemThick}</td>
                    <td>${vo.itemNum}</td>
                    <td>${vo.itemTotalWeight}</td>
                    <td>${vo.itemTotalSq}</td>
                    <td>${fns:getValueByDictKey(vo.itemYbType)}</td>
                    <td>${fns:getValueByDictKey(vo.itemYcType)}</td>
                    <td>
                        <c:if test="${vo.itemStatus eq '48'}">待确认</c:if>
                        <c:if test="${vo.itemStatus eq '49'}">下发生产</c:if>
                        <c:if test="${vo.itemStatus eq '50'}">已完成</c:if>
                    </td>
                    <td>
                        <c:if test="${vo.itemNum ne 0}">
                            <a href="${ctx}/produce/produce/info?id=${vo.prodPlanDetailId}"><i class="icon-pencil">&nbsp;生产</i></a>
                        </c:if>
                    </td>
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