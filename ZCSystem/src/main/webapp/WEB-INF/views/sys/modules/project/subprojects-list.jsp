<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/views/sys/includes/taglib.jsp"%>
<html>
<head>
<title>子项目管理</title>
<meta name="decorator" content="default" />
<%@include file="/WEB-INF/views/sys/includes/dialog.jsp"%>
<script type="text/javascript">
	function deletepro (id){
		$.ajax({
            type: "GET",
            url:"${ctx}/projects/project/delete.do?id="+id,
            async: false,
            error: function(request) {
            	$.messager
				.confirm(
						"提示",
						"操作失败");
            },
            success: function(data) {
            	$.messager
				.confirm(
						"提示",
						data,
						function() {
							window.location.reload();
						});
            }
        });
	}
</script>
</head>
<body>

	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/projects/project/subProlistView.do?parentid=${parentid }">子项目列表</a></li>
		<li><a href="${ctx}/projects/project/subformView.do?parentid=${parentid }">添加子项目</a></li>
		<a href="${ctx}/projects/project/listView.do"><input type="button" class="btn btn-default" style="float:right" value="返回父列表"></a>
	</ul>
	
	<form:form id="searchForm" modelAttribute="project"
		action="/projects/project/view.do" method="post"
		class="breadcrumb form-search">
		<div style="margin-top: 8px;">
			<label>子项目名称：</label>
			<form:input path="projectname" htmlEscape="false" maxlength="50"
				class="input-small" />
			<form:input path="parentid" value="${parentid }" type="hidden"/>
			<input type="hidden" name="viewpath" value="subprojects-list">
			&nbsp;<input id="btnSubmit" class="btn btn-primary btn-query"
				type="submit" value="查询" />
		</div>
	</form:form>
	<table id="contentTable"
		class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>序号</th>
				<th>项目名称</th>
				<th>项目状态</th>
				<th>项目发布时间</th>
				<th>项目众筹时间</th>
				<th>项目验收时间</th>
				<th>项目结束时间</th>
				<th>集赞票数</th>
				<th>集反对票数</th>
				<th>是否允许点赞</th>
				<th>最大可点赞的子项目数</th>
				<th>&nbsp;&nbsp;&nbsp;&nbsp;操&nbsp;&nbsp;作&nbsp;&nbsp;&nbsp;&nbsp;</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.data}" var="pro" varStatus="status">
				<tr>
					<td>${status.index + 1 }</td>
					<td>${pro.projectname }</td>
					<td>
						<c:choose>
    						<c:when test="${pro.projectstatus == 0 }">
    							发布
    						</c:when>
    						<c:when test="${pro.projectstatus == 1 }">
    							众筹
    						</c:when>
    						<c:when test="${pro.projectstatus == 2 }">
    							验收
    						</c:when>
    						<c:when test="${pro.projectstatus == 3 }">
    							完成
    						</c:when>
    					</c:choose>
					</td>
					<td><fmt:formatDate value="${pro.starttime }" pattern="yyyy-MM-dd"/></td>
					<td><fmt:formatDate value="${pro.crowdtime }" pattern="yyyy-MM-dd"/></td>
					<td><fmt:formatDate value="${pro.examinetime }" pattern="yyyy-MM-dd"/></td>
					<td><fmt:formatDate value="${pro.endtime }" pattern="yyyy-MM-dd"/></td>
					<td>${pro.agreecount }</td>
					<td>${pro.againstcount }</td>
					<td>
						<c:choose>
    						<c:when test="${pro.isallowedagree == 0 }">
    							不允许对本项目点赞
    						</c:when>
    						<c:when test="${pro.isallowedagree == 1 }">
    							允许对本项目点赞
    						</c:when>
    						<c:when test="${pro.isallowedagree == 2 }">
    							允许对子项目点赞
    						</c:when>
    						<c:when test="${pro.isallowedagree == 3 }">
    							同时允许
    						</c:when>
    					</c:choose>
    				</td>
					<td>${pro.maxagreelimit }</td>
					<td>
						<a href="${ctx}/projects/project/subformView.do?id=${pro.id }">修改</a><br> <%-- <a href="${ctx}/ucenter/dept/delete.do?id=${dept.id}" onclick="return confirmx('确认要删除该用户吗？', this.href)">删除</a> --%>
						<a href="${ctx}/projects/project/delete.do?id=${pro.id }"  onclick="deletepro(${pro.id });return false">删除</a><br>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page.getPageHtml()}</div>
</body>
</html>