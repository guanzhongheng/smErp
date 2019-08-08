]<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>角色管理</title>
	<link rel="stylesheet" href="/static/common/customize.css">

</head>
<body>
	<%--<ul class="nav nav-tabs">--%>
		<%--<li class="active"><a href="${ctx}/sys/role/">角色列表</a></li>--%>
		<%--<li><a href="${ctx}/sys/role/form">角色新增</a></li>--%>
	<%--</ul>--%>


	<div class="tabs-container" style="padding: 20px 20px;">
		<div class="panel panel-default" style="border-color: #50B0E6; border-style: solid; border-width: 1px; border-radius:5px 5px 5px 5px;">
			<div class="panel-heading" style="background-color: #50B0E6">
				<h3 class="panel-title global-panel-title" >
					角色列表
				</h3>
			</div>
			<div class="panel-body" style="padding: 10px 10px 0px 10px;">
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
									<a href="${ctx}/sys/role/form?id=${role.id}"><i class="icon-pencil">&nbsp;修改</i></a>
									<a href="${ctx}/sys/role/delete?id=${role.id}" onclick="return confirmx('确认要删除该角色吗？', this.href)"><i class="icon-trash">&nbsp;删除</i></a>
								</td>
							</tr>
						</c:forEach>
					</table>
					<div class="global-button-padding">
						<%--<input  class="btn btn-success global-button-style" style="width: 180px;" type="submit" value="添加新菜单" onclick="updateSort();"/>--%>
						<a href="${ctx}/sys/role/form" type="button" class="btn btn-primary global-button-style" style="width: 180px;height: 30px;line-height: 29px;">添加新角色</a>
					</div>
				</div>
			</div>
		</div>
	</div>






</body>
</html>