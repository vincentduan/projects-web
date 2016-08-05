<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/views/sys/includes/taglib.jsp"%>
<html>
<head>
<title>用户管理-增加用户</title>
<%@ include file="/WEB-INF/views/sys/includes/dialog.jsp"%>
<meta name="decorator" content="default" />
<style type="text/css">
.help-inline{
	    color: red;
}
</style>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/ucenter/user/listView.do">用户列表</a></li>
		<li class="active">
			<a href="${ctx}/ucenter/user/formView.do">${user.id==null ? "用户添加" : "用户修改"}</a>
		</li>
	</ul>
	<br />
		<form:form id="inputForm" modelAttribute="user" action="/ucenter/user/modify.do" method="post" class="form-horizontal" >
			<form:hidden path="id" />
			<!-- <span class="help-inline">若不修改密码，请留空。</span> -->
			<div class="control-group">
				<label class="control-label">归属机构:</label>
				<div class="controls">
					<form:select path="deptid">
					<c:forEach items="${fns:getDepartmentList(null)}" var="dept">
						<form:option value="${dept.id }">${dept.deptname}</form:option>
					</c:forEach>
					</form:select>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">省分:</label>
				<div class="controls">
					<form:select path="provid" >
					<c:forEach items="${fns:getProvList()}" var="prov" > 
					<form:option value="${prov.uvalue }">${prov.ukey }</form:option>
					</c:forEach>
					</form:select>
				</div>
			</div>

			<div class="control-group">
				<label class="control-label">登录名:</label>
				<div class="controls">
					<form:input path="username" htmlEscape="false" maxlength="50" class="required" />
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">姓名:</label>
				<div class="controls">
					<form:input path="realname" htmlEscape="false" maxlength="50" class="required realname"  />
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">性别:</label>
				<div class="controls">
					<form:select path="sex">
						<form:option value="1">男</form:option>
						<form:option value="0">女</form:option>
					</form:select>
				</div>
			</div>
			<c:if test="${ user.id == null }">
				<div class="control-group">
					<label class="control-label">密码:</label>
					<div class="controls">
					<form:password path="password" maxlength="50" minlength="3" class="required password"/>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">确认密码:</label>
					<div class="controls">
						<input type="password" id="confirmNewPassword" name="confirmNewPassword" maxlength="50" minlength="3" class="input required" equalTo="#password"/>
					</div>
				</div>
			</c:if>
			<div class="control-group">
				<label class="control-label">邮箱:</label>
				<div class="controls">
					<form:input path="email" htmlEscape="false" maxlength="100" class="email" />
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">电话:</label>
				<div class="controls">
					<form:input path="mobile" htmlEscape="false" maxlength="100" class="tel"/>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">手机:</label>
				<div class="controls">
					<form:input path="phone" htmlEscape="false" maxlength="100" class="mobile"/>
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
				<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存" />
				<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)" />
			</div>
		</form:form>
		<script>
		;(function($){
			$('#inputForm').validate({
				rules:{
					username:{
						required:true,
						remote:{
							url:'${ctx}/ucenter/user/check.do',
							data:{username:function(){return $('#username').val();},
								id:function(){return $('#id').val()}}
						}
					},
					password:{
						minlength:6
					}
				},
				messages:{
					username:{required:'请输入用户名...',remote:'该用户名已经被使用,请重新输入...'}
				},
				submitHandler:function(form){
					form.submit();
				}
			})
		})($);
		</script>
</body>
</html>