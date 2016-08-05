<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商品管理>>属性列表</title>
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
			<li><a href="<%=basePath%>category/categoryList">商品分类列表</a></li>
			<li class="hover"><a href="#">属性列表</a></li>
		</ul>
	</div></div>
	<!--content-->
	<div class="cont">
		<div class="w">
			<div class="cf">
				<a href="#" class="l add-export" onclick="add()"><i
					class="ui-icon"></i>添加属性</a>

				<ul class="r mode-filter">
					<li><form action="<%=basePath %>property/search" method="post">
							<input type="text" name="name" class="text-input" value=""
								placeholder="属性名称"> <select name="status"
								style="width: 150px;">
								<option value="-1" selected="true">状态</option>
								<option value="1">正常</option>
								<option value="2">停用</option>
							</select> <input type="submit" value="搜索" tabindex="12" class="export">
						</form></li>
				</ul>
			</div>
			<!--内容-->
			<div class="view-list">
				<table width="100%" class="ui-tab">
					<tbody>
						<tr>
							<th>属性ID</th>
							<th>属性名称</th>
							<th>是否销售属性</th>
							<th>排序</th>
							<th>状态</th>
							<th width="200">操作</th>
						</tr>
						<c:forEach items="${requestScope.items}" var="item">
							<tr>
								<td class="noline">${item.id}</td>
								<td>${item.name}</td>
								<c:choose>
									<c:when test="${item.isSale}">
										<td class="succ">是</td>
									</c:when>
									<c:otherwise>
										<td class="error">否</td>
									</c:otherwise>
								</c:choose>
								<td>${item.sort}</td>
								<c:choose>
									<c:when test="${item.status==1}">
										<td class="succ">正常</td>
									</c:when>
									<c:when test="${item.status==2}">
										<td class="error">停用</td>
									</c:when>
								</c:choose>
								<td><a
									href="<%=basePath %>property/propertyValueList?id=${item.id }">属性值设定</a>
									| <c:choose>
										<c:when test="${item.status==1}">
											<a
												href="<%=basePath %>property/changeStatus?id=${item.id }&&status=2">
												停用</a>
										</c:when>
										<c:when test="${item.status==2}">
											<a
												href="<%=basePath %>property/changeStatus?id=${item.id }&&status=1">
												启用</a>
										</c:when>
									</c:choose> | <c:if test="${!item.isDel}">
										<a href="<%=basePath %>property/delete?id=${item.id }">删除</a>
									</c:if></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<!--内容 end-->
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
		<div class="pop-title">添加属性</div>
		<div class="pop-cont">
			<form style="display: inline;" id="add"
				action="<%=basePath %>property/addProperty" method="post">
				<table width="100%" class="ui-edit-tab">
					<tbody>
						<tr>
							<th>属性名称：</th>
							<td><input type="text" name="name" value="" class="ui-input"
								placeholder=""></td>
						</tr>
						<tr>
							<th>是否销售属性：</th>
							<td><input name="isSale" type="radio" value="1" checked>是&nbsp;&nbsp;&nbsp;
								<input name="isSale" type="radio" value="0">&nbsp;&nbsp;&nbsp;否</td>
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
					<input type="submit" class="btns btn-submit" onclick="document.getElementById('add').submit();" value="确 定"> <input
						type="submit" class="btns btn-cancel" value="取 消">
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
