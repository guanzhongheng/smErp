<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>全部订单</title>
    <%--<link rel="stylesheet" href="/static/hPlugs/css/bootstrap.min.css">--%>
    <link rel="stylesheet" href="/static/common/customize.css">
    <script type="text/javascript">
        function page(n,s){

            if(n) $("#pageNo").val(n);
            if(s) $("#pageSize").val(s);
            $("#searchForm").attr("action","${ctx}/crm/order/list");
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
                订单列表
            </h3>
        </div>
        <div class="panel-body" style="padding: 10px 10px 0px 10px;">
            <form:form id="searchForm" modelAttribute="order" action="${ctx}/crm/order/list" method="post"
                       class="breadcrumb form-search">
                <sys:message content="${message}"/>
                <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
                <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
                <ul class="ul-form">
                    <li>
                        <form:input path="ordCode" htmlEscape="false" maxlength="200"
                                    class="input-medium" placeholder="订单编号" cssStyle="width: 150px;"/>
                    </li>
                    <li>
                        &nbsp;&nbsp;
                        <form:input path="ordTitle" htmlEscape="false" maxlength="200"
                                    class="input-medium" placeholder="订单标题" cssStyle="width: 120px;"/>
                    </li>
                    <li>
                        &nbsp;&nbsp;
                        <form:input path="cusName" htmlEscape="false" maxlength="200"
                                    class="input-medium" placeholder="关联客户" cssStyle="width: 120px;"/>
                    </li>
                    <li>
                        &nbsp;&nbsp;
                        <form:select path="isOver" class="input-medium" placeholder="订单状态" cssStyle="width: 120px;">
                            <form:option value="0" label="全部订单"/>
                            <form:option value="1" label="未完结订单"/>
                            <form:option value="2" label="完结订单"/>
                        </form:select>
                    </li>
                    <li>
                        &nbsp;&nbsp;
                        <form:input path="startDate" htmlEscape="false" maxlength="20"
                                    class="input-small Wdate" placeholder="开始日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
                        &nbsp;&nbsp;~&nbsp;&nbsp;
                        <form:input path="endDate" htmlEscape="false" maxlength="20"
                                    class="input-small Wdate" placeholder="截止日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
                    </li>
                    <%--<li>
                        <label for="exception"><input id="exception" name="exception" type="checkbox" value="1"/>跟进状态</label>
                    </li>--%>
                    <li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" style="width: 80px" value="查询"/></li>
                    <li class="btns"><a href="/order/order_add" type="button" class="btn btn-primary" style="width: 54px;height: 20px">新增</a></li>
                    <li class="btns"><a type="button" class="btn btn-primary" style="width: 54px;height: 20px" onclick="uploadFile()">上 传</a></li>
                    <li class="btns"><input class="btn btn-primary" type="button" style="width: 80px" onclick="ordFormReset()" value="重置"/></li>
                </ul>
            </form:form>

            <div class="control-group table-responsive">
                <table id="contentTable" class="table table-striped table-bordered table-hover text-nowrap">
                    <thead>
                    <tr>
                        <th style="text-align: center">序号</th>
                        <th style="text-align: center">订单编号</th>
                        <th style="text-align: center">订单标题</th>
                        <th style="text-align: center">关联客户</th>
                        <th style="text-align: center">订单数量</th>
                        <th style="text-align: center">订单金额</th>
                        <th style="text-align: center">审批状态</th>
                        <th style="text-align: center">签单日期</th>
                        <th >备注</th>
                        <th style="text-align: center">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${page.list}" var="ord" varStatus="status">
                        <tr>
                            <td style="text-align: center">${status.index + 1}</td>
                            <td>${ord.ordCode}</td>
                            <td><a href="/cus/order/info?ordCode=${ord.ordCode}">${ord.ordTitle}</a></td>
                            <td>${ord.cusName}</td>
                            <td>${ord.ordTotalNum}</td>
                            <td>${ord.orderPrice}</td>
                            <td>${ord.ordStatusValue}</td>
                            <td>${ord.ordSignDate}</td>
                            <td>${ord.remarks}</td>
                            <td>
                                <c:if test="${ord.ordStatus ne '100002'&& ord.ordStatus ne '100005' }" >
                                    <a href="/order/prodDetailList?ordCode=${ord.ordCode}"><i class="icon-plus">&nbsp;产品新增</i></a>
                                    <a href="/order/order_add?ordCode=${ord.ordCode}"><i class="icon-pencil">&nbsp;编辑</i></a>
                                </c:if>
                                <a href="/order/order_delete?ordCode=${ord.ordCode}" onclick="return confirmx('确认要删除该订单吗？', this.href)">
                                    <i class="icon-trash">删除</i></a>

                                <c:if test="${userId eq '1' }" >
                                    <a href="/order/update_orderPrice?ordCode=${ord.ordCode}">
                                        <i class="icon-asterisk">调价</i></a>
                                </c:if>
                                <a href="/export/orderInfo?ordCode=${ord.ordCode}"><i class="icon-download">&nbsp;详情导出</i></a>
                            </td>
                        </tr>
                    </c:forEach>
                    <tr>
                    		<td colspan="5">总计:</td>
                    		<td colspan="5">金额汇总:${totalPrice}</td>
                    </tr>
                    </tbody>
                </table>
                <div class="pagination">${page}</div>
            </div>
        </div>
    </div>
</div>

<script>
    function uploadFile() {
        top.$.jBox.open("iframe:${ctx}/crm/order/upload", "文件上传", 500, $(top.document).height() - 300, {
            buttons: {"确定": "ok", "关闭": true}, submit: function (v, h, f) {
                var file = h.find("iframe")[0].contentWindow.orderFile;
                var formData = new FormData();
                formData.append("file", file.files[0]);
                if (v == "ok") {

                    $.ajax({
                        type: "post",
                        url : '/order/import',
                        cache : false,
                        data : formData,
                        processData : false,
                        contentType : false
                    }).done(function(data) {
                        if (data == "success") {
                            top.$.jBox.tip('上传成功');
                            window.location.href = "/crm/order/list";
                        } else {
                            top.$.jBox.tip('上传失败:' + data);
                        }
                    }, 'json').fail(function(data) {
                         top.$.jBox.tip('上传失败:');
                    });
                }
            }, loaded: function (h) {

                $(".jbox-content", top.document).css("overflow-y", "hidden");
            }
        });
    };

    function ordFormReset() {
        $("#ordCode").val("");
        $("#ordTitle").val("");
        $("#cusName").val("");
        $("#ordSignDate").val("");
        $("#isOver").val("0").select2();

    }
</script>
</body>


</html>