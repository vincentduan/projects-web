package com.efubao.core.admin.controller.order;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.efubao.core.admin.vo.CommonVar;
import com.efubao.core.order.domain.BaseOrder;
import com.efubao.core.order.domain.OrderStatusStream;
import com.efubao.core.order.service.BaseOrderService;
import com.efubao.core.order.service.OrderStatusStreamService;

@Controller
@RequestMapping("/pay")
public class PayController {
	@Autowired
	public BaseOrderService baseOrderService;
	@Autowired
	public OrderStatusStreamService orderStatusStreamService;
	@RequestMapping("/payfirst")
	public String payfirst(HttpServletRequest request){
		String orderNo = request.getParameter("orderNo");
		BaseOrder baseOrder = baseOrderService.findByOrderNo(orderNo);
		OrderStatusStream orderStatusStream = new OrderStatusStream();
		orderStatusStream.setOrderNo(orderNo);
		List<OrderStatusStream> listos = orderStatusStreamService.queryByCondition(orderStatusStream);
		request.setAttribute("orderStream", listos);
		request.setAttribute("orderStatusMap", CommonVar.orderStatusMap());
		request.setAttribute("baseOrder", baseOrder);
		request.setAttribute("orderNo", orderNo);
			
		return "order/orderPaidDeposit";
			
	}
	

}
