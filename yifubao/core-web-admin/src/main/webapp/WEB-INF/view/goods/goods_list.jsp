<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="com.efubao.core.admin.utils.StatusEnum"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商品管理>>商品列表</title>
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
	<!--header-->
	<%@ include file="/WEB-INF/view/common/header.jsp"%>
	<div class="w">
		<ul class="nav-subul">
			<li class="hover"><a href="#">商品列表</a></li>
			<li><a href="<%=basePath%>category/categoryList">商品分类列表</a></li>
			<li><a href="<%=basePath%>property/propertyList">属性列表</a></li>
		</ul>
	</div>
	</div>
	<!--content-->
	<div class="cont">
		<div class="w">
			<div class="cf">
				<a href="<%=basePath%>goods/toAdd" class="l add-export"><i
					class="ui-icon"></i>添加商品</a>

				<ul class="r mode-filter">
					<li><form action="<%=basePath%>goods/goodsList" method="post">
							<input type="text" name="name" class="text-input"
								placeholder="商品名称"> <select style="width: 150px;"
								name="categoryId">
								<option value="" selected="selected">商品分类</option>
								<c:forEach items="${categorys }" var="category">
									<option value="${category.id }">${category.name }</option>
								</c:forEach>
							</select> <select name="status" style="width: 150px;">
								<option value="" selected="selected">请选择状态</option>
								<option value="1">正常</option>
								<option value="2">停用</option>
							</select> <input type="submit" value="搜索" tabindex="12" class="export">
						</form></li>
				</ul>
			</div>
			<!--内容-->
			<div class="view-list">
				<table style="width: 100%" class="ui-tab">
					<tbody>
						<tr>
							<th>商品ID</th>
							<th>商品名称</th>
							<th>商品分类</th>
							<th>排序</th>
							<th>状态</th>
							<th width="200">操作</th>
						</tr>
						<c:forEach items="${items }" var="item">
							<tr>
								<td class="noline">${item.id }</td>
								<td>${item.name }</td>

								<c:forEach items="${categorys }" var="category">
									<c:if test="${category.id == item.categoryId}">
										<td>${category.name }</td>
									</c:if>
								</c:forEach>
								<td>${item.sort }</td>
								<c:choose>
									<c:when test="${item.status == 1}">
										<td class="succ"><%=StatusEnum.getName("1")%></td>
									</c:when>
									<c:when test="${item.status == 2}">
										<td class="error"><%=StatusEnum.getName("2")%></td>
									</c:when>
								</c:choose>
								<td><a
									href="<%=basePath %>goods/goodsDetail?id=${item.id }">查看详情</a>|
									<c:choose>
										<c:when test="${item.status == 1}">
											<a
												href="<%=basePath %>goods/changeStatus?${fn:split(url,'?')[1]}id=${item.id }&toStatus=2&pageNo=${page.pageNo}">
												停用</a>
										</c:when>
										<c:when test="${item.status==2}">
											<a
												href="<%=basePath %>goods/changeStatus?${fn:split(url,'?')[1]}id=${item.id }&toStatus=1&pageNo=${page.pageNo}">启用</a>
										</c:when>
									</c:choose> |<a href="<%=basePath%>goods/goodsDel?${fn:split(url,'?')[1]}id=${item.id }&pageNo=${page.pageNo}">删除</a></td>
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
</body>
</html>
