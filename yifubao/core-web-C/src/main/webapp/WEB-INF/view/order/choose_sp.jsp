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
<title>选择服务商</title>
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
						<p class="leirong_1">所有订单</p>
						<p class="leirong_2">
							<span>订单号：11884720705</span><span>状态：发布需求</span>
						</p>
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

						<%-- <div class="leirong_2">
							<p>
								<span>定制信息</span>
							</p>
						</div>

						<div class="kehuinfo">
							<p>
								<span><img src="<%=basePath%>resources/img/tou_1.png">客户信息</span><label
									class="sem "><a href="#"><img
										src="<%=basePath%>resources/img/iconfont_1.png" />完善信息</a></label>
							</p>
						</div>
						<div class="bor_info">
							<div class="xiqinfo">
								<p>
									<span>姓名</span>：<a id="bespeakName"></a>
								</p>
								<p>
									<span>手机号</span>：<a id="bespeakPhone"></a>
								</p>
							</div>
							<div class="xiqinfo">
								<p>
									<span>企业名称</span>：<a id="companyName"></a>
								</p>
								<p>
									<span>企业地址</span>：<a id="addressDetail"></a>
								</p>
							</div>
							<div class="xiqinfo xiqinfo_1">
								<p>
									<span>定制部门</span>：<a id="customDepartment"></a>
								</p>
								<p>
									<span>量体地址</span>：<a id="orderMeasureAddress"></a>
								</p>
							</div>
						</div>
						<div class="kehuinfo">
							<p>
								<span><img src="<%=basePath%>resources/img/ye_1.png">客户定制需求</span><a href="#"><label
									class="sem "><img src="<%=basePath%>resources/img/iconfont_1.png" />完善定制需求</label></a>
							</p>
						</div>
						<div class="dingzfs">
							<p>
								<span>定制方式</span>：<label class="col">量体定制</label>
							</p>
							<p>
								<span>定制数量</span>：<label class="col" id="customNum"></label>
							</p>
							<p>
								<span>定制预算</span>：<label class="col" id="customBudget"></label>
							</p>
							<p>
								<span>定制周期</span>：<label class="col" id="customCycle"></label>
							</p>
							<p>
								<span>定制品类</span>：<label class="col" id="categoryName"></label>
							</p>
							<p>
								<span>定制属性</span>：<label class="col" id="categoryProperty"></label>
							</p>
							<p>
								<span>商品名称</span>：<label class="col" id="goodsName"><img
									src="<%=basePath%>resources/img/list1.png" /> <a href="#">
										查看商品详情 >></a></label>
							</p>
						</div> --%>
						<jsp:include page="./info.jsp" />
						<div class="kehuinfo">
							<p>
								<span><img src="<%=basePath%>resources/img/ye_2.png">服务商信息</span>
							</p>
						</div>
						<div class="pipeifws">
							<div class="pipeifws_1">
								<p>正在为您匹配服务商，已匹配到${fn:length(orderChooseSpVos)}个服务商</p>
							</div>
							<div class="sanxiang">
								<div class="kuand">
									<c:forEach items="${orderChooseSpVos }" var="orderChooseSpVo">
										<div class="sanfzy">
											<div class="logo_j">
												<img src="<%=basePath%>resources/img/logo4.png" />
											</div>
											<div class="jtext_1">
												<p class="jt_1">${orderChooseSpVo.serviceProvider.name }</p>
												<p>
													<img src="<%=basePath%>resources/img/telp.png" />13822222222
												</p>
											</div>
											<div class="logo_in">
												<p>
													<img src="<%=basePath%>resources/img/ye_3.png" /><span>平台级定制保障</span>
												</p>
											</div>
											<div class="tiaoz">
												<p>
													<a href="#"><u>查看服务商店铺</u></a>
												</p>
											</div>

											<div class="clear"></div>

											<div class="jindut">
												<div class="item jindut_1 on">
													<p>
														<span>1</span><label>报名参与</label>
													</p>
													<div class="item_info">
														<span><fmt:formatDate
																value="${orderChooseSpVo.create_time }"
																pattern="yyyy-MM-dd  HH:mm:ss " /></span><label>已报名参与竞标</label>
													</div>
												</div>
												<div class="item jindut_2 on">
													<p>
														<span>2</span><label>60分钟联系</label>
													</p>
													<div class="item_info">
														<span><fmt:formatDate
																value="${orderChooseSpVo.create_time }"
																pattern="yyyy-MM-dd  HH:mm:ss " /></span><label>已与您联系</label>
														<!-- <a href="#">服务商没有联系我</a> -->
													</div>
												</div>
												<div class="item jindut_3">
													<p>
														<span>3</span><label>中标</label>
													</p>
													<div class="div_btn2">
														<a href="<%=basePath%>order/choose_one_sp?spid=${orderChooseSpVo.serviceProvider.id}&orderNo=${orderChooseSpVo.orderNo}" class="on">选择，签单</a>
														<!-- <a href="#">换一个</a> -->
													</div>
												</div>
												<div class="clear"></div>
											</div>

											<div class="clear"></div>
										</div>
									</c:forEach>
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
							<a href="#">关于依服宝</a> <a href="#">联系我们</a> <a href="#">加入依服宝</a>
						</li>
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
					<p>客服邮箱：kf@efbao.com 客服电话：4008-888-888
						文明办网文明上网举报电话：010-82615762 违法不良信息举报中心 我最爱的人民警察评选>>反诈骗信息</p>
				</div>
			</div>
		</div>
		<!-------------------------------------- 尾部结束 -------------------------------------->
</body>
</html>