<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<%@ include file="/WEB-INF/views/sys/includes/taglib.jsp"%>
<html>
<head>
	<title>${fns:getConfig('productName')} 登录</title>
	<meta name="decorator" content="default"/>
    <link rel="stylesheet" href="${ctxStatic}/common/typica-login.css">
	<style type="text/css">
		.control-group{border-bottom:0px;}
		.navbar .brand{float: none;}
	</style>
    <script src="${ctxStatic}/common/backstretch.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$.backstretch([
 		      "${ctxStatic}/images/bg1.jpg", 
 		      "${ctxStatic}/images/bg2.jpg"
 		  	], {duration: 10000, fade: 2000});
			$('#phoneCodeButton').on('click',function(){
				var _this = this;
				$(_this).attr('disabled','disabled');
				var username = $('#username').val();
				if( username == '' ){
					$('#loginError').text('请填写登录手机号');
					$('#messageBox').show();
					$(_this).removeAttr('disabled')
					return false;
				}
				var pattern = /^((13[0-9])|(15[^4,\d])|(18[0,5-9]))\d{8}$/;
				if( !  pattern.test(username) ){
					$('#loginError').text('请正确填写登录手机号');
					$('#messageBox').show();
					$(_this).removeAttr('disabled')
					return false;
				}
				var params = {};
				params.username = username;
				sendRequestPost('${pageContext.request.contextPath}/servlet/sendPhoneCodeServlet', params, function(data){
					if(data) {
						$('#loginError').text('验证码已经成功的发送到您的手机');
						$('#messageBox').show();
					}else{
						$(_this).removeAttr('disabled')
					}
				}, new Function())
			});
			/* $("#loginForm").validate({
				rules: {
					validateCode: {remote: "${pageContext.request.contextPath}/servlet/validateCodeServlet"},
					phonecode:{remote: "${pageContext.request.contextPath}/servlet/validatePhoneCodeServlet"}
				},
				messages: {
					username: {required: "请填写登录手机号."},password: {required: "请填写密码."},
					phonecode: {remote: "手机验证码不正确.",required: "请填写手机校验码."},
					validateCode: {remote: "验证码不正确.", required: "请填写验证码."}
				},
				errorLabelContainer: "#messageBox",
				errorPlacement: function(error, element) {
					error.appendTo($("#loginError").parent());
				} 
			}); */
		});
		// 如果在框架中，则跳转刷新上级页面
		if(self.frameElement && self.frameElement.tagName=="IFRAME"){
			parent.location.reload();
		}
	</script>
</head>
<body>
    <div class="navbar navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <a class="brand text-center" href="${ctx}"><img src="${ctxStatic}/images/logo.png" style="height:40px;"></a>
        </div>
      </div>
    </div>

    <div class="container">
		<!--[if lte IE 8]><br/><br/><br/><br/><div class='alert alert-block' style="text-align:left;padding-bottom:10px;"><a class="close" data-dismiss="alert">x</a><h4>温馨提示：</h4><p>你使用的浏览器版本过低。为了获得更好的浏览体验，我们强烈建议您升级到最新版本的IE浏览器，或者使用较新版本的 Chrome、Firefox、Safari 等。</p></div><![endif]-->
		<%String error = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);%>
		<div id="messageBox" class="alert alert-error <%=error==null?"hide":""%>"><button data-dismiss="alert" class="close">×</button>
			<label id="loginError" class="error"><%=error==null?"":"com.unisk.is.exceptions.CaptchaException".equals(error)?"验证码错误, 请重试.":"用户或密码错误, 请重试." %></label>
		</div>
        <div id="login-wraper">
            <form id="loginForm"  class="form login-form" action="${ctx}/login.do" method="post">
                <legend><span style="color:#08c;">系统登陆</span></legend>
                <div class="body">
					<div class="control-group">
						<div class="controls">
							<i>用户名：</i>
							<input type="text" id="username" name="username" class="required" value="${username}" placeholder="登录名">
						</div>
					</div>
					<!-- <div class="control-group">
						<div class="controls">
							<i>校验码：</i>
							<input type="text" id="phonecode" name="phonecode" class="required" value="${phonecode}" placeholder="手机校验码" style="width: 100px;">
							<button id="phoneCodeButton" class="btn btn-primary">获取校验码</button>
						</div>
					</div> -->
					<div class="control-group">
						<div class="controls">
							<i>密&nbsp;&nbsp;码：</i><input type="password" id="password" name="password" class="required" placeholder="密码"/>
						</div>
					</div>
					<c:if test="${isValidateCodeLogin}"><div class="validateCode">
						<label for="password">密　码：</label>
						<tags:validateCode name="validateCode" inputCssStyle="margin-bottom:0;"/>
					</div></c:if>
                </div>
                <div class="footer">
                    <label class="checkbox inline">
                        <input type="checkbox" id="rememberMe" name="rememberMe"> <span style="color:#08c;">记住我</span>
                    </label>
                    <input class="btn btn-primary" type="submit" value="登 录"/>
                </div>
            </form>
        </div>
    </div>
    <footer class="white navbar-fixed-bottom">
		${fns:getConfig('productName')}
    </footer>
  </body>
</html>