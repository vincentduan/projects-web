<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<!--[if lt IE 9]>
        <script type="text/javascript" src="<%=basePath%>resources/js/html5.js"></script>
        <![endif]-->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title></title>
    <script type="text/javascript" src="<%=basePath%>resources/js/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>resources/css/style.css">
    <script type="text/javascript" src="<%=basePath%>resources/js/main.js"></script>
    <!--plugin-->
    <link rel="stylesheet" type="text/css" href="<%=basePath%>resources/css/owl.carousel.min.css">
    <script type="text/javascript" src="<%=basePath%>resources/js/owl.carousel.js"></script>
<script>
        $(function () {
            $(".banner_owl").owlCarousel({
                items: 1,
                smartSpeed: 1000,
                loop: true,
                margin: 0,
                autoplay: true,
                autoplayTimeout: 8000,
                autoplayHoverPause: true
            })
        })
        window.onload = function() {
			document.getElementById("服务团队" ).className = "on";
		}
    </script>
</head>
<body>
	<!-------------------------------------- 头部开始 -------------------------------------->
	<jsp:include page="/WEB-INF/view/common/sp_header.jsp"></jsp:include>
	<!-------------------------------------- 头部结束 -------------------------------------->
	<!-------------------------------------- 内容开始 -------------------------------------->
	<div class="mainer ">
        <div class="wrap">
            <div class="mainer_cont">
                <div class="div_cont">
                    <div class="team_info">
                        <div class="peo_info flt">
                            <div class="img"><img src="${measureMaster.avatarImagePath }" /></div>
                            <div class="text">
                                <p class="p_star">专业评级：<span class="star5"></span>${measureMaster.specialtyEvaluation }</p>
                            </div>
                        </div>
                        <div class="pro_cont">
                            <p class="p_tit"><span class="span_tit">${measureMaster.name }</span>（量体师）</p>
                            <p><span>量体经验</span>${measureMaster.measureExperience }</p>
                            <p><span>个人介绍</span>${measureMaster.introduction }</p>
                            <%-- <p><span>客户评价</span>${measureMaster.customerEvaluation }</p> --%>
                        </div>
                        <div class="clear"></div>
                    </div>
                    <div class="cont_list3">
                        <div class="title"><h3>量体案例<span>数量：5个</span></h3></div>
                        <ul>
                            <li>
                                <div class="list">
                                    <div class="img"><img src="../img/img21.png" /></div>
                                    <div class="text">
                                        <p><a href="#">西服正装</a><span>2016-01-10</span></p>
                                        <p>北京银行 丨 定制周期15天 丨 100件 丨 6~10万</p>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="list">
                                    <div class="img"><img src="../img/img21.png" /></div>
                                    <div class="text">
                                        <p><a href="#">西服正装</a><span>2016-01-10</span></p>
                                        <p>北京银行 丨 定制周期15天 丨 100件 丨 6~10万</p>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="list">
                                    <div class="img"><img src="../img/img21.png" /></div>
                                    <div class="text">
                                        <p><a href="#">西服正装</a><span>2016-01-10</span></p>
                                        <p>北京银行 丨 定制周期15天 丨 100件 丨 6~10万</p>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="list">
                                    <div class="img"><img src="../img/img21.png" /></div>
                                    <div class="text">
                                        <p><a href="#">西服正装</a><span>2016-01-10</span></p>
                                        <p>北京银行 丨 定制周期15天 丨 100件 丨 6~10万</p>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="list">
                                    <div class="img"><img src="../img/img21.png" /></div>
                                    <div class="text">
                                        <p><a href="#">西服正装</a><span>2016-01-10</span></p>
                                        <p>北京银行 丨 定制周期15天 丨 100件 丨 6~10万</p>
                                    </div>
                                </div>
                            </li> 
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
	<!-------------------------------------- 内容结束 -------------------------------------->
	<!-------------------------------------- 尾部开始 -------------------------------------->
	<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
	<!-------------------------------------- 尾部结束 -------------------------------------->
</body>
</html>