<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/views/sys/includes/taglib.jsp"%>
<html>
<head>
<title>添加题目-投票管理</title>
<meta name="decorator" content="default" />
<%@include file="/WEB-INF/views/sys/includes/dialog.jsp"%>
<style type="text/css">
.row .span{
	float: left;
	margin: 2px 2px;
}
.JS-SAVE{
	font-size: 18px;
	line-height: 30px;
    margin-left: 10px;
}
</style>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="/votes/vote/topicListView.do">题目列表</a></li>
		<li  class="active"><a href="/votes/vote/topicFormView.do">题目添加</a></li>
	</ul>
	<br />
	<form:form id="inputForm" modelAttribute="voteTopic" action="/ucenter/usergroup/edit.do" method="post" class="form-horizontal">
		<form:hidden path="id" />
		<div class="control-group">
			<label class="control-label">题目类型:</label>
			<div class="controls">
				<label class="radio inline" >
				    <form:radiobutton path="kinds" value="0"/><span>单选</span>
				 </label>
				 <label class="radio inline" >
				    <form:radiobutton path="kinds" value="1"/><span>多选</span>
				 </label>
			</div>
		</div>
		<div class="control-group hide" id="JS-KINDS-CHECKBOX">
			<div class="controls row">
				<p class="span">每人最多投 </p>
				<form:input type="number" path="maxvote" htmlEscape="false" maxlength="50" class="required maxvote input-small span" />
				<p class="span">票</p>
			</div>
			<div class="controls row ">
				<p class="span">每人最少投 </p>
				<form:input type="number" path="mixvote" htmlEscape="false" maxlength="50" class="required mixvote span input-small" />
				<p class="span">票</p>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">题目标题:</label>
			<div class="controls">
				<form:input path="title" htmlEscape="false" maxlength="50" class="required title" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注:</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="3" maxlength="200" class="input-xlarge" />
			</div>
		</div>
		<div class="control-group hide" id="JS-OPTIONS-GROUP">
			<div class="controls row hide">
				<p class="add-on span">>></p><a id="JS-OPTIONS-BUTTON" class="span" href="javascript:void(0);" data-count="0" data-save="false">添加选项</a>
			</div>
		</div>
		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-primary" type="button" data-flag="0" value="添加选项" />
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)" />
		</div>
	</form:form>
	<script>
	;(function($){
		$('input:radio').on('click',function(){
			var _this = this;
			if( $(_this).val() == 0 ) {
				$('#JS-KINDS-CHECKBOX').addClass('hide');
				$('#maxvote').val(1)&&$('#minvote').val(1);
			}
			if( $(_this).val() == 1 ) {
				$('#JS-KINDS-CHECKBOX').removeClass('hide');
				$('#maxvote').val('')&&$('#minvote').val('');
			}
		});
		$('#JS-OPTIONS-BUTTON').on('click',function(){
			var _this = this,count=$(_this).attr('data-count'),
				saveFlag = $(_this).attr('data-save');
			
			if(  parseInt(count) > 0 && saveFlag == 'false' ){
				$.jBox.alert('请填写选项,并保存...','提示');
				return false;
			}
			var html = '<div class="controls row">\
				<input type="text" class="input span" name="option_' + count + '">\
				<a href="javascript:void(0);" class="span JS-SAVE btn-link">保存</a>\
			</div>';
			$('#JS-OPTIONS-GROUP').append(html);
			$(_this).attr('data-save','false');
			$(_this).attr('data-count',count + 1 );
			
			
		});
		$('#JS-OPTIONS-GROUP').on('click','div a',function(event){
			console.log(event.target)
			var _this = this;
			var title = $(_this).siblings('input').val();
			if(title == ''){
				$.jBox.alert('请填写选项...','提示');
				return false;
			}
			$('#JS-OPTIONS-BUTTON').attr('data-save','true');
			//保存选项
		});
		
		$('input.btn-primary').on('click',function(){
			var _this = this;
			var flag = $(_this).attr('data-flag');
			if( flag == 1 ){
				//进行保存操作
			}
			if( flag == 0 ){
				var kinds = $('input[type=radio]:checked').val();
				if( !kinds ){
					$.jBox.alert('请选择题目类型...','提示');
					return false;
				}
				if( kinds == 1 ){
					var maxvote = $('#maxvote').val();
					var minvote = $('#minvote').val();
					if( maxvote == '' ) {
						$.jBox.alert('请填写最大投票数...','提示');
						return false;
					}
					if( minvote == '' ) {
						$.jBox.alert('请填写最小投票数...','提示');
						return false;
					}
				}
				var title = $('#title').val();
				if( title == '' ){
					$.jBox.alert('请填写题目标题...','提示');
					return false;
				}
				$('#JS-OPTIONS-GROUP').removeClass('hide');
				$('#JS-OPTIONS-GROUP .row').removeClass('hide');
				$(_this).val('保存');
			}
		});
	})($);
	</script>
</body>
</html>