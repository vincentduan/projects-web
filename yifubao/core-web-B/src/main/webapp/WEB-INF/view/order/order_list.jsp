<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title></title>
<script type="text/javascript"
	src="<%=basePath%>resources/js/jquery.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>resources/css/style_fw.css">
<script type="text/javascript" src="<%=basePath%>resources/js/main.js"></script>
<!--plugin-->
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>resources/css/owl.carousel.min.css">
<script type="text/javascript"
	src="<%=basePath%>resources/js/owl.carousel.js"></script>
<script>
	$(function() {
		$(".banner_owl").owlCarousel({
			items : 1,
			smartSpeed : 1000,
			loop : true,
			margin : 0,
			autoplay : true,
			autoplayTimeout : 8000,
			autoplayHoverPause : true
		})
		$(".pro_case .list .item").hover(function() {
			$(this).parents(".pro_case").find(".item").removeClass("on");
			$(this).addClass("on")
		}, function() {
			$(this).parents(".pro_case").find(".item").removeClass("on");
		})

		$(".item_owl").owlCarousel(
				{
					items : 5,
					smartSpeed : 500,
					loop : true,
					margin : 0,
					nav : true,
					navText : [ "<img src='<%=basePath%>resources/img/cur.png' />",
							"<img src='<%=basePath%>resources/img/cur2.png' />" ],
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
					<li><a href="#"><img
							src="<%=basePath%>resources/img/xiaoxi.png" />消息</a></li>
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
		<div class="bg1">
			<div class="wrap">
				<div class="deal">
					<div class="daohang">
						<p class="daohang_1">交易管理</p>
						<p class="daohang_2">
							<a href="#">订单管理</a>
						</p>


						<p class="daohang_1 padd">基础设置</p>
						<p class="daohang_2">
							<a href="#">服务商信息</a>
						</p>
						<p class="daohang_2">
							<a href="#">案例管理</a>
						</p>
						<p class="daohang_2">
							<a href="#">量体师管理</a>
						</p>


						<p class="daohang_1 padd">账号设置</p>
						<p class="daohang_2">
							<a href="#">修改登录密码</a>
						</p>
						<p class="daohang_2">
							<a href="#">修改手机号码</a>
						</p>
						<p class="daohang_2">
							<a href="#">身份认证</a>
						</p>
						<p class="daohang_2">
							<a href="#">支付账户管理</a>
						</p>
						<p class="daohang_1 padd">财务管理</p>
						<p class="daohang_2">
							<a href="#">收支明细</a>
						</p>
						<p class="daohang_1 padd">消息中心</p>
						<p class="daohang_2">
							<a href="#">全部消息</a>
						</p>
					</div>
					<div class="order">
						<div class="order_title">
							<span>订单管理</span>
							<ul id="myul">
								<li><a href="<%=basePath%>service/orderList">全部订单</a></li>
								<li><a href="<%=basePath%>service/orderList?status=2">已中标（2）</a></li>
								<li><a href="<%=basePath%>service/orderList?status=140">待量体（20）</a></li>
								<li><a href="<%=basePath%>service/orderList?status=160">生产完成（10）</a></li>
								<li><a href="<%=basePath%>service/orderList?status=170">待发货（5）</a></li>
								<li><a href="<%=basePath%>service/orderList?status=200">已完成</a></li>
							</ul>
							<div class="clear"></div>
						</div>
						<div class="order_content">
							<div class="con_right">
								<ul>
									<c:forEach items="${orderCustomDemandVos }"
										var="orderCustomDemandVo">
										<c:choose>
											<c:when test="${orderCustomDemandVo.status ==1 }">
												<li>
													<div class="swwe">
														<img src="<%=basePath%>resources/img/swwe.png">
													</div> <i><img src="<%=basePath%>resources/img/icon_jiao.jpg"></i>
													<div class="list_left">
														<p>
															<span>${orderCustomDemandVo.orderCustomerInfo.bespeakName }&nbsp;&nbsp;</span>定制&nbsp;&nbsp;${orderCustomDemandVo.serviceProvider.name }的<img
																src="<%=basePath%>resources/img/list1.png"><img
																src="<%=basePath%>resources/img/list2.png"><img
																src="<%=basePath%>resources/img/list3.png">&nbsp;&nbsp;${orderCustomDemandVo.orderCustomDemand.categoryName }
															共计件${orderCustomDemandVo.orderCustomDemand.customNum }
														</p>
														<span> 竞标&nbsp;&nbsp; </span> <a
															href="<%=basePath%>service/orderDetail?orderNo=${orderCustomDemandVo.orderCustomDemand.orderNo }&spId=${orderCustomDemandVo.orderCustomDemand.spId }">查看详情</a>
														<label><img
															src="<%=basePath%>resources/img/zhong.png"> <fmt:formatDate
																value="${orderCustomDemandVo.createTime }"
																pattern="yyyy-MM-dd  HH:mm:ss " /></label>
													</div>
													<div class="list_right">
														<img src="<%=basePath%>resources/img/yaoyingchao.png">
														<span>金牌管家：<label>姚颖超</label></span> <span><img
															src="<%=basePath%>resources/img/phone.png">13822222222</span>
													</div>
													<div class="clear"></div>
												</li>
											</c:when>
											<c:when test="${orderCustomDemandVo.status == 2 }">
												<li>
													<div class="swwe">
														<img src="<%=basePath%>resources/img/swwe.png">
													</div> <i><img src="<%=basePath%>resources/img/icon_jiao.jpg"></i>
													<div class="list_left">
														<p>
															<span>${orderCustomDemandVo.orderCustomerInfo.bespeakName }</span>定制&nbsp;&nbsp;${orderCustomDemandVo.serviceProvider.name }的<img
																src="<%=basePath%>resources/img/list1.png"><img
																src="<%=basePath%>resources/img/list2.png"><img
																src="<%=basePath%>resources/img/list3.png">&nbsp;&nbsp;${orderCustomDemandVo.orderCustomDemand.categoryName }
															共计件${orderCustomDemandVo.orderCustomDemand.customNum }
														</p>
															<c:choose>
																<c:when test="${orderCustomDemandVo.orderStatus == 125 }">
																	<span>
																		<label>中标</label>
																		<em>完善合同</em>
																	</span>
																	<a href="<%=basePath%>service/orderDetail?orderNo=${orderCustomDemandVo.orderCustomDemand.orderNo }&spId=${orderCustomDemandVo.orderCustomDemand.spId }">完善合同</a>
																	<a href="#" class="in">查看详情</a>
																</c:when>
																<c:when test="${orderCustomDemandVo.orderStatus == 130 }">
																	<span><label>待客户付定金：￥${orderCustomDemandVo.frontMoney }元</label>金额：￥${orderCustomDemandVo.totalMoney }
																	</span>
																	<a href="<%=basePath%>service/orderDetail?orderNo=${orderCustomDemandVo.orderCustomDemand.orderNo }&spId=${orderCustomDemandVo.orderCustomDemand.spId }" class="in">查看详情</a>
																</c:when>
																<c:when test="${orderCustomDemandVo.orderStatus == 140 }">
																	<span><label>客户已付定金:￥${orderCustomDemandVo.frontMoney }元</label>金额：￥${orderCustomDemandVo.totalMoney }<em>上门量体</em></span>
																		<a href="<%=basePath%>service/orderDetail?orderNo=${orderCustomDemandVo.orderCustomDemand.orderNo }&spId=${orderCustomDemandVo.orderCustomDemand.spId }">指派量体师</a><a href="<%=basePath%>service/orderDetail?orderNo=${orderCustomDemandVo.orderCustomDemand.orderNo }&spId=${orderCustomDemandVo.orderCustomDemand.spId }" class="in">查看详情</a>
																</c:when>
																<c:when test="${orderCustomDemandVo.orderStatus == 150 }">
																	<span><label>客户已付定金:￥${orderCustomDemandVo.frontMoney }元</label>金额：￥${orderCustomDemandVo.totalMoney }<em>生产制作</em></span>
																		<a href="<%=basePath%>service/orderDetail?orderNo=${orderCustomDemandVo.orderCustomDemand.orderNo }&spId=${orderCustomDemandVo.orderCustomDemand.spId }">生产完成</a><a href="<%=basePath%>service/orderDetail?orderNo=${orderCustomDemandVo.orderCustomDemand.orderNo }&spId=${orderCustomDemandVo.orderCustomDemand.spId }" class="in">查看详情</a>
																</c:when>
																<c:when test="${orderCustomDemandVo.orderStatus == 160 }">
																<!-- 代付尾款 -->
																	<span><label>待客户付尾款：￥${orderCustomDemandVo.balancePayment }元</label>金额：￥${orderCustomDemandVo.totalMoney }<img src="<%=basePath%>resources/img/ic1.png">已付定金：￥${orderCustomDemandVo.frontMoney }</span> 
																	<a href="<%=basePath%>service/orderDetail?orderNo=${orderCustomDemandVo.orderCustomDemand.orderNo }&spId=${orderCustomDemandVo.orderCustomDemand.spId }">生产完成</a><a href="#" class="in">查看详情</a> 
																
																</c:when>
															</c:choose>
														<label><img src="<%=basePath%>resources/img/zhong.png"><fmt:formatDate value="${orderCustomDemandVo.createTime }" pattern="yyyy-MM-dd  HH:mm:ss " /></label>
													</div>
													<div class="list_right">
														<img src="<%=basePath%>resources/img/yaoyingchao.png">
														<span>金牌管家：<label>姚颖超</label></span> <span><img
															src="<%=basePath%>resources/img/phone.png">13822222222</span>
													</div>
													<div class="clear"></div>
												</li>
											</c:when>
											<c:when test="${orderCustomDemandVo.status == 3 }">弃标</c:when>
											<c:otherwise>淘汰</c:otherwise>
										</c:choose>

									</c:forEach>
									<%-- <li>
										<div class="swwe">
											<img src="<%=basePath%>resources/img/swwe.png">
										</div> <i><img src="<%=basePath%>resources/img/icon_jiao.jpg"></i>
										<div class="list_left">
											<p>
												<span>微创网络科技有限公司</span>受理我的定制需求&nbsp;&nbsp;<img
													src="<%=basePath%>resources/img/list1.png"><img src="<%=basePath%>resources/img/list2.png"><img
													src="<%=basePath%>resources/img/list3.png">&nbsp;&nbsp;职业装 共计200件
											</p>
											<span><label>已选标</label><em>完善合同</em></span> <a href="#">完善合同</a><a
												href="#" class="in">查看详情</a> <label><img
												src="<%=basePath%>resources/img/zhong.png">2016-03-05&nbsp;&nbsp;12:10:30</label>
										</div>
										<div class="list_right">
											<img src="<%=basePath%>resources/img/yaoyingchao.png"> <span>金牌管家：<label>姚颖超</label></span>
											<span><img src="<%=basePath%>resources/img/phone.png">13822222222</span>
										</div>
										<div class="clear"></div>
									</li>
									<li>
										<div class="swwe">
											<img src="<%=basePath%>resources/img/swwe.png">
										</div> <i><img src="<%=basePath%>resources/img/icon_jiao.jpg"></i>
										<div class="list_left">
											<p>
												<span>微创网络科技有限公司</span>为我提供定制服务&nbsp;&nbsp;<img
													src="<%=basePath%>resources/img/list1.png"><img src="<%=basePath%>resources/img/list2.png"><img
													src="<%=basePath%>resources/img/list3.png">&nbsp;&nbsp;职业装 共计200件
											</p>
											<span><label>待客户付定金：￥24000.00元</label>金额：￥60000.00</span> <a
												href="#" class="in">查看详情</a> <label><img
												src="<%=basePath%>resources/img/zhong.png">2016-03-05&nbsp;&nbsp;12:10:30</label>
										</div>
										<div class="list_right">
											<img src="<%=basePath%>resources/img/yaoyingchao.png"> <span>金牌管家：<label>姚颖超</label></span>
											<span><img src="<%=basePath%>resources/img/phone.png">13822222222</span>
										</div>
										<div class="clear"></div>
									</li>
									<li>
										<div class="swwe">
											<img src="<%=basePath%>resources/img/swwe.png">
										</div> <i><img src="<%=basePath%>resources/img/icon_jiao.jpg"></i>
										<div class="list_left">
											<p>
												<span>微创网络科技有限公司</span>为我提供定制服务&nbsp;&nbsp;<img
													src="<%=basePath%>resources/img/list1.png"><img src="<%=basePath%>resources/img/list2.png"><img
													src="<%=basePath%>resources/img/list3.png">&nbsp;&nbsp;职业装 共计200件
											</p>
											<span><label>待客户付定金:￥24000.00元</label>金额：￥60000.00<em>上门量体</em></span>
											<a href="#">指派量体师</a><a href="#" class="in">查看详情</a> <label><img
												src="<%=basePath%>resources/img/zhong.png">2016-03-05&nbsp;&nbsp;12:10:30</label>
										</div>
										<div class="list_right">
											<img src="<%=basePath%>resources/img/yaoyingchao.png"> <span>金牌管家：<label>姚颖超</label></span>
											<span><img src="<%=basePath%>resources/img/phone.png">13822222222</span>
										</div>
										<div class="clear"></div>
									</li>
									<li>
										<div class="swwe">
											<img src="<%=basePath%>resources/img/swwe.png">
										</div> <i><img src="<%=basePath%>resources/img/icon_jiao.jpg"></i>
										<div class="list_left">
											<p>
												<span>微创网络科技有限公司</span>为我提供定制服务&nbsp;&nbsp;<img
													src="<%=basePath%>resources/img/list1.png"><img src="<%=basePath%>resources/img/list2.png"><img
													src="<%=basePath%>resources/img/list3.png">&nbsp;&nbsp;职业装 共计200件
											</p>
											<span><label>待客户付定金:￥24000.00元</label>金额：￥60000.00<em>生产制作</em></span>
											<a href="#">生产完成</a><a href="#" class="in">查看详情</a> <label><img
												src="<%=basePath%>resources/img/zhong.png">2016-03-05&nbsp;&nbsp;12:10:30</label>
										</div>
										<div class="list_right">
											<img src="<%=basePath%>resources/img/yaoyingchao.png"> <span>金牌管家：<label>姚颖超</label></span>
											<span><img src="<%=basePath%>resources/img/phone.png">13822222222</span>
										</div>
										<div class="clear"></div>
									</li>
									<li>
										<div class="swwe">
											<img src="<%=basePath%>resources/img/swwe.png">
										</div> <i><img src="<%=basePath%>resources/img/icon_jiao.jpg"></i>
										<div class="list_left">
											<p>
												<span>微创网络科技有限公司</span>为我提供定制服务&nbsp;&nbsp;<img
													src="<%=basePath%>resources/img/list1.png"><img src="<%=basePath%>resources/img/list2.png"><img
													src="<%=basePath%>resources/img/list3.png">&nbsp;&nbsp;职业装 共计200件
											</p>
											<span><label>待客户付尾款：￥36000.00元</label>金额：￥60000.00<img
												src="<%=basePath%>resources/img/ic1.png">已付定金：￥24000.00</span> <a href="#">生产完成</a><a
												href="#" class="in">查看详情</a> <label><img
												src="<%=basePath%>resources/img/zhong.png">2016-03-05&nbsp;&nbsp;12:10:30</label>
										</div>
										<div class="list_right">
											<img src="<%=basePath%>resources/img/yaoyingchao.png"> <span>金牌管家：<label>姚颖超</label></span>
											<span><img src="<%=basePath%>resources/img/phone.png">13822222222</span>
										</div>
										<div class="clear"></div>
									</li>
									<li>
										<div class="swwe">
											<img src="<%=basePath%>resources/img/swwe.png">
										</div> <i><img src="<%=basePath%>resources/img/icon_jiao.jpg"></i>
										<div class="list_left">
											<p>
												<span>微创网络科技有限公司</span>为我提供定制服务&nbsp;&nbsp;<img
													src="<%=basePath%>resources/img/list1.png"><img src="<%=basePath%>resources/img/list2.png"><img
													src="<%=basePath%>resources/img/list3.png">&nbsp;&nbsp;职业装 共计200件
											</p>
											<span><label>金额：￥24000.00元</label><img
												src="<%=basePath%>resources/img/ic1.png">已支付定金额：￥60000.00<em>待发货</em></span> <a
												href="#">确认发货</a><a href="#" class="in">查看详情</a> <label><img
												src="<%=basePath%>resources/img/zhong.png">2016-03-05&nbsp;&nbsp;12:10:30</label>
										</div>
										<div class="list_right">
											<img src="<%=basePath%>resources/img/yaoyingchao.png"> <span>金牌管家：<label>姚颖超</label></span>
											<span><img src="<%=basePath%>resources/img/phone.png">13822222222</span>
										</div>
										<div class="clear"></div>
									</li> --%>
								</ul>
							</div>
							<div class="clear"></div>
						</div>
						<div class="yj10"></div>
						<div class="custom">
							<img src="<%=basePath%>resources/img/banner1.png">
						</div>
						<div class="yj10"></div>
					</div>
					<div class="clear"></div>
				</div>
			</div>
		</div>
	</div>
	<!-------------------------------------- 内容结束 -------------------------------------->
	<!-------------------------------------- 尾部开始 -------------------------------------->
	<div class="footer">
		<div class="wrap">
			<div class="f_ul">
				<ul>
					<li><span class="span1">6大免费服务承诺</span></li>
					<li><span class="span2">金牌管家专属服务</span></li>
					<li><span class="span3">平台级服务保障</span></li>
				</ul>
			</div>
			<div class="f_nav">
				<ul>
					<li class="list"><span class="span_tit"><a href="#">买家帮助</a></span>
						<a href="#">新手指南</a> <a href="#">服务保障</a> <a href="#">帮助中心</a></li>
					<li class="list"><span class="span_tit"><a href="#">商家帮助</a></span>
						<a href="#">商家入驻</a> <a href="#">商家推广</a> <a href="#">帮助中心</a></li>
					<li class="list"><span class="span_tit"><a href="#">关于我们</a></span>
						<a href="#">关于依服宝</a> <a href="#">联系我们</a> <a href="#">加入依服宝</a></li>
					<li class="list"><span class="span_tit"><a href="#">关注我们</a></span>
						<a href="#" class="a_sina">新浪微博</a> <a href="#" class="a_QQ">QQ空间</a>
						<a href="#" class="a_weibo">腾讯微博</a></li>
					<li class="contant"><span class="phone">400-888-8888</span>
						<p>
							依服宝客服热线<br />周一至周日：09：00-20：00
						</p></li>

					<li class="li_ewm">
						<p>
							<img src="<%=basePath%>resources/img/ewm.png" /> <span>依服宝<br />APP下载
							</span>
						</p>
					</li>
					<li class="li_ewm">
						<p>
							<img src="<%=basePath%>resources/img/ewm.png" /> <span>依服宝<br />微信服务号
							</span>
						</p>
					</li>
				</ul>
			</div>

			<div class="copyright">
				<p>Copyright © 2015 efubao.com 电信与信息服务业务经营许可证100798号 经营性网站备案信息
					京ICP备11031139号 京公网安备110108006045</p>
				<p>客服邮箱：kf@efbao.com 客服电话：4008-888-888 文明办网文明上网举报电话：010-82615762
					违法不良信息举报中心 我最爱的人民警察评选>>反诈骗信息</p>
			</div>
		</div>
	</div>
	<!-------------------------------------- 尾部结束 -------------------------------------->
	<script type="text/javascript" language="javascript">
		// 设置菜单选中项的样式  
		$(function() {
			var temp = $
			{
				status
			}
			;
			if (temp == 2) {
				$("#myul li:nth-child(2)").addClass('on');
			} else if (temp == 140) {
				$("#myul li:nth-child(3)").addClass('on');
			} else if (temp == 160) {
				$("#myul li:nth-child(4)").addClass('on');
			} else if (temp == 170) {
				$("#myul li:nth-child(5)").addClass('on');
			} else if (temp == 200) {
				$("#myul li:nth-child(6)").addClass('on');
			} else {
				$("#myul li:nth-child(1)").addClass('on');
			}
		});
	</script>
</body>
</html>