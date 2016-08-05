<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
 <div class="fixed">
        <div class="img"><a href="#"><img src="<%=basePath%>resources/img/img_fix.png" /></a></div>
    </div>
