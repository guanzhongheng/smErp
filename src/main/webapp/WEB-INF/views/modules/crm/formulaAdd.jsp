<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<jsp:useBean id="formula" class="com.lcyzh.nmerp.model.vo.FormulaVo" scope="request"/>


<div class="tabs-container" style="padding: 20px 20px;">
    <div class="panel panel-default" style="border-color: #50B0E6; border-style: solid; border-width: 1px; border-radius:5px 5px 5px 5px;">
        <div class="panel-heading" style="background-color: #50B0E6">
            <h3 class="panel-title global-panel-title" >
                <c:if test="${fCode eq null}">创建配方</c:if>
                <c:if test="${fCode ne null}">编辑配方</c:if>
            </h3>
            <code class="pull-right" style="margin-top: -21px; margin-right: 8px"><span style="color: red; ">*</span>
                <small>为必填项</small>
            </code>
        </div>
        <div class="panel-body" style="padding: 0px;">
            <ul class="nav nav-tabs">
                <c:if test="${fCode eq null}">
                    <li class="active"><a data-toggle="tab" href="#tab-1" aria-expanded="true">配方基本信息</a></li>
                </c:if>
                <c:if test="${fCode ne null}">
                    <li <c:if test="${type eq null}"> class="active" </c:if>
                    ><a href="${ctx}/formula/addOrUpdate?fCode=${fCode}">配方基本信息</a></li>
                    <li <c:if test="${type eq 'outer'}"> class="active" </c:if>
                    ><a href="${ctx}/formula/updateDetail?fCode=${fCode}&type=outer">外层配比</a></li>
                    <li <c:if test="${type eq 'midder'}"> class="active" </c:if>
                    ><a href="${ctx}/formula/updateDetail?fCode=${fCode}&type=midder">中层配比</a></li>
                    <li <c:if test="${type eq 'inner'}"> class="active" </c:if>
                    ><a href="${ctx}/formula/updateDetail?fCode=${fCode}&type=inner">内层配比</a></li>
                </c:if>
            </ul>

            <form:form id="inputForm" modelAttribute="formula" action="${ctx}/formula/save"
                       method="post" class="form-horizontal">
                <c:if test="${fCode ne null}"><form:hidden path="fCode"/></c:if>
                <div class="row">
                    <br/>
                    <div class="col-sm-12">
                        <div class="ibox float-e-margins">

                            <div class="form-group">
                                <label class="col-sm-3 control-label"><i style="color: red">*</i> 配方名称：</label>
                                <div class="col-sm-8">
                                    <form:input path="fName" htmlEscape="false" maxlength="20"
                                                class="form-control global-input" placeholder="配方名称"/>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label"><i style="color: red">*</i> 产品品种：</label>
                                <div class="col-sm-8">
                                    <form:select path="prodVariety" cssClass="chosen-select global-input"
                                                 disabled="${formula.prodVariety ne null ? 'true':'false'}"
                                                 cssStyle="min-width: 300px">

                                        <form:option value="" label=""/>
                                        <form:options items="${fns:getCusDictList(148000)}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                                    </form:select>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label"><i style="color: red">*</i> 产品类别：</label>
                                <div class="col-sm-8">
                                    <form:select path="prodCgyCode" cssClass="chosen-select global-input"
                                                 disabled="${formula.prodCgyCode ne null ? 'true':'false'}"
                                                 cssStyle="min-width: 300px">
                                        <form:option value="" label=""/>
                                        <form:options items="${fns:getCusDictList(149000)}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                                    </form:select>
                                </div>
                            </div>

                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">备注信息：</label>
                                <div class="col-sm-8">
                                    <form:textarea path="remarks" htmlEscape="false" cssClass="form-control global-input"
                                                   cssStyle="min-width: 300px;" rows="6" maxlength="255"/>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group" style="text-align: left">
                                <div class="col-md-6 ">
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <button class="btn btn-primary global-button-style" type="submit">保存</button>
                                        <a href="/crm/formula/list" class="btn btn-white global-button-style" style="width: 130px;font-size: 18px;height: 40px;margin-left: 43px;" type="button" >返回</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form:form>
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
<script src="${ctxStatic}/hPlugs/js/plugins/validate/jquery.validate.min.js"></script>
<script src="${ctxStatic}/hPlugs/js/plugins/validate/messages_zh.min.js"></script>

<link rel="stylesheet" href="/static/common/customize.css">
<script>
    $(document).ready(function () {
        $(".i-checks").iCheck({checkboxClass: "icheckbox_square-green", radioClass: "iradio_square-green",});
        var fCode = '${fCode}';
        if(fCode != '' && fCode != undefined){
           // $("#fName").attr("readonly","readonly");
        }

        $("select").change(function(){
            $("#inputForm").valid();
        });
        $("#inputForm").validate({
            rules: {
                fName: {
                    required: true
                },
                prodVariety:{
                    required: true
                },
                prodCgyCode: {
                    required: true
                }
            },
            messages: {
                fName: {
                    required: "请输入配方名称"
                },
                prodVariety: {
                    required: "请选择产品品种"
                },
                prodCgyCode: {
                    required: "请选择产品类别"
                }
            },
            ignore:":hidden:not(select)",
            errorPlacement:function(error,element) {
                error.appendTo(element.parent());
            },
        });
        $("#prodVariety").append("<option value='${formula.prodVariety}' selected>Text</option>");
    });


</script>
