<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>

<link href="${ctxStatic}/hPlugs/css/plugins/bootstrap-table/bootstrap-table.css" rel="stylesheet">
<link href="${ctxStatic}/hPlugs/css/plugins/bootstrap-table/bootstrap-table-fixed-columns.css" rel="stylesheet">
<%--<link href="${ctxStatic}/hPlugs/css/bootstrap.min14ed.css" rel="stylesheet">--%>
<link rel="stylesheet" href="/static/common/customize.css">


<div class="tabs-container" style="padding: 0px 20px;">
    <div class="panel panel-default"
         style="border-color: #50B0E6; border-style: solid; border-width: 1px; border-radius:5px 5px 5px 5px;">
        <div class="panel-heading" style="background-color: #50B0E6">
            <h3 class="panel-title global-panel-title">
                订单详情
            </h3>
        </div>
        <div class="panel-body" style="padding: 10px 10px 0px 10px;">
            <div class="row">
                <div class="col-sm-12">
                    <input type="hidden" id="ordCode" value="${ordCode}"/>
                    <div class="form-group">
                        <div class="col-md-4">
                            <label class="col-md-4 control-label order-detail-label-margin" style="text-align: right">
                                订单标题:
                            </label>
                            <label class="col-md-8 control-label">
                                <input class="form-control" value="${order.ordTitle}" disabled>
                            </label>
                        </div>
                        <div class="col-md-4">
                            <label class="col-md-4 control-label order-detail-label-margin" style="text-align: right">
                                客户名称:
                            </label>
                            <label class="col-md-8 control-label">
                                <input class="form-control"value="${order.cusName}" disabled>
                            </label>
                        </div>
                        <div class="col-md-4">
                            <label class="col-md-4 control-label order-detail-label-margin" style="text-align: right">
                                代理客户:
                            </label>
                            <label class="col-md-8 control-label">
                                <input class="form-control"value="${order.proxyName}" disabled>
                            </label>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-12">
                    <div class="form-group">
                        <div class="col-md-4">
                            <label class="col-md-4 control-label order-detail-label-margin" style="text-align: right">
                                订单类型:
                            </label>
                            <label class="col-md-8 control-label">
                                <input class="form-control"value="${order.ordTypeValue}" disabled>
                            </label>
                        </div>
                        <div class="col-md-4">
                            <label class="col-md-4 control-label order-detail-label-margin" style="text-align: right">
                                签单日期:
                            </label>
                            <label class="col-md-8 control-label">
                                <input class="form-control"value="${order.ordSignDate}" disabled>
                            </label>
                        </div>
                        <div class="col-md-4">
                            <label class="col-md-4 control-label order-detail-label-margin" style="text-align: right">
                                交货日期:
                            </label>
                            <label class="col-md-8 control-label">
                                <input class="form-control"value="${order.ordDeliveryDate}" disabled>
                            </label>
                        </div>

                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-12">
                    <div class="form-group">
                        <div class="col-md-4">
                            <label class="col-md-4 control-label order-detail-label-margin" style="text-align: right">
                                我方签约:
                            </label>
                            <label class="col-md-8 control-label">
                                <input class="form-control"value="${order.comContractor==null?'':order.comContractor}" disabled>
                            </label>
                        </div>

                        <div class="col-md-4">
                            <label class="col-md-4 control-label order-detail-label-margin" style="text-align: right">
                                客户签约:
                            </label>
                            <label class="col-md-8 control-label">
                                <input class="form-control"value="${order.cusContractor==null?'':order.cusContractor}" disabled>
                            </label>
                        </div>
                        <div class="col-md-4">

                            <label class="col-md-4 control-label order-detail-label-margin" style="text-align: right">
                                备注:
                            </label>
                            <label class="col-md-8 control-label">
                                <input class="form-control"value="${order.remarks}" disabled>
                            </label>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-12">
                    <div class="form-group">
                        <div class="row">
                            <div class="col-md-1">
                                &nbsp;
                            </div>
                            <div class="col-md-11 " style="text-align: right;">
                                <button class="btn btn-primary global-button-style" type="button"
                                        onclick="history.go(-1)">返 回
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<div class="tabs-container" style="padding: 0px 20px;">
    <div class="panel panel-default"
         style="border-color: #50B0E6; border-style: solid; border-width: 1px; border-radius:5px 5px 5px 5px;">
        <div class="panel-heading" style="background-color: #50B0E6">
            <h3 class="panel-title global-panel-title">
                订单详情列表
            </h3>
        </div>
        <div class="panel-body" style="padding: 10px 10px 0px 10px;">

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
<style src="/static/hPlugs/css/bootstrap.min14ed.css" type="text/css"></style>
<link rel="stylesheet" href="/static/common/customize.css">
