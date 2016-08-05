<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" import="com.unisk.location.model.UniskUser"%>
<!doctype html>
<html class="no-js" lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>沃众筹</title>
<link type="text/css" href="/statics/modules/web/plist.css" rel="stylesheet" />
</head>
<body>
	<div class="head">
		<div class="container">
			<a href="http://www.10010.com" class="logo"> <img
				src="/statics/imgs/unicomlogo.png" alt="中国联通logo" />
			</a>

			<div class="nav">
				<ul style="display: none;">
					<li><a href="#">咨询</a></li>
					<li><a href="#">众筹</a></li>
					<li><a href="#">融资</a></li>
					<li class="active"><a href="#">创业公司</a></li>
					<li><a href="#">投资人</a></li>
				</ul>
			</div>
			<div class="navsub">
				<ul>
					<li  style="display: none;"><a href="#">搜索</a></li>
					<li  style="display: none;"><a href="#">客户端</a></li>
					<li class="head_1" style="line-height:60px; font-size: 12">Hi,<%=user==null ? "游客" : user.getUSERNAME() %>，您好！</li>
					<%
						if( user == null ){
					%>
					<li class="head_1" style="line-height:60px; font-size: 12"><a href="javascript:window.location.href='/backstage/reception/login.jsp?Referer='+window.location.href">登录</a></li>
					<%
						}else{
					%>				
					<li class="head_1" style="line-height:60px; font-size: 12"><a href="javascript:window.location.href='/reception/user/loginout.do?Referer='+window.location.href">登出</a></li>
					<%
						}
					%>
				</ul>
			</div>
		</div>
	</div>
	<div class="hr10"></div>
	<div class="hr10"></div>
	<div class="hr10"></div>
	<div class="hr10"></div>
	<div class="hr10"></div>
	<div class="hr10"></div>
	
	<c:forEach items="${plist }" var="pro">
	
		<div class="hr10"></div>
		<div class="hr10"></div>
		<div class="hr10"></div>
		<div class="container">
			<div class="cat-part01">
				<div class="syndicates-left"><img src="${pro.COVERLOGO }" width="840px" height="100%"></div>
				<div class="syndicates-status">${pro.STATUS==0||pro.STATUS==1?"众筹中 ":"已完成"}</div>
				<div class="syndicates-right">
				
					<div class="investor-led-title">
						<!-- <span class="led-logo"></span> -->
						<span></span>
						<strong class="led-name" title="项目简述">项目简述</strong>
						<!-- <span>领投</span> -->
					</div>
					<div class="investor-detail">
						<a href="/reception/project/${pro.ID }.do" class="syndicates-logo"><img  width="60px" height="60px" src="${pro.SMALLLOGO }"></a>
						<a href="/reception/project/${pro.ID }.do">
	                    <strong class="c-black">${pro.PROJECTNAME }</strong>
	                </a>
					<div class="brief">${pro.DESCRIPTION }</div>
					<div class="syndicates-detail">
						<div class="syndicates-attr">
							<p class="mb-5">开始时间</p>
							<p class="mb-5">结束时间</p>
						</div>
						<div class="syndicates-intro">
							<p class="mb-5">${pro.STARTDATE }</p>
							<p class="mb-5">${pro.ENDDATE }</p>
						</div>
					</div>
					<div class="loading-shade">
							<div style="width: 30%;" class="loading-bar"></div>
					</div>
					<div class="goal" style="">
						<span class="goal-text"></span>
						<span class="goal-umb"></span>
					</div>
					<a href="/reception/project/${pro.ID }.do" class="view-detail">查看详情</a>
					</div>
					
				</div>
			</div>
		</div>
	
	</c:forEach>
	
	<div class="hr10"></div>
	<div class="hr10"></div>
	<div class="hr10"></div>
	<!-- <div class="hr10"></div>
	<div class="hr10"></div>
	<div class="hr10"></div>
	<div class="container">
		<div class="cat-part01">
			<div class="syndicates-left syndicates-bg"></div>
			<div class="syndicates-status-01"> 7月31日  10:00  开始众筹</div>
			<div class="syndicates-right">
			
				<div class="investor-led-title">
					<span class="led-logo"></span>
					<strong class="led-name" title="亚杰基金">亚杰基金</strong>
					<span>领投</span>
				</div>
				<div class="investor-detail">
					<a href="#" class="syndicates-logo"></a>
					<a href="#">
                    <strong class="c-black">魔镜在线</strong>
                </a>
				<div class="brief">魔镜在线-你的私人购物助理</div>
				<div class="syndicates-detail">
					<div class="syndicates-attr">
						<p class="mb-5">创始人</p>
						<p class="mb-5">团队成员</p>
					</div>
					<div class="syndicates-intro">
						<p class="mb-5">知名电商企业高管</p>
						<p class="mb-5">超千人的团队管理经验</p>
					</div>
				</div>
				<div class="loading-shade">
						<div style="width: 58.5%;" class="loading-bar"></div>
				</div>
				<div class="goal">
					<span class="goal-text">众筹目标</span>
					<span class="goal-umb"> ￥300万</span>
				</div>
				<a href="#" class="view-detail">查看详情</a>
				</div>
				
			</div>
		</div>
	</div> -->
	
</body>
</html>
