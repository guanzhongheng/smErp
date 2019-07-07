<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>


<div class="wrapper wrapper-content animated fadeInRight">

    <div class="tabs-container">
        <ul class="nav nav-tabs">
            <li class="active"><a data-toggle="tab" href="#tab-1" aria-expanded="true"> 创建订单</a>
            </li>
        </ul>
        <div class="tab-content">
            <div id="tab-1" class="tab-pane active">
                <div class="panel-body">

                    <div class="row">
                        <div class="col-sm-12">
                            <div class="ibox-title">
                                <h5>基本信息</h5>
                                <code class="pull-right"><span style="color: red">*</span>
                                    <small>为必填项</small>
                                </code>
                            </div>
                            <div class="ibox-content">
                                <form:form id="inputForm" modelAttribute="orderAddModifyVo"
                                           action="${ctx}/order/order_save"
                                           method="post" class="form-horizontal">
                                <form:hidden path="ordCode"/>
                                <div class="row">
                                    <div class="col-sm-12">
                                        <div class="ibox float-e-margins">
                                            <form method="get" class="form-horizontal">
                                                <div class="hr-line-dashed"></div>
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label"><i style="color: red">*</i>
                                                        订单标题：</label>
                                                    <div class="col-sm-8">
                                                        <form:input path="ordTitle" htmlEscape="false" maxlength="200"
                                                                    class="form-control" placeholder="订单标题" readonly="true"/>
                                                    </div>
                                                </div>
                                                <div class="hr-line-dashed"></div>
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label"><i style="color: red">*</i>
                                                        关联客户：</label>
                                                    <div class="col-sm-8">
                                                        <form:input path="cusCode" htmlEscape="false" maxlength="200"
                                                                    class="form-control" placeholder="关联客户" readonly="true"/>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label"><i style="color: red"></i>
                                                        代理客户：</label>
                                                    <div class="col-sm-8">
                                                        <form:input path="proxyName" htmlEscape="false" maxlength="200"
                                                                    class="form-control" placeholder="代理客户名称" readonly="true"/>
                                                    </div>
                                                </div>
                                                <div class="hr-line-dashed"></div>
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label"><i style="color: red">*</i>
                                                        订单类型：</label>
                                                    <form:select path="ordType" class="chosen-select"
                                                                 cssStyle="min-width: 300px" readonly="true">
                                                        <form:option value="" label=""/>
                                                        <form:options items="${fns:getDictList(120000)}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                                                    </form:select>
                                                </div>
                                                <div class="hr-line-dashed"></div>
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label"><i style="color: red">*</i>
                                                        订单签订日期：</label>
                                                    <div class="col-sm-8">
                                                        <form:input path="ordSignDate" htmlEscape="false"
                                                                    maxlength="200"
                                                                    class="form-control" placeholder="订单签订日期" readonly="true"/>
                                                    </div>
                                                </div>
                                                <div class="hr-line-dashed"></div>
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label"><i style="color: red"></i>
                                                        订单交付日期：</label>
                                                    <div class="col-sm-8">
                                                        <form:input path="ordDeliveryDate" htmlEscape="false"
                                                                    maxlength="200"
                                                                    class="form-control" placeholder="订单交付日期" readonly="true"/>
                                                    </div>
                                                </div>

                                                <div class="hr-line-dashed"></div>
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label"><i style="color: red">*</i>
                                                        我方签约人：</label>
                                                    <div class="col-sm-8">
                                                        <form:input path="comContractor" htmlEscape="false"
                                                                    maxlength="200"
                                                                    class="form-control" placeholder="我方签约人" readonly="true"/>
                                                    </div>
                                                </div>

                                                <div class="hr-line-dashed"></div>
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label"><i style="color: red">*</i>
                                                        客户签约人：</label>
                                                    <div class="col-sm-8">
                                                        <form:input path="cusContractor" htmlEscape="false"
                                                                    maxlength="200"
                                                                    class="form-control" placeholder="客户签约人" readonly="true"/>
                                                    </div>
                                                </div>

                                                    <%--<div class="hr-line-dashed"></div>--%>
                                                    <%--<div class="form-group">--%>
                                                    <%--<label class="col-sm-3 control-label"><i style="color: red">*</i>--%>
                                                    <%--归属人员：</label>--%>
                                                    <%--<div class="col-sm-6">--%>
                                                    <%--<input type="text" class="form-control" name="password">--%>
                                                    <%--</div>--%>
                                                    <%--</div>--%>

                                                <div class="hr-line-dashed"></div>
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label"><i style="color: red"></i>
                                                        备注信息：</label>
                                                    <div class="col-sm-8">
                                                        <form:input path="remark" htmlEscape="false" maxlength="200"
                                                                    class="form-control" placeholder="备注信息" readonly="true"/>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                        <div class="row">
                                            <div class="form-group">
                                                <div class="col-sm-4 col-sm-offset-2">
                                                    <button class="btn btn-white" type="button"
                                                            onclick="history.go(-1)">返回
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                        </form:form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
<script>
    $(document).ready(function () {
        $(".i-checks").iCheck({checkboxClass: "icheckbox_square-green", radioClass: "iradio_square-green",})
    });
</script>
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
