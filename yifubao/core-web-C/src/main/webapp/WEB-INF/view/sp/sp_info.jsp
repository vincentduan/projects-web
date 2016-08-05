<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.efubao.core.bigc.utils.*"%> 
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
			document.getElementById("首页" ).className = "on";
		}
    </script>
</head>
<body>
	<!-------------------------------------- 头部开始 -------------------------------------->
	<jsp:include page="/WEB-INF/view/common/sp_header.jsp"></jsp:include>
	<!-------------------------------------- 头部结束 -------------------------------------->
	<!-------------------------------------- 内容开始 -------------------------------------->
    <div class="mainer mainer_index">
        <div class="wrap">
            <div class="banner2 flt">
                <div class="banner_owl">
                    <div class="item"><a href="#"><img src="${sp.logoImagePath }" /></a></div>
                    <div class="item"><a href="#"><img src="${sp.logoImagePath }" /></a></div>
                    <div class="item"><a href="#"><img src="${sp.logoImagePath }" /></a></div>
                </div>
                 
            </div>
            <div class="companyInfo frt">
                <div class="comp_tit">公司简介</div>
                <div class="comp_cont">
                    <p><img src="${sp.logoImagePath }" />${sp.summary }<a href="<%=basePath%>sp/spArchive?id=${sp.id}">查看更多</a></p>
                </div>
            </div>
            <div class="clear"></div>
             
            <div class="mainer_cont">
                <div class="div_cont">
                    <div class="tit"><h2>公司服务</h2></div>
                    <div class="cont_list1">
                        <p><span>服务区域</span><label>${fn:replace(spRange, ',', '、') }</label></p>
                        <p><span>服务类别</span><label><c:forTokens items="${sp.serviceCategory }" delims="," var="c" varStatus="status">
										<c:choose><c:when test="${c == 1}"><%=ServiceCategoryTypeEnum.getName("1")%></c:when>
										<c:when test="${c == 2}"><%=ServiceCategoryTypeEnum.getName("2")%></c:when>
										<c:when test="${c == 3}"><%=ServiceCategoryTypeEnum.getName("3")%></c:when></c:choose>
                            			<c:if test="${!status.last }">、</c:if></c:forTokens></label></p>
                        <p><span>服务内容</span><label><c:forEach items="${categorys}" var="category" varStatus="status">
                            			${category.name }<c:if test="${!status.last }">、</c:if></c:forEach></label></p>
                        <p><span>服务团队</span><label>设计师团队、量体师团队</label></p>
                    </div>
                </div>
                <div class="div_cont">
                    <div class="tit"><h2>服务团队成员</h2></div>
                    <div class="cont_list2">
                        <ul>
                        	<c:forEach items="${mmvs }" var="mmv" end="7">
                        	<li>
	                            <div class="img">
	                            	<img src="${mmv.measureMaster.avatarImagePath }" />
	                             <div class="img_info">
	                             	<span>待量体人数<label>${mmv.measureNum }</label></span>
	                             </div>
	                            </div>
	                            <div class="text">
	                                <h3><a href="<%=basePath%>sp/mMDetail?mmId=${mmv.measureMaster.id}&id=${sp.id}">${mmv.measureMaster.name }</a>（量体师）</h3>
	                                <span>${mmv.measureMaster.measureExperience }</span>
	                                <p class="p_star">专业评级：<span class="star5"></span>${mmv.measureMaster.specialtyEvaluation }</p>
	                            </div>
                        	</li>
                       		</c:forEach>
                        </ul>
                    </div>
                </div>

                <div class="div_cont">
                    <div class="tit"><h2>案例库</h2></div>
                    <div class="cont_list3">
                        <ul>
                            <li>
                                <div class="list">
                                    <div class="img"><img src="<%=basePath%>resources/img/img21.png" /></div>
                                    <div class="text">
                                        <p><a href="#">西服正装</a><span>2016-01-10</span></p>
                                        <p>北京银行 丨 定制周期15天 丨 100件 丨 6~10万</p>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="list">
                                    <div class="img"><img src="<%=basePath%>resources/img/img21.png" /></div>
                                    <div class="text">
                                        <p><a href="#">西服正装</a><span>2016-01-10</span></p>
                                        <p>北京银行 丨 定制周期15天 丨 100件 丨 6~10万</p>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="list">
                                    <div class="img"><img src="<%=basePath%>resources/img/img21.png" /></div>
                                    <div class="text">
                                        <p><a href="#">西服正装</a><span>2016-01-10</span></p>
                                        <p>北京银行 丨 定制周期15天 丨 100件 丨 6~10万</p>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="list">
                                    <div class="img"><img src="<%=basePath%>resources/img/img21.png" /></div>
                                    <div class="text">
                                        <p><a href="#">西服正装</a><span>2016-01-10</span></p>
                                        <p>北京银行 丨 定制周期15天 丨 100件 丨 6~10万</p>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="list">
                                    <div class="img"><img src="<%=basePath%>resources/img/img21.png" /></div>
                                    <div class="text">
                                        <p><a href="#">西服正装</a><span>2016-01-10</span></p>
                                        <p>北京银行 丨 定制周期15天 丨 100件 丨 6~10万</p>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="list">
                                    <div class="img"><img src="<%=basePath%>resources/img/img21.png" /></div>
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