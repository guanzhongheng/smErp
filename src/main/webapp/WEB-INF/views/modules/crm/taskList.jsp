<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>

<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5><i class="fa fa-bookmark"></i>&nbsp;基础信息</h5>
                </div>
                <div class="ibox-content">
                    <div class="row">
                        <div class="form-group col-sm-6">
                            <div class="input-group">
                                <span class="input-group-addon" style="width:100px;background-color: #EEEEEE">客户名称：</span>
                                <span class="form-control" type="text" style="min-width: 400px">123</span>

                            </div>
                            </br>
                            <div class="input-group">
                                <span class="input-group-addon" style="width:100px;background-color: #EEEEEE">客户类型：</span>
                                <span class="form-control" type="text" style="min-width: 400px"></span>
                            </div>
                            </br>
                            <div class="input-group">
                                <span class="input-group-addon" style="width:100px;background-color: #EEEEEE">客户星级：</span>
                                <span class="form-control" type="text" style="min-width: 400px"></span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <div class="input-group">
                                <span class="input-group-addon" style="width:100px;background-color: #EEEEEE">客户编号：</span>
                                <span class="form-control" type="text" style="min-width: 400px"></span>
                            </div>
                            </br>
                            <div class="input-group">
                                <span class="input-group-addon" style="width:100px;background-color: #EEEEEE">所属行业：</span>
                                <span class="form-control" type="text" style="min-width: 400px"></span>
                            </div>
                            </br>
                            <div class="input-group">
                                <span class="input-group-addon" style="width:100px;background-color: #EEEEEE">客户归属：</span>
                                <span class="form-control" type="text" style="min-width: 400px"></span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5><i class="fa fa-bookmark"></i>&nbsp;首联系人</h5>
                </div>
                <div class="ibox-content">
                    <div class="row">
                        <div class="form-group col-sm-6">
                            <div class="input-group">
                                <span class="input-group-addon" style="width:100px;background-color: #EEEEEE">联系人姓名：</span>
                                <span class="form-control" type="text" style="min-width: 400px">123</span>

                            </div>
                            </br>
                            <div class="input-group">
                                <span class="input-group-addon" style="width:100px;background-color: #EEEEEE">角色：</span>
                                <span class="form-control" type="text" style="min-width: 400px"></span>
                            </div>
                            </br>
                            <div class="input-group">
                                <span class="input-group-addon" style="width:100px;background-color: #EEEEEE">生日：</span>
                                <span class="form-control" type="text" style="min-width: 400px"></span>
                            </div>
                            </br>
                        </div>
                        <div class="form-group col-sm-6">
                            <div class="input-group">
                                <span class="input-group-addon" style="width:100px;background-color: #EEEEEE">手机号码：</span>
                                <span class="form-control" type="text" style="min-width: 400px"></span>
                            </div>
                            </br>
                            <div class="input-group">
                                <span class="input-group-addon" style="width:100px;background-color: #EEEEEE">部门职务：</span>
                                <span class="form-control" type="text" style="min-width: 400px"></span>
                            </div>
                            </br>
                            <div class="input-group">
                                <span class="input-group-addon" style="width:100px;background-color: #EEEEEE">固定电话：</span>
                                <span class="form-control" type="text" style="min-width: 400px"></span>
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
<script id="treeselectTpl" type="text/template">//<!--<div>
<#form:treeselect id="{{d.id}}" title="{{d.title}}" name="{{d.name}}" value="{{d.value}}"
	labelName="{{d.labelName}}" labelValue="{{d.labelValue}}" url="{{d.url}}"
	class="{{d.cssClass}}" btnClass="btn-sm" allowClear="true"/>
</div>//--></script>
<script>

</script>
