<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/views/sys/includes/taglib.jsp"%>
<html>
<head>
<title>角色本体列表-角色管理</title>
<meta name="decorator" content="default" />
<%@include file="/WEB-INF/views/sys/includes/dialog.jsp"%>
<style type="text/css">
.sort {
	color: #0663A2;
	cursor: pointer;
}
.btn-config {
	float: right;
	margin-right: 10px;
}
</style>
</head>
<body>
	<div class="container-fluid" id="main">
		<h1><small>${role.rolename }</small></h1>
		<dd> —— <i><fmt:formatDate value="${role.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></i> </dd>
		<dd> —— <i>${role.remarks}</i> </dd>
		<ul id="JS_SUBJECT_NAV" class="nav nav-tabs">
			<li class="active" data-type="UNISKUSER"><a href="javascript:void(0);">用户列表</a></li>
			<li data-type="USERGROUP"><a href="javascript:void(0);" data-type="group">用户组列表</a></li>
		</ul>
	</div>
	<div class="container-fluid" id="search">
		<form:form modelAttribute="subjects" id="subjectSearch" action="${ctx}/ucenter/subject/listView.do?roleid=${role.id}" method="post" class="breadcrumb form-search">
			<label for="mastervalue">角色主体：</label>
			<form:input path="mastervalue" htmlEscape="false" maxlength="50"  />
			<label for="master">角色类型：</label>
			<form:select path="master">
				<form:option value="UNISKUSER">用户</form:option>
				<form:option value="USERGROUP">用户组</form:option>
			</form:select>
			<input id="btnSubmit" class="btn btn-primary btn-query" type="submit" value="查询" />
			<a class="btn btn-config" href="javascript:void(0);" id="JS_CONFIG_SUBJECT">配置本体</a>
		</form:form>
	</div>
	
	<div class="container-fluid" id="JS_SUBJECT_UNISKUSER">
		<table id="contentTable" class="table table-striped table-bordered">
		<thead>
			<tr>
				<th>序号</th>
				<th>登录名</th>
				<th>姓名</th>
				<th>电话</th>
				<th>手机</th>
				<th>操作</th>
				<!--<shiro:hasPermission name="sys:user:edit">
					<th>操作</th>
				</shiro:hasPermission>-->
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${pageUser.data}" var="user" varStatus="vs">
				<tr>
					<td>${vs.count }</td>
					<td>${user.username}</td>
					<td>${user.realname}</td>
					<td>${user.phone}</td>
					<td>${user.mobile}</td>
					<td><a href="${ctx}/ucenter/user/delete.do?id=${user.id}"
						onclick="return confirmx('确认要删除该用户吗？', this.href)">删除</a> <!-- a href="${ctx}/sys/user/domin?id=${user.id}">管辖地区</a -->
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page.getPageHtml()}</div>	
	</div>
	<!-- *************************************************************************************** -->
	<!-- 角色本体之用户组                                                                                                                                                                                                   -->
	<!-- *************************************************************************************** -->
	<div class="container-fluid" id="JS_SUBJECT_USERGROUP">
		<table id="contentTable" class="table table-striped table-bordered">
		<thead>
			<tr>
				<th>序号</th>
				<th>用户组名</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${pageGroup.data}" var="userGroup" varStatus="vs">
				<tr>
					<td>${vs.count }</td>
					<td>${userGroup.groupname }</td>
					<td><a href="${ctx}/ucenter/user/delete.do?id=${userGroup.id}"
						onclick="return confirmx('确认要删除该用户吗？', this.href)">删除</a> <!-- a href="${ctx}/sys/user/domin?id=${user.id}">管辖地区</a -->
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page.getPageHtml()}</div>	
	</div>
<script>
	(function($){
		$('#JS_SUBJECT_USERGROUP').hide();
		$('#JS_SUBJECT_NAV li').on('click',function(){
			var _this = this;
			if( !$(_this).hasClass('active') ){
				$(_this).addClass('active').siblings('li').removeClass('active');
				$( '#JS_SUBJECT_' + $(_this).attr('data-type') ).show().siblings('div').not('#search').not('#main').hide();
				$('#mastervalue').val('') && $('#master').val( $(_this).attr('data-type') );
			}
		});
		$('#JS_CONFIG_SUBJECT').bind('click',function(){
			var master = $('#JS_SUBJECT_NAV li.active').attr('data-type');
			//配置相关的路径，传递角色id
			var iframeUrl = "";
			var iframeName = '用户';
			if( master == 'UNISKUSER' ){//用户的路径
				iframeUrl = "${ctx}/ucenter/user/usubjectview.do?userRolesId=${role.id}";
				iframeName = '用户';
			}
			if( master == 'USERGROUP' ){//用户组的路径
				iframeUrl = "${ctx}/ucenter/user/ugropview.do?userRolesId=${role.id}";
				iframeName = '用户组';
			}
			$.jBox("iframe:" + iframeUrl, {
		    	title: "配置角色本体[" + iframeName + "]",
		    	top:'2%',
		    	width: 1024,
		    	height: 500,
		    	buttons: { '确定' : 'ok' },
		    	submit:function(v,h,f){
		    	//v 点击按钮的值，比如点击的是上面buttons定义的关闭按钮，那么v=true
		    	//h 前一个页面的Jqeury对象
		    	//f 弹出层中form表单键值
		    	if (v == 'ok') {
						var iframeName = h.children(0).attr("name");
						var container = window.frames[iframeName].document
						var checked = $('input[type="checkbox"]:checked',container).not(".checkAll");
						var uids = '';
						$.each(checked,function(index,item) {
							uids += $(item).val()+ ',';
						});
						uids = uids.substr(0,uids.length - 1);
						alert(uids);
						//window.location.href = '${ctx}/ucenter/userandug/add.do?usergroupid=${usergp.id}&userId='+ uids;
					}
		    	}
			});
		});
	})($);
</script>
</body>
</html>