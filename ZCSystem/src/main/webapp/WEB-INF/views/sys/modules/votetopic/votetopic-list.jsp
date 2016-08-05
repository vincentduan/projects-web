<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/views/sys/includes/taglib.jsp"%>
<html>
<head>
<title>题目列表-投票管理</title>
<meta name="decorator" content="default" />
<%@include file="/WEB-INF/views/sys/includes/dialog.jsp"%>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="/votes/vote/topicListView.do">题目列表</a></li>
		<li><a href="/votes/vote/topicFormView.do">题目添加</a></li>
	</ul>
	<table id="contentTable" class="table table-striped table-bordered">
		<thead>
			<tr>
				<th>题号</th>
				<th>标题</th>
				<th>题目类型</th>
				<th>操作</th>
				<th>排序</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.data}" var="topic" varStatus="status">
				<tr>
				    <td>${status.index + 1 }</td>
					<td>${topic.TITLE }</td>
					<td>${topic.KINDSLABEL }</td>
					<td>
						<a href="${ctx}/ucenter/user/view.do?id=${topic.id}">查看</a> 
						<a href="${ctx}/ucenter/user/editView.do?id=${topic.id}">修改</a>
						<a href="${ctx}/ucenter/user/delete.do?id=${topic.id}" onclick="return confirmx('确认要删除该用户吗？', this.href)">删除</a>
					</td>
					<td>排序</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page.getPageHtml()}</div>
</body>
</html>