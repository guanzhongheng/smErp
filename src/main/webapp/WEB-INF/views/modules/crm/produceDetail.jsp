<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>

<style>
    .btn-app{    background-color: #f4f4f4;    font-size: 20px;}
</style>

<div class="wrapper wrapper-content animated fadeInRight">
    <div class="tabs-container">


        <ul class="nav nav-tabs">
            <li class="active"><a data-toggle="tab" href="#tab-1" aria-expanded="true">产品生产详情</a>
            </li>
        </ul>
        <div class="tab-content">
            <div id="tab-1" class="tab-pane active">
                <div class="panel-body">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="box">
                                <div class="box-header with-border">
                                    <h3 class="box-title">计重设备</h3>
                                </div>
                                <!-- /.box-header -->
                                <div class="box-body" >
                                    <div style="float:left;    margin-bottom: 10px;">
                                        <a class="btn btn-app">
                                            <i class="fa fa-play"></i> 启动
                                        </a>
                                        <a class="btn btn-app">
                                            <i class="fa fa-repeat"></i> 归零
                                        </a>
                                        <a class="btn btn-app">
                                            <i class="fa fa-circle-o"></i> 去皮
                                        </a>
                                        <a class="btn btn-app">
                                            <i class="fa fa-balance-scale"></i> 标重
                                        </a>
                                        <a class="btn btn-app">
                                            <i class="fa fa-tachometer"></i> 刻度
                                        </a>
                                        <a class="btn btn-app">
                                            <i class="fa fa-save"></i> 存盘
                                        </a>
                                    </div>

                                    <div style="min-width: 270px;background-color: black;color:green; font-size: 30px;float:left;text-align: center;margin-left:15px;">
                                        净：<span>0.00</span> KG
                                    </div>
                                    <div style="min-width: 270px;background-color: black;color:green; font-size: 30px;float:left;text-align: center;margin-left:15px;">
                                        皮：0.00 KG
                                    </div>
                                </div>
                                <!-- /.box-body -->
                            </div>


                            <div class="ibox-content">
                                <form:form id="inputForm" modelAttribute="vo" action="${ctx}/cus/customer_save"
                                           method="post" class="form-horizontal">
                                    <div class="row">
                                        <div class="col-sm-6 b-r">
                                            <div class="ibox float-e-margins">
                                                <form method="get" class="form-horizontal">
                                                    <div class="form-group">
                                                        <label class="col-sm-5 control-label"> 订单号：</label>
                                                        <div class="col-sm-5" style="text-align:center;padding-top: 7px;">
                                                                ${detail.ordCode}
                                                        </div>
                                                    </div>
                                                    <div class="hr-line-dashed"></div>
                                                    <div class="form-group">
                                                        <label class="col-sm-5 control-label"> 所属人：</label>
                                                        <div class="col-sm-5" style="text-align:center;padding-top: 7px;">
                                                                ${detail.itemOwner}
                                                        </div>
                                                    </div>
                                                    <div class="hr-line-dashed"></div>
                                                    <div class="form-group">
                                                        <label class="col-sm-5 control-label"> 机台编号：</label>
                                                        <div class="col-sm-5" style="text-align:center;padding-top: 7px;">
                                                                ${detail.macCode}
                                                        </div>
                                                    </div>
                                                    <div class="hr-line-dashed"></div>
                                                    <div class="form-group">
                                                        <label class="col-sm-5 control-label"> 长度：</label>
                                                        <div class="col-sm-5" style="text-align:center;padding-top: 7px;">
                                                                ${detail.itemLenth}
                                                        </div>
                                                    </div>
                                                    <div class="hr-line-dashed"></div>
                                                    <div class="form-group">
                                                        <label class="col-sm-5 control-label"> 厚度：</label>
                                                        <div class="col-sm-5" style="text-align:center;padding-top: 7px;">
                                                                ${detail.itemThick}
                                                        </div>
                                                    </div>
                                                    <div class="hr-line-dashed"></div>
                                                    <div class="form-group">
                                                        <label class="col-sm-5 control-label"> 重量：</label>
                                                        <div class="col-sm-5" style="text-align:center;padding-top: 7px;">
                                                                ${detail.itemTotalWeight}
                                                        </div>
                                                    </div>
                                                    <div class="hr-line-dashed"></div>
                                                    <div class="form-group">
                                                        <label class="col-sm-5 control-label"> 压边类型：</label>
                                                        <div class="col-sm-5" style="text-align:center;padding-top: 7px;">
                                                                ${fns:getValueByDictKey(detail.itemYbType)}
                                                        </div>
                                                    </div>
                                                    <div class="hr-line-dashed"></div>
                                                    <div class="form-group">
                                                        <label class="col-sm-5 control-label"> 配方：</label>
                                                        <div class="col-sm-5" style="text-align:center;padding-top: 7px;">
                                                                ${detail.formula}
                                                        </div>
                                                    </div>
                                                    <div class="hr-line-dashed"></div>
                                                </form>
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label"> 产品编号：</label>
                                                <div class="col-sm-5" style="text-align:center;padding-top: 7px;">
                                                        ${detail.itemCode}
                                                </div>
                                            </div>
                                            <div class="hr-line-dashed"></div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label"> 品种：</label>
                                                <div class="col-sm-5" style="text-align:center;padding-top: 7px;">
                                                        ${fns:getValueByDictKey(detail.itemVariety)}
                                                </div>
                                            </div>
                                            <div class="hr-line-dashed"></div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label"> 颜色：</label>
                                                <div class="col-sm-5" style="text-align:center;padding-top: 7px;">
                                                        ${fns:getDictValue(detail.itemColor, 'prod_color', defaultValue)}
                                                </div>
                                            </div>
                                            <div class="hr-line-dashed"></div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label"> 宽度：</label>
                                                <div class="col-sm-5" style="text-align:center;padding-top: 7px;">
                                                        ${detail.itemWidth}
                                                </div>
                                            </div>
                                            <div class="hr-line-dashed"></div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label"> 数量：</label>
                                                <div class="col-sm-5" style="text-align:center;padding-top: 7px;">
                                                        ${detail.itemNum}
                                                </div>
                                            </div>
                                            <div class="hr-line-dashed"></div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label"> 面积：</label>
                                                <div class="col-sm-5" style="text-align:center;padding-top: 7px;">
                                                        ${detail.itemTotalSq}
                                                </div>
                                            </div>
                                            <div class="hr-line-dashed"></div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label"> 延长米计算方式：</label>
                                                <div class="col-sm-5" style="text-align:center;padding-top: 7px;">
                                                        ${fns:getValueByDictKey(detail.itemYcType)}
                                                </div>
                                            </div>
                                            <div class="hr-line-dashed"></div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label"> 操作：</label>
                                                <div class="col-sm-5" style="text-align:center;padding-top: 7px;">
                                                    <button class="btn btn-primary" type="button" onclick="history.go(-1)">入库</button>
                                                </div>
                                            </div>
                                            <div class="hr-line-dashed"></div>
                                        </div>

                                    </div>
                                    <div class="row">
                                        <div class="form-group">

                                            <button class="btn btn-primary" type="button" onclick="history.go(-1)">重新打签</button>
                                            <button class="btn btn-primary" type="button" onclick="history.go(-1)">返回</button>
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
