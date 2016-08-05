<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<!--[if lt IE 9]>
        <script type="text/javascript" src="<%=basePath%>resources/js/html5.js"></script>
        <![endif]-->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title></title>
    <script type="text/javascript" src="<%=basePath%>resources/js/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>resources/css/style.css">
    <script type="text/javascript" src="<%=basePath%>resources/js/main.js"></script>
    <!--plugin-->
    <link rel="stylesheet" type="text/css" href="<%=basePath%>resources/css/owl.carousel.min.css">
    <script type="text/javascript" src="<%=basePath%>resources/js/owl.carousel.js"></script>
<script type="text/javascript">
		window.onload = function() {
			document.getElementById("cid_${parentCategorys[0].id}" ).className = "on";
		}
	</script>
</head>
<body>
	<!-------------------------------------- 头部开始 -------------------------------------->
	<jsp:include page="/WEB-INF/view/common/goods_header.jsp"></jsp:include>
	<!-------------------------------------- 头部结束 -------------------------------------->
	<!-------------------------------------- 内容开始 -------------------------------------->
	<div class="mainer">
		<div class="wrap">
			<!-------------------------------------- 左上类目栏 ----------------------------->
			<div class="div_pos">
				<span>
					<c:forEach items="${parentCategorys}" var="item" varStatus="st">
						<c:choose>
							<c:when test="${st.last }">
								<a href="#" class="a_tit">${item.name}</a>
							</c:when>
							<c:otherwise>
								<a href="<%=basePath%>goods/goodsList?categoryId=${item.id}" class="a_tit">${item.name}</a>
								<label>></label>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</span>
				<div class="clear"></div>
			</div>
			<!-------------------------------------- 左侧类目栏 ----------------------------->
			<div class="left_side flt">
				<ul>
					<c:forEach items="${categorys}" var="item">
						<c:if test="${item.parentId == 0}">
							<li><span class="span_tit"><a
									href="<%=basePath%>goods/goodsList?categoryId=${item.id}">${item.name}</a></span></li>
							<c:forEach items="${categorys}" var="subitem">
								<c:if test="${subitem.parentId == item.id}">
									<p><a href="<%=basePath%>goods/goodsList?categoryId=${subitem.id}">${subitem.name}</a></p>
								</c:if>
							</c:forEach>
						</c:if>
					</c:forEach>
				</ul>
			</div>
			<!-------------------------------------- 商品详情栏 ----------------------------->
			<div class="pro_list_page">
				<c:choose>
					<c:when test="${fn:length(items) > 0}">
						<ul>
							<c:forEach items="${items}" var="item">
								<li>
									<div class="list">
										<div class="img">
											<a href="<%=basePath%>goods/goodsDetail?goodsId=${item.id}">
											<img src="${item.firstImagePath }"></a>
										</div>
										<div class="text">
											<a href="<%=basePath%>goods/goodsDetail?goodsId=${item.id}">${item.name}</a> <span><label>￥
													${item.minPrice }</label> 元起 <a href="<%=basePath%>goods/goodsDetail?goodsId=${item.id}">我要定制</a></span>
										</div>
									</div>
								</li>
							</c:forEach>
						</ul>
						<!--分页-->
						<div class="page_size">
						<jsp:include page="/WEB-INF/view/common/page.jsp"></jsp:include>
						</div>
						<!--分页 end-->
					</c:when>
					<c:otherwise>
					<p style="width:100%;text-align:center;font-size: 20px">
						<br /><br /><br />商品维护中...请查看其它商品吧！</p>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<!-------------------------------------- 内容结束 -------------------------------------->
	<!-------------------------------------- 尾部开始 -------------------------------------->
	<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
	<!-------------------------------------- 尾部结束 -------------------------------------->
	<jsp:include page="/WEB-INF/view/common/float.jsp"></jsp:include>
</body>
</html>