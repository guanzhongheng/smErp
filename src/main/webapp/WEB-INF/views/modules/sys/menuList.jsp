<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>菜单管理</title>
    <%@include file="/WEB-INF/views/include/treetable.jsp" %>
    <link rel="stylesheet" href="/static/common/customize.css">
    <script type="text/javascript">
        $(document).ready(function () {
            $("#treeTable").treeTable({expandLevel: 3}).show();
        });

        function updateSort() {
            loading('正在提交，请稍等...');
            $("#listForm").attr("action", "${ctx}/sys/menu/updateSort");
            $("#listForm").submit();
        }
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/sys/menu/">菜单列表</a></li>
    <li><a href="${ctx}/sys/menu/form">菜单添加</a></li>
</ul>
<sys:message content="${message}"/>

<form id="listForm" method="post">
    <div class="control-group table-responsive">
    <table id="treeTable" class="table table-striped table-bordered  table-hover text-nowrap hide">
        <thead>
        <tr>
            <th style="text-align: center">名称</th>
            <th style="text-align: center">链接</th>
            <th style="text-align:center;">排序</th>
            <th style="text-align: center">可见</th>
            <th style="text-align: center">权限标识</th>
            <th style="text-align: center">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="menu">
            <tr id="${menu.id}" pId="${menu.parent.id ne '1'?menu.parent.id:'0'}">
                <td nowrap><i class="icon-${not empty menu.icon?menu.icon:' hide'}"></i><a
                        href="${ctx}/sys/menu/form?id=${menu.id}">${menu.name}</a></td>
                <td title="${menu.href}">${fns:abbr(menu.href,30)}</td>
                <td style="text-align:center;">
                    <input type="hidden" name="ids" value="${menu.id}"/>
                    <input name="sorts" type="text" value="${menu.sort}"
                           style="width:50px;margin:0;padding:0;text-align:center;">
                        ${menu.sort}
                </td>
                <td>${menu.isShow eq '1'?'显示':'隐藏'}</td>
                <td title="${menu.permission}">${fns:abbr(menu.permission,30)}</td>
                <td nowrap>
                    <a href="${ctx}/sys/menu/form?id=${menu.id}"><i class="icon-pencil">&nbsp;修改</i></a>
                    <a href="${ctx}/sys/menu/delete?id=${menu.id}"
                       onclick="return confirmx('要删除该菜单及所有子菜单项吗？', this.href)"><i class="icon-trash">&nbsp;删除</i></a>
                    <a href="${ctx}/sys/menu/form?parent.id=${menu.id}"><i class="icon-plus">&nbsp;添加下级菜单</i></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <%--<div class="form-actions pagination-left">--%>
        <%--<input id="btnSubmit" class="btn btn-primary global-button-style" type="button" value="保存排序" onclick="updateSort();"/>--%>
    <%--</div>--%>
        <div class="global-button-padding">
            <input id="btnSubmit" class="btn btn-primary global-button-style" style="width: 180px;" type="submit" value="保存排序" onclick="updateSort();"/>
        </div>
    </div>
</form>

</body>
</html>