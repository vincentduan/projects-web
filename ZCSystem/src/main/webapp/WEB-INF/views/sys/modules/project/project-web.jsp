<%@page import="com.unisk.location.model.UniskUser"%> <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	UniskUser user = (UniskUser) session.getAttribute("user");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>沃众筹:${project.PROJECTNAME }</title>
<script src="/statics/js/jquery-easyui-1.4.2/jquery.min.js"></script>
<script src="/statics/js/backstage/unisktools.js"></script>
<link type="text/css" href="/statics/css/project.css" rel="stylesheet" />
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
					<li style="display: none;"><a href="#">搜索</a></li>
					<li style="display: none;"><a href="#">客户端</a></li>
					<li class="head_1" style="line-height: 60px; font-size: 12">Hi,
						<%=user == null ? "游客" : user.getUSERNAME()%>， 您好！
					</li>
					<%
						if (user == null) {
					%>
					<li class="head_1" style="line-height: 60px; font-size: 12"><a
						href="javascript:window.location.href='/backstage/reception/login.jsp?Referer='+window.location.href">登录</a></li>
					<%
						} else {
					%>
					<li class="head_1" style="line-height: 60px; font-size: 12"><a
						href="javascript:window.location.href='/reception/user/loginout.do?Referer='+window.location.href">登出</a></li>
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
	<div class="company-basic ">
		<div class="container">
			<div class="basic-section">
				<div class="logo_pic">
					<img src="${project.SMALLLOGO }" alt="">
				</div>

				<div class="basic-info">
					<div class="company-name">
						<h3 class="ng-binding">${project.PROJECTNAME }</h3>
					</div>
					<div class="info">${project.DESCRIPTION }</div>
					<div class="basic-link">
						<div class="address">
							<span class="icons icon-h5-location">开始时间：${project.STARTDATE }</span>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span
								class="icons icon-h5-location">结束时间：${project.ENDDATE }</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="tab-section">
			<a class="active" href="#">总览</a>
		</div>
	</div>
	<div class="content-wrap">
		<div class="container">
			<div class="content-detail">
				<div class="title">
					<h3 style="margin-left: 20px;">项目介绍</h3>

				</div>
				<div class="hr5"></div>
				<div class="intro">${project.REMARK }</div>
				<div class="hr10"></div>
				<div class="hr10"></div>
				<div class="hr10"></div>
				<div class="de_nav">
					<div class="de_nav_mg" data-id="${project.ID }">
						<a class="de_nav_l" href="javascript:void(0);"></a>
						<div class="de_nav_c">
							<div class="de_nav_loading" style="width:${step}%;"></div>
						</div>
						<a class="de_nav_r" href="javascript:void(0);"></a>
					</div>
				</div>
				<div class="hr10"></div>
				<div class="hr10"></div>
				<div class="hr10"></div>
			</div>

			<div class="content-guide">
				<div class="invest-guide">
					<div class="guide">
						<div class="title">
							<h3>${project.STATUS==0||project.STATUS==1?"众筹中 ":"已完成"}</h3>

						</div>
						<div class="guide-info guide-round">
							<div class="round">
								<span class="guide-num">${project.PROJECTNAME } </span>
								<div class="hr10"></div>
								<span class="guide-num" style="color: #CCC">${project.STATUS == 0 ? "需求阶段" : project.STATUS == 1 ? "开发阶段" : "已完成" }</span>
							</div>
							<div class="round" style="display: none">
								<span class="guide-goa"> 众筹轮次 </span> <span class="guide-goa">
									目标金额 </span>
							</div>
						</div>
						<div class="loading-shade">
							<div style="width: 50%;" class="loading-bar"></div>
						</div>
						<c:forEach items="${companies }" var="company">
							<div class="progress-20">
								<span class="syndicates-option">${company.CNAME }</span> <span
									class="syndicates-val">已领取</span>
							</div>
						</c:forEach>

						<!-- <div class="progress-20">
						<span class="syndicates-val"><a href="#">更多></a></span>

					</div> -->
					</div>
					<div class="syndicates-line"></div>
					<div class="syndicates-btn-layer">
						<a href="/reception/project/to/${project.ID }.do"
							class="invest-btn btn">我要领取</a>
						<!-- <a href="#" class="cmt-btn">约谈徐总</a> -->
					</div>
					<div class="hr5"></div>

				</div>

			</div>

			
			<c:if test="${isShow }">
				<div class="hr10"></div>
				<div class="hr10"></div>
				<div class="hr10"></div>
				
				<div class="content-detail">
					<div class="title">
						<h3 style="margin-left: 20px;">子项目</h3>
					</div>
					<div class="hr5"></div>
					<c:forEach items="${subProjects }" var="subPorject">
						<div class="intro" style="border-bottom: 1px solid #A1A1A1; padding-bottom: 15px;">
							<h2>
								<span>${subPorject.PROVINCE }</span> <span>${subPorject.PROJECTNAME }</span>
							</h2>
							<div class="desc">
								<span>更新时间：<fmt:formatDate pattern="yyyy年M月d日 " value="${subPorject.VALIDDATE }"/></span>
								<div class="bg_sup" data-id='${subPorject.ID }'>${subPorject.AGREE== null ? '0' : subPorject.AGREE }赞</div>
							</div>
							<p>${subPorject.DESCRIPTION }</p>
						</div>
					
					</c:forEach>
	
					<!-- <div class="intro">
						<h2>
							<span>省份</span> <span>中国联通山东分公司</span> <span>ass2.0</span>
						</h2>
						<div class="desc">
							<span>更新时间：2015年8月18日</span>
							<div class="bg_nosup">228赞</div>
						</div>
						<p>监管部门是否暂停了分级基金的审批工作？已经获批的分级基金发行工作是否也面临暂停？分级基金指引政策进展情况如何，监管部门是否暂停了分级基金的审批工作？已经获批的分级基金发行工作是否也面临暂停？分级基金指引政策进展情况如。</p>
					</div> -->
				</div>
			</c:if>
			
		</div>

		<div class="hr10"></div>
		<div class="hr10"></div>
		<div class="hr10"></div>
</body>

<script>
	;
	(function($) {
		$('.de_nav_l').on('click', function() {
			var id = $(this).parent().attr('data-id');
			agreeAndAgainst(id, 'AGREE');
		})
		$('.de_nav_r').on('click', function() {
			var id = $(this).parent().attr('data-id');
			agreeAndAgainst(id, 'AGAINST');
		})
		$('.bg_sup').on('click', function() {
			var id = $(this).attr('data-id');
			agreeAndAgainst(id, 'AGREE');
		})
		function agreeAndAgainst(id, flag) {
			sendRequestPost(
					'/reception/project/agreeAndAgainst.do',
					{
						'ID' : id,
						'flag' : flag
					},
					function(data) {
						if (data.status == 1 && !data.data.login) {
							window.location.href = "/backstage/reception/login.jsp?Referer="
									+ window.location.href;
						} else if (data.status == 1
								&& data.data.agreeAndAgainstFlag) {
							alert(data.desc);
						}if (data.status == 0) {
							window.location.href =  window.location.href + '#' + Math.random();
						}
					}, new Function());
		}
	})($);
</script>
</html>
