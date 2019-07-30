]<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>角色管理</title>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/sys/role/">角色列表</a></li>
		<li><a href="${ctx}/sys/role/form">角色添加</a></li>
	</ul>
	<sys:message content="${message}"/>
	<div class="control-group table-responsive">
	<table id="contentTable" class="table table-striped table-bordered  table-hover text-nowrap ">
		<tr>
			<th style="text-align: center">序号</th>
			<th>角色名称</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${list}" var="role" varStatus="status">
			<tr>

				<td style="text-align: center">${status.index + 1}</td>
				<td><a href="form?id=${role.id}">${role.name}</a></td>
				<%--<td><a href="form?id=${role.id}">${role.enname}</a></td>--%>
				<%--<td>${role.office.name}</td>--%>
				<td>
					<%--<a href="${ctx}/sys/role/assign?id=${role.id}">分配</a>--%>
					<a href="${ctx}/sys/role/form?id=${role.id}">修改</a>
					<a href="${ctx}/sys/role/delete?id=${role.id}" onclick="return confirmx('确认要删除该角色吗？', this.href)">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>