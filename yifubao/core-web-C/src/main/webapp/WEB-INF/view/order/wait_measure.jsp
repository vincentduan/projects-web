<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>上门量体</title>
<link rel="stylesheet" href="<%=basePath%>resources/css/style.css" />
<link rel="stylesheet" href="<%=basePath%>resources/css/style1.css" />
<link rel="stylesheet"
	href="<%=basePath%>resources/css/owl.carousel.min.css" />
<script src="<%=basePath%>resources/js/jquery.min.js"
	type="text/javascript"></script>
<script src="<%=basePath%>resources/js/main.js" type="text/javascript"></script>
<script src="<%=basePath%>resources/js/owl.carousel.js"
	type="text/javascript"></script>
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
            $(".pro_case .list .item").hover(function () {
                $(this).parents(".pro_case").find(".item").removeClass("on");
                $(this).addClass("on")
            }, function () {
                $(this).parents(".pro_case").find(".item").removeClass("on");
            })

            $(".item_owl").owlCarousel({
                items: 5,
                smartSpeed: 500,
                loop: true,
                margin: 0,
                nav: true,
                navText: ["<img src='<%=basePath%>resources/img/cur.png' />", "<img src='<%=basePath%>resources/img/cur2.png' />" ],
							dots : false,
							autoplay : true,
							autoplayTimeout : 8000,
							autoplayHoverPause : true
						})

		$(".item_list").each(function() {
			$(this).find("ul").fadeOut().eq(0).fadeIn();
			;
		})
		$(".list_toggle").each(function() {
			$(this).find("li").eq(0).addClass("on")
		})
		$(".list_toggle ul li").hover(
				function() {
					$(this).parent().find("li").removeClass("on");
					$(this).addClass("on");
					$(this).parents(".list").find(".item_list").find("ul")
							.stop().fadeOut(1000).eq($(this).index()).stop()
							.fadeIn(1000);
					;
					$(this).parents(".list").find(".ul_tagg").stop().fadeOut(
							1000).eq($(this).index()).stop().fadeIn(1000);
					;

				})

		$(".ul_tagg").hide().eq(0).show();

	})
</script>

</head>
<body>
	<!-------------------------------------- 头部开始 -------------------------------------->
	<div class="head">
		<div class="wrap">
			<span class="flt"><a href="#">依文集团</a> & <a href="#">猪八戒网</a>
				<a href="#">旗下职业装定制平台</a></span>
			<div class="title_j">
				<ul>
					<li><a href="#"><img src="<%=basePath%>resources/img/xiaoxi.png" />消息</a></li>
					<li><a href="#">我的定制</a></li>
					<li><a href="#">186****2313</a><label><img
							src="<%=basePath%>resources/img/sanjiao.png" /></label></li>
				</ul>
			</div>
			<div class="clear"></div>
		</div>

	</div>
	<div class="input_j">
		<div class="wrap">
			<div class="logo_c">
				<img src="<%=basePath%>resources/img/logo3.png" />
			</div>
			<div class="text_j">
				<p>
					<a href="#">职业装定制</a>
				</p>
				<p>
					<span><a href="#">返回依服宝首页</a></span>
				</p>
			</div>
			<div class="input_a">
				<input type="text" placeholder="输入要搜索的关键词" /><a href="#"><span>搜索</span></a>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<!-------------------------------------- 头部结束 -------------------------------------->
	<!-------------------------------------- 内容开始 -------------------------------------->


	<div class="mainer">

	</div>
		<div class="shent_j">
			<div class="wrap">
				<div class="daohang">
					<p class="daohang_1">订单中心</p>
					<p class="daohang_2">
						<a href="#">我的订单</a>
					</p>
					<p class="daohang_2">
						<a href="#">取消的订单</a>
					</p>

					<p class="daohang_1 padd">账户设置</p>
					<p class="daohang_2">
						<a href="#">用户资料</a>
					</p>
					<p class="daohang_2">
						<a href="#">修改登录密码</a>
					</p>
					<p class="daohang_2">
						<a href="#">绑定手机/邮箱</a>
					</p>
					<p class="daohang_2">
						<a href="#">地址管理</a>
					</p>
					<p class="daohang_2">
						<a href="#">身份认证</a>
					</p>
					<p class="daohang_2">
						<a href="#">支付账户管理</a>
					</p>

					<p class="daohang_1 padd">我的消息</p>
					<p class="daohang_2">
						<a href="#">全部消息</a>
					</p>
				</div>

				<div class="zhengwen">
					<div class="leirong">
						<p class="leirong_1">上门量体</p>
						<div class="public">
							<p><label><span class="back_1 on">金额：${baseOrder.totalMoney }</span><span class="back_2 "><img src="../img/icon24.png">已支付金额${baseOrder.frontMoney }</span></label><i>订单号：${baseOrder.orderNo }</i><i>状态：<em>上门量体</em></i></p>
						</div>
						<div class="zhuangtai">
							<div class="div_item">
								<div class="item on item_first">
									<div class="list">
										<i></i>
										<p>发布需求</p>
										<span>2016-01-10 17:02:42</span>
										<div class="tanchuan">
											<div class="tanchuan_img">
												<img src="<%=basePath%>resources/img/yaoyingchao.png" />
												<div class="sanjia">
													<img src="<%=basePath%>resources/img/xiangxia.png" />
												</div>
											</div>
											<div class="tanchuan_text">
												<p>10分钟金牌管家联系您，</p>
												<p>根据您的需求匹配高资质服务商</p>
											</div>
										</div>
									</div>
								</div>

								<div class="item on">
									<div class="list">
										<i></i>
										<p>管家受理</p>
										<span>2016-01-10 17:02:42</span>
										<div class="tanchuan">
											<div class="tanchuan_img">
												<img src="<%=basePath%>resources/img/yaoyingchao.png" />
												<div class="sanjia">
													<img src="<%=basePath%>resources/img/xiangxia.png" />
												</div>
											</div>
											<div class="tanchuan_text">
												<p>10分钟金牌管家联系您，</p>
												<p>根据您的需求匹配高资质服务商</p>
											</div>
										</div>

									</div>
								</div>
								<div class="item in on">
									<div class="list">
										<i></i>
										<p class="p1">
											选择服务商<span class="span1">(设计、打样、报价)</span>
										</p>


										<div class="tanchuan">
											<div class="tanchuan_img">
												<img src="<%=basePath%>resources/img/yaoyingchao.png" />
												<div class="sanjia">
													<img src="<%=basePath%>resources/img/xiangxia.png" />
												</div>
											</div>
											<div class="tanchuan_text">
												<p>10分钟金牌管家联系您，</p>
												<p>根据您的需求匹配高资质服务商</p>
											</div>
										</div>

									</div>
								</div>
								<div class="item">
									<div class="list">
										<i></i>
										<p>签单付定金</p>

										<div class="tanchuan">
											<div class="tanchuan_img">
												<img src="<%=basePath%>resources/img/yaoyingchao.png" />
												<div class="sanjia">
													<img src="<%=basePath%>resources/img/xiangxia.png" />
												</div>
											</div>
											<div class="tanchuan_text">
												<p>10分钟金牌管家联系您，</p>
												<p>根据您的需求匹配高资质服务商</p>
											</div>
										</div>

									</div>
								</div>
								<div class="item">
									<div class="list">
										<i></i>
										<p>上门量体</p>

										<div class="tanchuan">
											<div class="tanchuan_img">
												<img src="<%=basePath%>resources/img/yaoyingchao.png" />
												<div class="sanjia">
													<img src="<%=basePath%>resources/img/xiangxia.png" />
												</div>
											</div>
											<div class="tanchuan_text">
												<p>10分钟金牌管家联系您，</p>
												<p>根据您的需求匹配高资质服务商</p>
											</div>
										</div>

									</div>
								</div>
								<div class="item">
									<div class="list">
										<i></i>
										<p>生产制作</p>

										<div class="tanchuan">
											<div class="tanchuan_img">
												<img src="<%=basePath%>resources/img/yaoyingchao.png" />
												<div class="sanjia">
													<img src="<%=basePath%>resources/img/xiangxia.png" />
												</div>
											</div>
											<div class="tanchuan_text">
												<p>10分钟金牌管家联系您，</p>
												<p>根据您的需求匹配高资质服务商</p>
											</div>
										</div>

									</div>
								</div>
								<div class="item">
									<div class="list">
										<i></i>
										<p>支付尾款</p>

										<div class="tanchuan">
											<div class="tanchuan_img">
												<img src="<%=basePath%>resources/img/yaoyingchao.png" />
												<div class="sanjia">
													<img src="<%=basePath%>resources/img/xiangxia.png" />
												</div>
											</div>
											<div class="tanchuan_text">
												<p>10分钟金牌管家联系您，</p>
												<p>根据您的需求匹配高资质服务商</p>
											</div>
										</div>

									</div>
								</div>
								<div class="item">
									<div class="list">
										<i></i>
										<p>待发货</p>

										<div class="tanchuan tanchuan_1">
											<div class="tanchuan_img">
												<img src="<%=basePath%>resources/img/yaoyingchao.png" />
												<div class="sanjia sanjia_1">
													<img src="<%=basePath%>resources/img/xiangxia.png">
												</div>
											</div>
											<div class="tanchuan_text">
												<p>10分钟金牌管家联系您，</p>
												<p>根据您的需求匹配高资质服务商</p>
											</div>
										</div>

									</div>
								</div>
								<div class="item">
									<div class="list">
										<i></i>
										<p>待签收</p>

										<div class="tanchuan tanchuan_1">
											<div class="tanchuan_img">
												<img src="<%=basePath%>resources/img/yaoyingchao.png" />
												<div class="sanjia sanjia_1">
													<img src="<%=basePath%>resources/img/xiangxia.png" />
												</div>
											</div>
											<div class="tanchuan_text">
												<p>10分钟金牌管家联系您，</p>
												<p>根据您的需求匹配高资质服务商</p>
											</div>
										</div>

									</div>
								</div>
								<div class="item item_last">
									<div class="list">
										<i></i>
										<p>交易完成</p>

										<div class="tanchuan tanchuan_1">
											<div class="tanchuan_img">
												<img src="<%=basePath%>resources/img/yaoyingchao.png" />
												<div class="sanjia sanjia_1">
													<img src="<%=basePath%>resources/img/xiangxia.png" />
												</div>
											</div>
											<div class="tanchuan_text">
												<p>10分钟金牌管家联系您，</p>
												<p>根据您的需求匹配高资质服务商</p>
											</div>
										</div>

									</div>
								</div>
								<div class="clear"></div>
							</div>
						</div>
                        <c:if test="${measureOrder.status==1 }">
						<jsp:include page="./info2.jsp" />
						</c:if>
						<c:if test="${measureOrder.status>1 }">
						<%-- <jsp:include page="./info3.jsp" /> --%>
						</c:if>
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