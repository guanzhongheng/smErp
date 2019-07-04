<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<body>
<form method="post" class="form-horizontal" id="transferInfo">
    <input type="hidden" id="taskIds" name="taskIds" value="${taskIds}">
    <br/><br/>
    <div class="control-group">
        <label class="col-sm-3 control-label">机台选择:</label>
        <div class="col-sm-6 controls">
            <select id="devInfo" name="devInfo" class="input-medium">
                <option value="1">一号机台</option>
                <option value="2">二号机台</option>
            </select>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-3 control-label"></label>
        <div class="col-sm-6 controls">
            <p><small>*如需变更客户相关记录归属人员请勾选相关选项</small></p>
        </div>
    </div>
</form>
</body>
</html>