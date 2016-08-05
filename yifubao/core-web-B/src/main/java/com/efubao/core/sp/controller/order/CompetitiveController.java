package com.efubao.core.sp.controller.order;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpRequest;
import org.apache.tools.ant.taskdefs.condition.Http;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.efubao.core.admin.domain.Category;
import com.efubao.core.admin.service.CategoryService;
import com.efubao.core.admin.service.GoodsSKUService;

import com.efubao.core.order.domain.BaseOrder;
import com.efubao.core.order.domain.OrderCustomDemand;
import com.efubao.core.order.domain.OrderCustomGoods;
import com.efubao.core.order.domain.OrderCustomerInfo;
import com.efubao.core.order.domain.OrderMeasureAddress;
import com.efubao.core.order.domain.OrderStatusStream;
import com.efubao.core.order.domain.ReceiveAddress;
import com.efubao.core.order.service.BaseOrderService;
import com.efubao.core.order.service.GenerateSerialNumberService;
import com.efubao.core.order.service.OrderCustomDemandService;
import com.efubao.core.order.service.OrderCustomGoodsService;
import com.efubao.core.order.service.OrderCustomerInfoService;
import com.efubao.core.order.service.OrderMeasureAddressService;
import com.efubao.core.order.service.OrderServiceProviderService;
import com.efubao.core.order.service.OrderStatusStreamService;
import com.efubao.core.order.service.ReceiveAddressService;
import com.efubao.core.sp.controller.common.CommonVar;
import com.efubao.core.sp.domain.ServiceProvider;
import com.efubao.core.sp.service.ServiceProviderService;
import com.efubao.core.sp.vo.OrderCustomDemandVo;
import com.efubao.core.sp.vo.OrderCustomerInfoVo;

@Controller
@RequestMapping("/competitive")
public class CompetitiveController {
	@Autowired
	public BaseOrderService baseOrderService;
	@Autowired
	public OrderCustomerInfoService orderCustomerInfoService;
	@Autowired
	public CategoryService categoryService;
	@Autowired
	public OrderCustomDemandService orderCustomDemandService;
	@Autowired
	public OrderStatusStreamService orderStatusStreamService;
	@Autowired
	public OrderMeasureAddressService orderMeasureAddressService;
	@Autowired
	public ReceiveAddressService receiveAddressService;
	@Autowired
	public OrderCustomGoodsService orderCustomGoodsService;
	@Autowired
	public OrderServiceProviderService orderServiceProviderService;
	@Autowired
	public ServiceProviderService serviceProviderService;
	@Autowired
	public GoodsSKUService goodsSKUService;
	@Autowired
	private GenerateSerialNumberService generateSerialNumberService;
	
	@RequestMapping("/compOrder")
	public String compOrder(HttpServletRequest request,HttpServletResponse response){
	 Integer count = 0;
     String orderNo = request.getParameter("orderNo");
     BaseOrder baseOrder = baseOrderService.findByOrderNo(orderNo);
     request.setAttribute("baseOrder", baseOrder);
     
     Category categoryTmp = new Category();
		categoryTmp.setIsDel(false);
		categoryTmp.setStatus(1);
		List<Category> categorys = categoryService.queryByCondition(categoryTmp);
 	request.setAttribute("categorys", categorys);
     
//     OrderCustomerInfoVo orderCustomerInfoVo = commonOrderInfoImpl.getOrderCInfoVo(orderNo);
     
     //获取订单商户信息        
     OrderCustomerInfo orderCustomerInfo = new OrderCustomerInfo();
     OrderMeasureAddress orderMeasureAddress = new OrderMeasureAddress();
     ReceiveAddress reciveAddress = new ReceiveAddress();
     OrderCustomerInfoVo orderCustomerInfoVo = new OrderCustomerInfoVo();
     orderCustomerInfo.setOrderNo(orderNo);
     List<OrderCustomerInfo> list = orderCustomerInfoService.queryByCondition(orderCustomerInfo);
     if(list.size()>0){
     	 orderCustomerInfoVo.setOrderCustomerInfo(list.get(0));
    }
     orderMeasureAddress.setOrderNo(orderNo);
     List<OrderMeasureAddress> li = orderMeasureAddressService.queryByCondition(orderMeasureAddress);
     orderCustomerInfoVo.setList(li);
     
     reciveAddress.setOrderNo(orderNo);
     List<ReceiveAddress> listra = receiveAddressService.queryByCondition(reciveAddress);
     if(listra.size()>0){
     	 orderCustomerInfoVo.setReceiveAddress(listra.get(0));
     }
     request.setAttribute("OrderCustomerInfoVo", orderCustomerInfoVo);
     
     
     
//     //获取订单客户定制需求
     OrderCustomDemandVo orderCustomDemandVo = new OrderCustomDemandVo();
     OrderCustomDemand orderCustomDemand = new OrderCustomDemand();
     OrderCustomGoods orderCustomGoods = new OrderCustomGoods();
     ServiceProvider serviceProvider = new ServiceProvider();
     
     orderCustomDemand.setOrderNo(orderNo);
     List<OrderCustomDemand> lists = orderCustomDemandService.queryByCondition(orderCustomDemand);
     if(lists.size()>0){
     	if(lists.get(0).getId()>0){
     		orderCustomGoods.setOrderCustomDemandId(lists.get(0).getId());
     	}
     	if(StringUtils.isNotBlank(String.valueOf(lists.get(0).getSpId()))){
     		serviceProvider = serviceProviderService.findById(lists.get(0).getSpId());
     		orderCustomDemandVo.setServiceProvider(serviceProvider);
     	}
     }
     List<OrderCustomGoods> l = orderCustomGoodsService.queryByCondition(orderCustomGoods);

     for(OrderCustomGoods ocg : l){
     	count += ocg.getGoodsNum();
     }
     orderCustomDemandVo.setOrderCustomGoods(l);
     orderCustomDemandVo.setOrderCustomDemand(lists.get(0));
     orderCustomDemandVo.setCount(count);
     
//     OrderCustomDemandVo orderCustomDemandVo = commonOrderInfo.getOrderCDemandVo(orderNo);
     OrderStatusStream orderStatusStream = new OrderStatusStream();
     orderStatusStream.setOrderNo(orderNo);
     List<OrderStatusStream> listos = orderStatusStreamService.queryByCondition(orderStatusStream);
     
     request.setAttribute("orderStream", listos);
     request.setAttribute("orderStatusMap", CommonVar.orderStatusMap());
     request.setAttribute("OrderCustomDemandVo", orderCustomDemandVo);

     return "competitive";
	}
}
