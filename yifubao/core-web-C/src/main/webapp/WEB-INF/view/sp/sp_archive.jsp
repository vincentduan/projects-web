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
        window.onload = function() {
			document.getElementById("服务商档案" ).className = "on";
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
        
             
            <div class="mainer_cont">
                <div class="div_cont">
                    <div class="tit"><h2>公司简介</h2></div>
                    <div class="pro_cont2">
                        <img src="${sp.logoImagePath }" />
                        <p><span></span>${sp.summary }</p>
                        <p>公司“红豆”品牌，深受白领阶层和成功人士喜爱，“红豆”服装符合国际最新流行趋势，工序都精益求精，公司现有成员企业4家，员工300多人，年生产各类职业套装30万套，成功的为各大型集团、石油化工、冶金电力、建筑消防、矿业医药、危险品处理、银行、证劵、政府部门、机关、学校等企业事业单位提供全方位的职业装订制服务。</p>
                        <p>红豆的良好品质不仅源于德、意、日等国家的先进制衣后整理设备及检验检测仪器，还取决于其卓越的管理机制。其产品严格按ISO9001:2008质量要求进行质量管理。红豆拥有国际先进的CAD、CAM计算机辅助研究系统，拥有电脑设计中心、研究中心、制版打样中心、制服展示中心、电脑信息中心、专业工厂和售后服务部门等完善的企业服务体系，同时还拥有中国至大规模的职业装图片库和软件展示系统。</p>

                        <h2>我们的理念：</h2>
                        <div class="item"><span>质量第一：</span><label>关注客户关注点，让客户没有后顾之忧</label><span>客户第一：</span><label>不断提高产品和服务质素，力求尽善尽美</label></div>
                        <div class="item"><span>诚信：</span><label>诚实正直，信守承诺</label><span>团结：</span> <label>共享共担，以小我完成大我</label><span>坚定：</span><label>永不言弃，坚持不移的态度</label></div>
                    </div>
                </div>
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
                    <div class="tit"><h2>认证信息</h2></div>
                    <div class="cont_list4">
                        <ul> 
                        <c:forEach items="${spCPs}" var="pic">
                        	<li><a href="${pic.imagePath }"><div class="list"><div class="img"><img src="${pic.imagePath }" /><i></i></div></div><span>
                        	<c:choose><c:when test="${pic.type == 1}"><%=SpCertificatePictureTypeEnum.getName("1")%></c:when>
							<c:when test="${pic.type == 2}"><%=SpCertificatePictureTypeEnum.getName("2")%></c:when>
							<c:when test="${pic.type == 3}"><%=SpCertificatePictureTypeEnum.getName("3")%></c:when>
							<c:when test="${pic.type == 4}"><%=SpCertificatePictureTypeEnum.getName("4")%></c:when>
							</c:choose></span></a></li>
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