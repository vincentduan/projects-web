<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="com.efubao.core.bigc.utils.*"%>
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
					<span>店铺</span>
				</div></a>
		</div>
		<div class="div_search frt">
			<div class="search flt">
				<div class="sea_input">
					<input type="text" placeholder="输入要搜索的关键词" /><input type="button"
						value="搜索" />
				</div>

			</div>
			<div class="search2 flt">
				<img src="<%=basePath%>resources/img/img16.png" />
			</div>
		</div>
		<div class="clear"></div>
	</div>
</div>
<div class="nav2">
	<div class="wrap">
		<div class="gs_info flt">
			<div class="img flt">
				<img src="${sp.logoImagePath }" />
			</div>
			<h2>${sp.name }</h2>
			<p>已为80多家企业提供专业优质的职业装定制服务</p>
			<p class="p_star1">
				店铺综合评分：<span class="star5"></span>5.0
			</p>
		</div>
		<div class="gs_info_list frt">
			<ul>
				<c:forTokens items="${sp.serviceCategory }" delims="," var="c"
					varStatus="status">
					<c:choose>
						<c:when test="${c == 1}">
							<li><div class="img">
									<img src="<%=basePath%>resources/img/icon33.png" />
								</div> <span><%=ServiceCategoryTypeEnum.getName("1")%></span></li>
						</c:when>
						<c:when test="${c == 2}">
							<li><div class="img">
									<img src="<%=basePath%>resources/img/icon34.png" />
								</div> <span><%=ServiceCategoryTypeEnum.getName("2")%></span></li>
						</c:when>
						<c:when test="${c == 3}">
							<li><div class="img">
									<img src="<%=basePath%>resources/img/icon35.png" />
								</div> <span><%=ServiceCategoryTypeEnum.getName("3")%></span></li>
						</c:when>
					</c:choose>
				</c:forTokens>
			</ul>
		</div>
		<div class="clear"></div>
	</div>
</div>
<div class="mainer_nav">
	<div class="wrap">
		<ul>
			<li id="首页"><a href="<%=basePath%>sp/spInfo?id=${sp.id}">首 页</a></li>
			<li id="案例库"><a href="#">案例库</a></li>
			<li id="服务团队"><a href="<%=basePath%>sp/mmList?id=${sp.id}">服务团队</a></li>
			<li id="交易保障"><a href="#">交易保障</a></li>
			<li id="服务商档案"><a href="<%=basePath%>sp/spArchive?id=${sp.id}">服务商档案</a></li>
			<li class="li_last"><a href="#">免费设计与报价</a></li>
		</ul>

	</div>
</div>