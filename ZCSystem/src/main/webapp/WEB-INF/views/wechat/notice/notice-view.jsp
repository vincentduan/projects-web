<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="">
<meta name="keywords" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png"
	href="${ctx}/statics/amazeui/i/favicon.png">
<link rel="stylesheet" href="${ctx}/statics/amazeui/css/amazeui.min.css">
<link rel="stylesheet" href="${ctx}/statics/amazeui/css/app.css">
<script src="${ctx}/statics/jquery/jquery-1.9.1.min.js" type="text/javascript"></script>
<title>公告消息列表</title>
<script type="text/javascript">
	var currentPage=Number('${page.currentPage}');
	var maxNum=Number('${page.maxNum}');
	var totalPage = Number('${page.totalPage}');

	function getMore(){
		currentPage = currentPage+1;
		if(currentPage>totalPage){
			alert('没有更多数据了....');
			return ;
		}
		var url = "${ctx}/wechat/notice/toList.do?currentPage="+currentPage+"&maxNum="+maxNum+"&receiverusername=${receiverusername}"
		$.ajax({
			url : url,
			type : 'GET',
			dataType : 'html',
			success:function(result){
				 $('#contentList').append(result);
			},
			error : function(xhr, textStatus) {
				alert('系统发生异常,请联系管理员!');
			}
		});
	}
</script>
</head>
<body>
	<div data-am-widget="list_news"
		class="am-list-news am-list-news-default">
		<!--列表标题-->
		<div data-am-widget="titlebar" class="am-titlebar am-titlebar-default" >
    		<h2 class="am-titlebar-title ">
     			公告消息
    		</h2>

		    <nav class="am-titlebar-nav">
		        <a href="javascript:void(0);" onclick="getMore();return false;" class="">查看更多 &raquo;</a>
		    </nav>
		</div>

		<div class="am-list-news-bd">
			<ul class="am-list" id="contentList">
				<c:if test="${not empty page.data }">
					<c:forEach var="item" items="${page.data }">
						<!--缩略图在标题左边-->
						<li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left">
							<div class="am-u-sm-4 am-list-thumb">
								<a href="${item.url }" class=""> <img
									src="${item.picUrl }"
									alt="${item.title }" />
								</a>
							</div>
		
							<div class=" am-u-sm-8 am-list-main">
								<h3 class="am-list-item-hd">
									<a href="${item.url }" class="">${item.title }</a>
								</h3>
								<div class="am-list-item-text">${item.content }</div>
							</div>
						</li>
					</c:forEach>
				</c:if>
			</ul>
		</div>
	</div>
</body>
</html>