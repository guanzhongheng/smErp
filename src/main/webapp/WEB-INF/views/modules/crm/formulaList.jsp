<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>配方列表</title>
    <link rel="stylesheet" href="/static/common/customize.css">
    <script type="text/javascript">
        function page(n,s){
            debugger;
            if(n) $("#pageNo").val(n);
            if(s) $("#pageSize").val(s);
            $("#searchForm").attr("action","${ctx}/crm/formula/list");
            $("#searchForm").submit();
            return false;
        }
    </script>
</head>
<body>

<div class="tabs-container" style="padding: 20px 20px;">
    <div class="panel panel-default" style="border-color: #50B0E6; border-style: solid; border-width: 1px; border-radius:5px 5px 5px 5px;">
        <div class="panel-heading" style="background-color: #50B0E6">
            <h3 class="panel-title global-panel-title" >
                配方列表
            </h3>
        </div>
        <div class="panel-body" style="padding: 10px 10px 0px 10px;">
            <form:form id="searchForm" modelAttribute="formula" action="${ctx}/crm/formula/list" method="post"
                       class="breadcrumb form-search">
                <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
                <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
                <ul class="ul-form">
                    <li>
                        <form:input path="fName" htmlEscape="false" maxlength="20" class="input-medium" placeholder="配方名称"/>
                    </li>
                    <li>
                        &nbsp;&nbsp;
                        <form:select path="prodVariety" class="input-medium" placeholder="产品品种">
                            <form:option value="" label=""/>
                            <form:options items="${fns:getCusDictList(148000)}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                        </form:select>
                    </li>
                    <li>
                        &nbsp;&nbsp;
                        <form:select path="prodCgyCode" class="input-medium" placeholder="产品类别">
                            <form:option value="" label=""/>
                            <form:options items="${fns:getCusDictList(149000)}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                        </form:select>
                    </li>
                    &nbsp;&nbsp;
                    <li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" style="width: 100px" value="查询"/></li>
                    <li class="btns"><a href="/formula/addOrUpdate" class="btn btn-primary" style="width: 100px">新增配方</a></li>
                </ul>
            </form:form>

            <div class="control-group table-responsive">
                <table id="contentTable" class="table table-striped table-bordered table-hover text-nowrap">
                    <thead>
                    <tr>
                        <th style="text-align: center">序号</th>
                        <th style="text-align: center">配方名称</th>
                        <th style="text-align: center">产品品种</th>
                        <th style="text-align: center">产品类别</th>
                        <th style="text-align: center">创建时间</th>
                        <th style="text-align: center">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${page.list}" var="f" varStatus="status">
                        <tr>
                            <td style="text-align: center">${status.index + 1}</td>
                            <td>${f.fName}</td>
                            <td>${fns:getValueByDictKey(f.prodVariety)}</td>
                            <td>${fns:getValueByDictKey(f.prodCgyCode)}</td>
                            <td><fmt:formatDate value="${f.createDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                            <td>
                                <a href="${ctx}/formula/addOrUpdate?fCode=${f.fCode}"><i class="icon-th-list">&nbsp;编辑</i></a>
                                <a href="${ctx}/produce/producePlan/info?prodPlanCode=${pp.prodPlanCode}"><i class="icon-th-list">&nbsp;删除</i></a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="pagination">${page}</div>
            </div>
        </div>
    </div>
</div>
</body>
</html>