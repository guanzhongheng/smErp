<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
    <title>全部客户</title>
    <script type="text/javascript">


    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/crm/list/">客户列表</a></li>
    <li><a href="${ctx}/crm/poollist/">公海列表</a></li>
</ul>
<form:form id="searchForm" modelAttribute="customer" action="${ctx}/crm/customer/list" method="post" class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <ul class="ul-form">
        <li>
            <form:input path="cusName" htmlEscape="false" maxlength="200" class="input-medium" placeholder="客户名称"/>
        </li>
        <li>
            &nbsp;&nbsp;
            <form:select path="cusType" class="input-medium" placeholder="客户类型">
                <form:option value="" label=""/>
                <%--<form:options items="${fns:getDictList('oa_notify_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>--%>
            </form:select>
        </li>
        <li>
            &nbsp;&nbsp;
            <form:select path="cusGrade" class="input-medium" placeholder="客户星级">
                <form:option value="" label=""/>
                <%--<form:options items="${fns:getDictList('oa_notify_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>--%>
            </form:select>
        <input id="beginDate" name="beginDate" placeholder="最后跟进" type="text" readonly="readonly" maxlength="20" class="input-small Wdate"
                                   value="" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
        </li>
        <li>
            &nbsp;&nbsp;
            <input type="checkbox" name="type" id="type">归属模式
        </li>
        &nbsp;&nbsp;
        <li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
    </ul>
</form:form>
<div class="control-group">&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="/cus/customer_add" type="button" class="btn btn-primary" style="width: 67px;height: 22px"><i class="icon-plus"></i>&nbsp;添加</a>
    <%--&nbsp;&nbsp;--%>
    <%--<a href="/crm/task_add" type="button" class="btn btn-default" style="width: 80px;height: 23px"><i class="icon-list-ul"></i>&nbsp;新建任务</a>--%>
    &nbsp;&nbsp;
    <a type="button" id="toCustomer" class="btn btn-default" style="width: 80px;height: 23px"><i class="icon-refresh"></i>&nbsp;转移客户</a>
    &nbsp;&nbsp;
    <a type="button" id="toPoolCustomer" class="btn btn-default" style="width: 80px;height: 23px"><i class="icon-group"></i>&nbsp;移入公海</a>
</div>
<div class="control-group">
<table id="contentTable" class="table table-striped table-bordered table-condensed">
    <thead>
    <tr>
        <th></th>
        <th>客户名称</th>
        <th>客户状态</th>
        <th>客户星级</th>
        <th>首联系人</th>
        <th>手机号码</th>
        <th>客户维护人</th>
        <th>未跟进天数</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.list}" var="cus">
        <tr>
            <td><input type="checkbox" name="cuscode" >${cus.cusCode}</td>
            <td>${cus.cusCode}</td>
            <td>${cus.cusStatus}</td>
            <td>${cus.cusGrade}</td>
            <td>${cus.cusAddress}</td>
            <td>${cus.cusAddress}</td>
            <td>${cus.cusAddress}</td>
            <td>${cus.cusAddress}</td>
            <td>
                <a href=""><i class="icon-comment">跟进</i></a>
                <a href=""><i class="icon-pencil">编辑</i></a>
                <a href="${ctx}/crm" onclick="return confirmx('确认要删除该客户吗？', this.href)"><i class="icon-trash">删除</i></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="pagination">${page}</div>
    <script>
        $("#toCustomer").click(function () {
            <!-- 针对选中客户进行操作 -->
            top.$.jBox.open("iframe:${ctx}/crm/formSubmit?ids=1,2,3,4,", "转移客户", 500, $(top.document).height() - 300, {
                buttons: {"确定": "ok", "关闭": true}, submit: function (v, h, f) {
                    debugger;
                    var ids = h.find("iframe")[0].contentWindow.ids;
                    var cusContent = h.find("iframe")[0].contentWindow.cusContent;
                    var remarks = h.find("iframe")[0].contentWindow.remarks;
                    if (v == "ok") {
                        $.post('${ctx}/crmAjax/saveTransfer/', {
                            cusIds: ids.value,
                            userId: cusContent.value,
                            remarks: remarks.value
                        },function(data) {
                            if(data = "success"){
                                top.$.jBox.tip('保存成功');
                            }else{
                                top.$.jBox.tip('保存失败');
                            }
                        })
                    }
                }, loaded: function (h) {
                    debugger;
                    $(".jbox-content", top.document).css("overflow-y", "hidden");
                }
            });
        });

        $("#toPoolCustomer").click(function () {
            <!-- 针对选中客户进行操作 -->
            top.$.jBox.open("iframe:${ctx}/crm/poolRemark?ids=1,2,3,4,", "移入公海", 500, $(top.document).height() - 300, {
                buttons: {"确定": "ok", "关闭": true}, submit: function (v, h, f) {
                    debugger;
                    var ids = h.find("iframe")[0].contentWindow.ids;
                    var remarks = h.find("iframe")[0].contentWindow.remarks;
                    if (v == "ok") {
                        $.post('${ctx}/crmAjax/savePoolCustomer/', {
                            cusIds: ids.value,
                            remarks: remarks.value
                        },function(data) {
                            if(data = "success"){
                                top.$.jBox.tip('移入成功');
                            }else{
                                top.$.jBox.tip('移入失败');
                            }
                        })
                    }
                }, loaded: function (h) {
                    debugger;
                    $(".jbox-content", top.document).css("overflow-y", "hidden");
                }
            });
        });
    </script>
</div>
</body>
</html>