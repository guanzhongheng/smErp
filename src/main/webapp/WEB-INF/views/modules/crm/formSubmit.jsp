<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<body>
<form method="post" class="form-horizontal" id="transferInfo">
    <input type="hidden" id="ids" name="ids" value="${ids}">
    <br/><br/>
    <div class="control-group">
        <label class="col-sm-1 control-label">接收对象:</label>
        <div class="col-sm-8 controls">
            <select id="cusContent" name="cusContent" class="input-medium">
                <c:forEach items="${userList}" var="us">
                	<option value="${us.loginName}">${us.loginName}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="control-group">
        <label class="col-sm-1 control-label">备注信息:</label>
        <div class="col-sm-8 controls">
            <textarea id="remarks" name="remarks" rows="5" maxlength="200" class="input-xlarge"></textarea>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-1 control-label"></label>
        <div class="col-sm-8 controls">
            <p><small>*如需变更客户相关记录归属人员请勾选相关选项</small></p>
        </div>
    </div>
</form>
</body>
</html>