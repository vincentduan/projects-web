<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>注册</title>

<script type="text/javascript" src="resources/js/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/registerCheck.js"></script>
<script type="text/javascript" src="resources/js/sendMsgControl.js"></script>

</head>
<body>
	<!-------------------------------------- 头部开始 -------------------------------------->
	<div class="head">
		<div class="wrap">
			<span class="flt"><a href="#">依文集团&nbsp; <a href="#">猪八戒网</a>
				&nbsp; <a>旗下职业装定制平台</a></span>
			<ul class="head_nav frt">
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
					<div class="logo_text flt"></div></a>
			</div>
			<div class="div_search frt">
				<div class="search2 flt">
					<font size="5">注册</font>
				</div>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<!-------------------------------------- 头部结束 -------------------------------------->
	<!-------------------------------------- 内容开始 -------------------------------------->


	<div class="mainer">
		<div class="wrap">
			<div class="registList">
				<div class="regist-main">
					<form id="register_form" action="register" method="get">
						<ul>
							<li><div class="tit">
									<h3>依文服饰欢迎您</h3>
								</div></li>
							<li>
								<div class="ui-form-item" id="phoneNum">
									<input type="text" id="mobilNum" class="ui-input"
										name="mobilNum" onBlur="checktelephone(this.value)"
										autocomplete="off" tabindex="1" value="" maxlength="100"
										placeholder="手机号" />
									 <span id="mobilNumDiv" class="ui-delect ui-error"></span>
									<div class="clr"></div>
								</div>
							</li>
							<li>
								<div class="ui-form-item" id="phoneVal">
									
									<input type="text" id="verifyNum" class="ui-input"
										name="verifyNum"  onBlur="checkVerifyNum(this.value)"
										autocomplete="off" tabindex="1" maxlength="60"
										placeholder="手机验证码" /> &nbsp;
									<input id="btnSendMsg" type="button" value="发送验证码" />
									<span id="mobilNumDiv" class="ui-delect ui-error"></span>
								</div>
							</li>
							<li>
								<div class="ui-form-item" id="passd1">
									<input type="password" id="checkpassd" class="ui-input"
										name="passd" onBlur="checkpassword(this.value)"
										autocomplete="off" tabindex="1" value="" maxlength="100"
										placeholder="密码" />
									<span id="checkpassdDiv" class="ui-delect ui-error"></span>
								</div>
							</li>
							<li>
								<div class="ui-form-item" id="passd2">
									<input type="password" id="checkpassdagain" class="ui-input"
										name="passd2" onBlur="checkpassrwordagain(this.value)"
										autocomplete="off" tabindex="1" value="" maxlength="100"
										placeholder="确认密码" />
									<span id="checkpassdagainDiv" class="ui-delect ui-error"></span>
								</div>
							</li>
							<li><div class="ui-form-item" id="contentLink">
									<a href="#" class="conLink">《依服宝用户服务协议》</a>
								</div></li>
							<li>
								<div class="ui-form-item" id="btn">
									<input name="" type="submit" class="registSub" value="同意协议并注册" 
										 onClick="$('#register_form').submit()" />
								</div>
							</li>
						</ul>
					</form>
				</div>
			</div>
			<div class="clear"></div>
			<div id="myDiv"></div>
		</div>
	</div>
	<!-------------------------------------- 内容结束 -------------------------------------->
	<!-------------------------------------- 尾部开始 -------------------------------------->
	<%-- <%@ include file="/WEB-INF/view/common/footer.jsp"%> --%>
	<!-------------------------------------- 尾部结束 -------------------------------------->
<script type="text/javascript">
	$("#btnSendMsg").click(function(){
	var value = $("#mobilNum").val();
	var getUrl = "/core-web-C/register/sendVerify"
	var getData = {"mobilNum":value};
	htmlobj=$.ajax({url:getUrl,data:getData,async:false,
		//success:function(msg){if(msg==true){alert("success");}}
	});
	$("#myDiv").html(htmlobj.responseText);
	  });
</script>

</body>
</html>