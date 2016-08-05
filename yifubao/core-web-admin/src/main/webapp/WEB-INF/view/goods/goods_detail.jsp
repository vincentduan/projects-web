<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page import="com.efubao.core.admin.utils.StatusEnum"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商品管理>>商品详情</title>
<script type="text/javascript">
	window.onload = function() {
		document.getElementById('商品管理').className = "hover";
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
	<!--header-->
	<%@ include file="/WEB-INF/view/common/header.jsp"%>
	<div class="w">
		<ul class="nav-subul">
			<li><a href="<%=basePath%>goods/goodsList">商品列表</a></li>
			<li class="hover"><a href="#">商品详情</a></li>
		</ul>
	</div>
	</div>
	<!--content-->
	<div class="cont">
		<div class="w">
			<div class="view-list">
				<div class="line-tab">
					<h3>基本资料</h3>
					<table style="width: 100%; margin-left: 3%" class="goods-tab">
						<tbody>
							<tr>
								<th>商品名称：</th>
								<td>${goods.name }</td>
							</tr>
							<tr>
								<th>分类：</th>
								<td><c:forEach items="${parentCategorys}" var="item"
										varStatus="st">
										<c:choose>
											<c:when test="${st.last }">
								${item.name}
							</c:when>
											<c:otherwise>
								${item.name}<label> >></label>
											</c:otherwise>
										</c:choose>
									</c:forEach></td>
							</tr>
							<tr>
								<th>商品介绍：</th>
								<td style="margin-right: 10%"><c:choose>
										<c:when test="${not empty goods.summary }">
								${goods.summary }
							</c:when>
										<c:otherwise>暂无</c:otherwise>
									</c:choose></td>
							</tr>
						</tbody>
					</table>
					<h3>商品属性</h3>
					<table class="attr-tab">
						<tbody>
							<tr>
								<c:forEach items="${attrs}" var="attr" varStatus="st">
									<th>${attr.name }</th>
								</c:forEach>
								<th>价格</th>
								<th>图片</th>
							<tr>
								<c:forEach items="${SKUS}" var="SKU">
									<tr>
										<c:forEach items="${fn:split(SKU.attributeValueNames, ',') }"
											var="value">
											<td>${value }</td>
										</c:forEach>
										<td>${SKU.price }</td>
										<td class="img"><c:forEach
												items="${fn:split(SKU.imagePath, ',')}" var="img">
												<c:if test="${img != ' ' }">
													<a href="${img}"> <img src="${img}" width="90"
														height="60">
													</a>
												</c:if>
											</c:forEach></td>
									</tr>
								</c:forEach>
						</tbody>
					</table>
					<h3>商品图片</h3>
					<table class="attr-table">
						<tbody>
							<tr>
								<td>
									<ul class="cf stills">
										<c:forEach items="${goodsPics}" var="item">
											<li><a href="${item.imagePath }"> <img
													src="${item.imagePath }" width="90" height="60">
											</a></li>
										</c:forEach>
									</ul>
								</td>
							</tr>
						</tbody>
					</table>
					<h3>详情描述</h3>
					<table class="attr-table">
						<tbody>
							<c:forEach items="${goodsDescs}" var="desc">
								<tr>
									<td>${desc.description}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

				</div>
			</div>
		</div>
	</div>
	<%-- <form action="<%=basePath %>/goods/goodsUpd" method="post">
						<input type="hidden" name="id" value="${goodsDetail.id}" />
						<div class="row detail-item">
							<div class="col-xs-2" style="width: 100px">描述详情：</div>
							<div class="col-xs-9">
								<textarea id="editor_id" name="content"
									style="width: 300px; height: 200px; display: block;">${goodsDetail.summary }</textarea>
							</div>
						</div>
						<div class="row detail-item">
							<div style="margin-top: 20px; padding-left: 40%;">
								<input type="submit" value="提交" />
							</div>
						</div>
					</form> --%>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/kindeditor-min.js"></script>
	<script>
		KindEditor.ready(function(K) {
			var editor = K.editor({
				allowFileManager : true
			});
			K('#image3').click(
					function() {
						editor.loadPlugin('image', function() {
							editor.plugin.imageDialog({
								showRemote : false,
								imageUrl : K('#url3').val(),
								clickFn : function(url, title, width, height,
										border, align) {
									K('#url3').val(url);
									editor.hideDialog();
								}
							});
						});
					});
		});
	</script>
	<script>
		var editor;
		KindEditor.ready(function(K) {
			editor = K.create('textarea[name="content"]', {
				resizeType : 1,
				allowPreviewEmoticons : false,
				allowImageUpload : false,
				items : [ 'fontname', 'fontsize', '|', 'forecolor',
						'hilitecolor', 'bold', 'italic', 'underline',
						'removeformat', '|', 'justifyleft', 'justifycenter',
						'justifyright', 'insertorderedlist',
						'insertunorderedlist', '|', 'emoticons', 'image',
						'link' ]
			});
		});
	</script>
</body>
</html>
