<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
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
<script type="text/javascript">
		window.onload = function() {
			$("#服务商信息" ).addClass("on");
		}
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
						<p class="con_title">服务商信息</p>
						<div class="lr_taggle">
                            <div class="togg_list">
                                <span class="on">基本信息</span>
                                <span>服务商档案</span>
                                <span>合同信息</span>
                            	<div class="clear"></div>
                            </div>
                            <div class="togg_cont">
                            	<div class="taggle">
                            		<div class="basic">
                            			<p><span>服务商名称：</span><label>${sp.name }</label></p>
                            			<p><span>服务商简称：</span><label>${sp.shortname }</label></p>
                            			<p><span>服务商等级：</span><label>${sp.grade }</label></p>
                            			<p><span>法人姓名：</span><label>${sp.legalPerson }</label></p>
                            			<p><span>注册地址：</span><label>${sp.registeredAddr }</label></p>
                            			<p><span>注册资金：</span><label>${sp.registeredCapital }</label></p>
                            			<p><span>营业执照注册号：</span><label>${sp.businessLicenceNo }</label></p>
                            			<p><span>税务登记证号：</span><label>${sp.taxRegistrationNo }</label></p>
                            			<p><span>组织机构代码：</span><label>${sp.orgCode }</label></p>
                            			<p><span>经营期限：</span><label><fmt:formatDate pattern="yyyy年M月" value="${sp.businessStartDate }" />
                            			至<fmt:formatDate pattern="yyyy年M月" value="${sp.businessEndDate }" /></label></p>
                            			<p><span>经营范围：</span><label>${sp.businessRange }</label></p>
                            			<p><span>备注：</span><label>${sp.remarks }</label></p>
                            			<c:forEach items="${spCPs}" var="pic"><p><span>
                            			<c:choose><c:when test="${pic.type == 1}"><%=SpCertificatePictureTypeEnum.getName("1")%></c:when>
										<c:when test="${pic.type == 2}"><%=SpCertificatePictureTypeEnum.getName("2")%></c:when>
										<c:when test="${pic.type == 3}"><%=SpCertificatePictureTypeEnum.getName("3")%></c:when>
										<c:when test="${pic.type == 4}"><%=SpCertificatePictureTypeEnum.getName("4")%></c:when>
										</c:choose></span><label><img src="${pic.imagePath }"></label></p>
                            			</c:forEach>
                            		</div>
                            	</div>
                            	<div class="taggle taggle_lt none">
                            		<div class="basic">
                            			<p><span>服务商LOGO：</span><label><img src="${sp.logoImagePath }"></label></p>
                            			<p><span>服务区域：</span><label>${fn:replace(spRange, ',', '、') }</label></p>
                            			<p><span>服务类型：</span><label>
                            			<c:forTokens items="${sp.serviceCategory }" delims="," var="c" varStatus="status">
										<c:choose><c:when test="${c == 1}"><%=ServiceCategoryTypeEnum.getName("1")%></c:when>
										<c:when test="${c == 2}"><%=ServiceCategoryTypeEnum.getName("2")%></c:when>
										<c:when test="${c == 3}"><%=ServiceCategoryTypeEnum.getName("3")%></c:when></c:choose>
                            			<c:if test="${!status.last }">、</c:if></c:forTokens> </label></p>
                            			<div class="intro">
                            				<span class="title">企业简介：</span>
                            				<div id="show_summary" class="intro_right">
                            					${sp.summary }
                            				<div class="edit">
                            					<a href="javascript:0" onclick="$('#show_summary').hide();$('#edit_summary').show()">编辑</a>
                            				</div>
                            				</div>
                            				<div id="edit_summary" class="intro_right" hidden="true">
	                           					<form id="form_summary" action="<%=basePath%>sp/updatesp" method="post">
	                           						<input name="id" value="${sp.id}" hidden="true">
	                           						<input name="summary" value="${sp.summary }">
	                           						<div class="edit">
                            							<a href="javascript:0" onclick="$('#form_summary').submit();">提交</a>
                            							<a href="javascript:0" onclick="$('#show_summary').show();$('#edit_summary').hide()">返回</a>
                            						</div>
	                           					</form>
                           					</div>
                            				<div class="clear"></div>
                            			</div>
                            		</div>
                            	</div>
                            	<div class="taggle taggle_xx none">
                            		<div class="basic">
                            			<div class="top">
                            			<p><span>服务商名称：</span><label>${sp.name }</label></p>
                            			<p><span>合同名称：</span><label>${spContract.contractName }</label></p>
                            			<p><span>合同编号：</span><label>${spContract.contractNum }</label></p>
                            			<p><span>合同有效期：</span><label><fmt:formatDate pattern="yyyy年M月" value="${spContract.validStartDate }" />
                            			至<fmt:formatDate pattern="yyyy年M月" value="${spContract.validEndDate }" /></label></p>
                            			<p><span>经营品类：</span><label><c:forEach items="${categorys}" var="category" varStatus="status">
                            			${category.name }<c:if test="${!status.last }"><br/></c:if></c:forEach></label></p>
                            			<p><span>发票类型：</span><label><c:forTokens items="${spContract.invoiceType }" delims="," var="i" varStatus="status">
                            			<span><c:choose><c:when test="${i == 1}"><%=InvoiceTypeEnum.getName("1")%></c:when>
										<c:when test="${i == 2}"><%=InvoiceTypeEnum.getName("2")%></c:when></c:choose></span>
                            			</c:forTokens></label></p>
                            			</div>
                            			<div class="bot">
                            				<p><span>平台佣金<label>（订单总额占比）</label></span><label><fmt:formatNumber value="${spContract.commissionPercent}" type="percent" /></label></p>
                            				<p><span>预付款<label>（订单总额占比）</label></span><label><fmt:formatNumber value="${spContract.prepaymentPercent}" type="percent" /></label></p>
                            				<p><span>履约保证金<label>（订单总额占比）</label></span><label><fmt:formatNumber value="${spContract.creditDepositPercent}" type="percent" /></label></p>
                            				<p><span>质保金<label>（订单总额占比）</label></span><label><fmt:formatNumber value="${spContract.qualityDepositPercent}" type="percent" /></label></p>
                            				<p><span>平台技术服务费<label>（按年收取）</label></span><label>${spContract.serviceFee}元</label></p>
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
    </div>
    <!-------------------------------------- 内容结束 -------------------------------------->
	<!-------------------------------------- 尾部开始 -------------------------------------->
	<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
	<!-------------------------------------- 尾部结束 -------------------------------------->
</body>
</html>