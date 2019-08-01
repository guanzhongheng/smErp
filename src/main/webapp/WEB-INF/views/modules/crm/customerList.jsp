<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>全部客户</title>
    <link rel="stylesheet" href="/static/common/customize.css">

    <script type="text/javascript">
        function page(n, s) {
            debugger;
            if (n) $("#pageNo").val(n);
            if (s) $("#pageSize").val(s);
            $("#searchForm").attr("action", "${ctx}/crm/customer/list");
            $("#searchForm").submit();
            return false;
        }
    </script>
</head>
<body>
<%--<ul class="nav nav-tabs">--%>
<%--<li class="active"><a href="${ctx}/crm/customer/list/" class="global-font">客户列表</a></li>--%>
<%--</ul>--%>

<div class="tabs-container" style="padding: 20px 20px;">


    <div class="panel panel-default"
         style="border-color: #50B0E6; border-style: solid; border-width: 1px; border-radius:5px 5px 5px 5px;">
        <div class="panel-heading" style="background-color: #50B0E6">
            <h3 class="panel-title global-panel-title">
                客户列表
            </h3>
        </div>
        <div class="panel-body" style="padding: 10px 10px 0px 10px;">
            <form:form id="searchForm" modelAttribute="customer" action="${ctx}/crm/customer/list" method="post"
                       class="breadcrumb form-search">
                <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
                <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
                <ul class="ul-form">
                    <li>
                        <form:input path="cusName" htmlEscape="false" maxlength="200" class="input-medium"
                                    placeholder="客户名称"/>
                    </li>
                    <li>
                        &nbsp;&nbsp;
                        <form:select path="cusType" class="input-medium" placeholder="客户类型">
                            <form:option value="" label=""/>
                            <form:option value="110002" label="经销商"/>
                            <form:option value="110001" label="散户"/>
                        </form:select>
                    </li>
                    <li>
                        &nbsp;&nbsp;
                        <form:select path="cusStatus" class="input-medium" placeholder="客户状态">
                            <form:option value="" label=""/>
                            <form:options items="${fns:getCusDictList(104000)}" itemLabel="label" itemValue="value"
                                          htmlEscape="false"/>
                        </form:select>
                    </li>
                    <li>
                        &nbsp;&nbsp;
                        <form:select path="cusGrade" class="input-medium" placeholder="客户星级">
                            <form:option value="" label=""/>
                            <form:options items="${fns:getCusDictList(105000)}" itemLabel="label" itemValue="value"
                                          htmlEscape="false"/>
                        </form:select>
                        <input id="beginDate" name="beginDate" placeholder="最后跟进" type="text" readonly="readonly"
                               maxlength="20"
                               class="input-small Wdate"
                               value="" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
                    </li>
                    <li>
                        &nbsp;&nbsp;
                        <input type="checkbox" name="followType" id="type" value="1">归属模式
                    </li>
                    &nbsp;&nbsp;
                    <li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" style="width: 100px;"
                                            value="查询"/></li>
                </ul>
            </form:form>

            <div class="control-group table-responsive">
                <table id="contentTable" class="table table-striped table-bordered table-hover text-nowrap">
                    <thead>
                    <tr>
                        <th><input type="checkbox" id="checkAll" onchange="checkedAll(this)"/></th>
                        <th style="text-align: center">客户编号</th>
                        <th style="text-align: center">客户名称</th>
                        <th style="text-align: center">客户类型</th>
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
                            <td><a href="/cus/customer_info?cusCode=${cus.cusCode}">${cus.cusCode}</a></td>
                            <td>${cus.cusName}</td>
                            <td>
                                <c:if test="${cus.cusType eq '110001'}">散户</c:if>
                                <c:if test="${cus.cusType eq '110002'}">经销商</c:if>
                            </td>
                            <td>${fns:getValueByDictKey(cus.cusStatus)}</td>
                            <td>${fns:getValueByDictKey(cus.cusGrade)}</td>
                            <td>${cus.primaryContactorName}</td>
                            <td>${cus.primaryContactorPhone}</td>
                            <td><fmt:formatDate value="${cus.lastFollowDate}" pattern="yyyy-MM-dd"/></td>
                            <td>${cus.unFollowDays}</td>
                            <td>
                                <a href="" onclick="gotoFollowInfo(${cusCode})"><i class="icon-comment">&nbsp;跟进</i></a>
                                <a href="${ctx}/cus/customer_add?cusCode=${cus.cusCode}"><i
                                        class="icon-pencil">&nbsp;编辑</i></a>
                                <a href="${ctx}/cus/customer_delete?cusCode=${cus.cusCode}"
                                   onclick="return confirmx('确认要删除该客户吗？', this.href)"><i class="icon-trash">&nbsp;删除</i></a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="pagination">${page}</div>
            </div>

            <div class="control-group">&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="/cus/customer_add" type="button" class="btn btn-primary" style="width: 100px;height: 23px"><i
                        class="icon-plus"></i>&nbsp;添加</a>
                &nbsp;&nbsp;
                <a type="button" id="toCustomer" class="btn btn-default" style="width: 100px;height: 23px"><i
                        class="icon-refresh"></i>&nbsp;转移客户</a>
                &nbsp;&nbsp;
                <a type="button" id="toPoolCustomer" class="btn btn-default" style="width: 100px;height: 23px"><i
                        class="icon-group"></i>&nbsp;移入公海</a>
            </div>
        </div>
    </div>
    <script>
        $(document).ready(function () {

            $("#toCustomer").click(function () {
                debugger;
                <!-- 针对选中客户进行操作 -->
                // var checkValue = $(".td checkbox");
                var str = getCheckValue();
                if (str.length > 0) {
                    top.$.jBox.open("iframe:${ctx}/crm/formSubmit?ids=" + str, "转移客户", 500, $(top.document).height() - 300, {
                        buttons: {"确定": "ok", "关闭": true}, submit: function (v, h, f) {
                            debugger;
                            var ids = h.find("iframe")[0].contentWindow.ids;
                            var cusContent = h.find("iframe")[0].contentWindow.cusContent;
                            var remarks = h.find("iframe")[0].contentWindow.remarks;
                            if (v == "ok") {
                                $.post('${ctx}/crmAjax/saveTransfer/', {
                                    cusCodes: ids.value,
                                    empCode: cusContent.value,
                                    remark: remarks.value
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
                } else {
                    top.$.jBox.tip('最少选中一条记录');
                }
            });
            $("#toPoolCustomer").click(function () {
                <!-- 针对选中客户进行操作 -->
                var str = getCheckValue();
                if (str.length > 0) {
                    top.$.jBox.open("iframe:${ctx}/crm/poolRemark?ids=" + str, "移入公海", 500, $(top.document).height() - 300, {
                        buttons: {"确定": "ok", "关闭": true}, submit: function (v, h, f) {
                            debugger;
                            var ids = h.find("iframe")[0].contentWindow.ids;
                            var remarks = h.find("iframe")[0].contentWindow.remarks;
                            if (v == "ok") {
                                $.post('${ctx}/crmAjax/savePoolCustomer/', {
                                    cusCodes: ids.value,
                                    remark: remarks.value
                                }, function (data) {
                                    if (data = "success") {
                                        top.$.jBox.tip('移入成功');
                                    } else {
                                        top.$.jBox.tip('移入失败');
                                    }
                                })
                            }
                        }, loaded: function (h) {
                            debugger;
                            $(".jbox-content", top.document).css("overflow-y", "hidden");
                        }
                    });
                } else {
                    top.$.jBox.tip('最少选中一条记录');
                }
            });
        })
            function gotoFollowInfo(cusCode) {
                top.$.jBox.open("iframe:${ctx}/crm/followInfo?cusCode=" + cusCode, "客户跟踪", 500, $(top.document).height() - 300, {
                    buttons: {"确定": "ok", "关闭": true}, submit: function (v, h, f) {
                        debugger;
                        var cusCode = h.find("iframe")[0].contentWindow.cusCode;
                        var followTitle = h.find("iframe")[0].contentWindow.followTitle;
                        var remarks = h.find("iframe")[0].contentWindow.remarks;
                        if (v == "ok") {
                            $.post('${ctx}/crmAjax/saveFollow/', {
                                cusCode: cusCode.value,
                                followTitle: followTitle.value,
                                followRemarks: remarks.value
                            }, function (data) {
                                if (data = "success") {
                                    top.$.jBox.tip('记录成功');
                                } else {
                                    top.$.jBox.tip('记录失败');
                                }
                            })
                        }
                    }, loaded: function (h) {
                        debugger;
                        $(".jbox-content", top.document).css("overflow-y", "hidden");
                    }
                });
            }

            function getCheckValue() {
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

            function checkedAll(obj) {
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
</body>
</html>