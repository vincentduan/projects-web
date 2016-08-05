<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商品管理>>商品分类列表</title>
<script type="text/javascript">
	window.onload = function() {
		document.getElementById('商品管理').className = "hover";
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
			<li><a href="<%=basePath%>goods/goodsList">商品列表</a></li>
			<li class="hover"><a href="#">商品分类列表</a></li>
			<li><a href="<%=basePath%>property/propertyList">属性列表</a></li>
		</ul>
	</div></div>
	<!--content-->
	<div class="cont">
		<div class="w">
			<div class="w">
				<div class="cf">
					<a href="#" class="l add-export" onclick="add()"><i
						class="ui-icon"></i>添加分类</a>

					<ul class="r mode-filter">
						<li><form action="<%=basePath%>category/search" method="post">
								<input type="text" name="name" class="text-input" value=""
									placeholder="分类名称"> <select name="status"
									style="width: 150px;">
									<option value="-1" selected="true">状态</option>
									<option value="1">正常</option>
									<option value="2">停用</option>
								</select> <input value="${requestScope.parentId}" name="parentId"
									hidden="true"> <input type="submit" value="搜索"
									tabindex="12" class="export">
							</form></li>
					</ul>
					<ul class="r mode-filter">
						<li><a
							href="<%=basePath%>category/categoryList?parentId=${requestScope.parentPId}"><input
								type="button" value="返回上级分类" tabindex="12" class="export"></a></li>
					</ul>
				</div>

				<!--内容-->
				<div class="view-list">
					<table width="100%" class="ui-tab">
						<tbody>
							<tr>
								<th>分类ID</th>
								<th>分类名称</th>
								<th>排序</th>
								<th>状态</th>
								<th width="200">操作</th>
							</tr>
							<c:forEach items="${requestScope.items}" var="item">
								<tr>
									<td class="noline">${item.id}</td>
									<td><a
										href="<%=basePath %>category/categoryList?parentId=${item.id }">${item.name}</a>
									</td>
									<td>${item.sort}</td>
									<c:choose>
										<c:when test="${item.status==1}">
											<td class="succ">正常</td>
										</c:when>
										<c:when test="${item.status==2}">
											<td class="error">停用</td>
										</c:when>
									</c:choose>
									<td><c:choose>
											<c:when test="${item.status==1}">
												<a
													href="<%=basePath %>category/changeStatus?id=${item.id }&&parentId=${item.parentId}&&status=2">
													停用</a>
											</c:when>
											<c:when test="${item.status==2}">
												<a
													href="<%=basePath %>category/changeStatus?id=${item.id }&&parentId=${item.parentId}&&status=1">启用</a>
											</c:when>
										</c:choose> |<c:if test="${!item.isDel}">
											<a
												href="<%=basePath %>category/delete?id=${item.id }&&parentId=${item.parentId}">删除</a>
										</c:if></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<!--内容 end-->
			</div>
		</div>
	</div>
	<!--content end-->
	<!--footer-->
	<div class="foot">
		<div class="w">
			<p class="copyright">©&nbsp;&nbsp;2014&nbsp;&nbsp;北京拉手网络技术有限公司&nbsp;&nbsp;LaShou.com&nbsp;&nbsp;京ICP证100571号&nbsp;&nbsp;京ICP备11004895号&nbsp;&nbsp;京公网安备110105001181号</p>
		</div>
	</div>
	<!--footer end-->
	<!--弹窗 提示信息-->
	<div class="pop" id="pop-tips"
		style="width: 500px; margin: -200px 0px 0px -250px;">
		<a href="javascript:self.close()" class="pop-close"></a>
		<div class="pop-title">添加分类</div>
		<div class="pop-cont">
			<form style="display: inline;" id="add"
				action="<%=basePath %>category/addCategory" method="post">
				<table width="100%" class="ui-edit-tab">
					<tbody>
						<tr>
							<th>分类名称：</th>
							<td><input type="text" name="name" value="" class="ui-input"
								placeholder=""><input value="${requestScope.parentId}"
								name="parentId" hidden="true"></td>
						</tr>
						<tr>
							<th>排序：</th>
							<td><input type="text" name="sort" value="" class="ui-input"
								placeholder=""></td>
						</tr>
					</tbody>
				</table>
			</form>
			<div class="btn-box-center">
				<input type="submit" class="btns btn-submit"
					onclick="document.getElementById('add').submit();" value="确 定">
				<input type="submit" class="btns btn-cancel" value="取 消">
			</div>
		</div>
	</div>
	<!--弹窗 提示信息 end-->
	<script type="text/javascript">
		function add() {
			getWindow('pop-tips');
		}
	</script>
</body>
</html>
