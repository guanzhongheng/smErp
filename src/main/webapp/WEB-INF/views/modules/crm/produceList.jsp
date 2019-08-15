<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>产品生产表</title>
    <link href="${ctxStatic}/hPlugs/css/plugins/bootstrap-table/bootstrap-table.css" rel="stylesheet">
    <link href="${ctxStatic}/hPlugs/css/plugins/bootstrap-table/bootstrap-table-fixed-columns.css" rel="stylesheet">
    <link rel="stylesheet" href="/static/common/customize.css">
    <script type="text/javascript">
        function page(n,s){

            if(n) $("#pageNo").val(n);
            if(s) $("#pageSize").val(s);
            $("#searchForm").attr("action","${ctx}/crm/produce/list");
            $("#searchForm").submit();
            return false;
        }
    </script>
</head>
<body>
<%--<ul class="nav nav-tabs">--%>
    <%--<li class="active"><a href="#">生产任务</a></li>--%>
<%--</ul>--%>




<div class="tabs-container" style="padding: 20px 20px;">
    <div class="panel panel-default" style="border-color: #50B0E6; border-style: solid; border-width: 1px; border-radius:5px 5px 5px 5px;">
        <div class="panel-heading" style="background-color: #50B0E6">
            <h3 class="panel-title global-panel-title" >
                生产任务
            </h3>
        </div>
        <div class="panel-body" style="padding: 10px 10px 0px 10px;">

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
                    <li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" style="width: 80px" value="查询"/></li>
                    &nbsp;&nbsp;
                    <li class="btns"><input class="btn btn-primary" type="button" style="width: 80px" onclick="produceFormReset()" value="重置"/></li>
                </ul>
            </form:form>
            <div class="control-group  table-responsive">
                <table id="contentTable" class="table table-striped table-bordered table-hover text-nowrap">
                    <thead>
                    <tr>
                        <th style="text-align: center">订单标题</th>
                        <th style="text-align: center">所属人</th>
                        <th style="text-align: center">机台编号</th>
                        <th style="text-align: center">品种</th>
                        <th style="text-align: center">类别</th>
                        <th style="text-align: center">颜色</th>
                        <th style="text-align: center">长度(m)</th>
                        <th style="text-align: center">宽度(m)</th>
                        <th style="text-align: center">厚度(mm)</th>
                        <th style="text-align: center">数量</th>
                        <th style="text-align: center">重量</th>
                        <th style="text-align: center">面积(㎡)</th>
                        <th style="text-align: center">压边类型</th>
                        <th style="text-align: center">延长米计算方式</th>
                        <th style="text-align: center">状态</th>
                        <th style="text-align: center">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${page.list}" var="vo">
                        <tr>
                            <td>${vo.orderTitle}</td>
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
                            <td>${fns:getDictValue(vo.itemYbType, 'prod_ybType', defaultValue)}</td>
                            <td>${fns:getDictValue(vo.itemYcType, 'prod_ycType', defaultValue)}</td>
                            <td>
                                <c:if test="${vo.itemStatus eq '48'}">待确认</c:if>
                                <c:if test="${vo.itemStatus eq '49'}">下发生产</c:if>
                                <c:if test="${vo.itemStatus eq '50'}">已完成</c:if>
                            </td>
                            <td>
                                <c:if test="${vo.itemNum ne 0}">
                                    <a href="${ctx}/produce/produce/info?id=${vo.prodPlanDetailId}"><i class="icon-wrench">&nbsp;生产</i></a>
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
        </div>
    </div>
</div>
<script>
    function produceFormReset() {
        $("#itemVariety").val("").select2();
        $("#itemCgyCode").val("").select2();
        $("#itemColor").val("").select2();
        $("#macCode").val("").select2();
    }
</script>




</body>
</html>