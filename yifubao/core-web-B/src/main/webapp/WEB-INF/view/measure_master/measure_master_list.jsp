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
						<p class="con_title">量体师管理</p>
						<div class="lr_taggle">
                            <div class="togg_list">
                                <span class="on">量体师列表</span>
                                <span>添加量体师</span>
                            	<div class="clear"></div>
                            </div>
                            <div class="togg_cont">
                            	<div class="taggle">
                            		<div class="mainer_cont">
					                    <div class="team_list in">
					                        <ul>
					                        	<c:forEach items="${mmvs }" var="mmv">
						                        	<li>
						                        		<div class="list">
						                                    <div class="img">
						                                    	<img src="${mmv.measureMaster.avatarImagePath }" />
							                                    <div class="img_text">
							                                    	<span>待量体人数<label>${mmv.measureNum }</label></span>
							                                    </div>
						                                    </div>
						                                    <div class="text">
						                                        <p class="p1"><span class="span_tit"><a href="<%=basePath%>mm/mmdetail?mmid=${mmv.measureMaster.id}">${mmv.measureMaster.name }</a></span>（量体师）</p>
						                                        <p>${mmv.measureMaster.measureExperience }</p>
						                                        <p class="p_star">专业评级：<span class="star5"></span>${mmv.measureMaster.specialtyEvaluation }</p>
						                                    </div>
						                        		</div>
						                        	</li>
					                        	</c:forEach>
					                        </ul>
					                    </div>
                					</div>
            					</div>
            					<div class="taggle taggle_lt none">
                                    <div class="add_measure">
                                    <form id="add_mm" action="<%=basePath%>mm/addmm" method="post">
                                    	<%-- <input name="spId" value="${sp.id }" hidden="true"> --%>
                                        <p><span class="hongxin">量体师名称：</span><input name="name" type="text" placeholder="请输入量体师姓名" /></p>
                                        <p><span class="hongxin">手机号码：</span><input name="mobile" type="text" placeholder="请输入量体师手机号码" /><i>（量体师手机号码，用于登陆量体师APP）</i></p>
                                        <p><span class="hongxin">专业评级：</span><select name="specialtyEvaluation">
                                        <option value="" selected="selected">请选择等级</option>
	                                        <option value="1">1级</option>
											<option value="2">2级</option>
											<option value="3">3级</option>
											<option value="4">4级</option>
											<option value="5">5级</option>
                                        </select></p>
                                        <p class="line_none"><span class="hongxin">量体经验：</span><textarea name="measureExperience" onfocus="if(this.value=='请输入量体经验') {this.value='';}" onblur="if(this.value=='') {this.value='请输入量体经验';}">请输入量体经验</textarea></p>
                                        <p class="line_none line_none2"><span class="hongxin">个人介绍：</span><textarea name="introduction" onfocus="if(this.value=='请输入个人介绍') {this.value='';}" onblur="if(this.value=='') {this.value='请输入个人介绍';}">请输入个人介绍</textarea></p>
                                        <!-- <p class="line_none line_none2"><span>客户评价：</span><textarea name="customerEvaluation"></textarea></p> -->
                                        <p class="but_mea"><span> </span><label class="color_1"><a href="#" onclick="$('#add_mm').submit()">提交</a></label></p>
                                    </form>
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