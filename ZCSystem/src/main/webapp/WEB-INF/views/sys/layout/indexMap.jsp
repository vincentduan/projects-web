<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/views/sys/includes/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>首页</title>
<meta name="decorator" content="default" />
<%@include file="/WEB-INF/views/sys/includes/dialog.jsp"%>
<style type="text/css">
	#mainMap{width: 100%;height:450px;}
	#map table {float: right; width: 150px; margin: auto 10px;position: relative;top:-300px;}
	.container-fluid caption {font-size: 22px;font-weight: bold;line-height: 34px;}
	.table th{text-align: center; vertical-align: middle; }
</style>
</head>
<body>
	<div class="container-fluid" id="map">
		<div class="text-center"><h3>垃圾短信实时监控</h3></div>
		<div id="mainMap"></div>
		<table class="table table-striped table-bordered">
			<caption>数据来源</caption>
			<tbody>
				<tr>
					<td width="68%">10010</td>
					<td>11</td>
				</tr>
				<tr>
					<td>100101111</td>
					<td>110</td>
				</tr>
				<tr>
					<td>手机营业厅</td>
					<td>9</td>
				</tr>
				<tr>
					<td>12210</td>
					<td>112</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span4"><h1>KPI考核情况</h1></div>
			<div class="span4 offset2">
			<select class="select" style="float: right;">
				<option>2015-12</option>
				<option>2015-11</option>
				<option>2015-10</option>
			</select>
			</div>
			<div class="span2 btn btn-primary">详情下载</div>
		</div>

		<table class="table table-striped table-bordered">
			<thead style="font-size:14px; ">
				<tr >
					<th rowspan="2">省份</th>
					<th rowspan="2">举报率(件/千万户)</th>
					<th rowspan="2">累计扣分</th>
					<th colspan="4">当月超标量(件)</th>
					<th colspan="4">累计超标量(件)</th>
				</tr>
				<tr>
					<th>总计</th>
					<th>点对点</th>
					<th>端口</th>
					<th>10010端口</th>
					<th>总计</th>
					<th>点对点</th>
					<th>端口</th>
					<th>10010端口</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>全国</td>
					<td width="9.1%">100</td>
					<td width="9%">0.20</td>
					<td width="9%">33</td>
					<td width="9%">44</td>
					<td width="9%">0</td>
					<td width="9%">0</td>
					<td width="9%">303</td>
					<td width="9%">304</td>
					<td width="9%">0</td>
					<td width="9%">0</td>
				</tr>
				<tr>
					<td>全国</td>
					<td width="9.1%">100</td>
					<td width="9%">0.20</td>
					<td width="9%">33</td>
					<td width="9%">44</td>
					<td width="9%">0</td>
					<td width="9%">0</td>
					<td width="9%">303</td>
					<td width="9%">304</td>
					<td width="9%">0</td>
					<td width="9%">0</td>
				</tr>
				<tr>
					<td>江苏</td>
					<td width="9.1%">100</td>
					<td width="9%">0.20</td>
					<td width="9%">33</td>
					<td width="9%">44</td>
					<td width="9%">0</td>
					<td width="9%">0</td>
					<td width="9%">303</td>
					<td width="9%">304</td>
					<td width="9%">0</td>
					<td width="9%">0</td>
				</tr>
				<tr>
					<td>湖北</td>
					<td width="9.1%">100</td>
					<td width="9%">0.20</td>
					<td width="9%">33</td>
					<td width="9%">44</td>
					<td width="9%">0</td>
					<td width="9%">0</td>
					<td width="9%">303</td>
					<td width="9%">304</td>
					<td width="9%">0</td>
					<td width="9%">0</td>
				</tr>
				<tr>
					<td>江西</td>
					<td width="9.1%">100</td>
					<td width="9%">0.20</td>
					<td width="9%">33</td>
					<td width="9%">44</td>
					<td width="9%">0</td>
					<td width="9%">0</td>
					<td width="9%">303</td>
					<td width="9%">304</td>
					<td width="9%">0</td>
					<td width="9%">0</td>
				</tr>
				<tr>
					<td>甘肃</td>
					<td width="9.1%">100</td>
					<td width="9%">0.20</td>
					<td width="9%">33</td>
					<td width="9%">44</td>
					<td width="9%">0</td>
					<td width="9%">0</td>
					<td width="9%">303</td>
					<td width="9%">304</td>
					<td width="9%">0</td>
					<td width="9%">0</td>
				</tr>
				<tr>
					<td>江西</td>
					<td width="9.1%">100</td>
					<td width="9%">0.20</td>
					<td width="9%">33</td>
					<td width="9%">44</td>
					<td width="9%">0</td>
					<td width="9%">0</td>
					<td width="9%">303</td>
					<td width="9%">304</td>
					<td width="9%">0</td>
					<td width="9%">0</td>
				</tr>
				<tr>
					<td>重庆</td>
					<td width="9.1%">100</td>
					<td width="9%">0.20</td>
					<td width="9%">33</td>
					<td width="9%">44</td>
					<td width="9%">0</td>
					<td width="9%">0</td>
					<td width="9%">303</td>
					<td width="9%">304</td>
					<td width="9%">0</td>
					<td width="9%">0</td>
				</tr>
				<tr>
					<td>山西</td>
					<td width="9.1%">100</td>
					<td width="9%">0.20</td>
					<td width="9%">33</td>
					<td width="9%">44</td>
					<td width="9%">0</td>
					<td width="9%">0</td>
					<td width="9%">303</td>
					<td width="9%">304</td>
					<td width="9%">0</td>
					<td width="9%">0</td>
				</tr>
				<tr>
					<td>四川</td>
					<td width="9.1%">100</td>
					<td width="9%">0.20</td>
					<td width="9%">33</td>
					<td width="9%">44</td>
					<td width="9%">0</td>
					<td width="9%">0</td>
					<td width="9%">303</td>
					<td width="9%">304</td>
					<td width="9%">0</td>
					<td width="9%">0</td>
				</tr>
			</tbody>
		</table>
	</div>
	<script type="text/javascript"
		src="${ctxStatic}/echarts-2.2.7/build/dist/echarts.js"></script>
	<script type="text/javascript" src="${ctxStatic}/modules/map.js"></script>
</body>
</html>