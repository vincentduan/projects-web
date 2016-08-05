<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<link href="<%=basePath%>resources/css/common.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>resources/css/goodsStyle.css" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet" href="<%=basePath%>resources/css/datedefault.css" />
<script src="<%=basePath%>resources/js/jquery-1.12.0.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="<%=basePath%>resources/js/zebra_datepicker.js"></script>
<script type="text/javascript" src="<%=basePath%>resources/js/core.js"></script>
<script src="<%=basePath%>resources/js/base_v1.js"
	type="text/javascript"></script>
<script src="<%=basePath%>resources/js/jquery-migrate-1.2.1.min.js"></script>

<!--3-14 start -->
<link href="<%=basePath%>resources/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="<%=basePath%>resources/css/backStyle.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>resources/css/style1.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>resources/css/owl.carousel.min.css">

<script type="text/javascript" src="<%=basePath%>resources/js/jquery.min.js"></script>
<script src="<%=basePath%>resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath%>resources/js/main.js"></script>
<script type="text/javascript" src="<%=basePath%>resources/js/owl.carousel.js"></script>
<!--[if lt IE 9]>
        <script type="text/javascript" src="<%=basePath%>resources/js/html5.js"></script>
        <![endif]-->
<!--[if IE 6]>
<SCRIPT src="http://d1.lashouimg.com/static/js/release/iepng.js"></SCRIPT>
<script type="text/javascript">
  DD_belatedPNG.fix('.iepng');
</script>
<![endif]-->
<!--end-->

<header class="head">
	<div class="head-site">
		<div class="w cf">
			<ul class="hdsite-ul">
				<li class="user">欢迎您管理员：<a href="#">管理员</a></li>
				<li class="magnt"><a href="#"><i></i>账号管理</a></li>
				<li class="quit"><a href="#"><i></i>退出</a></li>
			</ul>
		</div>
	</div>
	<div class="head-main">
		<div class="w cf">
			<div class="logo">
				<div style="margin-left:100px"><a href="#">运营管理系统</a></div>
				
			</div>
			<div class="name"></div>
		</div>
	</div>
</header>
<!--header end-->
<!--nav-->
<div class="nav">
	<div class="nav-main">
		<div class="w">
			<div class="nav-dl">
				<dl class="noline">
					<dt id="商户管理">
						<a href="<%=basePath%>sp/spList">商户管理</a>
					</dt>
					<dd class="nav-down">
						<i></i>
						<ul>
							<li><a href="<%=basePath%>sp/spList">服务商管理</a></li>
							<li><a href="<%=basePath%>spcontract/spcontractList">合同列表</a></li>
						</ul>
					</dd>
				</dl>
				<dl>
					<dt id="订单管理">
						<a href="#">订单管理</a>
					</dt>
					<dd class="nav-down">
						<i></i>
						<ul>
							<li><a href="#">订单列表</a></li>
						</ul>
					</dd>
				</dl>
				<dl>
					<dt id="商品管理">
						<a href="<%=basePath%>goods/goodsList">商品管理</a>
					</dt>
					<dd class="nav-down">
						<i></i>
						<ul>
							<li><a href="<%=basePath%>goods/goodsList">商品列表</a></li>
							<li><a href="<%=basePath%>category/categoryList">商品分类列表</a></li>
							<li><a href="<%=basePath%>property/propertyList">属性列表</a></li>
						</ul>
					</dd>
				</dl>
				<dl>
					<dt id="用户管理">
						<a href="#">用户管理</a>
					</dt>
					<dd class="nav-down">
						<i></i>
						<ul>
							<li><a href="#">用户列表</a></li>
						</ul>
					</dd>
				</dl>
				<dl>
					<dt id="财务管理">
						<a href="#">财务管理</a>
					</dt>
					<dd class="nav-down">
						<i></i>
						<ul>
							<li><a href="#">结算管理</a></li>
							<li><a href="#">财务明细</a></li>
							<li><a href="#">账户管理</a></li>
						</ul>
					</dd>
				</dl>
				<dl>
					<dt id="系统管理">
						<a href="#">系统管理</a>
					</dt>
					<dd class="nav-down">
						<i></i>
						<ul>
							<li><a href="#">案例管理</a></li>
							<li><a href="#">消息管理</a></li>
							<li><a href="#">权限管理</a></li>
							<li><a href="#">字典管理</a></li>
						</ul>
					</dd>
				</dl>
			</div>
		</div>
	</div>