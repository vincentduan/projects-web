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
<!DOCTYPE html>
<html>
<head>
<title>待付定金</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="<%=basePath %>resources/js/jquery.min.js"></script>
<script>
	$(function() {
		$(".r_div i").click(function() {
			$(".wansinfo").hide();
		})
		$(".top img").click(function() {
			$(".wsxx").hide();
		})
		$(".selectProvider_page2 .top img").click(function(){
           $(".selectProvider").hide();
        })
	    $(".addgoods_r_div i").click(function() {
		   $(".addgoods").hide();
	    })
	})
    function updateUInfo(){
    	var form = document.getElementById("form_3");
    	form.submit();
    }
    function updateDInfo(){
    	var form = document.getElementById("form_2");
    	form.submit();
    }
	function acceptOrder(){
		location.href="/core-admin/chooseSp/acceptOrder?orderNo="+${baseOrder.orderNo };
	}
	
	 function search_goods(){
	     	var name = $("#goods_name").val();
	     	var categoryId = document.getElementById("_categoryId_1").value;
	     	getUrl = "/core-web-B/contract/findGoods"
	     	args = {"name":name,"categoryId":categoryId}
	     	console.log(args);
	     	$.getJSON(getUrl,args,function(data){
	     	    
	     		table = document.getElementById("_table_2");
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
			        	
					}
	 		})
	     }
		 function saveGoods(){
		    	var form = document.getElementById("_save_1");
		    	form.submit();
		 }
		 
</script>
</head>
<body>
	<!--header-->
	<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>
	<!--header end-->
    <!--content-->
    <div class="cont">
      <div class="w">
        <div class="wrap">
          <div class="zhengwen">
            <div class="leirong">
              <p class="leirong_1">待付款订单</p>
              <p class="leirong_2"><span>订单号：${baseOrder.orderNo }</span><span>状态：<font>签单付订金</font></span><a href="#" class="txt666Color">取消订单</a></p>

              <div class="zhuangtai">
                <div class="div_item">
                  <div class="item on item_first">
                    <div class="list">
                      <i></i>
                      <p>发布需求</p>
                      <span>${baseOrder.createTime }</span>
                      <div class="tanchuan">
                        <div class="tanchuan_img">
                          <img src="<%=basePath%>resources/images/yaoyingchao_1.png" />
                          <div class="sanjia">
                            <img src="<%=basePath%>resources/images/xiangxia.png" />
                          </div>
                        </div>
                        <div class="tanchuan_text">
                          <p>10分钟金牌管家联系您，</p>
                          <p>根据您的需求匹配高资质服务商</p>
                        </div>
                      </div>
                    </div>
                  </div>

                  <div class="item on">
                    <div class="list">
                      <i></i>
                      <p>管家受理</p>
                      <span>2016-01-10 17:02:42</span>
                      <div class="tanchuan">
                        <div class="tanchuan_img">
                          <img src="<%=basePath%>resources/images/yaoyingchao_1.png" />
                          <div class="sanjia">
                            <img src="<%=basePath%>resources/images/xiangxia.png" />
                          </div>
                        </div>
                        <div class="tanchuan_text">
                          <p>10分钟金牌管家联系您，</p>
                          <p>根据您的需求匹配高资质服务商</p>
                        </div>
                      </div>

                    </div>
                  </div>
                  <div class="item on">
                    <div class="list">
                      <i></i>
                      <p class="p1">选择服务商<span class="span1">(设计、打样、报价)</span></p>
                      <span>2016-01-10 17:02:42</span>

                      <div class="tanchuan">
                        <div class="tanchuan_img">
                          <img src="<%=basePath%>resources/images/yaoyingchao_1.png" />
                          <div class="sanjia">
                            <img src="<%=basePath%>resources/images/xiangxia.png" />
                          </div>
                        </div>
                        <div class="tanchuan_text">
                          <p>您选择<a style="color:#f04444">依文服饰股份有限公司</a><br />为您定制服务：线下沟通</p>
                        </div>
                      </div>

                    </div>
                  </div>
                  <div class="item in on">
                    <div class="list">
                      <i></i>
                      <p>签单付定金</p>
						<span></span>
                      <div class="tanchuan">
                        <div class="tanchuan_img">
                          <img src="<%=basePath%>resources/images/yaoyingchao_1.png" />
                          <div class="sanjia">
                            <img src="<%=basePath%>resources/images/xiangxia.png" />
                          </div>
                        </div>
                        <div class="tanchuan_text">
                          <p>订单总金额：<a style="color:#f04444">10,000</a>元</p>
                          <p>待支付定金：<a style="color:#f04444">10,000</a>元</p>
                        </div>
                      </div>

                    </div>
                  </div>
                  <div class="item">
                    <div class="list">
                      <i></i>
                      <p>上门量体</p>
						<span></span>
                      <div class="tanchuan">
                        <div class="tanchuan_img">
                          <img src="<%=basePath%>resources/images/yaoyingchao_1.png" />
                          <div class="sanjia">
                            <img src="<%=basePath%>resources/images/xiangxia.png" />
                          </div>
                        </div>
                        <div class="tanchuan_text">
                          <p>10分钟金牌管家联系您，</p>
                          <p>根据您的需求匹配高资质服务商</p>
                        </div>
                      </div>

                    </div>
                  </div>
                  <div class="item">
                    <div class="list">
                      <i></i>
                      <p>生产制作</p>
						<span></span>
                      <div class="tanchuan">
                        <div class="tanchuan_img">
                          <img src="<%=basePath%>resources/images/yaoyingchao_1.png" />
                          <div class="sanjia">
                            <img src="<%=basePath%>resources/images/xiangxia.png" />
                          </div>
                        </div>
                        <div class="tanchuan_text">
                          <p>10分钟金牌管家联系您，</p>
                          <p>根据您的需求匹配高资质服务商</p>
                        </div>
                      </div>

                    </div>
                  </div>
                  <div class="item">
                    <div class="list">
                      <i></i>
                      <p>支付尾款</p>

                      <div class="tanchuan">
                        <div class="tanchuan_img">
                          <img src="<%=basePath%>resources/images/yaoyingchao_1.png" />
                          <div class="sanjia">
                            <img src="<%=basePath%>resources/images/xiangxia.png" />
                          </div>
                        </div>
                        <div class="tanchuan_text">
                          <p>10分钟金牌管家联系您，</p>
                          <p>根据您的需求匹配高资质服务商</p>
                        </div>
                      </div>

                    </div>
                  </div>
                  <div class="item">
                    <div class="list">
                      <i></i>
                      <p>待发货</p>

                      <div class="tanchuan tanchuan_1">
                        <div class="tanchuan_img">
                          <img src="<%=basePath%>resources/images/yaoyingchao_1.png" />
                          <div class="sanjia sanjia_1">
                            <img src="<%=basePath%>resources/images/xiangxia.png">
                          </div>
                        </div>
                        <div class="tanchuan_text">
                          <p>10分钟金牌管家联系您，</p>
                          <p>根据您的需求匹配高资质服务商</p>
                        </div>
                      </div>

                    </div>
                  </div>
                  <div class="item">
                    <div class="list">
                      <i></i>
                      <p>待签收</p>

                      <div class="tanchuan tanchuan_1">
                        <div class="tanchuan_img">
                          <img src="<%=basePath%>resources/images/yaoyingchao_1.png" />
                          <div class="sanjia sanjia_1">
                            <img src="<%=basePath%>resources/images/xiangxia.png" />
                          </div>
                        </div>
                        <div class="tanchuan_text">
                          <p>10分钟金牌管家联系您，</p>
                          <p>根据您的需求匹配高资质服务商</p>
                        </div>
                      </div>

                    </div>
                  </div>
                  <div class="item item_last">
                    <div class="list">
                      <i></i>
                      <p>交易完成</p>

                      <div class="tanchuan tanchuan_1">
                        <div class="tanchuan_img">
                          <img src="<%=basePath%>resources/images/yaoyingchao_1.png" />
                          <div class="sanjia sanjia_1">
                            <img src="<%=basePath%>resources/images/xiangxia.png" />
                          </div>
                        </div>
                        <div class="tanchuan_text">
                          <p>10分钟金牌管家联系您，</p>
                          <p>根据您的需求匹配高资质服务商</p>
                        </div>
                      </div>

                    </div>
                  </div>
                  <div class="clear"></div>
                </div>
              </div> 
              <c:if test="${baseOrder.status >=130 }">
                <jsp:include page="./info2.jsp"></jsp:include>
              </c:if> 
              <c:if test="${baseOrder.status < 130 }">
                <jsp:include page="./info.jsp"></jsp:include>
              </c:if>          
              
            </div>
          </div>
        </div>
      </div>
    </div>
  
    <!--content end-->

	<!--footer-->
	<%@ include file="/WEB-INF/view/common/footer.jsp"%>
	<!--footer end-->


  <div class="wsxx">
    	<div class="wsxx_page1">
    		<div class="wsxx_page2">
    			<div class="top">
    				<h3>完善定制需求<img src="<%=basePath%>resources/img/cha.png"></h3>
    				<div class="clear"></div>
    			</div>
    			<div class="title">
    				<h3>客户定制需求</h3>
    			</div>
    			<form id="form_2" action="/core-web-C/payOrder/editGoodsInfo">
    			<div class="txt">
    			    <input type="hidden" name="id" value="${OrderCustomDemandVo.orderCustomDemand.id }">
    			    <input type="hidden" name="orderNo" value="${baseOrder.orderNo }">
    				<p><span>定制方式：</span><label><span>量体定制</span></label></p>
    				<p><span>定制数量：</span><label><input type="text" name="customNum"><span>件</span></label></p>
    				<p><span>定制预算：</span><label><input type="text" name="customBudget"><span>元</span></label></p>
    				<p><span>定制周期：</span><label><input type="text" name="customCycle"><span>个工作日<em>（量体结束后15个工作日完成生产制作）</em></span></label></p>
    				<p><span>定制品类：</span><label><select name="categoryId"><option value="3">西服正装</option></select></label></p>
    				<p class="text"><span>定制属性：</span><label><textarea name="categoryProperty" id="textarea" onKeyDown="textdown(event)"
    onKeyUp="textup()" onfocus="if(value=='如面料属性、颜色、版号等'){value=''}"
    onblur="if (value ==''){value='如面料属性、颜色、版号等'}">如面料属性、颜色、版号等</textarea></label></p>
    				<p class="last"><span>定制品类：</span>
                
                    <label class="sem " onclick="$('.wsxx').hide();$('.addgoods').show();"><a href="#" ><strong>+</strong>添加商品</a></label>
						
    				<!-- <a onclick="$('.fixed').show(); $('.fix_alt_add').show(); $('.wsxx').hide();"></a> -->
    				<c:forEach items="${OrderCustomDemandVo.orderCustomGoods }" var="items">
    				     <label><img src="<%=basePath%>resources/img/list1.png"><span>${items.goodsName }  ${items.attributeValueNames }</span></label>
					</c:forEach>
                 
    			<div class="but_go">
    				<p><a href="javascript:void(0);" onclick="updateDInfo();"><span>保　存</span></a></p>
    			</div>
    			</div>
    			</form>
    			
    		</div>
    	</div>
    </div>
    <div class="wansinfo">
		<div class="windows">
			<div class="w_title">
				<p>完善客户信息</p>
				<div class="r_div">
					<i></i>
				</div>
			</div>
			<div class="tianxie">
				<div class="detailed">
					<p><img src="<%=basePath%>resources/img/icon25.png">客户信息</p>
					<div class="tianxie_1">
					<form id="form_3" action="/core-web-C/payOrder/editUInfo">
					    <input type="hidden" name="orderNo" value="${baseOrder.orderNo }">
						<div class="deta">
							<div class="detailed_1">
								<p><span>姓名：</span><input type="text" name="bespeakName" value="${OrderCustomerInfoVo.orderCustomerInfo.bespeakName }"/><label>请输入联系人姓名</label></p>
								<p><span>手机号：</span><input type="text" name="bespeakPhone" value="${OrderCustomerInfoVo.orderCustomerInfo.bespeakPhone }" placeholder="${OrderCustomerInfoVo.orderCustomerInfo.bespeakPhone }"/><label>请输入联系人手机号</label></p>
							</div>
							<div class="detailed_2">
								<p><span>企业名称：</span><input type="text" name="companyName" value="${OrderCustomerInfoVo.orderCustomerInfo.companyName }" placeholder="请输入企业名称"/></p>
								<p><span>定制部门：</span><input type="text" name="customDepartment" value="${OrderCustomerInfoVo.orderCustomerInfo.customDepartment }" placeholder="请输入定制部门"/></p>
								<p><span>所在地区：</span><select><option value="1">省/市</option></select><select class="select_2"><option value="1">市/地区</option></select><select><option value="1">县/市</option></select></p>
								<p><span> </span><input type="text" name="reciveAddress" value="${OrderCustomerInfoVo.reciveAddress.addressDetail }" placeholder="请输入量体详细地址"/></p>
								<p><span>量体地址：</span><input type="text" name="measureAddress" placeholder="请输入量体详细地址"/></p>
								<p><a href="#">+ 增加地址</a></p>
							</div>
							<div class="but_go">
								<p><a href="javascript:void(0);" onclick="updateUInfo();"><span>保　存</span></a></p>
							</div>
						</div>
					</form>
					</div>
				</div>
			</div>
		</div>
	</div>

<!-- 添加商品弹出层 -->
	<div class="addgoods">
		<div class="addgoods_windows">
			<div class="addgoods_w_title">
				<p>添加商品</p>
				<div class="addgoods_r_div">
					<i></i>
				</div>
			</div>
			<div class="addgoods_tianxie">
				<div class="addgoods_detailed">
					<div class="addgoods_tianxie_1">
						<div class="addgoods_deta">
							<div class="addgoods_detailed_1">
								<form id="_search" action="">
									<div class="cont_tit">
										<span>商品名称：</span> 
										<label><input type="text" placeholder="请输入商品名称" name="name" id="goods_name" /></label> <span>商品分类：</span>
										<label><select name="categoryId" id="_categoryId_1">
												<option value="" selected="true">请选择</option>
												<c:forEach items="${categorys }" var="item">
													<option value="${item.id }">${item.name }</option>
												</c:forEach>
										</select></label> 
										<span><input type="button" onclick="search_goods();" value="搜 索"></span>
									</div>
								</form>
							</div>
							<div class="addgoods_detailed_2">
								<form action="/core-admin/orderAccept/saveCustomGoods" id="_save_1">
								
									<input type="hidden" value="${orderNo }" name="orderNo"/>
									<table id="_table_2">
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
											<a href="#"	class="on">2</a> 
											<a href="#">3</a> 
											<a href="#">4</a> 
											<a href="#">5</a> 
											<a href="#">6</a> 
											<a href="#">...</a> 
											<span>
											<a href="#">下一页</a></span> <span><a href="#">末页</a></span> 
											<span>显示<label>1</label>到<label>8</label>条，共<label>78</label>条记录
											</span>
										</p>
									</div>
								</form>
							</div>
							<div class="but_go">
								<p>
									<a onclick="saveGoods();"><span>保&nbsp;存</span></a>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--添加商品弹出层end-->

<script>
  $(function () {
    $(".r_div i").click(function(){
      $(".wansinfo").hide();
    })
    $(".top img").click(function(){
      $(".wsxx").hide();
    })

  })
</script>
</body>
</html>