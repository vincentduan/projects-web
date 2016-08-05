<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>订单详情</title>
<script type="text/javascript"
	src="<%=basePath%>resources/js/jquery.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>resources/css/style.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>resources/css/style1.css">
<script type="text/javascript" src="<%=basePath%>resources/js/main.js"></script>
<!--plugin-->
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>resources/css/owl.carousel.min.css">
<script type="text/javascript"
	src="<%=basePath%>resources/js/owl.carousel.js"></script>
<script>
	$(function() {

	})
</script>
</head>
<body>
	<!-------------------------------------- 头部开始 -------------------------------------->
	<jsp:include page="/WEB-INF/view/common/order_header.jsp"></jsp:include>
	<!-------------------------------------- 头部结束 -------------------------------------->
	<!-------------------------------------- 内容开始 -------------------------------------->


	<div class="mainer">
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
			<p class="daohang_3">
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
					<span>订单号：${baseOrder.orderNo }</span><span>状态：${orderStatusMap[baseOrder.status] }</span>
				</p>
				<div class="zhuangtai">
					<div class="div_item">
						<div class="item on item_first">
							<div class="list">
								<i></i>
								<p>发布需求</p>
								<span>${baseOrder.createTime }</span>
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
								<p>管家受理</p>

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
								<p>选择服务商</p>
								<span class="span1">(设计、打样、报价)</span>

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

				<div class="leirong_2">
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
							<span>姓名</span>：<a>${OrderCustomerInfoVo.orderCustomerInfo.bespeakName }</a>
						</p>
						<p>
							<span>手机号</span>：<a>${OrderCustomerInfoVo.orderCustomerInfo.bespeakPhone }</a>
						</p>
					</div>
					<div class="xiqinfo">
						<p>
							<span>企业名称</span>： <label> <c:if
									test="${empty OrderCustomerInfoVo.orderCustomerInfo.companyName}">未填写</c:if>
								<c:if
									test="${!empty OrderCustomerInfoVo.orderCustomerInfo.companyName}">${OrderCustomerInfoVo.orderCustomerInfo.companyName }</c:if>
							</label>
						</p>
						<p>
							<span>企业地址</span>： <label> <c:if
									test="${empty OrderCustomerInfoVo.reciveAddress }">未填写</c:if> <c:if
									test="${!empty OrderCustomerInfoVo.reciveAddress }">${OrderCustomerInfoVo.reciveAddress.addressDetail }</c:if>
							</label>
						</p>
					</div>
					<div class="xiqinfo xiqinfo_1">
						<p>
							<span>定制部门</span>： <label> <c:if
									test="${empty OrderCustomerInfoVo.orderCustomerInfo.customDepartment }">未填写</c:if>
								<c:if
									test="${!empty OrderCustomerInfoVo.orderCustomerInfo.customDepartment }">${OrderCustomerInfoVo.orderCustomerInfo.customDepartment }</c:if>
							</label>
						</p>
						<p>
							<span>量体地址</span>： <label> <c:if
									test="${empty OrderCustomerInfoVo.list }">未填写</c:if> <c:if
									test="${!empty OrderCustomerInfoVo.list }">
									<c:forEach items="${OrderCustomerInfoVo.list }" var="list">
								 ${list.addressDetail }
								</c:forEach>
								</c:if>
							</label>
						</p>
					</div>
				</div>

				<div class="kehuinfo">
					<p>
						<span><img src="<%=basePath%>resources/img/ye_1.png">客户定制需求</span><label
							class="sem "><a href="#"><img
								src="<%=basePath%>resources/img/iconfont_1.png" />完善定制需求</a></label>
					</p>
				</div>
				<div class="dingzfs">
					<p>
						<span>定制方式</span>：<label class="col">量体定制</label>
					</p>
					<p>
						<span>定制数量</span>：<label>
							${OrderCustomDemandVo.count=='0'?'未填写':OrderCustomDemandVo.count }
						</label>
					</p>
					<p>
						<span>定制预算</span>：<label>${empty OrderCustomDemandVo.orderCustomDemand.customBudget?'未填写':OrderCustomDemandVo.orderCustomDemand.customBudget }</label>
					</p>
					<p>
						<span>定制周期</span>：<label>${empty OrderCustomDemandVo.orderCustomDemand.customCycle?'未填写':OrderCustomDemandVo.orderCustomDemand.customCycle }</label>
					</p>
					<p>
						<span>定制品类</span>：<label>${empty OrderCustomDemandVo.orderCustomDemand.categoryName?'未填写':OrderCustomDemandVo.orderCustomDemand.categoryName }</label>
					</p>
					<p>
						<span>定制属性</span>：<label>${empty OrderCustomDemandVo.orderCustomDemand.categoryProperty?'未填写':OrderCustomDemandVo.orderCustomDemand.categoryProperty }</label>
					</p>
					<p>
						<span>商品名称</span>：<label> </label>
					</p>
				</div>

				<div class="kehuinfo">
					<p>
						<span><img src="<%=basePath%>resources/img/ye_2.png">服务商信息</span>
					</p>
				</div>
				<%-- <div class="shang_info">
					<p>${empty OrderCustomDemandVo.serviceProvider?'暂无服务商信息':OrderCustomDemandVo.serviceProvider.name }</p>
				</div> --%>
			</div>
		</div>
	</div>
	<div class="clear"></div>



	<!-------------------------------------- 内容结束 -------------------------------------->
	<!-------------------------------------- 尾部开始 -------------------------------------->
	<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
	<!-------------------------------------- 尾部结束 -------------------------------------->
	<div class="wsxx">
		<div class="wsxx_page1">
			<div class="wsxx_page2">
				<div class="top">
					<h3>
						完善定制需求<img src="<%=basePath%>resources/img/cha.png">
					</h3>
					<div class="clear"></div>
				</div>
				<div class="title">
					<h3>客户定制需求</h3>
				</div>
				<div class="txt">
					<p>
						<span>定制方式：</span><label><span>量体定制</span></label>
					</p>
					<p>
						<span>定制数量：</span><label><input type="text"><span>件</span></label>
					</p>
					<p>
						<span>定制数量：</span><label><input type="text"><span>元</span></label>
					</p>
					<p>
						<span>定制数量：</span><label><input type="text"><span>个工作日<em>（量体结束后15个工作日完成生产制作）</em></span></label>
					</p>
					<p>
						<span>定制品类：</span><label><select><option
									value="1">西服正装</option></select></label>
					</p>
					<p class="text">
						<span>定制品类：</span><label><textarea id="textarea"
								onKeyDown="textdown(event)" onKeyUp="textup()"
								onfocus="if(value=='如面料属性、颜色、版号等'){value=''}"
								onblur="if (value ==''){value='如面料属性、颜色、版号等'}">如面料属性、颜色、版号等</textarea></label>
					</p>
					<p class="last">
						<span>定制品类：</span><label><img src="<%=basePath%>resources/img/list1.png"><span>男士双排扣西服
								XX面料 蓝色</span><a>删除</a></label>
					</p>
					<div class="ak">
						<a>保&nbsp;&nbsp;存</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="wansinfo">
		<div class="windows">
			<div class="w_title">
				<p>完善客户信息</p>
				<div class="r_div">
					<i></i>
				</div>
			</div>
			<div class="tianxie">
				<div class="detailed">
					<p>
						<img src="<%=basePath%>resources/img/icon25.png">客户信息
					</p>
					<div class="tianxie_1">
						<div class="deta">
							<div class="detailed_1">
								<p>
									<span>姓名：</span><input type="text" placeholder="张三" /><label>请输入联系人姓名</label>
								</p>
								<p>
									<span>手机号：</span><input type="text" placeholder="18612345678" /><label>请输入联系人手机号</label>
								</p>
							</div>
							<div class="detailed_2">
								<p>
									<span>企业名称：</span><input type="text" placeholder="请输入企业名称" />
								</p>
								<p>
									<span>定制部门：</span><input type="text" placeholder="请输入定制部门" />
								</p>
								<p>
									<span>所在地区：</span><select><option value="1">省/市</option></select><select
										class="select_2"><option value="1">市/地区</option></select><select><option
											value="1">县/市</option></select>
								</p>
								<p>
									<span> </span><input type="text" placeholder="请输入量体详细地址" />
								</p>
								<p>
									<span>量体地址：</span><input type="text" placeholder="请输入量体详细地址" />
								</p>
								<p>
									<a href="#">+ 增加地址</a>
								</p>
							</div>
							<div class="but_go">
								<p>
									<a href="#"><span>保 存</span></a>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
</body>
</html>