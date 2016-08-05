<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
</head>
<body>
    <!-------------------------------------- 头部开始 -------------------------------------->
    <div class="head">
        <div class="wrap">
            <span class="flt"><a href="#">依文集团</a> & <a href="#">猪八戒网</a>　<a href="#">旗下职业装定制平台</a></span>
            <div class="title_j">
                <ul>
                    <li><a href="#"><img src="<%=basePath%>resources/img/xiaoxi.png" />消息</a></li>
                    <li><a href="#">我的定制</a></li>
                    <li><a href="#">186****2313</a><label><img src="<%=basePath%>resources/img/sanjiao.png" /></label></li>
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
                <p><a href="#">职业装定制</a></p>
                <p><span><a href="#">返回依服宝首页</a></span></p>
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
        

        <div class="shent_j">
            <div class="wrap">
                <div class="daohang">
					<p class="daohang_1">交易管理</p>
					<p class="daohang_2"><a href="#">订单管理</a></p>
					
					
					<p class="daohang_1 padd">基础设置</p>
					<p class="daohang_2"><a href="#">服务商信息</a></p>
					<p class="daohang_2"><a href="#">案例管理</a></p>
					<p class="daohang_2"><a href="#">量体师管理</a></p>

					
					<p class="daohang_1 padd">账号设置</p>
					<p class="daohang_2"><a href="#">修改登录密码</a></p>
					<p class="daohang_2"><a href="#">修改手机号码</a></p>
					<p class="daohang_2"><a href="#">身份认证</a></p>
					<p class="daohang_2"><a href="#">支付账户管理</a></p>
					<p class="daohang_1 padd">财务管理</p>
					<p class="daohang_2"><a href="#">收支明细</a></p>
					<p class="daohang_1 padd">消息中心</p>
					<p class="daohang_2"><a href="#">全部消息</a></p>
				</div>

                <div class="zhengwen">
                    <div class="leirong">
                        <p class="leirong_1">所有订单</p>
                        <p class="leirong_2"><span>订单号：${baseOrder.orderNo }</span><span>状态：竞标</span></p>
                        <div class="zhuangtai">
                            <div class="div_item">
                                <div class="item on item_first in">
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

                                <div class="item">
                                    <div class="list">
                                        <i></i>
                                        <p>中标录合同</p>
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
                                <div class="item">
                                    <div class="list">
                                        <i></i>
                                        <p class="p1">客户<span class="span1">支付定金</span></p>
                                        

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
                                        <p class="p1">客户<span class="span1">支付尾款</span></p>

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
                                        <p>待签收</p>

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
                            <p><span>定制信息</span></p>
                        </div>

                        <div class="kehuinfo">
                            <p><span><img src="<%=basePath%>resources/img/tou_1.png">客户信息</span></p>
                        </div>
                        <div class="bor_info">
                            <div class="xiqinfo">
                                <p><span>姓名</span>：<a>张三</a></p>
                                <p><span>手机号</span>：<a>18612345678</a></p>
                            </div>
                            <div class="xiqinfo">
                                <p><span>企业名称</span>：<a>依服宝网络科技有限公司</a></p>
                                <p><span>企业地址</span>：<a>北京市海淀区西四环68号左岸公社6层</a></p>
                            </div>
                            <div class="xiqinfo xiqinfo_1">
                                <p><span>定制部门</span>：<a>全体</a></p>
                                <p><span>量体地址</span>：<a>北京市海淀区西四环68号左岸公社6层</a></p>
                            </div>
                        </div>
                        <div class="kehuinfo">
                            <p><span><img src="<%=basePath%>resources/img/ye_1.png">客户定制需求</span><a href="#"></p>
                        </div>
                        <div class="dingzfs">
                            <p><span>定制方式</span>：<label class="col">量体定制</label></p>
                            <p><span>定制数量</span>：<label class="col">100件</label></p>
                            <p><span>定制预算</span>：<label class="col">70000.00元</label></p>
                            <p><span>定制周期</span>：<label class="col">12个工作日</label></p>
                            <p><span>定制品类</span>：<label class="col">西服正装</label></p>
                            <p><span>定制属性</span>：<label class="col">面料属性XXXXXX，颜色X，版型编号XXXXXX【备注：标牌均印有拉卡拉集团LOGO】</label></p>
                            <p><span>商品名称</span>：<label class="col"><img src="<%=basePath%>resources/img/list2.png" />男士双排扣西服 XX面料 蓝色 <a href="#">  查看商品详情 >></a></label></p>
                        </div> --%>
						<jsp:include page="./info.jsp" />
                        <div class="kehuinfo">
                            <p><span><img src="<%=basePath%>resources/img/ye_2.png">竞标信息</span></p>
                        </div>
                        <div class="pipeifws">
                            <div class="pipeifws_1">
                                <p>已指派该客户订单，请在60分钟内联系客户。</p>
                            </div>
                            <div class="sanxiang">
                                <div class="kuand">
                                    <div class="sanfzy">
                                        <div class="jindut">
                                            <div class="item jindut_1 on">
                                                <p><span>1</span><label>报名参与</label></p>
                                                <div class="item_info"><span>2016-01-11 16:19:26</span><label>已报名参与竞标</label></div>
                                            </div>
                                            <div class="item jindut_2">
                                                <p><span>2</span><label>60分钟联系</label></p>
                                                <div class="item_info"> </div>
                                            </div>
                                            <div class="item jindut_3">
                                                <p><span>3</span><label>中标</label></p>
                                                <div class="div_btn2">
                                                    
                                                    <a href="<%=basePath%>service/order_giveup?orderNo=${orderNo }&spid=${SpId }">弃单</a>
                                                </div>
                                            </div>
                                            <div class="clear"></div>
                                        </div>
                                        <div class="clear"></div>
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
                    <li class="list">
                        <span class="span_tit"><a href="#">买家帮助</a></span>
                        <a href="#">新手指南</a>
                        <a href="#">服务保障</a>
                        <a href="#">帮助中心</a>
                    </li>
                    <li class="list">
                        <span class="span_tit"><a href="#">商家帮助</a></span>
                        <a href="#">商家入驻</a>
                        <a href="#">商家推广</a>
                        <a href="#">帮助中心</a>
                    </li>
                    <li class="list">
                        <span class="span_tit"><a href="#">关于我们</a></span>
                        <a href="#">关于依服宝</a>
                        <a href="#">联系我们</a>
                        <a href="#">加入依服宝</a>
                    </li>
                    <li class="list">
                        <span class="span_tit"><a href="#">关注我们</a></span>
                        <a href="#" class="a_sina">新浪微博</a>
                        <a href="#" class="a_QQ">QQ空间</a>
                        <a href="#" class="a_weibo">腾讯微博</a>
                    </li>
                    <li class="contant">
                        <span class="phone">400-888-8888</span>
                        <p>依服宝客服热线<br />周一至周日：09：00-20：00</p>
                    </li>

                    <li class="li_ewm">
                        <p>
                            <img src="<%=basePath%>resources/img/ewm.png" />
                            <span>依服宝<br />APP下载</span>
                        </p>
                    </li>
                    <li class="li_ewm">
                        <p>
                            <img src="<%=basePath%>resources/img/ewm.png" />
                            <span>依服宝<br />微信服务号</span>
                        </p>
                    </li>
                </ul>
            </div>

            <div class="copyright">
                <p>Copyright © 2015 efubao.com 电信与信息服务业务经营许可证100798号 经营性网站备案信息 京ICP备11031139号 京公网安备110108006045</p>
                <p>客服邮箱：kf@efbao.com 客服电话：4008-888-888 文明办网文明上网举报电话：010-82615762 违法不良信息举报中心 我最爱的人民警察评选>>反诈骗信息</p>
            </div>
        </div>
    </div>
    <!-------------------------------------- 尾部结束 -------------------------------------->
</body>
</html>