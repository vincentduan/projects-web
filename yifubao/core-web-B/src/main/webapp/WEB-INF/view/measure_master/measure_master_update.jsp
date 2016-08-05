<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="com.efubao.core.sp.utils.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<!--[if lt IE 9]>
       <script type="text/javascript" src="js/html5.js"></script>
       <![endif]-->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title></title>
<script type="text/javascript" src="<%=basePath%>resources/js/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath%>resources/css/style.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>resources/css/style_fw.css">
<script type="text/javascript" src="<%=basePath%>resources/js/main.js"></script>
<!--plugin-->
<link rel="stylesheet" type="text/css" href="<%=basePath%>resources/css/owl.carousel.min.css">
<script type="text/javascript" src="<%=basePath%>resources/js/owl.carousel.js"></script>
<script>
	window.onload = function() {
		$("#量体师管理" ).addClass("on");
	}
</script>
</head>
<body>
	<!-------------------------------------- 头部开始 -------------------------------------->
	<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>
	<!-------------------------------------- 头部结束 -------------------------------------->
	<!-------------------------------------- 内容开始 -------------------------------------->
	<div class="mainer ">
    	<div class="shent_j">
        <div class="wrap">
        	 <jsp:include page="/WEB-INF/view/common/siderbar.jsp"></jsp:include>
				<div class="facilitator">
					<div class="fa_content">
						<p class="con_title">更新量体师信息</p>
						<div class="lr_taggle">
							<div class="togg_cont">
		       					<div class="taggle taggle_lt">
			                        <div class="add_measure">
			                        <form:form id="update_mm" modelAttribute="measureMaster" action="updatemm" method="post">
			                        	<form:hidden path="id"/>
			                        	<p><span class="hongxin">量体师名称：</span><form:input path="name"/></p>
		                             	<p><span class="hongxin">手机号码：</span><form:input path="mobile"/><i>（量体师手机号码，用于登陆量体师APP）</i></p>
		                             	<p><span class="hongxin">专业评级：</span><form:select path="specialtyEvaluation">
		                              	<form:option value="1.0">1级</form:option>
										<form:option value="2.0">2级</form:option>
										<form:option value="3.0">3级</form:option>
										<form:option value="4.0">4级</form:option>
										<form:option value="5.0">5级</form:option>
			                            </form:select></p>
			                            <p class="line_none"><span class="hongxin">量体经验：</span><form:textarea path="measureExperience"></form:textarea></p>
			                            <p class="line_none line_none2"><span class="hongxin">个人介绍：</span><form:textarea path="introduction"></form:textarea></p>
			                            <%-- <p class="line_none line_none2"><span>客户评价：</span><form:textarea path="customerEvaluation"></form:textarea></p> --%>
			                            <p class="but_mea"><span> </span><label class="color_1"><a href="#" onclick="$('#update_mm').submit()">提交</a></label><label class="color_2"><a href="<%=basePath%>mm/mmdetail?mmid=${measureMaster.id}">返回详情</a></label></p>
			                        </form:form>
		                        	</div>
		                    	</div>
		                   	</div>
		            	</div>
					</div>
				</div>
            </div>
            <div class="clear"></div>
        	</div>
    </div>
    <!-------------------------------------- 内容结束 -------------------------------------->
	<!-------------------------------------- 尾部开始 -------------------------------------->
	<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
	<!-------------------------------------- 尾部结束 -------------------------------------->
</body>
</html>