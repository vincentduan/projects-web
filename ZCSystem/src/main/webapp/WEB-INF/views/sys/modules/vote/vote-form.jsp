<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/views/sys/includes/taglib.jsp"%>
<html>
<head>
<title>添加投票-投票管理</title>
<meta name="decorator" content="default" />
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="/votes/vote/listView.do">投票列表</a></li>
		<li  class="active"><a href="/votes/vote/formView.do">投票添加</a></li>
	</ul>
	<br />
	<form:form id="inputForm" modelAttribute="vote" action="/votes/vote/modifyVote.do" method="post" class="form-horizontal">
		<form:hidden path="id" />
		<div class="control-group">
			<label class="control-label">投票标题:</label>
			<div class="controls">
				<form:input path="title" htmlEscape="false" maxlength="50" class="required title" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">截止日期:</label>
			<div class="controls date">
				<input type="text" readonly id="deadlinetime" name="deadlinetime" maxlength="50" class="required deadlinetime" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">投票对象:</label>
			<div class="controls">
				<form:input path="touserlabel" htmlEscape="false" maxlength="50" class="required touserlabel" />
				<form:hidden path="touserids"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">首      语:</label>
			<div class="controls">
				<form:textarea path="headcontent" htmlEscape="false" rows="3" maxlength="200" class="input-xlarge headcontent" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">尾      语:</label>
			<div class="controls">
				<form:textarea path="footercontent" htmlEscape="false" rows="3" maxlength="200" class="input-xlarge headcontent" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注:</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="3" maxlength="200" class="input-xlarge" />
			</div>
		</div>
		
		<div class="control-group">
			<div class="controls">
				<label class="checkbox">
				    <form:checkbox path="allowshowresult" value="1"/><i>允许成员查看投票结果</i>
				 </label>
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				<label class="checkbox">
				    <form:checkbox path="allowanonymat" value="1"/><i>允许成员匿名投票</i>
				 </label>
			</div>
		</div>
	
		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-primary" type="submit" value="保存并添加问题" />
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)" />
		</div>
	</form:form>
	<script type="text/javascript">
	;(function($){
		$(".deadlinetime").datetimepicker({language:'zh-CN',format: 'yyyy-mm-dd',autoclose:true});
	})($);
	</script>
</body>
</html>