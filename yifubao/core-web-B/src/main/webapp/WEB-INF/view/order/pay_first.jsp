<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/view/common/import.jsp"%>
    <script>
        $(function () {

        })
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

                <div class="zhengwen">

                    <div class="leirong">

                        <p class="leirong_1">待付款订单</p>
                    
                        <p class="leirong_2"><span>订单号：${baseOrder.orderNo }</span><span>状态：客户付订金</span></p>

                        <div class="zhuangtai">
                            <div class="div_item">
                            <div class="item on item_first">
                                    <div class="list">
                                        <i></i>
                                        <p class="p1">竞标<span class="span1">(设计、打样、报价)</span></p>
                                        <span>2016-01-10 17:02:42</span>
                                        <div class="tanchuan tanchuan_first in">
                                            <div class="tanchuan_img">
                                              
                                                <div class="sanjia">
                                                    <img src="<%=basePath%>resources/img/xiangxia.png" />
                                                </div>
                                            </div>
                                            <div class="tanchuan_text">
                                                <p>线下沟通</p>
                                                
                                            </div>
                                        </div>
                                    </div>
                                    </div>
                              <c:forEach items="${orderStream }" var="item">
							  <c:if test="${item.status < baseOrder.status}">
							  <c:if test="${item.status > 120 }">
							  <div class="item on"><div class="list"><i></i><p>${orderStatusMap[item.status] }</p><span>${item.createTime }</span></div></div>
							  </c:if>
							  </c:if>
							  </c:forEach>
							  <!-- <div class="item on"><div class="list"><i></i><p>管家受理</p></div></div>
							  <div class="item"><div class="list"><i></i><p>选择服务商</p><span class="span1">(设计、打样、报价)</span></div></div> -->
							  <div class="item on"><div class="list"><i></i> <p class="p1">客户<span class="span1">支付定金</span></p>
							  <div class="tanchuan">
                                            <div class="tanchuan_img">
                                                <div class="sanjia">
                                                    <img src="<%=basePath%>resources/img/xiangxia.png" />
                                                </div>
                                            </div>
                                            <div class="tanchuan_text">
                                                <p>线下与客户沟通，确定合同内容。</p>
                                                
                                            </div>
                                        </div>
							  </div></div>
							  <div class="item"><div class="list"><i></i><p>上门量体</p></div></div>
							  <div class="item"><div class="list"><i></i><p>生产制作</p></div></div>
							  <div class="item"><div class="list"><i></i><p class="p1">客户<span class="span1">支付定金</span></p></div></div>
							  <div class="item"><div class="list"><i></i><p>待发货</p></div></div>
							  <div class="item"><div class="list"><i></i><p>待签收</p></div></div>
							  <div class="item item_last"><div class="list"><i></i><p>交易完成</p></div></div>
                                <%-- <div class="item on item_first">
                                    <div class="list">
                                        <i></i>
                                        <p class="p1">竞标<span class="span1">(设计、打样、报价)</span></p>
                                        <span>2016-01-10 17:02:42</span>
                                        <div class="tanchuan tanchuan_first in">
                                            <div class="tanchuan_img">
                                              
                                                <div class="sanjia">
                                                    <img src="<%=basePath%>resources/img/xiangxia.png" />
                                                </div>
                                            </div>
                                            <div class="tanchuan_text">
                                                <p>线下沟通</p>
                                                
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="item on">
                                    <div class="list">
                                        <i></i>
                                        <p>中标录合同</p>
                                        <span>2016-01-10 17:02:42</span>
                                        <div class="tanchuan">
                                            <div class="tanchuan_img">
                                              
                                                <div class="sanjia">
                                                    <img src="../img/xiangxia.png" />
                                                </div>
                                            </div>
                                            <div class="tanchuan_text">
                                                <p>录入合同，带客户确认</p>
                                                
                                            </div>
                                        </div>

                                    </div>
                                </div>
                                <div class="item on in">
                                    <div class="list">
                                        <i></i>
                                        <p class="p1">客户<span class="span1">支付定金</span></p>
                                        

                                        <div class="tanchuan">
                                            <div class="tanchuan_img">
                                                <div class="sanjia">
                                                    <img src="<%=basePath%>resources/img/xiangxia.png" />
                                                </div>
                                            </div>
                                            <div class="tanchuan_text">
                                                <p>线下与客户沟通，确定合同内容。</p>
                                                
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
                                                <div class="sanjia">
                                                    <img src="../img/xiangxia.png" />
                                                </div>
                                            </div>
                                            <div class="tanchuan_text">
                                                <p>线下与客户沟通，确定合同内容。</p>
                                                
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
                                                <div class="sanjia">
                                                    <img src="../img/xiangxia.png" />
                                                </div>
                                            </div>
                                            <div class="tanchuan_text">
                                                <p>线下与客户沟通，确定合同内容。</p>
                                                
                                            </div>
                                        </div>

                                    </div>
                                </div>
                                <div class="item">
                                    <div class="list">
                                        <i></i>
                                        <p class="p1">客户<span class="span1">支付尾款</span></p>

                                        <div class="tanchuan">
                                            <div class="tanchuan_img">
                                                <div class="sanjia">
                                                    <img src="../img/xiangxia.png" />
                                                </div>
                                            </div>
                                            <div class="tanchuan_text">
                                                <p>线下与客户沟通，确定合同内容。</p>
                                                
                                            </div>
                                        </div>

                                    </div>
                                </div>
                                <div class="item">
                                    <div class="list">
                                        <i></i>
                                        <p>待发货</p>

                                       <div class="tanchuan">
                                            <div class="tanchuan_img">
                                                <div class="sanjia">
                                                    <img src="../img/xiangxia.png" />
                                                </div>
                                            </div>
                                            <div class="tanchuan_text">
                                                <p>线下与客户沟通，确定合同内容。</p>
                                                
                                            </div>
                                        </div>

                                    </div>
                                </div>
                                <div class="item">
                                    <div class="list">
                                        <i></i>
                                        <p>待签收</p>

                                        <div class="tanchuan">
                                            <div class="tanchuan_img">
                                                <div class="sanjia">
                                                    <img src="../img/xiangxia.png" />
                                                </div>
                                            </div>
                                            <div class="tanchuan_text">
                                                <p>线下与客户沟通，确定合同内容。</p>
                                                
                                            </div>
                                        </div>

                                    </div>
                                </div>
                                
                                <div class="item item_last">
                                    <div class="list">
                                        <i></i>
                                        <p>交易完成</p>

                                        <div class="tanchuan">
                                            <div class="tanchuan_img">
                                                <div class="sanjia">
                                                    <img src="../img/xiangxia.png" />
                                                </div>
                                            </div>
                                            <div class="tanchuan_text">
                                                <p>线下与客户沟通，确定合同内容。</p>
                                                
                                            </div>
                                        </div>

                                    </div>
                                </div> --%>
                                <div class="clear"></div>
                            </div>
                        </div>

                        <p class="ht"> &nbsp; &nbsp; 该需求工作量大，为保障双方权益，建议您与服务商沟通后，共同签署<a>交易合同</a>，合同将作为纠纷处理时，官方仲裁的重要依据。</p>

                        <jsp:include page="./info2.jsp"></jsp:include>
                        
                    </div>
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