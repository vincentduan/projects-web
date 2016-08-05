<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>

<title>指派服务商</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script type="text/javascript" src="<%=basePath%>resources/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>resources/js/jquery-form.js"></script>


<script>
$(function() {
	$(".r_div i").click(function() {
		$(".wansinfo").hide();
	})
	$(".wsxx_page2 .top img").click(function() {
		$(".wsxx").hide();
	})
    $(".selectProvider_page2 .top img").click(function(){
        $(".selectProvider").hide();
      })
	$(".addgoods_r_div i").click(function() {
		$(".addgoods").hide();
	})
})
</script>
<script>
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
	function search(){
		
		var spName = $("#_spName").val();
		var categoryId = $("#_categoryId").val();
		
    	getUrl = "/core-admin/chooseSp/assignService"
    	args = {"spName":spName,"categoryId":categoryId}
    	$.getJSON(getUrl,args,function(data) {
	    	//data格式按照example:var json1={"abc":[{"id":"txt1"},{"name","txt2"}]};
  		  var count = 0;
  		  var html = ""
  		  var dataLength = data.result.length;
  		  //alert(dataLength);
  		  var currentNum=0;
  		  table = document.getElementById("_table");
  		  rowNum =  table.rows.length;
  	       while(rowNum > 0)
  	       {
  	    	table.deleteRow(0);
  	        rowNum -= 1;
  	        }
  		  for(var index in data.result){
  		    if(count%3==1) {
  		    	}
  		    thead = table.insertRow();
  		    thead.insertCell().innerHTML = "<label><input id='"+data.result[index].id+"' name='spName' value='"+data.result[index].id+"' type='checkbox'></input><span>"+data.result[index].name+"</span></label>";
  		    count++;
  			currentNum++;
  		    /* if(count==3||currentNum==dataLength){
  		      count = 0;
  		      html += '</tr>';
  		    } */
  		  }  
  		  /* if(count>0) html+='</tr>';
  		  $('#_selectProTable table').append(html); */
  		
  })
	}
	function chooseSp(){
		var form = document.getElementById("_form3");
		form.submit();
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
		        	/* $('#fix_cont table').append(" <tr><td><input type='checkbox' value='data[i].goodsSku.id' /></td><td>"+data[i].goods.id+"</td><td><img src='' />"+data[i].goods.name+"</td>"+
		        			" <td>"+data[i].category.name+"</td><td>"+data[i].goodsSku.attributeValueNames+"</td></tr>"); */
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
<p class="leirong_2">
              <span>订单号：${baseOrder.orderNo }</span>
              <span>状态：指派供应商</span>
              <span class="toServerPerson">
              <a href="#" class="txt666Color">取消订单</a>
              <a href="#" class="txtf04444Color" onclick="$('.selectProvider').show();">指派服务商</a>
              </span>
              </p>              <div class="zhuangtai">
                <div class="div_item">
                  <div class="item on item_first">
                    <div class="list">
                      <i></i>
                      <p>发布需求</p>
                      <span>${baseOrder.createTime }</span>
                      <div class="tanchuan">
                        <div class="tanchuan_img">
                          <img src="<%=basePath%>resources/images/yaoyingchao.png" />
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

                             <c:forEach items="${orderStream }" var="item">
							  <c:if test="${item.status < baseOrder.status}">
							  <div class="item on"><div class="list"><i></i><p>${orderStatusMap[item.status] }</p><span>${item.createTime }</span></div></div>
							  </c:if>
							  </c:forEach>
							  <!-- <div class="item on"><div class="list"><i></i><p>管家受理</p></div></div> -->
							  <div class="item on"><div class="list"><i></i><p>选择服务商</p><span class="span1">(设计、打样、报价)</span></div></div>
							  <div class="item"><div class="list"><i></i><p>签单订金</p></div></div>
							  <div class="item"><div class="list"><i></i><p>上门量体</p></div></div>
							  <div class="item"><div class="list"><i></i><p>生产制作</p></div></div>
							  <div class="item"><div class="list"><i></i><p>支付尾款</p></div></div>
							  <div class="item"><div class="list"><i></i><p>待发货</p></div></div>
							  <div class="item"><div class="list"><i></i><p>待签收</p></div></div>
							  <div class="item item_last"><div class="list"><i></i><p>交易完成</p></div></div>
                  
                  <div class="clear"></div>
                </div>
              </div>

             <div class="leirong_2">
							<p><span>定制信息</span></p>
						</div>
						
						<div class="kehuinfo">
							<p><span><img src="<%=basePath%>resources/img/tou_1.png">客户信息</span><label class="sem " onclick="$('.wansinfo').show();"><a href="#"><img src="<%=basePath%>resources/img/iconfont_1.png" />完善信息</a></label></p>
						</div>
						<div class="bor_info">
							<div class="xiqinfo">
								<p><span>姓名</span>：<a>${OrderCustomerInfoVo.orderCustomerInfo.bespeakName }</a></p>
								<p><span>手机号</span>：<a>${OrderCustomerInfoVo.orderCustomerInfo.bespeakPhone }</a></p>
							</div>
							<div class="xiqinfo">
								<p><span>企业名称</span>：
								<label>
								<c:if test="${empty OrderCustomerInfoVo.orderCustomerInfo.companyName}">未填写</c:if>
								<c:if test="${!empty OrderCustomerInfoVo.orderCustomerInfo.companyName}">${OrderCustomerInfoVo.orderCustomerInfo.companyName }</c:if>
								</label></p>
								<p><span>企业地址</span>：
								<label>
								<c:if test="${empty OrderCustomerInfoVo.reciveAddress }">未填写</c:if>
								<c:if test="${!empty OrderCustomerInfoVo.reciveAddress }">${OrderCustomerInfoVo.reciveAddress.addressDetail }</c:if>
								</label></p>
							</div>
							<div class="xiqinfo xiqinfo_1">
								<p><span>定制部门</span>：
								<label>
                                <c:if test="${empty OrderCustomerInfoVo.orderCustomerInfo.customDepartment }">未填写</c:if>
								<c:if test="${!empty OrderCustomerInfoVo.orderCustomerInfo.customDepartment }">${OrderCustomerInfoVo.orderCustomerInfo.customDepartment }</c:if>
								</label></p>
								<p><span>量体地址</span>：
								<label>
								<c:if test="${empty OrderCustomerInfoVo.list }">未填写</c:if>
								<c:if test="${!empty OrderCustomerInfoVo.list }">
								<c:forEach items="${OrderCustomerInfoVo.list }" var="list">
								 ${list.addressDetail }
								</c:forEach>
                                </c:if>
								</label></p>
							</div>
						</div>
						
						<div class="kehuinfo">
							<p><span><img src="<%=basePath%>resources/img/ye_1.png">客户定制需求</span><label class="sem " onclick="$('.wsxx').show();"><a href="#"><img src="<%=basePath%>resources/img/iconfont_1.png" />完善定制需求</a></label></p>
						</div>
						<div class="dingzfs">
							<p><span>定制方式</span>：<label class="col">量体定制</label></p>
							<p><span>定制数量</span>：<label>${OrderCustomDemandVo.orderCustomDemand.customNum=='0'?'未填写':OrderCustomDemandVo.orderCustomDemand.customNum }</label></p>
							<p><span>定制预算</span>：<label>${empty OrderCustomDemandVo.orderCustomDemand.customBudget?'未填写':OrderCustomDemandVo.orderCustomDemand.customBudget }</label></p>
							<p><span>定制周期</span>：<label>${empty OrderCustomDemandVo.orderCustomDemand.customCycle?'未填写':OrderCustomDemandVo.orderCustomDemand.customCycle }</label></p>
							<p><span>定制品类</span>：<label>${empty OrderCustomDemandVo.orderCustomDemand.categoryName?'未填写':OrderCustomDemandVo.orderCustomDemand.categoryName }</label></p>
							<p><span>定制属性</span>：<label>${empty OrderCustomDemandVo.orderCustomDemand.categoryProperty?'未填写':OrderCustomDemandVo.orderCustomDemand.categoryProperty }</label></p>
							<p><span>商品名称</span>：<br>
							<c:forEach items="${OrderCustomDemandVo.orderCustomGoods }" var="items">
							${items.goodsName }  ${items.attributeValueNames } <a href="">查看详情>></a><br>
							</c:forEach>
							<label>
							
                            </label></p>
						</div>

              <div class="kehuinfo">
                <p><span><img src="<%=basePath%>resources/images/ye_2.png">服务商信息</span></p>
              </div>
              <div class="pipeifws">
                <div class="pipeifws_1">
                  <p>正在为您匹配服务商，已匹配到3个服务商</p>
                </div>
                <div class="sanxiang">
                  <div class="kuand">
                    <div class="sanfzy">
                      <div class="logo_j">
                        <img src="<%=basePath%>resources/images/logo4.png" />
                      </div>
                      <div class="jtext_1">
                        <p class="jt_1">海瑞服饰股份有限公司</p>
                        <p><img src="<%=basePath%>resources/images/telp.png" />13822222222</p>
                      </div>
                      <div class="logo_in">
                        <p><img src="<%=basePath%>resources/images/ye_3.png" /><span>平台级定制保障</span></p>
                      </div>
                      <div class="tiaoz">
                        <p><a href="#"><u>查看服务商店铺</u></a></p>
                      </div>

                      <div class="clear"></div>

                      <div class="jindut">
                        <div class="item jindut_1 on">
                          <p><span>1</span><label>报名参与</label></p>
                          <div class="item_info"><span>2016-01-11 16:19:26</span><label>已报名参与竞标</label></div>
                        </div>
                        <div class="item jindut_2">
                          <p><span>2</span><label>60分钟联系</label></p>
                          <div class="item_info"> </div>
                        </div>
                        <div class="item jindut_3">
                          <p><span>3</span><label>中标</label></p>
                         <!--  <div class="div_btn2">
                            <a href="#" class="on">选择，签单</a>
                            <a href="#">换一个</a>
                          </div> -->
                        </div>
                        <div class="clear"></div>
                      </div>

                      <div class="clear"></div>
                    </div>
                    <div class="sanfzy">
                      <div class="logo_j">
                        <img src="<%=basePath%>resources/images/logo4.png" />
                      </div>
                      <div class="jtext_1">
                        <p class="jt_1">海瑞服饰股份有限公司</p>
                        <p><img src="<%=basePath%>resources/images/telp.png" />13822222222</p>
                      </div>
                      <div class="logo_in">
                        <p><img src="<%=basePath%>resources/images/ye_3.png" /><span>平台级定制保障</span></p>
                      </div>
                      <div class="tiaoz">
                        <p><a href="#"><u>查看服务商店铺</u></a></p>
                      </div>

                      <div class="clear"></div>

                      <div class="jindut">
                        <div class="item jindut_1 on">
                          <p><span>1</span><label>报名参与</label></p>
                          <div class="item_info"><span>2016-01-11 16:19:26</span><label>已报名参与竞标</label></div>
                        </div>
                        <div class="item jindut_2 on">
                          <p><span>2</span><label>60分钟联系</label></p>
                          <div class="item_info"><span>2016-01-11 16:19:26</span><label>已与您联系</label><a href="#">服务商没有联系我</a></div>
                        </div>
                        <div class="item jindut_3">
                          <p><span>3</span><label>中标</label></p>
                          <!-- <div class="div_btn2">
                            <a href="#" class="on">选择，签单</a>
                            <a href="#">换一个</a>
                          </div> -->
                        </div>
                        <div class="clear"></div>
                      </div>

                      <div class="clear"></div>
                    </div>
                    <div class="sanfzy">
                      <div class="out"><img src="<%=basePath%>resources/images/out.png" /></div>
                      <div class="logo_j">
                        <img src="<%=basePath%>resources/images/logo4.png" />
                      </div>
                      <div class="jtext_1">
                        <p class="jt_1">海瑞服饰股份有限公司</p>
                        <p><img src="<%=basePath%>resources/images/telp.png" />13822222222</p>
                      </div>
                      <div class="logo_in">
                        <p><img src="<%=basePath%>resources/images/ye_3.png" /><span>平台级定制保障</span></p>
                      </div>
                      <div class="tiaoz">
                        <p><a href="#"><u>查看服务商店铺</u></a></p>
                      </div>
                      <div class="clear"></div>

                      <div class="jindut">
                        <div class="item jindut_1 on">
                          <p><span>1</span><label>报名参与</label></p>
                          <div class="item_info"><span>2016-01-11 16:19:26</span><label>已报名参与竞标</label></div>
                        </div>
                        <div class="item jindut_2 on">
                          <p><span>2</span><label>60分钟联系</label></p>
                          <div class="item_info"><span>2016-01-11 16:19:26</span><label>服务商60分钟未联系您</label><span>交易顾问已帮您把他淘汰，并推荐了新的服务商参与您的需求</span></div>
                        </div>
                        <div class="item jindut_3">
                          <p><span>3</span><label>中标</label></p>
                          <!-- <div class="div_btn2">
                            <a href="#" class="on">选择，签单</a>
                            <a href="#">换一个</a>
                          </div> -->
                        </div>
                        <div class="clear"></div>
                      </div>

                      <div class="clear"></div>
                    </div>
                  </div>
                </div>
              </div>
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
    				<h3>完善定制需求<img src="<%=basePath%>resources/images/cha.png"></h3>
    				<div class="clear"></div>
    			</div>
    			<div class="title">
    				<h3>客户定制需求</h3>
    			</div>
    			<form id="form_2" action="/core-admin/orderAccept/editGoodsInfo">
    			<div class="txt">
    			    <input type="hidden" name="id" value="${OrderCustomDemandVo.orderCustomDemand.id }">
    			    <input type="hidden" name="orderNo" value="${baseOrder.orderNo }">
    				<p><span>定制方式：</span><label><span>量体定制</span></label></p>
    				<p><span>定制数量：</span><label><input type="text" name="customNum"><span>件</span></label></p>
    				<p><span>定制预算：</span><label><input type="text" name="customBudget"><span>元</span></label></p>
    				<p><span>定制周期：</span><label><input type="text" name="customCycle"><span>个工作日<em>（量体结束后15个工作日完成生产制作）</em></span></label></p>
    				<p><span>定制品类：</span><label><select name="categoryId">
    				<c:forEach items="${categorys }" var="list">
    				  <option value="${list.id }">${list.name }</option>
    				</c:forEach>
    				</select></label></p>
    				<p class="text"><span>备注：</span><label><textarea name="categoryProperty" id="textarea" onKeyDown="textdown(event)"
    onKeyUp="textup()" onfocus="if(value=='如面料属性、颜色、版号等'){value=''}"
    onblur="if (value ==''){value='空'}">如面料属性、颜色、版号等</textarea></label></p>
    				<p class="last"><span>定制品类：</span>
    				<label class="sem " onclick="$('.wsxx').hide();$('.addgoods').show();"><a href="#" ><strong>+</strong>添加商品</a></label>
						
    				<!-- <a onclick="$('.fixed').show(); $('.fix_alt_add').show(); $('.wsxx').hide();"></a> -->
    				<c:forEach items="${OrderCustomDemandVo.orderCustomGoods }" var="items">
    				     <label><img src="<%=basePath%>resources/img/list1.png"><span>${items.goodsName }  ${items.attributeValueNames }</span></label>
					</c:forEach>
    				<label><img src="<%=basePath%>resources/img/list1.png"><span>男士双排扣西服 XX面料 蓝色</span><a>删除</a></label></p>
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
          <p><img src="<%=basePath%>resources/images/icon25.png">客户信息</p>
          <div class="tianxie_1">
            <div class="deta">
              <div class="detailed_1">
                <p><span>姓名：</span><input type="text" placeholder="张三"/><label>请输入联系人姓名</label></p>
                <p><span>手机号：</span><input type="text" placeholder="18612345678"/><label>请输入联系人手机号</label></p>
              </div>
              <div class="detailed_2">
                <p><span>企业名称：</span><input type="text" placeholder="请输入企业名称"/></p>
                <p><span>定制部门：</span><input type="text" placeholder="请输入定制部门"/></p>
                <p><span>所在地区：</span><select><option value="1">省/市</option></select><select class="select_2"><option value="1">市/地区</option></select><select><option value="1">县/市</option></select></p>
                <p><span> </span><input type="text" placeholder="请输入量体详细地址"/></p>
                <p><span>量体地址：</span><input type="text" placeholder="请输入量体详细地址"/></p>
                <p><a href="#">+ 增加地址</a></p>
              </div>
              <div class="but_go">
                <p><a href="javascript:void(0);" onclick="updateUInfo();"><span>保　存</span></a></p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
<div class="selectProvider">
  <div class="selectProvider_page1">
    <div class="selectProvider_page2">
      <div class="top">
        <h3>指派服务商<img src="<%=basePath%>resources/images/cha.png"></h3>
        <div class="clear"></div>
      </div>
      <form id="_search" action="/core-admin/chooseSp/assignService">
      <div class="title">
        <ul>
          <li>&nbsp;&nbsp;&nbsp;<strong>服务商：</strong>&nbsp;
            <input type="text" class="text-input" value="" id="_spName" name="spName" placeholder="请输入服务商名称">
          </li>
          <li><strong>服务品类： </strong>
            <select class="" style="width:120px;" id="_categoryId" name="categoryId">
              <option value="-1" selected="true">请选择</option>
              <c:forEach items="${categorys }" var="item">
              <option value="${item.id }">${item.name }</option>
              </c:forEach>
            </select>
          </li>
          <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="button" value="搜索" tabindex="12" class="export" onclick="search();"/>
          </li>
        </ul>
      </div>
      </form>
      <form id="_form3" action="/core-admin/chooseSp/assignSp">
      <input type="hidden" value="${baseOrder.orderNo }" name="orderNo"/>
      <div class="txt">
          <div class="selectProTable" id="_selectProTable">
            <table id="_table">
            </table>
            <label><input type="checkbox" onclick="changeClick(this.checked,'spName')" ></input>
              <span>全选</span></label>
              <!--分页-->
              <div class="page"> <span class="page_text"> 88 条记录</span><a class="pageup pageup-dis" href="javascript:void(0)" title="上一页"><em></em>上一页</a> <a class="current" href="javascript:void(0)">1</a><a href="/page2">2</a><a href="/page3">3</a><a href="/page4">4</a><a href="/page5">5</a> <span>...</span> <a href="/page207">207</a> <a class="pagedown" href="/page2" title="下一页">下一页<em></em></a> </div>
              <!--分页 end-->
          </div>
          <div class="ak">
            <a href="#" class="txtf04444Color" onclick="chooseSp();">发&nbsp;送</a>
            <a href="#" class="txt666Color">取&nbsp;消</a>
          </div>
        </div>
      </form>

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

<script type="text/javascript">
  /*
 * 全选/全不选属性
 */
function changeClick(flag, name){
  checkboxs = document.getElementsByName(name);
  for (var i = 0; i < checkboxs.length; i++) {
    if (checkboxs[i].checked != flag) {
      $(checkboxs[i]).click();
    }
  }
}
</script>
</body>
</html>