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
.list-group-item {
    border: 0px;
}
.list-group-item .label {
	font-size:12px;
    margin: 2px 2px;
    display: inline-block;
}
blockquote {
    padding: 0px 0px;
    margin: 0 0 20px;
    font-size: 17.5px;
    border-left: 5px solid #337ab7;
}
</style>
<script type="text/javascript">
	//定义全局已选部门ID列表,已选标签列表,已选用户ID列表
	var selectedDepartmentIds=[];
	var selectedTagIds=[];
	var selectedUserIds=[];

	wx.config({
	    debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
	    appId: 'wxfcb21d8e71642675', // 必填，企业号的唯一标识，此处填写企业号corpid
	    timestamp: '${data.timestamp}', // 必填，生成签名的时间戳
	    nonceStr: '${data.noncestr}', // 必填，生成签名的随机串
	    signature: '${data.signature}',// 必填，签名，见附录1
	    jsApiList: ['openEnterpriseChat','openEnterpriseContact'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
	});
	
	wx.error(function(res){
		console.log(res);
	    // config信息验证失败会执行error函数，如签名过期导致验证失败，具体错误信息可以打开config的debug模式查看，也可以在返回的res参数中查看，对于SPA可以在这里更新签名。

	});

	$(function(){
		//打开企业通讯录选人
		var evalWXjsApi = function(jsApiFun) {
		    if (typeof WeixinJSBridge == "object" && typeof WeixinJSBridge.invoke == "function") {
		        jsApiFun();
		    } else {
		        document.attachEvent && document.attachEvent("WeixinJSBridgeReady", jsApiFun);
		        document.addEventListener && document.addEventListener("WeixinJSBridgeReady", jsApiFun);
		    }
		};
		
		$('#openEnterpriseContact_invoke').click(function() {
		    evalWXjsApi(function() {
		        WeixinJSBridge.invoke("openEnterpriseContact", {
		            "groupId": "${contactData.groupId}",    // 必填，管理组权限验证步骤1返回的group_id
		            "timestamp": "${contactData.timestamp}",    // 必填，管理组权限验证步骤2使用的时间戳
		            "nonceStr": "${contactData.noncestr}",    // 必填，管理组权限验证步骤2使用的随机字符串
		            "signature": "${contactData.signature}",  // 必填，管理组权限验证步骤2生成的签名
		            "params" : {
		                'departmentIds' : [0],    // 非必填，可选部门ID列表（如果ID为0，表示可选管理组权限下所有部门）
		                'tagIds' : [0],    // 非必填，可选标签ID列表（如果ID为0，表示可选所有标签）
		                'mode' : 'multi',    // 必填，选择模式，single表示单选，multi表示多选
		                'type' : ['department','tag','user'],    // 必填，选择限制类型，指定department、tag、user中的一个或者多个
		                'selectedDepartmentIds' : selectedDepartmentIds,    // 非必填，已选部门ID列表
		                'selectedTagIds' : selectedTagIds,    // 非必填，已选标签ID列表
		                'selectedUserIds' : selectedUserIds,    // 非必填，已选用户ID列表
		            },
		        }, function(res) {
		            if (res.err_msg.indexOf('function_not_exist') > 0) {
		                alert('版本过低请升级');
		            } else if (res.err_msg.indexOf('openEnterpriseContact:fail') > 0) {
		                return;
		            }
		            /* for(var key in res){
						$('#showSelectedDiv1').append(res[key]);
			        }  */
			        //openEnterpriseContact:ok{"selectAll":false,"departmentList":[],"tagList":[],"userList":[{"id":"shiyuehe","name":"徐皓","photo":"http://shp.qpic.cn/bizmp/8UXUj8DBNdBAIebMrFFib3OwcGvHz6A2lH43hCWxbibWnbeMkmmibDh6w/64"},{"id":"markeness","name":"张京","photo":"http://shp.qpic.cn/bizmp/8UXUj8DBNdB2bn0WfvwAqsqT7dD2uNowWwJDsa34pwF8T7FUzEuTibQ/64"}]}
		            //全选时返回openEnterpriseContact:ok{"selectAll":true,"departmentList":[],"tagList":[],"userList":[]}
		            var result = JSON.parse(res.result);    // 返回字符串，开发者需自行调用JSON.parse解析
		            var selectAll = result.selectAll;     // 是否全选（如果是，其余结果不再填充）
		            var showUserDiv = "";
		            //清空以前选择的用户，重新赋值
	            	selectedDepartmentIds=[];
	            	selectedTagIds=[];
	            	selectedUserIds=[];
		            if (!selectAll)
		            {   
		                selectedDepartmentList = result.departmentList;    // 已选的部门列表
		                for (var i = 0; i < selectedDepartmentList.length; i++) {
		                    var department = selectedDepartmentList[i];
		                    var departmentId = department.id;    // 已选的单个部门ID
		                    selectedDepartmentIds.push(departmentId);
		                    var departemntName = department.name;    // 已选的单个部门名称
		                    showUserDiv +=appendHtml(departemntName,null);
		                }
		                var selectedTagList = result.tagList;    // 已选的标签列表
		                for (var i = 0; i < selectedTagList.length; i++) {
		                    var tag = selectedTagList[i];
		                    var tagId = tag.id;    // 已选的单个标签ID
		                    selectedTagIds.push(tagId);
		                    var tagName = tag.name;    // 已选的单个标签名称
		                    showUserDiv +=appendHtml(tagName,null);
		                }
		                var selectedUserList = result.userList;    // 已选的成员列表
		                for (var i = 0; i < selectedUserList.length; i++) {
		                    var user = selectedUserList[i];
		                    var userId = user.id;    // 已选的单个成员ID
		                    selectedUserIds.push(userId);
		                    var userName = user.name;    // 已选的单个成员名称
		                    showUserDiv +=appendHtml(userName,user.photo);
		                }
		            }else{
		            	showUserDiv +=appendHtml("所有用户",null);
			        }
			        if(showUserDiv!=""){
			        	 $('#showSelectedDiv').html(showUserDiv);
				    }
		        });
		    });
		});		

		function appendHtml(showName,photoUrl){
			//return "<div class=\"alert alert-success alert-dismissible\" role=\"alert\"><button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button> <span>"+showName+"</span></div>";
			//暂时不显示微信用户图片
			/* if(photoUrl){
				return "<span class=\"label label-success\"><img alt=\""+showName+"\" src=\""+photoUrl+"\"></img>"+showName+"</span>&nbsp;&nbsp;";
			} */
			return "<span class=\"label label-success\">"+showName+"</span>&nbsp;&nbsp;";
		}

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
	<div class="page-header ">
	<blockquote>
	  <h1 class="center-block">发布公告</h1>
	</blockquote>
	</div>
	<form id="formData">
		<div class="form-group">
		    <label for="title"><h4>请输入标题</h4></label>
		    <input id="title" name="title" type="text" class="form-control" placeholder="请输入标题...">
		</div>
		<div class="form-group">
		    <label for="content"><h4>请输入公告正文</h4></label>
		    <textarea class="form-control" id="content" name="content" rows="6" placeholder="请输入公告正文..."></textarea>
		</div>
		<div class="form-group">
		   <ul class="list-group">
			  <li class="list-group-item" id="openEnterpriseContact_invoke">
			    <span class="badge"><span class="glyphicon glyphicon-menu-right"><!-- 图标类 --></span></span>
			      请选择发布对象
			  </li>
			</ul>
		</div>
		<div id="showSelectedDiv"></div>
	  	<br/>
		<button type="button" id="publishBtn" class="btn btn-primary btn-lg btn-block">发     布</button>
	</form>
</div>
</body>
</html>