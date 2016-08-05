package com.efubao.core.admin.controller.order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.efubao.common.util.Page;
import com.efubao.core.admin.domain.Category;
import com.efubao.core.admin.service.CategoryService;
import com.efubao.core.admin.vo.OrderCustomDemandVo;
import com.efubao.core.admin.vo.OrderCustomerInfoVo;
import com.efubao.core.order.domain.BaseOrder;
import com.efubao.core.order.domain.OrderCustomDemand;
import com.efubao.core.order.domain.OrderCustomGoods;
import com.efubao.core.order.domain.OrderCustomerInfo;
import com.efubao.core.order.domain.OrderMeasureAddress;
import com.efubao.core.order.domain.OrderServiceProvider;
import com.efubao.core.order.service.BaseOrderService;
import com.efubao.core.order.service.OrderCustomDemandService;
import com.efubao.core.order.service.OrderCustomGoodsService;
import com.efubao.core.order.service.OrderCustomerInfoService;
import com.efubao.core.order.service.OrderMeasureAddressService;
import com.efubao.core.order.service.OrderServiceProviderService;
import com.efubao.core.order.service.ReceiveAddressService;
import com.efubao.core.sp.domain.ServiceProvider;
import com.efubao.core.sp.service.ServiceProviderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/chooseSp")
public class ChooseSpController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(ChooseSpController.class);
	
	@Autowired
	public CategoryService categoryService;
	@Autowired
	public BaseOrderService baseOrderService;
	@Autowired
	public OrderCustomerInfoService orderCustomerInfoService;
    @Autowired
	public OrderMeasureAddressService orderMeasureAddressService;
    @Autowired
    public OrderCustomGoodsService orderCustomGoodsService;
    @Autowired
    public OrderCustomDemandService orderCustomDemandService;
    @Autowired
    public ReceiveAddressService receiveAddressService;
	@Autowired
    public ServiceProviderService serviceProviderService;
	@Autowired
	public OrderServiceProviderService orderServiceProviderService;
	/**
	 * 受理需求之后跳转到选择服务商
	 * 
	 * @param request
	 * @param response
	 * @param attr
	 * @return
	 */
	@RequestMapping("/acceptOrder")
	public String acceptOrder(HttpServletRequest request, HttpServletResponse response,RedirectAttributes attr){
		String orderNo = request.getParameter("orderNo");
		if(StringUtils.isNotBlank(orderNo)){
			BaseOrder baseOrder = new BaseOrder();
			baseOrder.setStatus(120);
			baseOrder.setOrderNo(orderNo);
			baseOrderService.update(baseOrder);
		}
		attr.addAttribute("orderNo", orderNo);
		return "redirect:/orderAccept/showOrderInfo";
	}
	
	/**
	 * 选择服务商
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/assignService")
	@ResponseBody
	public String assignService(HttpServletRequest request, HttpServletResponse response){
		String spName = request.getParameter("spName");
		String categoryId = request.getParameter("categoryId");
		String pageNo = StringUtils.defaultIfBlank(request.getParameter("pageNo"), "1");
		
		Page<ServiceProvider> page = new Page<ServiceProvider>();
		page.setPageSize(12);
		page.setPageNo(Integer.parseInt(pageNo));
		Integer start = (page.getPageNo()-1)*page.getPageSize();
		spName = "%"+spName+"%";
		if(Integer.parseInt(categoryId)==-1||StringUtils.isBlank(categoryId)){
			serviceProviderService.getServiceP(page,spName,0,start,page.getPageSize());
		}else{
			serviceProviderService.getServiceP(page,spName,Integer.parseInt(categoryId),start,page.getPageSize());
		}
		ObjectMapper mapper = new ObjectMapper();
		String ret = "";
		try {
			ret = mapper.writeValueAsString(page);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	@RequestMapping(value = "/assignSp", method = RequestMethod.GET)
	public String assignSp(HttpServletRequest request, HttpServletResponse response,RedirectAttributes attr) {
		String orderNo = request.getParameter("orderNo");
		String[] spids = request.getParameterValues("spName");
		OrderServiceProvider orderServiceProvider;
		for (int i = 0; i < spids.length; i++) {
			orderServiceProvider = new OrderServiceProvider();
			orderServiceProvider.setOrderNo(orderNo);
			orderServiceProvider.setStatus(1);
			orderServiceProvider.setId(Long.parseLong(spids[i]));
			orderServiceProviderService.save(orderServiceProvider);
		}
		attr.addAttribute("orderNo", orderNo);
		return "redirect:/pay/payfirst";
	}

}
