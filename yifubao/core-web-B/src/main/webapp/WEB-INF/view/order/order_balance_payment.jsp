<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>客户待付尾款</title>
<script type="text/javascript"
	src="<%=basePath%>resources/js/jquery.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>resources/css/style_fw.css">
<script type="text/javascript" src="<%=basePath%>resources/js/main.js"></script>
<!--plugin-->
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>resources/css/owl.carousel.min.css">
<script type="text/javascript"
	src="<%=basePath%>resources/js/owl.carousel.js"></script>
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
						$('#makeDays')
								.text(msg.orderContract.makeDays + "个工作日");
						$('#customCycle').text(msg.orderContract.customCycle);
						$('#customMoney').text(
								"定制预算： " + msg.orderContract.customMoney + "元");
						$('#customCategory').text(
								"定制类型： " + msg.orderContract.customCategory);
						$('#totalNum').text("定制数量： " + msg.totalNum + "件");
						$('#totalMoney').text(
								"定制数量： " + msg.orderContract.totalMoney + "元");

						var prepaymentPercent = msg.spContract.prepaymentPercent * 100;
						var finalMoney = msg.finalMoney * 100;
						var creditDepositPercent = msg.spContract.creditDepositPercent * 100;
						$('#prepaymentPercent').text(prepaymentPercent + "%");
						$('#frontMoney').text(
								msg.orderContract.frontMoney + "元");
						$('#balancePayment').text(
								msg.orderContract.balancePayment + "元");
						$('#creditDeposit').text(
								msg.orderContract.creditDeposit + "元");
						$('#creditDepositPercent').text(
								creditDepositPercent + "%");
						$('#finalMoney').text(finalMoney + "%");
						$('#customProperty').text(
								"定制属性： " + msg.orderContract.customProperty);
						$("#customGoods").append("<table>");
						for ( var i in msg.list) {
							$("#customGoods").append(
									"<tr><td>" + list.goodsName + "  "
											+ list.attributeValueNames
											+ "</td></tr>");
						}
						$("#customGoods").append("</table>");
					}
				});

	});
	/* 时间戳转换 */
	function add0(m){return m<10?'0'+m:m }
	function format(timeStamp)
	{
	//timeStamp是整数，否则要parseInt转换
	var time = new Date(timeStamp);
	var y = time.getFullYear();
	var m = time.getMonth()+1;
	var d = time.getDate();
	var h = time.getHours();
	var mm = time.getMinutes();
	var s = time.getSeconds();
	return y+'-'+add0(m)+'-'+add0(d)+' '+add0(h)+':'+add0(mm)+':'+add0(s);
	}
	/* 时间戳转换 end*/
	/*量体信息 */
	$(function() {  
		$.ajax( {  
	        type : "get",  
	        url : "http://localhost:8080/core-web-C/measure/mesureInfo?orderNo=${orderNo }",
	        dataType:"json",  
	        success : function(data) {    			
	        	  $.each(data, function(index, val) {
	        		    var html = '<tr>';
	        		    var measureInfo = val.measureInfo;
	        		    var measureOrder = val.measureOrderProperty;
	        		    var measureInfoProperties = val.measureInfoProperty;   			
	        			
	        		  	//处理表头            			
	        		    if(index==0){
	        		    	var thTable = '<tr><th>序号</th><th>部门</th><th>姓名</th><th>性别</th><th>手机号</th><th>录入时间</th>';
	            			//处理measureInfoProperty
	            		    $.each(measureInfoProperties, function(index, val) {
	            		      thTable += '<th>'+val.measureProperty + '</th>';
	            		    });
	            			thTable +='</tr>';
	            			$('#bodydatatable').append(thTable);
	        		    }
	        			html += '<tr>';
	        		    //处理measureinfo
	        			//ID
	        		    html += '<td>' + measureInfo.id + '</td>';    
	        		    //部门
	        			if(measureInfo.department == null)
	        		      html += '<td>空</td>';
	        		    else      
	        		      html += '<td>' + measureInfo.department + '</td>';
	        			//姓名
	        			html += '<td>' + measureInfo.name + '</td>';
	        			//性别
	        		    if(measureInfo.gender===1)
	        		      html += '<td>男</td>';
	        		    else
	        		      html += '<td>女</td>';
	        		    //手机号
	        		    html += '<td>' + measureInfo.phone + '</td>';
	        		    //录入时间
	        			//时间戳处理        			
	        			html += '<td>' + format(measureInfo.createTime) + '</td>';     		      
		    		    //处理measureInfoProperty
	        		    $.each(measureInfoProperties, function(index, val) {
							html += '<td>'+val.measurePropertyValue+'</td>';
	        		    });
	        		    
	        		    html += '</tr>';
	        		    $('#bodydatatable').append(html);
	        		  });
	        		},
	    });
	});
	/*量体信息end */
</script>
</head>
<body>
    <!-------------------------------------- 头部开始 -------------------------------------->
    <div class="head">
        <div class="wrap">
            <span class="flt"><a href="#">依文集团</a> & <a href="#">猪八戒网</a>　<a href="#">旗下职业装定制平台</a></span>
            <div class="title_j">
				<ul>
					<li><a href="#"><img src="<%=basePath%>resources/img/xiaoxi.png"/>消息</a></li>
					<li><a href="#">我的定制</a></li>
					<li><a href="#">186****2313</a><label><img src="<%=basePath%>resources/img/sanjiao.png"/></label></li>
				</ul>
			</div>
            <div class="clear"></div>
        </div>
		
    </div>
    <div class="input_j">
        <div class="wrap">
            <div class="logo_c">
                <img src="<%=basePath%>resources/img/logo3.png" />
            </div>
            <div class="text_j">
                <p><a href="#">职业装定制</a></p>
                <p><span><a href="#">返回依服宝首页</a></span></p>
            </div>
            <div class="input_a">
                <input type="text" placeholder="输入要搜索的关键词" /><a href="#"><span>搜索</span></a>
            </div>
        </div>
        <div class="clear"></div>
    </div>
    <!-------------------------------------- 头部结束 -------------------------------------->
    <!-------------------------------------- 内容开始 -------------------------------------->


    <div class="mainer">
        
		
		<div class="shent_j">
			<div class="wrap">
				<div class="daohang">
					<p class="daohang_1">交易管理</p>
					<p class="daohang_2 in"><a href="#">订单管理</a></p>
					
					
					<p class="daohang_1 padd">基础设置</p>
					<p class="daohang_2"><a href="#">服务商信息</a></p>
					<p class="daohang_2"><a href="#">案例管理</a></p>
					<p class="daohang_2"><a href="#">量体师管理</a></p>

					
					<p class="daohang_1 padd">账号设置</p>
					<p class="daohang_2"><a href="#">修改登录密码</a></p>
					<p class="daohang_2"><a href="#">修改手机号码</a></p>
					<p class="daohang_2"><a href="#">身份认证</a></p>
					<p class="daohang_2"><a href="#">支付账户管理</a></p>
					<p class="daohang_1 padd">财务管理</p>
					<p class="daohang_2"><a href="#">收支明细</a></p>
					<p class="daohang_1 padd">消息中心</p>
					<p class="daohang_2"><a href="#">全部消息</a></p>
				</div>
				
				<div class="zhengwen">
					<div class="leirong">
						<p class="leirong_1">付尾款订单</p>
						<div class="public">
							<p><label><span class="back_1 on">金额：￥${baseOrder.totalMoney }</span><span class="back_2 ">已支付金额￥${baseOrder.frontMoney }</span></label><i>订单号：${baseOrder.orderNo }</i><i>状态：<em>客户付尾款</em></i><a>支付尾款：￥${baseOrder.balancePayment }</a></p>
						</div>
						<div class="zhuangtai">
                            <div class="div_item">
                                <div class="item on item_first">
                                    <div class="list">
                                        <i></i>
                                        <p class="p1">竞标<span class="span1">(设计、打样、报价)</span></p>
                                        <span>2016-01-10 17:02:42</span>
                                        <div class="tanchuan tanchuan_first in">
                                            <div class="tanchuan_img">
                                              
                                                <div class="sanjia">
                                                    <img src="<%=basePath%>resources/img/xiangxia.png" />
                                                </div>
                                            </div>
                                            <div class="tanchuan_text">
                                                <p>线下沟通</p>
                                                
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="item on">
                                    <div class="list">
                                        <i></i>
                                        <p>中标录合同</p>
                                        <span>2016-01-10 17:02:42</span>
                                        <div class="tanchuan">
                                            <div class="tanchuan_img">
                                              
                                                <div class="sanjia">
                                                    <img src="<%=basePath%>resources/img/xiangxia.png" />
                                                </div>
                                            </div>
                                            <div class="tanchuan_text">
                                                <p>录入合同，带客户确认</p>
                                                
                                            </div>
                                        </div>

                                    </div>
                                </div>
                                <div class="item on">
                                    <div class="list">
                                        <i></i>
                                        <p class="p1">客户<span class="span1">支付定金</span></p>
                                        
										<span>2016-01-10 17:02:42</span>
                                        <div class="tanchuan">
                                            <div class="tanchuan_img">
                                                <div class="sanjia">
                                                    <img src="<%=basePath%>resources/img/xiangxia.png" />
                                                </div>
                                            </div>
                                            <div class="tanchuan_text">
                                                <p>线下与客户沟通，确定合同内容。</p>
                                                
                                            </div>
                                        </div>

                                    </div>
                                </div>
                                <div class="item on">
                                    <div class="list">
                                        <i></i>
                                        <p>上门量体</p>
										<span>2016-01-10 17:02:42</span>
                                        <div class="tanchuan">
                                            <div class="tanchuan_img">
                                                <div class="sanjia">
                                                    <img src="<%=basePath%>resources/img/xiangxia.png" />
                                                </div>
                                            </div>
                                            <div class="tanchuan_text">
                                                <p>指派量体师上门量体</p>
                                                
                                            </div>
                                        </div>

                                    </div>
                                </div>
                                <div class="item on">
                                    <div class="list">
                                        <i></i>
                                        <p>生产制作</p>
										<span>2016-01-10 17:02:42</span>
                                        <div class="tanchuan">
                                            <div class="tanchuan_img">
                                                <div class="sanjia">
                                                    <img src="<%=basePath%>resources/img/xiangxia.png" />
                                                </div>
                                            </div>
                                            <div class="tanchuan_text">
                                                <p>生产完成后，请确认</p>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                                <div class="item on in">
                                    <div class="list">
                                        <i></i>
                                        <p class="p1">客户<span class="span1">支付尾款</span></p>
										<span>2016-01-10 17:02:42</span>
                                        <div class="tanchuan">
                                            <div class="tanchuan_img">
                                                <div class="sanjia">
                                                    <img src="<%=basePath%>resources/img/xiangxia.png" />
                                                </div>
                                            </div>
                                            <div class="tanchuan_text">
                                                <p>待客户付尾款</p>
                                                
                                            </div>
                                        </div>

                                    </div>
                                </div>
                                <div class="item">
                                    <div class="list">
                                        <i></i>
                                        <p>待发货</p>
										<span>2016-01-10 17:02:42</span>
                                        <div class="tanchuan">
                                            <div class="tanchuan_img">
                                                <div class="sanjia">
                                                    <img src="<%=basePath%>resources/img/xiangxia.png" />
                                                </div>
                                            </div>
                                            <div class="tanchuan_text">
                                                <p>带服务商发货</p>
                                                
                                            </div>
                                        </div>

                                    </div>
                                </div>
                                <div class="item">
                                    <div class="list">
                                        <i></i>
                                        <p>待签收</p>
										<span>2016-01-10 17:02:42</span>
                                        <div class="tanchuan">
                                            <div class="tanchuan_img">
                                                <div class="sanjia">
                                                    <img src="<%=basePath%>resources/img/xiangxia.png" />
                                                </div>
                                            </div>
                                            <div class="tanchuan_text">
                                                <p>待签收</p>
                                                
                                            </div>
                                        </div>

                                    </div>
                                </div>
                                
                                <div class="item item_last">
                                    <div class="list">
                                        <i></i>
                                        <p>交易完成</p>
										<span>2016-01-10 17:02:42</span>
                                        <div class="tanchuan">
                                            <div class="tanchuan_img">
                                                <div class="sanjia">
                                                    <img src="<%=basePath%>resources/img/xiangxia.png" />
                                                </div>
                                            </div>
                                            <div class="tanchuan_text">
                                                <p>交易结束</p>
                                                
                                            </div>
                                        </div>

                                    </div>
                                </div>
                                <div class="clear"></div>
                            </div>
                        </div>
						 <div class="lr_taggle">
                            <div class="togg_list">
                                <span class="on">定制需求</span>
                                <span>合同</span>
								<span>量体信息</span>
                                <div class="clear"></div>
                            </div>
                            <div class="togg_cont">
                                <div class="taggle">
                                    <div class="kehuinfo">
                                        <p><span><img src="<%=basePath%>resources/img/tou_1.png">客户信息</span></p>
                                    </div>
                                    <div class="bor_info">
                                        <div class="xiqinfo">
                                            <p>姓名：<a>张三</a></p>
                                            <p>手机号：<a>18612345678</a></p>
                                        </div>
                                        <div class="xiqinfo">
                                            <p><span>企业名称</span>：<a>依服宝网络科技有限公司</a></p>
                                            <p><span>企业地址</span>：<a>北京市海淀区西四环68号左岸公社6层</a></p>
                                        </div>
                                        <div class="xiqinfo xiqinfo_1">
                                            <p><span>定制部门</span>：<a>全体</a></p>
                                            <p><span>量体地址</span>：<a>北京市海淀区西四环68号左岸公社6层</a></p>
                                        </div>
                                    </div>

                                    <div class="kehuinfo">
                                        <p><span><img src="<%=basePath%>resources/img/ye_1.png">客户定制需求</span></p>
                                    </div>
                                    <div class="dingzfs">
                                        <p><span>定制方式</span>：<label class="col">量体定制</label></p>
                                        <p><span>定制数量</span>：<label class="col">100件</label></p>
                                        <p><span>定制预算</span>：<label class="col">70000.00元</label></p>
                                        <p><span>定制周期</span>：<label class="col">12个工作日</label></p>
                                        <p><span>定制品类</span>：<label class="col">西服正装</label></p>
                                        <p><span>定制属性</span>：<label class="col">面料属性XXXXXX，颜色X，版型编号XXXXXX【备注：标牌均印有拉卡拉集团LOGO】</label></p>
                                        <p><span>商品名称</span>：<label class="col"><img src="<%=basePath%>resources/img/list1.png" />男士双排扣西服 XX面料 蓝色 <a href="#">  查看商品详情</a></label></p>
                                    </div>


                                </div>
                                <div class="taggle taggle_ht none">
                                    <div class="ht_tit">
                                        <div class="tit_1"><span>合同状态：<a class="a_6bbe6c">未生效，待确认</a></span></div>
                                        <div class="tit2"><span class="span1">服务商：依文服饰股份有限公司</span><span class="span2">13822222222</span><span class="span3">平台级定制保障</span></div>
                                        <div class="tit2"><span>您与服务商共同签署了合同，现在您可以：</span></div>
                                        <div class="tit2">
                                            <p>1. 如有需求变更，您可以发起<a class="a_0fa1ed">补充合同</a>，以避免交易纠纷</p>
                                            <p>2. 如交易发生纠纷，您可以联系客服处理，客服热线：4008-888-888</p>
                                        </div>
                                    </div>
                                    <div class="ht_cont">
                                        <div class="div_ht_t"><span>合同</span></div>
                                        <div class="ht_item">
                                            <div class="ht_item_tit tit1">生产完成时间</div>
                                            <p>成衣生产制作须在：<a class="a_6bbe6c">15个工作日</a> 完成（量体结束后开始计算生产时间）</p>
                                        </div>
                                        <div class="ht_item">
                                            <div class="ht_item_tit tit2">定制内容</div>
                                            <p>定制方式： 量体定制</p>
                                            <p>定制数量： 100件</p>
                                            <p>定制预算： 70000.00元</p>
                                            <p>定制周期： 12个工作日</p>
                                            <p>定制品类： 西服正装</p>
                                            <p>定制属性： 面料属性XXXXXX，颜色X，版型编号XXXXXX【备注：标牌均印有拉卡拉集团LOGO】</p>
                                            <p>商品名称： 男士双排扣西服 XX面料 蓝色</p>
                                        </div>
                                        <div class="ht_item">
                                            <div class="ht_item_tit tit3">交付与验收</div>
                                            <p class="p_tit">订单总额：<a class="a_6bbe6c">60000.00元</a></p>
                                            <p>阶段一：支付订金-订单总额的40%，即 24000.00元<br />双方签订合同并且客户支付订金成功后，服务商指派量体师上门量体，量体结束后量体数据由客户确认，服务商开始生产制作</p>
                                        </div>
                                        <div class="ht_item">
                                            <p>阶段二：支付尾款-订单总额的60%，即 <a class="a_6bbe6c">36000.00元</a><br />服务商生产制作完成后，客户支付尾款，尾款支付成功服务商发货<br />若生产制作周期(量体结束后开始计算天数)超过15个工作日，服务商承诺赔付订单总额10%的履约保证金，即<a class="a_6bbe6c">6000.00元</a></p>
                                        </div>
                                        <div class="ht_item">
                                            <p>阶段三：签收验货<br />【服务商承诺：不合体免费返修，二次返修不合格免费重做】</p>
                                        </div>
                                        <div class="ht_item">
                                            <div class="ht_item_tit tit4">双方责任</div>

                                            <p>
                                                1. 服务商开始工作前应和客户确认定制周期时间、定制需求、和每个阶段的付款比例及逾期生产完成的赔付比例等，双方无异议后开始工作。<br />
                                                2. 客户托管金额后，服务商如在约定交付时间内没有完成生产制作，服务商需要主动赔付客户履约保证金。<br />
                                                3. 服务商与客户自行协商修改等问题，服务商设计、打样定稿后，客户如需重新制作、大改等可能导致工期延时需要重新签订补充合同，说明原因并协商费用。<br />
                                                4. 生产制作阶段，不接受退款处理。
                                            </p>
                                        </div>
                                        <div class="ht_item">
                                            <div class="ht_item_tit tit5">售后保障</div>

                                            <p>
                                                服务商承诺为客户提供以下售后服务，具体为：<br />
                                                服务商承诺保证完成，保证质量并修改到客户满意为止，当客户部分或全额付款后，若服务商违背承诺，客户有权发起维权，经判定维权成功，客户可以获得双倍赔付（依服宝将扣除服务商的保证金先行赔付给客户）。<br /><a class="a_6bbe6c">>>服务商违背了该项承诺？立即 发起争议维权</a>
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
                                                <p>合同生效时间：2016-01-12</p>
                                            </div>
                                            <div class="clear"></div>
                                            <div class="ht_btn"><a href="#">同意该合同</a></div>
                                        </div>
                                    </div>
                                </div>
                                <div class="taggle taggle_lt none taggle_lt_fw">
                                    <div class="msg">
                                        <div class="left">
                                            <span>量体信息:</span>
                                        </div>
                                        <div class="right">
                                            <label><span></span></label>
                                            <p><span class="txt_left">已完成80%</span><span class="txt_right">80/100</span></p>
                                            <div class="clear"></div>
                                        </div>
                                        <div class="clear"></div>
                                    </div>
                                    <div class="lt_table">
                                        <h3>量体数据</h3>
                                        <table id="bodydatatable">
										</table>
                                    </div>
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
                                            <span>共<label>8</label>页<label>64</label>条</span>
                                        </p>
                                    </div>
                                    <div class="download">
                                        <a>下载量体数据</a>
                                    </div>
                                </div>
                            </div>
                        </div>

						</div>
				</div>
			</div>
			<div class="clear"></div>
		</div>
		
    </div>
    <!-------------------------------------- 内容结束 -------------------------------------->
    <!-------------------------------------- 尾部开始 -------------------------------------->
    <div class="footer">
        <div class="wrap">
            <div class="f_ul">
                <ul>
                    <li><span class="span1">6大免费服务承诺</span></li>
                    <li><span class="span2">金牌管家专属服务</span></li>
                    <li><span class="span3">平台级服务保障</span></li>
                </ul>
            </div>
            <div class="f_nav">
                <ul>
                    <li class="list">
                        <span class="span_tit"><a href="#">买家帮助</a></span>
                        <a href="#">新手指南</a>
                        <a href="#">服务保障</a>
                        <a href="#">帮助中心</a>
                    </li>
                    <li class="list">
                        <span class="span_tit"><a href="#">商家帮助</a></span>
                        <a href="#">商家入驻</a>
                        <a href="#">商家推广</a>
                        <a href="#">帮助中心</a>
                    </li>
                    <li class="list">
                        <span class="span_tit"><a href="#">关于我们</a></span>
                        <a href="#">关于依服宝</a>
                        <a href="#">联系我们</a>
                        <a href="#">加入依服宝</a>
                    </li>
                    <li class="list">
                        <span class="span_tit"><a href="#">关注我们</a></span>
                        <a href="#" class="a_sina">新浪微博</a>
                        <a href="#" class="a_QQ">QQ空间</a>
                        <a href="#" class="a_weibo">腾讯微博</a>
                    </li>
                    <li class="contant">
                        <span class="phone">400-888-8888</span>
                        <p>依服宝客服热线<br />周一至周日：09：00-20：00</p>
                    </li>

                    <li class="li_ewm">
                        <p>
                            <img src="<%=basePath%>resources/img/ewm.png" />
                            <span>依服宝<br />APP下载</span>
                        </p>
                    </li>
                    <li class="li_ewm">
                        <p>
                            <img src="<%=basePath%>resources/img/ewm.png" />
                            <span>依服宝<br />微信服务号</span>
                        </p>
                    </li>
                </ul>
            </div>

            <div class="copyright">
                <p>Copyright © 2015 efubao.com 电信与信息服务业务经营许可证100798号 经营性网站备案信息 京ICP备11031139号 京公网安备110108006045</p>
<p>客服邮箱：kf@efbao.com 客服电话：4008-888-888 文明办网文明上网举报电话：010-82615762 违法不良信息举报中心 我最爱的人民警察评选>>反诈骗信息</p>
            </div>
        </div>
    </div>
    <!-------------------------------------- 尾部结束 -------------------------------------->
</body>
</html>