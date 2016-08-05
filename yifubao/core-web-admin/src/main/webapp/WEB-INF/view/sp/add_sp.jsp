<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
  
<title>商户管理>>添加服务商</title>
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
			<li class="hover"><a href="#">添加服务商</a></li>
		</ul>
	</div>
	</div>
	<!--content-->
	<div class="cont">
		<div class="w">
			<!--内容-->
			<div class="view-list">
				<form id="uploadform" action="upload" method="POST"
					enctype="multipart/form-data">
					<div class="line-tab">
						<h3>基本资料</h3>
						<table style="width: 100%; margin-left: 8%" class="ui-edit-tab">
							<tbody>
								<tr>
									<th><span class="ui-error">*</span>&nbsp;服务商名称：</th>
									<td><input name="name" class="large-text-input"
										placeholder="请输入服务商名称"></td>
								</tr>
								<tr>
									<th><span class="ui-error">*</span>&nbsp;服务商等级：</th>
									<td><select name="grade" style="width: 250px;">
											<option selected="selected">请选择</option>
											<option value="A">A</option>
											<option value="B">B</option>
											<option value="C">C</option>
											<option value="D">D</option>
									</select></td>
								</tr>
								<tr>
									<th><span class="ui-none">*</span>&nbsp;服务商简称：</th>
									<td><input name="shortname" class="large-text-input"
										placeholder="请输入服务商简称"></td>
								</tr>
								<tr>
									<th><span class="ui-error">*</span>&nbsp;公司名称：</th>
									<td><input name="companyName" class="large-text-input"
										placeholder="请输入公司名称"></td>
								</tr>
								<tr>
									<th><span class="ui-error">*</span>&nbsp;法人姓名：</th>
									<td><input name="legalPerson" class="large-text-input"
										placeholder="请输入法人姓名"></td>
								</tr>
								<tr>
									<th><span class="ui-error">*</span>&nbsp;注册地址：</th>
									<td><select name="grade" style="width: 250px;">
											<option selected="selected">请选择</option>
											<option value="A">A</option>
											<option value="B">B</option>
											<option value="C">C</option>
											<option value="D">D</option>
									</select></td>
								</tr>
								<tr>
									<td></td>
									<td><input name="registeredAddr" class="large-text-input"
										style="width: 400px" placeholder="请输入详细地址信息"></td>
								</tr>
								<tr>
									<th><span class="ui-error">*</span>&nbsp;注册资金：</th>
									<td><input name="registeredCapital"
										class="large-text-input" placeholder="请输入注册资金"></td>
								</tr>
								<tr>
									<th><span class="ui-error">*</span>&nbsp;营业执照注册号：</th>
									<td><input name="businessLicenceNo"
										class="large-text-input" placeholder="请输入营业执照注册号"></td>
								</tr>
								<tr>
									<th><span class="ui-none">*</span>&nbsp;税务登记证号：</th>
									<td><input name="taxRegistrationNo"
										class="large-text-input" placeholder="请输入税务登记证号"></td>
								</tr>
								<tr>
									<th><span class="ui-none">*</span>&nbsp;组织机构代码：</th>
									<td><input name="orgCode" class="large-text-input"
										placeholder="请输入组织机构代码"></td>
								</tr>
								<tr>
									<th><span class="ui-error">*</span>&nbsp;经营期限：</th>
									<td><input id="datepicker-example1-1"
										name="businessStartDate">&nbsp;至&nbsp; <input
										id="datepicker-example1-2" name="businessEndDate"></td>
								</tr>
								<tr>
									<th><span class="ui-error">*</span>&nbsp;经营范围：</th>
									<td><input name="businessRange" class="large-text-input"
										placeholder="请输入经营范围"></td>
								</tr>
								<tr>
									<td></td>
									<td colspan="5"><span class="ui-error">注：需要上传营业执照、税务登记证附件、银行开户许可证、附件最大为2MB；
											<br /> 如企业已办理三证合一，仅填写营业执照注册号及上传三证合一扫描件或照片
									</span>
									<td>
								</tr>
								<tr>
									<th><span class="ui-error">*</span>&nbsp;营业执照：</th>
									<td><input id="show1" class="large-text-input"
										onclick="selectFile(1)" placeholder="选择文件"> <input
										id="path1" name="path1" hidden="true"><span id="info1"></span></td>
								</tr>
								<tr>
									<th><span class="ui-none">*</span>&nbsp;税务登记证：</th>
									<td><input id="show2" class="large-text-input"
										onclick="selectFile(2)" placeholder="选择文件"> <input
										id="path2" name="path2" hidden="true"><span id="info2"></span></td>
								</tr>
								<tr>
									<th><span class="ui-none">*</span>&nbsp;组织机构代码证：</th>
									<td><input id="show3" class="large-text-input"
										onclick="selectFile(3)" placeholder="选择文件"> <input
										id="path3" name="path3" hidden="true"><span id="info3"></span></td>
								</tr>
								<tr>
									<th><span class="ui-none">*</span>&nbsp;银行开户许可证：</th>
									<td><input id="show4" class="large-text-input"
										onclick="selectFile(4)" placeholder="选择文件"> <input
										id="path4" name="path4" hidden="true"><span id="info4"></span></td>
								</tr>
								<tr>
									<th><span class="ui-none">*</span>&nbsp;备注：</th>
									<td><input name="remarks" class="large-text-input"
										style="width: 400px" placeholder="备注信息"></td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="line-tab">
						<h3>服务商档案</h3>
						<table style="width: 100%; margin-left: 8%" class="ui-edit-tab">
							<tbody>
								<tr>
									<th><span class="ui-error">*</span>&nbsp;服务商LOGO：</th>
									<td><input id="show5" class="large-text-input"
										onclick="selectFile(5)" placeholder="选择文件"> <input
										id="path5" name="logoImagePath" hidden="true"><span
										id="info5"></span></td>
								</tr>
								<tr>
									<th><span class="ui-error">*</span>&nbsp;服务区域：</th>
									<td><select name="grade" style="width: 130px;">
											<option selected="selected">请选择</option>
											<option value="A">浙江省</option>
											<option value="B">B</option>
											<option value="C">C</option>
											<option value="D">D</option>
									</select>&nbsp;&nbsp;<select name="grade" style="width: 130px;">
											<option selected="selected">请选择</option>
											<option value="A">A</option>
											<option value="B">B</option>
											<option value="C">C</option>
											<option value="D">D</option>
									</select></td>
								</tr>
								<tr>
									<th><span class="ui-error">*</span>&nbsp;服务类别：</th>
									<td><label><input name="serviceCategory"
											type="checkbox" value="1" />&nbsp;高端定制&nbsp;&nbsp;&nbsp;</label> <label><input
											name="serviceCategory" type="checkbox" value="2" />&nbsp;量体定制&nbsp;&nbsp;&nbsp;</label>
										<label><input name="serviceCategory" type="checkbox"
											value="3" />&nbsp;标准定制&nbsp;&nbsp;&nbsp;</label></td>
								</tr>
								<tr>
									<th><span class="ui-error">*</span>&nbsp;是否支持量体：</th>
									<td><label><input name="serviceCategory"
											type="radio" value="1" />&nbsp;支持量体&nbsp;&nbsp;&nbsp;</label> <label><input
											name="serviceCategory" type="radio" value="0" />&nbsp;不支持量体&nbsp;&nbsp;&nbsp;</label>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</form>
				<div class="btn-box-center">
					<input type="submit" class="btns btn-submit" value="提 交"> <input
						type="submit" class="btns btn-cancel" value="返 回">
				</div>
			</div>
			<form id="form" method="POST" enctype="multipart/form-data">
				<input id="file" type="file" name="mfs" hidden="true">
			</form>
			<!--内容 end-->
		</div>
	</div>
	<!--content end-->
	<!--footer-->
	<%@ include file="/WEB-INF/view/common/footer.jsp"%>
	<!--footer end-->
	<script>
	var index = 1;
	function selectFile(id){ 
		index = id;
		document.getElementById('file').click();
	}
		$("input[id='file']").change(function() {
			var file = document.getElementById("file").files[0];
			if (file.size > 2 * 1024 * 1024) {
				alert("附件最大为2MB");
			} else {
				show = '#show' + index;
				$(show).val(file.name);
				info = 'info' + index;
				document.getElementById(info).innerHTML = "<img src='<%=basePath%>resources/images/uploading.png'>";
				var formData = new FormData($("#form")[0]);
				var url = "<%=basePath%>fileUpload/singlePic";
				$
				.ajax({
					url : url,
					type : 'POST',
					data : formData,
					async : false,
					cache : false,
					contentType : false,
					processData : false,
					success : function(data) {
						var ret = eval('(' + data + ')');
						if (ret.success == true) {
							path = '#path' + index;
							info = 'info' + index;
							document.getElementById(info).innerHTML = "<img src='<%=basePath%>resources/images/success.png'>";
							$(path).val(ret.filePath);
						} else {
							info = 'info' + index;
							document.getElementById(info).className = "error";
							document.getElementById(info).innerHTML = "<img src='<%=basePath%>resources/images/fail.png'>&nbsp;&nbsp;&nbsp;" + ret.message;
						}
					},
					error : function(data) {
						console.log(data)
						if (data.status != 200){
							info = 'info' + index;
							document.getElementById(info).className = "error";
							document.getElementById(info).innerHTML = "<img src='<%=basePath%>resources/images/fail.png'>&nbsp;&nbsp;&nbsp;" + data.status+" : " + data.statusText;
						}else{
							var ret = eval('(' + data + ')');
							info = 'info' + index;
							document.getElementById(info).className = "error";
							document.getElementById(info).innerHTML = "<img src='<%=basePath%>resources/images/fail.png'>&nbsp;&nbsp;&nbsp;" + ret.message;
						}
						
					}
				});
			}
			document.getElementById("file").value = "";
		});
	</script>
</body>
</html>
