<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/views/sys/includes/taglib.jsp"%>
<html>
<head>
<title>用户列表-添加用户</title>
<meta name="decorator" content="default" />
<%@include file="/WEB-INF/views/sys/includes/dialog.jsp"%>
</head>
<body>
	<form:form id="searchForm" modelAttribute="user" action="/ucenter/user/forGroupUsersView.do?groupId=${groupId}" method="post" class="breadcrumb form-search">
		<div style="margin-top: 8px;">
			<label for="realname">姓&nbsp;&nbsp;&nbsp;名：</label>
			<form:input path="realname" htmlEscape="false" maxlength="50" class="input-small" />
			<input id="btnSubmit" class="btn btn-primary btn-query" type="submit" value="查询" />
		</div>
	</form:form>
	<form id="userForm" method="post" name="userForm">
		<table id="contentTable" class="table table-striped table-bordered">
			<thead>
				<tr>
					<th><input type="checkbox" name="userid" id="checkAll"></th>
					<th>登录名</th>
					<th>姓名</th>
					<th>部门</th>
					<th>电话</th>
					<th>手机</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${page.data}" var="user">
					<tr>
						<td><input type="checkbox" value="${user.id}" data-username="${user.username}" name="userid"></td>
						<td>${user.username}</td>
						<td>${user.realname}</td>
						<td>${user.DEPTIDLABEL}</td>
						<td>${user.phone}</td>
						<td>${user.mobile}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
	<div class="pagination">${page.getPageHtml()}</div>
	<script type="text/javascript">
	;(function($){
		selectAll('checkAll',$('#contentTable'));
	})($);
	</script>
</body>
</html>