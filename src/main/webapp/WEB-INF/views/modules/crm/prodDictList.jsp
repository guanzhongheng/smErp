<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>全部客户</title>
    <link rel="stylesheet" href="/static/common/customize.css">
    <script type="text/javascript">
        function page(n,s){

            if(n) $("#pageNo").val(n);
            if(s) $("#pageSize").val(s);
            $("#searchForm").attr("action","${ctx}/tProduct/list");
            $("#searchForm").submit();
            return false;
        }
    </script>
</head>
<body>
<%--<ul class="nav nav-tabs">--%>
    <%--<li class="active"><a href="${ctx}/tProduct/list/">产品列表</a></li>--%>
    <%--<li><a href="${ctx}/tProduct/get?id=">产品操作</a></li>--%>
<%--</ul>--%>

<div class="tabs-container" style="padding: 20px 20px;">
    <div class="panel panel-default" style="border-color: #50B0E6; border-style: solid; border-width: 1px; border-radius:5px 5px 5px 5px;">
        <div class="panel-heading" style="background-color: #50B0E6">
            <h3 class="panel-title global-panel-title" >
                产品列表
            </h3>
        </div>
        <div class="panel-body" style="padding: 10px 10px 0px 10px;">

            <form:form id="searchForm" modelAttribute="tProduct" action="${ctx}/tProduct/list" method="post"
                       class="breadcrumb form-search">
                <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
                <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
                <ul class="ul-form">
                    <li>
                        <form:input path="prodCode" htmlEscape="false" maxlength="200" class="input-medium" placeholder="产品编码"/>
                    </li>
                    <li>
                        &nbsp;&nbsp;
                        <form:input path="prodName" htmlEscape="false" maxlength="200" class="input-medium" placeholder="产品名称"/>
                    </li>
                    <li>
                        &nbsp;&nbsp;
                        <form:select path="prodCgyCode" class="input-medium" placeholder="产品类别">
                            <form:option value="" label=""/>
                            <form:options items="${fns:getCusDictList(149000)}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                        </form:select>
                    </li>
                    <li>
                        &nbsp;&nbsp;
                        <form:select path="delFlag" class="input-medium">
                            <form:option value="0" label="有效"/>
                            <form:option value="-1" label="无效"/>
                            <form:option value="" label="全部"/>
                        </form:select>
                    </li>
                    &nbsp;&nbsp;
                    <li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" style="width: 80px" value="查询"/></li>
                    &nbsp;&nbsp;
                    <li class="btns"><a href="/tProduct/get" type="button" class="btn btn-primary" style="width: 54px;height: 20px">新增</a></li>
                    &nbsp;&nbsp;
                    <li class="btns"><input class="btn btn-primary" type="button" style="width: 80px" onclick="formReset()" value="重置"/></li>
                </ul>
            </form:form>

            <div class="table-responsive">
                <table id="contentTable" class="table table-striped table-bordered  table-hover text-nowrap">
                    <thead>
                    <tr>
                        <th style="text-align: center">产品编号</th>
                        <th style="text-align: center">产品名称</th>
                        <th style="text-align: center">产品品种</th>
                        <th style="text-align: center">产品类别</th>
                        <th style="text-align: center">产品厚度</th>
                        <th style="text-align: center">产品单位</th>
                        <th style="text-align: center">产品颜色</th>
                        <th style="text-align: center">计价方式</th>
                        <th style="text-align: center">指导价格</th>
                        <th style="text-align: center">密度</th>
                        <th style="text-align: center">状态</th>
                        <th style="text-align: center">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${page.list}" var="cus">
                        <tr>
                                <%--${fns:getDictLabel(user.userType, 'sys_user_type', '无')}--%>
                            <td>${cus.prodCode}</td>
                            <td>${cus.prodName}</td>
                            <td>${fns:getValueByDictKey(cus.prodVariety)}</td>
                            <td>${fns:getValueByDictKey(cus.prodCgyCode)}</td>
                            <td>${cus.prodThick}</td>
                            <td>${fns:getValueByDictKey(cus.prodUnit)}</td>
                            <td>${fns:getDictLabel(cus.prodColor, 'prod_color', '无')}</td>
                            <td>${fns:getValueByDictKey(cus.prodPriceType)}</td>
                            <td>${cus.prodGuidePrice}</td>
                            <td>${cus.prodDensity}</td>
                            <td>${cus.delFlag == "0"?"有效":"无效"}
                            </td>
                            <td>
                                <a href="${ctx}/tProduct/get?id=${cus.id}"><i class="icon-pencil">&nbsp;编辑</i></a>
                                <a href="${ctx}/tProduct/delete?id=${cus.id}"
                                   onclick="return confirmx('确认要删除该产品吗？', this.href)"><i class="icon-trash">&nbsp;删除</i></a>
                                <c:if test="${cus.delFlag eq '-1'}">
                                    <a href="${ctx}/tProduct/getBackProd?id=${cus.id}"><i class="icon-pencil">&nbsp;启用</i></a>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="pagination">${page}</div>

                <script>
                    $("#toCustomer").click(function () {

                        <!-- 针对选中客户进行操作 -->
                        // var checkValue = $(".td checkbox");
                        var str = getCheckValue();
                        if (str.length > 0) {
                            top.$.jBox.open("iframe:${ctx}/crm/formSubmit?ids="+str, "转移客户", 500, $(top.document).height() - 300, {
                                buttons: {"确定": "ok", "关闭": true}, submit: function (v, h, f) {

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

                                    $(".jbox-content", top.document).css("overflow-y", "hidden");
                                }
                            });
                        }else{
                            top.$.jBox.tip('最少选中一条记录');
                        }

                    });

                    $("#toPoolCustomer").click(function () {
                        <!-- 针对选中客户进行操作 -->

                        var str = getCheckValue();
                        if (str.length > 0) {
                            top.$.jBox.open("iframe:${ctx}/crm/poolRemark?ids="+str, "移入公海", 500, $(top.document).height() - 300, {
                                buttons: {"确定": "ok", "关闭": true}, submit: function (v, h, f) {

                                    var ids = h.find("iframe")[0].contentWindow.ids;
                                    var remarks = h.find("iframe")[0].contentWindow.remarks;
                                    if (v == "ok") {
                                        $.post('${ctx}/crmAjax/savePoolCustomer/', {
                                            cusIds: ids.value,
                                            remarks: remarks.value
                                        }, function (data) {
                                            if (data = "success") {
                                                top.$.jBox.tip('移入成功');
                                            } else {
                                                top.$.jBox.tip('移入失败');
                                            }
                                        })
                                    }
                                }, loaded: function (h) {

                                    $(".jbox-content", top.document).css("overflow-y", "hidden");
                                }
                            });
                        }else{
                            top.$.jBox.tip('最少选中一条记录');
                        }
                    });

                    function gotoFollowInfo(cusCode) {
                        top.$.jBox.open("iframe:${ctx}/crm/followInfo?cusCode="+cusCode, "客户跟踪", 500, $(top.document).height() - 300, {
                            buttons: {"确定": "ok", "关闭": true}, submit: function (v, h, f) {

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

                                $(".jbox-content", top.document).css("overflow-y", "hidden");
                            }
                        });
                    }

                    function getCheckValue(){
                        var obj = document.getElementsByName("cuscode");
                        var check_val = '';
                        for(k in obj){
                            if(obj[k].checked)
                                check_val = check_val + "," +obj[k].value
                        }
                        check_val = check_val.replace(",,",",");
                        return check_val;
                    }

                    function checkedAll(obj){
                        var codes = document.getElementsByName("cuscode")
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
            </div>
        </div>
    </div>
</div>
<script>
    function formReset() {
        $("#prodCode").val("");
        $("#prodName").val("");
        $("#prodCgyCode").val("").select2();
    }
</script>


</body>
</html>