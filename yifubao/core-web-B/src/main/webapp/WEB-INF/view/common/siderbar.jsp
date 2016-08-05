<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<div class="daohang">
	<p class="daohang_1">交易管理</p>
	<p class="daohang_2">
		<a href="#">订单管理</a>
	</p>


	<p class="daohang_1 padd">基础管理</p>
	<p id="服务商信息" class="daohang_2">
		<a href="<%=basePath%>sp/spinfo">服务商信息</a>
	</p>
	<p id="案例管理" class="daohang_2">
		<a href="<%=basePath%>case/caseinfo">案例管理</a>
	</p>
	<p id="量体师管理" class="daohang_2">
		<a href="<%=basePath%>mm/mmlist">量体师管理</a>
	</p>

	<p class="daohang_1 padd">账号设置</p>
	<p class="daohang_2">
		<a href="#">修改登录密码</a>
	</p>
	<p class="daohang_2">
		<a href="#">修改手机号码</a>
	</p>
	<p class="daohang_2">
		<a href="#">身份认证</a>
	</p>
	<p class="daohang_2">
		<a href="#">支付账户管理</a>
	</p>

	<p class="daohang_1 padd">财务管理</p>
	<p class="daohang_2">
		<a href="#">收支明细</a>
	</p>

	<p class="daohang_1 padd">消息中心</p>
	<p class="daohang_2">
		<a href="#">全部消息</a>
	</p>
</div>