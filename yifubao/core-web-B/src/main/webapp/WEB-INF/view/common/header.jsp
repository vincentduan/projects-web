<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<div class="head">
	<div class="wrap">
		<span class="flt"><a href="#">依文集团</a> & <a href="#">猪八戒网</a> <a
			href="#">旗下职业装定制平台</a></span>
		<div class="title_j">
			<ul>
				<li><a href="#"><img
						src="<%=basePath%>resources/img/xiaoxi.png" />消息</a></li>
				<li><a href="#">我的定制</a></li>
				<li><a href="#">186****2313</a><label><img
						src="<%=basePath%>resources/img/sanjiao.png" /></label></li>
			</ul>
		</div>
		<div class="clear"></div>
	</div>
</div>
<div class="input_j">
	<div class="wrap">
		<div class="logo_c">
			<img src="<%=basePath%>resources/img/logo3.png" />
		</div>
		<div class="text_j text_a">
			<p>
				<a href="#">服务商管理中心</a>
			</p>

		</div>
		<div class="input_a">
			<input type="text" placeholder="输入要搜索的关键词" /><a href="#"><span>搜索</span></a>
		</div>
	</div>
	<div class="clear"></div>
</div>