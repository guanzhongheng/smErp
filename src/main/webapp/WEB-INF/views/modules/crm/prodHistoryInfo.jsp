<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>

<link rel="stylesheet" href="/static/common/customize.css">


<div class="tabs-container" style="padding: 0px 20px;">
    <div class="panel panel-default"
         style="border-color: #50B0E6; border-style: solid; border-width: 1px; border-radius:5px 5px 5px 5px;">
        <div class="panel-heading" style="background-color: #50B0E6">
            <h3 class="panel-title global-panel-title">
                产品详情
            </h3>
        </div>
        <div class="panel-body" style="padding: 10px 10px 0px 10px;">
            <div class="row">
                <div class="col-sm-12" >
                    <div class="form-group">
                        <div class="col-md-6">
                            <form:form id="searchForm" modelAttribute="vo" action="${ctx}/produce/history/find" method="post">
                            <sys:message content="${message}"/>
                            <label class="col-md-3 control-label order-detail-label-margin" style="text-align: right">
                                输入二维码号:
                            </label>
                            <label class="col-md-4 control-label">
                                <form:input path="barCode" htmlEscape="false" maxlength="200"
                                            class="form-control"  cssStyle="width: 150px;"/>
                            </label>
                            <label class="col-md-4 control-label" style="text-align: left">
                                <input id="btnSubmit" class="btn btn-primary" type="submit" style="width: 80px" value="查询"/>
                            </label>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
            <hr/>
            <div class="row">
                <div class="col-sm-12">
                    <div class="form-group">
                        <div class="col-md-4">
                            <label class="col-md-4 control-label order-detail-label-margin" style="text-align: right">
                                订单标题:
                            </label>
                            <label class="col-md-8 control-label">
                                <input class="form-control" value="${prod.ordTitle}" disabled>
                            </label>
                        </div>
                        <div class="col-md-4">
                            <label class="col-md-4 control-label order-detail-label-margin" style="text-align: right">
                                代理商:
                            </label>
                            <label class="col-md-8 control-label">
                                <input class="form-control"value="${prod.proxyName}" disabled>
                            </label>
                        </div>
                        <div class="col-md-4">
                            <label class="col-md-4 control-label order-detail-label-margin" style="text-align: right">
                                产品归属人:
                            </label>
                            <label class="col-md-8 control-label">
                                <input class="form-control"value="${prod.itemOwner}" disabled>
                            </label>
                        </div>
                        
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-12">
                    <div class="form-group">
                    		<div class="col-md-4">
                            <label class="col-md-4 control-label order-detail-label-margin" style="text-align: right">
                                订单创建人:
                            </label>
                            <label class="col-md-8 control-label">
                                <input class="form-control"value="${prod.ordCreateBy}" disabled>
                            </label>
                        </div>
                        <div class="col-md-4">
                            <label class="col-md-4 control-label order-detail-label-margin" style="text-align: right">
                                订单修改人:
                            </label>
                            <label class="col-md-8 control-label">
                                <input class="form-control"value="${prod.ordUpdateBy}" disabled>
                            </label>
                        </div>
                        <div class="col-md-4">
                            <label class="col-md-4 control-label order-detail-label-margin" style="text-align: right">
                                订单审批人:
                            </label>
                            <label class="col-md-8 control-label">
                                <input class="form-control"value="${prod.ordApprovalBy}" disabled>
                            </label>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-12">
                    <div class="form-group">
                    		<div class="col-md-4">
                            <label class="col-md-4 control-label order-detail-label-margin" style="text-align: right">
                                订单创建时间:
                            </label>
                            <label class="col-md-8 control-label">
                                <input class="form-control"value="${prod.orderCreateTime}" disabled>
                            </label>
                        </div>
                       
                    </div>
                </div>
            </div>
            <hr/>
            <div class="row">
            	 	<div class="col-sm-12">
	            		<div class="form-group">
	            			<h3>产品库存信息(<span style="color:red;" >${prod.status=="1"?"出库":"未出库"}</span>)</h3>
	            		</div>
            		</div>
            </div>
            <hr />
            <div class="row">
                <div class="col-sm-12">
                    <div class="form-group">
                        <div class="col-md-4">
                            <label class="col-md-4 control-label order-detail-label-margin" style="text-align: right">
                                产品品种:
                            </label>
                            <label class="col-md-8 control-label">
                                <input class="form-control"value="${fns:getValueByDictKey(prod.itemVariety)}" disabled>
                            </label>
                        </div>
                        <div class="col-md-4">
                            <label class="col-md-4 control-label order-detail-label-margin" style="text-align: right">
                                产品类别:
                            </label>
                            <label class="col-md-8 control-label">
                                <input class="form-control"value="${fns:getValueByDictKey(prod.itemCgyCode)}" disabled>
                            </label>
                        </div>
                        <div class="col-md-4">
                            <label class="col-md-4 control-label order-detail-label-margin" style="text-align: right">
                                产品颜色:
                            </label>
                            <label class="col-md-8 control-label">
                                <input class="form-control"value="${fns:getDictValue(prod.itemColor, 'prod_color', defaultValue)}" disabled>
                            </label>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-12">
                    <div class="form-group">
                        <div class="col-md-4">
                            <label class="col-md-4 control-label order-detail-label-margin" style="text-align: right">
                                产品长度:
                            </label>
                            <label class="col-md-8 control-label">
                                <input class="form-control"value="${prod.itemLenth}" disabled>
                            </label>
                        </div>

                        <div class="col-md-4">
                            <label class="col-md-4 control-label order-detail-label-margin" style="text-align: right">
                                产品宽度:
                            </label>
                            <label class="col-md-8 control-label">
                                <input class="form-control"value="${prod.itemWidth}" disabled>
                            </label>
                        </div>
                        <div class="col-md-4">

                            <label class="col-md-4 control-label order-detail-label-margin" style="text-align: right">
                                产品厚度:
                            </label>
                            <label class="col-md-8 control-label">
                                <input class="form-control"value="${prod.itemThick}" disabled>
                            </label>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-12">
                    <div class="form-group">
                        <div class="col-md-4">
                            <label class="col-md-4 control-label order-detail-label-margin" style="text-align: right">
                                产品净重:
                            </label>
                            <label class="col-md-8 control-label">
                                <input class="form-control"value="${prod.itemWeight - prod.itemTareWeight}" disabled>
                            </label>
                        </div>

                        <div class="col-md-4">
                            <label class="col-md-4 control-label order-detail-label-margin" style="text-align: right">
                              	压边类型:
                            </label>
                            <label class="col-md-8 control-label">
                                <input class="form-control"value="${fns:getDictValue(prod.itemYbType, 'prod_ybType', defaultValue)}" disabled>
                            </label>
                        </div>
                        <div class="col-md-4">
                            <label class="col-md-4 control-label order-detail-label-margin" style="text-align: right">
                                延长米方式:
                            </label>
                            <label class="col-md-8 control-label">
                                <input class="form-control"value="${fns:getDictValue(prod.itemYcType, 'prod_ycType', defaultValue)}" disabled>
                            </label>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-12">
                    <div class="form-group">
                        <div class="col-md-4">
                            <label class="col-md-4 control-label order-detail-label-margin" style="text-align: right">
                                产品计价方式:
                            </label>
                            <label class="col-md-8 control-label">
                                <input class="form-control"value="${fns:getValueByDictKey(prod.itemPriceType)}" disabled>
                            </label>
                        </div>
                        <div class="col-md-4">
                            <label class="col-md-4 control-label order-detail-label-margin" style="text-align: right">
                                产品价格:
                            </label>
                            <label class="col-md-8 control-label">
                                <input class="form-control"value="${prod.itemPrice}" disabled>
                            </label>
                        </div>
                        <div class="col-md-4">
                            <label class="col-md-4 control-label order-detail-label-margin" style="text-align: right">
                                生产入库时间:
                            </label>
                            <label class="col-md-8 control-label">
                                <input class="form-control"value="${prod.stockCreateTime}" disabled>
                            </label>
                        </div>
                       
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-12">
                    <div class="form-group">
                        <div class="col-md-4">
                            <label class="col-md-4 control-label order-detail-label-margin" style="text-align: right">
                                生产入库人:
                            </label>
                            <label class="col-md-8 control-label">
                                <input class="form-control"value="${prod.stockCreateBy}" disabled>
                            </label>
                        </div>

                        <div class="col-md-4">
                            <label class="col-md-4 control-label order-detail-label-margin" style="text-align: right">
                                库存信息修改:
                            </label>
                            <label class="col-md-8 control-label">
                                <input class="form-control"value="${prod.stockUpdateBy}" disabled>
                            </label>
                        </div>
                        <div class="col-md-4">
                            <label class="col-md-4 control-label order-detail-label-margin" style="text-align: right">
                                产品起止码:
                            </label>
                            <label class="col-md-8 control-label">
                                <input class="form-control"value="${prod.seCode}" disabled>
                            </label>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-12">
                    <div class="form-group">

                        <div class="col-md-4">
                            <label class="col-md-4 control-label order-detail-label-margin" style="text-align: right">
                                密度:
                            </label>
                            <label class="col-md-8 control-label">
                                <input class="form-control"value="${prod.prodDensity}" disabled>
                            </label>
                        </div>

                        <div class="col-md-4">
                            <label class="col-md-4 control-label order-detail-label-margin" style="text-align: right">
                                米克重:
                            </label>
                            <label class="col-md-8 control-label">
                                <input class="form-control"value="${prod.itemMickWeight}" disabled>
                            </label>
                        </div>


                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-12">
                    <div class="form-group">
                        <div class="col-md-4">
                            <label class="col-md-4 control-label order-detail-label-margin" style="text-align: right">
                                产品备注:
                            </label>
                            <label class="col-md-8 control-label">
                                <textarea rows="3" cols="40" disabled="disabled">${prod.remarks}</textarea>
                            </label>
                        </div>
                    </div>
                </div>
            </div>
            <hr/>
            <div class="row">
            	 	<div class="col-sm-12">
	            		<div class="form-group">
	            			<h3>产品出库信息</h3>
	            		</div>
            		</div>
            </div>
            <hr/>
            <div class="row">
                <div class="col-sm-12">
                    <div class="form-group">
                        <div class="col-md-4">
                            <label class="col-md-4 control-label order-detail-label-margin" style="text-align: right">
                                运输车牌号:
                            </label>
                            <label class="col-md-8 control-label">
                                <input class="form-control"value="${prod.carNo}" disabled>
                            </label>
                        </div>

                        <div class="col-md-4">
                            <label class="col-md-4 control-label order-detail-label-margin" style="text-align: right">
                                收货人:
                            </label>
                            <label class="col-md-8 control-label">
                                <input class="form-control"value="${prod.receiver}" disabled>
                            </label>
                        </div>
                        <div class="col-md-4">

                            <label class="col-md-4 control-label order-detail-label-margin" style="text-align: right">
                                联系方式:
                            </label>
                            <label class="col-md-8 control-label">
                                <input class="form-control"value="${prod.phone}" disabled>
                            </label>
                        </div>
                    </div>
                </div>
            </div>
       
            <hr/>
            <div class="row">
            	 	<div class="col-sm-12">
	            		<div class="form-group">
	            			<h3>产品配方信息</h3>
	            		</div>
            		</div>
            </div>
            <hr/>
            <div class="row">
            		<div class="col-sm-12">
            			<div class="tabs-container">
                        <ul class="nav nav-tabs">
                            <li class="active"><a data-toggle="tab" href="#tab-out"
                                                  aria-expanded="true">外层配比</a>
                            </li>
                            <li class=""><a data-toggle="tab" href="#tab-middle"
                                            aria-expanded="false">中层配比</a>
                            </li>
                            <li class=""><a data-toggle="tab" href="#tab-in"
                                            aria-expanded="false">内层配比</a>
                            </li>
                        </ul>
                        <div class="tab-content">
                            <div id="tab-out" class="tab-pane active">
                                <div class="panel-body" style="min-height: 200px">
                                    <div class="row" style="height: 20px;">
                                        <div class="col-sm-12" style="text-align: center">
                                            <h3>摄氏温度(<span id="outTemp">0</span>度)</h3>
                                        </div>
                                    </div>
                                    <div class="hr-line-dashed"></div>
                                    <table id="outerTable"
                                           class="table table-bordered" style="height: 100%">
                                    </table>
                                </div>
                            </div>
                            <div id="tab-middle" class="tab-pane">
                                <div class="panel-body" style="min-height: 200px">
                                    <div class="row" style="height: 20px;">
                                        <div class="col-sm-12" style="text-align: center">
                                            <h3>摄氏温度(<span id="midTemp">0</span>度)</h3>
                                        </div>
                                    </div>
                                    <div class="hr-line-dashed"></div>
                                    <table id="midderTable"
                                           class="table table-bordered"  style="height: 100%">
                                    </table>
                                </div>
                            </div>
                            <div id="tab-in" class="tab-pane">
                                <div class="panel-body" style="min-height: 200px">
                                    <div class="row" style="height: 20px;">
                                        <div class="col-sm-12" style="text-align: center">
                                            <h3>摄氏温度(<span id="inTemp">0</span>度)</h3>
                                        </div>
                                    </div>
                                    <div class="hr-line-dashed"></div>
                                    <table id="innerTable"
                                           class="table table-bordered"  style="height: 100%">
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
            		</div>
            </div>
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
<script src="${ctxStatic}/hPlugs/js/plugins/layer/layer.min.js"></script>
<script src="${ctxStatic}/hPlugs/js/plugins/bootstrap-table/bootstrap-table.js"></script>
<script src="${ctxStatic}/hPlugs/js/plugins/bootstrap-table/bootstrap-table-fixed-columns.js"></script>
<script src="${ctxStatic}/hPlugs/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<style src="/static/hPlugs/css/bootstrap.min14ed.css" type="text/css"></style>
<link rel="stylesheet" href="/static/common/customize.css">
<script>
 	var FormuInfo = '${prod.formula}';
 	
    var rawList = new Array();
    $.ajax({
        type: "POST",
        url: '/formula/ajaxRmList',
        dataType:'json',
        cache: false,
        success: function(data){
            if(data != null){
                rawList = data;
            }
        }
    });
	 
    function initTable(){
        $("#outerTable").bootstrapTable({
            url: '',
            pagination: false,  //表格底部显示分页条
            sidePagination: "server",
            escape: false, //启动转义字符
            queryParamsType: '',//设置请求参数格式
            columns: [
                {
                    field: 'ckId',
                    title: '序号',
                    align: 'center',
                    width: '60px',
                    formatter:function (value,row,index){
                        if(index == 0){
                            maxOutDataIndex = 1;
                        }else{
                            maxOutDataIndex = maxOutDataIndex + 1;
                        }
                        row.ckId = maxOutDataIndex;
                        return maxOutDataIndex;
                    }
                },
                {
                    field: 'rawmCode',
                    title: '原料编号',
                    width: '25%'
                },
                {
                    field: 'rawmName',
                    title: '原料名称',
                    width: '45%'
                }, {
                    field: 'weight',
                    title: '数量',
                    align: 'center'
                }
            ]
        });
        $("#midderTable").bootstrapTable({
            url: '',
            pagination: false,  //表格底部显示分页条
            sidePagination: "server",
            escape: false, //启动转义字符
            queryParamsType: '',//设置请求参数格式
            columns: [
                {
                    field: 'ckId',
                    title: '序号',
                    align: 'center',
                    width: '60px',
                    formatter:function (value,row,index){
                        if(index == 0){
                            maxMidDataIndex = 1;
                        }else{
                            maxMidDataIndex = maxMidDataIndex + 1;
                        }
                        row.ckId = maxMidDataIndex;
                        return maxMidDataIndex;
                    }
                },
                {
                    field: 'rawmCode',
                    title: '原料编号',
                    width: '25%'
                },
                {
                    field: 'rawmName',
                    title: '原料名称',
                    width: '45%'
                }, {
                    field: 'weight',
                    title: '数量',
                    align: 'center'
                }
            ]
        });
        $("#innerTable").bootstrapTable({
            url: '',
            pagination: false,  //表格底部显示分页条
            sidePagination: "server",
            escape: false, //启动转义字符
            queryParamsType: '',//设置请求参数格式
            columns: [
                {
                    field: 'ckId',
                    title: '序号',
                    align: 'center',
                    width: '60px',
                    formatter:function (value,row,index){
                        if(index == 0){
                            maxInDataIndex = 1;
                        }else{
                            maxInDataIndex = maxInDataIndex + 1;
                        }
                        row.ckId = maxInDataIndex;
                        return maxInDataIndex;
                    }
                },
                {
                    field: 'rawmCode',
                    title: '原料编号',
                    width: '25%'
                },
                {
                    field: 'rawmName',
                    title: '原料名称',
                    width: '42%'
                }, {
                    field: 'weight',
                    title: '数量',
                    align: 'center'
                }
            ]
        });
    }
	function doProcessData(){
        if(FormuInfo != null && FormuInfo.length > 0){
            var obj = JSON.parse(FormuInfo);
            if(obj.outer != null){
                $("#outTemp").text(obj.outer.temperature);
                $("#outerTable").bootstrapTable("load",obj.outer.rawMaterialVos);
            }
            if(obj.midder != null){
                $("#midTemp").text(obj.midder.temperature);
                $("#midderTable").bootstrapTable("load",obj.midder.rawMaterialVos);
            }
            if(obj.inner != null){
                $("#inTemp").text(obj.inner.temperature);
                $("#innerTable").bootstrapTable("load",obj.inner.rawMaterialVos);
            }
            $(".chosen-container").css('width',"100%");
            $(".loading-text").hide();
        }
  };
	$(document).ready(function () {
	 	initTable();
	 	setTimeout(function() {
	 		doProcessData();
                   },500)
    		
    });
</script>