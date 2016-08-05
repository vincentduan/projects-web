<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
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

<script>
$(function () {
	$("#案例管理" ).addClass("on");
})
</script>
</head>
<body>
	<!-------------------------------------- 头部开始 -------------------------------------->
	<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>
	<!-------------------------------------- 头部结束 -------------------------------------->
	<!-------------------------------------- 内容开始 -------------------------------------->
	<div class="mainer">
        <div class="shent_j">
            <div class="wrap">
            <jsp:include page="/WEB-INF/view/common/siderbar.jsp"></jsp:include>
				<div class="facilitator">
					<div class="fa_content">
						<p class="con_title">案例详情</p>
						<div class="lr_taggle">
							<div class="togg_cont">
                            	<div class="taggle taggle_lt">
                           			<div class="top">
                           			<p><span>案例名称：</span><label>${goodsCaseVo.goodsCase.caseName }</label></p>
                           			<p><span>定制方案：</span><label>${goodsCaseVo.goodsCase.plan }</label></p>
                           			<p><span>定制费用：</span><label>
                           				<c:choose>
                           					<c:when test="${goodsCaseVo.goodsCase.cost > 0}">
                           						<fmt:formatNumber value="${goodsCaseVo.goodsCase.cost/10000 }" type="currency" />
                           					</c:when>
                        					<c:otherwise>**</c:otherwise>
                        				</c:choose> 万</label></p>
                           			<p><span>客户名称：</span><label>${goodsCaseVo.goodsCase.customerName}</label></p>
                           			<p><span>所属品类：</span><label>${goodsCaseVo.category}</label></p>
                           			<p><span>定制数量：</span><label>${goodsCaseVo.goodsCase.customNum}件</label></p>
                           			<p><span>定制周期：</span><label>${goodsCaseVo.goodsCase.customCycle}个工作日</label></p>
                           			<p><span>行业分类：</span><label>${goodsCaseVo.industry}</label></p>
                            		</div>
                            		<div class="intro">
                           				<span class="title">案例图片：</span>
                           				<div class="intro_right">
                           					<ul>
                           						<c:forEach items="${goodsCaseVo.casePictures }" var="picture">
													<li><img src="${picture.imagePath }"></li>
												</c:forEach>
                           					</ul>
                           					<div class="clear"></div>
                           				</div>
                           				<div class="clear"></div>
                           			</div>
                           			<div class="intro">
                           				<span class="title">案例描述：</span>
                           				<div class="intro_right">
                           					<p class="in">${goodsCaseVo.goodsCase.description}</p>				
                           				</div>
                           				<div class="clear"></div>
                           			</div>
                           			<div class="intro">
                           				<span class="title">客户评价：</span>
                           				<div class="intro_right">
                           					<label>${goodsCaseVo.goodsCase.customerEvaluation}</label>
                           				</div>
                           				<div class="clear"></div>
                           			</div>
                           			<p class="but_anliu">
										<span> </span><a style="margin-left:12%;" href="<%=basePath%>case/toupdatecase?caseid=${goodsCaseVo.goodsCase.id}">编辑</a><a href="<%=basePath%>case/caseinfo" class="on">返回案例列表</a>
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