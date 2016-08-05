<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/views/sys/includes/taglib.jsp"%>
<html>
<head>
<title>角色管理-角色添加</title>
<meta name="decorator" content="default" />
<script type="text/javascript">
	$(function(){
		var disabled = "${canEdit}";
		if(disabled){
			$('.form-control').attr('disabled',disabled);
			$('input[type="button"]').attr('disabled',disabled);
		}
		
		$('#submitBtn').click(function(){
			var url = '${ctx}/ucenter/role/edit.do';
			var formData = getFormData('#submitForm');
			//发送ajax请求
			sendAjaxRequest('#tableContainerDiv', url, 'POST', 'json', formData,function(result){
				if(result.resultCode=='0'){
					$.messager.alert('提示', result.msg, 'info');
					window.location.href='${ctx}/ucenter/role/toMain.do';
				}
			}, null);
		});
	});
</script>
</head>
<body>

	<ul class="nav nav-tabs">
		<li><a href="/ucenter/role/mainView.do">角色列表</a></li>
		<li class="active"><a href="${roles.id != null ? '/ucenter/role/editView.do' : '/ucenter/role/addView.do' }">${roles.id != null ? '角色修改' : '角色添加'}</a></li>
	</ul>
	
	<form:form id="rolesForm" modelAttribute="roles" action="${roles.id != null ? '/ucenter/role/edit.do' : '/ucenter/role/add.do' }" method="post" class="form-horizontal">
		<c:if test="${roles.id != null}">
			<form:hidden path="id"/>
		</c:if>
		<tags:message content="${message }" />
		<div class="control-group">
			<label class="control-label">角色代码:</label>
			<div class="controls">
				<form:input path="roleno" htmlEscape="false" maxlength="50"
					class="required roleno" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">角色名称:</label>
			<div class="controls">
				<form:input path="rolename" htmlEscape="false" maxlength="50"
					class="required rolename" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">是否允许编辑:</label>
			<div class="controls">
				<form:select path="allowedit">
					<form:option value="1">是</form:option>
					<form:option value="0">否</form:option>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">是否允许删除:</label>
			<div class="controls">
				<form:select path="allowedit">
					<form:option value="1">是</form:option>
					<form:option value="0">否</form:option>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注:</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="3"
					maxlength="200" class="input-xlarge" />
			</div>
		</div>
		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存" />&nbsp; 
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)" />
		</div>
	</form:form>
</body>
</html>