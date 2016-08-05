<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/views/sys/includes/taglib.jsp"%>
<html>
<head>
<title>添加部门-部门管理</title>
<meta name="decorator" content="default" />
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/ucenter/dept/listView.do">机构列表</a></li>
		<li class="active">
			<a href="${ctx}/ucenter/dept/formView.do">${dept.id == null ?'机构添加' : '机构修改' }</a>
		</li>
	</ul>
	<br />
	<form:form id="inputForm" modelAttribute="dept" action="/ucenter/dept/modify.do" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<div class="control-group">
			<label class="control-label">上级机构:</label>
			<div class="controls">
				<form:select path="parentid" class="required parentid">
				<form:option value="1">----</form:option>
				<c:forEach var="pdept" items="${fns:getDepartmentList(0)}">
				<form:option value="${pdept.id }">${pdept.deptname }</form:option>
				</c:forEach>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">机构名称:</label>
			<div class="controls">
				<form:input path="deptname" htmlEscape="false" maxlength="50"
						class="required deptname" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">机构编号:</label>
			<div class="controls">
				<form:input path="deptno" htmlEscape="false" maxlength="50"
						class="required deptno" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">排序:</label>
			<div class="controls">
				<form:input path="sortcode" htmlEscape="false" maxlength="50" type="number"
						class="required sortcode" />
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
			<input id="btnSubmit" class="btn btn-primary" type="submit"
						value="提 交" />
			<input id="btnCancel" class="btn" type="button" value="返 回"
				onclick="history.go(-1)" />
		</div>
	</form:form>
</body>
</html>