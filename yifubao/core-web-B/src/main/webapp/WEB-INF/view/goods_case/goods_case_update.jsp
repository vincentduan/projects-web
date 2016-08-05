<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="com.efubao.core.sp.utils.*"%>
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
<link rel="stylesheet" type="text/css" href="<%=basePath%>resources/css/style.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>resources/css/style_fw.css">
<script type="text/javascript" src="<%=basePath%>resources/js/main.js"></script>
<!--plugin-->
<link rel="stylesheet" type="text/css" href="<%=basePath%>resources/css/owl.carousel.min.css">
<script type="text/javascript" src="<%=basePath%>resources/js/owl.carousel.js"></script>
<script>
$(function () {
    $("#量体师管理" ).addClass("on");
    $(".anlixiangx_img .anlixiangx_3").hover(function () {
        $(this).find(".anlixiangx_fix").stop().fadeToggle();
    });
})
</script>
</head>
<body>
	<!-------------------------------------- 头部开始 -------------------------------------->
	<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>
	<!-------------------------------------- 头部结束 -------------------------------------->
	<!-------------------------------------- 内容开始 -------------------------------------->
	<div class="mainer ">
    	<div class="shent_j">
        <div class="wrap">
        	 <jsp:include page="/WEB-INF/view/common/siderbar.jsp"></jsp:include>
				<div class="facilitator">
					<div class="fa_content">
						<p class="con_title">更新案例信息</p>
						<div class="lr_taggle">
							<div class="togg_cont">
       							<div class="taggle taggle_lt">
			                        <form:form id="update_case" modelAttribute="goodsCase" action="updatecase" method="post">
			                        	<form:hidden path="id"/>
		                        		<p><span>案例名称： </span><form:input path="caseName" type="text"/><label>（限20个汉字）</label></p>
										<p><span>定制方案： </span><form:input path="plan" type="text"/><label>（限20个汉字）</label></p>
										<p><span>订制费用： </span><form:input path="cost" type="text"/><label>（单位：元）</label></p>
										<p><span>客户名称： </span><form:input path="customerName" type="text"/><label></label></p>
										<p><span>所属品类：</span><form:select path="categoryId">
										<c:forEach items="${categorys }" var="category">
											<form:option value="${category.id}">${category.name}</form:option>
										</c:forEach>
										</form:select><label></label></p>
										<p><span>定制数量：</span><form:input path="customNum" type="text"/><label>（单位：件）</label></p>
										<p><span>定制周期：</span><form:input path="customCycle" type="text"/><label>（个工作日）</label></p>
										<p><span>行业分类：</span><form:select path="industryId">
										<c:forEach items="${industrys }" var="industry">
											<form:option value="${industry.id}">${industry.name}</form:option>
										</c:forEach>
										</form:select></p>
										<div class="anlitp">
											<p><span>案例图片：</span></p>
										</div>
										<div class="anlixiangx">
											<p class="anlixiangx_1">图片上传</p>
											<p class="anlixiangx_2"><label onclick="$('#file').click()">选择图片</label><span id="info" style="width:75%;text-align: center;"></span></p>
											<div id="show">
											<c:forEach items="${casePictures }" var="picture">
												<div class="anlixiangx_img">
													<div class="anlixiangx_3">
														<img src="${basepath}${picture.imagePath }" class="img_j"/>
														<div class="anlixiangx_fix">
															<a href="javascript:0" onclick="removeImg(this)"><img src="<%=basePath%>resources/img/iomcd_30.png"/></a>
														</div>
														<input id="picid_${picture.id }" name="picIds" value="${picture.id }" hidden='true'>
													</div>  
												</div>
											</c:forEach>
											</div>
										</div>
										<div class="open_one">
											<p><span>案例描述：</span></p>
										</div>
										<div class="open_2">
											<p><form:textarea path="description"></form:textarea></p>
										</div>
										<div class="clear"></div>
										<p class="anlims_op"><span>客户评价：</span><form:textarea path="customerEvaluation"></form:textarea></p>
										<p class="but_anliu">
											<span> </span><a style="margin-left:12%;" href="#" onclick="$('#update_case').submit()">提交</a><a href="<%=basePath%>case/casedetail?caseid=${goodsCase.id}" class="on">返回案例详情</a>
										</p>
			                        </form:form>
			                    </div>
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
    </div>
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
					<a href='javascript:0' onclick='remove(this)'><img src='<%=basePath%>resources/img/iomcd_30.png'/></a></div>\
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