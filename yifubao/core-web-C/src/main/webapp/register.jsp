<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<!--[if lt IE 9]>
        <script type="text/javascript" src="js/html5.js"></script>
        <![endif]-->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>注册</title>

<script type="text/javascript" src="resources/js/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/registerCheck.js"></script>
<script type="text/javascript" src="resources/js/sendMsgControl.js"></script>

<link rel="stylesheet" type="text/css" href="resources/css/style.css">
<link rel="stylesheet" type="text/css" href="resources/css/style1.css">
<script type="text/javascript" src="resources/js/main.js"></script>
<!--plugin-->
<link rel="stylesheet" type="text/css" href="resources/css/owl.carousel.min.css">
<script type="text/javascript" src="resources/js/owl.carousel.js"></script>
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

	})
</script>

</head>
<body>
	<!-------------------------------------- 头部开始 -------------------------------------->
	<div class="head">
		<div class="wrap">
			<span class="flt"><a href="#">依文集团</a> & <a href="#">猪八戒网</a></span>
			<ul class="head_nav frt">
				<li><a href="#">登录</a></li>
				<li><a href="#">注册</a></li>
				<li><a href="#">我要定制</a></li>
				<li><a href="#">客户服务</a></li>
				<li><a href="#">网站导航</a></li>
				<li><a href="#" class="ico_phone">手机依服宝</a></li>
				<li><a href="#" class="ico_gz">关注依服宝</a></li>
			</ul>
			<div class="clear"></div>
		</div>
	</div>
	<div class="header">
		<div class="wrap">
			<div class="logo flt">
				<a href="#"><img src="resources/img/logo.png" class="flt" />
				<div class="logo_text flt">
						<span>欢迎登陆</span>
					</div></a>
			</div>
			<div class="div_search frt">
				<a href="#">返回首页</a>
			</div>
			<div class="clear"></div>
		</div>
	</div>

	<!-------------------------------------- 头部结束 -------------------------------------->
	<!-------------------------------------- 内容开始 -------------------------------------->
	<div class="mainer">
		<div class="reg_banner">
			<div class="wrap">
				<div class="reg_tc">
					<div class="reg_content">
						<div class="reg_title">
							<p>
								<span>用户注册</span><a href="#">立即登录</a>
							</p>
							<div class="clear"></div>
						</div>
						<form id="register_form" action="register" method="get">
						<div class="reg_txt">
							<!-- <label><input type="text" value="手机号"></label>  -->
							<label>
							<input type="text" id="mobilNum" class="ui-input"
										name="mobilNum" onBlur="checktelephone(this.value)"
										autocomplete="off" tabindex="1" value="" maxlength="100"
										placeholder="手机号" />
									 <span id="mobilNumDiv" class="ui-delect ui-error"></span>
							</label>
							<!-- <label class="verity"><input type="text" value="手机验证码"><a>获取验证码</a></label> -->
							<label class="verity">
							<input type="text" id="verifyNum" class="verifyNum-input"
										name="verifyNum"  onBlur="checkVerifyNum(this.value)"
										autocomplete="off" tabindex="1" maxlength="60"
										placeholder="手机验证码" /> &nbsp;
									<!-- <input id="btnSendMsg" class="SendMsg-input" type="button" value="发送验证码" /> -->
									<a id="btnSendMsg" style="cursor:pointer;">发送验证码</a>
									<span id="verifyNumDiv" class="ui-delect ui-error"></span>
							</label>
							<!-- <label><input type="text" value="密码"></label>  -->
							<label><input type="password" id="checkpassd" class="ui-input"
										name="passd" onBlur="checkpassword(this.value)"
										autocomplete="off" tabindex="1" value="" maxlength="100"
										placeholder="密码" />
									<span id="checkpassdDiv" class="ui-delect ui-error"></span>
							</label>
							<!-- <label><input type="text" value="确认密码"></label>  -->
							<label><input type="password" id="checkpassdagain" class="ui-input"
										name="passd2" onBlur="checkpassrwordagain(this.value)"
										autocomplete="off" tabindex="1" value="" maxlength="100"
										placeholder="确认密码" />
									<span id="checkpassdagainDiv" class="ui-delect ui-error"></span>
							</label>
							<label class="lbl_btn"><a href="javascript:void(0)" name="submit" onClick="document.getElementById('register_form').submit();">同意协议并注册</a></label>
							<!-- <label class="lbl_btn"><input name="" type="submit" class="registSub" value="同意协议并注册" 
										 onClick="$('#register_form').submit()" /></label>  -->
							<label><em><a href="#">《依服宝用户服务协议》</a></em></label>
						</div>
					</form>
					</div>
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
							<img src="resources/img/ewm.png" /> <span>依服宝<br />APP下载
							</span>
						</p>
					</li>
					<li class="li_ewm">
						<p>
							<img src="resources/img/ewm.png" /> <span>依服宝<br />微信服务号
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
<script>
$("#btnSendMsg").click(function() {
	var value = $("#mobilNum").val();
	var getUrl = "/core-web-C/register/sendVerify"
	var getData = {
		"mobilNum" : value
	};
	htmlobj = $.ajax({
		url : getUrl,
		data : getData,
		async : false,
	//success:function(msg){if(msg==true){alert("success");}}
	});
	$("#myDiv").html(htmlobj.responseText);
});
</script>
</body>
</html>