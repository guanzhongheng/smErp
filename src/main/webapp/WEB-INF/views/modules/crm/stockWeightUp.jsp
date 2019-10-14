<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<body>
<form method="post" class="form-horizontal" >
    <input type="hidden" id="stockId" name="stockId" value="${stockId}">
    <br/><br/>
    <div class="control-group" style="margin-left: -30px">
        <label class="col-sm-1 control-label">重量:</label>
        <div class="col-sm-8 controls">
            <input type="text" name="stockWeight" id="stockWeight" />
        </div>
    </div>
</form>
</body>
</html>