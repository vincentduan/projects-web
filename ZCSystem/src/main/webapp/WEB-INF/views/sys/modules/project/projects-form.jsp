<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/views/sys/includes/taglib.jsp"%>
<html>
<head>
<title>项目管理</title>
<meta name="decorator" content="default" />
<script src="${ctxStatic}/modules/fileinput/js/fileinput.js" type="text/javascript"></script>
<script src="${ctxStatic}/modules/fileinput/js/fileinput_locale_zh.js" type="text/javascript"></script>
<link href="${ctxStatic}/modules/fileinput/css/fileinput.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/projects/project/listView.do">项目列表</a></li>
		<li class="active"><a href="${ctx}/projects/project/formView.do">${project.id == null ? '添加项目' : '修改项目' }</a></li>
	</ul>
	<form:form id="editForm" modelAttribute="project" action="${ctx}/projects/project/modify.do" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<div class="control-group">
			<label class="control-label">项目名称:</label>
			<div class="controls"><form:input path="projectname" htmlEscape="false" maxlength="50" class="required" /></div>
		</div>
		<div class="control-group">
			<label class="control-label">项目摘要:</label>
			<div class="controls">
				<form:input path="projectbrief" htmlEscape="false" maxlength="50" class="required" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">项目状态:</label>
			<div class="controls">
				<form:select path="projectstatus" name="projectstatus">
						<form:option value="0" label="发布" />
						<form:option value="1" label="众筹" />
						<form:option value="2" label="验收" />
						<form:option value="3" label="完成" />
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">项目LOGO:</label>
			<div class="controls"  style="width:50%">
				<form:hidden path="projectlogo"/>
				<input name="fileupload" type="file" class="file projectlogo"  >
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">封面图:</label>
			<div class="controls" style="width:50%">
				<form:hidden path="coverimage"/>
				<input name="fileupload" type="file" class="file coverimage">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">项目发布时间:</label>
			<div class="controls">
				<%-- <form:input path="starttime" readonly="readonly" htmlEscape="false" maxlength="50" class="required times" /> --%>
				<input type="text" readonly id="starttime" name="starttime" maxlength="50" class="required times" placeholder="<fmt:formatDate value='${project.starttime }' pattern='yyyy-MM-dd'/>" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">项目众筹时间:</label>
			<div class="controls">
				<input type="text" readonly id="crowdtime" name="crowdtime" maxlength="50" class="required times" placeholder="<fmt:formatDate value='${project.crowdtime }' pattern='yyyy-MM-dd'/>" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">项目验收时间:</label>
			<div class="controls">
				<input type="text" readonly id="examinetime" name="examinetime" maxlength="50" class="required times" placeholder="<fmt:formatDate value='${project.examinetime }' pattern='yyyy-MM-dd'/>" /> 
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">项目结束时间:</label>
			<div class="controls">
				<input type="text" readonly id="endtime" name="endtime" maxlength="50" class="required times" placeholder="<fmt:formatDate value='${project.endtime }' pattern='yyyy-MM-dd'/>" /> 
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">是否允许点赞:</label>
			<div class="controls">
				<form:select path="isallowedagree" name="isallowedagree">
						<form:option value="0" label="不允许对本项目点赞" />
						<form:option value="1" label="允许对本项目点赞" />
						<form:option value="2" label="允许对子项目点赞" />
						<form:option value="3" label="同时允许" />
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
			<label class="control-label">项目描述:</label>
			<div class="controls">
				<form:textarea path="projectcontent" id="projectcontent"  name="projectcontent" style="width: 600px; height: 200px" />
			</div>
		</div>
		<div class="form-actions">
			<input type="submit" class="btn btn-primary" type="button"  value="保 存" >
			<input id="btnCancel" class="btn" type="button" value="取消" onclick="history.go(-1)" />
		</div>
	</form:form>
<script type="text/javascript">
;(function($){
	$(".times").datetimepicker({language:'zh-CN',format: 'yyyy-mm-dd',autoclose:true});
})($);
</script>
<!-- 实例化编辑器 -->
<script src="${ctxStatic}/ueditor/uediter.project.config.js" charset="utf-8" type="text/javascript"></script>
<script src="${ctxStatic}/ueditor/ueditor.all.js" type="text/javascript" charset="utf-8" > </script>
<script type="text/javascript" charset="utf-8" src="${ctxStatic}/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">
	var ue = UE.getEditor("projectcontent",{
	    toolbars: [
	               ['fullscreen', 'source', '|', 'undo', 'redo', '|',
	                'bold', 'italic', 'underline', 'fontborder', 'superscript', 'subscript', 'removeformat', 'formatmatch', 'pasteplain', '|', 'forecolor', 'backcolor', 'insertorderedlist', 'insertunorderedlist', '|',
	                'rowspacingtop', 'rowspacingbottom', 'lineheight', '|',
	                'customstyle', 'paragraph', 'fontfamily', 'fontsize', '|',
	                'justifyleft', 'justifycenter', 'justifyright', 'justifyjustify', '|',
	                'link', 'unlink','|',
	                'simpleupload','|',
	                'preview']
	           ],
	           autoHeightEnabled: true,
	           autoFloatEnabled: true
	});
</script>
<!-- 文件上传 -->

<script type="text/javascript">
	 $(".projectlogo").fileinput({
				showRemove:true, //显示移除
				layoutTemplates:{
					actions: '',
					progress:''
				},
				uploadUrl: '${ctx}/upload.do',
				uploadAsync:true,
				ajaxSettings:{
						async:false ,
						dataType : 'text' ,
						success:function(data) {
					    	$('#projectlogo').val(data);
						}
				}
		});
	 $(".coverimage").fileinput({
			showRemove:true, //显示移除
			layoutTemplates:{
				actions: '',
				progress:''
			},
			uploadUrl: '${ctx}/upload.do',
			uploadAsync:true,
			ajaxSettings:{
					async:false ,
					dataType : 'text' ,
					success:function(data) {
				    	$('#coverimage').val(data);
					}
			}
	});
;(function($,jQuery){//闭包
	
})($,$);

</script>
</body>
</html>