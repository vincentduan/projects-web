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
<script type="text/javascript">
	
	window.onload = function() {
		document.getElementById("cid_${parentCategorys[0].id}" ).className = "on";
	}
	
	var values = new Array(${fn:length(attrs)});
	for (var int = 0; int < values.length; int++) {
		values[int] = "0"
	}
	var prices = <%=request.getAttribute("prices")%>
	var SKUS = <%=request.getAttribute("SKUS")%>
	console.log(SKUS)
	function changePrice(id) {
		values[Number(id.split("_")[0])] = id.split("_")[1]
		var flag = true
		for ( var v in values) {
			if (values[v] == "0") {
				flag = false
			}
		}
		if (flag) {
			console.log(SKUS[values.join()]);
			document.getElementById("price" ).firstChild.nodeValue = prices[values.join()];
		}
	}
	
	</script>
</head>
<body>
	<!-------------------------------------- 头部开始 -------------------------------------->
	<jsp:include page="/WEB-INF/view/common/goods_header.jsp"></jsp:include>
    <!-------------------------------------- 头部结束 -------------------------------------->
    <!-------------------------------------- 内容开始 -------------------------------------->


    <div class="mainer">
        <div class="wrap">
            <!-------------------------------------- 左上类目栏 ----------------------------->
			<div class="div_pos">
				<span>
					<c:forEach items="${parentCategorys}" var="item" varStatus="st">
						<c:choose>
							<c:when test="${st.last }">
								<a href="#" class="a_tit">${item.name}</a>
							</c:when>
							<c:otherwise>
								<a href="<%=basePath%>goods/goodsList?categoryId=${item.id}" class="a_tit">${item.name}</a>
								<label>></label>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</span>
				<div class="clear"></div>
			</div>
            
            <div class="pro_info">
                <div class="pro_silder flt">
                     <div class="slider_left flt">
                         <div class="cur cur_top"><img src="<%=basePath%>resources/img/cur3.png" /></div>
                         <ul>
                         	<c:forEach items="${goodsPics}" var="item">
                             	<li><div class="img"><img src="${item.imagePath }" /></div></li>
                         	</c:forEach>
                         </ul>
                         <div class="cur cur_bottom"><img src="<%=basePath%>resources/img/cur4.png" /></div>
                     </div>
                    <div class="slider_pic frt">
                        <div class="img">
                            <img src="${goods.firstImagePath }" />
                        </div>
                    </div>
                </div>

                <div class="pro_desc frt">
                    <div class="title"><a href="#">${goods.name }</a></div>
                    <div class="item item1"><span class="flt">售价：</span><p><label>￥<font id="price">${goods.minPrice} - ${goods.maxPrice}</font></label>元</p></div>
                    <c:forEach items="${attrs}" var="attr" varStatus="attrIndex">
                    	<div class="item item_img"><span class="flt">${attr.name}：</span>
	                    	<p id="dd" class="p_color">
	                    		<c:forEach items="${attr.attrValues}" var="value" varStatus="valueIndex">
	                    			<span id="${attrIndex.index}_${value.id }" onclick="changePrice(this.id)"><i></i>
	                    			<c:if test="${not empty value.imgPath}"><img src="${value.imgPath }" /></c:if>
	                    			${value.name }
	                    		</span>
	                    		</c:forEach>
	                    	</p>
	                    </div>
                    </c:forEach>
                    <div class="div_btn"><a href="#">预约定制</a></div>
                </div>
                <div class="clear"></div>
            </div>
             
            <div class="pro_info2">
                <div class="left_side flt">
                    <ul>
					<c:forEach items="${categorys}" var="item">
						<c:if test="${item.parentId == 0}">
							<li><span class="span_tit"><a
									href="<%=basePath%>goods/goodsList?categoryId=${item.id}">${item.name}</a></span></li>
							<c:forEach items="${categorys}" var="subitem">
								<c:if test="${subitem.parentId == item.id}">
									<p><a href="<%=basePath%>goods/goodsList?categoryId=${subitem.id}">${subitem.name}</a></p>
								</c:if>
							</c:forEach>
						</c:if>
					</c:forEach>
				</ul>
                </div>

                <div class="pro_show">
                	<c:forEach items="${goodsDescs}" var="item">
                		${item.description}${item.id}${item.goodsId}
                	</c:forEach>
                    <%-- <div class="title"><span>产品展示</span></div>
                    <div class="show_cont"><img src="<%=basePath%>resources/img/pic1.jpg" /></div>
                    <div class="title"><span>定制介绍</span></div>
                    <div class="show_cont"><img src="<%=basePath%>resources/img/pic2.jpg" /></div>
                    <div class="title2"><span>定制流程</span></div>
                    <div class="show_cont"><img src="<%=basePath%>resources/img/pic3.jpg" /></div>
                    <div class="title"><span>产品信息</span></div>
                    <div class="show_cont"><img src="<%=basePath%>resources/img/pic4.jpg" /></div>
                    <div class="title2"><span>洗涤说明</span></div>
                    <div class="show_cont"><img src="<%=basePath%>resources/img/pic5.jpg" /></div>
                    <div class="title"><span>细节展示</span></div>
                    <div class="show_cont"><img src="<%=basePath%>resources/img/pic6.jpg" /></div>
                    <div class="title"><span>服务承诺</span></div>
                    <div class="show_cont cont_text"><p>依服宝平台销售并发货的商品，由平台依服宝提供发票和相应的售后服务。<span>请您放心购买！</span></p></div> --%>
                </div>
                <div class="clear"></div>
            </div>

             

            <div class="clear"></div>
        </div>
    </div>
    <!-------------------------------------- 内容结束 -------------------------------------->
    <!-------------------------------------- 尾部开始 -------------------------------------->
    <jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
	<!-------------------------------------- 尾部结束 -------------------------------------->
	<jsp:include page="/WEB-INF/view/common/float.jsp"></jsp:include>
</body>
</html>