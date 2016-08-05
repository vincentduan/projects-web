package com.efubao.core.admin.controller.order;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.efubao.common.util.Page;
import com.efubao.core.admin.domain.Category;
import com.efubao.core.admin.domain.Goods;
import com.efubao.core.admin.domain.GoodsSKU;
import com.efubao.core.admin.service.CategoryService;
import com.efubao.core.admin.service.GoodsSKUService;
import com.efubao.core.admin.service.GoodsService;
import com.efubao.core.admin.vo.CommonVar;
import com.efubao.core.admin.vo.ContractGoodsSave;
import com.efubao.core.admin.vo.OrderCustomDemandVo;
import com.efubao.core.admin.vo.OrderCustomerInfoVo;
import com.efubao.core.order.domain.BaseOrder;
import com.efubao.core.order.domain.OrderContract;
import com.efubao.core.order.domain.OrderContractGoods;
import com.efubao.core.order.domain.OrderCustomDemand;
import com.efubao.core.order.domain.OrderCustomGoods;
import com.efubao.core.order.domain.OrderCustomerInfo;
import com.efubao.core.order.domain.OrderMeasureAddress;
import com.efubao.core.order.domain.OrderStatusStream;
import com.efubao.core.order.domain.ReceiveAddress;
import com.efubao.core.order.service.BaseOrderService;
import com.efubao.core.order.service.OrderCustomDemandService;
import com.efubao.core.order.service.OrderCustomGoodsService;
import com.efubao.core.order.service.OrderCustomerInfoService;
import com.efubao.core.order.service.OrderMeasureAddressService;
import com.efubao.core.order.service.OrderServiceProviderService;
import com.efubao.core.order.service.OrderStatusStreamService;
import com.efubao.core.order.service.ReceiveAddressService;
import com.efubao.core.sp.service.ServiceProviderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/orderAccept")
public class OrderAccept {
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
	@Autowired
	public OrderStatusStreamService orderStatusStreamService;
	@Autowired
	public GoodsSKUService goodsSKUService;
	@Autowired
	public GoodsService goodsService;
	
	@RequestMapping("/showOrderInfo")
	public String showOrderInfo(HttpServletRequest request, HttpServletResponse response) {
		
        Integer count = 0;
        String orderNo = request.getParameter("orderNo");
        BaseOrder baseOrder = baseOrderService.findByOrderNo(orderNo);
        
        Category categoryTmp = new Category();
		categoryTmp.setIsDel(false);
		categoryTmp.setStatus(1);
		categoryTmp.setParentId((long)0);
		List<Category> categorys = categoryService.queryByCondition(categoryTmp);
    	request.setAttribute("categorys", categorys);
        
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
        
        //获取订单客户定制需求
        OrderCustomDemandVo orderCustomDemandVo = new OrderCustomDemandVo();
        OrderCustomDemand orderCustomDemand = new OrderCustomDemand();
        OrderCustomGoods orderCustomGoods = new OrderCustomGoods();
        orderCustomDemand.setOrderNo(orderNo);
        List<OrderCustomDemand> lists = orderCustomDemandService.queryByCondition(orderCustomDemand);
        orderCustomGoods.setOrderCustomDemandId(lists.get(0).getId());
        List<OrderCustomGoods> l = orderCustomGoodsService.queryByCondition(orderCustomGoods);

        for(OrderCustomGoods ocg : l){
        	if(ocg.getGoodsNum()!=null){
        		count += ocg.getGoodsNum();
        	}
        }
        orderCustomDemandVo.setOrderCustomGoods(l);
        orderCustomDemandVo.setOrderCustomDemand(lists.get(0));
        orderCustomDemandVo.setCount(count);
        request.setAttribute("orderNo", orderNo);
        request.setAttribute("baseOrder", baseOrder);
        request.setAttribute("OrderCustomerInfoVo", orderCustomerInfoVo);
        request.setAttribute("OrderCustomDemandVo", orderCustomDemandVo);
        
        OrderStatusStream orderStatusStream = new OrderStatusStream();
        orderStatusStream.setOrderNo(orderNo);
        List<OrderStatusStream> listos = orderStatusStreamService.queryByCondition(orderStatusStream);
        request.setAttribute("orderStream", listos);
        request.setAttribute("orderStatusMap", CommonVar.orderStatusMap());
        if(baseOrder.getStatus()==110||baseOrder.getStatus()==100){
        	return "order/orderAccept";
        }if(baseOrder.getStatus()==120){
        	return "/order/orderToProvider";
        }if(baseOrder.getStatus()==125 || baseOrder.getStatus()==130){
        	return "";
        }

		return "order/order_list";
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
	
		return "redirect:/orderAccept/showOrderInfo";
	}
	
	@RequestMapping("/editGoodsInfo")
	public String editGoodsInfo(HttpServletRequest request, HttpServletResponse response, RedirectAttributes attr, @ModelAttribute OrderCustomDemand orderCustomDemand) {
		orderCustomDemandService.update(orderCustomDemand);
		attr.addAttribute("orderNo", request.getParameter("orderNo"));
		return "redirect:/orderAccept/showOrderInfo";
	}

	/**
	 * 搜索商品SKU信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/findGoods",method =  RequestMethod.GET)
	@ResponseBody
	public String searchGoods(HttpServletRequest request,HttpServletResponse response){
		
		List<ContractGoodsSave> list = new ArrayList<ContractGoodsSave>();
	    String name = request.getParameter("name");
	    String categoryId = StringUtils.defaultIfBlank(request.getParameter("categoryId"), "0");
	    String pageNo = StringUtils.defaultIfBlank(request.getParameter("pageNo"), "1");
	    Integer start = 0;
	    Page<GoodsSKU> page = new Page<GoodsSKU>();
	    page.setPageSize(6);
	    start = (Integer.parseInt(pageNo)-1)*page.getPageSize();
	    name = "%"+name+"%";
		goodsSKUService.searchGoodsSku(page,name, Integer.parseInt(categoryId),start,page.getPageSize());
		for(GoodsSKU goodsSKU : page.getResult()){
			ContractGoodsSave contractGoodsSave = new ContractGoodsSave();
			Goods goods = goodsService.findById(goodsSKU.getGoodsId());
			Category category = categoryService.findById(goods.getCategoryId());
			contractGoodsSave.setGoods(goods);
			contractGoodsSave.setGoodsSku(goodsSKU);
			contractGoodsSave.setCategory(category);
			list.add(contractGoodsSave);
		}
		ObjectMapper mapper = new ObjectMapper();
		String ret = "";
		try {
			ret = mapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	/**
	 * 添加定制需求商品
	 * 
	 * @param request
	 * @param response
	 * @param attr
	 * @return
	 */
	@RequestMapping("/saveCustomGoods")
	public String saveContractGoods(HttpServletRequest request,HttpServletResponse response,RedirectAttributes attr){
		
		String[] goodsSkuId = request.getParameterValues("goodsSkuId");
		String orderNo = request.getParameter("orderNo");
//		BaseOrder baseOrder = baseOrderService.findByOrderNo(orderNo);
		
		OrderCustomDemand orderCustomDemand = new OrderCustomDemand();
		orderCustomDemand.setOrderNo(orderNo);
		orderCustomDemand.setIsDel(false);
		List<OrderCustomDemand> l = orderCustomDemandService.queryByCondition(orderCustomDemand);
		if(l.size()>0){
			Long orderCustomDemandId = l.get(0).getId();
			
			for(int i = 0;i < goodsSkuId.length; i++){
				if(StringUtils.isNotBlank(goodsSkuId[i])){
					System.out.println(goodsSkuId[i]);
					
					GoodsSKU goodsSku = goodsSKUService.findById(Long.parseLong(goodsSkuId[i]));
					Goods goods = goodsService.findById(goodsSku.getGoodsId());
					OrderCustomGoods orderCustomGoods = new OrderCustomGoods();
					orderCustomGoods.setGoodsSkuId(Long.parseLong(goodsSkuId[i]));
					orderCustomGoods.setGoodsName(goods.getName());
					orderCustomGoods.setAttributeIds(goodsSku.getAttributeIds());
					orderCustomGoods.setAttributeNames(goodsSku.getAttributeNames());
					orderCustomGoods.setAttributeValueIds(goodsSku.getAttributeValueIds());
					orderCustomGoods.setAttributeValueNames(goodsSku.getAttributeValueNames());
					orderCustomGoods.setOrderCustomDemandId(orderCustomDemandId);
					orderCustomGoodsService.save(orderCustomGoods);
				}
			}
			attr.addAttribute("orderCustomDemandId", orderCustomDemandId);
		}
		
		attr.addAttribute("orderNo", orderNo);
		
		return "redirect:/orderAccept/showOrderInfo";
	}

}
