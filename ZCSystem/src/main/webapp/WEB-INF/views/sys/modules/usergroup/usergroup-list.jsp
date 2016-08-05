<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/views/sys/includes/taglib.jsp"%>
<html>
<head>
<title>用户组-用户管理</title>
<meta name="decorator" content="default" />
<%@include file="/WEB-INF/views/sys/includes/dialog.jsp"%>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="/ucenter/usergroup/listView.do">用户组列表</a></li>
		<li><a href="/ucenter/usergroup/formView.do">用户组添加</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="group" action="${ctx }/ucenter/usergroup/listView.do" method="post" class="breadcrumb form-search">
		<label for="groupname">用户组名：</label>
		<form:input path="groupname" htmlEscape="false" maxlength="50" class="input-small" />
		<input id="btnSubmit" class="btn btn-primary btn-query" type="submit" value="查询" />
	</form:form>
	<table id="contentTable" class="table table-striped table-bordered">
		<thead>
			<tr>
				<th>用户组名</th>
				<th>微信同步状态</th>
				<th>创建时间</th>
				<th>备注</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.data}" var="group">
				<tr>
					<td>${group.groupname}</td>
					<td>${group.WECHATSTATUSLABEL }</td>
					<td><fmt:formatDate value="${group.createtime}" pattern="yyyy-MM-dd" /></td>
					<td>${group.remarks}</td>
					<td>
						<c:if test="${group.allowedit==1}"> 
							<a href="${ctx}/ucenter/usergroup/formView.do?id=${group.id}">修改</a>
						</c:if> 
						<c:if test="${group.allowdel==1}">
							<a href="${ctx}/ucenter/usergroup/delete.do?id=${group.id}" onclick="return confirmx('确认要删除该用户组吗？', this.href)">删除</a>
						</c:if> 
						<a href="${ctx}/ucenter/usergroup/groupUsersView.do?id=${group.id}">配置用户</a>
						<c:if test="${group.wechatstatus == 0 || group.wechatstatus == 2 }">
							<a class="syncButton" href="javascript:void(0);" data-href="${ctx}/ucenter/sync/syncWechat.do" data-flag="GROUP" data-id="${group.id}">同步微信</a> 
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