<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>

<div class="tabs-container" style="padding: 20px 20px;">


    <div class="panel panel-default" style="border-color: #50B0E6; border-style: solid; border-width: 1px; border-radius:5px 5px 5px 5px;">
        <div class="panel-heading" style="background-color: #50B0E6">
            <h3 class="panel-title global-panel-title" >
                创建客户
            </h3>
            <code class="pull-right" style="margin-top: -25px"><span style="color: red; ">*</span>
                <small>为必填项</small>
            </code>
        </div>
        <div class="panel-body" style="padding: 10px 10px 0px 10px;">
            <form:form id="inputForm" modelAttribute="customerAddModifyVo" action="${ctx}/cus/customer_save"
                       method="post" class="form-horizontal">
                <form:hidden path="cusCode"/>
                <div class="row">
                            <div class="col-sm-6 b-r">
                                <div class="ibox float-e-margins">
                                    <form method="get" class="form-horizontal">
                                        <div class="ibox-title" style="border-width: 4px 0px 0px 4px; border-color: #eaeaea; background-color: #f1f5f7">
                                            <h3>基本信息</h3>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label"><i style="color: red">*</i> 客户名称：</label>
                                            <div class="col-sm-8">
                                                <form:input path="cusName" htmlEscape="false" maxlength="30"
                                                            class="form-control global-input" placeholder="客户名称"/>
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label"><i style="color: red">*</i> 所属行业：</label>
                                            <div class="col-sm-8">
                                                <form:select path="industry" cssClass="chosen-select global-input"
                                                             cssStyle="min-width: 300px">
                                                    <form:option value="" label=""/>
                                                    <form:options items="${fns:getCusDictList(120000)}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                                                </form:select>
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label"><i style="color: red">*</i> 客户类型：</label>
                                            <div class="col-sm-8">
                                                <div class="radio i-checks">
                                                    <c:if test="${empty customerAddModifyVo.cusType}">
                                                        <input type="radio" checked  value="110002" id="optionsRadios1"
                                                               name="cusType"><i></i>&nbsp;经销商
                                                    </c:if>
                                                    <c:if test="${not empty customerAddModifyVo.cusType}">
                                                        <input type="radio" ${customerAddModifyVo.cusType eq '110002' ? 'checked' : ''}  value="110002" id="optionsRadios1"
                                                               name="cusType"><i></i>&nbsp;经销商
                                                    </c:if>
                                                    <input type="radio" ${customerAddModifyVo.cusType eq '110001' ? 'checked' : ''} value="110001" id="optionsRadios2"
                                                           name="cusType"><i></i>&nbsp;散户

                                                </div>
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label"><i style="color: red">*</i> 客户状态：</label>
                                            <div class="col-sm-8">
                                                <form:select path="cusStatus" class="chosen-select"
                                                             cssStyle="min-width: 300px">
                                                    <form:option value="" label=""/>
                                                    <form:options items="${fns:getCusDictList(104000)}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                                                </form:select>
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label"><i style="color: red">*</i> 客户星级：</label>
                                            <div class="col-sm-8">
                                                <form:select path="cusGrade" class="chosen-select"
                                                             cssStyle="min-width: 300px">
                                                    <form:option value="" label=""/>
                                                    <form:options items="${fns:getCusDictList(105000)}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                                                </form:select>
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>

                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">客户来源：</label>
                                            <div class="col-sm-8">
                                                <form:select path="cusSource" class="chosen-select"
                                                             cssStyle="min-width: 300px">
                                                    <form:option value="" label=""/>
                                                    <form:options items="${fns:getCusDictList(106000)}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                                                </form:select>
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">详细地址：</label>
                                            <div class="col-sm-8">
                                                <form:input path="cusAddress" htmlEscape="false" maxlength="60"
                                                            class="form-control global-input" placeholder="详细地址"/>
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>

                                        <div class="form-group">
                                            <label class="col-sm-3 control-label"><i style="color: red">*</i> 归属人员：</label>
                                            <div class="col-sm-8">
                                                <%--<form:select path="empCode" class="chosen-select"--%>
                                                             <%--cssStyle="min-width: 300px">--%>
                                                    <%--<form:option value="" label=""/>--%>
                                                    <%--<form:options items="${fns:getEmpListByDept(109001)}" itemLabel="label" itemValue="value" htmlEscape="false"/>--%>
                                                <%--</form:select>--%>
                                                    <select id="cusContent" name="empCode" class="chosen-select" style="min-width: 300px">
                                                        <c:forEach items="${userList}" var="us">
                                                            <option value="${us.id}">${us.name}</option>
                                                        </c:forEach>
                                                    </select>
                                            </div>
                                        </div>

                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">备注信息：</label>
                                            <div class="col-sm-8">
                                                <form:textarea path="remarks" htmlEscape="false" cssClass="form-control global-input"
                                                               cssStyle="min-width: 300px;" rows="6" maxlength="100"/>
                                            </div>
                                        </div>

                                        <c:if test="${empty customerAddModifyVo.cusCode}">
                                        <div class="hr-line-dashed"></div>
                                        <div class="ibox-title" style="border-width: 4px 0px 0px 4px; border-color: #eaeaea; background-color: #f1f5f7">
                                            <h3>附加信息</h3>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">跟进内容：</label>
                                            <div class="col-sm-8">
                                                <input type="text" class="form-control global-input" name="followDetail" maxlength="100">
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label"><i style="color: red">*</i> 跟进人员：</label>
                                            <div class="col-sm-8">
                                                <select id="cusContent2" name="followEmpCode" class="chosen-select" style="min-width: 300px">
                                                    <c:forEach items="${userList}" var="us">
                                                        <option value="${us.id}">${us.name}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        </c:if>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="ibox-title" style="border-width: 4px 0px 0px 4px; border-color: #eaeaea; background-color: #f1f5f7">
                                    <h3>首要联系人</h3>
                                </div>
                                <div class="hr-line-dashed"></div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label"><i style="color: red">*</i> 联系人姓名：</label>
                                    <div class="col-sm-8">
                                        <form:input path="primaryContactorName" htmlEscape="false" maxlength="20"
                                                    class="form-control global-input" placeholder="首要联系人姓名"/>
                                    </div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">尊称：</label>
                                    <div class="col-sm-8">
                                        <div class="radio i-checks">
                                            <c:if test="${empty customerAddModifyVo.primaryContactorSex}">
                                                <input type="radio" name="primaryContactorSex" value="108003" checked> <i></i>未知
                                            </c:if>
                                            <c:if test="${not empty customerAddModifyVo.primaryContactorSex}">
                                                <input type="radio" name="primaryContactorSex" value="108003" ${customerAddModifyVo.primaryContactorSex eq '108003' ? 'checked' : ''}> <i></i>未知
                                            </c:if>
                                            <input type="radio" name="primaryContactorSex" value="108001" ${customerAddModifyVo.primaryContactorSex eq '108001' ? 'checked' : ''}> <i></i>先生
                                            <input type="radio" name="primaryContactorSex" value="108002" ${customerAddModifyVo.primaryContactorSex eq '108002' ? 'checked' : ''}> <i></i>女士
                                        </div>
                                    </div>
                                </div>

                                <div class="hr-line-dashed"></div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">角色：</label>

                                    <div class="col-sm-8">
                                            <%--<form:input path="primaryContactorRole" htmlEscape="false" maxlength="200"--%>
                                            <%--class="form-control" placeholder="首要联系人角色"/>--%>
                                        <form:select path="primaryContactorRole" class="chosen-select"
                                                     cssStyle="min-width: 300px">
                                            <form:options items="${fns:getCusDictList(130000)}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                                        </form:select>
                                    </div>
                                </div>

                                <div class="hr-line-dashed"></div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">生日：</label>

                                    <div class="col-sm-8">
                                        <form:input path="primaryContactorBirth" htmlEscape="false" maxlength="12"
                                                    class="form-control global-input" placeholder="首要联系人生日" />
                                    </div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">部门：</label>

                                    <div class="col-sm-8">
                                            <%--<form:input path="primaryContactorDepartment" htmlEscape="false" maxlength="200"--%>
                                            <%--class="form-control" placeholder="首要联系人部门"/>--%>
                                        <form:select path="primaryContactorDepartment" class="chosen-select"
                                                     cssStyle="min-width: 300px">
                                            <form:options items="${fns:getCusDictList(109000)}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                                        </form:select>
                                    </div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label"><i style="color: red">*</i> 手机号码：</label>

                                    <div class="col-sm-8">
                                        <form:input path="primaryContactorPhone" htmlEscape="false" type="number" maxlength="11"
                                                    class="form-control global-input" placeholder="首要联系人手机号码"/>
                                    </div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">电子邮箱：</label>

                                    <div class="col-sm-8">
                                        <form:input path="primaryContactorEmail" htmlEscape="false" maxlength="200"
                                                    class="form-control global-input" placeholder="首要联系人电子邮箱"/>
                                    </div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">详细地址：</label>

                                    <div class="col-sm-8">
                                        <form:input path="primaryContactorAddress" htmlEscape="false" maxlength="200"
                                                    class="form-control global-input" placeholder="首要联系人详细地址"/>
                                    </div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">备注信息：</label>

                                    <div class="col-sm-8">
                                        <form:textarea path="primaryContactorRemark" htmlEscape="false" cssClass="form-control global-input"
                                                       cssStyle="min-width: 300px; " rows="6"/>
                                    </div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group" style="text-align: center">
                                    <div class="row">
                                        <div class="col-sm-4 col-sm-offset-2" >
                                            <button class="btn btn-primary global-button-style" type="submit">保存客户</button>
                                        </div>
                                        <div class="col-sm-4 " >
                                            <button class="btn btn-white global-button-style" type="button" onclick="javascript:window.location.replace(document.referrer); ">返回</button>
                                        </div>
                                    </div>
                                </div>
                            </div>

                </div>
            </form:form>


        </div>
    </div>
</div>

<script>
    $(document).ready(function () {
        $(".i-checks").iCheck({checkboxClass: "icheckbox_square-green", radioClass: "iradio_square-green",});
        $("select").change(function(){
            $("#inputForm").valid();
        })
        $("#inputForm").validate({
            rules: {
                cusName: {
                    required: true
                },
                industry:{
                    required: true
                },
                cusStatus: {
                    required: true
                },
                cusGrade: {
                    required: true
                },
                primaryContactorName: {
                    required: true
                },
                primaryContactorPhone: {
                    required: true
                }
            },
            messages: {
                cusName: {
                    required: "请输入客户名称"
                },
                industry: {
                    required: "请选择客户类型"
                },
                cusStatus: {
                    required: "请选择客户状态"
                },
                cusGrade: {
                    required: "请选择客户星级"
                },
                primaryContactorName: {
                    required: "请输入联系人"
                },
                primaryContactorPhone: {
                    required: "请输入联系人手机号"
                }
            },
            ignore:":hidden:not(select)",
            errorPlacement:function(error,element) {
                error.appendTo(element.parent());
            },
        });
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
<script src="${ctxStatic}/hPlugs/js/plugins/validate/jquery.validate.min.js"></script>
<script src="${ctxStatic}/hPlugs/js/plugins/validate/messages_zh.min.js"></script>

<link rel="stylesheet" href="/static/common/customize.css">