<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/views/sys/includes/taglib.jsp"%>
<html>
<head>
<title>用户列表-用户组管理</title>
<meta name="decorator" content="default" />
<%@include file="/WEB-INF/views/sys/includes/dialog.jsp"%>
<style type="text/css">
.sort {
	color: #0663A2;
	cursor: pointer;
}

.btn-config {
	float: right;
	margin-right: 10px;
}
</style>
</head>
<body>
	<div class="container-fluid">
		<h1>${group.groupname}</h1>
		<dd> —— <i><fmt:formatDate value="${group.createtime}" pattern="yyyy-MM-dd HH:mm:ss" /></i> </dd>
		<dd> —— <i>${group.remarks}</i> </dd>
	</div>
	<form:form modelAttribute="user" id="searchForm" action="/ucenter/usergroup/groupUsersView.do?id=${group.id}" method="post" class="breadcrumb form-search">
		<div style="margin-top: 8px;">
			<label for="realname">姓&nbsp;&nbsp;名：</label> 
			<form:input path="realname" htmlEscape="false" maxlength="50" class="input-small" /> 
			<input id="btnSubmit" class="btn btn-primary btn-query" type="submit" value="查询" /> 
			<a class="btn btn-config" href="javascript:void(0);" id="JS_CONFIG_SUBJECT" data-id="${group.id }">配置用户</a>
		</div>
	</form:form>

	<table id="contentTable" class="table table-striped table-bordered">
		<thead>
			<tr>
				<th>登录名</th>
				<th>姓名</th>
				<th>部门</th>
				<th>电话</th>
				<th>手机</th>
				<th>微信同步状态</th>
				<th>操作</th>
			</tr>

		</thead>
		<tbody>
			<c:forEach items="${page.data}" var="user">
				<tr>
					<td>${user.username}</td>
					<td>${user.realname}</td>
					<td>${user.DEPTLABEL}</td>
					<td>${user.phone}</td>
					<td>${user.mobile}</td>
					<td>${user.UGWECHATSTATUSLABEL}</td>
					<td><a href="${ctx}/ucenter/userandgroup/delete.do?userid=${user.id}&usergroupid=${group.id }" onclick="return confirmx('确认要删除该用户吗？', this.href)">删除</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page.getPageHtml()}</div>
	<script>
		(function($) {
			$('#JS_CONFIG_SUBJECT').bind('click', function() {
				$.jBox("iframe:${ctx}/ucenter/user/forGroupUsersView.do?groupId=${group.id }",
					{
						title : '向用户组[${group.groupname}]加用户',
						top : '2%',
						width : 1024,
						height : 500,
						buttons : {
							'确定' : 'ok'
						},
						submit : function(v, h, f) {
							//v 点击按钮的值，比如点击的是上面buttons定义的关闭按钮，那么v=true
							//h 前一个页面的Jqeury对象
							//f 弹出层中form表单键值
							if (v == 'ok') {
								var iframeName = h.children(0).attr("name");
								var container = window.frames[iframeName].document
								var checked = $('input[type="checkbox"]:checked',container).not(".checkAll");
								var uids = '',unames = '' ;
								$.each(checked,function(index,item) {
									uids += $(item).val()+ ',';
									unames += $(item).attr('data-username') + ',';
								});
								uids = uids.substr(0,uids.length - 1);
								var form = $('<form class="hide"></form>');
								$(form).attr('action','${ctx}/ucenter/userandgroup/add.do');
								$(form).attr('method','post');
								$(form).append('<input name="usergroupid" value="${group.id}" />');
								$(form).append('<input name="uids" value="' + uids + '" />');
								$(form).append('<input name="unames" value="' + unames + '" />');
								$(form).submit();
							}
						}
					});
			});
		})($);
	</script>
</body>
</html>