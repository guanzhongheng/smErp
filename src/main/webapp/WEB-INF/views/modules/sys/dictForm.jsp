<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>字典管理</title>
	<link rel="stylesheet" href="/static/common/customize.css">
	<script type="text/javascript">
		$(document).ready(function() {
			$("#value").focus();
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
<body>
	<%--<ul class="nav nav-tabs">--%>
		<%--<li><a href="${ctx}/sys/dict/">字典列表</a></li>--%>
		<%--<li class="active"><a href="${ctx}/sys/dict/form?id=${dict.id}">字典管理</a></li>--%>
	<%--</ul><br/>--%>



	<div class="tabs-container" style="padding: 20px 20px;">
		<div class="panel panel-default" style="border-color: #50B0E6; border-style: solid; border-width: 1px; border-radius:5px 5px 5px 5px;">
			<div class="panel-heading" style="background-color: #50B0E6">
				<h3 class="panel-title global-panel-title" >
					<c:if test="${empty dict.id}">字典添加</c:if>
					<c:if test="${not empty dict.id}">字典修改</c:if>
				</h3>
				<code class="pull-right" style="margin-top: -33px; margin-right: 8px"><span style="color: red; ">*</span>
					<small>为必填项</small>
				</code>
			</div>
			<div class="panel-body" style="padding: 10px 10px 0px 10px;">

				<form:form id="inputForm" modelAttribute="dict" action="${ctx}/sys/dict/save" method="post" class="form-horizontal">
					<form:hidden path="id"/>
					<sys:message content="${message}"/>
					<div class="control-group">
						<label class="control-label">键值:</label>
						<div class="controls">
							<form:input path="value" htmlEscape="false" maxlength="50" class="required"/>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							标签:&nbsp;&nbsp;&nbsp;&nbsp;
							<form:input path="label" htmlEscape="false" maxlength="50" class="required"/>
						</div>
					</div>
					<%--<div class="control-group">--%>
						<%--<label class="control-label">标签:</label>--%>
						<%--<div class="controls">--%>
							<%--<form:input path="label" htmlEscape="false" maxlength="50" class="required"/>--%>
						<%--</div>--%>
					<%--</div>--%>
					<div class="control-group">
						<label class="control-label">类型:</label>
						<div class="controls">
							<form:input path="type" htmlEscape="false" maxlength="50" class="required abc"/>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							描述:&nbsp;&nbsp;&nbsp;&nbsp;
							<form:input path="description" htmlEscape="false" maxlength="50" class="required"/>
						</div>
					</div>
					<%--<div class="control-group">--%>
						<%--<label class="control-label">描述:</label>--%>
						<%--<div class="controls">--%>
							<%--<form:input path="description" htmlEscape="false" maxlength="50" class="required"/>--%>
						<%--</div>--%>
					<%--</div>--%>
					<div class="control-group">
						<label class="control-label">排序:</label>
						<div class="controls">
							<form:input path="sort" htmlEscape="false" maxlength="11" class="required digits"/>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							备注:&nbsp;&nbsp;&nbsp;&nbsp;
							<form:textarea path="remarks" htmlEscape="false" rows="3" maxlength="200" class="input-xlarge"/>
						</div>
					</div>
					<%--<div class="control-group">--%>
						<%--<label class="control-label">备注:</label>--%>
						<%--<div class="controls">--%>
							<%--<form:textarea path="remarks" htmlEscape="false" rows="3" maxlength="200" class="input-xlarge"/>--%>
						<%--</div>--%>
					<%--</div>--%>
					<div class="">
						<input id="btnSubmit" class="btn btn-primary global-button-style" style="width: 180px; margin-left: 180px" type="submit" value="保  存"/>&nbsp;
						<input id="btnCancel" class="btn btn-white global-button-style" style="width: 180px" type="button" value="返  回" onclick="history.go(-1)"/>
					</div>
					<br/>
				</form:form>



			</div>
		</div>
	</div>






</body>
</html>