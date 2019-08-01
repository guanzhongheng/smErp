<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>字典管理</title>
    <link rel="stylesheet" href="/static/common/customize.css">
    <script type="text/javascript">
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
	    	return false;
	    }
	</script>
</head>
<body>
	<%--<ul class="nav nav-tabs">--%>
		<%--<li class="active"><a href="${ctx}/sys/dict/">字典列表</a></li>--%>
		<%--<li><a href="${ctx}/sys/dict/form?sort=10">字典添加</a></li>--%>
	<%--</ul>--%>




    <div class="tabs-container" style="padding: 20px 20px;">
        <div class="panel panel-default" style="border-color: #50B0E6; border-style: solid; border-width: 1px; border-radius:5px 5px 5px 5px;">
            <div class="panel-heading" style="background-color: #50B0E6">
                <h3 class="panel-title global-panel-title" >
                    字典列表
                </h3>
            </div>
            <div class="panel-body" style="padding: 10px 10px 0px 10px;">

                <form:form id="searchForm" modelAttribute="dict" action="${ctx}/sys/dict/" method="post" class="breadcrumb form-search">
                    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
                    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
                    <label>类型：</label><form:select id="type" path="type" class="input-medium" cssStyle="width: 200px"><form:option value="" label=""/><form:options items="${typeList}" htmlEscape="false"/></form:select>
                    &nbsp;&nbsp;<label>描述 ：</label><form:input path="description" htmlEscape="false" maxlength="50" class="input-medium"/>
                    &nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit" style="width: 100px" value="查询"/>
                </form:form>
                <sys:message content="${message}"/>
                <div class="control-group table-responsive">
                    <table id="contentTable" class="table table-striped table-bordered  table-hover text-nowrap">
                        <thead>
                        <tr>
                            <th style="text-align: center">键值</th>
                            <th style="text-align: center">标签</th>
                            <th style="text-align: center">类型</th>
                            <th style="text-align: center">描述</th>
                            <th style="text-align: center">排序</th>
                            <th style="text-align: center">操作</th>
                        </tr></thead>
                        <tbody>
                        <c:forEach items="${page.list}" var="dict">
                            <tr>
                                <td>${dict.value}</td>
                                <td><a href="${ctx}/sys/dict/form?id=${dict.id}">${dict.label}</a></td>
                                <td><a href="javascript:" onclick="$('#type').val('${dict.type}');$('#searchForm').submit();return false;">${dict.type}</a></td>
                                <td>${dict.description}</td>
                                <td>${dict.sort}</td>
                                <td>
                                    <a href="${ctx}/sys/dict/form?id=${dict.id}"><i class="icon-pencil">&nbsp;修改</i></a>
                                    <a href="${ctx}/sys/dict/delete?id=${dict.id}&type=${dict.type}" onclick="return confirmx('确认要删除该字典吗？', this.href)"><i class="icon-trash">&nbsp;删除</i></a>
                                    <a href="<c:url value='${ctx}/sys/dict/form?type=${dict.type}&sort=${dict.sort+10}'><c:param name='description' value='${dict.description}'/></c:url>"><i class="icon-plus">&nbsp;添加键值</i></a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <div class="pagination">${page}</div>

                    <div class="global-button-padding">
                        <%--<input  class="btn btn-success global-button-style" style="width: 180px;" type="submit" value="添加新菜单" onclick="updateSort();"/>--%>
                        <a href="${ctx}/sys/dict/form?sort=10" type="button" class="btn btn-primary global-button-style" style="width: 180px;height: 30px;line-height: 29px;">添加新字典</a>
                    </div>
                </div>
            </div>
        </div>
    </div>







</body>
</html>