package com.efubao.core.sp.controller.order;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.efubao.common.util.Page;
import com.efubao.core.order.domain.BaseOrder;
import com.efubao.core.order.domain.OrderCustomDemand;
import com.efubao.core.order.domain.OrderCustomerInfo;
import com.efubao.core.order.domain.OrderServiceProvider;
import com.efubao.core.order.service.BaseOrderService;
import com.efubao.core.order.service.OrderCustomDemandService;
import com.efubao.core.order.service.OrderCustomerInfoService;
import com.efubao.core.order.service.OrderServiceProviderService;
import com.efubao.core.sp.domain.ServiceProvider;
import com.efubao.core.sp.service.ServiceProviderService;
import com.efubao.core.sp.vo.OrderCustomDemandVo;

@Controller
@RequestMapping("/service")
public class ServiceOrderController {

	@Autowired
	private BaseOrderService baseOrderService;
	@Autowired
	private OrderServiceProviderService orderServiceProviderService;
	@Autowired
	private ServiceProviderService serviceProviderService;
	@Autowired
	private OrderCustomDemandService orderCustomDemandService;
	@Autowired
	private OrderCustomerInfoService orderCustomerInfoService;

	@RequestMapping("/orderList")
	public String orderList(HttpServletRequest request, HttpServletResponse response, RedirectAttributes attr) {
		Integer pageNo = Integer.parseInt(StringUtils.isNotBlank(request.getParameter("pageNo")) && StringUtils.isNumeric(request.getParameter("pageNo")) ? request.getParameter("pageNo")
				: "1");
		// 订单状态
		int orderStatus = 0;
		// 获取中标状态
		String isBid = request.getParameter("status");
		// 假定供应商id为i
		Long spId = 1L;
		ServiceProvider serviceProvider = serviceProviderService.findById(spId);
		OrderServiceProvider orderServiceProvider = new OrderServiceProvider();
		orderServiceProvider.setSpId(spId);
		if (isBid != null) {
			if ("2".equals(isBid)) {
				// 中标
				orderServiceProvider.setStatus(2);
			} else {
				orderServiceProvider.setStatus(2);
				orderStatus = Integer.parseInt(isBid);
			}
		}
		Page<OrderServiceProvider> page = new Page<>();
		page.setPageSize(20);
		page.setPageNo(pageNo);
		page.setOrderBy("create_time DESC");
		orderServiceProviderService.queryByPage(page, orderServiceProvider);
		// 得到这个供应商的订单列表
		List<OrderServiceProvider> orderServiceProviders = page.getResult();
		List<OrderCustomDemandVo> orderCustomDemandVos = new LinkedList<>();
		OrderCustomDemandVo ordercustomDemandVo = null;
		OrderCustomDemand orderCustomDemand = null;
		for (OrderServiceProvider temp : orderServiceProviders) {
			ordercustomDemandVo = new OrderCustomDemandVo();
			ordercustomDemandVo.setServiceProvider(serviceProvider);
			String orderNo = temp.getOrderNo();
			BaseOrder baseOrder = baseOrderService.findByOrderNo(orderNo);
			if (baseOrder.getStatus() != orderStatus && orderStatus != 0)
				continue;
			orderCustomDemand = new OrderCustomDemand();
			orderCustomDemand.setOrderNo(orderNo);
			// 根据订单号，在OrderCustomDemand表中，获取到定制信息
			List<OrderCustomDemand> orderCustomDemands = orderCustomDemandService.queryByCondition(orderCustomDemand);
			/*
			 * for (OrderCustomDemand temp2 : orderCustomDemands) { ordercustomDemandVo.setOrderCustomDemand(temp2); }
			 */
			try {
				ordercustomDemandVo.setOrderCustomDemand(orderCustomDemands.get(0));
			} catch (Exception e) {
				System.out.println("orderCustomDemands为空");
			}
			// 根据订单号，在OrderCustomerInfo表中，获取客户信息
			OrderCustomerInfo orderCustomerInfo = new OrderCustomerInfo();
			orderCustomerInfo.setOrderNo(orderNo);
			List<OrderCustomerInfo> orderCustomerInfos = orderCustomerInfoService.queryByCondition(orderCustomerInfo);
			try {
				ordercustomDemandVo.setOrderCustomerInfo(orderCustomerInfos.get(0));
			} catch (Exception e) {
				System.out.println("orderCustomerInfos为空");
			}
			// 根据订单号，在OrderServiceProvider表中，获取订单状态信息
			ordercustomDemandVo.setOrderStatus(baseOrder.getStatus());
			ordercustomDemandVo.setStatus(temp.getStatus());
			ordercustomDemandVo.setCreateTime(temp.getCreateTime());
			ordercustomDemandVo.setFrontMoney(baseOrder.getFrontMoney());
			ordercustomDemandVo.setTotalMoney(baseOrder.getTotalMoney());
			ordercustomDemandVo.setBalancePayment(baseOrder.getBalancePayment());
			orderCustomDemandVos.add(ordercustomDemandVo);
		}
		request.setAttribute("orderCustomDemandVos", orderCustomDemandVos);
		request.setAttribute("status", isBid);
		return "order/order_list";
	}

	@RequestMapping(value = "/orderDetail", method = RequestMethod.GET)
	public String orderDetail(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		String orderNo = request.getParameter("orderNo");
		String spId = request.getParameter("spId");
		BaseOrder baseOrder = baseOrderService.findByOrderNo(orderNo);
		int status = baseOrder.getStatus();
		request.setAttribute("baseOrder", baseOrder);
		request.setAttribute("orderNo", orderNo);
		request.setAttribute("SpId", spId);
		if (status == 120) {
			// 竞标,可以选择弃标
			return "order/order_bid";
		}
		if (status == 125) {
			// 中标，可以选择录入合同
			return "order/order_win_bid";
		}
		if (status == 130) {
			return "order/pay_first";
		}
		if (status == 140) {
			// 上门量体状态，可以指派量体师
			return "order/order_measure";
		}
		if (status == 150) {
			// 生产制作状态
			return "order/order_making";
		}
		if (status == 160) {
			// 付尾款状态
			return "order/order_balance_payment";
		}
		if (status == 170) {
			// 待发货状态
		}
		return null;
	}

	@RequestMapping(value = "/order_giveup", method = RequestMethod.GET)
	public String orderGiveUp(HttpServletRequest request, HttpServletResponse response) {
		String orderNo = request.getParameter("orderNo");
		String spid = request.getParameter("spid");
		Long Spid = null;
		if (spid != null) {
			Spid = Long.parseLong(spid);
		}
		List<OrderServiceProvider> orderServiceProviders = orderServiceProviderService.getSpListByOrderNo(orderNo);
		for (OrderServiceProvider temp : orderServiceProviders) {
			if (Spid == temp.getSpId()) {
				// 弃标
				temp.setStatus(3);
				orderServiceProviderService.update(temp);
				break;
			}
		}
		return "redirect:/service/orderList";
	}
}
