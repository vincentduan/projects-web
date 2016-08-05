<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<!-- 注意：本JSP页面是在微信端使用的，故按需引入其他文件.使手机端更快得到响应 -->
<script src="${ctx}/statics/jquery/jquery-1.9.1.min.js" type="text/javascript"></script>
<!-- 引入微信JS-SDK -->
<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.1.0.js"></script>
<!-- 引入bootstrap -->
<link href="${ctx}/statics/bootstrap/3.3.5/dist/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<script src="${ctx}/statics/bootstrap/3.3.5/dist/js/bootstrap.min.js" type="text/javascript"></script>
<title>公告发布</title>
<style type="text/css">
.list-group-item .label {
	font-size:14px;
    margin: 2px 2px;
    display: inline-block;
}
</style>
<script type="text/javascript">
	//定义全局已选部门ID列表,已选标签列表,已选用户ID列表
	var selectedDepartmentIds=["2","3"];
	var selectedTagIds=["2","23"];
	var selectedUserIds=["shijb11","market"];

	$(function(){
		$('#publishBtn').click(function(){
			var url = "${ctx}/wechat/notice/generate.do";
			var title = $('#title').val();
			var content = $('#content').val();
			if($.trim(title)==""){
				alert('请先填写公告标题');
				return ;
			}
			if($.trim(content)==""){
				alert('请先填写公告内容');
				return ;
			}
			var data = {'title':title,
					    'content':content,
					    'selectedUserIds':selectedUserIds,
					    'selectedTagIds':selectedTagIds,
					    'selectedDepartmentIds':selectedDepartmentIds};
		    console.log(data);
		    var json = JSON.stringify(data);
		    alert(json);
			$.ajax({
				url : url,
				type : 'POST',
				data : JSON.stringify(data),
				dataType : 'json',
				success:function(result){
					//window.location.href=result.url;
					alert('发布成功！');
					wx.closeWindow();
				},
				error : function(xhr, textStatus) {
					alert('系统发生异常,请联系管理员!');
				}
			});
		});

	});
		
</script>
</head>
<body >
<div class="container-fluid">
	<form id="formData">
		<div class="form-group">
		    <label for="title">请输入标题</label>
		    <input id="title" name="title" type="text" class="form-control" placeholder="请输入标题...">
		</div>
		<div class="form-group">
		    <label for="content">请输入公告正文</label>
		    <textarea class="form-control" id="content" name="content" rows="6" placeholder="请输入公告正文..."></textarea>
		</div>
		<div class="form-group">
		   <ul class="list-group">
			  <li class="list-group-item" id="openEnterpriseContact_invoke">
			    <span class="glyphicon glyphicon-menu-right"></span><!-- 图标类 -->
			      请选择发布对象
			  </li>
			</ul>
		</div>
		
		<div id="showSelectedDiv">
			
	  	</div>
	  	
	  	<br/>
		<button type="button" id="publishBtn" class="btn btn-primary btn-lg btn-block">发     布</button>
	</form>
</div>
</body>
</html>