<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>库存列表</title>
    <script type="text/javascript">
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/crm/customer/list/">库存列表</a></li>
    <li><a href="${ctx}/crm/customer/poollist/">出库清单</a></li>
</ul>
<form:form id="searchForm" modelAttribute="customer" action="${ctx}/crm/customer/list" method="post"
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
                <form:options items="${fns:getCusDictList(110000)}" itemLabel="label" itemValue="value" htmlEscape="false"/>
            </form:select>
        </li>
        <li>
            &nbsp;&nbsp;
            <form:select path="cusGrade" class="input-medium" placeholder="客户星级">
                <form:option value="" label=""/>
                <form:options items="${fns:getCusDictList(105000)}" itemLabel="label" itemValue="value" htmlEscape="false"/>
            </form:select>
            <input id="beginDate" name="beginDate" placeholder="最后跟进" type="text" readonly="readonly" maxlength="20"
                   class="input-small Wdate"
                   value="" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
        </li>
        <li>
            &nbsp;&nbsp;
            <input type="checkbox" name="followType" id="type" value="1">归属模式
        </li>
        &nbsp;&nbsp;
        <li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
    </ul>
</form:form>
<div class="control-group">
    <table id="contentTable" class="table table-striped table-bordered table-condensed">
        <thead>
        <tr>
            <th>产品名称</th>
            <th>产品编号</th>
            <th>产品规格</th>
            <th>订单编号</th>
            <th>订单标题</th>
            <th>订单状态</th>
            <th>当前库存</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.list}" var="cus">
            <tr>
                <td>${cus.cusName}</td>
                <td>${cus.cusStatus}</td>
                <td>${cus.cusGrade}</td>
                <td>${cus.primaryContactorName}</td>
                <td>
                    <a href="/crm/" ><i class="icon-comment">&nbsp;详情</i></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="pagination">${page}</div>

    <script>

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
</body>
</html>