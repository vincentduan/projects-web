<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<div class="zhuangtai">
							<div class="div_item">
								<div class="item on item_first">
									<div class="list">
										<i></i>
										<p>发布需求</p>
										<span>${baseOrder.createTime }</span>
										<div class="tanchuan">
											<div class="tanchuan_img">
												<img src="<%=basePath%>resources/img/yaoyingchao.png"/>
												<div class="sanjia">
													<img src="<%=basePath%>resources/img/xiangxia.png"/>
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
								<c:if test="${baseOrder.status=='110' }"><p>管家受理</p></c:if>
								<c:if test="${baseOrder.status=='120' }"><p>选择供应商</p></c:if>
								<c:if test="${baseOrder.status=='125'|| baseOrder.status=='130' }"><p>签单付定金</p></c:if>
								<c:if test="${baseOrder.status=='140' }"><p>上门量体</p></c:if>
								<c:if test="${baseOrder.status=='150' }"><p>生产制作</p></c:if>
								<c:if test="${baseOrder.status=='160' }"><p>支付尾款</p></c:if>
								<c:if test="${baseOrder.status=='170' }"><p>待发货</p></c:if>
								<c:if test="${baseOrder.status=='180' }"><p>待签收</p></c:if>
								<c:if test="${baseOrder.status=='190'|| baseOrder.status=='200'  }"><p>交易完成</p></c:if>
								     </div>
								</div>
								<div class="item on">
								   <div class="list">
								     <c:forEach items="${orderStream }" var="list">
								        <c:if test="${list.status=='110' }">
								        <p>管家受理</p>
										<span>${list.createTime }</span>
										<div class="tanchuan">
											<div class="tanchuan_img">
												<img src="<%=basePath%>resources/img/yaoyingchao.png"/>
												<div class="sanjia">
													<img src="<%=basePath%>resources/img/xiangxia.png"/>
												</div>
											</div>
											<div class="tanchuan_text">
												<p>${list.remarks }</p>
											</div>
										</div>
								        </c:if>
								        <c:if test="${list.status=='120' }">
								        <p>选择服务商</p>
										<span class="span1">(设计、打样、报价)</span>
										<span>${list.createTime }</span>
										<div class="tanchuan">
											<div class="tanchuan_img">
												<img src="<%=basePath%>resources/img/yaoyingchao.png"/>
												<div class="sanjia">
													<img src="<%=basePath%>resources/img/xiangxia.png"/>
												</div>
											</div>
											<div class="tanchuan_text">
												<p>${list.remarks }</p>
											</div>
										</div>
								        </c:if>
								        <c:if test="${list.status=='125'||list.status=='130' }">
								        <p>签单付订金</p>
										<span>${list.createTime }</span>
										<div class="tanchuan">
											<div class="tanchuan_img">
												<img src="<%=basePath%>resources/img/yaoyingchao.png"/>
												<div class="sanjia">
													<img src="<%=basePath%>resources/img/xiangxia.png"/>
												</div>
											</div>
											<div class="tanchuan_text">
												<p>${list.remarks }</p>
											</div>
										</div>
								        </c:if>
								        <c:if test="${list.status=='140' }">
								        <p>上门量体</p>
										<span>${list.createTime }</span>
										<div class="tanchuan">
											<div class="tanchuan_img">
												<img src="<%=basePath%>resources/img/yaoyingchao.png"/>
												<div class="sanjia">
													<img src="<%=basePath%>resources/img/xiangxia.png"/>
												</div>
											</div>
											<div class="tanchuan_text">
												<p>${list.remarks }</p>
											</div>
										</div>
								        </c:if>
								        <c:if test="${list.status=='150' }">
								        <p>生产制作</p>
										<span>${list.createTime }</span>
										<div class="tanchuan">
											<div class="tanchuan_img">
												<img src="<%=basePath%>resources/img/yaoyingchao.png"/>
												<div class="sanjia">
													<img src="<%=basePath%>resources/img/xiangxia.png"/>
												</div>
											</div>
											<div class="tanchuan_text">
												<p>${list.remarks }</p>
											</div>
										</div>
								        </c:if>
								        <c:if test="${list.status=='160' }">
								        <p>支付尾款</p>
										<span>${list.createTime }</span>
										<div class="tanchuan">
											<div class="tanchuan_img">
												<img src="<%=basePath%>resources/img/yaoyingchao.png"/>
												<div class="sanjia">
													<img src="<%=basePath%>resources/img/xiangxia.png"/>
												</div>
											</div>
											<div class="tanchuan_text">
												<p>${list.remarks }</p>
											</div>
										</div>
								        </c:if>
								        <c:if test="${list.status=='170' }">
								        <p>待发货</p>
										<span>${list.createTime }</span>
										<div class="tanchuan">
											<div class="tanchuan_img">
												<img src="<%=basePath%>resources/img/yaoyingchao.png"/>
												<div class="sanjia">
													<img src="<%=basePath%>resources/img/xiangxia.png"/>
												</div>
											</div>
											<div class="tanchuan_text">
												<p>${list.remarks }</p>
											</div>
										</div>
								        </c:if>
								        <c:if test="${list.status=='180' }">
								        <p>待签收</p>
										<span>${list.createTime }</span>
										<div class="tanchuan">
											<div class="tanchuan_img">
												<img src="<%=basePath%>resources/img/yaoyingchao.png"/>
												<div class="sanjia">
													<img src="<%=basePath%>resources/img/xiangxia.png"/>
												</div>
											</div>
											<div class="tanchuan_text">
												<p>${list.remarks }</p>
											</div>
										</div>
								        </c:if>
								        <c:if test="${list.status=='190'||list.status=='200' }">
								        <p>交易完成</p>
										<span>${list.createTime }</span>
										<div class="tanchuan">
											<div class="tanchuan_img">
												<img src="<%=basePath%>resources/img/yaoyingchao.png"/>
												<div class="sanjia">
													<img src="<%=basePath%>resources/img/xiangxia.png"/>
												</div>
											</div>
											<div class="tanchuan_text">
												<p>${list.remarks }</p>
											</div>
										</div>
								        </c:if>
								     </c:forEach>
										<i></i>
								   <div>
								</div>
								