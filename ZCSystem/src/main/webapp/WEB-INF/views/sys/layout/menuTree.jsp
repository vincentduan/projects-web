<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/views/sys/includes/taglib.jsp"%>
<html>
<head>
	<title>菜单导航</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript"> 
		$(document).ready(function() {
			/* $(".accordion-heading a").click(function(){
				$('.accordion-toggle i').removeClass('icon-chevron-down');
				$('.accordion-toggle i').addClass('icon-chevron-right');
				if(!$($(this).attr('href')).hasClass('in')){
					$(this).children('i').removeClass('icon-chevron-right');
					$(this).children('i').addClass('icon-chevron-down');
				}
			});
			$(".accordion-body a").click(function(){
				$("#menu li").removeClass("active");
				$("#menu li i").removeClass("icon-white");
				$(this).parent().addClass("active");
				$(this).children("i").addClass("icon-white");
			}); */
			//$(".accordion-body a:first i").click();
			$('#menu li:gt(1)').click(function(){
				if( 'leaf' == $(this).attr('data-flag') && $(this).hasClass('active') ) {
					$(this).siblings('li').removeClass('active');
				}
				else if( 'root' == $(this).attr('data-flag') ) {
					//$(this).siblings('li').removeClass('active');
				}
				else{
					$(this).addClass('active').siblings('li').removeClass('active');
				}
			});
		});
	</script>
</head>
<body>
	<div class="well sidebar-nav" id="menu">
	<ul class="nav nav-list">
	  <li class="nav-header">信息安全综合管理平台</li>
	  <li class="divider"></li>
	<c:set var="menuList" value="${fns:getMenuList()}"/>
	<c:set var="firstMenu" value="true"/>
	<c:forEach items="${menuList}" var="menu" varStatus="idxStatus">
	<c:if test="${not empty menu.menuhref && menu.parentid eq '1' && menu.isshow eq '1'}">
		<li data-flag="leaf" class="${firstMenu?'active':''}"><a href="${not empty menu.menuhref?menu.menuhref:'/404'}" target="${not empty menu.target?menu.target:'mainFrame'}" >${menu.menuname}</a></li>
		<c:set var="firstMenu" value="false"/>
	</c:if>
	<c:if test="${empty menu.menuhref && menu.parentid eq '1' && menu.isshow eq '1'}">
		<li data-flag="root" class="${firstMenu?'active':''}"><a href="#" >${menu.menuname}</a></li>
		<c:forEach items="${menuList}" var="menuChild">
			<c:if test="${menuChild.parentid eq menu.id && menuChild.isshow eq '1'}">
			<li class="nav-list" data-flag="leaf"><a  href="${not empty menuChild.menuhref?menuChild.menuhref:'/404'}" target="${not empty menuChild.target?menuChild.target:'mainFrame'}" ><i></i>&nbsp;${menuChild.menuname}</a></li>
			</c:if>
		</c:forEach>
		<c:set var="firstMenu" value="false"/>
	</c:if>
	</c:forEach>
	</ul>
	<%-- 
	<c:set var="menuList" value="${fns:getMenuList()}"/>
	<c:set var="firstMenu" value="true"/>
	<c:forEach items="${menuList}" var="menu" varStatus="idxStatus">
	<c:if test="${menu.parentid eq (not empty param.parentId?param.parentId:'1')&&menu.isshow eq '1'}">
		<div class="accordion-group">
		    <div class="accordion-heading">
		    	<a id="ahref${menu.id}" class="accordion-toggle" data-toggle="collapse" data-parent="#menu" href="#collapse${menu.id}" title="${menu.remarks}"><i class="icon-chevron-${firstMenu?'down':'right'}"></i>&nbsp;${menu.menuname}</a>
		    </div>
		    <div id="collapse${menu.id}" class="accordion-body collapse ${firstMenu?'in':''}">
				<div class="accordion-inner">
					<ul class="nav nav-list">
					<c:forEach items="${menuList}" var="menuChild">
					<c:if test="${menuChild.parentid eq menu.id && menuChild.isshow eq '1'}">
						<li><a  id="coli${menuChild.id}" href="${not empty menuChild.menuhref?menuChild.menuhref:'/404'}" target="${not empty menuChild.target?menuChild.target:'mainFrame'}" ><i class="icon-${not empty menuChild.menuicon?menuChild.menuicon:'circle-arrow-right'}"></i>&nbsp;${menuChild.menuname}</a></li>
					<c:set var="firstMenu" value="false"/>
					</c:if>
					</c:forEach>
					</ul>
				</div>
		    </div>
		</div>
	</c:if>
	</c:forEach> --%>
	</div>
</body>
</html>
