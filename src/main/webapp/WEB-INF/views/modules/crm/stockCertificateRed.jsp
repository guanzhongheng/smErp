<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>通用膜_A4纸打印</title>
    <style type="text/css">
        body
        {
            margin: 0;
            padding: 0;
            background-color: #FAFAFA;
            font: 12pt "Tahoma";
        }
        *
        {
            box-sizing: border-box;
            -moz-box-sizing: border-box;
        }
        .page
        {
            width: 21cm;
            min-height: 29.7cm;
            padding: 2cm;
            margin: 0cm auto;
            #border: 1px #D3D3D3 solid;
            border-radius: 5px;
            background: white;
            box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
        }
        .subpage
        {
            padding: 1cm;
            border: 5px rgba(0,0,0,0) solid;
            height: 150mm;
            width:200mm;
            outline: 2cm rgba(0,0,0,0) solid;
        }
        @page
        {
            size: A4;
            margin: 0;
        }
        @media print
        {
            .page
            {
                margin: 0;
                border: initial;
                border-radius: initial;
                width: initial;
                min-height: initial;
                box-shadow: initial;
                background: initial;
                page-break-after: always;
            }
        }
        td {
            text-align:left;
            height:26px
        }
    </style>
</head>
<body>
<div class="book">
    <div class="page">
        <div class="subpage">

            <div class="gray-bg" style="background-color: white">
            <div>
                <div style="text-align: right;"><div id="imgcode" style="margin-right: 40px;margin-top: -90px;"></div></div>
                <div style="width:100%;padding-left:0px;padding-top: 30px;margin-top: 0px;">
                    <table  border="0" cellspacing="0" style="height:180px;">
                        <tr>
                            <td colspan="2"><font size=4>${fns:getValueByDictKey(vo.itemVariety)} ${vo.itemWidth}m * ${vo.itemThick}mm</font></td>
                        </tr>
                        <tr>
                            <td colspan="2" ><font size=4>${vo.itemLenth}</font></td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <font size=4>
                                    <c:if test="${vo.itemPriceType eq 141001 || vo.itemPriceType eq 141003 || vo.itemPriceType eq 141005}">
                                        ${vo.itemWeight-vo.itemTareWeight}
                                    </c:if>
                                </font>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2"><font size=4>生产班</font></td>
                        </tr>
                        <tr>
                            <td colspan="2"><font size=4><fmt:formatDate value="${vo.createTime}" pattern="yyyy年MM月dd日"/></font></td>
                        </tr>
                        <tr>
                            <td colspan="2"><font size=4>${user.name}
                                <c:if test="${vo.seCode ne '' && vo.seCode != null}">
                                    (${vo.seCode})
                                </c:if></font></td>
                        </tr>
                        <tr>
                            <td colspan="2"><font size=4></font></td>
                        </tr>
                        <tr>
                            <td colspan="2"><font size=4></font></td>
                        </tr>
                        <tr>
                            <td colspan="2"><font size=4>${vo.barCode}</font></td>
                        </tr>
                        <tr>
                            <td colspan="2"><font size=4>${vo.seCode}</font></td>
                        </tr>
                        <tr>
                            <td colspan="2"><font size=4>${vo.useTime}</font></td>
                        </tr>
                    </table>
                    <div style="text-align: center;    margin-top: 5px;">
                        <button class="btn btn-primary global-button-style" type="button" id="bth" onclick="" >打印</button>
                    </div>
                </div>
            </div>
            <script src="js/jquery.min.js?v=2.1.4"></script>
            <script src="js/bootstrap.min.js?v=3.3.6"></script>
            <script src="${ctxStatic}/hPlugs/js/jquery.qrcode.js"></script>
            <script src="${ctxStatic}/hPlugs/js/qrcode.js"></script>


                <script type="text/javascript">
                $(document).ready(function () {
                    var barCode = '${vo.barCode}';
                    $("#imgcode").qrcode(barCode);
                })
                $("#bth").click(function () {
                    $("#bth").hide();
                    window.print();
                    parent.layer.closeAll();
                });
            </script>
            </div>

        </div>
    </div>

</div>
</body>
</html>