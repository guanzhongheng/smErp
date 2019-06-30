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
                <div class="row">
                    <div class="col-sm-6 b-r">
                        <div class="ibox float-e-margins">
                            <form method="get" class="form-horizontal">
                                <h3>基本信息</h3>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label"><i style="color: red">*</i> 客户名称：</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control">
                                    </div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">助记名称：</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control">
                                    </div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label"><i style="color: red">*</i> 所属行业：</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" name="password">
                                    </div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label"><i style="color: red">*</i> 客户类型：</label>
                                    <div class="col-sm-8">
                                        <div class="radio i-checks">
                                            <label>
                                                <input type="radio" checked="" value="option1" id="optionsRadios1"
                                                       name="optionsRadios"><i></i>&nbsp;企业客户</label>
                                            <label>
                                                <input type="radio" value="option2" id="optionsRadios2"
                                                       name="optionsRadios"><i></i>&nbsp;个人客户</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label"><i style="color: red">*</i> 客户状态：</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" name="password">
                                    </div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label"><i style="color: red">*</i> 客户星级：</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" name="password">
                                    </div>
                                </div>
                                <div class="hr-line-dashed"></div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label">客户来源：</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" name="password">
                                    </div>
                                </div>
                                <div class="hr-line-dashed"></div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label"><i style="color: red">*</i> 归属人员：</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" name="password">
                                    </div>
                                </div>
                                <div class="hr-line-dashed"></div>

                                <h3>附加信息</h3>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">详细地址：</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" name="password">
                                    </div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">备注信息：</label>
                                    <div class="col-sm-8">
                                        <textarea name="" id="" maxlength="300" style="min-width: 300px" rows="6" ></textarea>
                                    </div>
                                </div>

                                <div class="hr-line-dashed"></div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label"><i style="color: red">*</i> 跟进时间：</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" name="password">
                                    </div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">跟进内容：</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" name="password">
                                    </div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label"><i style="color: red">*</i> 跟进人员：</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" name="password">
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <h3>首要联系人</h3>
                        <div class="hr-line-dashed"></div>
                        <form method="get" class="form-horizontal">

                            <div class="form-group">
                                <label class="col-sm-3 control-label"><i style="color: red">*</i> 联系人姓名：</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">尊称：</label>
                                <div class="col-sm-8">
                                    <div class="radio i-checks">
                                        <label>
                                            <input type="checkbox" value="" checked=""> <i></i>未知</label>
                                        <label>
                                            <input type="checkbox" value=""> <i></i>先生</label>
                                        <label>
                                            <input type="checkbox" value="" > <i></i>女士</label>
                                    </div>
                                </div>
                            </div>

                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">角色：</label>

                                <div class="col-sm-8">
                                    <input type="text" class="form-control">
                                </div>
                            </div>

                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">生日：</label>

                                <div class="col-sm-8">
                                    <input type="text" class="form-control">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">部门职务：</label>

                                <div class="col-sm-8">
                                    <input type="text" class="form-control">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label"><i style="color: red">*</i> 手机号码：</label>

                                <div class="col-sm-8">
                                    <input type="text" class="form-control">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">电子邮箱：</label>

                                <div class="col-sm-8">
                                    <input type="text" class="form-control">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">微信账号：</label>

                                <div class="col-sm-8">
                                    <input type="text" class="form-control">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">QQ号码：</label>

                                <div class="col-sm-8">
                                    <input type="text" class="form-control">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">详细地址：</label>

                                <div class="col-sm-8">
                                    <input type="text" class="form-control">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">备注信息：</label>

                                <div class="col-sm-8">
                                    <textarea name="" id="4" maxlength="300" style="min-width: 300px"  rows="5"></textarea>
                                </div>
                            </div>
                        </form>
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

    // $("#inputForm").validate({
    //     submitHandler: function(form){
    //         $("#userRoleString").val(roleGrid.dataGrid('getSelectRows').join(','));
    //         js.ajaxSubmitForm($(form), function(data){
    //             js.showMessage(data.message);
    //             if(data.result == Global.TRUE){
    //                 js.closeCurrentTabPage(function(contentWindow){
    //                     contentWindow.page();
    //                 });
    //             }
    //         }, "json");
    //     }
    // });
</script>
