<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商户管理>>服务商管理</title>
<script type="text/javascript">
	window.onload = function() {
		document.getElementById('商户管理').className = "hover";
	}
</script>
<!--[if IE 6]>
<SCRIPT src="http://d1.lashouimg.com/static/js/release/iepng.js"></SCRIPT>
<script type="text/javascript">
	DD_belatedPNG.fix('.iepng');
</script>
<![endif]-->
</head>
<body>
	<%@ include file="/WEB-INF/view/common/header.jsp"%>
	<div class="w">
		<ul class="nav-subul">
			<li class="hover"><a href="#">服务商管理</a></li>
			<li><a href="<%=basePath%>spcontract/spcontractList">合同列表</a></li>
		</ul>
	</div></div>
	<!--content-->
	<div class="cont">
		<div class="w">
			<div class="cf">
				<a href="<%=basePath%>sp/addSp" class="l add-export"><i
					class="ui-icon"></i>添加服务商</a>

				<ul class="r mode-filter">
					<li><form action="<%=basePath%>sp/spList" method="post">
							<input type="text" name="name" class="text-input" value=""
								placeholder="服务商名称"><input type="text" name="id"
								class="text-input" value="" placeholder="服务商编号"> <select
								name="status" style="width: 150px;">
								<option value="" selected="true">服务商状态</option>
								<option value="1">未开通</option>
								<option value="2">正常</option>
								<option value="3">冻结</option>
							</select> <input type="submit" value="搜索" tabindex="12" class="export">
						</form></li>
				</ul>
			</div>
			<!--内容-->
			<div class="view-list">
				<table width="100%" class="ui-tab">
					<tbody>
						<tr>
							<th>服务商ID</th>
							<th>服务商名称</th>
							<th>录入时间</th>
							<th>录入人</th>
							<th>审批状态</th>
							<th>服务商状态</th>
							<th>量体师</th>
							<th width="250">操作</th>
						</tr>
						<c:forEach items="${requestScope.items}" var="item">
							<tr>
								<td class="noline">${item.id}</td>
								<td>${item.name}</td>
								<td>${fn:split(item.createTime, ' ')[0]}</td>
								<td>${item.creatorId}</td>
								<c:choose>
									<c:when test="${item.checkState == 1}">
										<td class="error">未审核</td>
									</c:when>
									<c:when test="${item.checkState == 2}">
										<td class="succ">审核通过</td>
									</c:when>
									<c:when test="${item.checkState == 3}">
										<td class="error">审核不通过</td>
									</c:when>
								</c:choose>
								<c:choose>
									<c:when test="${item.status == 1}">
										<td class="error">未开通</td>
									</c:when>
									<c:when test="${item.status == 2}">
										<td class="succ">正常</td>
									</c:when>
									<c:when test="${item.status == 3}">
										<td class="error">冻结</td>
									</c:when>
								</c:choose>
								<td><a href="<%=basePath %>sp/mmList?id=${item.id }">查看</a></td>
								<td><a href="<%=basePath %>sp/spDetail?id=${item.id }">查看详情</a>
									|<a href="<%=basePath %>spcontract/spcontractadd?id=${item.id }">
										添加合同</a>| <c:choose>
										<c:when test="${item.status == 1}">
										<a href="#" onclick="link(${item.id })"> 开通账号</a>
										</c:when>
										<c:when test="${item.status == 2}">
											<a
												href="<%=basePath %>sp/changeStatus?id=${item.id }&&status=3&&pageNo=${page.pageNo}">
												&nbsp;&nbsp;&nbsp;冻结&nbsp;&nbsp;&nbsp;</a>
										</c:when>
										<c:when test="${item.status == 3}">
											<a
												href="<%=basePath %>sp/changeStatus?id=${item.id }&&status=2&&pageNo=${page.pageNo}">
												&nbsp;&nbsp;&nbsp;解冻&nbsp;&nbsp;&nbsp;</a>
										</c:when>
									</c:choose> | <c:if test="${!item.isDel}">
										<a
											href="<%=basePath %>sp/delete?id=${item.id }&&pageNo=${page.pageNo}">删除</a>
									</c:if></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<!--内容 end-->
			<!--分页-->
			<%@ include file="/WEB-INF/view/common/page.jsp"%>
			<!--分页 end-->
		</div>
	</div>
	<!--content end-->
	<!--footer-->
	<%@ include file="/WEB-INF/view/common/footer.jsp"%>
	<!--footer end-->
	<!--弹窗 提示信息-->
	<div class="pop" id="pop-tips-link"
		style="width: 500px; margin: -200px 0px 0px -250px;">
		<a href="javascript:self.close()" class="pop-close"></a>
		<div class="pop-title">开通服务商账号</div>
		<div class="pop-cont">
			<form style="display: inline;" id="link"
				action="<%=basePath%>sp/linkAccount" method="post">
				<table width="100%" class="ui-edit-tab">
					<tbody>
						<tr>
							<th>服务商手机号：</th>
							<td><input type="text" name="phoneNum" value=""
								class="ui-input" placeholder=""> <input id="id"
								type="text" name="id" value="" class="ui-input" hidden="true">
								<input name="pageNo" value="${page.pageNo}" class="ui-input"
								hidden="true"></td>
						</tr>
					</tbody>
				</table>
			</form>
			<br />
			<div>注：如果手机号已在猪八戒网注册，将通知服务商使用猪八戒网账号密码登录；如果未在猪八戒网注册过，系统自动在猪八戒网生成账号密码并发送到服务商手机</div>
			<div class="btn-box-center">
				<input type="submit" class="btns btn-submit"
					onclick="document.getElementById('link').submit();" value="确 定">
				<input type="submit" class="btns btn-cancel" value="取 消">
			</div>
		</div>
	</div>
	<!--弹窗 提示信息 end-->
	<script type="text/javascript">
		function add() {
			getWindow('pop-tips');
		};
		function link(id) {
			$(document.getElementById("id")).val(id);
			getWindow('pop-tips-link');
		}
	</script>
</body>
</html>
