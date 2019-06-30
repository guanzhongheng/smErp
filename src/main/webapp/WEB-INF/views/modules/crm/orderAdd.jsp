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
                            <div class="ibox-content">
                                <div class="row">
                                    <div class="col-sm-12">
                                        <div class="form-group">
                                            <div class="row">
                                                <code class="pull-right"><i style="color: red">*</i>
                                                    <small>为必填项</small>
                                                </code>
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <form method="post" class="form-horizontal">
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label"><i style="color: red">*</i>
                                                    订单标题：</label>
                                                <div class="col-sm-6">
                                                    <input type="text" class="form-control">
                                                </div>
                                            </div>
                                            <div class="hr-line-dashed"></div>
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label"><i style="color: red">*</i>
                                                    关联客户：</label>
                                                <div class="col-sm-6">
                                                    <input type="text" class="form-control">
                                                </div>
                                            </div>
                                            <div class="hr-line-dashed"></div>
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label"><i style="color: red">*</i>
                                                    订单总金额：</label>
                                                <div class="col-sm-6">
                                                    <input type="text" class="form-control" name="password">
                                                </div>
                                            </div>
                                            <div class="hr-line-dashed"></div>
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label">订单类型：</label>
                                                <div class="col-sm-6">

                                                </div>
                                            </div>
                                            <div class="hr-line-dashed"></div>
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label">交货日期：</label>
                                                <div class="col-sm-6">
                                                    <input type="text" class="form-control" name="password">
                                                </div>
                                            </div>
                                            <div class="hr-line-dashed"></div>


                                            <div class="form-group">
                                                <label class="col-sm-3 control-label">客户签约人：</label>
                                                <div class="col-sm-6">
                                                    <input type="text" class="form-control" name="password">
                                                </div>
                                            </div>
                                            <div class="hr-line-dashed"></div>

                                            <div class="form-group">
                                                <label class="col-sm-3 control-label">我方签约人：</label>
                                                <div class="col-sm-6">
                                                    <input type="text" class="form-control" name="password">
                                                </div>
                                            </div>
                                            <div class="hr-line-dashed"></div>

                                            <div class="form-group">
                                                <label class="col-sm-3 control-label"><i style="color: red">*</i>
                                                    归属人员：</label>
                                                <div class="col-sm-6">
                                                    <input type="text" class="form-control" name="password">
                                                </div>
                                            </div>
                                            <div class="hr-line-dashed"></div>
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label">备注信息：</label>
                                                <div class="col-sm-6">
                                                <textarea name="" id="" maxlength="300" style="min-width: 300px"
                                                          rows="6"></textarea>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <div class="col-sm-8 col-sm-offset-4">
                                                    <button class="btn btn-primary" type="submit">提交审批</button>
                                                    &nbsp;&nbsp;
                                                    <button class="btn btn-primary" type="submit">保存订单</button>
                                                    &nbsp;&nbsp;
                                                    <button class="btn btn-primary" type="submit">保存订单</button>
                                                </div>
                                            </div>
                                        </form>
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
