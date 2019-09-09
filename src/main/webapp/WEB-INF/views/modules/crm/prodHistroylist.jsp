<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>全部客户</title>
    <link rel="stylesheet" href="/static/common/customize.css">

    <script type="text/javascript">
        function page(n,s){

            if(n) $("#pageNo").val(n);
            if(s) $("#pageSize").val(s);
            $("#searchForm").attr("action","${ctx}/tProduct/histroyList");
            $("#searchForm").submit();
            return false;
        }
    </script>
</head>
<body>
<%--<ul class="nav nav-tabs">--%>
    <%--<li class="active"><a href="${ctx}/tProduct/histroyList">产品历史</a></li>--%>
<%--</ul>--%>

<div class="tabs-container" style="padding: 20px 20px;">
    <div class="panel panel-default" style="border-color: #50B0E6; border-style: solid; border-width: 1px; border-radius:5px 5px 5px 5px;">
        <div class="panel-heading" style="background-color: #50B0E6">
            <h3 class="panel-title global-panel-title" >
                产品历史
            </h3>
        </div>
        <div class="panel-body" style="padding: 10px 10px 0px 10px;">
            <form:form id="searchForm" modelAttribute="prodHistroyVo" action="${ctx}/tProduct/histroyList" method="post"
                       class="breadcrumb form-search">
                <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
                <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
                <ul class="ul-form">
                    <li>
                        <form:input path="orderTitle" htmlEscape="false" maxlength="200" cssStyle="width: 130px;"
                                    class="input-medium" placeholder="订单标题"/>
                    </li>
                    <li>
                        &nbsp;&nbsp;
                        <form:select path="itemCgyCode" class="input-medium" placeholder="产品类型" cssStyle="width: 130px;">
                            <form:option value="" label=""/>
                            <form:options items="${fns:getCusDictList(149000)}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                        </form:select>
                    </li>
                    <li>
                        &nbsp;&nbsp;
                        <form:select path="itemVariety" class="input-medium" placeholder="产品品种" cssStyle="width: 130px;">
                            <form:option value="" label=""/>
                            <form:options items="${fns:getCusDictList(148000)}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                        </form:select>
                    </li>
                    <li>
                        &nbsp;&nbsp;
                        <form:input path="startDate" htmlEscape="false" readonly="readonly" class="input-small Wdate" cssStyle="width: 195px;"
                                    placeholder="开始时间" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
                        ～
                        <form:input path="endDate" htmlEscape="false" readonly="readonly" class="input-small Wdate" cssStyle="width: 195px;"
                                    placeholder="开始时间" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
                    </li>
                    <li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" style="width: 70px" value="查询"/></li>
                    <li class="btns"><input class="btn btn-primary" type="button" style="width: 70px" onclick="histFormReset()" value="重置"/></li>
                </ul>
            </form:form>
            <div class="control-group table-responsive">
                <table id="contentTable" class="table table-striped table-bordered table-hover text-nowrap">
                    <thead>
                    <tr>
                        <th style="text-align: center">序号</th>
                        <th style="text-align: center">订单标题</th>
                        <th style="text-align: center">产品品种</th>
                        <th style="text-align: center">产品类别</th>
                        <th style="text-align: center">产品颜色</th>
                        <th style="text-align: center">产品重量</th>
                        <th style="text-align: center">产品数量</th>
                        <th style="text-align: center">生产机台</th>
                        <th style="text-align: center">产品归属人</th>
                        <th style="text-align: center">入库时间</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${page.list}" var="cus" varStatus="status">
                        <tr>
                            <td style="text-align: center">${status.index + 1}</td>
                            <td>${cus.orderTitle}</td>
                            <td>${fns:getValueByDictKey(cus.itemVariety)}</td>
                            <td>${fns:getValueByDictKey(cus.itemCgyCode)}</td>
                            <td>${fns:getDictLabel(cus.itemColor,'prod_color','无')}</td>
                            <td>${cus.itemTotalWeight}</td>
                            <td>${cus.itemNum}</td>
                            <td>${cus.macCode}</td>
                            <td>${cus.itemOwner}</td>
                            <td><fmt:formatDate value="${cus.createTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
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
    function histFormReset() {
        $("#ordCode").val("");
        $("#startDate").val("");
        $("#endDate").val("");
        $("#itemCgyCode").val("").select2();
        $("#itemVariety").val("").select2();
    }
</script>






</body>
</html>