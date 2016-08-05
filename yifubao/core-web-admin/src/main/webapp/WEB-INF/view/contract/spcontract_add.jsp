<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.efubao.core.admin.utils.StatusEnum" %>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/core-admin/resources/css/datedefault.css" type="text/css">
<script type="text/javascript" src="/core-admin/resources/js/jquery-1.12.0.js"></script>
<script type="text/javascript" src="/core-admin/resources/js/zebra_datepicker.js"></script>
<script type="text/javascript" src="/core-admin/resources/js/core.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<div class="col-xs-2" style="width: 100px">
             服务商名称：
</div>
<select name="" style="width: 150px;">
	<option value="-1" selected="true">情选择</option>
	<c:forEach items="${list }" var="list">
		<option value="${list.id }">${list.name }</option>
	</c:forEach>
</select>

<input id="datepicker-example1" type="text">

</body>
</html>