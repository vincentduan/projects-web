<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商户管理>>合同管理</title>
<script type="text/javascript">
	window.onload = function() {
		document.getElementById('商户管理').className = "hover";
	}
</script>
<!--[if IE 6]>
<SCRIPT src="http://d1.lashouimg.com/static/js/release/iepng.js"></SCRIPT>
<script type="text/javascript">
	DD_belatedPNG.fix('.iepng');
</script>
<![endif]-->
</head>
<body>
	<%@ include file="/WEB-INF/view/common/header.jsp"%>
	<div class="w">
		<ul class="nav-subul">
			<li><a href="<%=basePath%>sp/spList">服务商管理</a></li>
			<li class="hover"><a href="<%=basePath%>spcontract/spcontractList">合同列表</a></li>
		</ul>
	</div>
	<!--content-->
	<div class="cont">
		<div class="w">
			<div class="cf">
			<a href="<%=basePath %>spcontract/spcontractadd" class="l add-export" onclick="add()"><i
					class="ui-icon"></i>添加合同</a>
				<ul class="r mode-filter">
					<li><form action="<%=basePath%>sp/search" method="post">
							<input type="text" name="name" class="text-input" value=""
								placeholder="服务商名称"><input type="text" name="id"
								class="text-input" value="" placeholder="服务商编号"> <select
								name="status" style="width: 150px;">
								<option value="" selected="true">服务商状态</option>
								<option value="1">未开通</option>
								<option value="2">正常</option>
								<option value="3">冻结</option>
							</select> <input type="submit" value="搜索" tabindex="12" class="export">
						</form></li>
				</ul>
			</div>
			<!--内容-->
			<div class="view-list">
				<table width="100%" class="ui-tab">
					<tbody>
						<tr>
							<th>合同编号</th>
							<th>合同名称</th>
							<th>服务商名称</th>
							<th>录入时间</th>
							<th>审批状态</th>
							<th>状态</th>
							<th>操作</th>
						</tr>
						<c:forEach items="${spContractList}" var="item">
							<tr>
								<td class="noline">${item.contractNum}</td>
								<td>${item.contractName}</td>
								<td>${item.spName}</td>
								<td>${fn:split(item.createTime, ' ')[0]}</td>
								<td>${item.check_status_label} </td>
								<c:choose>
									<c:when test="${item.status == 1}">
										<td class="succ">合作</td>
									</c:when>
									<c:otherwise>
										未合作
									</c:otherwise>
								</c:choose>
								<td><a href="<%=basePath %>spcontract/spcontractDetail?id=${item.id }">查看详情</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<!--内容 end-->
			<!--分页-->
			<div class="page">
				<span class="page_text"> ${page.totalCount} 条记录</span><a
					class="pageup pageup-dis" href="javascript:void(0)" title="上一页"><em></em>上一页</a>
				<a class="current" href="javascript:void(0)">${page.pageNo}</a><a href="/page2">2</a><a
					href="/page3">3</a><a href="/page4">4</a><a href="/page5">5</a> <span>...</span>
				<a href="<%=basePath %>sp/spList?pageNo=${page.pageNo+1}">${page.totalPages}</a> <a class="pagedown" href="/page2"
					title="下一页">下一页<em></em></a>
			</div>
			<!--分页 end-->
		</div>
	</div>
	<!--content end-->
	<!--footer-->
	<div class="foot">
		<div class="w">
			<p class="copyright">©&nbsp;&nbsp;2014&nbsp;&nbsp;北京拉手网络技术有限公司&nbsp;&nbsp;LaShou.com&nbsp;&nbsp;京ICP证100571号&nbsp;&nbsp;京ICP备11004895号&nbsp;&nbsp;京公网安备110105001181号</p>
		</div>
	</div>
	<!--footer end-->
</body>
</html>
