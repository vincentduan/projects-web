<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" import="com.unisk.location.model.UniskUser"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%
	UniskUser user = (UniskUser)session.getAttribute("user");
%>
<!doctype html>
<html class="no-js" lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>沃众筹</title>
<link type="text/css" href="/statics/css/rst.css" rel="stylesheet" />
<script type="text/javascript" src="/statics/js/jquery-easyui-1.4.2/jquery.min.js"></script>
<script type="text/javascript" src="/statics/js/jquery.form.js"></script>
<script type="text/javascript" src="/statics/js/backstage/unisktools.js"></script>
</head>
<body>
	<div class="head">
		<div class="container">
			<a href="http://www.10010.com" class="logo"> <img
				src="/statics/imgs/unicomlogo.png" alt="中国联通logo" />
			</a>
			<div class="nav">
				<ul style="display: none;">
					<li><a href="#">咨询</a></li>
					<li><a href="#">众筹</a></li>
					<li><a href="#">融资</a></li>
					<li class="active"><a href="#">创业公司</a></li>
					<li><a href="#">投资人</a></li>
				</ul>
			</div>
			<div class="navsub">
				<ul>
					<li  style="display: none;"><a href="#">搜索</a></li>
					<li  style="display: none;"><a href="#">客户端</a></li>
					<li class="head_1" style="line-height:60px; font-size: 12">Hi,<%=user==null ? "游客" : user.getUSERNAME() %>，您好！</li>
					<%
						if( user == null ){
					%>
					<li class="head_1" style="line-height:60px; font-size: 12"><a href="javascript:window.location.href='/backstage/reception/login.jsp?Referer='+window.location.href">登录</a></li>
					<%
						}else{
					%>				
					<li class="head_1" style="line-height:60px; font-size: 12"><a href="javascript:window.location.href='/reception/user/loginout.do?Referer='+window.location.href">登出</a></li>
					<%
						}
					%>
				</ul>
			</div>
		</div>
	</div>
	<div class="hr10"></div>
	<div class="hr10"></div>
	<div class="hr10"></div>
	<div class="hr10"></div>
	<div class="hr10"></div>
	<div class="hr10"></div>
	<div class="hr10"></div>
	<div class="hr10"></div>
	<div class="hr10"></div>
	<div class="container">
		<div class="ctn-wrap">
			<form action="/reception/company/add.do" name="form1">
			<input type="hidden" name="PID" value="${project.ID }">
				<div class="form-title">领取<<${project.PROJECTNAME }>></div>
				<div class="create-from">
					<div class="form_grop">
						<div class="label-control">
							<span class="required">*</span>
							公司名称
						</div>
						<input type="text" name="CNAME" id="CNAME" placeholder="填写公司名称" class="form-input">
					</div>
					<!-- <div class="hr10"></div>
					<div class="hr10"></div>
					<div class="form_grop">
						<div class="label-control">
							<span class="required">*</span>
							产品状态
						</div>
						<select class="form-st">
							<option label="3个月内上线" value="0">3个月内上线</option>
							<option label="6个月内上线" value="1">6个月内上线</option>
							<option label="运营中" selected="selected" value="2">运营中</option>
							<option label="停止运营" value="3">停止运营</option>
						</select>
					</div> -->
					<div class="hr10"></div>
					<div class="hr10"></div>
					<div class="form_grop">
						<div class="label-control">
							<span class="required">*</span>
							公司地址
						</div>
						<input type="text" name="CADDR" id="CADDR"  placeholder="如：北京 海淀 中关村南大街7号" class="form-input">
					</div>
					<div class="hr10"></div>
					<div class="hr10"></div>
					<div class="form_grop">
						<div class="label-control">
							<span class="required">*</span>
							公司网址
						</div>
						<input type="text" name="CWEB" id="CWEB"  placeholder="如：http://www.36kr.com" class="form-input">
					</div>
					<div class="hr10"></div>
					<div class="hr10"></div>
					<div class="form_grop">
						<div class="label-control">
							<span class="required">*</span>
							公司简述
						</div>
						<textarea class="form-tt"  name="CINFO" id="CINFO"  placeholder="简练的话语描述公司的基本情况"></textarea>
						<div class="hr5"></div>
					</div>
					<div class="hr10"></div>
					<div class="hr10"></div>
					<div class="form_grop">
						<div class="label-control">
							<span class="required">*</span>
							项目负责人
						</div>
						<input class="form-input" name="CUSER" id="CUSER"  placeholder="请填写项目负责人"></input>
						<div class="hr5"></div>
					</div>
					<div class="hr10"></div>
					<div class="hr10"></div>
					<div class="form_grop">
						<div class="label-control">
							<span class="required">*</span>
							项目负责人电话
						</div>
						<input class="form-input"  name="CUSERPHONE" id="CUSERPHONE"  placeholder="请填写项目负责人电话"></input>
						<div class="hr5"></div>
					</div>
					<div class="hr10"></div>
					<div class="hr10"></div>
					<div class="form_grop">
						<div class="label-control">
							<span class="required">*</span>
							项目负责人邮箱
						</div>
						<input class="form-input" name="CUSEREMAIL" id="CUSEREMAIL"  placeholder="请填写项目负责人邮箱"></input>
						<div class="hr5"></div>
					</div>
					<div class="hr10"></div>
					<div class="hr10"></div>
					<div class="form_grop">
						<div class="label-control">
							上传项目经历
						</div>
						<label>
							<input type="hidden"  name="CPROJECT" id="CPROJECT" >
							<input type="file"  name="uploadFile" id="uploadFile" style="width:90px; text-align:center;" value="本地上传" class="form-input">
						</label>
						<span class="form-sp" style="color:#32353D;">  提供与领取项目相关的项目经历，仅提供认证使用，平台不会暴露您的信息。</span>
						<div class="hr5"></div>
						<div class="enter-total" style="color:#767675;">格式为doc,pdf,小于20MB</div>
						<div class="hr10"></div>
						<div class="hr10"></div>
						<div class="enter-total"><input type="submit"  value="提交" class="form-cmt"></div>
					</div>
					<div class="hr10"></div>
					<div class="hr10"></div>
					<div class="hr10"></div>
					<div class="hr10"></div>
					
					
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript">
		$('input[type=submit]').on('click',function(){
			$(this).attr('disbaled','disbaled');
			if( $('#CNAME').val() == '' ){
				alert('请输入公司名称!');
				return false;
			}
			if( $('#CADDR').val() == '' ){
				alert('请输入公司地址!');
				return false;
			}
			if( $('#CWEB').val() == '' ){
				alert('请输入公司网址!');
				return false;
			}
			if( $('#CINFO').val() == '' ){
				alert('请输入公司简述!');
				return false;
			}
			if( $('#CUSER').val() == '' ){
				alert('请输入项目负责人!');
				return false;
			}
			if( $('#CUSERPHONE').val() == '' ){
				alert('请输入项目负责人电话!');
				return false;
			}
			if( $('#CUSEREMAIL').val() == '' ){
				alert('请输入项目负责人邮箱!');
				return false;
			}
			if( $('#CNAME').val() == '' ){
				alert('请输入公司名称!');
				return false;
			}
			if( $('#CPROJECT').val() == '' ){
				alert('请上传项目经历!');
				return false;
			}
			return true;
		})
		
		$('input[type=file]').on('change',function(){
			var fileStr = $(this).val();
			fileStr = fileStr.substring( fileStr.lastIndexOf('.') + 1);
			if( fileStr.toLocaleLowerCase() != 'doc' && fileStr.toLocaleLowerCase() != 'docx' && fileStr.toLocaleLowerCase() !='pdf' ) return alert('请上传doc,pdf等格式的文件');
			uploadFile('uploadFile','CPROJECT');
		})
	</script>
</body>
</html>
