<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<link rel="stylesheet" href="/static/common/customize.css">

<style>
    body {
        font-family:楷体;
    }
    td {
        text-align:left;
    }
</style>

<div>
    <br>
    <div class="col-sm-12">
        <button class="btn btn-success" type="button" id="stock">打印标签</button>
        <button class="btn btn-primary" type="button" id="new">打印新版合格证</button>
        <button class="btn btn-danger" type="button" id="red">打印红色合格证</button>
        <button class="btn btn-warning" type="button" id="yellow">打印黄色合格证</button>
        <button class="btn btn-info" type="button" id="green">打印绿色合格证</button>
    </div>
    <div style="width: 80mm;height: 50mm;padding:5px;display: none" id="div-stock">
        <font style="font-size: 20px;padding-left: 5px">
            ${vo.cusName}<c:if test="${vo.itemOwner ne '' && vo.itemOwner != null}">-</c:if>${vo.itemOwner}-${fns:getValueByDictKey(vo.itemVariety)}
        </font>
        <table>
            <tr>
                <td>
                    <img id="imgcode"/>
                </td>
                <c:if test="${vo.itemPriceType eq 141001 || vo.itemPriceType eq 141003 || vo.itemPriceType eq 141005}">
                    <td>
                        <b>
                        <span style="font-size: 35px;">${vo.trueWeight}<span style="font-size: 15px;">Kg</span></span>
                        </b>
                    </td>
                </c:if>
            </tr>
        </table>
        <table>
            <tr>
                <td style="width: 150px;"><font style="font-size: 15px;">幅宽 : ${vo.itemWidth}m</font></td>
                <td style="width: 150px;"><font style="font-size: 15px;">厚度 : ${vo.itemThick}mm</font></td>
            </tr>
            <tr>
                <td style="width: 150px;"><font style="font-size: 15px;">长度 : ${vo.itemLenth}m</font></td>
                <td style="width: 150px;"><font style="font-size: 15px;">颜色 : ${vo.itemColorValue}</font></td>
            </tr>
            <tr>
                <td style="width: 150px;"><font style="font-size: 15px;">机台 : ${vo.macCode}</font></td>
                <td style="width: 150px;"><font style="font-size: 15px;">质检 : ${user.name}</font></td>
            </tr>
        </table>
        <font style="font-size: 15px;padding-left: 2px" >压边类型 : ${fns:getDictValue(vo.itemYbType, 'prod_ybType', defaultValue)}</font>
        <br>
        <font style="font-size: 15px;padding-left: 2px" >时间:<fmt:formatDate value="${vo.createTime}" pattern="yyyy.MM.dd HH:mm"/></font>
        &nbsp;&nbsp;<font style="font-size: 15px;" >起止:${vo.seCode}</font>
    </div>

    <div style="width: 210mm;display: none" id="div-new">
        <table  border="0" cellspacing="0" style="padding-top: 31.5px;margin-top: 15px;">
            <tr>
                <td colspan="2" style="height:1px;"></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align:left;height:26px" ><font size=4>${fns:getValueByDictKey(vo.itemVariety)}  ${vo.itemWidth}m * ${vo.itemThick}mm</font></td>
            </tr>
            <tr>
                <td colspan="2"  style="text-align:left;height:26px"><font size=4>${vo.itemLenth}</font></td>
            </tr>
            <tr>
                <td colspan="2"  style="text-align:left;height:26px">
                    <font size=4>
                        <c:if test="${vo.itemPriceType eq 141001 || vo.itemPriceType eq 141003 || vo.itemPriceType eq 141005}">
                            ${vo.trueWeight}
                        </c:if>
                    </font>
                </td>
            </tr>
            <tr>
                <td colspan="2"  style="text-align:left;height:26px"><font size=4>生产班</font></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align:left;height:26px" ><font size=4><fmt:formatDate value="${vo.createTime}" pattern="yyyy年MM月dd日"/></font></td>
            </tr>
            <tr>
                <td colspan="2"  style="text-align:left;height:26px"><font size=4>${user.name}</font></td>
            </tr>
            <tr>
                <td colspan="2"  style="text-align:left;height:26px"><font size=4></font></td>
            </tr>
            <tr>
                <td colspan="2"  style="text-align:left;height:26px"><font size=4></font></td>
            </tr>
            <tr>
                <td colspan="2"  style="text-align:left;height:26px"><font size=4>jr<fmt:formatDate value="${vo.createTime}" pattern="yyyyMMddHHmm"/></font></td>
            </tr>
            <tr>
                <td colspan="2"  style="text-align:left;height:26px"><font size=4>${vo.seCode}</font></td>
            </tr>
        </table>
    </div>

    <div style="width: 210mm;display: none" id="div-red">
        <table  border="0" cellspacing="0" style=" padding-top: 75px;margin-top: 40px;">
            <tr>
                <td colspan="2" style="height:1px;"></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align:left;height:26px"><font size=4>${fns:getValueByDictKey(vo.itemVariety)} ${vo.itemWidth}m * ${vo.itemThick}mm</font></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align:left;height:26px"><font size=4>${vo.itemLenth}</font></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align:left;height:26px">
                    <font size=4>
                        <c:if test="${vo.itemPriceType eq 141001 || vo.itemPriceType eq 141003 || vo.itemPriceType eq 141005}">
                            ${vo.trueWeight}
                        </c:if>
                    </font>
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align:left;height:26px"><font size=4>生产班</font></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align:left;height:26px"><font size=4><fmt:formatDate value="${vo.createTime}" pattern="yyyy年MM月dd日"/></font></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align:left;height:26px"><font size=4>${user.name}
                    <c:if test="${vo.seCode ne '' && vo.seCode != null}">
                        (${vo.seCode})
                    </c:if></font></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align:left;height:26px"><font size=4></font></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align:left;height:26px"><font size=4></font></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align:left;height:26px"><font size=4>jr<fmt:formatDate value="${vo.createTime}" pattern="yyyyMMddHHmm"/></font></td>
            </tr>
        </table>
    </div>
    <div style="width: 210mm;display: none" id="div-yellow">
        <table  border="0" cellspacing="0" style="padding-left:400px;padding-top: 25px;margin-top: -18px;">
            <tr>
                <td colspan="2" style="height:1px;"></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align:left;height:32px"><font size=4>${fns:getValueByDictKey(vo.itemVariety)}</font></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align:left;height:32px"><font size=4>${vo.itemOwner}</font></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align:left;height:32px"><font size=4>${vo.itemWidth}m * ${vo.itemThick}</font></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align:left;height:32px"><font size=4>${vo.itemLenth} </font></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align:left;height:32px">
                    <font size=4>
                        <c:if test="${vo.itemPriceType eq 141001 || vo.itemPriceType eq 141003 || vo.itemPriceType eq 141005}">
                            ${vo.trueWeight}
                        </c:if>
                    </font>
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align:left;height:32px"><font size=4></font></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align:left;height:32px"><font size=4><fmt:formatDate value="${vo.createTime}" pattern="yyyy年MM月dd日"/></font></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align:left;height:32px"><font size=4>生产班</font></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align:left;height:32px"><font size=4>${user.name}
                    <c:if test="${vo.seCode ne '' && vo.seCode != null}">
                        (${vo.seCode})
                    </c:if></font></td>
            </tr>
        </table>
    </div>
    <div style="width: 210mm;display: none" id="div-green">
        <table  border="0" cellspacing="0" style="padding-left:390px; padding-top: 15px;margin-top: -18px;">
            <tr>
                <td colspan="2" style="height:1px;"></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align:left;height:35px;padding-left:110px;"><font size=4>${vo.itemOwner}</font></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align:left;height:35px;padding-left:70px"><font style="font-size: 15px;">
                    ${fns:getValueByDictKey(vo.itemVariety)} ${vo.itemWidth}m * ${vo.itemThick}mm</font></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align:left;height:35px;padding-left:110px;">
                    <font size=4>
                        <c:if test="${vo.itemPriceType eq 141001 || vo.itemPriceType eq 141003 || vo.itemPriceType eq 141005}">
                            ${vo.trueWeight} kg
                        </c:if>
                    </font>
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align:left;height:35px;padding-left:110px;"><font size=4>${vo.itemLenth} m</font></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align:left;height:35px;padding-left:110px;"><font size=4>${vo.seCode}</font></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align:left;height:35px;padding-left:110px;"><font size=4></font></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align:left;height:35px;padding-left:110px;"><font size=4>${user.name}</font></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align:left;height:35px;padding-left:110px;"><font size=4><fmt:formatDate value="${vo.createTime}" pattern="yyyy年MM月dd日"/></font></td>
            </tr>
        </table>
    </div>
</div>
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
<script src="${ctxStatic}/hPlugs/js/plugins/JsBarcode/JsBarcode.all.min.js"></script>
<script src="${ctxStatic}/hPlugs/js/LodopFuncs.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        var barCode = '${vo.barCode}';
        JsBarcode("#imgcode", barCode,{
            format: "CODE128",//选择要使用的条形码类型
            height:26,//高度
            width:1.5,
            displayValue:true,//是否在条形码下方显示文字
            fontSize:12,//设置文本的大小
            textPosition:"top",//设置文本的垂直位置
        });

        var LODOP;

        $("#stock").click(function () {
            LODOP=getLodop();
            LODOP.PRINT_INIT("打印标签");
            LODOP.SET_PRINT_STYLE("FontName","楷体");
            LODOP.ADD_PRINT_HTM(0,0,"80mm","50mm",document.getElementById("div-stock").innerHTML);
            // LODOP.PREVIEW();
            LODOP.PRINT();
        });
        $("#new").click(function () {
            LODOP=getLodop();
            LODOP.PRINT_INIT("打印合格证");
            LODOP.ADD_PRINT_HTM("3cm","3cm","210mm","150mm",document.getElementById("div-new").innerHTML);
            // LODOP.PREVIEW();
            LODOP.PRINT();
        });
        $("#red").click(function () {
            LODOP=getLodop();
            LODOP.PRINT_INIT("打印合格证");
            LODOP.ADD_PRINT_HTM("3cm","3cm","210mm","150mm",document.getElementById("div-red").innerHTML);
            // LODOP.PREVIEW();
            LODOP.PRINT();
        });
        $("#yellow").click(function () {
            LODOP=getLodop();
            LODOP.PRINT_INIT("打印合格证");
            LODOP.ADD_PRINT_HTM("3cm","3cm","210mm","150mm",document.getElementById("div-yellow").innerHTML);
            // LODOP.PREVIEW();
            LODOP.PRINT();
        });
        $("#green").click(function () {
            LODOP=getLodop();
            LODOP.PRINT_INIT("打印合格证");
            LODOP.ADD_PRINT_HTM("3cm","3cm","210mm","150mm",document.getElementById("div-green").innerHTML);
            // LODOP.PREVIEW();
            LODOP.PRINT();
        });
    });

</script>
