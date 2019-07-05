<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>用户管理</title>
	<%@include file="/WEB-INF/views/include/treeview.jsp" %>
	<style type="text/css">
		.ztree {overflow:auto;margin:0;_margin-top:10px;padding:10px 0 0 10px;}
	</style>
</head>
<body>
	<sys:message content="${message}"/>
	<div id="content" class="row-fluid">

		<div id="openClose" class="close">&nbsp;</div>
		<div id="right">
			<iframe  src="${ctx}/sys/user/list" width="100%" height="91%" frameborder="0"></iframe>
		</div>
	</div>
	<script type="text/javascript">


		// var leftWidth = 180; // 左侧窗口大小
		// var htmlObj = $("html"), mainObj = $("#main");
		// var frameObj = $("#left, #openClose, #right, #right iframe");
		// function wSize(){
		// 	var strs = getWindowSize().toString().split(",");
		// 	htmlObj.css({"overflow-x":"hidden", "overflow-y":"hidden"});
		// 	mainObj.css("width","auto");
		// 	frameObj.height(strs[0] - 5);
		// 	var leftWidth = ($("#left").width() < 0 ? 0 : $("#left").width());
		// 	$("#right").width($("#content").width()- leftWidth - $("#openClose").width() -5);
		// 	$(".ztree").width(leftWidth - 10).height(frameObj.height() - 46);
		// }
	</script>
	<script src="${ctxStatic}/common/wsize.min.js" type="text/javascript"></script>
</body>
</html>