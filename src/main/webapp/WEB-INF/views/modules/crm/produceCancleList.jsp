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
            $("#searchForm").attr("action","${ctx}/crm/produceCancle/list");
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
                生产任务管理
            </h3>
        </div>
        <div class="panel-body" style="padding: 10px 10px 0px 10px;">

            <form:form id="searchForm" modelAttribute="vo" action="${ctx}/crm/produceCancle/list" method="post"
                       class="breadcrumb form-search">
                <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
                <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
                <ul class="ul-form">
                    <li>
                        <form:input path="orderTitle" htmlEscape="false" maxlength="200" cssStyle="width: 120px;"
                                    class="input-medium" placeholder="订单标题"/>
                    </li>
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
                </ul>
                <ul class="ul-form">
                    <li>
                        <input id="startLength" name="startLength" style="width: 100px;" placeholder="起始宽度" class="input-medium" type="number" value="${vo.startLength}" min="0" step="0.01">
                        ~
                        <input id="endLength" name="endLength" style="width: 100px;" placeholder="结束宽度" class="input-medium" type="number" value="${vo.endLength}" min="0" step="0.01">

                    </li>
                    <li>
                        &nbsp;&nbsp;
                        <input id="ordSort" name="ordSort" type="checkbox" value="1" ${vo.ordSort == 1?"checked":""}/>宽度倒序
                    </li>
                    &nbsp;&nbsp;
                    <li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" style="width: 80px" value="查询"/></li>
                    &nbsp;&nbsp;
                    <li class="btns"><input class="btn btn-primary" type="button" style="width: 80px" onclick="produceFormReset()" value="重置"/></li>
                    &nbsp;&nbsp;
                    <li class="btns"><input class="btn btn-primary" type="button" style="width: 94px" onclick="doPrcoessList()" value="批量撤销"/></li>
                </ul>
            </form:form>
            <div class="control-group  table-responsive">
                <table id="contentTable" class="table table-striped table-bordered table-hover text-nowrap">
                    <thead>
                    <tr>
                        <th style="width: 10px;"><input type="checkbox" id="ProdcheckAll"
                                                              onchange="checkedAll(this)"/></th>
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
                        <th style="text-align: center">理论重量(kg)</th>
                        <%--<th style="text-align: center">重量</th>--%>
                        <%--<th style="text-align: center">面积(㎡)</th>--%>
                        <th style="text-align: center">压边类型</th>
                        <%--<th style="text-align: center">延长米计算方式</th>--%>
                        <th style="text-align: center">状态</th>
                        <th style="text-align: center">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${page.list}" var="vo">
                        <tr>
                            <td style="text-align: center">
                                <input type="checkbox" name="ProdDetailId" value="${vo.prodPlanDetailId}">
                            </td>
                            <td>${vo.orderTitle}</td>
                            <td>${vo.itemOwner}</td>
                            <td>${vo.macCode}</td>
                            <td>${fns:getValueByDictKey(vo.itemVariety)}</td>
                            <td>${fns:getValueByDictKey(vo.itemCgyCode)}</td>
                            <td>${fns:getDictValue(vo.itemColor, 'prod_color', defaultValue)}</td>
                            <td>${vo.itemLenth}</td>
                            <td><span style="color: #00a2d4">${vo.itemWidth}</span></td>
                            <td>${vo.itemThick}</td>
                            <td>${vo.itemNum}</td>
                            <td>${vo.theoryWeight}</td>
                            <%--<td>${vo.itemTotalWeight}</td>--%>
                            <%--<td>${vo.itemTotalSq}</td>--%>
                            <td>${fns:getDictValue(vo.itemYbType, 'prod_ybType', defaultValue)}</td>
                            <%--<td>${fns:getDictValue(vo.itemYcType, 'prod_ycType', defaultValue)}</td>--%>
                            <td>
                                <c:if test="${vo.itemStatus eq '48'}">待确认</c:if>
                                <c:if test="${vo.itemStatus eq '49'}">下发生产</c:if>
                                <c:if test="${vo.itemStatus eq '50'}">已完成</c:if>
                            </td>
                            <td>
                                <c:if test="${vo.itemNum ne 0}">
                                    <a href="${ctx}/produce/produce/cancle?id=${vo.prodPlanDetailId}"
                                       onclick="return confirmx('确认撤销生产任务？', this.href)"
                                    ><i class="icon-wrench">&nbsp;撤销</i></a>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td>总计:</td>
                        <td colspan="9"></td>
                        <td colspan="4">理论总重量:${theoryTotalWeight}</td>
                    </tr>
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
        $("#orderTitle").val("");
        $("#startLength").val("");
        $("#endLength").val("");
        $("#itemVariety").val("").select2();
        $("#itemCgyCode").val("").select2();
        $("#itemColor").val("").select2();
        $("#macCode").val("").select2();
    }

    function checkedAll(obj) {
        var codes = document.getElementsByName("ProdDetailId")
        if (obj.checked) {
            for (var i = 0; i < codes.length; i++) {
                codes[i].checked = true;
            }
        } else {
            for (var i = 0; i < codes.length; i++) {
                codes[i].checked = false;
            }
        }
    }

    function getCheckAllValue() {
        var obj = document.getElementsByName("ProdDetailId");
        var check_val = '';
        for (k in obj) {
            if (obj[k].checked)
                check_val = check_val + obj[k].value + ",";
        }
        check_val = check_val.replace(",,", ",");
        return check_val;
    }

    function doPrcoessList(obj) {
        // 获取批量处理的ID信息
        var str = getCheckAllValue();
        window.location.href = "/produce/produce/cancleList?ids="+str;
    }
    
</script>




</body>
</html>