<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<!--[if lt IE 9]>
       <script type="text/javascript" src="js/html5.js"></script>
       <![endif]-->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title></title>
<script type="text/javascript" src="<%=basePath%>resources/js/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath%>resources/css/style_fw.css">
<script type="text/javascript" src="<%=basePath%>resources/js/main.js"></script>
<!--plugin-->
<link rel="stylesheet" type="text/css" href="<%=basePath%>resources/css/owl.carousel.min.css">
<script type="text/javascript" src="<%=basePath%>resources/js/owl.carousel.js"></script>

<script>
$(function () {
	$("#案例管理" ).addClass("on");
	$(".anlixiangx_img .anlixiangx_3").hover(function () {
        $(this).find(".anlixiangx_fix").stop().fadeToggle();
    })
})
</script>
</head>
<body>
	<!-------------------------------------- 头部开始 -------------------------------------->
	<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>
	<!-------------------------------------- 头部结束 -------------------------------------->
	<!-------------------------------------- 内容开始 -------------------------------------->
	
    <div class="mainer">
       <div class="shent_j">
            <div class="wrap">
                   <jsp:include page="/WEB-INF/view/common/siderbar.jsp"></jsp:include>
                    <div class="facilitator">
					<div class="fa_content">
						<p class="con_title">案例管理</p>
						<div class="lr_taggle">
                            <div class="togg_list">
                                <span class="on">案例列表</span>
                                <span>添加案例</span>
                            	<div class="clear"></div>
                            </div>
                            <div class="togg_cont">
                            	<div class="taggle">
                            		<div class="casus">
                            			<ul>
                            			<c:if test="${fn:length(goodsCaseVos) == 0 }"><h2 style="text-align: center;margin: 10%;">还没有任何案例，快去添加吧！</h2></c:if>
                            			<c:forEach items="${goodsCaseVos }" var="caseVo" varStatus="status">
                            				<c:choose>
                            					<c:when test="${status.count%3 == 2}"><li class="mid"></c:when>
                            					<c:otherwise><li></c:otherwise>
                            				</c:choose>
                            					<div class="top">
                            					<a href="<%=basePath%>case/casedetail?caseid=${caseVo.goodsCase.id}"><img src="${caseVo.firstPicture.imagePath }"></a>
                            					</div>
                            					<div class="bot">
                            						<h3>${caseVo.category }<label><fmt:formatDate pattern="yyyy-MM-dd" value="${caseVo.goodsCase.createTime }" /></label></h3>
                            						<p><span>${caseVo.goodsCase.customerName }</span>
                            						<span>定制周期${caseVo.goodsCase.customCycle }天</span>
                            						<span>${caseVo.goodsCase.customNum }件</span>
                            						<span><c:choose><c:when test="${caseVo.goodsCase.cost > 0}">
                            						<fmt:formatNumber value="${caseVo.goodsCase.cost/10000 }" type="currency" /></c:when>
                            						<c:otherwise>**</c:otherwise>
                            						</c:choose> 万</span></p>
                            					</div>
                            				</li>
					                    </c:forEach>
                            				<div class="clear"></div>
                            			</ul>
                            		</div>
                            	</div>
                            	<div class="taggle taggle_lt none">
                                    <form id="add_case" action="<%=basePath%>case/addcase" method="post">
                            		<p><span>案例名称： </span><input name="caseName" type="text" placeholder="请输入案例名称"/><label>（限20个汉字）</label></p>
									<p><span>定制方案： </span><input name="plan" type="text" placeholder="请输入定制款型、数量等信息"/><label>（限20个汉字）</label></p>
									<p><span>订制费用： </span><input name="cost" type="text" placeholder="请输入定制费用"/><label>（单位：元）</label></p>
									<p><span>客户名称： </span><input name="customerName" type="text" placeholder="请输入客户名称"/><label></label></p>
									<p><span>所属品类：</span><select name="categoryId">
									<c:forEach items="${categorys }" var="category">
										<option value="${category.id}">${category.name}</option>
									</c:forEach>
									</select><label></label></p>
									<p><span>定制数量：</span><input name="customNum" type="text" placeholder="请输入案例定制数量"/><label>（单位：件）</label></p>
									<p><span>定制周期：</span><input name="customCycle" type="text" placeholder="请输入案例定制周期"/><label>（个工作日）</label></p>
									<p><span>行业分类：</span><select name="industryId">
									<c:forEach items="${industrys }" var="industry">
										<option value="${industry.id}">${industry.name}</option>
									</c:forEach>
									</select></p>
									<div class="anlitp">
										<p><span>案例图片：</span></p>
									</div>
									<div class="anlixiangx">
										<p class="anlixiangx_1">图片上传</p>
										<p class="anlixiangx_2"><label onclick="$('#file').click()">选择图片</label><span id="info" style="width:75%;text-align: center;"></span></p>
										<div id="show">
										</div>
									</div>
									<div class="open_one">
										<p><span>案例描述：</span></p>
									</div>
									<div class="open_2">
										<p><textarea name="description"></textarea></p>
									</div>
									<div class="clear"></div>
									<p class="anlims_op"><span>客户评价：</span><textarea name="customerEvaluation"></textarea></p>
									<p class="but_anliu"><span> </span><a style="margin-left:20%;" href="#" onclick="$('#add_case').submit()">提交</a></p>
									</form>
									<div class="clear"></div>
                            	</div>
                            </div>
						</div>
				</div>
                
            </div>
            <form id="form" method="POST" enctype="multipart/form-data">
				<input id="file" type="file" name="file" hidden="true">
			</form>
            <div class="clear"></div>
        </div>

    </div></div>
    <!-------------------------------------- 内容结束 -------------------------------------->
	<!-------------------------------------- 尾部开始 -------------------------------------->
	<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
	<!-------------------------------------- 尾部结束 -------------------------------------->
<script>
function removeImg(current){
	current.parentNode.parentNode.parentNode.remove();
}
$("input[id='file']").change(function() {
	var file = document.getElementById("file").files[0];
	var info = document.getElementById("info");
	var basepath = "";
	if (file.size > 2 * 1024 * 1024) {
		info.innerHTML = "<img src='<%=basePath%>resources/img/fail.png'>&nbsp;&nbsp;&nbsp;文件大小不能超过2M";
	}else if(file.name.length > 50){
		info.innerHTML = "<img src='<%=basePath%>resources/img/fail.png'>&nbsp;&nbsp;&nbsp;文件名长度不能超过50个字符";
	} else {
		info.innerHTML = "<img src='<%=basePath%>resources/img/uploading.png'>";
		var formData = new FormData($("#form")[0]);
		var url = "http://api.efubao.com:9081/core-api/fileupload/singlepic";
		$
		.ajax({
			url : url,
			type : 'POST',
			data : formData,
			async : true,
			cache : false,
			contentType : false,
			processData : false,
			success : function(data) {
				if (data.code == 200) {
					info.innerHTML = "<img src='<%=basePath%>resources/img/success.png'>";
					str = "<div class='anlixiangx_img'><div class='anlixiangx_3'> \
					<img src='"+ basepath + data.data.filePath +"' class='img_j'/><div class='anlixiangx_fix'>\
					<a href='javascript:0' onclick='removeImg(this)'><img src='<%=basePath%>resources/img/iomcd_30.png'/></a></div>\
					<input name='imagePaths' value='"+ data.data.filePath +"' hidden='true'><input name='picNames' value='"+ file.name +"' hidden='true'></div></div>";
					$('#show').append(str);
				 	$(".anlixiangx_img .anlixiangx_3").hover(function () {
				        $(this).find(".anlixiangx_fix").stop().fadeToggle();
				    });
				} else {
					info.innerHTML = "<img src='<%=basePath%>resources/img/fail.png'>&nbsp;&nbsp;&nbsp;" + data.message.msg;
				}
			},
			error : function(data) {
				console.log(data)
				if (data.status != 200){
					info.innerHTML = "<img src='<%=basePath%>resources/img/fail.png'>&nbsp;&nbsp;&nbsp;" + data.status+" : " + data.statusText;
				}else{
					var data = eval('(' + data + ')');
					info.innerHTML.innerHTML = "<img src='<%=basePath%>resources/img/fail.png'>&nbsp;&nbsp;&nbsp;" + data.message.msg;
				}
				
			}
		});
	}
	document.getElementById("file").value = "";
});
	</script>
</body>
</html>