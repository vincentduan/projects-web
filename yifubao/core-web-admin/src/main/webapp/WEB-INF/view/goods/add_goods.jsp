<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商品管理>>添加商品</title>
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
	<%@ include file="/WEB-INF/view/common/header.jsp"%>
	<div class="w">
		<ul class="nav-subul">
			<li><a href="<%=basePath%>goods/goodsList">商品管理</a></li>
			<li class="hover"><a href="#">添加商品</a></li>
		</ul>
	</div>
	</div>
	<input id="categoryId" value="">
	<div>
		<select onchange="change(this)">
			<option value="0">请选择</option>
			<c:forEach items="${categorys }" var="category">
				<option value="${category.id }">${category.name }</option>
			</c:forEach>
		</select>
	</div>
	<div>
		<div>
		颜色：
		<input id="1" name="颜色" type="checkbox" value="红色">红色
		<input id="2" name="颜色" type="checkbox" value="绿色">绿色
		<input id="3" name="颜色" type="checkbox" value="黄色">黄色
		<input id="4" name="颜色" type="checkbox" value="蓝色">蓝色
		<input id="0" onclick="changeClick(this.checked, '颜色')" type="checkbox">全选
		</div>
		<div>
		尺寸：
		<input id="5" name="尺寸" type="checkbox" value="XL">XL
		<input id="6" name="尺寸" type="checkbox" value="XXL">XXL
		<input id="7" name="尺寸" type="checkbox" value="M">M
		<input id="0" onclick="changeClick(this.checked, '尺寸')" type="checkbox">全选
		</div>
		<div>
		面料：
		<input id="8" name="面料" type="checkbox" value="亚麻">亚麻
		<input id="9" name="面料" type="checkbox" value="丝绸">丝绸
		<input id="10" name="面料" type="checkbox" value="棉">棉
		<input id="0" onclick="changeClick(this.checked, '面料')" type="checkbox">全选
		</div>
		<div>
			<input type="button" onclick="createTable(this, 'attr_table')" value="添加明细">
		</div>
	</div>
	<div>
	<form action="<%=basePath%>goods/addGoods" method="post">
		<table id="attr_table" class="attr-edit-tab">
			<tbody>
			</tbody>
		</table>
		<input type="submit" value="提交">
	</form>
	</div>
	
<script type="text/javascript">
var attrs = [
	{
		"attrId":"1",
		"attrName":"颜色",
		"valueIds":[],
		"valueNames":[],
		"counts":0,
		"multiple":0
	},
	{
		"attrId":"2",
		"attrName":"尺寸",
		"valueIds":[],
		"valueNames":[],
		"counts":0,
		"multiple":0
	},
	{
		"attrId":"3",
		"attrName":"面料",
		"valueIds":[],
		"valueNames":[],
		"counts":0,
		"multiple":0
	}
 ]
var goodsId = 1
var isable = true
$("input:checkbox").change(function() {
	if (this.id != 0) {
		isable = true
		objs = document.getElementsByName(this.name);
		for (var i = 0; i < attrs.length; i++) {
			if(attrs[i]["attrName"] == this.name){
				attrs[i]["valueIds"] = [];
				attrs[i]["valueNames"] = [];
				attrs[i]["counts"] = 0;
				for(var j = 0; j < objs.length; j++){
					if(objs[j].checked){
						attrs[i]["valueIds"].push(objs[j].id);
						attrs[i]["valueNames"].push(objs[j].value);
						attrs[i]["counts"] += 1;
					}
				}
				break;
			}
		}
		console.log(attrs)
	}
});

function createTable(button, tableId){
	var table = document.getElementById(tableId);
	var allCounts = 1;
	var isEmpty = true
	var attributeIds = []
	var attributeNames = []
	var tmpAttrs = []
	for (var i = 0; i < attrs.length; i++) {
		if(attrs[i]["counts"] != 0){
			allCounts *= attrs[i]["counts"]
			attrs[i]["multiple"] = allCounts
			isEmpty = false
			attributeIds.push(attrs[i]["attrId"])
			attributeNames.push(attrs[i]["attrName"])
			tmpAttrs.push(attrs[i])
		}
	}
	if(isEmpty){
		removeAllNextElement(button);
		$(button.parentNode).append("<span>请选择属性后再点击</span>")
		return
	}
	if(!isable){
		removeAllNextElement(button);
		$(button.parentNode).append("<span>请重新选择属性后再点击</span>")
		return
	}
	isable = false
	clearTable(tableId);
	var multiple = 1;
	var valueIds = []
	var valueNames = []
	var thead = table.insertRow();
	for (var i = 0; i < tmpAttrs.length; i++) {
		thead.insertCell().innerHTML = attrs[i]["attrName"]
	}
	thead.insertCell().innerHTML = "价格"
	thead.insertCell().innerHTML = "<input value='"+ goodsId +"' name='goodsId' hidden='true'>"
	for (var i = 0; i < allCounts; i++) {
		row = table.insertRow();
		for (var j = 0; j < tmpAttrs.length; j++) {
			multiple = tmpAttrs[j]["multiple"];
			counts = tmpAttrs[j]["counts"];
			if(i%(allCounts/multiple) == 0){
				valueNames[j] = (tmpAttrs[j]["valueNames"][(i/(allCounts/multiple))%counts])
				valueIds[j] = (tmpAttrs[j]["valueIds"][(i/(allCounts/multiple))%counts])
				cell = row.insertCell();
				cell.setAttribute("rowspan", allCounts/multiple);
				cell.innerHTML = tmpAttrs[j]["valueNames"][(i/(allCounts/multiple))%counts]
			}
		}
		row.insertCell().innerHTML = "<input name='price'>"
		row.insertCell().innerHTML = "<input value='" + valueIds.join() + "' name='attributeValueIds' hidden='true'>"
		row.insertCell().innerHTML = "<input value='" + valueNames.join() + "' name='attributeValueNames'>"
		row.insertCell().innerHTML = "<input value='" + attributeIds.join() + "' name='attributeIds' hidden='true'>"
		row.insertCell().innerHTML = "<input value='" + attributeNames.join() + "' name='attributeNames'>"
	}
}

/*
 * 当select变化时，动态生成下一级select以及将当前选择结果暂存至categoryId中
 */
var url = "<%=basePath%>category/getSon"
var args = {"parentId":0}
function change(current){
	if(current.value != 0){
		args["parentId"] = current.value
		$.getJSON(url,args,function(data){
			if(data.length > 0){
				removeAllNextElement(current);
				$(current.parentNode).append(createSelect(data));
				document.getElementById('categoryId').value = "";
			}else{
				document.getElementById('categoryId').value = current.value;
			}
		})
	}else{
		removeAllNextElement(current);
		document.getElementById('categoryId').value = "";
	}
}
</script>
</body>
</html>