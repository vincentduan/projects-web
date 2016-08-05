<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<!-- 注意：本JSP页面是在微信端使用的，故按需引入其他文件.使手机端更快得到响应 -->
<script src="${ctx}/statics/jquery/jquery-1.9.1.min.js" type="text/javascript"></script>
<!-- 引入bootstrap -->
<link href="${ctx}/statics/bootstrap/3.3.5/dist/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<script src="${ctx}/statics/bootstrap/3.3.5/dist/js/bootstrap.min.js" type="text/javascript"></script>
<title>${title}</title>
</head>
<body>
<div class="container-fluid">
	<div class="page-header ">
		<h1 class="center-block">${title}</h1>
		<small>${createTime}</small>
	</div>
	<p>
		${content}
	</p>
	
	<#--
	<div class="footer ">
		<div>
			<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
			<span>最近访客<small>&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)">10人</a></small></span>	
		</div>
		<div class="list-group-item">
			<span class="label label-default">访客</span>
			<span class="label label-default">访客</span>
			<span class="label label-default">访客</span>
			<span class="label label-default">访客</span>
			<span class="label label-default">访客</span>
			<span class="label label-default">访客</span>
			<span class="label label-default">访客</span>
			<span class="label label-default">访客</span>
			<span class="label label-default">访客</span>
			<span class="label label-default">访客访客访客</span>
			<span class="label label-default">访客</span>
			<span class="label label-default">访客</span>
			<span class="label label-default">访客</span>
			<span class="label label-default">访客</span>
			<span class="label label-default">访客</span>
			<span class="label label-default">访客</span>
		</div>
		</div>
	 -->
</div>
<body>

</html>