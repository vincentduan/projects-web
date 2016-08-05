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
		<li class="active">
			<a href="${ctx}/ucenter/dept/listView.do">机构列表</a>
		</li>
		<li>
			<a href="${ctx}/ucenter/dept/formView.do">机构添加</a>
		</li>
	</ul>
	<form:form id="searchForm" modelAttribute="dept" action="/ucenter/dept/listView.do" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="" />
		<input id="pageSize" name="pageSize" type="hidden" value="" />
		<input id="orderBy" name="orderBy" type="hidden" value="" />
		<div style="margin-top: 8px;">
			<label for="parentid">上级机构：</label>
			<form:select path="parentid" class="required parentid">
				<form:option value="1">----</form:option>
				<c:forEach var="pdept" items="${fns:getDepartmentList(0)}">
				<form:option value="${pdept.id }">${pdept.deptname }</form:option>
				</c:forEach>
			</form:select>
			<label for="deptname">机构名称：</label>
			<form:input path="deptname" htmlEscape="false" maxlength="50" class="input" />
			<input id="btnSubmit" class="btn btn-primary btn-query"
				type="submit" value="查询" />
		</div>
	</form:form>
	<table id="contentTable" class="table table-striped table-bordered ">
		<thead>
			<tr>
				<th>序号</th>
				<th>机构名称</th>
				<th>机构编号</th>
				<th>上级机构</th>
				<th>微信同步状态</th>
				<th>备注</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.data}" var="dept" varStatus="status">
				<tr>
				    <td>${status.index + 1 }</td>
					<td>${dept.deptname }</td>
					<td>${dept.deptno }</td>
					<td>${dept.PARENTIDLEBAL }</td>
					<td>${dept.WECHATSTATUSLABEL }</td>
					<td>${dept.remarks }</td>
					<td>
					<a href="${ctx}/ucenter/dept/formView.do?id=${dept.id}">修改</a>
					<a href="${ctx}/ucenter/dept/delete.do?id=${dept.id}" onclick="return confirmx('确认要删除该用户吗？', this.href)">删除</a>
					<c:if test="${dept.wechatstatus == 0 || dept.wechatstatus == 2 }">
						<a class="syncButton" href="javascript:void(0);" data-href="${ctx}/ucenter/sync/syncWechat.do" data-flag="DEPT" data-id="${dept.id}">同步微信</a> 
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