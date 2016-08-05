<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/sys/includes/taglib.jsp"%>
<html>
<head>
<title>角色列表-角色管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="decorator" content="default" />
<%@include file="/WEB-INF/views/sys/includes/dialog.jsp"%>
<script type="text/javascript">
	$(function(){
		$('#queryBtn').click(function(){
			var url = '${ctx}/ucenter/role/listView.do';
			var formData = getFormData('#queryForm');
			//发送ajax请求
			sendAjaxRequest('#tableContainerDiv', url, 'POST', 'html', formData,null, null);
		});
		$('#queryBtn').click();
	});
</script>
</head>
<body>

	<ul class="nav nav-tabs">
		<li class="active"><a href="/ucenter/role/mainView.do">角色列表</a></li>
		<li><a href="/ucenter/role/addView.do">角色添加</a></li>
	</ul>
	
	<div class="tab-content">
		<div>
			<form id="queryForm" class="breadcrumb form-search">
				<div>
					<span>
						<label for="roleCode">角色代码：</label>
						<input type="text" name="roleno" id="roleno" class="input-small">
						
						<label for="roleName">角色名称：</label>
						<input type="text" name="rolename" id="rolename" class="input-small">
						
					</span>
					<span>
						<input id="queryBtn" class="btn btn-primary btn-query" type="button" value="查询" /> 
					</span>
				</div>
			</form>
		</div>
		
		<div id="tableContainerDiv">
			
		</div>
	</div>
</body>
</html>