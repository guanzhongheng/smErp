<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
    <title>设备管理</title>
    <link rel="stylesheet" href="/static/common/customize.css">
    <script type="text/javascript">
        function page(n,s){
            if(n) $("#pageNo").val(n);
            if(s) $("#pageSize").val(s);
            $("#searchForm").attr("action","${ctx}/equipment/list");
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
                设备列表
            </h3>
        </div>
        <div class="panel-body" style="padding: 10px 10px 0px 10px;">
            <form:form id="searchForm" modelAttribute="equipment" action="${ctx}/equipment/list" method="post" class="breadcrumb form-search ">
                <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
                <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
                <ul class="ul-form">
                    <li>&nbsp;&nbsp;<form:input path="macName" htmlEscape="false" maxlength="50" class="input-medium" placeholder="设备名称"/></li>
                    <li>&nbsp;&nbsp;<form:input path="macAddress" htmlEscape="false" maxlength="50" class="input-medium" placeholder="设备MAC地址"/></li>

                    <li class="btns">
                        <input id="btnSubmit" class="btn btn-primary" type="submit" style="width: 80px" value="查询" onclick="return page();"/>
                    <li class="btns">
                        <a href="${ctx}/equipment/addForm" type="button" class="btn btn-primary" style="width: 54px;height: 20px">新增</a>
                    </li>
                    <li class="btns"><input class="btn btn-primary" type="button" style="width: 80px" onclick="macListReset()" value="重置"/></li>
                </ul>
            </form:form>
            <sys:message content="${message}"/>
            <div class="control-group table-responsive">
                <table id="contentTable" class="table table-striped table-bordered table-hover text-nowrap">
                    <thead>
                    <tr>
                        <th style="text-align: center">序号</th>
                        <th style="text-align: center">设备名称</th>
                        <th style="text-align: center">设备IP地址</th>
                        <th style="text-align: center">是否启用</th>
                        <th style="text-align: center">创建时间</th>
                        <th style="text-align: center">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${page.list}" var="equ" varStatus="status">
                        <tr>
                            <td style="text-align: center">${status.index + 1}</td>
                            <td>${equ.macName}</td>
                            <td>${equ.macAddress}</td>
                            <td>${equ.devSwitch=='0'?"启用":"不启用"}</td>
                            <td><fmt:formatDate value="${equ.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                            <td>
                                <a href="${ctx}/equipment/get?eqId=${equ.eqId}"><i class="icon-pencil">&nbsp;修改</i></a>
                                <a href="${ctx}/equipment/delete?eqId=${equ.eqId}" onclick="return confirmx('确认要删除该设备吗？', this.href)"><i class="icon-trash">&nbsp;删除</i></a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="pagination">${page}</div>
        </div>
    </div>
</div>
<script>
    function macListReset() {
        $("#macAddress").val("");
        $("#macName").val("");
    }
</script>
</body>
</html>