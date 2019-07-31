<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>全部订单</title>
    <%--<link rel="stylesheet" href="/static/hPlugs/css/bootstrap.min.css">--%>
    <link rel="stylesheet" href="/static/common/customize.css">
    <script type="text/javascript">
        function page(n,s){
            debugger;
            if(n) $("#pageNo").val(n);
            if(s) $("#pageSize").val(s);
            $("#searchForm").attr("action","${ctx}/crm/order/list");
            $("#searchForm").submit();
            return false;
        }
    </script>
</head>
<body>
<%--<ul class="nav nav-tabs">--%>
    <%--<li class="active"><a href="${ctx}/crm/order/list/">订单列表</a></li>--%>
<%--</ul>--%>



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
                    <li>
                        <label for="exception"><input id="exception" name="exception" type="checkbox" value="1"/>跟进状态</label>
                    </li>
                    <li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" style="width: 100px" value="查询"/></li>
                    <li class="clearfix"></li>
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
                        <th style="text-align: center">审批状态</th>
                        <th style="text-align: center">签单日期</th>
                        <th style="text-align: center">订单总金额</th>
                        <th style="text-align: center">已回款金额</th>
                        <th style="text-align: center">已开票金额</th>
                        <th style="text-align: center">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${page.list}" var="ord" varStatus="status">
                        <tr>
                            <td style="text-align: center">${status.index + 1}</td>
                            <td><a href="/cus/order/info?ordCode=${ord.ordCode}">${ord.ordCode}</a></td>
                            <td>${ord.ordTitle}</td>
                            <td>${ord.cusName}</td>
                            <td>${ord.ordStatusValue}</td>
                            <td>${ord.ordSignDate}</td>
                            <td>${ord.ordTotalAmount}</td>
                            <td>${ord.repayAmount}</td>
                            <td>${ord.invoicedAmount}</td>
                            <td>
                                    <%--<a href=""><i class="icon-comment">跟进</i></a>--%>
                                <a href="/order/prodDetailList?ordCode=${ord.ordCode}"><i class="icon-plus">&nbsp;产品添加</i></a>
                                <a href="/order/order_add?ordCode=${ord.ordCode}"><i class="icon-pencil">&nbsp;编辑</i></a>
                                <a href="/order/order_delete?ordCode=${ord.ordCode}" onclick="return confirmx('确认要删除该订单吗？', this.href)">
                                    <i class="icon-trash">删除</i></a>
                                <a href="/print/order_print?ordCode=${ord.ordCode}"><i class="icon-print">&nbsp;打印</i></a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="pagination">${page}</div>
            </div>
            <div class="control-group">&nbsp;&nbsp;&nbsp;&nbsp;
                <%--<a href="/order/order_add" type="button" class="btn btn-primary" style="width: 67px;height: 22px"><i--%>
                <%--class="icon-plus"></i>&nbsp;添加</a>&nbsp;&nbsp;&nbsp;&nbsp;--%>
                <a type="button" class="btn btn-primary" style="width: 100px;height: 23px" onclick="uploadFile()">上  传</a>
            </div>
        </div>
    </div>
</div>





<script>
    function uploadFile() {
        top.$.jBox.open("iframe:${ctx}/crm/order/upload", "文件上传", 500, $(top.document).height() - 300, {
            buttons: {"确定": "ok", "关闭": true}, submit: function (v, h, f) {
                debugger;

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
                        if (data = "success") {
                            top.$.jBox.tip('上传成功');
                        } else {
                            top.$.jBox.tip('上传失败');
                        }
                    }, 'json').fail(function() {
                    });
                }
            }, loaded: function (h) {
                debugger;
                $(".jbox-content", top.document).css("overflow-y", "hidden");
            }
        });
    };
</script>
<%--<sys:message content="${message}"/>--%>
</body>


</html>