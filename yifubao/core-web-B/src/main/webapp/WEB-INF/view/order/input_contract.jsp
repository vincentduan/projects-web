<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/view/common/import.jsp"%>
  <style type="text/css">
        .fixed_table{ border:1px solid #FFF; margin:0 30px;}

        .fixed_table table{ width:770px; margin:0 auto; margin-top:20px; border:1px solid #e3e3e3; border-collapse:collapse;}
        .fixed_table table tr td{border:1px solid #e3e3e3;  text-align:center;  padding:5px 10px;}
        .fixed_table table tr td a{text-decoration:underline; color: #666;}
        .fixed_table table tr td img{ vertical-align:middle;margin-right:20px;}
        .fixed_table_btn{ text-align:center; margin-top:20px;}
    </style>
<script>
        $(function () {
            //获取系统时间。
           var dateTime=new Date();
           var year = dateTime.getFullYear();
           var month = dateTime.getMonth();
           var day = dateTime.getDate();
           var local = dateTime.toLocaleString();
           var time = year+"-"+month+"-"+day;
           /*  alert(month); */
           $("#systemTime").text(time);

        })
        function getNum(){
            var totalMoney = document.getElementById("totalMoney").value;
            var prepaymentPercent = ${spContract.prepaymentPercent};
            document.getElementById("frontMoney").value = totalMoney*prepaymentPercent;
            document.getElementById("balancePayment").value = totalMoney*(1-prepaymentPercent);
            document.getElementById("creditDeposit").value = totalMoney*${spContract.creditDepositPercent};
            var balancePayment = document.getElementById("balancePayment").value;
            var creditDeposit = document.getElementById("creditDeposit").value;
            var frontMoney = document.getElementById("frontMoney").value;
            $('#frontMoney').text(frontMoney+"元");
            $('#creditDeposit').text(creditDeposit+"元");
            $('#balancePayment').text(balancePayment+"元");
        }
        
        function search_goods(){
        	/* var form = document.getElementById("_search")
        	form.submit();  */
        	var name = $("#goods_name").val();
        	var categoryId = document.getElementById("_categoryId").value;
        	getUrl = "/core-web-B/contract/findGoods"
        	args = {"name":name,"categoryId":categoryId}
        	console.log(args);
        	$.getJSON(getUrl,args,function(data){
        	    
        		table = document.getElementById("_table");
        	    rowNum = table.rows.length;
        	    while(rowNum > 1)
        	    {
        	    	table.deleteRow(1);
        	        rowNum -= 1;
        	    }
        		for ( var i in data) {

		        	thead = table.insertRow();
		        	thead.insertCell().innerHTML = "<input type='checkbox' name='goodsSkuId' value="+data[i].goodsSku.id+">";
		        	thead.insertCell().innerHTML = data[i].goods.id;
		        	thead.insertCell().innerHTML = "<img src='' />"+data[i].goods.name;
		        	thead.insertCell().innerHTML = data[i].category.name;
		        	thead.insertCell().innerHTML = data[i].goodsSku.attributeValueNames;
		        	/* $('#fix_cont table').append(" <tr><td><input type='checkbox' value='data[i].goodsSku.id' /></td><td>"+data[i].goods.id+"</td><td><img src='' />"+data[i].goods.name+"</td>"+
		        			" <td>"+data[i].category.name+"</td><td>"+data[i].goodsSku.attributeValueNames+"</td></tr>"); */
				}
    		})
        }
        function saveGoods(){
        	var form = document.getElementById("_save");
        	form.submit();
        }
        function contract(){
        	var form = document.getElementById("form_contract");
        	form.submit();
        }
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

				<div class="zhengwen">

					<div class="leirong">

						<p class="leirong_1">
							待付款订单<a href="#">返回</a>
						</p>
						<div class="taggle taggle_ht">
							<div class="ht_tit">
								<div class="tit_1">
									<span>合同状态：<a class="a_6bbe6c">未生效，待确认</a></span>
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
							<form id="form_contract" action="/core-web-B/contract/entry" method="post">
							<div class="ht_cont">
							    <input type="hidden" value="${orderNo }" name="orderNo">
							    <input type="hidden" value="${orderContractId }" name="orderContractId">
								<div class="div_ht_t">
									<span>合同</span>
								</div>
								<div class="ht_item">
									<div class="ht_item_tit tit1">生产完成时间</div>
									<p>
										成衣生产制作须在：<a class="a_6bbe6c"><input type="text" name="makeDays"/></a>个工作日完成（量体结束后开始计算生产时间）
									</p>
								</div>
								<div class="ht_item">
									<div class="ht_item_tit tit2">定制内容</div>
									<p>定制方式： 量体定制</p>
									<p>
										定制数量： <a class="a_6bbe6c"><input type="text" name=""/></a>件
									</p>
									<p>
										量体数量： <a class="a_6bbe6c"><input type="text" name="measureNum" /></a>件
									</p>
									<p>
										定制预算： <a class="a_6bbe6c"><input type="text" name="customMoney"/></a>元
									</p>
									<p>
										定制周期： <a class="a_6bbe6c"><input type="text" name="customCycle"/></a>个工作日
									</p>
									<p>
										定制品类： <a class="a_6bbe6c"><select name="customCategory">
												<c:forEach items="${categorys }" var="item">
													<option value="${item.name }">${item.name }</option>
												</c:forEach>
										</select></a>
									</p>
									<p>
										备注：
										<textarea name="customProperty" id="textarea" onKeyDown="textdown(event)"
											onKeyUp="textup()"
											onfocus="if(value=='如面料属性、颜色、版号等'){value=''}"
											onblur="if (value ==''){value='如面料属性、颜色、版号等'}">如面料属性、颜色、版号等</textarea>
									</p>
									<p class="p_btn">定制商品： <a onclick="$('.fixed').show(); $('.fix_alt_add').show();">+添加商品</a></p>
                                        <!-- 添加商品表格 -->
                                        <div class="fixed_table" id="fixed_table" >
                                        <!-- style="display: none;"> -->
                                        <table>
                                        <c:forEach items="${listCgoods }" var="items">
                                        <%-- <input type="hidden" value="${items.goodsName } ${items.attributeValueNames }" name=""/> --%> 
                                           <tr>     
                                                    <td><img src="../img/f_ico2.png" /></td>
                                                    <td>${items.goodsName } ${items.attributeValueNames }</td>
                                                    <td>单价：<input name="${items.id }_price" type="text" size="8px"placeholder="输入金额"></input>元</td>
                                                    <td>数量：<input name="${items.id }_num" type="text" size="8px" placeholder="输入数量"></input>件</td>
                                                    <td><a href="/core-web-B/contract/del?id=${items.id  }">删除</a></td>
                                            </tr>
                                        </c:forEach>
                                        </table>
                                        </div>
								</div>
								<div class="ht_item">
									<div class="ht_item_tit tit3">交付与验收</div>
									<p class="p_tit">
										订单总额：<a class="a_6bbe6c"><input type="text" onblur="getNum();" id="totalMoney" name="totalMoney"
											value="" />元</a>
									</p>
									<p>
										阶段一：支付订金-订单总额的<fmt:formatNumber value="${spContract.prepaymentPercent}" type="percent" />，即 <a class="a_6bbe6c"><input id="frontMoney" name="frontMoney" readonly="readonly"/>元</a><br />双方签订合同并且客户支付订金成功后，服务商指派量体师上门量体，量体结束后量体数据由客户确认，服务商开始生产制作
									</p>
								</div>
								<div class="ht_item">
									<p>
										阶段二：支付尾款-订单总额的<fmt:formatNumber value="${finalMoney}" type="percent" />，即 <a class="a_6bbe6c"><input  id="balancePayment" name="balancePayment" readonly="readonly"/>元</a><br />服务商生产制作完成后，客户支付尾款，尾款支付成功服务商发货<br />若生产制作周期(量体结束后开始计算天数)超过15个工作日，服务商承诺赔付订单总额<fmt:formatNumber value="${spContract.creditDepositPercent}" type="percent" />的履约保证金，即<a
											class="a_6bbe6c"><input  id="creditDeposit" name="creditDeposit" readonly="readonly"/>元</a>
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
										1.
										服务商开始工作前应和客户确认定制周期时间、定制需求、和每个阶段的付款比例及逾期生产完成的赔付比例等，双方无异议后开始工作。<br />
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

										<p>甲方（客户）：依服宝网络科技有限公司</p>
									</div>
									<div class="item">

										<p>乙方（服务商）：依文服饰股份有限公司</p>
										<p>合同生效时间：<a id="systemTime">2016-3-14</a></p>
									</div>
									<div class="clear"></div>
									<div class="ht_btn">
										<a href="#" onclick="contract();">同意该合同</a>
									</div>
								</div>
							</div>
							</form>
						</div>

					</div>
				</div>
			</div>
			<div class="clear"></div>
		</div>

	</div>
	<!-------------------------------------- 内容结束 -------------------------------------->
	<!-------------------------------------- 尾部开始 -------------------------------------->
    <jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
	<!-------------------------------------- 尾部结束 -------------------------------------->
	<div class="fixed"></div>
    <div class="fix_alt_add">
        <div class="fix_tit">
            <a  class="goback" onclick="$('.fixed').hide(); $('.fix_alt_add').hide();">返回</a>
            <span class="h_tit">添加商品</span>
        </div>
        <span class="span_tit">商品列表</span>
        <div class="fix_cont" id="fix_cont">
            <form id="_search" action="/core-web-B/contract/searchGoods">
            <div class="cont_tit">
                <span>商品名称：</span>
                <label><input type="text" placeholder="请输入商品名称" name="name" id="goods_name" /></label>
                <span>商品分类：</span>
                <label><select name="categoryId" id="_categoryId">
              <option value="" selected="true">请选择</option>
              <c:forEach items="${categorys }" var="item">
              <option value="${item.id }">${item.name }</option>
              </c:forEach>
               </select></label>
                <span><a onclick="search_goods();">搜 索</a></span>
            </div>
            </form>
            <form action="/core-web-B/contract/saveContractGoods" id="_save">
            <input type="hidden" value="${orderNo }" name="orderNo">
            <table id="_table">
                <tr>                    
                    <th></th>
                    <th>商品ID</th>
                    <th>商品名称</th>
                    <th>商品分类</th>
                    <th>商品属性</th>
                </tr>
            </table>
            <div class="page_size">
                <p>
                    <span><a href="#">首页</a></span>
                    <a href="#">1</a>
                    <a href="#" class="on">2</a>
                    <a href="#">3</a>
                    <a href="#">4</a>
                    <a href="#">5</a>
                    <a href="#">6</a>
                    <a href="#">...</a>
                    <span><a href="#">下一页</a></span>
                    <span><a href="#">末页</a></span>
                    <span>显示<label>1</label>到<label>8</label>条，共<label>78</label>条记录</span>
                </p>
            </div>
             </form>
        </div>
        <div class="fix_btn"><a onclick="saveGoods();">保&nbsp; &nbsp; &nbsp;存</a></div>
    </div>
</body>
</html>