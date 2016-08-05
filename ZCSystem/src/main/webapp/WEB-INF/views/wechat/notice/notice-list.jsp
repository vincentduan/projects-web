<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>

	 <c:if test="${not empty page.data }">
		<c:forEach var="item" items="${page.data }">
			<!--缩略图在标题左边-->
			<li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left">
				<div class="am-u-sm-4 am-list-thumb">
					<a href="${item.url }" class=""> <img
						src="${item.picUrl }"
						alt="${item.title }" />
					</a>
				</div>

				<div class=" am-u-sm-8 am-list-main">
					<h3 class="am-list-item-hd">
						<a href="${item.url }" class="">${item.title }</a>
					</h3>
					<div class="am-list-item-text">${item.content }</div>
				</div>
			</li>
		</c:forEach>
	</c:if>
