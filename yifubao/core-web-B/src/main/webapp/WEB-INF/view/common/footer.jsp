<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
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