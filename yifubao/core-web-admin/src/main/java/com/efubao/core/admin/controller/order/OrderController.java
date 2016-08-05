package com.efubao.core.admin.controller.order;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.efubao.common.util.Page;
import com.efubao.core.admin.service.CategoryService;
import com.efubao.core.admin.vo.CommonVar;
import com.efubao.core.admin.vo.OrderCustomDemandVo;
import com.efubao.core.admin.vo.OrderCustomerInfoVo;
import com.efubao.core.admin.vo.OrderInfo;
import com.efubao.core.order.domain.BaseOrder;
import com.efubao.core.order.domain.OrderCustomDemand;
import com.efubao.core.order.domain.OrderCustomGoods;
import com.efubao.core.order.domain.OrderCustomerInfo;
import com.efubao.core.order.domain.OrderMeasureAddress;
import com.efubao.core.order.domain.OrderServiceProvider;
import com.efubao.core.order.domain.OrderStatusStream;
import com.efubao.core.order.domain.ReceiveAddress;
import com.efubao.core.order.service.BaseOrderService;
import com.efubao.core.order.service.OrderCustomDemandService;
import com.efubao.core.order.service.OrderCustomGoodsService;
import com.efubao.core.order.service.OrderCustomerInfoService;
import com.efubao.core.order.service.OrderMeasureAddressService;
import com.efubao.core.order.service.OrderServiceProviderService;
import com.efubao.core.order.service.ReceiveAddressService;
import com.efubao.core.sp.domain.ServiceProvider;
import com.efubao.core.sp.service.ServiceProviderService;

@Controller
@RequestMapping("/order")
public class OrderController {
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
	public ReceiveAddressService reciveAddressService;
	@Autowired
	private OrderServiceProviderService orderServiceProviderService;
	@Autowired
	private ServiceProviderService serviceProviderService;

	/**
	 * 网站首页入口
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/orderList", method = RequestMethod.GET)
	public String orderList(HttpServletRequest request) {
		int status = 1;
		String t = request.getParameter("status");
		if (StringUtils.isNotEmpty(t)) {
			status = Integer.parseInt(t);// 如果为2，表示待付款（待付订金和待付尾款）
			request.setAttribute("status", status);
		} else {
			request.setAttribute("status", status);
		}
		Integer pageNo = Integer.parseInt(StringUtils.isNotBlank(request.getParameter("pageNo")) && StringUtils.isNumeric(request.getParameter("pageNo")) ? request.getParameter("pageNo")
				: "1");
		Page<BaseOrder> page = new Page<>();
		page.setPageSize(50);
		page.setPageNo(pageNo);
		page.setOrderBy("create_time DESC");
		BaseOrder baseOrder = new BaseOrder();
		baseOrder.setIsDel(false);
		if (status != 1) {
			baseOrder.setStatus(status);
		}
		baseOrderService.queryByPage(page, baseOrder);
		List<BaseOrder> baseOrders = page.getResult();
		OrderInfo orderInfo = null;
		List<OrderInfo> orderInfoList = new LinkedList<>();
		for (BaseOrder temp : baseOrders) {
			orderInfo = new OrderInfo();
			orderInfo.setOrderNo(temp.getOrderNo());// 订单号
			orderInfo.setCreateTime(temp.getCreateTime());// 订单创建时间
			orderInfo.setStatus(temp.getStatus());// 订单状态
			// 客户信息
			OrderCustomerInfo orderCustomerInfo = new OrderCustomerInfo();
			orderCustomerInfo.setOrderNo(temp.getOrderNo());
			List<OrderCustomerInfo> orderCustomerInfos = orderCustomerInfoService.queryByCondition(orderCustomerInfo);
			try {
				orderInfo.setOrderCustomerInfo(orderCustomerInfos.get(0));
			} catch (Exception e) {
				System.out.println("orderCustomerInfos为空");
			}
			if (temp.getStatus() == 110) {
				// 管家受理

			}
			if (temp.getStatus() == 120) {
				// 选择服务商
				List<OrderServiceProvider> orderServiceProviderList = orderServiceProviderService.getSpListByOrderNo(temp.getOrderNo());
				// List<Long> spids = new LinkedList<>();
				// for (OrderServiceProvider orderServiceProvider : orderServiceProviderList) {
				// spids.add(orderServiceProvider.getSpId());
				// }
				// List<ServiceProvider> serviceProviders = serviceProviderService.getSpListByIds(spids);
				// orderInfo.setServiceProviderList(serviceProviders);
				orderInfo.setServiceProviderListSize(orderServiceProviderList.size());
			}
			if (temp.getStatus() >= 125 && temp.getStatus() != 210) {
				if (StringUtils.isNotBlank(temp.getSpId() + "")) {
					ServiceProvider serviceProvider = serviceProviderService.findById(temp.getSpId());
					orderInfo.setServiceProvider(serviceProvider);
				}
				orderInfo.setFrontMoney(temp.getFrontMoney());
				orderInfo.setTotalMoney(temp.getTotalMoney());
			}
			if (temp.getStatus() == 140) {
				// 上门量体
			}
			if (temp.getStatus() == 150) {
				// 生产制作
			}
			if (temp.getStatus() == 160) {
				// 付尾款 1
			}
			if (temp.getStatus() == 170) {
				// 待发货
			}
			if (temp.getStatus() == 180) {
				// 待签收
			}
			if (temp.getStatus() == 190) {
				// 已签收
			}
			if (temp.getStatus() == 200) {
				// 交易完成
			}
			if (temp.getStatus() == 210) {
				// 取消订单
				if (StringUtils.isNotBlank(temp.getSpId() + "")) {
					ServiceProvider serviceProvider = serviceProviderService.findById(temp.getSpId());
					orderInfo.setServiceProvider(serviceProvider);
				}
			}
			// 定制数量，一个订单只有一个定制数量
			OrderCustomDemand orderCustomDemand = new OrderCustomDemand();
			orderCustomDemand.setOrderNo(temp.getOrderNo());
			try {
				orderInfo.setOrderCustomDemand(orderCustomDemandService.queryByCondition(orderCustomDemand).get(0));
			} catch (Exception e) {
				System.out.println(temp.getOrderNo());
			}

			orderInfoList.add(orderInfo);
		}
		request.setAttribute("orderInfoList", orderInfoList);
		request.setAttribute("orderStatusMap", CommonVar.orderStatusMap());
		request.setAttribute("page", page);
		String url = "order/orderList";
		request.setAttribute("url", url);
		return "order/order_list";
	}

	@RequestMapping("/orderDetail")
	public String orderDetail(HttpServletRequest request, HttpServletResponse response, RedirectAttributes attr) {
		String orderNo = request.getParameter("orderNo");

		BaseOrder baseOrder = new BaseOrder();
		baseOrder.setOrderNo(orderNo);
		List<BaseOrder> list = baseOrderService.queryByCondition(baseOrder);
		if (list.size() > 0) {
			Integer status = list.get(0).getStatus();
			attr.addAttribute("orderNo", orderNo);
			if (status == 100 || status == 110) {
				return "redirect:/orderAccept/showOrderInfo";
			}
			if (status == 120) {
				// 选择服务商controller
				attr.addAttribute("orderNo", orderNo);
				return "redirect:/order/chooseSp";
			}
			if (status == 125 || status == 130) {
				return "redirect:/payOrder/showOrderInfo";
			}
		}
		return "order/order_list";
	}

	@RequestMapping("/cancelOrder")
	public String cancelOrder(HttpServletRequest request, HttpServletResponse response) {
		String orderNo = request.getParameter("orderNo");
		BaseOrder baseOrder = new BaseOrder();
		baseOrder.setOrderNo(orderNo);
		baseOrder.setStatus(200);
		baseOrderService.update(baseOrder);
		return "order/order_list";
	}

	/**
	 * ajax请求 orderInfo,客户信息
	 */
	@ResponseBody
	@RequestMapping("/orderCustomerInfoVo")
	public OrderCustomerInfoVo getOrderCustomerInfo(String orderNo, HttpServletRequest request, HttpServletResponse response) {
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
		request.setAttribute("orderCustomerInfoVo", orderCustomerInfoVo);
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
	public OrderCustomDemandVo getOrderCustomDemandVo(String orderNo, HttpServletRequest request, HttpServletResponse response) {
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
		request.setAttribute("OrderCustomDemandVo", orderCustomDemandVo);
		return orderCustomDemandVo;
	}

	

}
