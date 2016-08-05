<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %> 
<script type="text/javascript">
	$(function() {
		$
				.ajax({
					type : "get",
					url : "http://localhost:8080/core-web-C/publishOrder/orderCustomerInfoVo?orderNo=${orderNo }",
					dataType : "json",
					success : function(msg) {
						//alert("Data Saved: " + msg.orderCustomerInfo.bespeakName+"--");
						$('#bespeakName').text(
								msg.orderCustomerInfo.bespeakName);
						$('#bespeakPhone').text(
								msg.orderCustomerInfo.bespeakPhone);
						$('#companyName').text(
								msg.orderCustomerInfo.companyName);
						$('#addressDetail').text(
								msg.reciveAddress.addressDetail);
						$('#customDepartment').text(
								msg.orderCustomerInfo.customDepartment);
						$('#orderMeasureAddress').text(
								msg.list[0].addressDetail);
					}
				});
		$
				.ajax({
					type : "get",
					url : "http://localhost:8080/core-web-C/publishOrder/orderCustomDemandVo?orderNo=${orderNo }",
					dataType : "json",
					success : function(msg) {
						$('#customNum').text(msg.orderCustomDemand.customNum);
						$('#customBudget').text(
								msg.orderCustomDemand.customBudget + "￥");
						$('#customCycle').text(
								msg.orderCustomDemand.customCycle + "个工作日");
						$('#categoryName').text(
								msg.orderCustomDemand.categoryName);
						$('#categoryProperty').text(
								msg.orderCustomDemand.categoryProperty);
						$('#goodsName').text(msg.orderCustomGoods[0].goodsName);
					}
				});
		$
		.ajax({
			type : "get",
			url : "/core-web-B/pay/contractInfo?orderNo=${orderNo }&spId=${spId }",
			dataType : "json",
			success : function(msg) {
				$('#makeDays').text(msg.orderContract.makeDays+ "个工作日");
				$('#customCycle').text(msg.orderContract.customCycle);
				$('#customMoney').text("定制预算： "+msg.orderContract.customMoney+"元");
				$('#customCategory').text("定制类型： "+msg.orderContract.customCategory);
				$('#totalNum').text("定制数量： "+msg.totalNum+"件");
				$('#totalMoney').text("定制数量： "+msg.orderContract.totalMoney+"元");
				
				var prepaymentPercent = msg.spContract.prepaymentPercent*100;
				var finalMoney = msg.finalMoney*100;
				var creditDepositPercent = msg.spContract.creditDepositPercent*100;
				$('#prepaymentPercent').text(prepaymentPercent+"%");
				$('#frontMoney').text(msg.orderContract.frontMoney+"元");
				$('#balancePayment').text(msg.orderContract.balancePayment+"元");
				$('#creditDeposit').text(msg.orderContract.creditDeposit+"元");
				$('#creditDepositPercent').text(creditDepositPercent+"%");
				$('#finalMoney').text(finalMoney+"%");
				$('#customProperty').text("定制属性： "+msg.orderContract.customProperty);
				$("#customGoods").append("<table>");
				for ( var i in msg.list) {
					$("#customGoods").append("<tr><td>"+list.goodsName+"  "+list.attributeValueNames+"</td></tr>");
				}
				$("#customGoods").append("</table>");
			}
		});
		
	});
</script>
<!-- 上门量体及之后的状态的定制信息   -->
<div class="lr_taggle">
	<div class="togg_list">
		<span class="on">定制需求</span> <span>合同</span>
		<div class="clear"></div>
	</div>
	<div class="togg_cont">
		<div class="taggle">
			<div class="kehuinfo">
				<p>
					<span><img src="<%=basePath%>resources/img/tou_1.png">客户信息</span>
				</p>
			</div>
			<div class="bor_info">
				<div class="xiqinfo">
					<p>
						姓名：<a id="bespeakName"></a>
					</p>
					<p>
						手机号：<a id="bespeakPhone"></a>
					</p>
				</div>
				<div class="xiqinfo">
					<p>
						<span>企业名称</span>：<a id="companyName"></a>
					</p>
					<p>
						<span>企业地址</span>：<a id="addressDetail"></a>
					</p>
				</div>
				<div class="xiqinfo xiqinfo_1">
					<p>
						<span>定制部门</span>：<a id="customDepartment"></a>
					</p>
					<p>
						<span>量体地址</span>：<a id="orderMeasureAddress">北京市海淀区西四环68号左岸公社6层</a>
					</p>
				</div>
			</div>

			<div class="kehuinfo">
				<p>
					<span><img src="<%=basePath%>resources/img/ye_1.png">客户定制需求</span>
				</p>
			</div>
			<div class="dingzfs">
				<p>
					<span>定制方式</span>：<label class="col">量体定制</label>
				</p>
				<p>
					<span>定制数量</span>：<label class="col" id="customNum"></label>
				</p>
				<p>
					<span>定制预算</span>：<label class="col" id="customBudget"></label>
				</p>
				<p>
					<span>定制周期</span>：<label class="col" id="customCycle"></label>
				</p>
				<p>
					<span>定制品类</span>：<label class="col" id="categoryName"></label>
				</p>
				<p>
					<span>定制属性</span>：<label class="col" id="categoryProperty"></label>
				</p>
				<p>
					<span>商品名称</span>：<label class="col" id="goodsName"><img
						src="<%=basePath%>resources/img/list1.png" /><a
						href="#"> 查看商品详情 >></a></label>
				</p>
			</div>


		</div>
		<div class="taggle taggle_ht none">
			<div class="ht_tit">
				<div class="tit_1">
				<c:if test="${baseOrder.status == '140' }">
				    <span>合同状态：<a class="a_6bbe6c">确认生效</a></span>
				</c:if>
				<c:if test="${baseOrder.status != '140' }">
				<span>合同状态：<a class="a_6bbe6c">未生效，待确认</a></span>
				</c:if>
				</div>
				<div class="tit2">
					<span class="span1">服务商：依文服饰股份有限公司</span><span class="span2">13822222222</span><span
						class="span3">平台级定制保障</span>
				</div>
				<div class="tit2">
					<span>您与服务商共同签署了合同，现在您可以：</span>
				</div>
				<div class="tit2">
					<p>
						1. 如有需求变更，您可以发起<a class="a_0fa1ed">补充合同</a>，以避免交易纠纷
					</p>
					<p>2. 如交易发生纠纷，您可以联系客服处理，客服热线：4008-888-888</p>
				</div>
			</div>
			<div class="ht_cont">
				<div class="div_ht_t">
					<span>合同</span>
				</div>
				<div class="ht_item">
					<div class="ht_item_tit tit1">生产完成时间</div>
					<p>
						成衣生产制作须在：<a class="a_6bbe6c" id="makeDays">个工作日</a> 完成（量体结束后开始计算生产时间）
					</p>
				</div>
				<div class="ht_item">
					<div class="ht_item_tit tit2">定制内容</div>
					<p>定制方式： 量体定制</p>
					<p id="totalNum"></p>
					<p id="customMoney">定制预算： 70000.00元</p>
					<p id="customCycle">定制周期： 12个工作日</p>
					<p id="customCategory">定制品类： 西服正装</p>
					<p id="customProperty">定制属性： 面料属性XXXXXX，颜色X，版型编号XXXXXX【备注：标牌均印有拉卡拉集团LOGO】</p>
					<p id="customGoods">商品名称： </p>
				</div>
				<div class="ht_item">
					<div class="ht_item_tit tit3">交付与验收</div>
					<p class="p_tit">
						订单总额：<a class="a_6bbe6c" id="totalMoney">60000.00元</a>
					</p>
					<p>
						阶段一：支付订金-订单总额的<label id="prepaymentPercent"></label>，即<label class="col" id="frontMoney"> 24000.00元</label><br />双方签订合同并且客户支付订金成功后，服务商指派量体师上门量体，量体结束后量体数据由客户确认，服务商开始生产制作
					</p>
				</div>
				<div class="ht_item">
					<p>
						阶段二：支付尾款-订单总额的<label id="finalMoney"></label>，即 <a class="a_6bbe6c" id="balancePayment">36000.00元</a><br />服务商生产制作完成后，客户支付尾款，尾款支付成功服务商发货<br />若生产制作周期(量体结束后开始计算天数)超过15个工作日，服务商承诺赔付订单总额<label id="creditDepositPercent"></label>的履约保证金，即<a
							class="a_6bbe6c" id="creditDeposit">6000.00元</a>
					</p>
				</div>
				<div class="ht_item">
					<p>
						阶段三：签收验货<br />【服务商承诺：不合体免费返修，二次返修不合格免费重做】
					</p>
				</div>
				<div class="ht_item">
					<div class="ht_item_tit tit4">双方责任</div>

					<p>
						1. 服务商开始工作前应和客户确认定制周期时间、定制需求、和每个阶段的付款比例及逾期生产完成的赔付比例等，双方无异议后开始工作。<br />
						2. 客户托管金额后，服务商如在约定交付时间内没有完成生产制作，服务商需要主动赔付客户履约保证金。<br /> 3.
						服务商与客户自行协商修改等问题，服务商设计、打样定稿后，客户如需重新制作、大改等可能导致工期延时需要重新签订补充合同，说明原因并协商费用。<br />
						4. 生产制作阶段，不接受退款处理。
					</p>
				</div>
				<div class="ht_item">
					<div class="ht_item_tit tit5">售后保障</div>

					<p>
						服务商承诺为客户提供以下售后服务，具体为：<br />
						服务商承诺保证完成，保证质量并修改到客户满意为止，当客户部分或全额付款后，若服务商违背承诺，客户有权发起维权，经判定维权成功，客户可以获得双倍赔付（依服宝将扣除服务商的保证金先行赔付给客户）。<br />
						<a class="a_6bbe6c">>>服务商违背了该项承诺？立即 发起争议维权</a>
					</p>
				</div>

				<div class="ht_item ht_item_last">
					<div class="item">
						<div class="state no"></div>
						<p>甲方（客户）：依服宝网络科技有限公司</p>
					</div>
					<div class="item">
						<div class="state yes"></div>
						<p>乙方（服务商）：依文服饰股份有限公司</p>
						<p id="">合同生效时间：2016-01-12</p>
					</div>
					<div class="clear"></div>
					<c:if test="${baseOrder.status < '140' }">
					<div class="ht_btn">
						<a href="#">同意该合同</a>
					</div>
					</c:if>
					
					
				</div>
			</div>
		</div>
	</div>
</div>
