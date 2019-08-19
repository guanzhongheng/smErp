<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <script src="${ctxStatic}/hPlugs/js/plugins/layer/layer.min.js"></script>
    <title>库存列表</title>
    <link rel="stylesheet" href="/static/common/customize.css">

    <script type="text/javascript">
        function page(n,s){

            if(n) $("#pageNo").val(n);
            if(s) $("#pageSize").val(s);
            $("#searchForm").attr("action","${ctx}/crm/inventory/list");
            $("#searchForm").submit();
            return false;
        }

        function rePrint(stockId){
            layer.open({
                type: 2,
                title: '打印标签确认',
                skin: 'layui-layer-rim', //加上边框
                area: ['300px', '315px'],
                content: ['/produce/produce/rePrint?stockId='+stockId+'"', 'yes'] //iframe的url，no代表不显示滚动条
            });
        }

        function exportInfo() {
            $("#searchForm").attr('action','/export/stock');
            $("#searchForm").submit();
            $("#searchForm").attr('action','/crm/inventory/list');
        }
    </script>
</head>
<body>

<div class="tabs-container" style="padding: 20px 20px;">
    <div class="panel panel-default" style="border-color: #50B0E6; border-style: solid; border-width: 1px; border-radius:5px 5px 5px 5px;">
        <div class="panel-heading" style="background-color: #50B0E6">
            <h3 class="panel-title global-panel-title" >
                条形码列表
            </h3>
        </div>
        <div class="panel-body" style="padding: 10px 10px 0px 10px;">

            <form:form id="searchForm" modelAttribute="stockQueryVo" action="${ctx}/crm/inventory/list" method="post"
                       class="breadcrumb form-search">
                <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
                <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
                <ul class="ul-form">
                    <li>
                        <form:input path="ordCode" htmlEscape="false" maxlength="200" class="input-medium" placeholder="订单编号"/>
                    </li>
                    <li>
                        &nbsp;&nbsp;
                        <form:select path="itemCgyCode" class="input-medium" placeholder="产品类型">
                            <form:option value="" label=""/>
                            <form:options items="${fns:getCusDictList(149000)}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                        </form:select>
                    </li>
                    <li>
                        &nbsp;&nbsp;
                        <form:select path="itemVariety" class="input-medium" placeholder="产品品种">
                            <form:option value="" label=""/>
                            <form:options items="${fns:getCusDictList(148000)}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                        </form:select>
                    </li>
                    &nbsp;&nbsp;
                    <li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" style="width: 80px" value="查询"/></li>
                    &nbsp;&nbsp;
                    <li class="btns"><input id="btnExport" class="btn btn-primary" type="button" style="width: 80px" value="导出" onclick="exportInfo()"/></li>
                    &nbsp;&nbsp;
                    <li class="btns"><input class="btn btn-primary" type="button" style="width: 80px" onclick="invenFormReset()" value="重置"/></li>
                </ul>
            </form:form>
            <div class="control-group  table-responsive">
                <table id="contentTable" class="table table-striped table-bordered table-hover text-nowrap">
                    <thead>
                    <tr>
                        <th style="text-align: center">序号</th>
                        <th style="text-align: center">订单标题</th>
                        <th style="text-align: center">条形码号</th>
                        <th style="text-align: center">归属人</th>
                        <th style="text-align: center">产品类别</th>
                        <th style="text-align: center">产品品种</th>
                        <th style="text-align: center">产品颜色</th>
                        <th style="text-align: center">长(m)</th>
                        <th style="text-align: center">宽(m)</th>
                        <th style="text-align: center">厚度(mm)</th>
                        <th style="text-align: center">重量</th>
                        <th style="text-align: center">压边类型</th>
                        <th style="text-align: center">延长米方式</th>
                        <th style="text-align: center">计价方式</th>
                        <th style="text-align: center">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${page.list}" var="cus" varStatus="status">
                        <tr>
                            <td style="text-align: center">${status.index + 1}</td>
                            <td>${cus.orderTitle}</td>
                            <td>${cus.barCode}</td>
                            <td>${cus.itemOwner}</td>
                            <td>${fns:getValueByDictKey(cus.itemCgyCode)}</td>
                            <td>${fns:getValueByDictKey(cus.itemVariety)}</td>
                            <td>${fns:getDictLabel(cus.itemColor,'prod_color','无')}</td>
                            <td>${cus.itemLenth}</td>
                            <td>${cus.itemWidth}</td>
                            <td>${cus.itemThick}</td>
                            <td>${cus.itemWeight}</td>
                            <td>${fns:getDictLabel(cus.itemYbType,'prod_ybType','无')}</td>
                            <td>${fns:getDictLabel(cus.itemYcType,'prod_ycType','无')}</td>
                            <td>${fns:getValueByDictKey(cus.itemUnit)}</td>
                            <%--<td><button class="btn btn-primary" type="button" onclick="rePrint(${cus.stockId})"  >补签</button></td>--%>
                            <td><a href="#" rel="external nofollow"
                                   onclick="rePrint(${cus.stockId});return false;"><i class="icon-print">&nbsp;补签</i></a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="pagination">${page}</div>


            </div>
        </div>
    </div>
</div>
</body>

<script type="text/javascript">

    function invenFormReset() {
        $("#ordCode").val("");
        $("#itemCgyCode").val("").select2();
        $("#itemVariety").val("").select2();
    }

</script>

</html>