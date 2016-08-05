package com.efubao.core.bigc.controller.order;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.efubao.common.util.Page;
import com.efubao.core.bigc.controller.common.CommonVar;
import com.efubao.core.bigc.vo.OrderChooseSpVo;
import com.efubao.core.bigc.vo.OrderInfo;
import com.efubao.core.order.domain.BaseOrder;
import com.efubao.core.order.domain.OrderCustomDemand;
import com.efubao.core.order.domain.OrderServiceProvider;
import com.efubao.core.order.domain.OrderStatusStream;
import com.efubao.core.order.service.BaseOrderService;
import com.efubao.core.order.service.OrderCustomDemandService;
import com.efubao.core.order.service.OrderServiceProviderService;
import com.efubao.core.sp.domain.ServiceProvider;
import com.efubao.core.sp.service.ServiceProviderService;

/**
 */
@Controller
@RequestMapping(value = { "/order" })
public class OrderController {
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	private BaseOrderService baseOrderService;
	@Autowired
	private OrderServiceProviderService orderServiceProviderService;
	@Autowired
	private ServiceProviderService serviceProviderService;
	@Autowired
	private OrderCustomDemandService orderCustomDemandService;

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
		page.setPageSize(100);
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
				orderInfo.setBalancePayment(temp.getBalancePayment());
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
		request.setAttribute("orderNo", orderNo);
		BaseOrder baseOrder = new BaseOrder();
		baseOrder.setOrderNo(orderNo);
		List<BaseOrder> list = baseOrderService.queryByCondition(baseOrder);
		request.setAttribute("baseOrder", list.get(0));
		if (list.size() > 0) {
			Integer status = list.get(0).getStatus();
			attr.addAttribute("orderNo", orderNo);
			if (status == 100 || status == 110) {
				return "redirect:/publishOrder/showOrderInfo";
			}
			if (status == 120) {
				// 选择服务商controller
				attr.addAttribute("orderNo", orderNo);
				return "redirect:/order/chooseSp";
			}
			if (status == 125 || status == 130) {
				// 付订金
				return "redirect:/payOrder/showOrderInfo";
			}
			if (status == 140) {
				// 上门量体状态
				return "order/order_measure";
			}
			if (status == 150) {
				// 生产制作
				return "order/order_making";
			}
			if (status == 160) {
				// 付尾款
				return "order/order_balance_payment";
			}
		}
		return "order/order_list";
	}

	/**
	 * 选择服务商
	 * 
	 * @param request
	 * @param response
	 * @param attr
	 * @return
	 */
	@RequestMapping("/chooseSp")
	public String chooseSp(HttpServletRequest request, HttpServletResponse response, RedirectAttributes attr) {
		String orderNo = request.getParameter("orderNo");
		// 选择服务商列表
		List<OrderServiceProvider> orderServiceProviderList = orderServiceProviderService.getSpListByOrderNo(orderNo);
		List<Long> spids = new LinkedList<>();
		for (OrderServiceProvider orderServiceProvider : orderServiceProviderList) {
			spids.add(orderServiceProvider.getSpId());
		}
		// List<ServiceProvider> serviceProviders = serviceProviderService.getSpListByIds(spids);
		// orderInfo.setServiceProviderList(serviceProviders);
		List<OrderChooseSpVo> orderChooseSpVos = new LinkedList<>();
		OrderChooseSpVo orderChooseSpVo = null;
		for (OrderServiceProvider orderServiceProvider : orderServiceProviderList) {
			orderChooseSpVo = new OrderChooseSpVo();
			Long spid = orderServiceProvider.getSpId();
			ServiceProvider serviceProvider = serviceProviderService.findById(spid);
			orderChooseSpVo.setOrderNo(orderNo);
			orderChooseSpVo.setServiceProvider(serviceProvider);
			orderChooseSpVo.setCreate_time(orderServiceProvider.getCreateTime());
			orderChooseSpVo.setStatus(orderServiceProvider.getStatus());
			orderChooseSpVos.add(orderChooseSpVo);
		}
		request.setAttribute("orderChooseSpVos", orderChooseSpVos);
		request.setAttribute("chooseSp_status", 120);
		request.setAttribute("orderNo", orderNo);
		return "order/choose_sp";
	}

	/**
	 * 选择某一个供应商
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/choose_one_sp", method = RequestMethod.GET)
	public String choose_one_sp(HttpServletRequest request, HttpServletResponse response) {
		Long spid = Long.parseLong(request.getParameter("spid"));
		String orderNo = request.getParameter("orderNo");
		List<OrderServiceProvider> orderServiceProviderList = orderServiceProviderService.getSpListByOrderNo(orderNo);
		for (OrderServiceProvider temp : orderServiceProviderList) {
			if (temp.getSpId() == spid) {
				temp.setStatus(2);
			} else {
				temp.setStatus(4);
			}
			orderServiceProviderService.update(temp);
		}
		BaseOrder baseOrder = baseOrderService.findById(Long.parseLong(orderNo));
		baseOrder.setSpId(spid);
		baseOrder.setStatus(125);
		baseOrderService.update(baseOrder);
		OrderCustomDemand orderCustomDemand = new OrderCustomDemand();
		orderCustomDemand.setOrderNo(orderNo);
		List<OrderCustomDemand> orderCustomDemands = orderCustomDemandService.queryByCondition(orderCustomDemand);
		try {
			OrderCustomDemand temp = orderCustomDemands.get(0);
			temp.setSpId(spid);
			orderCustomDemandService.update(temp);
		} catch (Exception e) {
			System.out.println("orderCustomDemands为空");
		}
		OrderStatusStream orderStatusStream = new OrderStatusStream();
		orderStatusStream.setIsDel(false);
		orderStatusStream.setOrderNo(orderNo);
		orderStatusStream.setStatus(125);
		orderStatusStream.setFinishTime(new Timestamp(System.currentTimeMillis()));
		return "redirect:/order/orderList";
	}

}
