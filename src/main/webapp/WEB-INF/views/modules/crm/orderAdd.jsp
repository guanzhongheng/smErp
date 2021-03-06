<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>


<link rel="stylesheet" href="/static/common/customize.css">
<script src="${ctxStatic}/My97DatePicker/WdatePicker.js" type="text/javascript"></script>

<sys:message content="${message}"/>
<div class="tabs-container" style="padding: 20px 20px;">
    <div class="panel panel-default" style="border-color: #50B0E6; border-style: solid; border-width: 1px; border-radius:5px 5px 5px 5px;">
        <div class="panel-heading" style="background-color: #50B0E6">
            <h3 class="panel-title global-panel-title" >
                <c:if test="${empty orderAddModifyVo.ordCode}">创建订单</c:if>
                <c:if test="${not empty orderAddModifyVo.ordCode}">编辑订单</c:if>
            </h3>
            <code class="pull-right" style="margin-top: -25px"><span style="color: red; ">*</span>
                <small>为必填项</small>
            </code>
        </div>
        <div class="panel-body" style="padding: 10px 10px 0px 10px;">
            <div class="">
                <form:form id="inputForm" modelAttribute="orderAddModifyVo"
                           action="${ctx}/order/order_save"
                           method="post" class="form-horizontal">
                <form:hidden path="ordCode"/>
                    <input type="hidden" name="showCusCode" id="showCusCode" value="${orderAddModifyVo.cusCode}">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="">
                            <form method="get" class="form-horizontal">
                                </br>
                                <div class="form-group">
                                    <label class="col-md-2 control-label order-label-margin"><i style="color: red">*</i>
                                        订单标题:
                                    </label>
                                    <label class="col-md-2 control-label order-label-input-width" disabled>
                                        <form:input path="ordTitle" htmlEscape="false" maxlength="255" disabled="${orderAddModifyVo.ordCode == null?'false':'true'}"
                                                    class="form-control global-input" placeholder="订单标题"/>
                                    </label>

                                    <label class="col-md-2 control-label  order-label-margin order-input-width">
                                        关联客户:
                                    </label>
                                    <label class="col-md-2 control-label order-input-width " style="text-align: left">
                                        <select id="cusCode" name="cusCode" class="chosen-select global-input order-input-width" style="width: 150px;" >
                                            <c:forEach  items="${customers}" var="s">
                                                <option class="order-input-width" value='${s.cusCode}' style="width: 150px;" > ${s.cusName}</option>
                                            </c:forEach>
                                        </select>

                                    </label>
                                    <div class="col-md-2 control-label order-input-width">
                                        <a href="/cus/customer_add" class="btn btn-primary" style="width: 100px">客户新增</a>
                                    </div>
                                </div>


                                <div class="hr-line-dashed"></div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label order-label-margin"><i style="color: red"></i>
                                        代理客户:
                                    </label>
                                    <div class="col-md-2 control-label order-label-input-width">
                                        <form:input path="proxyName" htmlEscape="false" maxlength="20"
                                                    class="form-control  global-input order-label-input-width" placeholder="代理客户名称"/>
                                    </div>
                                    <label class="col-md-2 control-label  order-label-margin order-input-width"><i style="color: red"></i>
                                        订单类型:
                                    </label>
                                    <div class="col-md-2 control-label order-input-width " style="text-align: left">
                                        <form:select path="ordType" class="chosen-select  global-input order-input-width" cssStyle="min-width: 150px">
                                            <form:option cssClass="order-input-width" value="" label="" />
                                            <form:options cssClass="order-input-width" items="${fns:getCusDictList(101000)}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                                        </form:select>
                                    </div>
                                </div>


                                <div class="hr-line-dashed"></div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label order-label-margin"><i style="color: red">*</i>
                                        订单签订日期:
                                    </label>
                                    <div class="col-md-2 control-label order-date-width">
                                        <form:input path="ordSignDate" id="ordSignDate" htmlEscape="false"
                                                    maxlength="200"
                                                    class="input-sm form-control global-input order-date-width" placeholder="订单签订日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
                                    </div>
                                    <label class="col-md-2 control-label  order-label-margin order-input-width" style="margin-left: 107px;"><i style="color: red"></i>
                                        订单交付日期:
                                    </label>
                                    <div class="col-md-2 control-label order-date-width ">
                                        <form:input path="ordDeliveryDate" id="ordDeliveryDate" htmlEscape="false"
                                                    maxlength="200"
                                                    class="input-sm form-control global-input order-date-width" placeholder="订单交付日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
                                    </div>
                                </div>


                                <div class="hr-line-dashed"></div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label order-label-margin"><i style="color: red">*</i>
                                        我方签约人:
                                    </label>
                                    <div class="col-md-2 control-label order-label-input-width">
                                        <form:input path="comContractor" htmlEscape="false"
                                                    maxlength="10"
                                                    class="form-control global-input order-label-input-width" placeholder="我方签约人"/>
                                    </div>
                                    <label class="col-md-2 control-label order-label-margin order-input-width"><i style="color: red">*</i>
                                        客户签约人:
                                    </label>
                                    <div class="col-md-2 control-label order-label-input-width">
                                        <form:input path="cusContractor" htmlEscape="false"
                                                    maxlength="10"
                                                    class="form-control global-input order-label-input-width" placeholder="客户签约人"/>
                                    </div>
                                </div>

                                <div class="hr-line-dashed"></div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label order-label-margin"><i style="color: red"></i>
                                        备注信息：
                                    </label>
                                    <div class="col-md-2 control-label order-label-input-width">
                                        <form:textarea path="remarks" htmlEscape="false" maxlength="255"
                                                        cssClass="global-input order-label-input-width" rows="4"/>
                                    </div>
                                </div>


                                <div class="hr-line-dashed"></div>
                                <div class="form-group" >
                                    <div class="row">
                                        <div class="col-md-1">
                                            &nbsp;
                                        </div>
                                        <div class="col-md-6 " >
                                            <button class="btn btn-primary global-button-style" type="submit">保存订单</button>&nbsp;&nbsp;&nbsp;
                                            <c:if test="${not empty orderAddModifyVo.ordCode}"><button class="btn btn-primary global-button-style" type="button" onclick="prodlistAdd()">产品添加</button>&nbsp;&nbsp;&nbsp;
                                            </c:if>
                                            <button class="btn btn-primary global-button-style" type="button"
                                                    onclick="gotBackList()">返  回
                                            </button>
                                        </div>
                                    </div>
                                </div>

                            </form>
                        </div>
                        </form:form>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>



<script>
    function gotBackList(){
        window.location.href = "/crm/order/list";
    }

    $(document).ready(function () {
        $(".i-checks").iCheck({checkboxClass: "icheckbox_square-green", radioClass: "iradio_square-green",});
        // $("#ordSignDate").datepicker({
        //     todayBtn: "linked",
        //     keyboardNavigation: !1,
        //     forceParse: !1,
        //     calendarWeeks: !0,
        //     autoclose: !0
        // });
        // $("#ordDeliveryDate").datepicker({
        //     todayBtn: "linked",
        //     keyboardNavigation: !1,
        //     forceParse: !1,
        //     calendarWeeks: !0,
        //     autoclose: !0
        // })
        // $("select").change(function(){
        //     validate();
        // })
        $("#inputForm").validate({
            rules: {
                ordTitle: {
                    required: true
                },
                ordSignDate:{
                    required: true
                },
                comContractor: {
                    required: true
                },
                cusContractor: {
                    required: true
                }
            },
            messages: {
                ordTitle: {
                    required: "请输入订单标题"
                },
                ordSignDate: {
                    required: "请选择签订时间"
                },
                comContractor: {
                    required: "请输入我方签约人"
                },
                cusContractor: {
                    required: "请输入客户签约人"
                }
            },
            ignore:":hidden:not(select)",
            errorPlacement:function(error,element) {
                error.appendTo(element.parent());
            },
        });

        if($("#showCusCode").val() != null && $("#showCusCode").val() != undefined && $("#showCusCode").val() != ""){
            $("#cusCode").val($("#showCusCode").val());
            $("#cusCode").trigger("chosen:updated");
        }
    });
    function prodlistAdd() {
        var orderCode = $("#ordCode").val();
        if(orderCode == null || orderCode == '' || orderCode == undefined){
            layer.msg('请先保存订单');
            return;
        }
        window.location.href = "/order/prodDetailList?ordCode=" + orderCode;
    }


</script>

<script src="${ctxStatic}/hPlugs/js/jquery.min.js?v=2.1.4" type="text/javascript"></script>
<script src="${ctxStatic}/hPlugs/js/bootstrap.min.js?v=3.3.6" type="text/javascript"></script>
<script src="${ctxStatic}/hPlugs/js/content.min.js?v=1.0.0" type="text/javascript"></script>
<script src="${ctxStatic}/hPlugs/js/plugins/layer/layer.min.js"></script>
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

<script src="${ctxStatic}/hPlugs/js/plugins/validate/jquery.validate.min.js"></script>
<script src="${ctxStatic}/hPlugs/js/plugins/validate/messages_zh.min.js"></script>