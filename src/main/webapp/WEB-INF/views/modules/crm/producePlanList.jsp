<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>生产计划表</title>
    <link rel="stylesheet" href="/static/common/customize.css">
    <script type="text/javascript">
        function page(n,s){

            if(n) $("#pageNo").val(n);
            if(s) $("#pageSize").val(s);
            $("#searchForm").attr("action","${ctx}/crm/producePlan/list");
            $("#searchForm").submit();
            return false;
        }
    </script>
</head>
<body>
<%--<ul class="nav nav-tabs">--%>
    <%--<li class="active"><a href="#">待生产计划</a></li>--%>
<%--</ul>--%>



<div class="tabs-container" style="padding: 20px 20px;">
    <div class="panel panel-default" style="border-color: #50B0E6; border-style: solid; border-width: 1px; border-radius:5px 5px 5px 5px;">
        <div class="panel-heading" style="background-color: #50B0E6">
            <h3 class="panel-title global-panel-title" >
                待生产计划列表
            </h3>
        </div>
        <div class="panel-body" style="padding: 10px 10px 0px 10px;">
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
                    <li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" style="width: 80px" value="查询"/></li>
                    &nbsp;&nbsp;
                    <li class="btns"><input class="btn btn-primary" type="button" style="width: 80px" onclick="prodFormReset()" value="重置"/></li>
                </ul>
            </form:form>

            <div class="control-group table-responsive">
                <table id="contentTable" class="table table-striped table-bordered table-hover text-nowrap">
                    <thead>
                    <tr>
                        <th style="text-align: center">序号</th>
                        <th style="text-align: center">品种</th>
                        <th style="text-align: center">类别</th>
                        <th style="text-align: center">机台</th>
                        <th style="text-align: center">颜色</th>
                        <th style="text-align: center">总数量</th>
                        <th style="text-align: center">已下发生产数量</th>
                        <th style="text-align: center">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${page.list}" var="pp" varStatus="status">
                        <tr>
                            <td style="text-align: center">${status.index + 1}</td>
                            <td>${fns:getValueByDictKey(pp.prodVariety)}</td>
                            <td>${fns:getValueByDictKey(pp.prodCgyCode)}</td>
                            <td>${pp.macCode}</td>
                            <td>${fns:getDictValue(pp.prodColor, 'prod_color', defaultValue)}</td>
                            <td>${pp.totalQuantity}</td>
                            <td>${pp.quantity}</td>
                            <td><a href="${ctx}/produce/producePlan/info?prodPlanCode=${pp.prodPlanCode}"><i class="icon-th-list">&nbsp;详情</i></a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="pagination">${page}</div>

            </div>
        </div>
    </div>
</div>

<script>
function prodFormReset() {
    $("#prodVariety").val("").select2();
    $("#prodCgyCode").val("").select2();
    $("#prodColor").val("").select2();
    $("#macCode").val("").select2();
}
</script>





</body>
</html>