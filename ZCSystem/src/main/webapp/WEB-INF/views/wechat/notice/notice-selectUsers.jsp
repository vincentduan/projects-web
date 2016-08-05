<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="ctxStatic" value="${pageContext.request.contextPath}/statics"/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- 注意：如果本页面作为单独页面时，此三条配置需放开;若作为bootstrap模态框的形式被其他页面加载时，需要注释掉此配置，防止同一页面加载jquery,bootstrap重复了导致用不了jquery -->
<%-- 
<script src="${ctxStatic}/jquery/jquery-1.9.1.min.js" type="text/javascript"></script>
<link href="${ctxStatic}/bootstrap/3.3.5/dist/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<script src="${ctxStatic}/bootstrap/3.3.5/dist/js/bootstrap.min.js" type="text/javascript"></script> 
--%>

<link href="${ctxStatic}/jquery-ztree/3.5.12/css/zTreeStyle/zTreeStyle.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${ctxStatic}/jquery-ztree/3.5.12/js/jquery.ztree.all-3.5.min.js"></script>
<style type="text/css">
.ztree li span.button.user_glyphicon_ico_open{margin-right:2px; background: url(${ctxStatic}/jquery-ztree/3.5.12/css/zTreeStyle/img/diy/user.gif) no-repeat scroll 0 0 transparent; vertical-align:top; *vertical-align:middle}
.ztree li span.button.user_glyphicon_ico_close{margin-right:2px; background: url(${ctxStatic}/jquery-ztree/3.5.12/css/zTreeStyle/img/diy/user.gif) no-repeat scroll 0 0 transparent; vertical-align:top; *vertical-align:middle}
.ztree li span.button.user_glyphicon_ico_docu{margin-right:2px; background: url(${ctxStatic}/jquery-ztree/3.5.12/css/zTreeStyle/img/diy/user.gif) no-repeat scroll 0 0 transparent; vertical-align:top; *vertical-align:middle}
.tag-item{display: inline-block;line-height: 25px;margin: 5px;padding-right: 12px;}
.tag-item-close{float: none;position: relative;top: 4px;left: 8px;}
</style>
<title>选择发送范围</title>
<script type="text/javascript">
	var treeContainer = {};//定义承装ztree对象的容器
	var zTreeByDept,zTreeByTag;
	$(function(){
		//定义zTree初始化配置信息
		var setting = {
			view: {
				showLine: true,
				selectedMulti: true  //允许多选
			},
			data: {
				simpleData: {
					enable: true
					
				}
			},
			edit: {				
				enable: false,      //不允许编辑
			},
			check: {
					enable: true   // 是否显示复选框
			},
			callback: {
					beforeCheck: zTreeBeforeCheck,
					onCheck: zTreeOnCheck
			}
		};
		var deptMenuNodes = ${deptMenuNodes};//按部门节点集合
		var tagMenuNodes = ${tagMenuNodes};//按标签节点集合

		//初始化部门菜单树
		var t1 = $("#deptMenuDiv");
		t1 = $.fn.zTree.init(t1, setting, deptMenuNodes);	
		zTreeByDept = $.fn.zTree.getZTreeObj("deptMenuDiv");
		zTreeByDept.expandAll(true);//展开全部节点
		treeContainer['deptMenuDiv'] = zTreeByDept;

		//初始化标签菜单树
		var t2 = $("#tagMenuDiv");
		t2 = $.fn.zTree.init(t2, setting, tagMenuNodes);	
		zTreeByTag = $.fn.zTree.getZTreeObj("tagMenuDiv");
		treeContainer['tagMenuDiv'] = zTreeByTag;
	});

	function zTreeBeforeCheck(treeId, treeNode){
		var checkStatus = treeNode.getCheckStatus();
		//console.log(checkStatus);
		//父节点是半选状态下的逻辑处理
		if(checkStatus.half==true){
			removeSelected(treeNode);
		}
		if(!treeNode.checked){
			treeNode['treeId']=treeId;//将treeId织入节点中,方便后续判断节点来自哪个树
			var html = '<span name="span_'+treeNode.id+'" class="label label-success tag-item"><span>'+treeNode.name+'</span><button type="button" id="btn_'+treeNode.id+'" data=\''+JSON.stringify(treeNode)+'\' class="close tag-item-close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button></span>';
			$('#selectedUsersDiv').append(html);
		}else{
			$('span[name="span_'+treeNode.id+'"').remove();
		}
		return true;
	}

	//勾选 或 取消勾选的事件回调函数
	function zTreeOnCheck(event, treeId, treeNode){
		checkNode(treeNode,treeContainer[treeId]);
	};

	function checkNode(treeNode,zTree){
		if(treeNode.isParent){
			for(var i = 0;treeNode.children && i<treeNode.children.length;i++){
				//设置节点是否可以check
				zTree.setChkDisabled(treeNode.children[i],treeNode.checked,false,false);
				if(!treeNode.checked){
					zTree.checkNode(treeNode.children[i], false, false);
				};
				//如果子节点仍然是目录节点，则递归调用
				if(treeNode.children[i].isParent){
					checkNode(treeNode.children[i],zTree);//递归调用
				};
			};
		}
	};

	function removeSelected(treeNode){
		//移除目录节点
		if(treeNode.checked){
			$('span[name="span_'+treeNode.id+'"').remove();
		}
		//移除叶子节点
		for(var i = 0;treeNode.isParent && treeNode.children && i<treeNode.children.length;i++){
			var childNode = treeNode.children[i];
			if(childNode.isParent&&childNode.children){
				removeSelected(childNode);//如果子节点仍然是目录节点，则递归调用
			}else{
				$('span[name="span_'+treeNode.children[i].id+'"').remove();
			};
		};
	}
	
</script>
</head>
<body>
 <div class="panel panel-default">
  <div class="panel-body">
	<div class="panel panel-primary" >
		<div class="panel-heading"><span class="glyphicon glyphicon-hand-right" style="margin-right: 10px;"></span><strong>用户组织树</strong></div>
		<div class="panel-body">
		  <ul class="nav nav-tabs" role="tablist">
		    <li role="presentation" class="active"><a href="#selectByDept" aria-controls="selectByDept" role="tab" data-toggle="tab">按部门</a></li>
		    <li role="presentation"><a href="#selectByTag" aria-controls="selectByTag" role="tab" data-toggle="tab">按标签</a></li>
		  </ul>
		
		  <!-- Tab panes -->
		  <div class="tab-content">
		  	<!-- 按部门组织树 开始 -->
		    <div role="tabpanel" class="tab-pane active" id="selectByDept">
		    	<div id="deptMenuDiv" class="ztree" style="margin: 10px 2px;">
		    	
		    	</div>
		    </div>
		    <!-- 按部门组织树 结束 -->
		   	
		    <!-- 按标签组织树 开始 -->
		    <div role="tabpanel" class="tab-pane" id="selectByTag">
		    	<div id="tagMenuDiv" class="ztree" style="margin: 10px 2px;">
		    	
		    	</div>
		    </div>
		    <!-- 按标签组织树 结束 -->
		  </div>
		
		</div>
		
	</div>
	
	<div class="panel panel-success">
	  <div class="panel-heading"><span class="glyphicon glyphicon-hand-right" style="margin-right: 10px;"></span><strong>已选择发送对象</strong></div>
	  <div class="panel-body" id="selectedUsersDiv">
	  	
	  </div>
	</div>
	
	
	
	
	</div>
	</div>

	<script type="text/javascript">
		$(function(){
			//绑定取消事件
			$('body').on('click','.tag-item-close',function(){
				var data = JSON.parse($(this).attr('data'));//通过json转化的节点缺少函数属性，故需要根据节点id重新获取treeNode
				var zTree = treeContainer[data.treeId];
				var treeNode = zTree.getNodeByTId(data.tId);
				zTree.checkNode(treeNode, false, true,true);
			});

		})
	</script>
</body>
</html>