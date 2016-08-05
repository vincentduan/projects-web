<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/views/sys/includes/taglib.jsp"%>
<html>
<head>
<title>项目管理</title>
<meta name="decorator" content="default" />
<%@include file="/WEB-INF/views/sys/includes/dialog.jsp"%>
<script src="${ctxStatic}/modules/fileinput/js/fileinput.js" type="text/javascript"></script>
<script src="${ctxStatic}/modules/fileinput/js/fileinput_locale_zh.js" type="text/javascript"></script>
<link href="${ctxStatic}/modules/fileinput/css/fileinput.css" type="text/css" rel="stylesheet" />
<script type="text/javascript">
	function checkFlag(){
		var radios = document.getElementsByName("flag");
		var tag = false;
		var val;
		for(radio in radios) {
		   if(radios[radio].checked) {
		      tag = true;
		      val = radios[radio].value;
		      break;
		   }
		}
		if(tag) {
			$("#upload_parentid").val(val);
			$('#upload').modal();
		} 
		else {
		  alert("请选择一个项目");
		}
	} 
	function deletepro (id){
		sendRequestPost('${ctx}/projects/project/delete.do',{id:id},function(data){
			window.location.reload();
		})
	}
</script>
</head>
<body>
	<div id="upload" class="modal hide fade in" style="display: none; ">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">×</a>
			<h3>上传子项目</h3>
		</div>
		<div class="modal-body">
			<h4>选择项目文件：</h4>
			<p>请选择.xlsx文件</p>		  
      		<form enctype="multipart/form-data" action="${ctx}/projects/project/uploadSubfile.do" method="post" >
                 <div class="form-group">
                    <input class="file" type="file" name="file" data-min-file-count="1">
                    <input type="hidden" id="upload_parentid" name="upload_parentid" >
                </div>
            </form>   
		</div>
	</div>
	<ul class="nav nav-tabs">
		<li class="active"><a href="/projects/project/listView.do">项目列表</a></li>
		<li><a href="${ctx}/projects/project/formView.do" >添加项目</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="projects" action="${ctx}/projects/project/view.do" method="post" class="breadcrumb form-search">
		<div style="margin-top: 8px;">
			<label>项目名称：</label>
			<form:input path="projectname" htmlEscape="false" maxlength="50" class="input-small" />
			<input id="btnSubmit" class="btn btn-primary btn-query" type="submit" value="查询" />
			<a href="javascript:void(0);" data-toggle="modal" onclick="checkFlag();return false" class="btn btn-primary" style="float:right;margin-right:10px;">上传项目</a>
			<a href="${ctx}/projects/project/downloadfile.do" target="_blank" class="btn btn-link" style="float:right;margin-right:10px;">下载模板</a>
		</div>
	</form:form>
	<table id="contentTable"
		class="table table-striped table-bordered">
		<thead>
			<tr>
				<th>惰行区间</th>
				<th>项目名称</th>
				<th>项目状态</th>
				<th>项目发布时间</th>
				<th>项目众筹时间</th>
				<th>项目验收时间</th>
				<th>项目结束时间</th>
				<th>集赞票数</th>
				<th>集反对票数</th>
				<th>是否允许点赞</th>
				<th>最大可点赞的子项目数</th>
				<th>&nbsp;&nbsp;&nbsp;&nbsp;操&nbsp;&nbsp;作&nbsp;&nbsp;&nbsp;&nbsp;</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.data}" var="pro" varStatus="status">
				<tr>
					<td><input type="radio" name="flag" id="flag" value="${pro.id }"/></td>
					<td>${pro.projectname }</td>
					<td>
						<c:choose>
    						<c:when test="${pro.projectstatus == 0 }">
    							发布
    						</c:when>
    						<c:when test="${pro.projectstatus == 1 }">
    							众筹
    						</c:when>
    						<c:when test="${pro.projectstatus == 2 }">
    							验收
    						</c:when>
    						<c:when test="${pro.projectstatus == 3 }">
    							完成
    						</c:when>
    					</c:choose>
					</td>
					<td><fmt:formatDate value="${pro.starttime }" pattern="yyyy-MM-dd"/></td>
					<td><fmt:formatDate value="${pro.crowdtime }" pattern="yyyy-MM-dd"/></td>
					<td><fmt:formatDate value="${pro.examinetime }" pattern="yyyy-MM-dd"/></td>
					<td><fmt:formatDate value="${pro.endtime }" pattern="yyyy-MM-dd"/></td>
					<td>${pro.agreecount }</td>
					<td>${pro.againstcount }</td>
					<td>
						<c:choose>
    						<c:when test="${pro.isallowedagree == 0 }">
    							不允许对本项目点赞
    						</c:when>
    						<c:when test="${pro.isallowedagree == 1 }">
    							允许对本项目点赞
    						</c:when>
    						<c:when test="${pro.isallowedagree == 2 }">
    							允许对子项目点赞
    						</c:when>
    						<c:when test="${pro.isallowedagree == 3 }">
    							同时允许
    						</c:when>
    					</c:choose>
					</td>
					<td>${pro.maxagreelimit }</td>
					<td>
						<a href="${ctx}/projects/project/formView.do?id=${pro.id }">修改</a><br>
						<a href="#" onclick="deletepro(${pro.id });return false">删除</a><br>
						<c:if test="${pro.parentid == null}">
							<a href="${ctx}/projects/project/subProlistView.do?parentid=${pro.id }">查看子项目</a><br>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page.getPageHtml()}</div>
</body>
</html>