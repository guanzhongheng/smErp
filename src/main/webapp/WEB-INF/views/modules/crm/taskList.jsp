<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>全部订单</title>
    <script type="text/javascript">


    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/crm/order/taskList">任务分配</a></li>
</ul>
<form:form id="searchForm" modelAttribute="order" action="${ctx}/crm/order/taskList" method="post"
           class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <ul class="ul-form">
        <li>
            <form:input path="ordCode" htmlEscape="false" maxlength="200"
                        class="input-medium" placeholder="订单编号"/>
        </li>
        <li>
            &nbsp;&nbsp;
            <form:input path="ordTitle" htmlEscape="false" maxlength="200"
                        class="input-medium" placeholder="订单标题"/>
        </li>
        <li>
            &nbsp;&nbsp;
            <form:input path="cusName" htmlEscape="false" maxlength="200"
                        class="input-medium" placeholder="关联客户"/>
        </li>
        <li>
            &nbsp;&nbsp;
            <input id="ordSignDate" name="ordSignDate" placeholder="签单日期" type="text" readonly="readonly" maxlength="20"
                   class="input-small Wdate"
                   value="" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
        </li>
        <li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
        <li class="clearfix"></li>
    </ul>
</form:form>
<div class="control-group">&nbsp;&nbsp;&nbsp;&nbsp;
    <a type="button" id="taskDoWork" class="btn btn-default" style="width: 80px;height: 23px"><i
            class="icon-refresh"></i>&nbsp;任务分配</a>
</div>
<div class="control-group">
    <table id="contentTable" class="table table-striped table-bordered table-condensed">
        <thead>
        <tr>
            <th><input type="checkbox" id="checkAll" onchange="checkedAll(this)">全选/全不选</th>
            <th>订单编号</th>
            <th>订单标题</th>
            <th>关联客户</th>
            <th>审批状态</th>
            <th>订单总金额</th>
            <th>已回款金额</th>
            <th>已开票金额</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.list}" var="ord">
            <tr>
                <td><input type="checkbox" name="orderCode" value="${ord.ordCode}" /></td>
                <td>${ord.ordCode}</td>
                <td>${ord.ordTitle}</td>
                <td>${ord.ordCusName}</td>
                <td>${ord.ordStatusValue}</td>
                <td>${ord.ordTotalAmount}</td>
                <td>${ord.repayAmount}</td>
                <td>${ord.invoicedAmount}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="pagination">${page}</div>
</div>
<sys:message content="${message}"/>
<script>
    $("#taskDoWork").click(function () {
        debugger;
        <!-- 针对选中客户进行操作 -->
        // var checkValue = $(".td checkbox");
        var str = getTaskCheckValue();
        if (str.length > 0) {
            top.$.jBox.open("iframe:${ctx}/crm/taskForm?ids="+str, "任务分配", 500, $(top.document).height() - 300, {
                buttons: {"确定": "ok", "关闭": true}, submit: function (v, h, f) {
                    debugger;
                    var taskIds = h.find("iframe")[0].contentWindow.taskIds;
                    var devInfo = h.find("iframe")[0].contentWindow.devInfo;
                    if (v == "ok") {
                        $.post('${ctx}/crmAjax/saveTransfer/', {
                            taskIds: taskIds.value,
                            devInfo: devInfo.value
                        }, function (data) {
                            if (data = "success") {
                                top.$.jBox.tip('分配成功');
                                window.location.href = "/crm/order/taskList";
                            } else {
                                top.$.jBox.tip('分配成功');
                            }
                        })
                    }
                }, loaded: function (h) {
                    debugger;
                    $(".jbox-content", top.document).css("overflow-y", "hidden");
                }
            });
        }else{
            top.$.jBox.tip('最少选中一条记录');
        }

    });

    function getTaskCheckValue() {
        debugger;
        var obj = document.getElementsByName("orderCode");
        var check_val = '';
        for(k in obj){
            if(obj[k].checked)
                check_val = check_val + "," +obj[k].value
        }
        check_val = check_val.replace(",,",",");
        return check_val;
    }

    function checkedAll(obj){
        var codes = document.getElementsByName("orderCode")
        if(obj.checked){
            for(var i=0;i<codes.length;i++){
                codes[i].checked = true;
            }
        }else{
            for(var i=0;i<codes.length;i++){
                codes[i].checked = false;
            }
        }
    }
</script>

</body>
</html>