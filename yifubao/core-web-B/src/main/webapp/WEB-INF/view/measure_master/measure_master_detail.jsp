<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<link rel="stylesheet" type="text/css" href="<%=basePath%>resources/css/style_fw.css">
<script type="text/javascript" src="<%=basePath%>resources/js/main.js"></script>
<!--plugin-->
<link rel="stylesheet" type="text/css" href="<%=basePath%>resources/css/owl.carousel.min.css">
<script type="text/javascript" src="<%=basePath%>resources/js/owl.carousel.js"></script>

<script language="javascript" type="text/javascript" src="<%=basePath%>resources/My97DatePicker/WdatePicker.js"></script>
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
						<p class="con_title">量体师详情</p>
						<div class="lr_taggle">
							<div class="togg_cont">
                            	<div class="taggle taggle_lt">
                            		<div class="top">
                            			<p><span class="">量体师姓名：</span><label>${measureMaster.name }</label></p>
                                		<p><span class="">手机号码：</span><label>${measureMaster.mobile }</label></p>
                                		<p><span class="">专业评级：</span><label class="wukexin">${measureMaster.specialtyEvaluation }</label></p>
                                		<p><span class="">量体经验：</span><label>${measureMaster.measureExperience }</label></p>
                                		<p><span class="">个人介绍：</span><label>${measureMaster.introduction }</label></p>
                                	</div>
                                	<div class="intro">
                           				<span class="title">客户评价：</span>
                           				<div class="intro_right" style="width:720px">
                           					<%-- <label>${measureMaster.customerEvaluation }</label> --%>
                           					<label>服务态度好，工作仔细，有耐心，专业素质强~</label>
                           				</div>
                           				<div class="clear"></div>
                           			</div>
                           			<p class="but_anliu">
										<span> </span><a style="margin-left:12%;" href="<%=basePath%>mm/mmdetail?mmid=${measureMaster.id}&isupdate=1">修改</a><a href="<%=basePath%>mm/mmlist" class="on">返回列表</a>
									</p>
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