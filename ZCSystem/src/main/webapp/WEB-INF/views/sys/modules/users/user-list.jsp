<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/views/sys/includes/taglib.jsp"%>
<html>
<head>
<title>用户列表-用户管理</title>
<meta name="decorator" content="default" />
<%@include file="/WEB-INF/views/sys/includes/dialog.jsp"%>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="/ucenter/user/listView.do">用户列表</a></li>
		<li><a href="/ucenter/user/formView.do">用户添加</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="user"
		action="/ucenter/user/listView.do" method="post"
		class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="" />
		<input id="pageSize" name="pageSize" type="hidden" value="" />
		<input id="orderBy" name="orderBy" type="hidden" value="" />
		<div style="margin-top: 8px;">
			<label>姓&nbsp;&nbsp;&nbsp;名：</label>
			<form:input path="realname" htmlEscape="false" maxlength="50" class="input-small" />
			<input id="btnSubmit" class="btn btn-primary btn-query" type="submit" value="查询" />
		</div>
	</form:form>
	<table id="contentTable" class="table table-striped table-bordered">
		<thead>
			<tr>
				<th>序号</th>
				<th>归属部门</th>
				<th>省分</th>
				<th>登录名</th>
				<th>姓名</th>
				<th>电话</th>
				<th>手机</th>
				<th>微信同步状态</th>
				<th>备注</th>
				<th>操作</th>
				<!--<shiro:hasPermission name="sys:user:edit">
					<th>操作</th>
				</shiro:hasPermission>-->
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.data}" var="user" varStatus="status">
				<tr>
				    <td>${status.index + 1 }</td>
					<td>联通时科</td>
					<td>${user.PROVIDLABEL}</td>
					<td><a href="${ctx}/sys/user/form?id=${user.id}">${user.username}</a></td>
					<td>${user.realname}</td>
					<td>${user.mobile}</td>
					<td>${user.phone}</td>
					<td>${user.WECHATSTATUSLABEL }</td>
					<td>${user.remarks }</td>
					<td>
						<a href="${ctx}/ucenter/user/formView.do?id=${user.id}">修改</a> 
						<a href="${ctx}/ucenter/user/delete.do?id=${user.id}" onclick="return confirmx('确认要删除该用户吗？', this.href)">删除</a>
						<c:if test="${user.wechatstatus == 0 || user.wechatstatus == 2 }">
							<a class="syncButton" href="javascript:void(0);" data-href="${ctx}/ucenter/sync/syncWechat.do" data-flag="USER" data-id="${user.id}">同步微信</a> 
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page.getPageHtml()}</div>
	<script type="text/javascript">
	;(function($){
		$('.syncButton').on('click',function(){
			var _this = this;
			var params = {flag:$(_this).attr('data-flag'),id:$(_this).attr('data-id')};
			sendRequestPost($(_this).attr('data-href'),params,function(data){
				if(data.status == 0 ){
					$.jBox.alert(data.desc,'提示');
					window.locaton.href = window.locaton.href; 
				}
			});
		});
	})($);
	</script>
</body>
</html>