<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/views/sys/includes/taglib.jsp"%>
<html>
<head>
<title>用户管理-角色管理</title>
<meta name="decorator" content="default" />
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="/ucenter/usergroup/listView.do">用户组列表</a></li>
		<li class="active">
			<a href="/ucenter/usergroup/formView.do">${group.id == null ? '用户组添加' : '用户组修改' }</a>	
		</li>
	</ul>
		<form:form id="inputForm" modelAttribute="group" action="/ucenter/usergroup/modify.do" method="post" class="form-horizontal">
			<form:hidden path="id" />

			<div class="control-group">
				<label class="control-label">用户组名:</label>
				<div class="controls">
					<form:input path="groupname" htmlEscape="false" maxlength="50" class="required groupname" />
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">是否允许编辑:</label>
				<div class="controls">
					<form:select path="allowedit">
						<form:option value="1">是</form:option>
						<form:option value="0">否</form:option>
					</form:select>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">是否允许删除:</label>
				<div class="controls">
					<form:select path="allowdel">
						<form:option value="1">是</form:option>
						<form:option value="0">否</form:option>
					</form:select>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">备注:</label>
				<div class="controls">
					<form:textarea path="remarks" htmlEscape="false" rows="3"
						maxlength="200" class="input-xlarge" />
				</div>
			</div>
			<div class="form-actions">
				<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存" />
				<input id="btnCancel" class="btn" type="button" value="返 回"
					onclick="history.go(-1)" />
			</div>
		</form:form>
</body>
</html>