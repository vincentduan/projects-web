<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
					<div class="tit tit3">
						<h3>服务团队成员</h3>
					</div>
					<div class="team_list">
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
											<p class="p1">
												<span class="span_tit"><a href="<%=basePath%>sp/mMDetail?mmId=${mmv.measureMaster.id}&id=${sp.id}">${mmv.measureMaster.name }</a></span>（量体师）
											</p>
											<p>${mmv.measureMaster.measureExperience }</p>
											<p class="p_star">
												专业评级：<span class="star5"></span>${mmv.measureMaster.specialtyEvaluation }</p>
										</div>
									</div>
								</li>
							</c:forEach>
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