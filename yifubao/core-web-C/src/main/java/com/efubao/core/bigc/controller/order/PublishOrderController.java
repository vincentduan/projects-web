package com.efubao.core.bigc.controller.order;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.efubao.core.admin.domain.Category;
import com.efubao.core.admin.domain.GoodsSKU;
import com.efubao.core.admin.service.CategoryService;
import com.efubao.core.admin.service.GoodsSKUService;
import com.efubao.core.bigc.controller.common.CommonVar;
import com.efubao.core.bigc.vo.OrderCustomDemandVo;
import com.efubao.core.bigc.vo.OrderCustomerInfoVo;
import com.efubao.core.order.domain.BaseOrder;
import com.efubao.core.order.domain.OrderCustomDemand;
import com.efubao.core.order.domain.OrderCustomGoods;
import com.efubao.core.order.domain.OrderCustomerInfo;
import com.efubao.core.order.domain.OrderMeasureAddress;
import com.efubao.core.order.domain.OrderStatusStream;
import com.efubao.core.order.domain.ReceiveAddress;
import com.efubao.core.order.service.BaseOrderService;
import com.efubao.core.order.service.GenerateSerialNumberService;
import com.efubao.core.order.service.GenerateSerialNumberService.SerialNumberEnum;
import com.efubao.core.order.service.OrderCustomDemandService;
import com.efubao.core.order.service.OrderCustomGoodsService;
import com.efubao.core.order.service.OrderCustomerInfoService;
import com.efubao.core.order.service.OrderMeasureAddressService;
import com.efubao.core.order.service.OrderServiceProviderService;
import com.efubao.core.order.service.OrderStatusStreamService;
import com.efubao.core.order.service.ReceiveAddressService;
import com.efubao.core.sp.domain.ServiceProvider;
import com.efubao.core.sp.service.ServiceProviderService;

@Controller
@RequestMapping(value = { "/publishOrder" })
public class PublishOrderController {

	private static final Logger logger = LoggerFactory.getLogger(PublishOrderController.class);

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
	public ReceiveAddressService reciveAddressService;
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

	@RequestMapping("/createOrder")
	public String createOrder(HttpServletRequest request, HttpServletResponse response, RedirectAttributes attr, @ModelAttribute OrderCustomGoods orderCustomGoods) throws Exception {

		/**
		 * 首先判断是否已经登录，否则就跳到登录界面（待开发）
		 * 
		 */
		// 获取客户ID
		String customerId = request.getParameter("customerId");
		String spId = request.getParameter("supplierId");
		String categoryId = request.getParameter("categoryId");
		String bespeakName = request.getParameter("bespeakName");
		String goodsSkuId = request.getParameter("goodsSkuId");
		String bespeakPhone = request.getParameter("bespeakPhone");
		String goodsName = request.getParameter("goodsName");
		// 通过方法创建订单号
		String orderNo = generateSerialNumberService.getSerialNumber(SerialNumberEnum.ORDER);

		BaseOrder baseOrder = new BaseOrder();
		baseOrder.setOrderNo(orderNo);
		if(StringUtils.isNotBlank(customerId)){
			baseOrder.setCustomerId(Long.parseLong(customerId));
		}
		baseOrderService.save(baseOrder);

		if (StringUtils.isNotEmpty(bespeakName) && StringUtils.isNotEmpty(bespeakPhone)) {
			OrderCustomerInfo orderCustomerInfo = new OrderCustomerInfo();
			orderCustomerInfo.setBespeakName(bespeakName);
			orderCustomerInfo.setBespeakPhone(bespeakPhone);
			orderCustomerInfo.setOrderNo(orderNo);
			orderCustomerInfoService.save(orderCustomerInfo);
		}
		OrderCustomDemand orderCustomDemand = new OrderCustomDemand();
		orderCustomDemand.setOrderNo(orderNo);

		if (StringUtils.isNotBlank(spId)) {
			orderCustomDemand.setSpId(Long.parseLong(spId));
		}
		if (StringUtils.isNotBlank(categoryId)) {
			orderCustomDemand.setCategoryId(Long.parseLong(categoryId));
			Category category = categoryService.findById(Long.parseLong(categoryId));
			orderCustomDemand.setCategoryName(category.getName());
		}
		orderCustomDemandService.save(orderCustomDemand);

		if (StringUtils.isNotBlank(goodsSkuId)) {
			GoodsSKU goodsSKU = goodsSKUService.findById(Long.parseLong(goodsSkuId));
			orderCustomGoods.setOrderCustomDemandId(orderCustomDemand.getId());
			orderCustomGoods.setGoodsSkuId(Long.parseLong(goodsSkuId));
			orderCustomGoods.setGoodsName(goodsName);
			orderCustomGoods.setAttributeIds(goodsSKU.getAttributeIds());
			orderCustomGoods.setAttributeNames(goodsSKU.getAttributeNames());
			orderCustomGoods.setAttributeValueIds(goodsSKU.getAttributeValueIds());
			orderCustomGoods.setAttributeValueNames(goodsSKU.getAttributeValueNames());
			orderCustomGoodsService.save(orderCustomGoods);
		}
		attr.addAttribute("orderNo", orderNo);

		// OrderStatusStream orderStatusStream = new OrderStatusStream();
		// orderStatusStream.setOrderNo(orderNo);
		// orderStatusStream.setStatus(100);
		// orderStatusStreamService.save(orderStatusStream);

		return "redirect:/publishOrder/showOrderInfo";
	}

	@RequestMapping("/showOrderInfo")
	public String showOrderInfo(HttpServletRequest request, HttpServletResponse response) {
		
//		CommonOrderInfoImpl commonOrderInfoImpl = new CommonOrderInfoImpl();
        Integer count = 0;
        String orderNo = request.getParameter("orderNo");
        BaseOrder baseOrder = baseOrderService.findByOrderNo(orderNo);
        request.setAttribute("baseOrder", baseOrder);
        
        Category categoryTmp = new Category();
		categoryTmp.setIsDel(false);
		categoryTmp.setStatus(1);
		List<Category> categorys = categoryService.queryByCondition(categoryTmp);
    	request.setAttribute("categorys", categorys);
        
//        OrderCustomerInfoVo orderCustomerInfoVo = commonOrderInfoImpl.getOrderCInfoVo(orderNo);
        
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
        List<ReceiveAddress> listra = reciveAddressService.queryByCondition(reciveAddress);
        if(listra.size()>0){
        	 orderCustomerInfoVo.setReceiveAddress(listra.get(0));
        }
        request.setAttribute("OrderCustomerInfoVo", orderCustomerInfoVo);
        
        
        
//        //获取订单客户定制需求
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
        
//        OrderCustomDemandVo orderCustomDemandVo = commonOrderInfo.getOrderCDemandVo(orderNo);
        OrderStatusStream orderStatusStream = new OrderStatusStream();
        orderStatusStream.setOrderNo(orderNo);
        List<OrderStatusStream> listos = orderStatusStreamService.queryByCondition(orderStatusStream);
        
        request.setAttribute("orderStream", listos);
        request.setAttribute("orderStatusMap", CommonVar.orderStatusMap());
        request.setAttribute("OrderCustomDemandVo", orderCustomDemandVo);

		return "order/customer/detail";
	}

	@RequestMapping("/editUInfo")
	public String editUInfo(HttpServletRequest request, HttpServletResponse response, RedirectAttributes attr, @ModelAttribute OrderCustomerInfo orderCustomerInfo) {

		String company = request.getParameter("companyName");
		String department = request.getParameter("customDepartment");
		String reciveDetail = request.getParameter("reciveAddress");
		String measureDetail = request.getParameter("measureAddress");
		String orderNo = request.getParameter("orderNo");
		String contacts = request.getParameter("bespeakName");
		String contactPhone = request.getParameter("bespeakPhone");

		ReceiveAddress reciveAddress = new ReceiveAddress();
		reciveAddress.setAddressDetail(reciveDetail);
		reciveAddress.setContacts(contacts);
		reciveAddress.setContactPhone(contactPhone);
		// 省市城市区的编码还没存
		reciveAddress.setOrderNo(orderNo);
		// 要返回收货地址ID
		reciveAddressService.save(reciveAddress);
		Long reciveadd = reciveAddress.getId();

		// orderCustomerInfo.setOrderNo(orderNo);
		// orderCustomerInfo.setReciveAddressId(reciveadd);
		// orderCustomerInfoService.update(orderCustomerInfo);
		// System.out.println(orderCustomerInfo.getCompanyName()+"---"+orderCustomerInfo.getCustomDepartment());
		OrderCustomerInfo orderCI = new OrderCustomerInfo();
		orderCI.setOrderNo(orderNo);
		List<OrderCustomerInfo> list = orderCustomerInfoService.queryByCondition(orderCI);
		if (list.size() > 0) {
			list.get(0).setBespeakName(contacts);
			list.get(0).setBespeakPhone(contactPhone);
			list.get(0).setCompanyName(company);
			list.get(0).setCustomDepartment(department);
			list.get(0).setReceiveAddressId(reciveadd);
			orderCustomerInfoService.update(list.get(0));
		}

		OrderMeasureAddress orderMeasureAddress = new OrderMeasureAddress();
		orderMeasureAddress.setAddressDetail(measureDetail);
		orderMeasureAddress.setContacts(contacts);
		orderMeasureAddress.setContactPhone(contactPhone);
		// 省市城市区的编码还没存
		orderMeasureAddress.setOrderNo(orderNo);
		// 要返回主键订单量体地址ID
		orderMeasureAddressService.save(orderMeasureAddress);

		attr.addAttribute("orderNo", orderNo);

		return "redirect:/publishOrder/showOrderInfo";
	}

	@RequestMapping("/editGoodsInfo")
	public String editGoodsInfo(HttpServletRequest request, HttpServletResponse response, RedirectAttributes attr, @ModelAttribute OrderCustomDemand orderCustomDemand) {
		orderCustomDemandService.update(orderCustomDemand);
		attr.addAttribute("orderNo", request.getParameter("orderNo"));
		return "redirect:/publishOrder/showOrderInfo";
	}

	/**
	 * ajax请求 orderInfo,客户信息
	 */
	@ResponseBody
	@RequestMapping("/orderCustomerInfoVo")
	public OrderCustomerInfoVo getOrderCustomerInfo(String orderNo) {
		// BaseOrder baseOrder = baseOrderService.findByOrderNo(orderNo);
		// request.setAttribute("baseOrder", baseOrder);
		// 获取订单商户信息
		OrderCustomerInfo orderCustomerInfo = new OrderCustomerInfo();
		OrderMeasureAddress orderMeasureAddress = new OrderMeasureAddress();
		ReceiveAddress reciveAddress = new ReceiveAddress();
		OrderCustomerInfoVo orderCustomerInfoVo = new OrderCustomerInfoVo();
		orderCustomerInfo.setOrderNo(orderNo);
		List<OrderCustomerInfo> list = orderCustomerInfoService.queryByCondition(orderCustomerInfo);
		if (list.size() > 0) {
			orderCustomerInfoVo.setOrderCustomerInfo(list.get(0));
		}
		orderMeasureAddress.setOrderNo(orderNo);
		List<OrderMeasureAddress> li = orderMeasureAddressService.queryByCondition(orderMeasureAddress);
		orderCustomerInfoVo.setList(li);

		reciveAddress.setOrderNo(orderNo);
		List<ReceiveAddress> listra = reciveAddressService.queryByCondition(reciveAddress);
		if (listra.size() > 0) {
			orderCustomerInfoVo.setReceiveAddress(listra.get(0));
		}
		return orderCustomerInfoVo;
	}

	/**
	 * ajax,客户定制需求
	 * 
	 * @param orderNo
	 * @return
	 * @author duandingyang
	 */
	@ResponseBody
	@RequestMapping("/orderCustomDemandVo")
	public OrderCustomDemandVo getOrderCustomDemandVo(String orderNo) {
		// 获取订单客户定制需求
		OrderCustomDemandVo orderCustomDemandVo = new OrderCustomDemandVo();
		OrderCustomDemand orderCustomDemand = new OrderCustomDemand();
		OrderCustomGoods orderCustomGoods = new OrderCustomGoods();
		ServiceProvider serviceProvider = new ServiceProvider();
		orderCustomDemand.setOrderNo(orderNo);
		List<OrderCustomDemand> lists = orderCustomDemandService.queryByCondition(orderCustomDemand);
		if (lists.size() > 0) {
			if (lists.get(0).getId() > 0) {
				orderCustomGoods.setOrderCustomDemandId(lists.get(0).getId());
			}
			if (StringUtils.isNotBlank(String.valueOf(lists.get(0).getSpId()))) {
				serviceProvider = serviceProviderService.findById(lists.get(0).getSpId());
				orderCustomDemandVo.setServiceProvider(serviceProvider);
			}
		}
		List<OrderCustomGoods> l = orderCustomGoodsService.queryByCondition(orderCustomGoods);
		Integer count = 0;
		for (OrderCustomGoods ocg : l) {
			count += ocg.getGoodsNum();
		}
		orderCustomDemandVo.setOrderCustomGoods(l);
		orderCustomDemandVo.setOrderCustomDemand(lists.get(0));
		orderCustomDemandVo.setCount(count);

		// OrderCustomDemandVo orderCustomDemandVo = commonOrderInfo.getOrderCDemandVo(orderNo);
		OrderStatusStream orderStatusStream = new OrderStatusStream();
		orderStatusStream.setOrderNo(orderNo);
		// List<OrderStatusStream> listos = orderStatusStreamService.queryByCondition(orderStatusStream);
		// request.setAttribute("OrderCustomDemandVo", orderCustomDemandVo);
		return orderCustomDemandVo;
	}

}
