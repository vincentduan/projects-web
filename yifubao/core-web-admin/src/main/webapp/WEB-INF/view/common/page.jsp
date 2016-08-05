<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="page">
	<span class="page_text"> ${page.totalCount} 条记录</span>
	<c:choose>
		<c:when test="${page.pageNo == 1}">
			<a class="pageup pageup-dis" href="javascript:void(0)" title="上一页"><em></em>上一页</a>
		</c:when>
		<c:otherwise>
			<a class="pageup" href="<%=basePath %>${url}pageNo=${page.pageNo-1}" title="上一页"><em></em>上一页</a>
		</c:otherwise>
	</c:choose>
	<c:if test="${page.pageNo>4}">
		<a href="<%=basePath %>${url}pageNo=1">1</a>
	</c:if>
	<c:if test="${page.pageNo==6}">
		<a href="<%=basePath %>${url}pageNo=2">2</a>
	</c:if>
	<c:if test="${page.pageNo>6}">
		<a>...</a>
	</c:if>
		
		<c:forEach var="s"
			begin="${(page.pageNo-3)>1?(page.pageNo-3):1}"
			end="${(page.pageNo+3) > page.totalPages ? page.totalPages:(page.pageNo+3)}">
			<c:choose>
				<c:when test="${s==page.pageNo}">
					<span class="current"> ${page.pageNo} </span>
				</c:when>
				<c:otherwise>
					<a href="<%=basePath %>${url}pageNo=${s}"
						style="cursor: pointer;"> ${s} </a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	<c:if test="${page.pageNo<(page.totalPages-5)}">
		<a>...</a>
	</c:if>
	<c:if test="${page.pageNo==(page.totalPages-5)}">
		<a href="<%=basePath %>${url}pageNo=${page.totalPages-1 }">${page.totalPages-1 }</a>
	</c:if>
	<c:if test="${page.pageNo<(page.totalPages-3)}">
		<a href="<%=basePath %>${url}pageNo=${page.totalPages}">${page.totalPages}</a>
	</c:if>
	<c:choose>
		<c:when test="${page.pageNo == page.totalPages}">
			<a class="pagedown pagedown-dis" href="javascript:void(0)"
		title="下一页">下一页<em></em></a>
		</c:when>
		<c:otherwise>
			<a class="pagedown" href="<%=basePath %>${url}pageNo=${page.pageNo+1}"
		title="下一页">下一页<em></em></a>
		</c:otherwise>
	</c:choose>
</div>