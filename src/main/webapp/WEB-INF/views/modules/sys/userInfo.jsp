<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>个人信息</title>
	<link rel="stylesheet" href="/static/common/customize.css">
	<script type="text/javascript">
		$(document).ready(function() {
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>

</head>
<body class="global-font">
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/sys/user/info" class="global-font">个人信息</a></li>
		<li><a href="${ctx}/sys/user/modifyPwd" class="global-font">修改密码</a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="user" action="${ctx}/sys/user/info" method="post" class="form-horizontal"><%--
		<form:hidden path="email" htmlEscape="false" maxlength="255" class="input-xlarge"/>
		<sys:ckfinder input="email" type="files" uploadPath="/mytask" selectMultiple="false"/> --%>
		<sys:message content="${message}"/>
		<%--<div class="control-group">--%>
			<%--<label class="control-label">头像:</label>--%>
			<%--<div class="controls">--%>
				<%--<form:hidden id="nameImage" path="photo" htmlEscape="false" maxlength="255" class="input-xlarge"/>--%>
				<%--<sys:ckfinder input="nameImage" type="images" uploadPath="/photo" selectMultiple="false" maxWidth="100" maxHeight="100"/>--%>
			<%--</div>--%>
		<%--</div>--%>
		<%--<div class="control-group">--%>
			<%--<label class="control-label">归属公司:</label>--%>
			<%--<div class="controls">--%>
				<%--<label class="lbl">${user.company.name}</label>--%>
			<%--</div>--%>
		<%--</div>--%>
		<%--<div class="control-group">--%>
			<%--<label class="control-label">归属部门:</label>--%>
			<%--<div class="controls">--%>
				<%--<label class="lbl">${user.office.name}</label>--%>
			<%--</div>--%>
		<%--</div>--%>

		<div class="panel panel-default" style="border-color: #50B0E6; border-style: solid; border-width: 1px; border-radius:5px 5px 5px 5px;">
			<div class="panel-heading" style="background-color: #50B0E6">
				<h3 class="panel-title global-panel-title" >
					基础信息
				</h3>
			</div>
			<div class="panel-body">
				<div class="control-group"></div>
				<div class="control-group">
					<label class="control-label global-font">姓名:</label>
					<div class="controls global-font">
						<form:input cssClass="global-font" cssStyle="font-size: 18px;" path="name" htmlEscape="false" maxlength="50" class="required" readonly="true"/>

						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					邮箱:&nbsp;&nbsp;&nbsp;&nbsp;<form:input cssStyle="font-size: 18px;" path="email" htmlEscape="false" maxlength="50" class="email"/>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label global-font">电话:</label>
					<div class="controls global-font">
						<form:input cssStyle="font-size: 18px;" path="phone" htmlEscape="false" maxlength="50"/>

					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					手机:&nbsp;&nbsp;&nbsp;&nbsp;<form:input cssStyle="font-size: 18px;" path="mobile" htmlEscape="false" maxlength="50"/>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label global-font" >备注:</label>
					<div class="controls">
						<form:textarea cssStyle="font-size: 18px; width: 538px" path="remarks" htmlEscape="false" rows="3" maxlength="200" class="input-xlarge"/>
					</div>
				</div>
				<div class="global-button-padding">
					<input id="btnSubmit" class="btn btn-primary global-button-style" style="width: 180px;" type="submit" value="保   存"/>
				</div>
			</div>
		</div>

		<div class="panel panel-default" style="border-color: #50B0E6; border-style: solid; border-width: 1px; border-radius:5px 5px 5px 5px; margin-top: 20px">
			<div class="panel-heading" style="background-color: #50B0E6">
				<h3 class="panel-title global-panel-title" >
					用户权限信息
				</h3>
			</div>
			<div class="panel-body">
				<div class="control-group"></div>
				<div class="control-group">
					<label class="control-label global-font">类型:</label>
					<div class="controls global-font">
						<%--<label class="lbl global-font">${fns:getDictLabel(user.userType, 'sys_user_type', '无')}</label>--%>
						<input value="${fns:getDictLabel(user.userType, 'sys_user_type', '无')}"
							   htmlEscape="false" maxlength="50" class="myself-input-readonly" readonly="true"/>

						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						角色:&nbsp;&nbsp;&nbsp;&nbsp;
						<%--<label class="global-font">${user.roleNames}</label>--%>
							<input value="${user.roleNames}"
								   htmlEscape="false" maxlength="50" class="myself-input-readonly" readonly="true"/>

					</div>
				</div>
				<div class="control-group">
					<label class="control-label global-font">时间:</label>
					<div class="controls global-font">
						<label class="lbl global-font">
							<%--<fmt:formatDate value="${user.oldLoginDate}" type="both" dateStyle="full"/>--%>
							<input value="<fmt:formatDate value="${user.oldLoginDate}" pattern="yyyy-MM-dd HH:mm:ss" />"
								   htmlEscape="false" maxlength="50" class="myself-input-readonly" readonly="true"/>

							<%--&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--%>
							<%--上次登录IP:--%>
						<%--<input value="${user.oldLoginIp}"--%>
							   <%--htmlEscape="false" maxlength="50" class="myself-input-readonly" readonly="true"/>--%>
						<%--</label>--%>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label global-font">上次登录IP:</label>
					<div class="controls global-font">
						<label class="lbl global-font">
								<%--<fmt:formatDate value="${user.oldLoginDate}" type="both" dateStyle="full"/>--%>
							<%--<input value="${user.oldLoginDate}" type="date"--%>
								   <%--htmlEscape="false" maxlength="50" class="myself-input-readonly" readonly="true"/>--%>

							<%--&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--%>
							<%--上次登录IP:--%>
							<input value="${user.oldLoginIp}"
								   htmlEscape="false" maxlength="50" class="myself-input-readonly" readonly="true"/>
						</label>
					</div>
				</div>

			</div>
		</div>






		<%--<div class="control-group">--%>
			<%--<label class="control-label">姓名:</label>--%>
			<%--<div class="controls">--%>
				<%--<form:input path="name" htmlEscape="false" maxlength="50" class="required" readonly="true"/>--%>
			<%--</div>--%>
		<%--</div>--%>
		<%--<div class="control-group">--%>
			<%--<label class="control-label">邮箱:</label>--%>
			<%--<div class="controls">--%>
				<%--<form:input path="email" htmlEscape="false" maxlength="50" class="email"/>--%>
			<%--</div>--%>
		<%--</div>--%>
		<%--<div class="control-group">--%>
			<%--<label class="control-label">电话:</label>--%>
			<%--<div class="controls">--%>
				<%--<form:input path="phone" htmlEscape="false" maxlength="50"/>--%>
			<%--</div>--%>
		<%--</div>--%>
		<%--<div class="control-group">--%>
			<%--<label class="control-label">手机:</label>--%>
			<%--<div class="controls">--%>
				<%--<form:input path="mobile" htmlEscape="false" maxlength="50"/>--%>
			<%--</div>--%>
		<%--</div>--%>
		<%--<div class="control-group">--%>
			<%--<label class="control-label">备注:</label>--%>
			<%--<div class="controls">--%>
				<%--<form:textarea path="remarks" htmlEscape="false" rows="3" maxlength="200" class="input-xlarge"/>--%>
			<%--</div>--%>
		<%--</div>--%>
		<%--<div class="control-group">--%>
			<%--<label class="control-label">用户类型:</label>--%>
			<%--<div class="controls">--%>
				<%--<label class="lbl">${fns:getDictLabel(user.userType, 'sys_user_type', '无')}</label>--%>
			<%--</div>--%>
		<%--</div>--%>
		<%--<div class="control-group">--%>
			<%--<label class="control-label">用户角色:</label>--%>
			<%--<div class="controls">--%>
				<%--<label class="lbl">${user.roleNames}</label>--%>
			<%--</div>--%>
		<%--</div>--%>
		<%--<div class="control-group">--%>
			<%--<label class="control-label">上次登录:</label>--%>
			<%--<div class="controls">--%>
				<%--<label class="lbl">IP: ${user.oldLoginIp}&nbsp;&nbsp;&nbsp;&nbsp;时间：<fmt:formatDate value="${user.oldLoginDate}" type="both" dateStyle="full"/></label>--%>
			<%--</div>--%>
		<%--</div>--%>

	</form:form>
</body>
</html>