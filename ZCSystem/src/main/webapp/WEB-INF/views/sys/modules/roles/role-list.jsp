<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/sys/includes/taglib.jsp"%>

<div>
	<table id="contentTable" class="table table-striped table-bordered">
		<thead>
			<tr>
				<th>角色代码</th>
				<th>角色名称</th>
				<th>创建人</th>
				<th>创建时间</th>
				<th>是否允许编辑</th>
				<th>是否允许删除</th>
				<th>角色状态</th>
				<th>操作</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${page.data}" var="role">
				<tr>
					<td>${role.roleno }</td>
					<td>${role.rolename }</td>
					<td>${role.createUsername }</td>
					<td><fmt:formatDate value="${role.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td>${role.alloweditName}</td>
					<td>${role.allowdelName}</td>
					<td>${role.statusName}</td>
					<td>
						<c:if test="${role.allowedit==1}">
							<a href="${ctx}/ucenter/role/editView.do?id=${role.id}">修改</a>&nbsp;
						</c:if>
						<c:if test="${role.allowdel==1}">
							<a href="${ctx}/ucenter/role/delete.do?id=${role.id}"
								onclick="return confirmx('确认要删除该用户吗？', this.href)">删除</a> 
						</c:if>
							<a href="${ctx}/ucenter/subject/listView.do?roleid=${role.id}" >配置本体</a> 
					</td>
				</tr>
			</c:forEach>
		</tbody>
		
	</table>
	<div class="pagination">${page.getPageHtml()}</div>
</div>
