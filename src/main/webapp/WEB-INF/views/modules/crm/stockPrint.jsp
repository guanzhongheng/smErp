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

<div class="gray-bg" >
    <div style="width:90%;padding:7px 8px 5px 32px;">

        <table>
            <tr style="height:30px;">
                <td colspan="4" style=""><span style="font-size: 22px;">
                    ${vo.cusName}
                    <c:if test="${vo.itemOwner ne '' && vo.itemOwner != null}">
                        -
                    </c:if>
                    ${vo.itemOwner}
                        - ${fns:getValueByDictKey(vo.itemVariety)}</span></td>
            </tr>
        </table>
        <table>
            <tr>
                <td>
                    <img id="imgcode"/>
                </td>
                <c:if test="${vo.itemPriceType eq 141001 || vo.itemPriceType eq 141003 || vo.itemPriceType eq 141005}">
                    <td style="width:70px;"><b>
                        <span style="font-size: 35px;">${vo.itemWeight-vo.itemTareWeight}<span style="font-size: 15px;">Kg</span></span>

                    </b></td>
                </c:if>
            </tr>
        </table>


        <table>
            <tr>
                <td colspan="2"><font style=";font-size: 16px;">幅宽 : ${vo.itemWidth}m</font></td>
                <td colspan="2">&nbsp;&nbsp;&nbsp;<font style="font-size: 15px;">厚度 : ${vo.itemThick}mm</font></td>
            </tr>
            <tr>
                <td colspan="2"><font style="font-size: 16px;">长度 : ${vo.itemLenth}m</font></td>
                <td colspan="2">&nbsp;&nbsp;&nbsp;<font style="font-size: 15px;">颜色 : ${vo.itemColorValue}</font></td>
            </tr>
            <tr>
                <td colspan="2"><font style="font-size: 16px;">生产机台 : ${vo.macCode}</font></td>
                <td colspan="2">&nbsp;&nbsp;&nbsp;<font style="font-size: 15px;">质检 : ${user.name}</font></td>
            </tr>
            <tr>
                <td colspan="4"><font style="font-size: 16px;" >压边类型 : ${fns:getDictValue(vo.itemYbType, 'prod_ybType', defaultValue)}</font></td>
            </tr>
        </table>
        <font style="font-size: 16px;" >时间:<fmt:formatDate value="${vo.createTime}" pattern="yyyy.MM.dd HH:mm"/></font>
        &nbsp;<font style="font-size: 16px;" >起止:${vo.seCode}</font>
        <div style="text-align: center;    margin-top: 5px;" id="btnArea">
            <button class="btn btn-primary " type="button" id="bth" >打印</button>
        </div>
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
<script type="text/javascript">
    $(document).ready(function () {
        // var LODOP = getLodop();
        // console.log(LODOP);
        // LODOP.SET_PRINT_MODE("TRYLINKPRINTER_NOALERT",true);//这个语句设置网络共享打印机连接不通时是否提示一下
        // if (LODOP.SET_PRINTER_INDEX(0)){
        //     LODOP.PRINT();
        // }//这里指定第0号打印机打印


        var barCode = '${vo.barCode}';
        var jump = '${jump}';
        JsBarcode("#imgcode", barCode,{
            format: "CODE128",//选择要使用的条形码类型
            height:26,//高度
            width:1.5,
            displayValue:true,//是否在条形码下方显示文字
            fontSize:12,//设置文本的大小
            textPosition:"top",//设置文本的垂直位置
        });

        $("#bth").click(function () {
            $("#btnArea").hide();
            window.print();
            // if(jump == 0) {
            //     parent.setTimeout('window.location.href = "/crm/produce/list"', 100);
            // }
            parent.layer.closeAll();
        });
    });


    function print33(){

    }
</script>
