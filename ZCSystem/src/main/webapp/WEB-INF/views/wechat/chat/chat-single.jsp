<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
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
<link href="${ctx}/statics/bootstrap/2.3.1/css_${not empty cookie.theme.value ? cookie.theme.value:'default'}/bootstrap.min.css" type="text/css" rel="stylesheet" />
<script src="${ctx}/statics/bootstrap/2.3.1/js/bootstrap.min.js" type="text/javascript"></script>
<title>私聊</title>
<script type="text/javascript">

	//定义全局已选部门ID列表,已选标签列表,已选用户ID列表
	var selectedDepartmentIds=[];
	var selectedTagIds=[];
	var selectedUserIds=[];
	var selectedUserNames=[];

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

	wx.ready(function(res){
		WeixinJSBridge.call('closeWindow');
		//打开企业通讯录选人
		var evalWXjsApi = function(jsApiFun) {
		    if (typeof WeixinJSBridge == "object" && typeof WeixinJSBridge.invoke == "function") {
		        jsApiFun();
		    } else {
		        document.attachEvent && document.attachEvent("WeixinJSBridgeReady", jsApiFun);
		        document.addEventListener && document.addEventListener("WeixinJSBridgeReady", jsApiFun);
		    }
		};
		
	    evalWXjsApi(function() {
	        WeixinJSBridge.invoke("openEnterpriseContact", {
	            "groupId": "${contactData.groupId}",    // 必填，管理组权限验证步骤1返回的group_id
	            "timestamp": "${contactData.timestamp}",    // 必填，管理组权限验证步骤2使用的时间戳
	            "nonceStr": "${contactData.noncestr}",    // 必填，管理组权限验证步骤2使用的随机字符串
	            "signature": "${contactData.signature}",  // 必填，管理组权限验证步骤2生成的签名
	            "params" : {
	                'departmentIds' : [0],    // 非必填，可选部门ID列表（如果ID为0，表示可选管理组权限下所有部门）
	                'tagIds' : [0],    // 非必填，可选标签ID列表（如果ID为0，表示可选所有标签）
	                'mode' : 'single',    // 必填，选择模式，single表示单选，multi表示多选
	                'type' : ['user'],    // 必填，选择限制类型，指定department、tag、user中的一个或者多个
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
	            var result = JSON.parse(res.result);    // 返回字符串，开发者需自行调用JSON.parse解析
	            var selectAll = result.selectAll;     // 是否全选（如果是，其余结果不再填充）
	            if (!selectAll)
	            {   
		            //清空以前选择的用户，重新赋值
	            	selectedDepartmentIds=[];
	            	selectedTagIds=[];
	            	selectedUserIds=[];
	            	
	                
	                var selectedUserList = result.userList;    // 已选的成员列表
	                for (var i = 0; i < selectedUserList.length; i++) {
	                    var user = selectedUserList[i];
	                    var userId = user.id;    // 已选的单个成员ID
	                    selectedUserIds.push(userId);
	                    var userName = user.name;    // 已选的单个成员名称
	                    selectedUserNames.push(userName);
	                }
	            }
	            var userIds = "";
	            if(selectedUserIds.length>0){
					userIds +=selectedUserIds.pop();
					wx.openEnterpriseChat({
					    userIds: userIds,    // 必填，参与会话的成员列表。格式为userid1;userid2;...，用分号隔开，最大限制为1000个。userid单个时为单聊，多个时为群聊。
					    groupName: "",  // 必填，会话名称。单聊时该参数传入空字符串""即可。
					    success: function(res) {
					        // 回调
					    	 
					    },
					    fail: function(res) {
					        if(res.errMsg.indexOf('function not exist') > 0){
					            alert('版本过低请升级');
					        }
					    }
					});
		        }
	        });
	    });
	});		

</script>
</head>
<body >

</body>
</html>