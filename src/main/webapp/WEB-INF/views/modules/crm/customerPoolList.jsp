<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>全部客户</title>
    <link rel="stylesheet" href="/static/common/customize.css">

    <script type="text/javascript">
        function page(n, s) {
            debugger;
            if(n) $("#pageNo").val(n);
            if(s) $("#pageSize").val(s);
            $("#searchForm").attr("action","${ctx}/crm/customer/poollist");
            $("#searchForm").submit();
            return false;
        }
    </script>
</head>
<body>
<%--<ul class="nav nav-tabs">--%>
    <%--<li class="active"><a href="${ctx}/crm/customer/poollist/">公海列表</a></li>--%>
<%--</ul>--%>


<div class="tabs-container" style="padding: 20px 20px;">
    <div class="panel panel-default" style="border-color: #50B0E6; border-style: solid; border-width: 1px; border-radius:5px 5px 5px 5px;">
        <div class="panel-heading" style="background-color: #50B0E6">
            <h3 class="panel-title global-panel-title" >
                公海客户列表
            </h3>
        </div>
        <div class="panel-body" style="padding: 10px 10px 0px 10px;">
            <form:form id="searchForm" modelAttribute="customer" action="${ctx}/crm/customer/poollist" method="post"
                       class="breadcrumb form-search">
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
                        <input id="beginDate" name="beginDate" placeholder="最后跟进" type="text" readonly="readonly" maxlength="20"
                               class="input-small Wdate"
                               value="" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
                    </li>
                    &nbsp;&nbsp;
                    <li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" style="width: 100px" value="查询"/></li>
                </ul>
            </form:form>
            <%--<div class="control-group">&nbsp;&nbsp;&nbsp;&nbsp;--%>
            <%--&lt;%&ndash;<a href="/cus/customer_add" type="button" class="btn btn-primary" style="width: 67px;height: 22px"><i&ndash;%&gt;--%>
            <%--&lt;%&ndash;class="icon-plus"></i>&nbsp;添加</a>&ndash;%&gt;--%>
            <%--&lt;%&ndash;&nbsp;&nbsp;&ndash;%&gt;--%>
            <%--&lt;%&ndash;<a href="/crm/task_add" type="button" class="btn btn-default" style="width: 80px;height: 23px"><i class="icon-list-ul"></i>&nbsp;新建任务</a>&ndash;%&gt;--%>
            <%--&nbsp;&nbsp;--%>
            <a type="button" id="toCustomer" class="btn btn-default" style="height: 23px"><i
            class="icon-refresh"></i>添加归属人</a>
            </div>
            <div class="control-group table-responsive">
                <table id="contentTable" class="table table-striped table-bordered  table-hover text-nowrap">
                    <thead>
                    <tr>
                        <th><input type="checkbox" id="checkAll" onchange="poolCheckedAll(this)" /></th>
                        <th style="text-align: center">编号</th>
                        <th style="text-align: center">客户名称</th>
                        <th style="text-align: center">客户状态</th>
                        <th style="text-align: center">客户星级</th>
                        <th style="text-align: center">首联系人</th>
                        <th style="text-align: center">手机号码</th>
                        <th style="text-align: center">最后跟进日期</th>
                        <th style="text-align: center">未跟进天数</th>
                        <th style="text-align: center">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${page.list}" var="cus">
                        <tr>
                            <td><input type="checkbox" name="cuscode" value="${cus.cusCode}"></td>
                            <td>${cus.cusCode}</td>
                            <td>${cus.cusName}</td>
                            <td>${cus.cusStatus}</td>
                            <td>${cus.cusGrade}</td>
                            <td>${cus.primaryContactorName}</td>
                            <td>${cus.primaryContactorPhone}</td>
                            <td><fmt:formatDate value="${cus.lastFollowDate}" pattern="yyyy-MM-dd"/></td>
                            <td>${cus.unFollowDays}</td>
                            <td>
                                    <%--<a href=""><i class="icon-comment">&nbsp;跟进</i></a>--%>
                                <a href="${ctx}/cus/customer_add?cusCode=${cus.cusCode}"><i class="icon-pencil">&nbsp;编辑</i></a>
                                <a href="${ctx}/cus/customer_delete?cusCode=${cus.cusCode}"
                                   onclick="return confirmx('确认要删除该客户吗？', this.href)"><i class="icon-trash">&nbsp;删除</i></a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="pagination">${page}</div>

                <script>
                    $(document).ready(function () {
                        $("#toCustomer").click(function () {
                            <!-- 针对选中客户进行操作 -->
                            var str = getPoolCheckValue();
                            if (str.length > 0) {
                                top.$.jBox.open("iframe:${ctx}/crm/formSubmit?ids=" + str, "添加归属人", 500, $(top.document).height() - 300, {
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
                                            }, function (data) {
                                                if (data = "success") {
                                                    top.$.jBox.tip('保存成功');
                                                } else {
                                                    top.$.jBox.tip('保存失败');
                                                }
                                            })
                                        }
                                    }, loaded: function (h) {
                                        debugger;
                                        $(".jbox-content", top.document).css("overflow-y", "hidden");
                                    }
                                });
                            }

                        });
                    })
                    function getPoolCheckValue() {
                        debugger;
                        var obj = document.getElementsByName("cuscode");
                        var check_val = '';
                        for (k in obj) {
                            if (obj[k].checked)
                                check_val = check_val + obj[k].value + ",";
                        }
                        check_val = check_val.replace(",,", ",");
                        return check_val;
                    }

                    function poolCheckedAll(obj) {
                        var codes = document.getElementsByName("cuscode")
                        if (obj.checked) {
                            for (var i = 0; i < codes.length; i++) {
                                codes[i].checked = true;
                            }
                        } else {
                            for (var i = 0; i < codes.length; i++) {
                                codes[i].checked = false;
                            }
                        }
                    }
                </script>
            </div>
        </div>
    </div>
</div>





</body>
</html>