package com.efubao.core.sp.controller.order;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.efubao.core.order.domain.BaseOrder;
import com.efubao.core.order.domain.OrderContract;
import com.efubao.core.order.domain.OrderContractGoods;
import com.efubao.core.order.domain.OrderStatusStream;
import com.efubao.core.order.service.BaseOrderService;
import com.efubao.core.order.service.OrderContractGoodsService;
import com.efubao.core.order.service.OrderContractService;
import com.efubao.core.order.service.OrderStatusStreamService;
import com.efubao.core.sp.controller.common.CommonVar;
import com.efubao.core.sp.domain.ServiceProvider;
import com.efubao.core.sp.domain.SpContract;
import com.efubao.core.sp.service.ServiceProviderService;
import com.efubao.core.sp.service.SpContractService;
import com.efubao.core.sp.vo.OrderContractVo;

@Controller
@RequestMapping("/pay")
public class PayOrderController {
	@Autowired
	public OrderContractService orderContractService;
	@Autowired
	public ServiceProviderService serviceProviderService;
	@Autowired
	public OrderContractGoodsService orderContractGoodsService;
	@Autowired
	public BaseOrderService baseOrderService;
	@Autowired
	public OrderStatusStreamService orderStatusStreamService;
	@Autowired
	public SpContractService spContractService;
	@RequestMapping("/payFirst")
	public String payFirst(HttpServletRequest request, HttpServletResponse response){
		String spId = "4";
		
		String orderNo = request.getParameter("orderNo");
//		String orderContractId = request.getParameter("orderContractId");
		BaseOrder baseOrder = new BaseOrder();
		baseOrder.setOrderNo(orderNo);
		baseOrder = baseOrderService.findByOrderNo(orderNo);
		request.setAttribute("baseOrder", baseOrder);
		request.setAttribute("orderNo", orderNo);
		OrderStatusStream orderStatusStream = new OrderStatusStream();
	    orderStatusStream.setOrderNo(orderNo);
	    List<OrderStatusStream> listos = orderStatusStreamService.queryByCondition(orderStatusStream);
	    request.setAttribute("orderStream", listos);
	    request.setAttribute("orderStatusMap", CommonVar.orderStatusMap());
		
	    request.setAttribute("spId", spId);
	    return "order/pay_first";
	}
	
	

	@RequestMapping("/contractInfo")
	@ResponseBody
	public OrderContractVo contractInfo(HttpServletRequest request, HttpServletResponse response){
		String orderNo = request.getParameter("orderNo");
//		String spId = request.getParameter("spId");
		OrderContractVo orderContractVo = new OrderContractVo();
		if(StringUtils.isNotBlank(orderNo)){
			Integer totalNum=0;
			BaseOrder baseOrder = baseOrderService.findByOrderNo(orderNo);
			String spId = String.valueOf(baseOrder.getSpId());
			if(StringUtils.isNotBlank(String.valueOf(baseOrder.getOrderContractId()))){
				OrderContract orderContract = orderContractService.findById(baseOrder.getOrderContractId());
				ServiceProvider serviceProvider = serviceProviderService.findById(orderContract.getSpId());
				OrderContractGoods orderContractGoods =new OrderContractGoods();
				orderContractGoods.setOrderContractId(baseOrder.getOrderContractId());
				List<OrderContractGoods> list = orderContractGoodsService.queryByCondition(orderContractGoods);
				for(OrderContractGoods ocg : list){
					totalNum += ocg.getGoodsNum();
				}
				
				SpContract spContract = new SpContract();
				spContract.setSpId(Long.parseLong(spId));
				spContract.setIsDel(false);
				List<SpContract> l = spContractService.queryByCondition(spContract);
				if(list.size()>0){
					orderContractVo.setSpContract(l.get(0));
					BigDecimal bd = new BigDecimal(1);
					BigDecimal finalMoney = bd.subtract(l.get(0).getCreditDepositPercent());
					orderContractVo.setFinalMoney(finalMoney);
				}
				
				orderContractVo.setBaseOrder(baseOrder);
				orderContractVo.setList(list);
				orderContractVo.setServiceProvider(serviceProvider);
				orderContractVo.setOrderContract(orderContract);
				orderContractVo.setTotalNum(totalNum);
				
			}
		}
	    return orderContractVo;
	}
}
