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
        <script type="text/javascript" src="js/html5.js"></script>
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
                navText: ["<img src='../img/cur.png' />", "<img src='../img/cur2.png' />"],
                dots: false,
                autoplay: true,
                autoplayTimeout: 8000,
                autoplayHoverPause: true
            })


            $(".item_list").each(function () {
                $(this).find("ul").fadeOut().eq(0).fadeIn();;
            })
            $(".list_toggle").each(function () {
                $(this).find("li").eq(0).addClass("on")
            })
            $(".list_toggle ul li").hover(function () {
                $(this).parent().find("li").removeClass("on");
                $(this).addClass("on");
                $(this).parents(".list").find(".item_list").find("ul").stop().fadeOut(1000).eq($(this).index()).stop().fadeIn(1000);;
                $(this).parents(".list").find(".ul_tagg").stop().fadeOut(1000).eq($(this).index()).stop().fadeIn(1000);;
     
            })

            $(".ul_tagg").hide().eq(0).show();
            $(".art_cont p .input1").click(function () {
                $(this).parent().find("label").stop().slideToggle();
            })
            $(".art_cont p label a").click(function () {
                $(this).parents("p").find(".input1").html($(this).html());
                $(this).parents("p").find("label").slideUp();
            })
        })
    </script>
</head>
<body>
	<!-------------------------------------- 头部开始 -------------------------------------->
	<jsp:include page="/WEB-INF/view/common/goods_header.jsp"></jsp:include>
	<!-------------------------------------- 头部结束 -------------------------------------->
	<!-------------------------------------- 内容开始 -------------------------------------->


	<div class="mainer mainer_index">
		<div class="wrap">
			<div class="banner flt">
				<div class="banner_owl">
					<div class="item">
						<img src="<%=basePath%>resources/img/banner.png" />
					</div>
					<div class="item">
						<img src="<%=basePath%>resources/img/banner.png" />
					</div>
					<div class="item">
						<img src="<%=basePath%>resources/img/banner.png" />
					</div>
				</div>
				<div class="banner_list">
					<ul>
						<li>
							<div class="list">
								<div class="img flt">
									<img src="<%=basePath%>resources/img/img1.png" />
								</div>
								<div class="text">
									<h2>服务承诺</h2>
									<p>6大免费服务</p>
									<p>专业高品质</p>
								</div>
							</div>
						</li>
						<li>
							<div class="list">
								<div class="img flt">
									<img src="<%=basePath%>resources/img/img2.png" />
								</div>
								<div class="text">
									<h2>金牌管家</h2>
									<p>全程监管</p>
									<p>一对一服务</p>
								</div>
							</div>
						</li>
						<li>
							<div class="list">
								<div class="img flt">
									<img src="<%=basePath%>resources/img/img3.png" />
								</div>
								<div class="text">
									<h2>服务保障</h2>
									<p>交易担保</p>
									<p>逾期赔付10%</p>
									<p>免费返修</p>
								</div>
							</div>
						</li>
					</ul>
				</div>
			</div>
			<div class="banner1 frt">
				<div class="article">
					<div class="title">
						<h2>依服宝</h2>
						<span>是做什么的？</span>
						<p>
							依服宝帮助客户找到靠谱专业的<br />职业装定制供应商，<br />为客户提供全程职业装定制保障服务。
						</p>
					</div>
					<div class="art_cont">
					<form id="form_1" name="form_1" action="/core-web-C/publishOrder/createOrder">
						<span class="span_tit"><i>10秒</i>免费预约</span> <span>金牌管家提供专业咨询服务</span>
						<p>
							<input type="text" name="bespeakPhone" placeholder="您的电话" />
						</p>
						<p>
							<input type="text" name="bespeakName" placeholder="您的称呼" />
						</p>
						<p>
							<select name="categoryId" style="width: 150px;">
							<option value="-1" selected="selected">请选择状态</option>
							<c:forEach items="${categorys }" var="list">
							  <option value="${list.id }">${list.name }</option>
							</c:forEach>
                            </select>
						</p>
						<p class="p_btn">
						    <!-- <input type="submit" value="预约定制"> -->
							<a href="javascript:void(0);" onclick="createOrder();">预约定制</a>
						</p>
					</form>
					</div>
				</div>
			</div>
			<div class="clear"></div>
			<div class="page_index">
				<div class="title">
					<h2 class="flt">定制流程</h2>
					<a href="#" class="frt">一分钟了解定制流程</a>
					<div class="clear"></div>
				</div>
				<div class="list_liuc">
					<ul>
						<li>
							<div class="img">
								<img src="<%=basePath%>resources/img/icon7.png" /><i></i>
							</div>
							<div class="text">
								<span><i>1</i>分钟</span>
								<p>预约咨询</p>
							</div>
						</li>
						<li>
							<div class="img">
								<img src="<%=basePath%>resources/img/icon8.png" /><i></i>
							</div>
							<div class="text">
								<span><i>10</i>分钟</span>
								<p>免费报价</p>
							</div>
						</li>
						<li>
							<div class="img">
								<img src="<%=basePath%>resources/img/icon9.png" /><i></i>
							</div>
							<div class="text">
								<span><i>3</i>日内</span>
								<p>免费打样</p>
							</div>
						</li>
						<li>
							<div class="img">
								<img src="<%=basePath%>resources/img/icon10.png" /><i></i>
							</div>
							<div class="text">
								<span><i>1</i>日内</span>
								<p>免费修改</p>
							</div>
						</li>
						<li>
							<div class="img">
								<img src="<%=basePath%>resources/img/icon11.png" /><i></i>
							</div>
							<div class="text">
								<span><i>24</i>小时</span>
								<p>签订合同</p>
							</div>
						</li>
						<li>
							<div class="img">
								<img src="<%=basePath%>resources/img/icon12.png" /><i></i>
							</div>
							<div class="text">
								<span><i>7</i>日内</span>
								<p>免费量体</p>
							</div>
						</li>
						<li>
							<div class="img">
								<img src="<%=basePath%>resources/img/icon13.png" /><i></i>
							</div>
							<div class="text">
								<span><i>15</i>日内</span>
								<p>生产制作</p>
							</div>
						</li>
						<li>
							<div class="img">
								<img src="<%=basePath%>resources/img/icon14.png" /><i></i>
							</div>
							<div class="text">
								<span><i>48</i>小时</span>
								<p>免费发货</p>
							</div>
						</li>
						<li>
							<div class="img">
								<img src="<%=basePath%>resources/img/icon15.png" /><i></i>
							</div>
							<div class="text">
								<span><i>3</i>个月</span>
								<p>免费返修</p>
							</div>
						</li>
						<li>
							<div class="img">
								<img src="<%=basePath%>resources/img/icon16.png" />
							</div>
							<div class="text">
								<span><i>1</i>年内</span>
								<p>免费重做</p>
							</div>
						</li>
					</ul>
				</div>
			</div>

			<div class="page_index page_index_list">
				<div class="title">
					<h2 class="flt">职业装客户案例</h2>
					<div class="clear"></div>
				</div>
				<div class="pro_case">
					<div class="list list1">
						<div class="item on">
							<div class="img1">
								<img src="<%=basePath%>resources/img/img4.png" />
							</div>
							<div class="text">
								<h2>金融/能源行业</h2>
								<p>
									适用于金融行业/能源行业，礼仪着装。<br />统一的套装更能提升公司员工的团队气质，<br />也能体现员工个人端正，大气，成熟的气质。
								</p>
							</div>
						</div>
					</div>
					<div class="list list2">
						<div class="item">
							<div class="img2">
								<img src="<%=basePath%>resources/img/img5.png" />
							</div>
							<div class="text">
								<h2>金融/能源行业</h2>
								<p>
									适用于金融行业/能源行业，礼仪着装。<br />统一的套装更能提升公司员工的团队气质，<br />也能体现员工个人端正，大气，成熟的气质。
								</p>
							</div>
						</div>
						<div class="item">
							<div class="img3">
								<img src="<%=basePath%>resources/img/img6.png" />
							</div>
							<div class="text">
								<h2>金融/能源行业</h2>
								<p>
									适用于金融行业/能源行业，礼仪着装。<br />统一的套装更能提升公司员工的团队气质，<br />也能体现员工个人端正，大气，成熟的气质。
								</p>
							</div>
						</div>
						<div class="item">
							<div class="img4">
								<img src="<%=basePath%>resources/img/img7.png" />
							</div>
							<div class="text">
								<h2>金融/能源行业</h2>
								<p>
									适用于金融行业/能源行业，礼仪着装。<br />统一的套装更能提升公司员工的团队气质，<br />也能体现员工个人端正，大气，成熟的气质。
								</p>
							</div>
						</div>
					</div>
					<div class="list list3">
						<div class="item">
							<div class="img5">
								<img src="<%=basePath%>resources/img/img8.png" />
							</div>
							<div class="text">
								<h2>金融/能源行业</h2>
								<p>
									适用于金融行业/能源行业，礼仪着装。<br />统一的套装更能提升公司员工的团队气质，<br />也能体现员工个人端正，大气，成熟的气质。
								</p>
							</div>
						</div>
						<div class="item">
							<div class="img6">
								<img src="<%=basePath%>resources/img/img9.png" />
							</div>
							<div class="text">
								<h2>金融/能源行业</h2>
								<p>
									适用于金融行业/能源行业，礼仪着装。<br />统一的套装更能提升公司员工的团队气质，<br />也能体现员工个人端正，大气，成熟的气质。
								</p>
							</div>
						</div>
					</div>
					<div class="clear"></div>
				</div>
			</div>

			<div class="page_index pro_list">
				<div class="list">
					<div class="title">
						<h2 class="flt">
							<span class="span1">西服正装</span>
						</h2>
						<div class="list_toggle frt">
							<ul>
								<li><a href="javascript:void(0);">单排扣上衣</a></li>
								<li><a href="javascript:void(0);">双排扣上衣</a></li>
								<li><a href="javascript:void(0);">单件西装</a></li>
								<li><a href="javascript:void(0);">多件套西装</a></li>
								<li><a href="javascript:void(0);">衬衫</a></li>
							</ul>
						</div>
						<div class="clear"></div>
					</div>

					<div class="item_list">
						<ul>
							<li>
								<div class="list">
									<div class="img">
										<a href="#"><img
											src="<%=basePath%>resources/img/img10.png" /></a>
									</div>
									<div class="text">
										<h2>休闲服1</h2>
										<span>适用于休闲娱乐</span>
									</div>
								</div>
							</li>
							<li>
								<div class="list">
									<div class="img">
										<a href="#"><img
											src="<%=basePath%>resources/img/img11.png" /></a>
									</div>
									<span class="span_pos">热销</span>
									<div class="text">
										<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
												899</label> 元起<a href="#" class="">我要定制</a></span>
									</div>
								</div>
							</li>
							<li>
								<div class="list">
									<div class="img">
										<a href="#"><img
											src="<%=basePath%>resources/img/img11.png" /></a>
									</div>
									<div class="text">
										<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
												899</label> 元起<a href="#" class="">我要定制</a></span>
									</div>
								</div>
							</li>
							<li>
								<div class="list">
									<div class="img">
										<a href="#"><img
											src="<%=basePath%>resources/img/img11.png" /></a>
									</div>
									<div class="text">
										<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
												899</label> 元起<a href="#" class="">我要定制</a></span>
									</div>
								</div>
							</li>
						</ul>
						<ul>
							<li>
								<div class="list">
									<div class="img">
										<a href="#"><img
											src="<%=basePath%>resources/img/img10.png" /></a>
									</div>
									<div class="text">
										<h2>休闲服2</h2>
										<span>适用于休闲娱乐</span>
									</div>
								</div>
							</li>
							<li>
								<div class="list">
									<div class="img">
										<a href="#"><img
											src="<%=basePath%>resources/img/img11.png" /></a>
									</div>
									<span class="span_pos">热销</span>
									<div class="text">
										<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
												899</label> 元起<a href="#" class="on">我要定制</a></span>
									</div>
								</div>
							</li>
							<li>
								<div class="list">
									<div class="img">
										<a href="#"><img
											src="<%=basePath%>resources/img/img11.png" /></a>
									</div>
									<div class="text">
										<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
												899</label> 元起<a href="#" class="">我要定制</a></span>
									</div>
								</div>
							</li>
							<li>
								<div class="list">
									<div class="img">
										<a href="#"><img
											src="<%=basePath%>resources/img/img11.png" /></a>
									</div>
									<div class="text">
										<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
												899</label> 元起<a href="#" class="">我要定制</a></span>
									</div>
								</div>
							</li>
						</ul>
						<ul>
							<li>
								<div class="list">
									<div class="img">
										<a href="#"><img
											src="<%=basePath%>resources/img/img10.png" /></a>
									</div>
									<div class="text">
										<h2>休闲服3</h2>
										<span>适用于休闲娱乐</span>
									</div>
								</div>
							</li>
							<li>
								<div class="list">
									<div class="img">
										<a href="#"><img
											src="<%=basePath%>resources/img/img11.png" /></a>
									</div>
									<span class="span_pos">热销</span>
									<div class="text">
										<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
												899</label> 元起<a href="#" class="">我要定制</a></span>
									</div>
								</div>
							</li>
							<li>
								<div class="list">
									<div class="img">
										<a href="#"><img
											src="<%=basePath%>resources/img/img11.png" /></a>
									</div>
									<div class="text">
										<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
												899</label> 元起<a href="#" class="">我要定制</a></span>
									</div>
								</div>
							</li>
							<li>
								<div class="list">
									<div class="img">
										<a href="#"><img
											src="<%=basePath%>resources/img/img11.png" /></a>
									</div>
									<div class="text">
										<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
												899</label> 元起<a href="#" class="">我要定制</a></span>
									</div>
								</div>
							</li>
						</ul>
						<ul>
							<li>
								<div class="list">
									<div class="img">
										<a href="#"><img
											src="<%=basePath%>resources/img/img10.png" /></a>
									</div>
									<div class="text">
										<h2>休闲服4</h2>
										<span>适用于休闲娱乐</span>
									</div>
								</div>
							</li>
							<li>
								<div class="list">
									<div class="img">
										<a href="#"><img
											src="<%=basePath%>resources/img/img11.png" /></a>
									</div>
									<span class="span_pos">热销</span>
									<div class="text">
										<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
												899</label> 元起<a href="#" class="">我要定制</a></span>
									</div>
								</div>
							</li>
							<li>
								<div class="list">
									<div class="img">
										<a href="#"><img
											src="<%=basePath%>resources/img/img11.png" /></a>
									</div>
									<div class="text">
										<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
												899</label> 元起<a href="#" class="">我要定制</a></span>
									</div>
								</div>
							</li>
							<li>
								<div class="list">
									<div class="img">
										<a href="#"><img
											src="<%=basePath%>resources/img/img11.png" /></a>
									</div>
									<div class="text">
										<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
												899</label> 元起<a href="#" class="">我要定制</a></span>
									</div>
								</div>
							</li>
						</ul>
						<ul>
							<li>
								<div class="list">
									<div class="img">
										<a href="#"><img
											src="<%=basePath%>resources/img/img10.png" /></a>
									</div>
									<div class="text">
										<h2>休闲服5</h2>
										<span>适用于休闲娱乐</span>
									</div>
								</div>
							</li>
							<li>
								<div class="list">
									<div class="img">
										<a href="#"><img
											src="<%=basePath%>resources/img/img11.png" /></a>
									</div>
									<span class="span_pos">热销</span>
									<div class="text">
										<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
												899</label> 元起<a href="#" class="">我要定制</a></span>
									</div>
								</div>
							</li>
							<li>
								<div class="list">
									<div class="img">
										<a href="#"><img
											src="<%=basePath%>resources/img/img11.png" /></a>
									</div>
									<div class="text">
										<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
												899</label> 元起<a href="#" class="">我要定制</a></span>
									</div>
								</div>
							</li>
							<li>
								<div class="list">
									<div class="img">
										<a href="#"><img
											src="<%=basePath%>resources/img/img11.png" /></a>
									</div>
									<div class="text">
										<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
												899</label> 元起<a href="#" class="">我要定制</a></span>
									</div>
								</div>
							</li>
						</ul>
					</div>

				</div>

				<div class="list">
					<div class="title">
						<h2 class="flt">
							<span class="span2">休闲服</span>
						</h2>
						<div class="list_toggle frt">
							<ul>
								<li class="on"><a href="javascript:void(0);">单排扣上衣</a></li>
								<li><a href="javascript:void(0);">双排扣上衣</a></li>
								<li><a href="javascript:void(0);">单件西装</a></li>
								<li><a href="javascript:void(0);">多件套西装</a></li>
								<li><a href="javascript:void(0);">衬衫</a></li>
							</ul>
						</div>
						<div class="clear"></div>
					</div>
					<div class="item_list">
						<ul>
							<li>
								<div class="list">
									<div class="img">
										<a href="#"><img
											src="<%=basePath%>resources/img/img10.png" /></a>
									</div>
									<div class="text">
										<h2>休闲服1</h2>
										<span>适用于休闲娱乐</span>
									</div>
								</div>
							</li>
							<li>
								<div class="list">
									<div class="img">
										<a href="#"><img
											src="<%=basePath%>resources/img/img11.png" /></a>
									</div>
									<span class="span_pos">热销</span>
									<div class="text">
										<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
												899</label> 元起<a href="#" class="">我要定制</a></span>
									</div>
								</div>
							</li>
							<li>
								<div class="list">
									<div class="img">
										<a href="#"><img
											src="<%=basePath%>resources/img/img11.png" /></a>
									</div>
									<div class="text">
										<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
												899</label> 元起<a href="#" class="">我要定制</a></span>
									</div>
								</div>
							</li>
							<li>
								<div class="list">
									<div class="img">
										<a href="#"><img
											src="<%=basePath%>resources/img/img11.png" /></a>
									</div>
									<div class="text">
										<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
												899</label> 元起<a href="#" class="">我要定制</a></span>
									</div>
								</div>
							</li>
						</ul>
						<ul>
							<li>
								<div class="list">
									<div class="img">
										<a href="#"><img
											src="<%=basePath%>resources/img/img10.png" /></a>
									</div>
									<div class="text">
										<h2>休闲服2</h2>
										<span>适用于休闲娱乐</span>
									</div>
								</div>
							</li>
							<li>
								<div class="list">
									<div class="img">
										<a href="#"><img
											src="<%=basePath%>resources/img/img11.png" /></a>
									</div>
									<span class="span_pos">热销</span>
									<div class="text">
										<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
												899</label> 元起<a href="#" class="">我要定制</a></span>
									</div>
								</div>
							</li>
							<li>
								<div class="list">
									<div class="img">
										<a href="#"><img
											src="<%=basePath%>resources/img/img11.png" /></a>
									</div>
									<div class="text">
										<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
												899</label> 元起<a href="#" class="">我要定制</a></span>
									</div>
								</div>
							</li>
							<li>
								<div class="list">
									<div class="img">
										<a href="#"><img
											src="<%=basePath%>resources/img/img11.png" /></a>
									</div>
									<div class="text">
										<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
												899</label> 元起<a href="#" class="">我要定制</a></span>
									</div>
								</div>
							</li>
						</ul>
						<ul>
							<li>
								<div class="list">
									<div class="img">
										<a href="#"><img
											src="<%=basePath%>resources/img/img10.png" /></a>
									</div>
									<div class="text">
										<h2>休闲服3</h2>
										<span>适用于休闲娱乐</span>
									</div>
								</div>
							</li>
							<li>
								<div class="list">
									<div class="img">
										<a href="#"><img
											src="<%=basePath%>resources/img/img11.png" /></a>
									</div>
									<span class="span_pos">热销</span>
									<div class="text">
										<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
												899</label> 元起<a href="#" class="">我要定制</a></span>
									</div>
								</div>
							</li>
							<li>
								<div class="list">
									<div class="img">
										<a href="#"><img
											src="<%=basePath%>resources/img/img11.png" /></a>
									</div>
									<div class="text">
										<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
												899</label> 元起<a href="#" class="">我要定制</a></span>
									</div>
								</div>
							</li>
							<li>
								<div class="list">
									<div class="img">
										<a href="#"><img
											src="<%=basePath%>resources/img/img11.png" /></a>
									</div>
									<div class="text">
										<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
												899</label> 元起<a href="#" class="">我要定制</a></span>
									</div>
								</div>
							</li>
						</ul>
						<ul>
							<li>
								<div class="list">
									<div class="img">
										<a href="#"><img
											src="<%=basePath%>resources/img/img10.png" /></a>
									</div>
									<div class="text">
										<h2>休闲服4</h2>
										<span>适用于休闲娱乐</span>
									</div>
								</div>
							</li>
							<li>
								<div class="list">
									<div class="img">
										<a href="#"><img
											src="<%=basePath%>resources/img/img11.png" /></a>
									</div>
									<span class="span_pos">热销</span>
									<div class="text">
										<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
												899</label> 元起<a href="#" class="">我要定制</a></span>
									</div>
								</div>
							</li>
							<li>
								<div class="list">
									<div class="img">
										<a href="#"><img
											src="<%=basePath%>resources/img/img11.png" /></a>
									</div>
									<div class="text">
										<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
												899</label> 元起<a href="#" class="">我要定制</a></span>
									</div>
								</div>
							</li>
							<li>
								<div class="list">
									<div class="img">
										<a href="#"><img
											src="<%=basePath%>resources/img/img11.png" /></a>
									</div>
									<div class="text">
										<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
												899</label> 元起<a href="#" class="">我要定制</a></span>
									</div>
								</div>
							</li>
						</ul>
						<ul>
							<li>
								<div class="list">
									<div class="img">
										<a href="#"><img
											src="<%=basePath%>resources/img/img10.png" /></a>
									</div>
									<div class="text">
										<h2>休闲服5</h2>
										<span>适用于休闲娱乐</span>
									</div>
								</div>
							</li>
							<li>
								<div class="list">
									<div class="img">
										<a href="#"><img
											src="<%=basePath%>resources/img/img11.png" /></a>
									</div>
									<span class="span_pos">热销</span>
									<div class="text">
										<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
												899</label> 元起<a href="#" class="">我要定制</a></span>
									</div>
								</div>
							</li>
							<li>
								<div class="list">
									<div class="img">
										<a href="#"><img
											src="<%=basePath%>resources/img/img11.png" /></a>
									</div>
									<div class="text">
										<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
												899</label> 元起<a href="#" class="">我要定制</a></span>
									</div>
								</div>
							</li>
							<li>
								<div class="list">
									<div class="img">
										<a href="#"><img
											src="<%=basePath%>resources/img/img11.png" /></a>
									</div>
									<div class="text">
										<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
												899</label> 元起<a href="#" class="">我要定制</a></span>
									</div>
								</div>
							</li>
						</ul>
					</div>
				</div>

				<div class="list">
					<div class="title">
						<h2 class="flt">
							<span class="span3">工程服</span>
						</h2>
						<div class="list_toggle frt">
							<ul>
								<li><a href="javascript:void(0);">单排扣上衣</a></li>
								<li><a href="javascript:void(0);">双排扣上衣</a></li>
								<li><a href="javascript:void(0);">单件西装</a></li>
								<li><a href="javascript:void(0);">多件套西装</a></li>
								<li><a href="javascript:void(0);">衬衫</a></li>
							</ul>
						</div>
						<div class="clear"></div>
					</div>
					<div class="item_list">
						<div class="item_list">
							<ul>
								<li>
									<div class="list">
										<div class="img">
											<a href="#"><img
												src="<%=basePath%>resources/img/img10.png" /></a>
										</div>
										<div class="text">
											<h2>休闲服1</h2>
											<span>适用于休闲娱乐</span>
										</div>
									</div>
								</li>
								<li>
									<div class="list">
										<div class="img">
											<a href="#"><img
												src="<%=basePath%>resources/img/img11.png" /></a>
										</div>
										<span class="span_pos">热销</span>
										<div class="text">
											<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
													899</label> 元起<a href="#" class="">我要定制</a></span>
										</div>
									</div>
								</li>
								<li>
									<div class="list">
										<div class="img">
											<a href="#"><img
												src="<%=basePath%>resources/img/img11.png" /></a>
										</div>
										<div class="text">
											<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
													899</label> 元起<a href="#" class="">我要定制</a></span>
										</div>
									</div>
								</li>
								<li>
									<div class="list">
										<div class="img">
											<a href="#"><img
												src="<%=basePath%>resources/img/img11.png" /></a>
										</div>
										<div class="text">
											<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
													899</label> 元起<a href="#" class="">我要定制</a></span>
										</div>
									</div>
								</li>
							</ul>
							<ul>
								<li>
									<div class="list">
										<div class="img">
											<a href="#"><img
												src="<%=basePath%>resources/img/img10.png" /></a>
										</div>
										<div class="text">
											<h2>休闲服2</h2>
											<span>适用于休闲娱乐</span>
										</div>
									</div>
								</li>
								<li>
									<div class="list">
										<div class="img">
											<a href="#"><img
												src="<%=basePath%>resources/img/img11.png" /></a>
										</div>
										<span class="span_pos">热销</span>
										<div class="text">
											<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
													899</label> 元起<a href="#" class="">我要定制</a></span>
										</div>
									</div>
								</li>
								<li>
									<div class="list">
										<div class="img">
											<a href="#"><img
												src="<%=basePath%>resources/img/img11.png" /></a>
										</div>
										<div class="text">
											<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
													899</label> 元起<a href="#" class="">我要定制</a></span>
										</div>
									</div>
								</li>
								<li>
									<div class="list">
										<div class="img">
											<a href="#"><img
												src="<%=basePath%>resources/img/img11.png" /></a>
										</div>
										<div class="text">
											<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
													899</label> 元起<a href="#" class="">我要定制</a></span>
										</div>
									</div>
								</li>
							</ul>
							<ul>
								<li>
									<div class="list">
										<div class="img">
											<a href="#"><img
												src="<%=basePath%>resources/img/img10.png" /></a>
										</div>
										<div class="text">
											<h2>休闲服3</h2>
											<span>适用于休闲娱乐</span>
										</div>
									</div>
								</li>
								<li>
									<div class="list">
										<div class="img">
											<a href="#"><img
												src="<%=basePath%>resources/img/img11.png" /></a>
										</div>
										<span class="span_pos">热销</span>
										<div class="text">
											<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
													899</label> 元起<a href="#" class="">我要定制</a></span>
										</div>
									</div>
								</li>
								<li>
									<div class="list">
										<div class="img">
											<a href="#"><img
												src="<%=basePath%>resources/img/img11.png" /></a>
										</div>
										<div class="text">
											<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
													899</label> 元起<a href="#" class="">我要定制</a></span>
										</div>
									</div>
								</li>
								<li>
									<div class="list">
										<div class="img">
											<a href="#"><img
												src="<%=basePath%>resources/img/img11.png" /></a>
										</div>
										<div class="text">
											<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
													899</label> 元起<a href="#" class="">我要定制</a></span>
										</div>
									</div>
								</li>
							</ul>
							<ul>
								<li>
									<div class="list">
										<div class="img">
											<a href="#"><img
												src="<%=basePath%>resources/img/img10.png" /></a>
										</div>
										<div class="text">
											<h2>休闲服4</h2>
											<span>适用于休闲娱乐</span>
										</div>
									</div>
								</li>
								<li>
									<div class="list">
										<div class="img">
											<a href="#"><img
												src="<%=basePath%>resources/img/img11.png" /></a>
										</div>
										<span class="span_pos">热销</span>
										<div class="text">
											<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
													899</label> 元起<a href="#" class="">我要定制</a></span>
										</div>
									</div>
								</li>
								<li>
									<div class="list">
										<div class="img">
											<a href="#"><img
												src="<%=basePath%>resources/img/img11.png" /></a>
										</div>
										<div class="text">
											<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
													899</label> 元起<a href="#" class="">我要定制</a></span>
										</div>
									</div>
								</li>
								<li>
									<div class="list">
										<div class="img">
											<a href="#"><img
												src="<%=basePath%>resources/img/img11.png" /></a>
										</div>
										<div class="text">
											<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
													899</label> 元起<a href="#" class="">我要定制</a></span>
										</div>
									</div>
								</li>
							</ul>
							<ul>
								<li>
									<div class="list">
										<div class="img">
											<a href="#"><img
												src="<%=basePath%>resources/img/img10.png" /></a>
										</div>
										<div class="text">
											<h2>休闲服5</h2>
											<span>适用于休闲娱乐</span>
										</div>
									</div>
								</li>
								<li>
									<div class="list">
										<div class="img">
											<a href="#"><img
												src="<%=basePath%>resources/img/img11.png" /></a>
										</div>
										<span class="span_pos">热销</span>
										<div class="text">
											<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
													899</label> 元起<a href="#" class="">我要定制</a></span>
										</div>
									</div>
								</li>
								<li>
									<div class="list">
										<div class="img">
											<a href="#"><img
												src="<%=basePath%>resources/img/img11.png" /></a>
										</div>
										<div class="text">
											<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
													899</label> 元起<a href="#" class="">我要定制</a></span>
										</div>
									</div>
								</li>
								<li>
									<div class="list">
										<div class="img">
											<a href="#"><img
												src="<%=basePath%>resources/img/img11.png" /></a>
										</div>
										<div class="text">
											<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
													899</label> 元起<a href="#" class="">我要定制</a></span>
										</div>
									</div>
								</li>
							</ul>
						</div>
					</div>
				</div>

				<div class="list">
					<div class="title">
						<h2 class="flt">
							<span class="span4">防寒服</span>
						</h2>
						<div class="list_toggle frt">
							<ul>
								<li><a href="javascript:void(0);">单排扣上衣</a></li>
								<li><a href="javascript:void(0);">双排扣上衣</a></li>
								<li><a href="javascript:void(0);">单件西装</a></li>
								<li><a href="javascript:void(0);">多件套西装</a></li>
								<li><a href="javascript:void(0);">衬衫</a></li>
							</ul>
						</div>
						<div class="clear"></div>
					</div>
					<div class="item_list">
						<div class="item_list">
							<ul>
								<li>
									<div class="list">
										<div class="img">
											<a href="#"><img
												src="<%=basePath%>resources/img/img10.png" /></a>
										</div>
										<div class="text">
											<h2>休闲服1</h2>
											<span>适用于休闲娱乐</span>
										</div>
									</div>
								</li>
								<li>
									<div class="list">
										<div class="img">
											<a href="#"><img
												src="<%=basePath%>resources/img/img11.png" /></a>
										</div>
										<span class="span_pos">热销</span>
										<div class="text">
											<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
													899</label> 元起<a href="#" class="">我要定制</a></span>
										</div>
									</div>
								</li>
								<li>
									<div class="list">
										<div class="img">
											<a href="#"><img
												src="<%=basePath%>resources/img/img11.png" /></a>
										</div>
										<div class="text">
											<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
													899</label> 元起<a href="#" class="">我要定制</a></span>
										</div>
									</div>
								</li>
								<li>
									<div class="list">
										<div class="img">
											<a href="#"><img
												src="<%=basePath%>resources/img/img11.png" /></a>
										</div>
										<div class="text">
											<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
													899</label> 元起<a href="#" class="">我要定制</a></span>
										</div>
									</div>
								</li>
							</ul>
							<ul>
								<li>
									<div class="list">
										<div class="img">
											<a href="#"><img
												src="<%=basePath%>resources/img/img10.png" /></a>
										</div>
										<div class="text">
											<h2>休闲服2</h2>
											<span>适用于休闲娱乐</span>
										</div>
									</div>
								</li>
								<li>
									<div class="list">
										<div class="img">
											<a href="#"><img
												src="<%=basePath%>resources/img/img11.png" /></a>
										</div>
										<span class="span_pos">热销</span>
										<div class="text">
											<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
													899</label> 元起<a href="#" class="">我要定制</a></span>
										</div>
									</div>
								</li>
								<li>
									<div class="list">
										<div class="img">
											<a href="#"><img
												src="<%=basePath%>resources/img/img11.png" /></a>
										</div>
										<div class="text">
											<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
													899</label> 元起<a href="#" class="">我要定制</a></span>
										</div>
									</div>
								</li>
								<li>
									<div class="list">
										<div class="img">
											<a href="#"><img
												src="<%=basePath%>resources/img/img11.png" /></a>
										</div>
										<div class="text">
											<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
													899</label> 元起<a href="#" class="">我要定制</a></span>
										</div>
									</div>
								</li>
							</ul>
							<ul>
								<li>
									<div class="list">
										<div class="img">
											<a href="#"><img
												src="<%=basePath%>resources/img/img10.png" /></a>
										</div>
										<div class="text">
											<h2>休闲服3</h2>
											<span>适用于休闲娱乐</span>
										</div>
									</div>
								</li>
								<li>
									<div class="list">
										<div class="img">
											<a href="#"><img
												src="<%=basePath%>resources/img/img11.png" /></a>
										</div>
										<span class="span_pos">热销</span>
										<div class="text">
											<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
													899</label> 元起<a href="#" class="">我要定制</a></span>
										</div>
									</div>
								</li>
								<li>
									<div class="list">
										<div class="img">
											<a href="#"><img
												src="<%=basePath%>resources/img/img11.png" /></a>
										</div>
										<div class="text">
											<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
													899</label> 元起<a href="#" class="">我要定制</a></span>
										</div>
									</div>
								</li>
								<li>
									<div class="list">
										<div class="img">
											<a href="#"><img
												src="<%=basePath%>resources/img/img11.png" /></a>
										</div>
										<div class="text">
											<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
													899</label> 元起<a href="#" class="">我要定制</a></span>
										</div>
									</div>
								</li>
							</ul>
							<ul>
								<li>
									<div class="list">
										<div class="img">
											<a href="#"><img
												src="<%=basePath%>resources/img/img10.png" /></a>
										</div>
										<div class="text">
											<h2>休闲服4</h2>
											<span>适用于休闲娱乐</span>
										</div>
									</div>
								</li>
								<li>
									<div class="list">
										<div class="img">
											<a href="#"><img
												src="<%=basePath%>resources/img/img11.png" /></a>
										</div>
										<span class="span_pos">热销</span>
										<div class="text">
											<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
													899</label> 元起<a href="#" class="">我要定制</a></span>
										</div>
									</div>
								</li>
								<li>
									<div class="list">
										<div class="img">
											<a href="#"><img
												src="<%=basePath%>resources/img/img11.png" /></a>
										</div>
										<div class="text">
											<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
													899</label> 元起<a href="#" class="">我要定制</a></span>
										</div>
									</div>
								</li>
								<li>
									<div class="list">
										<div class="img">
											<a href="#"><img
												src="<%=basePath%>resources/img/img11.png" /></a>
										</div>
										<div class="text">
											<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
													899</label> 元起<a href="#" class="">我要定制</a></span>
										</div>
									</div>
								</li>
							</ul>
							<ul>
								<li>
									<div class="list">
										<div class="img">
											<a href="#"><img
												src="<%=basePath%>resources/img/img10.png" /></a>
										</div>
										<div class="text">
											<h2>休闲服5</h2>
											<span>适用于休闲娱乐</span>
										</div>
									</div>
								</li>
								<li>
									<div class="list">
										<div class="img">
											<a href="#"><img
												src="<%=basePath%>resources/img/img11.png" /></a>
										</div>
										<span class="span_pos">热销</span>
										<div class="text">
											<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
													899</label> 元起<a href="#" class="">我要定制</a></span>
										</div>
									</div>
								</li>
								<li>
									<div class="list">
										<div class="img">
											<a href="#"><img
												src="<%=basePath%>resources/img/img11.png" /></a>
										</div>
										<div class="text">
											<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
													899</label> 元起<a href="#" class="">我要定制</a></span>
										</div>
									</div>
								</li>
								<li>
									<div class="list">
										<div class="img">
											<a href="#"><img
												src="<%=basePath%>resources/img/img11.png" /></a>
										</div>
										<div class="text">
											<a href="#">2016春夏男士三粒扣高级定制商务款……</a> <span><label>￥
													899</label> 元起<a href="#" class="">我要定制</a></span>
										</div>
									</div>
								</li>
							</ul>
						</div>
					</div>
				</div>

				<div class="list">
					<div class="title">
						<h2 class="flt">服务保障</h2>

						<div class="clear"></div>
					</div>
					<div class="div_baoz">
						<div class="bz_left flt">
							<i></i>
							<div class="img">
								<img src="<%=basePath%>resources/img/icon18.png" />
							</div>
							<h2>定制宝</h2>
							<p>
								全面为客户提供<br />3大职业装定制服务保障
							</p>
						</div>
						<div class="bz_list">
							<ul>
								<li>
									<div class="list">
										<div class="img flt">
											<img src="<%=basePath%>resources/img/img12.png">
										</div>
										<div class="text">
											<h2>交易担保</h2>
											<p>交易担保</p>
											<p>满意付款</p>
										</div>
									</div>
								</li>
								<li>
									<div class="list">
										<div class="img flt">
											<img src="<%=basePath%>resources/img/img13.png">
										</div>
										<div class="text">
											<h2>履约保证</h2>
											<p>未按时交付</p>
											<p>先行赔付10%</p>
										</div>
									</div>
								</li>
								<li>
									<div class="list">
										<div class="img flt">
											<img src="<%=basePath%>resources/img/img14.png">
										</div>
										<div class="text">
											<h2>服务保证</h2>
											<p>免费返修</p>
											<p>不合格重新制作</p>
										</div>
									</div>
								</li>
							</ul>
						</div>
						<div class="clear"></div>
					</div>
				</div>

				<div class="list">
					<div class="title">
						<h2 class="flt">优质服务商</h2>
						<div class="list_toggle frt">
							<ul>
								<li><a href="javascript:void(0);">西服正装</a></li>
								<li><a href="javascript:void(0);">休闲服</a></li>
								<li><a href="javascript:void(0);">工程服</a></li>
								<li><a href="javascript:void(0);">防寒服</a></li>
							</ul>
						</div>
						<div class="clear"></div>
					</div>
					<div class="item_list item_list1">
						<div class="ul_tagg">
							<div class="item_list_owl">
								<div class="item_owl">
									<div class="item">
										<div class="img">
											<img src="<%=basePath%>resources/img/img15.png" />
										</div>
										<div class="text">
											<p class="title">
												<a href="<%=basePath%>sp/spInfo?id=1">红豆制衣</a><span class="pingfe frt"><i
													class="i3"></i>3.0</span>
											</p>
											<p class="tips">
												<span>高端定制</span><span>量体定制</span><span>标准定制</span>
											</p>
											<p class="desc">已为100多家企业提供专业优质的职业装定制服务</p>
										</div>
									</div>
									
									<div class="item">
										<div class="img">
											<img src="<%=basePath%>resources/img/img15.png" />
										</div>
										<div class="text">
											<p class="title">
												<a href="#">红豆制衣</a><span class="pingfe frt"><i
													class="i3"></i>3.0</span>
											</p>
											<p class="tips">
												<span>高端定制</span><span>量体定制</span><span>标准定制</span>
											</p>
											<p class="desc">已为100多家企业提供专业优质的职业装定制服务</p>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="ul_tagg">
							<div class="item_list_owl">
								<div class="item_owl">
									<div class="item">
										<div class="img">
											<img src="<%=basePath%>resources/img/img15.png" />
										</div>
										<div class="text">
											<p class="title">
												<a href="#">红豆制衣</a><span class="pingfe frt"><i
													class="i3"></i>3.0</span>
											</p>
											<p class="tips">
												<span>高端定制</span><span>量体定制</span><span>标准定制</span>
											</p>
											<p class="desc">已为100多家企业提供专业优质的职业装定制服务</p>
										</div>
									</div>
									<div class="item">
										<div class="img">
											<img src="<%=basePath%>resources/img/img15.png" />
										</div>
										<div class="text">
											<p class="title">
												<a href="#">红豆制衣</a><span class="pingfe frt"><i
													class="i3"></i>3.0</span>
											</p>
											<p class="tips">
												<span>高端定制</span><span>量体定制</span><span>标准定制</span>
											</p>
											<p class="desc">已为100多家企业提供专业优质的职业装定制服务</p>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="ul_tagg">
							<div class="item_list_owl">
								<div class="item_owl">
									<div class="item">
										<div class="img">
											<img src="<%=basePath%>resources/img/img15.png" />
										</div>
										<div class="text">
											<p class="title">
												<a href="#">红豆制衣</a><span class="pingfe frt"><i
													class="i3"></i>3.0</span>
											</p>
											<p class="tips">
												<span>高端定制</span><span>量体定制</span><span>标准定制</span>
											</p>
											<p class="desc">已为100多家企业提供专业优质的职业装定制服务</p>
										</div>
									</div>
									<div class="item">
										<div class="img">
											<img src="<%=basePath%>resources/img/img15.png" />
										</div>
										<div class="text">
											<p class="title">
												<a href="#">红豆制衣</a><span class="pingfe frt"><i
													class="i3"></i>3.0</span>
											</p>
											<p class="tips">
												<span>高端定制</span><span>量体定制</span><span>标准定制</span>
											</p>
											<p class="desc">已为100多家企业提供专业优质的职业装定制服务</p>
										</div>
									</div>
									<div class="item">
										<div class="img">
											<img src="<%=basePath%>resources/img/img15.png" />
										</div>
										<div class="text">
											<p class="title">
												<a href="#">红豆制衣</a><span class="pingfe frt"><i
													class="i3"></i>3.0</span>
											</p>
											<p class="tips">
												<span>高端定制</span><span>量体定制</span><span>标准定制</span>
											</p>
											<p class="desc">已为100多家企业提供专业优质的职业装定制服务</p>
										</div>
									</div>
									<div class="item">
										<div class="img">
											<img src="<%=basePath%>resources/img/img15.png" />
										</div>
										<div class="text">
											<p class="title">
												<a href="#">红豆制衣</a><span class="pingfe frt"><i
													class="i3"></i>3.0</span>
											</p>
											<p class="tips">
												<span>高端定制</span><span>量体定制</span><span>标准定制</span>
											</p>
											<p class="desc">已为100多家企业提供专业优质的职业装定制服务</p>
										</div>
									</div>
									<div class="item">
										<div class="img">
											<img src="<%=basePath%>resources/img/img15.png" />
										</div>
										<div class="text">
											<p class="title">
												<a href="#">红豆制衣</a><span class="pingfe frt"><i
													class="i3"></i>3.0</span>
											</p>
											<p class="tips">
												<span>高端定制</span><span>量体定制</span><span>标准定制</span>
											</p>
											<p class="desc">已为100多家企业提供专业优质的职业装定制服务</p>
										</div>
									</div>
									<div class="item">
										<div class="img">
											<img src="<%=basePath%>resources/img/img15.png" />
										</div>
										<div class="text">
											<p class="title">
												<a href="#">红豆制衣</a><span class="pingfe frt"><i
													class="i3"></i>3.0</span>
											</p>
											<p class="tips">
												<span>高端定制</span><span>量体定制</span><span>标准定制</span>
											</p>
											<p class="desc">已为100多家企业提供专业优质的职业装定制服务</p>
										</div>
									</div>
									<div class="item">
										<div class="img">
											<img src="<%=basePath%>resources/img/img15.png" />
										</div>
										<div class="text">
											<p class="title">
												<a href="#">红豆制衣</a><span class="pingfe frt"><i
													class="i3"></i>3.0</span>
											</p>
											<p class="tips">
												<span>高端定制</span><span>量体定制</span><span>标准定制</span>
											</p>
											<p class="desc">已为100多家企业提供专业优质的职业装定制服务</p>
										</div>
									</div>
									<div class="item">
										<div class="img">
											<img src="<%=basePath%>resources/img/img15.png" />
										</div>
										<div class="text">
											<p class="title">
												<a href="#">红豆制衣</a><span class="pingfe frt"><i
													class="i3"></i>3.0</span>
											</p>
											<p class="tips">
												<span>高端定制</span><span>量体定制</span><span>标准定制</span>
											</p>
											<p class="desc">已为100多家企业提供专业优质的职业装定制服务</p>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="ul_tagg">
							<div class="item_list_owl">
								<div class="item_owl">
									<div class="item">
										<div class="img">
											<img src="<%=basePath%>resources/img/img15.png" />
										</div>
										<div class="text">
											<p class="title">
												<a href="#">红豆制衣</a><span class="pingfe frt"><i
													class="i3"></i>3.0</span>
											</p>
											<p class="tips">
												<span>高端定制</span><span>量体定制</span><span>标准定制</span>
											</p>
											<p class="desc">已为100多家企业提供专业优质的职业装定制服务</p>
										</div>
									</div>
									<div class="item">
										<div class="img">
											<img src="<%=basePath%>resources/img/img15.png" />
										</div>
										<div class="text">
											<p class="title">
												<a href="#">红豆制衣</a><span class="pingfe frt"><i
													class="i3"></i>3.0</span>
											</p>
											<p class="tips">
												<span>高端定制</span><span>量体定制</span><span>标准定制</span>
											</p>
											<p class="desc">已为100多家企业提供专业优质的职业装定制服务</p>
										</div>
									</div>
									<div class="item">
										<div class="img">
											<img src="<%=basePath%>resources/img/img15.png" />
										</div>
										<div class="text">
											<p class="title">
												<a href="#">红豆制衣</a><span class="pingfe frt"><i
													class="i3"></i>3.0</span>
											</p>
											<p class="tips">
												<span>高端定制</span><span>量体定制</span><span>标准定制</span>
											</p>
											<p class="desc">已为100多家企业提供专业优质的职业装定制服务</p>
										</div>
									</div>
									<div class="item">
										<div class="img">
											<img src="<%=basePath%>resources/img/img15.png" />
										</div>
										<div class="text">
											<p class="title">
												<a href="#">红豆制衣</a><span class="pingfe frt"><i
													class="i3"></i>3.0</span>
											</p>
											<p class="tips">
												<span>高端定制</span><span>量体定制</span><span>标准定制</span>
											</p>
											<p class="desc">已为100多家企业提供专业优质的职业装定制服务</p>
										</div>
									</div>
									<div class="item">
										<div class="img">
											<img src="<%=basePath%>resources/img/img15.png" />
										</div>
										<div class="text">
											<p class="title">
												<a href="#">红豆制衣</a><span class="pingfe frt"><i
													class="i3"></i>3.0</span>
											</p>
											<p class="tips">
												<span>高端定制</span><span>量体定制</span><span>标准定制</span>
											</p>
											<p class="desc">已为100多家企业提供专业优质的职业装定制服务</p>
										</div>
									</div>
									<div class="item">
										<div class="img">
											<img src="<%=basePath%>resources/img/img15.png" />
										</div>
										<div class="text">
											<p class="title">
												<a href="#">红豆制衣</a><span class="pingfe frt"><i
													class="i3"></i>3.0</span>
											</p>
											<p class="tips">
												<span>高端定制</span><span>量体定制</span><span>标准定制</span>
											</p>
											<p class="desc">已为100多家企业提供专业优质的职业装定制服务</p>
										</div>
									</div>
									<div class="item">
										<div class="img">
											<img src="<%=basePath%>resources/img/img15.png" />
										</div>
										<div class="text">
											<p class="title">
												<a href="#">红豆制衣</a><span class="pingfe frt"><i
													class="i3"></i>3.0</span>
											</p>
											<p class="tips">
												<span>高端定制</span><span>量体定制</span><span>标准定制</span>
											</p>
											<p class="desc">已为100多家企业提供专业优质的职业装定制服务</p>
										</div>
									</div>
									<div class="item">
										<div class="img">
											<img src="<%=basePath%>resources/img/img15.png" />
										</div>
										<div class="text">
											<p class="title">
												<a href="#">红豆制衣</a><span class="pingfe frt"><i
													class="i3"></i>3.0</span>
											</p>
											<p class="tips">
												<span>高端定制</span><span>量体定制</span><span>标准定制</span>
											</p>
											<p class="desc">已为100多家企业提供专业优质的职业装定制服务</p>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>


				<div class="list">
					<div class="title">
						<h2 class="flt">我们的客户</h2>
						<div class="clear"></div>
					</div>
					<div class="link">
						<ul>
							<li><div class="img">
									<img src="<%=basePath%>resources/img/link.png" />
								</div></li>
							<li><div class="img">
									<img src="<%=basePath%>resources/img/link.png" />
								</div></li>
							<li><div class="img">
									<img src="<%=basePath%>resources/img/link.png" />
								</div></li>
							<li><div class="img">
									<img src="<%=basePath%>resources/img/link.png" />
								</div></li>
							<li><div class="img">
									<img src="<%=basePath%>resources/img/link.png" />
								</div></li>
							<li><div class="img">
									<img src="<%=basePath%>resources/img/link.png" />
								</div></li>
							<li><div class="img">
									<img src="<%=basePath%>resources/img/link.png" />
								</div></li>
							<li><div class="img">
									<img src="<%=basePath%>resources/img/link.png" />
								</div></li>
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
	<jsp:include page="/WEB-INF/view/common/float.jsp"></jsp:include>
</body>
</html>