<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/views/sys/includes/taglib.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<c:set var="ueditorPath" value="${ctxStatic}/ueditor/" />
<script type="text/javascript">
	window.UEDITOR_HOME_URL = '${ueditorPath}';
</script>
<script src="${ctxStatic}/jquery/jquery-1.9.1.min.js" type="text/javascript"></script>
<script src="${ctxStatic}/jquery/jquery.bootstrap.min.js" type="text/javascript"></script>
<script src="${ctxStatic}/jquery/jquery-migrate-1.1.1.min.js" type="text/javascript"></script>
<link href="${ctxStatic}/bootstrap/3.3.5/dist/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<script src="${ctxStatic}/bootstrap/3.3.5/dist/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${ctxStatic}/modules/fileinput/js/fileinput.js" type="text/javascript"></script>
<script src="${ctxStatic}/modules/fileinput/js/fileinput_locale_zh.js" type="text/javascript"></script>
<link href="${ctxStatic}/modules/fileinput/css/fileinput.css" type="text/css" rel="stylesheet" />
<%@include file="/WEB-INF/views/sys/includes/dialog.jsp"%>
<script src="${ctxStatic}/ueditor/ueditor.config.js" type="text/javascript"></script>
<script src="${ctxStatic}/ueditor/ueditor.all.min.js" type="text/javascript"></script>
<script charset="utf-8" src="${ctxStatic}/ueditor/lang/zh-cn/zh-cn.js"></script>
<script src="${ctxStatic}/modules/main.js" type="text/javascript"></script>
<title>公告发布</title>
<script type="text/javascript">
	
</script>
</head>
<body style="width: 100%">
	<ul class="nav nav-tabs">
		<li><a href="/ucenter/item/listView.do">公告列表</a></li>
		<li class="active"><a href="/ucenter/notice/formView.do">公告添加</a></li>
	</ul>
	<div style="width: 100%">
		<form style="margin: 10px;" id="dataForm" method="post" action="${ctx}/ucenter/notice/upload.do" enctype="multipart/form-data">
				<div class="form-group">
					<div class="row" style="margin-bottom: 5px;">
						<div class="col-md-1" style="text-align: right;padding: 0px 2px;width: 6%;margin-top: 6px;">
							<label for="title" style="letter-spacing: 10px;font-weight: bold;  ">标题</label>
						</div>
						<div class="col-md-11">
							<input type="text" class="form-control" id="title" name="title" style="width: 100%;height: 100%;"  placeholder="请输入公告标题！">
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<div class="row" style="margin-bottom: 5px;">
						<div class="col-md-1" style="text-align: right;padding: 0px 2px;width: 6%;margin-top: 10px;">
							<label for="uploadType1"  style="letter-spacing: 10px;font-weight: bold;  ">标题</label>
						</div>
						<div class="col-md-11">
							<div class="radio">
							    <label class="radio-inline">
								  <input type="radio" name="uploadType" id="uploadType1" value="1" checked="checked"> 富文本
								</label>
								<label class="radio-inline">
								  <input type="radio" name="uploadType" id="uploadType2" value="2"> 文件上传
								</label>
							</div>
						</div>
					</div>
				</div>
				
				<div class="form-group" id="uploadDiv" style="display: none;">
					<div class="row" style="margin-bottom: 5px;">
						<div class="col-md-1" style="text-align: right;padding: 0px 2px;width: 6%;">
							<label for="fileUpload" style="letter-spacing: 10px;font-weight: bold;  ">上传附件</label>
						</div>
						<div class="col-md-11">
							<input id="fileUpload" name="file" type="file" multiple class="file-loading">
							<input type="hidden" name="fileName" id="fileName" value="">
							<input type="hidden" name="url" id="url" value="" >
							<input type="hidden" name="filePath" id="filePath" value="" >
						</div>
					</div>
				</div>
				
				<div class="form-group" id="contentDiv" >
					<div class="row" style="margin-bottom: 5px;">
						<div class="col-md-1" style="text-align: right;padding: 0px 2px;width: 6%;">
							<label for="content" style="margin-bottom: 5px;letter-spacing: 10px;font-weight: bold; ">正文</label>
						</div>
						<div class="col-md-11">
							<script id="content" name="content" type="text/plain" style="width: 100%">
      			 
    						</script>
						</div>
					</div>
				</div>
				
				<div class="form-group"  style="margin-bottom: 5px;">
					<div class="row" style="margin-top: 10px;">
						<div class="col-md-1" style="text-align: right;padding: 0px 2px;width: 6%;"></div>
						<div class="col-md-11" >
							 <button type="button" id="chooseUsers" class="btn btn-info" data-toggle="modal" style="float: left;">选择发送对象</button>
							 <button type="button" id="publishBtn" class="btn btn-info" style="margin-left: 30px;letter-spacing: 10px;"> 发布</button>
						</div>
					</div>
				</div>
				
				
				<div class="form-group"  style="margin-bottom: 5px;">
					<div class="row" style="margin-top: 10px;">
						<div class="col-md-1" style="text-align: right;padding: 0px 2px;width: 6%;"></div>
						<div class="col-md-11" >
							 <div class="panel panel-success">
							     <div class="panel-heading"><span class="glyphicon glyphicon-hand-right" style="margin-right: 10px;"></span><strong>已选择发送对象</strong></div>
							     <div class="panel-body" id="choosedUsersDiv">
							     </div>
							 </div>
						</div>
					</div>
				</div>
			 
		</form>
	</div>
	
	<div id="chooseUserModal" class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
		  <div class="modal-dialog modal-lg">
		     <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			      </div>
			      <div class="modal-body" id="chooseUserModalBody">
			         
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
			        <button type="button" class="btn btn-primary" id="chooseUserConfirmBtn">确定</button>
			      </div>
			 </div>
		  </div>
		</div>
	
	<script type="text/javascript">
		var ue = UE.getEditor('content',{
				initialFrameHeight:400
			});
		//选择公告的发布方式
		$("input[name='uploadType']").click(function(){
			console.log(this.checked);
			if(this.value=="1"){
				$("#uploadDiv").hide();
				$("#contentDiv").show();
			}else if(this.value=="2"){
				$("#uploadDiv").show();
				$("#contentDiv").hide();
			}
		});
		
		$(function(){
			$('#publishBtn').click(function(){
				var data = getFormData("#dataForm");
				if($.trim(data.title)==""){
					$.messager.alert('提示', '请先填写公告标题!', 'info');
					return ;
				}
				if(data.uploadType=="1"){//以富文本方式发布公告
					if($.trim(data.content)==""){
						$.messager.alert('提示', '请先填写公告内容!', 'info');
						return ;
					}
					data.content = ue.getAllHtml();
				}else if(data.uploadType=="2"){//以附件方式发布公告
					var fileName = $('#fileName').val();
					if($.trim(fileName)==""){
						$.messager.alert('提示', '请先上传公告附件!', 'info');
						return ;
					}
					//删除不必要的数据,提高网络传输速率
					if(data.content){delete data.content};
				}
				//验证是否已选择发送对象
				if($.trim($("#choosedUsersDiv").html())==""){
					$.messager.alert('提示', '请先选择发送对象!', 'info');
					return ;
				}
				//定义已选部门ID列表,已选标签列表,已选用户ID列表
				var selectedDepartmentIds=[];
				var selectedTagIds=[];
				var selectedUserIds=[];
				var buttons = $("#choosedUsersDiv").find('button');
				$.each(buttons,function(index,item){
					var treeNode = JSON.parse($(item).attr('data'));
					if(treeNode.treeId=='deptMenuDiv'&&treeNode.isParent){//部门ID节点
						selectedDepartmentIds.push(treeNode.id);
					}else if(treeNode.treeId=='tagMenuDiv'&&treeNode.isParent){//标签ID节点
						selectedTagIds.push(treeNode.id);
					}else{
						//此处不去重复，交后台服务器处理
						selectedUserIds.push(treeNode.id);
					}
				});
				//添加发送对象列表集合
				data['selectedUserIds']=selectedUserIds.join(",");
				data['selectedTagIds']=selectedTagIds.join(",");
				data['selectedDepartmentIds']=selectedDepartmentIds.join(",");
				//console.log(data);
				//提交请求
				var url = "${ctx}/ucenter/notice/publish.do";
				sendAjaxRequest(null, url, 'POST', 'json', data, function(result){
					$.messager.alert('提示', result.message, 'info');
				});
			});

			
			//选择发送对象按钮绑定click事件
			var reloadModal = true;
			$('#chooseUsers').click(function(){
				var url = '${ctx}/wechat/notice/toShowUserTree.do';
				//加载一次用户组织树之后不需要再重复加载树,这样可以保存操作数据状态,当发布之后，需将reloadModal置为true,清空操作数据，重新加载树
				if(reloadModal){
					sendAjaxRequest("#chooseUserModalBody", url, 'GET', 'html', null, function(result){
						reloadModal = false;
						$('#chooseUserModal').modal('show');
					});
				}else{
					$('#chooseUserModal').modal('show');
				}
				
			});
			//模态框确定按钮click事件
			$('#chooseUserConfirmBtn').click(function(){
				$("#choosedUsersDiv").html($('#selectedUsersDiv').html());
				$('#chooseUserModal').modal('hide');
			});
			
			//上传附件
			$("#fileUpload").fileinput({
		        overwriteInitial: true,
		        maxFileSize: 2048,
		        initialCaption: "请上传附件!" ,
		        uploadAsync:true,
		        showPreview:false,
		        uploadUrl :"${ctx}/ucenter/notice/upload.do",
		        layoutTemplates:{
					actions: '',
					progress:''
				},
				ajaxSettings:{
					async:true ,
					dataType :'json',
					success:function(result) {
						$.messager.alert('提示', result.message, 'info');
				    	$("#url").val(result.url);
				    	$('#fileName').val(result.fileName);
				    	$('#filePath').val(result.filePath);
					}
			    }
		    });
		});
		
		
		
	</script>
</body>
</html>