<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<div class="page">
	<c:choose>
		<c:when test="${page.pageNo == 1}">
			<span><a href="javascript:void(0)">首页</a></span>
			<span><a href="javascript:void(0)">上一页</a></span>
		</c:when>
		<c:otherwise>
			<a href="<%=basePath %>${url}pageNo=1">首页</a>
			<a href="<%=basePath %>${url}pageNo=${page.pageNo-1}">上一页</a>
		</c:otherwise>
	</c:choose>
	<c:if test="${page.pageNo>4}">
		<a href="<%=basePath %>${url}pageNo=1">1</a>
	</c:if>
	<c:if test="${page.pageNo==6}">
		<a href="<%=basePath %>${url}pageNo=2">2</a>
	</c:if>
	<c:if test="${page.pageNo>6}">
		<span><a href="javascript:void(0)">...</a></span>
	</c:if>
		
		<c:forEach var="s"
			begin="${(page.pageNo-3)>1?(page.pageNo-3):1}"
			end="${(page.pageNo+3) > page.totalPages ? page.totalPages:(page.pageNo+3)}">
			<c:choose>
				<c:when test="${s==page.pageNo}">
					<a href="javascript:void(0)" class="on"> ${page.pageNo} </a>
				</c:when>
				<c:otherwise>
					<a href="<%=basePath %>${url}pageNo=${s}"> ${s} </a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	<c:if test="${page.pageNo<(page.totalPages-5)}">
		<span><a href="javascript:void(0)">...</a></span>
	</c:if>
	<c:if test="${page.pageNo==(page.totalPages-5)}">
		<a href="<%=basePath %>${url}pageNo=${page.totalPages-1 }">${page.totalPages-1 }</a>
	</c:if>
	<c:if test="${page.pageNo<(page.totalPages-3)}">
		<a href="<%=basePath %>${url}pageNo=${page.totalPages}">${page.totalPages}</a>
	</c:if>
	<c:choose>
		<c:when test="${page.pageNo == page.totalPages}">
			<span><a href="javascript:void(0)">下一页</a></span>
			<span><a href="javascript:void(0)">末页</a></span>
		</c:when>
		<c:otherwise>
			<a href="<%=basePath %>${url}pageNo=${page.pageNo+1}">下一页</a>
			<a href="<%=basePath %>${url}pageNo=${page.totalPages}">末页</a>
		</c:otherwise>
	</c:choose>
		<span>共<label>${page.totalPages }</label>页<label>${page.totalCount}</label>条</span>
	
</div>