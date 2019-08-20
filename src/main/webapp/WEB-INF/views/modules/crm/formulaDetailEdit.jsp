<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<jsp:useBean id="detailVo" class="com.lcyzh.nmerp.model.vo.FormulaDetailVo" scope="request"/>
<link rel="stylesheet" href="/static/common/customize.css">


<div class="tabs-container" style="padding: 20px 20px;">
    <div class="panel panel-default" style="border-color: #50B0E6; border-style: solid; border-width: 1px; border-radius:5px 5px 5px 5px;">
        <div class="panel-heading" style="background-color: #50B0E6">
            <h3 class="panel-title global-panel-title" >
                编辑配比:
                <c:if test="${type eq 'outer'}"> 外层 </c:if>
                <c:if test="${type eq 'midder'}"> 中层 </c:if>
                <c:if test="${type eq 'inner'}"> 内层 </c:if>
            </h3>
            <code class="pull-right" style="margin-top: -21px; margin-right: 8px"><span style="color: red; ">*</span>
                <small>为必填项</small>
            </code>
        </div>
        <div class="panel-body" style="padding: 0px;">
            <ul class="nav nav-tabs">
                <li <c:if test="${type eq null}"> class="active" </c:if>
                ><a href="${ctx}/formula/addOrUpdate?fCode=${fCode}">配方基本信息</a></li>
                <li <c:if test="${type eq 'outer'}"> class="active" </c:if>
                ><a href="${ctx}/formula/updateDetail?fCode=${fCode}&type=outer">外层配比</a></li>
                <li <c:if test="${type eq 'midder'}"> class="active" </c:if>
                ><a href="${ctx}/formula/updateDetail?fCode=${fCode}&type=midder">中层配比</a></li>
                <li <c:if test="${type eq 'inner'}"> class="active" </c:if>
                ><a href="${ctx}/formula/updateDetail?fCode=${fCode}&type=inner">内层配比</a></li>
            </ul>
            <form:form id="inputForm" modelAttribute="detailVo" action="${ctx}/formula/detailSave"
                       method="post" class="form-horizontal">
                <input type="hidden" name="fCode" value="${fCode}"/>
                <input type="hidden" name="type" value="${type}"/>
                <div class="row">
                    <br/>
                    <div class="col-sm-6 b-r">
                        <div class="ibox float-e-margins">
                            <form method="get" class="form-horizontal">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label"><i style="color: red">*</i> 温度标准（℃）：</label>
                                    <div class="col-sm-8">
                                        <form:input path="temperature" htmlEscape="false" maxlength="10"
                                                    class="form-control global-input" placeholder="温度" />
                                    </div>
                                </div>

                                <div class="hr-line-dashed"></div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">备注信息：</label>
                                    <div class="col-sm-8">
                                        <form:textarea path="remarks" htmlEscape="false" cssClass="form-control global-input"
                                                       cssStyle="min-width: 300px;" rows="6" maxlength="255" value=""/>
                                    </div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group" style="text-align: center">
                                    <button class="btn btn-primary global-button-style" onclick="addRow()" type="button">增加原料</button>
                                    <button class="btn btn-primary global-button-style" type="submit">保存</button>
                                    <a href="/crm/formula/list" class="btn btn-white global-button-style" type="button" >返回</a>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="ibox float-e-margins">
                            <div class="table-responsive" style="min-height: 300px;">
                                <table id="contentTable" class="table table-striped table-bordered table-hover text-nowrap">
                                    <thead>
                                    <tr>
                                        <th style="text-align: center">原料</th>
                                        <th style="text-align: center">数量</th>
                                        <th style="text-align: center">操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${detailVo.rawMaterialVos}" var="vo" varStatus="status">
                                        <tr>
                                            <td>
                                                <input type="hidden" name="rawMaterialVos[${status.index}].rawmName" value="${vo.rawmName}">
                                                <select class="chosen-select" name="rawMaterialVos[${status.index}].rawmCode" onchange="setRmValue(this)">
                                                    <option value ="${vo.rawmCode}" >${vo.rawmName}</option>
                                                    <c:forEach items="${rmList}" var="rm">
                                                        <option value ="${rm.rawmCode}" >${rm.rawmName}</option>
                                                    </c:forEach>
                                                </select>
                                            </td>
                                            <td><input type="text" class="form-control" name="rawMaterialVos[${status.index}].weight" value="${vo.weight}"/></td>
                                            <td>
                                                <button class="btn btn-primary global-button-style" onclick="delRow(this)" type="button">删除</button>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </form:form>
        </div>

    </div>
</div>





<%--<div class="wrapper wrapper-content animated fadeInRight">--%>
        <%--<div class="tab-content">--%>
            <%--<div id="tab-1" class="tab-pane active">--%>
                <%--<div class="panel-body" style="padding: 10px 10px 0px 10px;">--%>
                    <%--<div class="panel panel-default" style="border-color: #50B0E6; border-style: solid; border-width: 1px; border-radius:5px 5px 5px 5px;">--%>
                        <%--<div class="panel-heading" style="background-color: #50B0E6">--%>
                            <%--<h3 class="panel-title global-panel-title" >--%>
                                <%--编辑配比:--%>
                                <%--<c:if test="${type eq 'outer'}"> 外层 </c:if>--%>
                                <%--<c:if test="${type eq 'midder'}"> 中层 </c:if>--%>
                                <%--<c:if test="${type eq 'inner'}"> 内层 </c:if>--%>
                            <%--</h3>--%>
                            <%--<code class="pull-right" style="margin-top: -25px"><span style="color: red; ">*</span>--%>
                                <%--<small>为必填项</small>--%>
                            <%--</code>--%>
                        <%--</div>--%>
                        <%--<ul class="nav nav-tabs">--%>

                            <%--<li <c:if test="${type eq null}"> class="active" </c:if>--%>
                            <%--><a href="${ctx}/formula/addOrUpdate?fCode=${fCode}">配方基本信息</a></li>--%>
                            <%--<li <c:if test="${type eq 'outer'}"> class="active" </c:if>--%>
                            <%--><a href="${ctx}/formula/updateDetail?fCode=${fCode}&type=outer">外层配比</a></li>--%>
                            <%--<li <c:if test="${type eq 'midder'}"> class="active" </c:if>--%>
                            <%--><a href="${ctx}/formula/updateDetail?fCode=${fCode}&type=midder">中层配比</a></li>--%>
                            <%--<li <c:if test="${type eq 'inner'}"> class="active" </c:if>--%>
                            <%--><a href="${ctx}/formula/updateDetail?fCode=${fCode}&type=inner">内层配比</a></li>--%>
                        <%--</ul>--%>
                        <%--<form:form id="inputForm" modelAttribute="detailVo" action="${ctx}/formula/detailSave"--%>
                                   <%--method="post" class="form-horizontal">--%>
                            <%--<input type="hidden" name="fCode" value="${fCode}"/>--%>
                            <%--<input type="hidden" name="type" value="${type}"/>--%>
                            <%--<div class="row">--%>
                                <%--<br/>--%>
                                <%--<div class="col-sm-6 b-r">--%>
                                    <%--<div class="ibox float-e-margins">--%>
                                        <%--<form method="get" class="form-horizontal">--%>
                                            <%--<div class="form-group">--%>
                                                <%--<label class="col-sm-3 control-label"><i style="color: red">*</i> 温度标准（℃）：</label>--%>
                                                <%--<div class="col-sm-8">--%>
                                                    <%--<form:input path="temperature" htmlEscape="false" maxlength="10"--%>
                                                                <%--class="form-control global-input" placeholder="温度" />--%>
                                                <%--</div>--%>
                                            <%--</div>--%>

                                            <%--<div class="hr-line-dashed"></div>--%>
                                            <%--<div class="form-group">--%>
                                                <%--<label class="col-sm-3 control-label">备注信息：</label>--%>
                                                <%--<div class="col-sm-8">--%>
                                                    <%--<form:textarea path="remarks" htmlEscape="false" cssClass="form-control global-input"--%>
                                                                   <%--cssStyle="min-width: 300px;" rows="6" maxlength="255" value=""/>--%>
                                                <%--</div>--%>
                                            <%--</div>--%>
                                            <%--<div class="hr-line-dashed"></div>--%>
                                            <%--<div class="form-group" style="text-align: center">--%>
                                                    <%--<button class="btn btn-primary global-button-style" onclick="addRow()" type="button">增加原料</button>--%>
                                                    <%--<button class="btn btn-primary global-button-style" type="submit">保存</button>--%>
                                                    <%--<a href="/crm/formula/list" class="btn btn-white global-button-style" type="button" >返回</a>--%>
                                            <%--</div>--%>
                                        <%--</form>--%>
                                    <%--</div>--%>
                                <%--</div>--%>
                                <%--<div class="col-sm-6">--%>
                                    <%--<div class="ibox float-e-margins">--%>
                                        <%--<div class="table-responsive" style="min-height: 300px;">--%>
                                            <%--<table id="contentTable" class="table table-striped table-bordered table-hover text-nowrap">--%>
                                                <%--<thead>--%>
                                                <%--<tr>--%>
                                                    <%--<th style="text-align: center">原料</th>--%>
                                                    <%--<th style="text-align: center">数量</th>--%>
                                                    <%--<th style="text-align: center">操作</th>--%>
                                                <%--</tr>--%>
                                                <%--</thead>--%>
                                                <%--<tbody>--%>
                                                <%--<c:forEach items="${detailVo.rawMaterialVos}" var="vo" varStatus="status">--%>
                                                    <%--<tr>--%>
                                                        <%--<td>--%>
                                                            <%--<input type="hidden" name="rawMaterialVos[${status.index}].rawmName" value="${vo.rawmName}">--%>
                                                            <%--<select class="chosen-select" name="rawMaterialVos[${status.index}].rawmCode" onchange="setRmValue(this)">--%>
                                                                <%--<option value ="${vo.rawmCode}" >${vo.rawmName}</option>--%>
                                                                <%--<c:forEach items="${rmList}" var="rm">--%>
                                                                    <%--<option value ="${rm.rawmCode}" >${rm.rawmName}</option>--%>
                                                                <%--</c:forEach>--%>
                                                            <%--</select>--%>
                                                        <%--</td>--%>
                                                        <%--<td><input type="text" class="form-control" name="rawMaterialVos[${status.index}].weight" value="${vo.weight}"/></td>--%>
                                                        <%--<td>--%>
                                                            <%--<button class="btn btn-primary global-button-style" onclick="delRow(this)" type="button">删除</button>--%>
                                                        <%--</td>--%>
                                                    <%--</tr>--%>
                                                <%--</c:forEach>--%>
                                                <%--</tbody>--%>
                                            <%--</table>--%>
                                        <%--</div>--%>
                                    <%--</div>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</form:form>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>
<%--</div>--%>

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
<script>
    /*准备工作*/
    var rmList = new Array();
    $.ajax({
        type: "POST",
        url: '/formula/ajaxRmList',
        dataType:'json',
        cache: false,
        success: function(data){
            if(data != null){
                rmList = data;
            }
        }
    });

    var current = '${detailVo.rawMaterialVos == null ? 0:detailVo.rawMaterialVos.size()}';
    console.log(current);

    /*逻辑部分*/
    function delRow(obj){
        $(obj).parents("tr").remove();
    }

    function setRmValue(obj){
        var rawmCode = $(obj).val();
        $.each(rmList,function(i,rm){
            if(rawmCode == rm.rawmCode){
                $(obj).prev().val(rm.rawmName);
                // $(obj).next().val(rm.rawnSpecs);
            }
        });
    }

    function addRow(){
        var rownum = current++;

        var headOption = "<option value =''>请选择原料</option>";
        if(rmList != null || rmList != undefined){
            $.each(rmList,function(i,obj){
                headOption = headOption + "<option value='"+obj.rawmCode+"'>"+obj.rawmName+"</option>";
                // headOption = headOption + "<option value='"+obj.rawmCode+"'>"+obj.rawmName+"("+obj.rawnSpecs+")"+"</option>";
            });
        }
        var option = "<select class='chosen-select' name='rawMaterialVos["+ rownum +"].rawmCode' onchange='setRmValue(this)'>" + headOption + "</select>";

        var tr ="<tr><td>" +
                "<input type='hidden' name='rawMaterialVos["+ rownum +"].rawmName' value=''>" +
                option +
                // "<input type='hidden' name='rawMaterialVos["+ rownum +"].rawnSpecs' value=''>" +
                "</td>" +
                "<td><input  class='form-control' type='text' name='rawMaterialVos["+ rownum +"].weight' /></td>" +
                "<td><button class='btn btn-primary global-button-style' onclick='delRow(this)' type='button'>删除</button></td></tr>";
        $("#contentTable").append(tr);
         $('.chosen-select').chosen();
    }

    $(document).ready(function () {

        $(".i-checks").iCheck({checkboxClass: "icheckbox_square-green", radioClass: "iradio_square-green",});
        // $("select").change(function(){
        //     validate();
        // })
        $("#inputForm").validate({
            rules: {
                temperature: {
                    required: true
                }
            },
            messages: {
                temperature: {
                    required: "请输入温度"
                }
            },
            ignore:":hidden:not(select)",
            errorPlacement:function(error,element) {
                error.appendTo(element.parent());
            },
        });
        $('.chosen-select').chosen();

    });


</script>