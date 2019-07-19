<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>

<div class="wrapper wrapper-content animated fadeInRight">
    <div class="tabs-container">


        <ul class="nav nav-tabs">
            <li class="active"><a data-toggle="tab" href="#tab-1" aria-expanded="true">生产计划详情</a>
            </li>
        </ul>
        <div class="tab-content">
            <div id="tab-1" class="tab-pane active">
                <div class="panel-body">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="ibox-content">

                                <form:form id="inputForm" modelAttribute="vo" action="${ctx}/produce/producePlan/update"
                                           method="post" class="form-horizontal">
                                    <div class="row">
                                        <div class="col-sm-6 b-r">
                                            <div class="ibox float-e-margins">
                                                <form method="get" class="form-horizontal">
                                                    <input id="prodPlanCode" name="prodPlanCode" type="hidden" value="${prodPlan.prodPlanCode}"/>
                                                    <div class="form-group">
                                                        <label class="col-sm-5 control-label"> 品种：</label>
                                                        <div class="col-sm-5" style="text-align:center;padding-top: 7px;">
                                                                ${fns:getValueByDictKey(prodPlan.prodVariety)}
                                                        </div>
                                                    </div>
                                                    <div class="hr-line-dashed"></div>
                                                    <div class="form-group">
                                                        <label class="col-sm-5 control-label"> 种类：</label>
                                                        <div class="col-sm-5" style="text-align:center;padding-top: 7px;">
                                                                ${fns:getValueByDictKey(prodPlan.prodCgyCode)}
                                                        </div>
                                                    </div>
                                                    <div class="hr-line-dashed"></div>
                                                    <div class="form-group">
                                                        <label class="col-sm-5 control-label"> 颜色：</label>
                                                        <div class="col-sm-5" style="text-align:center;padding-top: 7px;">
                                                                ${fns:getDictValue(prodPlan.prodColor, 'prod_color', defaultValue)}
                                                        </div>
                                                    </div>
                                                    <div class="hr-line-dashed"></div>
                                                    <div class="form-group">
                                                        <label class="col-sm-5 control-label"> 总数量：</label>
                                                        <div class="col-sm-5" style="text-align:center;padding-top: 7px;">
                                                                ${prodPlan.totalQuantity}
                                                        </div>
                                                    </div>
                                                    <div class="hr-line-dashed"></div>
                                                    <div class="form-group">
                                                        <label class="col-sm-5 control-label"> 已下发生产数量：</label>
                                                        <div class="col-sm-5" style="text-align:center;padding-top: 7px;">
                                                                ${prodPlan.quantity}
                                                        </div>
                                                    </div>
                                                    <div class="hr-line-dashed"></div>
                                                </form>
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label"> 机台：</label>
                                                <div class="col-sm-5" style="text-align:center;padding-top: 7px;">
                                                        ${prodPlan.macCode}
                                                </div>
                                            </div>
                                            <div class="hr-line-dashed"></div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">配方：</label>
                                                <div class="col-sm-5" style="text-align:center;padding-top: 7px;">
                                                    <textarea name="formula" style="width: 250px;height: 200px;" >
                                                             <c:out value="${prodPlan.formula}" escapeXml="false"></c:out>
                                                    </textarea>
                                                </div>
                                            </div>
                                            <div class="hr-line-dashed"></div>
                                            <div class="form-group">
                                                <div class="col-sm-8">
                                                    <button class="btn btn-primary"  type="submit">保存</button>
                                                </div>
                                            </div>
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
                                    <h5>生产计划详情-产品列表</h5>
                                </div>
                                <div class="ibox-content timeline" style="overflow-x: auto; overflow-y: auto;">
                                    <table id="contentTable" class="table table-striped table-bordered table-condensed" style=" table-layout: fixed;">
                                        <thead>
                                        <tr>
                                            <th style="width: 50px"><input type="checkbox" id="checkAll" onchange="checkedAll(this)" /></th>
                                            <th style="width: 150px">订单号</th>
                                            <th style="width: 150px">产品编号</th>
                                            <th style="width: 60px">所属人</th>
                                            <th style="width: 80px">机台编号</th>
                                            <th style="width: 100px">品种</th>
                                            <th style="width: 80px">类别</th>
                                            <th style="width: 60px">颜色</th>
                                            <th style="width: 70px">长度(m)</th>
                                            <th style="width: 70px">宽度(m)</th>
                                            <th style="width: 70px">厚度(m)</th>
                                            <th style="width: 60px">数量</th>
                                            <th style="width: 60px">重量</th>
                                            <th style="width: 70px">面积(㎡)</th>
                                            <th style="width: 80px">压边类型</th>
                                            <th style="width: 120px">延长米计算方式</th>
                                            <th style="width: 100px">状态</th>
                                            <%--<th style="width: 50px">操作</th>--%>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${list}" var="vo">
                                        <tr>
                                            <td>
                                                <c:if test="${vo.itemStatus eq '48'}">
                                                    <input type="checkbox" name="detailId" value="${vo.id}">
                                                </c:if>
                                            </td>
                                            <td>${vo.ordCode}</td>
                                            <td>${vo.itemCode}</td>
                                            <td>${vo.itemOwner}</td>
                                            <td>${vo.macCode}</td>
                                            <td>${fns:getValueByDictKey(vo.itemVariety)}</td>
                                            <td>${fns:getValueByDictKey(vo.itemCgyCode)}</td>
                                            <td>${fns:getDictValue(vo.itemColor, 'prod_color', defaultValue)}</td>
                                            <td>${vo.itemLenth}</td>
                                            <td>${vo.itemWidth}</td>
                                            <td>${vo.itemThick}</td>
                                            <td>${vo.itemNum}</td>
                                            <td>${vo.itemTotalWeight}</td>
                                            <td>${vo.itemTotalSq}</td>
                                            <td>${fns:getValueByDictKey(vo.itemYbType)}</td>
                                            <td>${fns:getValueByDictKey(vo.itemYcType)}</td>
                                            <td style="color: #08c;">
                                                <c:if test="${vo.itemStatus eq '48'}">待确认</c:if>
                                                <c:if test="${vo.itemStatus eq '49'}">下发生产</c:if>
                                                <c:if test="${vo.itemStatus eq '50'}">已完成</c:if>
                                            </td>
                                            <%--<td>按钮：移出机台</td>--%>
                                        </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                    <div class="row">
                                        <div class="form-group">
                                            <button class="btn btn-primary" type="button" id="distribution">下发生产</button>
                                            <button class="btn btn-primary" type="button" onclick="history.go(-1)">返回</button>
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
</div>

<script>
    $(document).ready(function () {
        $(".i-checks").iCheck({checkboxClass: "icheckbox_square-green", radioClass: "iradio_square-green",})
    });

    $("#distribution").click(function () {
        <!-- 针对选中客户进行操作 -->
        var str = getCheckValue();
        var prodPlanCode = $("#prodPlanCode").val();
        var path = 'window.location.href = "/produce/producePlan/info?prodPlanCode='+prodPlanCode+'"';
        if (str.length > 0) {
            $.ajax({
                url: "/produce/producePlanDetail/updateBatch",
                type: 'POST',
                data: {ids:str },
                dataType: 'json',
                success: function (result) {
                    if(result >0){
                        top.$.jBox.tip('下发成功');
                        self.setTimeout(path, 2000);
                    }else {
                        top.$.jBox.tip('下发失败，请联系管理员');
                    }

                }
            });

        }else{
            top.$.jBox.tip('最少选中一条记录');
        }

    });

    function getCheckValue(){
        debugger;
        var obj = document.getElementsByName("detailId");
        var check_val = '';
        for(k in obj){
            if(obj[k].checked)
                check_val = check_val + obj[k].value + ",";
        }
        check_val = check_val.replace(",,",",");
        return check_val;
    }

    function checkedAll(obj){
        var codes = document.getElementsByName("detailId")
        if(obj.checked){
            for(var i=0;i<codes.length;i++){
                codes[i].checked = true;
            }
        }else{
            for(var i=0;i<codes.length;i++){
                codes[i].checked = false;
            }
        }
    }


</script>
