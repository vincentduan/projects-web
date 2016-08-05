package com.efubao.core.sp.controller.order;

import java.math.BigDecimal;
import java.util.ArrayList;
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
import com.efubao.core.order.domain.BaseOrder;
import com.efubao.core.order.domain.OrderContract;
import com.efubao.core.order.domain.OrderContractGoods;
import com.efubao.core.order.domain.OrderCustomGoods;
import com.efubao.core.order.service.BaseOrderService;
import com.efubao.core.order.service.OrderContractGoodsService;
import com.efubao.core.order.service.OrderContractService;
import com.efubao.core.order.service.GenerateSerialNumberService.SerialNumberEnum;
import com.efubao.core.sp.domain.SpContract;
import com.efubao.core.sp.service.SpContractService;
import com.efubao.core.sp.vo.ContractGoodsSave;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.AMQP.Access.Request;

@Controller
@RequestMapping("/contract")
public class InputContract {
	private static final Logger logger = LoggerFactory
			.getLogger(InputContract.class);
	
	@Autowired
	public SpContractService spContractService;
	@Autowired
	public CategoryService categoryService;
	@Autowired
	public GoodsSKUService goodsSKUService;
	@Autowired
	public GoodsService goodsService;
	@Autowired
	public OrderContractGoodsService orderContractGoodsService;
	@Autowired
	public OrderContractService orderContractService;
	@Autowired
	private BaseOrderService baseOrderService;

	/**
	 * 进入录合同页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/entry", method = RequestMethod.GET)
	public String contract(HttpServletRequest request,HttpServletResponse response){
		String spId = "4";
		//获取商家和平台的合同
		String orderContractId = request.getParameter("orderContractId");
		String orderNo = request.getParameter("orderNo");
//		String spId = request.getParameter("spId");
		SpContract spContract = new SpContract();
		spContract.setSpId(Long.parseLong(spId));
		spContract.setIsDel(false);
		List<SpContract> list = spContractService.queryByCondition(spContract);
		if(list.size()>0){
			request.setAttribute("spContract", list.get(0));
		}
		BigDecimal bd = new BigDecimal(1);
		BigDecimal finalMoney = bd.subtract(list.get(0).getCreditDepositPercent());
		request.setAttribute("finalMoney", finalMoney);
//		System.out.println(list.get(0).getCreditDepositPercent());
		//获取商品类别
		Category categoryTmp = new Category();
		categoryTmp.setIsDel(false);
		categoryTmp.setStatus(1);
		List<Category> categorys = categoryService.queryByCondition(categoryTmp);
    	request.setAttribute("categorys", categorys);
    	//获取合同订单商品列
    	if(StringUtils.isNotBlank(orderContractId)){
    		OrderContractGoods orderContractGoods = new OrderContractGoods();
    		orderContractGoods.setOrderContractId(Long.parseLong(orderContractId));
    		List<OrderContractGoods> listCgoods = orderContractGoodsService.queryByCondition(orderContractGoods);
    		request.setAttribute("listCgoods", listCgoods);
    		request.setAttribute("orderContractId", orderContractId);
    	}
    	request.setAttribute("orderNo", orderNo);
		return "/order/input_contract";
	}
	/**
	 * 添加订单合同
	 * 
	 * @param request
	 * @param response
	 * @param orderCustomGoods
	 * @return
	 */
	@RequestMapping(value="/entry", method = RequestMethod.POST)
	public String inputOrderContract(HttpServletRequest request,HttpServletResponse response,
			RedirectAttributes attr,@ModelAttribute OrderContract orderContract){
		String orderContractId = request.getParameter("orderContractId");
		String orderNo = request.getParameter("orderNo");
		if(StringUtils.isNotBlank(orderContractId)){
    		OrderContractGoods orderContractGoods = new OrderContractGoods();
    		orderContractGoods.setOrderContractId(Long.parseLong(orderContractId));
    		List<OrderContractGoods> listCgoods = orderContractGoodsService.queryByCondition(orderContractGoods);
    		for(OrderContractGoods ocg : listCgoods){
    			String price = request.getParameter(ocg.getId()+"_price");
        		String num =  request.getParameter(ocg.getId()+"_num");
        		System.out.println(price);
        		ocg.setGoodsPrice(new BigDecimal(price));
        		ocg.setGoodsNum(Integer.parseInt(num));
        		orderContractGoodsService.update(ocg);
    		}
    		orderContract.setId(Long.parseLong(orderContractId));
    		orderContractService.update(orderContract);
    		
    		BaseOrder baseOrder = baseOrderService.findById(Long.parseLong(orderNo));
    		baseOrder.setOrderContractId(Long.parseLong(orderContractId));
    		baseOrder.setStatus(130);
    		if(orderContract.getBalancePayment()!=null){
    			baseOrder.setBalancePayment(orderContract.getBalancePayment());
    		}
    		baseOrderService.update(baseOrder);
    		
    		attr.addAttribute("orderNo", orderNo);
    		attr.addAttribute("orderContractId", orderContractId);
    		return "redirect:/pay/payFirst";
    	}
		return "/order/input_contract";
	}
	
	/**
	 * 添加合同商品
	 * 
	 * @param request
	 * @param response
	 * @param attr
	 * @return
	 */
	@RequestMapping("/saveContractGoods")
	public String saveContractGoods(HttpServletRequest request,HttpServletResponse response,RedirectAttributes attr){
		String[] goodsSkuId = request.getParameterValues("goodsSkuId");
		String orderNo = request.getParameter("orderNo");
		OrderContract orderContract = new OrderContract();
		orderContract.setSpId((long)4);
		orderContractService.save(orderContract);
		Long orderContractId = orderContract.getId();
		for(int i = 0;i < goodsSkuId.length; i++){
			if(StringUtils.isNotBlank(goodsSkuId[i])){
				System.out.println(goodsSkuId[i]);
				
				GoodsSKU goodsSku = goodsSKUService.findById(Long.parseLong(goodsSkuId[i]));
				Goods goods = goodsService.findById(goodsSku.getGoodsId());
				OrderContractGoods orderContractGoods = new OrderContractGoods();
				orderContractGoods.setGoodsSkuId(Long.parseLong(goodsSkuId[i]));
				orderContractGoods.setGoodsName(goods.getName());
				orderContractGoods.setGoodsPrice(goods.getMinPrice());
				orderContractGoods.setAttributeIds(goodsSku.getAttributeIds());
				orderContractGoods.setAttributeNames(goodsSku.getAttributeNames());
				orderContractGoods.setAttributeValueIds(goodsSku.getAttributeValueIds());
				orderContractGoods.setAttributeValueNames(goodsSku.getAttributeValueNames());
				orderContractGoods.setOrderContractId(orderContractId);
				orderContractGoodsService.save(orderContractGoods);
			}
		}
		attr.addAttribute("orderNo", orderNo);
		attr.addAttribute("orderContractId", orderContractId);
		return "redirect:/contract/entry";
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
	public List<ContractGoodsSave> searchGoods(HttpServletRequest request,HttpServletResponse response){
		
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
		logger.info("List<ContractGoodsSave>"+page.getResult());
		for(GoodsSKU goodsSKU : page.getResult()){
			ContractGoodsSave contractGoodsSave = new ContractGoodsSave();
			Goods goods = goodsService.findById(goodsSKU.getGoodsId());
			Category category = categoryService.findById(goods.getCategoryId());
			contractGoodsSave.setGoods(goods);
			contractGoodsSave.setGoodsSku(goodsSKU);
			contractGoodsSave.setCategory(category);
			list.add(contractGoodsSave);
		}
		return list;
	}
	
	
}
