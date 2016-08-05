<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title>订单列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<!--header-->
	<%@ include file="/WEB-INF/view/common/header.jsp"%>
	<!--header end-->
	<!--content-->

	<div class="cont">
		<div class="w">
			<div class="cf">
				<ul class="cfr mode-filter">
					<li><strong>商品名称：</strong> <input type="text"
						class="text-input" value="" placeholder="请输入商品名称"></li>
					<li><strong>订单编号： </strong> <input type="text"
						class="text-input" value="" placeholder="请输入订单编号"></li>
					<li><strong>起止日期： </strong> <input id="datepicker-example1-1"
						type="text">至 <input id="datepicker-example1-2"
						type="text"></li>
				</ul>
				<ul class="cfr mode-filter">
					<li>&nbsp;&nbsp;&nbsp;<strong>服务商：</strong>&nbsp; <input
						type="text" class="text-input" value="" placeholder="请输入服务商名称">
					</li>
					<li>&nbsp;&nbsp;&nbsp;<strong>收货人： </strong> <input
						type="text" class="text-input" value="" placeholder="请输入收货人名称">
					</li>
					<li><strong>订单状态： </strong> <select class=""
						style="width: 120px;">
							<option value="" selected="true">1</option>
							<option value="">2</option>
					</select></li>
					<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="button"
						value="搜索" tabindex="12" class="export" />
					</li>
				</ul>
			</div>
			<div class="wrap">
				<div class="order">
					<div class="order_title">
						<span>订单管理</span>
						<ul>
							<li class="on"><a>全部订单</a></li>
							<li><a>待受理（2）</a></li>
							<li><a>待拍单（20）</a></li>
							<li><a>已完成（10）</a></li>
							<li><a>已取消</a></li>
							<li><a>待结算</a></li>
							<li><a>已结算</a></li>
						</ul>
						<div class="clear"></div>
					</div>
					<div class="order_content">
						<div class="con_right">
							<ul>
								<c:forEach items="${orderInfoList }" var="orderInfo">
									<li>
										<div class="swwe">
											<img src="<%=basePath%>resources/images/swwe.png">
										</div> <i><img src="<%=basePath%>resources/images/icon_jiao.jpg"></i>
										<c:choose>
											<c:when test="${orderInfo.status==100}">
												<div class="list_left">
													<p>
														<span>${orderInfo.orderCustomerInfo.bespeakName }</span>发布了定制服务需求&nbsp;&nbsp;<img
															src="<%=basePath%>resources/images/list1.png"><img
															src="<%=basePath%>resources/images/list2.png"><img
															src="<%=basePath%>resources/images/list3.png">&nbsp;&nbsp;${orderInfo.orderCustomDemand.categoryName }
														共计${orderInfo.orderCustomDemand.customNum }件
													</p>
													<span></span> <a>管家受理</a> <label><img
														src="<%=basePath%>resources/images/zhong.png">
													<fmt:formatDate value="${orderInfo.createTime }"
															pattern="yyyy-MM-dd  HH:mm:ss " /> <img
														src="<%=basePath%>resources/images/back_1.png"><font
														color="red">10分30秒</font></label>
												</div>
												<div class="list_right">
													<div>
														<a href="<%=basePath%>order/orderDetail?orderNo=${orderInfo.orderNo }">受理需求</a>
													</div>
												</div>
											</c:when>
											<c:when test="${orderInfo.status==110}">
												<div class="list_left">
													<p>
														<span>${orderInfo.orderCustomerInfo.bespeakName }</span>发布了定制服务需求&nbsp;&nbsp;<img
															src="<%=basePath%>resources/images/list1.png"><img
															src="<%=basePath%>resources/images/list2.png"><img
															src="<%=basePath%>resources/images/list3.png">&nbsp;&nbsp;${orderInfo.orderCustomDemand.categoryName }
														共计${orderInfo.orderCustomDemand.customNum }件
													</p>
													<span></span> <a href="#" class="in">指派服务商</a> <label><img
														src="<%=basePath%>resources/images/zhong.png"><fmt:formatDate value="${orderInfo.createTime }"
															pattern="yyyy-MM-dd  HH:mm:ss " /></label>
												</div>
												<div class="list_right">
													<div>
														<a href="<%=basePath%>order/orderDetail?orderNo=${orderInfo.orderNo }" class="txt666Color">指派服务</a>
													</div>
													<div>
														<a href="<%=basePath%>order/orderCancel?orderNo=${orderInfo.orderNo }">取消订单</a>
													</div>
												</div>
											</c:when>
											<c:when test="${orderInfo.status==130}">
												<li>
													<div class="swwe">
														<img src="<%=basePath%>resources/images/swwe.png">
													</div> <i><img
														src="<%=basePath%>resources/images/icon_jiao.jpg"></i>
													<div class="list_left">
														<p>
															<span>${orderInfo.serviceProvider.name }</span>为我提供定制服务&nbsp;&nbsp;<img
																src="<%=basePath%>resources/images/list1.png"><img
																src="<%=basePath%>resources/images/list2.png"><img
																src="<%=basePath%>resources/images/list3.png">&nbsp;&nbsp;${orderInfo.orderCustomDemand.categoryName }
															共计${orderInfo.orderCustomDemand.customNum }件
														</p>
														<span><label>待付定金:￥${orderInfo.frontMoney }元</label>金额：￥${orderInfo.totalMoney }<em>待付尾款</em></span>
														<a>支付尾款</a> <label><img
															src="<%=basePath%>resources/images/zhong.png">2016-03-05&nbsp;&nbsp;12:10:30</label>
													</div>
													<div class="list_right">
														<div>
															<a href="<%=basePath%>order/orderCancel?orderNo=${orderInfo.orderNo }">取消订单</a>
														</div>
													</div>
													<div class="clear"></div>
												</li>
											</c:when>
											<c:when test="${orderInfo.status==120}">
												<div class="list_left">
													<p>
														<span>${orderInfo.orderCustomerInfo.bespeakName }</span>发布了定制服务需求&nbsp;&nbsp;<img
															src="<%=basePath%>resources/images/list1.png"><img
															src="<%=basePath%>resources/images/list2.png"><img
															src="<%=basePath%>resources/images/list3.png">&nbsp;&nbsp;${orderInfo.orderCustomDemand.categoryName }
														共计${orderInfo.orderCustomDemand.customNum }件
													</p>
													<span></span> <a href="#" class="in">指派服务商</a> <label><img
														src="<%=basePath%>resources/images/zhong.png"><fmt:formatDate value="${orderInfo.createTime }"
															pattern="yyyy-MM-dd  HH:mm:ss " /></label>
												</div>
												<div class="list_right">
													<div>
														<a href="<%=basePath%>order/orderDetail?orderNo=${orderInfo.orderNo }" class="txt666Color">指派服务</a>
													</div>
													<div>
														<a href="<%=basePath%>order/orderCancel?orderNo=${orderInfo.orderNo }">取消订单</a>
													</div>
												</div>
											</c:when>
										</c:choose>
										<div class="clear"></div>
									</li>
								</c:forEach>
								<%-- <li>
									<div class="swwe">
										<img src="<%=basePath%>resources/images/swwe.png">
									</div> <i><img src="<%=basePath%>resources/images/icon_jiao.jpg"></i>
									<div class="list_left">
										<p>
											<span>张三</span>发布了定制服务需求&nbsp;&nbsp;<img
												src="<%=basePath%>resources/images/list1.png"><img
												src="<%=basePath%>resources/images/list2.png"><img
												src="<%=basePath%>resources/images/list3.png">&nbsp;&nbsp;职业装
											共计200件
										</p>
										<p>
											<span>红豆制衣有限公司</span>提供定制服务<img
												src="<%=basePath%>resources/images/yes.png">
										</p>
										<span><label>金额:￥24000.00元</label><em> 签单付定金</em></span> <label><img
											src="<%=basePath%>resources/images/zhong.png">2016-03-05&nbsp;&nbsp;12:10:30</label>
									</div>
									<div class="list_right">
										<div>
											<a href="#">取消订单</a>
										</div>
									</div>
									<div class="clear"></div>
								</li>
								<li>
									<div class="swwe">
										<img src="<%=basePath%>resources/images/swwe.png">
									</div> <i><img src="<%=basePath%>resources/images/icon_jiao.jpg"></i>
									<div class="list_left">
										<p>
											<span>红豆制衣有限发展公司</span>为我提供定制服务&nbsp;&nbsp;<img
												src="<%=basePath%>resources/images/list1.png"><img
												src="<%=basePath%>resources/images/list2.png"><img
												src="<%=basePath%>resources/images/list3.png">&nbsp;&nbsp;职业装
											共计200件
										</p>
										<span><label>待付定金:￥36000.00元</label>金额：￥60000.00<em>待付尾款</em></span>
										<a href="#">支付尾款</a> <label><img
											src="<%=basePath%>resources/images/zhong.png">2016-03-05&nbsp;&nbsp;12:10:30</label>
									</div>
									<div class="list_right">
										<div>
											<a href="#">取消订单</a>
										</div>
									</div>
									<div class="clear"></div>
								</li>
								<li>
									<div class="swwe">
										<img src="<%=basePath%>resources/images/swwe.png">
									</div> <i><img src="<%=basePath%>resources/images/icon_jiao.jpg"></i>
									<div class="list_left">
										<p>
											<span>红豆制衣有限发展公司</span>为我提供定制服务&nbsp;&nbsp;<img
												src="<%=basePath%>resources/images/list1.png"><img
												src="<%=basePath%>resources/images/list2.png"><img
												src="<%=basePath%>resources/images/list3.png">&nbsp;&nbsp;职业装
											共计200件
										</p>
										<span><label>待付定金:￥36000.00元</label>金额：￥60000.00<em>待发货</em></span>
										<a href="#" class="in">查看详情</a> <label><img
											src="<%=basePath%>resources/images/zhong.png">2016-03-05&nbsp;&nbsp;12:10:30</label>
									</div>
									<div class="list_right">
										<div>
											<a href="#">取消订单</a>
										</div>
									</div>
									<div class="clear"></div>
								</li>
								<li>
									<div class="swwe">
										<img src="<%=basePath%>resources/images/swwe.png">
									</div> <i><img src="<%=basePath%>resources/images/icon_jiao.jpg"></i>
									<div class="list_left">
										<p>
											<span>红豆制衣有限发展公司</span>为我提供定制服务&nbsp;&nbsp;<img
												src="<%=basePath%>resources/images/list1.png"><img
												src="<%=basePath%>resources/images/list2.png"><img
												src="<%=basePath%>resources/images/list3.png">&nbsp;&nbsp;职业装
											共计200件
										</p>
										<span><label>金额:￥60000.00元</label><img
											src="<%=basePath%>resources/images/ic1.png">已支付金额：￥60000.00<em>待收货</em></span>
										<a href="#" class="in">确认签收</a> <label><img
											src="<%=basePath%>resources/images/zhong.png">2016-03-05&nbsp;&nbsp;12:10:30</label>
									</div>
									<div class="list_right">
										<div>
											<a href="#">取消订单</a>
										</div>
									</div>
									<div class="clear"></div>
								</li>
								<li>
									<div class="swwe">
										<img src="<%=basePath%>resources/images/swwe.png">
									</div> <i><img src="<%=basePath%>resources/images/icon_jiao.jpg"></i>
									<div class="list_left">
										<p>
											<span>红豆制衣有限发展公司</span>为我提供定制服务&nbsp;&nbsp;<img
												src="<%=basePath%>resources/images/list1.png"><img
												src="<%=basePath%>resources/images/list2.png"><img
												src="<%=basePath%>resources/images/list3.png">&nbsp;&nbsp;职业装
											共计200件
										</p>
										<span><label>金额:￥60000.00元</label><img
											src="<%=basePath%>resources/images/ic1.png">已支付金额：￥60000.00<em>已签收</em></span>
										<a href="#" class="in">确认签收</a> <label><img
											src="<%=basePath%>resources/images/zhong.png">2016-03-05&nbsp;&nbsp;12:10:30</label>
									</div>
									<div class="list_right">
										<div>
											<a href="#">取消订单</a>
										</div>
									</div>
									<div class="clear"></div>
								</li>
								<li>
									<div class="swwe">
										<img src="<%=basePath%>resources/images/swwe.png">
									</div> <i><img src="<%=basePath%>resources/images/icon_jiao.jpg"></i>
									<div class="list_left">
										<p>
											<span>红豆制衣有限发展公司</span>为我提供定制服务&nbsp;&nbsp;<img
												src="<%=basePath%>resources/images/list1.png"><img
												src="<%=basePath%>resources/images/list2.png"><img
												src="<%=basePath%>resources/images/list3.png">&nbsp;&nbsp;职业装
											共计200件
										</p>
										<span>已取消</span> <a href="#" class="in">查看详情</a> <label><img
											src="<%=basePath%>resources/images/zhong.png">2016-03-05&nbsp;&nbsp;12:10:30</label>
									</div>
									<div class="list_right">
										<div>
											<a href="#">取消订单</a>
										</div>
									</div>
									<div class="clear"></div>
								</li> --%>
							</ul>
						</div>
						<div class="clear"></div>
					</div>
					<!--分页-->
					<div class="page">
						<span class="page_text"> 88 条记录</span><a class="pageup pageup-dis"
							href="javascript:void(0)" title="上一页"><em></em>上一页</a> <a
							class="current" href="javascript:void(0)">1</a><a href="/page2">2</a><a
							href="/page3">3</a><a href="/page4">4</a><a href="/page5">5</a> <span>...</span>
						<a href="/page207">207</a> <a class="pagedown" href="/page2"
							title="下一页">下一页<em></em></a>
					</div>
					<!--分页 end-->
					<div class="yj10"></div>
				</div>
				<div class="clear"></div>
			</div>
		</div>
	</div>
	<!--content end-->

	<!--footer-->
	<%@ include file="/WEB-INF/view/common/footer.jsp"%>
	<!--footer end-->
</body>
</html>