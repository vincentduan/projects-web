<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.efubao.core.admin.utils.StatusEnum" %>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加合同</title>
<link href="/core-admin/resources/css/common.css" rel="stylesheet" type="text/css"/>
<script src="/core-admin/resources/js/jquery.min.js" type="text/javascript"></script>
<script src="/core-admin/resources/js/base_v1.js" type="text/javascript"></script>
<link rel="stylesheet" href="/core-admin/resources/css/datedefault.css" type="text/css">
<link rel="stylesheet" href="/core-admin/resources/css/goodsStyle.css" type="text/css">
<script type="text/javascript" src="/core-admin/resources/js/jquery-1.12.0.js"></script>
<script type="text/javascript" src="/core-admin/resources/js/zebra_datepicker.js"></script>
<script type="text/javascript" src="/core-admin/resources/js/core.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<div class="cont">
  <div class="w">
    <!--内容-->
    <div class="view-list">
    <form action="<%=basePath%>spcontract/spcontractadd" method="post">
      <table width="90%" class="ui-tab">
	        <tbody>
	          <tr>
	            <th colspan="4">添加合同</th>
	          </tr>
	          <tr>
	            <td style="width:200px"><span style="color:#FF0000;">* </span>服务商名称：</td>
	            <td colspan="2">
	            	<c:choose>
	            		<c:when test="${isServiceProvider==1 }">
	            			${serviceProvider.name }
	            			<input type="hidden" name="hidden_id" value="${serviceProvider.id }">
	            		</c:when>
	            		<c:otherwise>
		            		<select class="text-select" name = "spName" style="width:185px;">
				                <option value="0" selected="true">请选择</option>
				                <c:forEach items="${list }" var="list">
									<option value="${list.id }">${list.name }</option>
								</c:forEach>
			                </select>
	            		</c:otherwise>
	            	</c:choose>
	            </td>
	          </tr>
	          <tr>
	            <td><span style="color:#FF0000;">* </span>合同名称：</td>
	            <td><input type="text" name="contractName" class="text-input" value="请输入合同名称"></input></td>
	          </tr>
	          <tr>
	            <td><span style="color:#FF0000;">* </span>合同编号：</td>
	            <td colspan="2"><input type="text" name="contractNum" class="text-input" value="请输入合同编号"></input></td>
	          </tr>
	          <tr>
	            <td><span style="color:#FF0000;">* </span>合同有效期：</td>
	            <td><input id="datepicker-example1-1" name="validStartDate" type="text">
	            &nbsp;至&nbsp;<input id="datepicker-example1-2" name="validEndDate" type="text"></td>
	          </tr>
	          <tr>
	            <td><span style="color:#FF0000;">* </span>经营品类</td>
	            <td><select class="text-select" name="category" style="width:185px;">
	                <option value="0" name="sp_category" selected="true">请选择</option>
	                <c:forEach items="${category }" var="cat">
						<option value="${cat.id }">${cat.name }</option>
					</c:forEach>
	              </select></td>
	          </tr>
	          <tr>
	            <td ><span style="color:#FF0000;">* </span>发票类型</td>
	            <td ><input name="invoice" type="radio" value="1">普通发票</input>&nbsp;&nbsp;
	            <input name="invoice" type="radio" value="2">增值税发票</input>
	            </td>
	          </tr>
	          <tr>
	            <td><span style="color:#FF0000;">*佣金 </span><span style="color:#333333;">(订单总额占比)：</span></td>
	            <td><input type="text" class="text-input" name="commissionPercent"></input>%</td>
	          </tr>
	          <tr>
	            <td><span style="color:#FF0000;">*预付款 </span><span style="color:#333333;">(订单总额占比)：</span></td>
	            <td><input type="text" class="text-input" name="prepaymentPercent"></input>%</td>
	          </tr>
	          <tr>
	            <td><span style="color:#FF0000;">*履约保证金 </span><span style="color:#333333;">(订单总额占比)：</span></td>
	            <td><input type="text" class="text-input" name="creditDepositPercent"></input>%</td>
	          </tr><tr>
	            <td><span style="color:#FF0000;">*质保金 </span><span style="color:#333333;">(订单总额占比)：</span></td>
	            <td><input type="text" class="text-input" name="qualityDepositPercent"></input>%</td>
	          </tr>
	          <tr>
	            <td><span style="color:#FF0000;">*平台技术服务费 </span><span style="color:#333333;">(按年收取)：</span></td>
	            <td><input type="text" class="text-input" name="serviceFee"></input>元</td>
	          </tr>
	          <tr>
	            <td style="padding-left:20%">
	                <input name="submit" type="submit" class="fanhui" value="提交" />
	            </td>
	          </tr>
	        </tbody>
	      </table>
      </form>
    </div>
  </div>
</div>
</body>
</html>