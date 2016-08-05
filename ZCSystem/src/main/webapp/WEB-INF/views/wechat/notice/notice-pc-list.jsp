<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/views/sys/includes/taglib.jsp"%>
<html>
<head>
<title>公告消息列表</title>
<meta name="decorator" content="default" />
<%@include file="/WEB-INF/views/sys/includes/dialog.jsp"%>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="/ucenter/item/listView.do">公告列表</a></li>
		<li><a href="/ucenter/notice/formView.do">公告添加</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="item"
		action="/ucenter/notice/listView.do" method="post"
		class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="" />
		<input id="pageSize" name="pageSize" type="hidden" value="" />
		<input id="orderBy" name="orderBy" type="hidden" value="" />
		<div style="margin-top: 8px;">
			<label>发布时间从：</label>
			<span class="input-append date" id="beginTimeDiv" data-date-format="yyyy-mm-dd HH:ii:ss">
			    <input class="span3" size="25" type="text" id="beginTime" name="beginTime">
			    <span class="add-on" title="选择"><i class="icon-th"></i></span>
			    <span class="add-on" title="清空"><i class="icon-remove" ></i></span>
			</span>
			<span style="margin: 0 10px;">至</span>
			<span class="input-append date" id="endTimeDiv" data-date-format="yyyy-mm-dd HH:ii:ss">
			    <input class="span3" size="25" type="text" id="endTime" name="endTime">
			    <span class="add-on" title="选择"><i class="icon-th"></i></span>
			    <span class="add-on" title="清空"><i class="icon-remove" ></i></span>
			</span>      
			<input id="btnSubmit" class="btn btn-primary btn-query" type="submit" value="查询" />
		</div>
	</form:form>
	<table id="contentTable" class="table table-striped table-bordered">
		<thead>
			<tr>
				<th>序号</th>
				<th>标题</th>
				<th>创建时间</th>
				<th>创建人</th>
				<th>发布状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.data}" var="item" varStatus="status">
				<tr>
				    <td>${status.index + 1 }</td>
					<td>${item.title}</td>
					<td><fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
					<td>${item.creatorName}</td>
					<td>${item.statusName}</td>
					<td>
						<a href="${ctx}/ucenter/notice/formView.do?id=${item.id}">修改</a> 
						<c:if test="${item.status == 0}">
							<a href="${ctx}/ucenter/notice/delete.do?id=${item.id}" onclick="return confirmx('确认要删除该用户吗？', this.href)">删除</a>
							<a class="syncButton" href="javascript:void(0);" data-href="${ctx}/ucenter/notice/sync.do" data-flag="item" data-id="${item.id}" style="letter-spacing: 5px;">发布</a> 
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page.getPageHtml()}</div>
	<script type="text/javascript">
		$(function(){
			$('.syncButton').on('click',function(){
				var _this = this;
				var params = {flag:$(_this).attr('data-flag'),id:$(_this).attr('data-id')};
				sendRequestPost($(_this).attr('data-href'),params,function(data){
					if(data.status == 0 ){
						$.jBox.alert(data.desc,'提示');
						window.locaton.href = window.locaton.href; 
					}
				});
			});
			console.log($(".date"));
			 $(".date").datetimepicker({
			        format:"yyyy-mm-dd hh:ii:ss",
			        autoclose:true,
			        minView:1,
			        todayBtn:true,
			        todayHighlight:true,
			        language:'zh-CN'
			 });
		});
	</script>
</body>
</html>