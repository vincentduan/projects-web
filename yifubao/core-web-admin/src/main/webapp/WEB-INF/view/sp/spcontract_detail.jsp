<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.efubao.core.admin.utils.StatusEnum" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商户管理>>合同详情</title>
<link href="/core-admin/resources/css/goodsStyle.css" rel="stylesheet" type="text/css"/>
<link href="/core-admin/resources/css/common.css" rel="stylesheet" type="text/css"/>
<link href="/core-admin/resources/css/bootstrap.min.css" rel="stylesheet" media="screen">
<script src="/core-admin/resources/js/jquery-1.4.2.min.js" type="text/javascript"></script>
<script src="/core-admin/resources/js/jquery.min.js" type="text/javascript"></script>
<script src="/core-admin/resources/js/base_v1.js" type="text/javascript"></script>
<link rel="stylesheet" href="/core-admin/resources/css/default.css" />
<script charset="utf-8" src="/core-admin/resources/editor/kindeditor.js"></script>
<script charset="utf-8" src="/core-admin/resources/editor/lang/zh_CN.js"></script>
<script type="text/javascript">
	window.onload = function() {
		document.getElementById('商户管理').className = "hover";
	}
</script>
</head>
<body>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<div class="cont">
  <div class="w">
    <!--内容-->
    <div class="view-list">
      <table width="90%" class="ui-tab">
        <tbody>
          <tr>
            <th colspan="4">合同详情</th>
          </tr>
          <tr>
            <td><span style="color:#FF0000;">* </span>服务商名称：</td>
            <td colspan="2">${spContractVo.spName }</td>
          </tr>
          <tr>
            <td><span style="color:#FF0000;">* </span>合同名称：</td>
            <td colspan="2">${spContractVo.contractName }</td>
          </tr>
          <tr>
            <td><span style="color:#FF0000;">* </span>合同编号：</td>
            <td colspan="2">${spContractVo.contractNum }</td>
          </tr>
          <tr>
            <td><span style="color:#FF0000;">* </span>合同有效期：</td>
            <td><fmt:formatDate value="${spContractVo.validStartDate}" pattern="yyyy-MM-dd"/>至<fmt:formatDate value="${spContractVo.validEndDate}" pattern="yyyy-MM-dd"/></td>
          </tr>
          <tr>
            <td><span style="color:#FF0000;">* </span>经营品类</td>
            <td><span><c:forEach items="${spContractVo.category}" var="item">${item.name }></c:forEach></td>
          </tr>
          <tr>
            <td ><span style="color:#FF0000;">* </span>发票类型</td>
            <td >
            <input name="invoice" type="radio" disabled value="1" ${(spContractVo.invoiceType=='1')?'checked' : ''} />普通发票&nbsp;&nbsp;
            <input name="invoice" type="radio" disabled value="2" ${(spContractVo.invoiceType=='2')?'checked' : ''} />增值税发票发票
            </td>
          </tr>
          <tr>
          	<td><span style="color:#FF0000;">*佣金 </span><span style="color:#333333;">(订单总额占比)：</span></td>
            <td>${spContractVo.commissionPercent*100 }%</td>
          </tr>
          <tr>
          	<td><span style="color:#FF0000;">*预付款 </span><span style="color:#333333;">(订单总额占比)：</span></td>
            <td>${spContractVo.prepaymentPercent*100 }%</td>
          </tr>
          <tr>
          	<td><span style="color:#FF0000;">*履约保证金 </span><span style="color:#333333;">(订单总额占比)：</span></td>
            <td>${spContractVo.creditDepositPercent*100 }%</td>
          </tr><tr>
          	<td><span style="color:#FF0000;">*质保金 </span><span style="color:#333333;">(订单总额占比)：</span></td>
            <td>${spContractVo.qualityDepositPercent*100 }%</td>
          </tr>
          <tr>
          	<td><span style="color:#FF0000;">*平台技术服务费 </span><span style="color:#333333;">(按年收取)：</span></td>
            <td>${spContractVo.serviceFee }</td>
          </tr>
          <tr>
          	<td colspan="2" style="padding-left:20%">
            	<input name="" type="button" class="fanhui" value="返回" onClick="javascript:void(0);"/>
            </td>
          </tr>
        </tbody>
      </table>
    </div>

  </div>
</div>				

</body>
</html>
