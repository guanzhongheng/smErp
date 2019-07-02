<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>

<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox-title">
                <h5>创建客户</h5>
                <code class="pull-right"><span style="color: red">*</span>
                    <small>为必填项</small>
                </code>
            </div>
            <div class="ibox-content">

                <form:form id="inputForm" modelAttribute="customerAddModifyVo" action="${ctx}/cus/customer_save"
                           method="post" class="form-horizontal">
                    <div class="row">
                        <div class="col-sm-6 b-r">
                            <div class="ibox float-e-margins">
                                <form method="get" class="form-horizontal">
                                    <h3>基本信息</h3>
                                    <div class="hr-line-dashed"></div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label"><i style="color: red">*</i> 客户名称：</label>
                                        <div class="col-sm-8">
                                            <form:input path="cusName" htmlEscape="false" maxlength="200"
                                                        class="form-control" placeholder="客户名称"/>
                                        </div>
                                    </div>
                                    <div class="hr-line-dashed"></div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label"><i style="color: red">*</i> 所属行业：</label>
                                        <div class="col-sm-8">
                                            <form:select path="industry" class="chosen-select" placeholder="所属行业"
                                                         cssStyle="min-width: 300px">
                                                <form:option value="" label=""/>
                                                <form:option value="1" label="12"/>
                                                <%--<form:options items="${fns:getDictList('oa_notify_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>--%>
                                            </form:select>
                                        </div>
                                    </div>
                                    <div class="hr-line-dashed"></div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label"><i style="color: red">*</i> 客户类型：</label>
                                        <div class="col-sm-8">
                                            <div class="radio i-checks">
                                                <input type="radio" checked="" value="1" id="optionsRadios1"
                                                       name="cusType"><i></i>&nbsp;企业客户
                                                <input type="radio" value="2" id="optionsRadios2"
                                                       name="cusType"><i></i>&nbsp;个人客户
                                            </div>
                                        </div>
                                    </div>
                                    <div class="hr-line-dashed"></div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label"><i style="color: red">*</i> 客户状态：</label>
                                        <div class="col-sm-8">
                                            <form:select path="cusStatus" class="chosen-select" placeholder="客户状态"
                                                         cssStyle="min-width: 300px">
                                                <form:option value="" label=""/>
                                                <form:option value="1" label="12"/>
                                                <%--<form:options items="${fns:getDictList('oa_notify_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>--%>
                                            </form:select>
                                        </div>
                                    </div>
                                    <div class="hr-line-dashed"></div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label"><i style="color: red">*</i> 客户星级：</label>
                                        <div class="col-sm-8">
                                            <form:select path="cusGrade" class="chosen-select" placeholder="客户星级"
                                                         cssStyle="min-width: 300px">
                                                <form:option value="" label=""/>
                                                <form:option value="1" label="1"/>
                                                <%--<form:options items="${fns:getDictList('oa_notify_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>--%>
                                            </form:select>
                                        </div>
                                    </div>
                                    <div class="hr-line-dashed"></div>

                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">客户来源：</label>
                                        <div class="col-sm-8">
                                            <form:select path="cusSource" class="chosen-select" placeholder="客户来源"
                                                         cssStyle="min-width: 300px">
                                                <form:option value="" label=""/>
                                                <form:option value="1" label="1"/>
                                                <%--<form:options items="${fns:getDictList('oa_notify_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>--%>
                                            </form:select>
                                        </div>
                                    </div>
                                    <div class="hr-line-dashed"></div>

                                    <div class="form-group">
                                        <label class="col-sm-3 control-label"><i style="color: red">*</i> 归属人员：</label>
                                        <div class="col-sm-8">
                                            <form:select path="empCode" class="chosen-select" placeholder="归属人员"
                                                         cssStyle="min-width: 300px">
                                                <form:option value="" label=""/>
                                                <form:option value="1" label="2"/>
                                                <%--<form:options items="${fns:getDictList('oa_notify_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>--%>
                                            </form:select>
                                        </div>
                                    </div>
                                    <div class="hr-line-dashed"></div>

                                    <h3>附加信息</h3>
                                    <div class="hr-line-dashed"></div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">详细地址：</label>
                                        <div class="col-sm-8">
                                            <form:input path="cusAddress" htmlEscape="false" maxlength="200"
                                                        class="form-control" placeholder="客户名称"/>
                                        </div>
                                    </div>
                                    <div class="hr-line-dashed"></div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">备注信息：</label>
                                        <div class="col-sm-8">
                                            <form:textarea path="remarks" htmlEscape="false"
                                                           cssStyle="min-width: 300px;" rows="6"/>
                                        </div>
                                    </div>
                                    <c:if test="${not empty customerAddModifyVo.cusCode}">
                                    <div class="hr-line-dashed"></div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">跟进内容：</label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control" name="">
                                        </div>
                                    </div>
                                    <div class="hr-line-dashed"></div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label"><i style="color: red">*</i> 跟进人员：</label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control" name="password"
                                                   value="${customerAddModifyVo.cusName}">
                                        </div>
                                    </div>
                                    </c:if>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <h3>首要联系人</h3>
                            <div class="hr-line-dashed"></div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label"><i style="color: red">*</i> 联系人姓名：</label>
                                <div class="col-sm-8">
                                    <form:input path="primaryContactorName" htmlEscape="false" maxlength="200"
                                                class="form-control" placeholder="首要联系人姓名"/>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">尊称：</label>
                                <div class="col-sm-8">
                                    <div class="radio i-checks">
                                        <input type="checkbox" name="primaryContactorSex" value="" checked=""> <i></i>未知
                                        <input type="checkbox" name="primaryContactorSex" value=""> <i></i>先生
                                        <input type="checkbox" name="primaryContactorSex" value=""> <i></i>女士
                                    </div>
                                </div>
                            </div>

                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">角色：</label>

                                <div class="col-sm-8">
                                    <form:input path="primaryContactorRole" htmlEscape="false" maxlength="200"
                                                class="form-control" placeholder="首要联系人角色"/>
                                </div>
                            </div>

                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">生日：</label>

                                <div class="col-sm-8">
                                    <form:input path="primaryContactorBirth" htmlEscape="false" maxlength="200"
                                                class="form-control" placeholder="首要联系人生日"/>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">部门：</label>

                                <div class="col-sm-8">
                                    <form:input path="primaryContactorDepartment" htmlEscape="false" maxlength="200"
                                                class="form-control" placeholder="首要联系人生日"/>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label"><i style="color: red">*</i> 手机号码：</label>

                                <div class="col-sm-8">
                                    <form:input path="primaryContactorPhone" htmlEscape="false" maxlength="200"
                                                class="form-control" placeholder="首要联系人生日"/>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">电子邮箱：</label>

                                <div class="col-sm-8">
                                    <form:input path="primaryContactorEmail" htmlEscape="false" maxlength="200"
                                                class="form-control" placeholder="首要联系人生日"/>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">详细地址：</label>

                                <div class="col-sm-8">
                                    <form:input path="primaryContactorAddress" htmlEscape="false" maxlength="200"
                                                class="form-control" placeholder="首要联系人生日"/>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">备注信息：</label>

                                <div class="col-sm-8">
                                    <form:textarea path="primaryContactorRemark" htmlEscape="false"
                                                   cssStyle="min-width: 300px;" rows="6"/>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-2">
                                <button class="btn btn-primary" type="submit">创建客户</button>
                                &nbsp;&nbsp;
                                <button class="btn btn-white" type="button" onclick="history.go(-1)">返回</button>
                            </div>
                        </div>
                    </div>
                </form:form>
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
