<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="/WEB-INF/view/common/head.jsp"></jsp:include>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<div class="header">
	<div class="wrap">
		<div class="logo flt">
			<a href="#"><img src="<%=basePath%>resources/img/logo.png"
				class="flt" />
				<div class="logo_text flt">
					<img src="<%=basePath%>resources/img/logo_text.png" />
				</div></a>
		</div>
		<div class="div_search frt">
			<div class="search flt">
				<div class="sea_input">
					<form id="goods_search" action="<%=basePath%>goods/goodsSearch"
						method="post">
						<input type="text" name="name" placeholder="输入要搜索的关键词" /> <input
							type="button" value="搜索" onclick="$('#goods_search').submit()" />
					</form>
				</div>
			</div>
			<div class="search2 flt">
				<img src="<%=basePath%>resources/img/img16.png" />
			</div>
		</div>
		<div class="clear"></div>
	</div>
</div>
<div class="nav">
	<div class="wrap">
		<ul>
			<li><a id="index" href="<%=basePath%>">首 页</a></li>
			<c:forEach items="${categorys}" var="item">
				<c:if test="${item.parentId == 0}">
					<li><a id="cid_${item.id}"
						href="<%=basePath%>goods/goodsList?categoryId=${item.id}">${item.name}</a></li>
				</c:if>
			</c:forEach>
			<li><a href="#">服务保障</a></li>
			<li><a href="#">案例展示</a></li>
		</ul>
	</div>
</div>
