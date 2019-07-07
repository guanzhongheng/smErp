<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>

<div class="wrapper wrapper-content animated fadeInRight">
    <div class="tabs-container">


        <ul class="nav nav-tabs">
            <li class="active"><a data-toggle="tab" href="#tab-1" aria-expanded="true">客户详情</a>
            </li>
        </ul>
        <div class="tab-content">
            <div id="tab-1" class="tab-pane active">
                <div class="panel-body">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="ibox-title">
                                <h5>客户详情</h5>
                                <code class="pull-right"><span style="color: red">*</span>
                                    <small>为必填项</small>
                                </code>
                            </div>
                            <div class="ibox-content">

                                <form:form id="inputForm" modelAttribute="customerAddModifyVo" action="${ctx}/cus/customer_save"
                                           method="post" class="form-horizontal">
                                    <form:hidden path="cusCode"/>
                                    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
                                    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
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
                                                                        class="form-control" placeholder="客户名称" readonly="true"/>
                                                        </div>
                                                    </div>
                                                    <div class="hr-line-dashed"></div>
                                                    <div class="form-group">
                                                        <label class="col-sm-3 control-label"><i style="color: red">*</i> 所属行业：</label>
                                                        <div class="col-sm-8">
                                                            <form:select path="industry" class="chosen-select"
                                                                         cssStyle="min-width: 300px" readonly="true">
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
                                                                    <input type="radio" checked  readonly="true" value="110002" id="optionsRadios1"
                                                                           name="cusType"><i></i>&nbsp;企业客户
                                                                </c:if>
                                                                <c:if test="${not empty customerAddModifyVo.cusType}">
                                                                    <input type="radio" ${customerAddModifyVo.cusType eq '110002' ? 'checked' : ''} readonly="true" value="110002" id="optionsRadios1"
                                                                           name="cusType"><i></i>&nbsp;企业客户
                                                                </c:if>
                                                                <input type="radio" ${customerAddModifyVo.cusType eq '110001' ? 'checked' : ''} readonly="true" value="110001" id="optionsRadios2"
                                                                       name="cusType"><i></i>&nbsp;个人客户
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="hr-line-dashed"></div>
                                                    <div class="form-group">
                                                        <label class="col-sm-3 control-label"><i style="color: red">*</i> 客户状态：</label>
                                                        <div class="col-sm-8">
                                                            <form:select path="cusStatus" class="chosen-select"
                                                                         cssStyle="min-width: 300px" readonly="true">
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
                                                                         cssStyle="min-width: 300px" readonly="true">
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
                                                                         cssStyle="min-width: 300px" readonly="true">
                                                                <form:option value="" label=""/>
                                                                <form:options items="${fns:getCusDictList(106000)}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                                                            </form:select>
                                                        </div>
                                                    </div>
                                                    <div class="hr-line-dashed"></div>

                                                    <div class="form-group">
                                                        <label class="col-sm-3 control-label"><i style="color: red">*</i> 归属人员：</label>
                                                        <div class="col-sm-8">
                                                            <form:select path="empCode" class="chosen-select"
                                                                         cssStyle="min-width: 300px" readonly="true">
                                                                <form:option value="" label=""/>
                                                                <form:options items="${fns:getEmpListByDept(109001)}" itemLabel="label" itemValue="value" htmlEscape="false"/>
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
                                                                        class="form-control" placeholder="详细地址" readonly="true"/>
                                                        </div>
                                                    </div>
                                                    <div class="hr-line-dashed"></div>
                                                    <div class="form-group">
                                                        <label class="col-sm-3 control-label">备注信息：</label>
                                                        <div class="col-sm-8">
                                                            <form:textarea path="remarks" htmlEscape="false"
                                                                           cssStyle="min-width: 300px;" rows="6" readonly="true"/>
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
                                                            <input type="text" class="form-control" name="password" readonly="true"
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
                                                                class="form-control" placeholder="首要联系人姓名" readonly="true"/>
                                                </div>
                                            </div>
                                            <div class="hr-line-dashed"></div>
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label">尊称：</label>
                                                <div class="col-sm-8">
                                                    <div class="radio i-checks">
                                                        <c:if test="${empty customerAddModifyVo.primaryContactorSex}">
                                                            <input type="radio" name="primaryContactorSex" value="108003" readonly="true" checked> <i></i>未知
                                                        </c:if>
                                                        <c:if test="${not empty customerAddModifyVo.primaryContactorSex}">
                                                            <input type="radio" name="primaryContactorSex" value="108003" readonly="true" ${customerAddModifyVo.primaryContactorSex eq '108003' ? 'checked' : ''}> <i></i>未知
                                                        </c:if>
                                                        <input type="radio" name="primaryContactorSex" value="108001" readonly="true" ${customerAddModifyVo.primaryContactorSex eq '108001' ? 'checked' : ''}> <i></i>先生
                                                        <input type="radio" name="primaryContactorSex" value="108002" readonly="true" ${customerAddModifyVo.primaryContactorSex eq '108002' ? 'checked' : ''}> <i></i>女士
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
                                                                 cssStyle="min-width: 300px" readonly="true">
                                                        <form:options items="${fns:getCusDictList(130000)}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                                                    </form:select>
                                                </div>
                                            </div>

                                            <div class="hr-line-dashed"></div>
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label">生日：</label>

                                                <div class="col-sm-8">
                                                    <form:input path="primaryContactorBirth" htmlEscape="false" maxlength="200"
                                                                class="form-control" placeholder="首要联系人生日" readonly="true"/>
                                                </div>
                                            </div>
                                            <div class="hr-line-dashed"></div>
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label">部门：</label>

                                                <div class="col-sm-8">
                                                        <%--<form:input path="primaryContactorDepartment" htmlEscape="false" maxlength="200"--%>
                                                        <%--class="form-control" placeholder="首要联系人部门"/>--%>
                                                    <form:select path="primaryContactorDepartment" class="chosen-select"
                                                                 cssStyle="min-width: 300px" readonly="true">
                                                        <form:options items="${fns:getCusDictList(109000)}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                                                    </form:select>
                                                </div>
                                            </div>
                                            <div class="hr-line-dashed"></div>
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label"><i style="color: red">*</i> 手机号码：</label>

                                                <div class="col-sm-8">
                                                    <form:input path="primaryContactorPhone" htmlEscape="false" maxlength="200"
                                                                class="form-control" placeholder="首要联系人手机号码" readonly="true"/>
                                                </div>
                                            </div>
                                            <div class="hr-line-dashed"></div>
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label">电子邮箱：</label>

                                                <div class="col-sm-8">
                                                    <form:input path="primaryContactorEmail" htmlEscape="false" maxlength="200"
                                                                class="form-control" placeholder="首要联系人电子邮箱" readonly="true"/>
                                                </div>
                                            </div>
                                            <div class="hr-line-dashed"></div>
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label">详细地址：</label>

                                                <div class="col-sm-8">
                                                    <form:input path="primaryContactorAddress" htmlEscape="false" maxlength="200"
                                                                class="form-control" placeholder="首要联系人详细地址" readonly="true"/>
                                                </div>
                                            </div>
                                            <div class="hr-line-dashed"></div>
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label">备注信息：</label>

                                                <div class="col-sm-8">
                                                    <form:textarea path="primaryContactorRemark" htmlEscape="false"
                                                                   cssStyle="min-width: 300px;" rows="6" readonly="true"/>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group">
                                            <button class="btn btn-primary" type="button" onclick="history.go(-1)">返回</button>
                                        </div>
                                    </div>
                                </form:form>
                            </div>
                        </div>
                    </div>


                    <div class="row animated fadeInRight">
                        <div class="col-sm-12">
                            <div class="ibox float-e-margins">
                                <div class="ibox-title">
                                    <h5>客户跟进信息</h5>
                                </div>
                                <div class="ibox-content timeline">
                                    <c:forEach items="${follow}" var="fo">
                                        <div class="timeline-item">
                                            <div class="row">
                                                <div class="col-xs-3 date">
                                                    <i class="fa fa-file-text"></i>${fo.followTime}
                                                    <br>
                                                </div>
                                                <div class="col-xs-9 content">
                                                    <p class="m-b-xs"><strong>${fo.followType}</strong>
                                                    </p>
                                                    <p>${fo.followDetail}</p>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
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
<script src="${ctxStatic}/hPlugs/js/plugins/peity/jquery.peity.min.js"></script>
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
