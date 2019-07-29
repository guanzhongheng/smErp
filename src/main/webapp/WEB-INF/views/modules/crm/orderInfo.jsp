<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>

<link href="${ctxStatic}/hPlugs/css/plugins/bootstrap-table/bootstrap-table.css" rel="stylesheet">
<link href="${ctxStatic}/hPlugs/css/plugins/bootstrap-table/bootstrap-table-fixed-columns.css" rel="stylesheet">

<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <input type="hidden" id="ordCode" value="${ordCode}"/>
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <label class="col-sm-3 control-label">订单信息

                </label>
            </div>
            <div class="ibox-content">
                <form method="get" class="form-horizontal">
                    <div class="hr-line-dashed"></div>
                    <div class="form-group">

                        <%--<div class="row">--%>
                            <%--<div class="col-md-3">--%>
                                <%--&lt;%&ndash;<div class="input-group">&ndash;%&gt;--%>
                                    <%--<span for="memberName" class="input-group-addon" style="background-color: #eee">订单标题:</span>--%>
                                    <%--<input type="text" maxlength="20" class="form-control"--%>
                                           <%--value="${order.ordTitle}" readonly="true">--%>
                                <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                            <%--</div>--%>
                            <%--<div class="col-md-3">--%>
                                <%--&lt;%&ndash;<div class="input-group">&ndash;%&gt;--%>
                                    <%--<span for="memberName" class="input-group-addon" style="background-color: #eee">客户名称:</span>--%>
                                    <%--<input type="text" maxlength="20" class="form-control" value="${order.cusCode}" readonly="true">--%>
                                <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <div class="col-sm-4">
                            <label class="col-sm-3 control-label">订单标题:</label>
                            <input class="col-sm-4 global-input-readonly" value="${order.ordTitle}">
                            <%--<label class="col-sm-4 control-label">${order.ordTitle}</label>--%>
                        </div>
                        <div class="col-sm-4">
                            <label class="col-sm-3 control-label">客户名称:</label>
                            <input class="col-sm-4 global-input-readonly" value="${order.cusCode}">
                        </div>
                        <div class="col-sm-4">
                            <label class="col-sm-3 control-label">代理客户:</label>
                            <input class="col-sm-4 global-input-readonly" value="${order.proxyName}">
                        </div>
                    </div>
                    <div class="hr-line-dashed"></div>
                    <div class="form-group">

                        <div class="col-sm-4">
                            <label class="col-sm-3 control-label">订单类型:</label>
                            <input class="col-sm-4 global-input-readonly" value="${order.ordTypeValue}">
                        </div>
                        <div class="col-sm-4">
                            <label class="col-sm-3 control-label">签单日期:</label>
                            <input class="col-sm-4 global-input-readonly" value="${order.ordSignDate}">
                        </div>
                        <div class="col-sm-4">
                            <label class="col-sm-3 control-label">交货日期:</label>
                            <input class="col-sm-4 global-input-readonly" value="${order.ordDeliveryDate}">
                        </div>
                    </div>
                    <div class="hr-line-dashed"></div>
                    <div class="form-group">
                        <div class="col-sm-4">
                            <label class="col-sm-3 control-label">我方签约:</label>
                            <input class="col-sm-4 global-input-readonly" value="${order.comContractor==null?"":order.comContractor}">
                        </div>
                        <div class="col-sm-4">
                            <label class="col-sm-3 control-label">客户签约:</label>
                            <input class="col-sm-4 global-input-readonly" value="${order.cusContractor==null?"":order.cusContractor}">
                        </div>
                        <div class="col-sm-4">
                            <label class="col-sm-3 control-label">备注信息:</label>
                            <input class="col-sm-4 global-input-readonly" value="${order.remarks}">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    </br>
    <div class="row">
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <button class="btn btn-primary" type="button"
                onclick="history.go(-1)">返  回
        </button>
    </div>
    </br>
    <div class="row">
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>订单详情列表</h5>
            </div>
            <div class="ibox-content">
                    <table id="cusProdInfo" class="table table-bordered" style="max-height: 500px;">
                        <thead>
                        <tr>
                            <th data-field="ordTitle">订单标题</th>
                            <th data-field="itemName">产品名称</th>
                            <th data-field="itemCgyCodeValue">品种</th>
                            <th data-field="itemVaritemValue">类别</th>
                            <th data-field="itemLenth">长</th>
                            <th data-field="itemWidth">宽</th>
                            <th data-field="itemThick">厚度</th>
                            <th data-field="itemColorValue">颜色</th>
                            <th data-field="itemUnitValue">单位</th>
                            <th data-field="itemOwner">归属人</th>
                            <th data-field="itemPrice">单价</th>
                            <th data-field="itemNum">数量</th>
                            <th data-field="itemPriceTypeValue">计价方式</th>
                            <th data-field="itemWeight">重量</th>
                            <th data-field="itemTotalWeight">总重量</th>
                            <th data-field="itemTotalSq">总面积</th>
                            <th data-field="itemYcType">延长方式</th>
                            <th data-field="itemYbType">压边类型</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${ordItems}" var="o">
                            <tr>
                                <td>${o.ordCode}</td>
                                <td>${o.itemName}</td>
                                <td>${o.itemCgyCodeValue}</td>
                                <td>${o.itemVaritemValue}</td>
                                <td>${o.itemLenth}</td>
                                <td>${o.itemWidth}</td>
                                <td>${o.itemThick}</td>
                                <td>${o.itemColorValue}</td>
                                <td>${o.itemUnitValue}</td>
                                <td>${o.itemOwner}</td>
                                <td>${o.itemPrice}</td>
                                <td>${o.itemNum}</td>
                                <td>${o.itemPriceType==141001?"重量":"面积"}</td>
                                <td>${o.itemWeight}</td>
                                <td>${o.itemTotalWeight}</td>
                                <td>${o.itemTotalSq}</td>
                                <td>${fns:getDictLabel(o.itemYcType,'prod_ycType','无')}</td>
                                <td>${fns:getDictLabel(o.itemYbType,'prod_ybType','无')}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="${ctxStatic}/hPlugs/js/jquery.min.js?v=2.1.4" type="text/javascript"></script>
<script src="${ctxStatic}/hPlugs/js/bootstrap.min.js?v=3.3.6" type="text/javascript"></script>
<script src="${ctxStatic}/hPlugs/js/content.min.js?v=1.0.0" type="text/javascript"></script>
<script src="${ctxStatic}/hPlugs/js/plugins/chosen/chosen.jquery.js"></script>
<script src="${ctxStatic}/hPlugs/js/plugins/jsKnob/jquery.knob.js"></script>
<script src="${ctxStatic}/hPlugs/js/plugins/jasny/jasny-bootstrap.min.js"></script>
<script src="${ctxStatic}/hPlugs/js/plugins/datapicker/bootstrap-datepicker.js"></script>
<script src="${ctxStatic}/hPlugs/js/plugins/prettyfile/bootstrap-prettyfile.js"></script>
<script src="${ctxStatic}/hPlugs/js/plugins/switchery/switchery.js"></script>
<script src="${ctxStatic}/hPlugs/js/plugins/ionRangeSlider/ion.rangeSlider.min.js"></script>
<script src="${ctxStatic}/hPlugs/js/plugins/iCheck/icheck.min.js"></script>
<script src="${ctxStatic}/hPlugs/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="${ctxStatic}/hPlugs/js/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<script src="${ctxStatic}/hPlugs/js/plugins/clockpicker/clockpicker.js"></script>
<script src="${ctxStatic}/hPlugs/js/plugins/cropper/cropper.min.js"></script>
<script src="${ctxStatic}/hPlugs/js/demo/form-advanced-demo.min.js"></script>
<script src="${ctxStatic}/hPlugs/js/plugins/layer/layer.min.js"></script>
<script src="${ctxStatic}/hPlugs/js/plugins/bootstrap-table/bootstrap-table.js"></script>
<script src="${ctxStatic}/hPlugs/js/plugins/bootstrap-table/bootstrap-table-fixed-columns.js"></script>
<script src="${ctxStatic}/hPlugs/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<link rel="stylesheet" href="/static/common/customize.css">