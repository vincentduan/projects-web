<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/views/sys/includes/taglib.jsp"%>
<html>
<head>
<title>投票列表-投票管理</title>
<meta name="decorator" content="default" />
<%@include file="/WEB-INF/views/sys/includes/dialog.jsp"%>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="/votes/vote/listView.do">投票列表</a></li>
		<li><a href="/votes/vote/formView.do">投票添加</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="vote" action="/votes/vote/listView.do" method="post" class="breadcrumb form-search">
		<div style="margin-top: 8px;" class="">
			<label for="title">标 题：</label>
			<form:select path="status">
				<form:option value="-1">全部</form:option>
				<form:option value="0">草稿</form:option>
				<form:option value="1">已发布</form:option>
				<form:option value="2">收集中</form:option>
				<form:option value="3">已结束</form:option>
			</form:select>
			<label for="title">标 题：</label>
			<form:input path="title" htmlEscape="false" maxlength="50" class="input-small" />
			<input id="btnSubmit" class="btn btn-primary btn-query" type="submit" value="查询" />
		</div>
	</form:form>
	<table id="contentTable" class="table table-striped table-bordered">
		<thead>
			<tr>
				<th>序号</th>
				<th>邮票标题</th>
				<th>创建时间</th>
				<th>截止时间</th>
				<th>状态</th>
				<th>投票人数</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.data}" var="vote" varStatus="status">
				<tr>
				    <td>${status.index + 1 }</td>
					<td>${vote.TITLE }</td>
					<td><fmt:formatDate value="${vote.CREATETIME }" pattern="yyyy-MM-dd"/></td>
					<td><fmt:formatDate value="${vote.DEADLINE }" pattern="yyyy-MM-dd"/></td>
					<td>${vote.STATUSLABEL}</td>
					<td>1/1</td>
					<td>
						<a href="${ctx}/ucenter/user/view.do?id=${vote.id}">查看</a> 
						<a href="${ctx}/ucenter/user/editView.do?id=${vote.id}">修改</a>
						<a href="${ctx}/ucenter/user/delete.do?id=${vote.id}" onclick="return confirmx('确认要删除该用户吗？', this.href)">删除</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page.getPageHtml()}</div>
</body>
</html>