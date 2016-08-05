package com.efubao.core.bigc.controller.goods;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestMapping;

import com.efubao.common.util.Page;
import com.efubao.core.admin.domain.Category;
import com.efubao.core.admin.domain.Goods;
import com.efubao.core.admin.domain.GoodsDesc;
import com.efubao.core.admin.domain.GoodsPic;
import com.efubao.core.admin.domain.GoodsSKU;
import com.efubao.core.admin.service.CategoryService;
import com.efubao.core.admin.service.GoodsDescService;
import com.efubao.core.admin.service.GoodsPicService;
import com.efubao.core.admin.service.GoodsSKUService;
import com.efubao.core.admin.service.GoodsService;
import com.efubao.core.bigc.vo.GoodsSKUAttribute;
import com.efubao.core.bigc.vo.GoodsSKUAttributeValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/goods")
public class GoodsController {

	private static final Logger logger = LoggerFactory
			.getLogger(GoodsController.class);

	@Autowired
	private GoodsService goodsService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private GoodsSKUService goodsSKUService;
	@Autowired
	private GoodsDescService goodsDescService;
	@Autowired
	private GoodsPicService goodsPicService;

	/**
	 * 商品信息列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */

	@RequestMapping("/goodsList")
	public String goodsList(HttpServletRequest request,
			HttpServletResponse response) {
		// 处理分页
		Integer pageNo = Integer
				.parseInt(StringUtils.isNotBlank(request.getParameter("pageNo"))
						&& StringUtils.isNumeric(request.getParameter("pageNo")) ? request
						.getParameter("pageNo") : "1");
		Page<Goods> page = new Page<Goods>();
		page.setPageSize(12);
		page.setPageNo(pageNo);

		// 查询商品
		String cid = request.getParameter("categoryId");
		List<Goods> items = new ArrayList<Goods>();
		if (StringUtils.isNotBlank(cid) && StringUtils.isNumeric(cid)) {
			Goods goodsTmp = new Goods();
			goodsTmp.setCategoryId(Long.parseLong(cid));
			goodsTmp.setIsDel(false);
			goodsTmp.setStatus(1);
			goodsService.queryByPage(page, goodsTmp);
			items = page.getResult();
		}

		// 分页跳转链接
		String url = "goods/goodsList?";
		if (StringUtils.isNotBlank(cid) && StringUtils.isNumeric(cid)) {
			request.setAttribute("parentCategorys",
					categoryService.queryParentCategory(Long.parseLong(cid)));
			url += "categoryId=" + cid + "&";
		}
		request.setAttribute("page", page);
		request.setAttribute("items", items);
		request.setAttribute("categorys",
				categoryService.queryAllActiveCategory());
		request.setAttribute("url", url);
		return "goods/goods_list";
	}

	@RequestMapping(value = "/goodsSearch")
	public String goodsSearch(HttpServletRequest request,
			HttpServletResponse response) {
		// 处理分页
		Integer pageNo = Integer
				.parseInt(StringUtils.isNotBlank(request.getParameter("pageNo"))
						&& StringUtils.isNumeric(request.getParameter("pageNo")) ? request
						.getParameter("pageNo") : "1");
		Page<Goods> page = new Page<Goods>();
		page.setPageSize(12);
		page.setPageNo(pageNo);

		// 查询商品
		String name = request.getParameter("name");
		List<Goods> items = new ArrayList<Goods>();
		if (StringUtils.isNotEmpty(name)) {
			Goods goodsTmp = new Goods();
			goodsTmp.setName(name);
			goodsTmp.setIsDel(false);
			goodsTmp.setStatus(1);
			goodsService.queryByPage(page, goodsTmp);
			items = page.getResult();
		}

		// 分页跳转链接
		String url = "goods/goodsSearch?";
		if (StringUtils.isNotEmpty(name)) {
			url += "name=" + name + "&";
		}

		request.setAttribute("page", page);
		request.setAttribute("items", items);
		request.setAttribute("categorys",
				categoryService.queryAllActiveCategory());
		request.setAttribute("url", url);
		return "goods/search_result";
	}

	/**
	 * 商品详情
	 */
	@RequestMapping("/goodsDetail")
	public String goodsDetail(HttpServletRequest request,
			HttpServletResponse response) {
		String goodsId = request.getParameter("goodsId");
		if (StringUtils.isNotBlank(goodsId) && StringUtils.isNumeric(goodsId)) {
			Goods goods = goodsService.findById(Long.parseLong(goodsId));
			if (goods != null) {
				request.setAttribute("goods", goods);
				// 组装左上导航信息
				Category cTmp = new Category();
				cTmp.setName(goods.getName());
				List<Category> parentCategorys = categoryService
						.queryParentCategory(goods.getCategoryId());
				parentCategorys.add(cTmp);
				request.setAttribute("parentCategorys", parentCategorys);
				// 获得商品属性
				GoodsSKU goodsSKU = new GoodsSKU();
				goodsSKU.setGoodsId(goods.getId());
				goodsSKU.setIsDel(false);
				List<GoodsSKU> goodsSKUs = goodsSKUService
						.queryByCondition(goodsSKU);
				List<GoodsSKUAttribute> attrs = new ArrayList<GoodsSKUAttribute>();
				if (!goodsSKUs.isEmpty()) {
					GoodsSKU goodsSKUTmp = goodsSKUs.get(0);
					String[] attrNames = goodsSKUTmp.getAttributeNames().split(",");
					String[] attrIds = goodsSKUTmp.getAttributeIds().split(",");
					for (int i = 0; i < attrIds.length; i++) {
						GoodsSKUAttribute attr = new GoodsSKUAttribute();
						attr.setId(Long.parseLong(attrIds[i]));
						attr.setName(attrNames[i]);
						List<GoodsSKUAttributeValue> attrValues = new ArrayList<GoodsSKUAttributeValue>();
						for (GoodsSKU gSKU : goodsSKUs) {
							Long tmp = Long.parseLong(gSKU.getAttributeValueIds().split(",")[i]);
							boolean flag = true;
							for (GoodsSKUAttributeValue attrValueTmp : attrValues) {
								if (attrValueTmp.getId() == tmp) {
									flag = false;
								}
							}
							if (flag) {
								GoodsSKUAttributeValue attrValue = new GoodsSKUAttributeValue();
								attrValue.setId(tmp);
								attrValue.setName(gSKU.getAttributeValueNames().split(",")[i]);
								if (StringUtils.isNotBlank(gSKU.getImagePath().split(",")[i])){
									attrValue.setImgPath(gSKU.getImagePath().split(",")[i]);
								}
								attrValues.add(attrValue);
							}
						}
						attr.setAttrValues(attrValues);
						attrs.add(attr);
					}
					
					ObjectMapper mapper = new ObjectMapper();
					//获得商品价格
					Map<String, String> pricesMap = new HashMap<String, String>();
					for (GoodsSKU g : goodsSKUs) {
						pricesMap.put(g.getAttributeValueIds(), ""+g.getPrice());
					}
					String prices = "";
					try {
						prices = mapper.writeValueAsString(pricesMap);
					} catch (JsonProcessingException e) {
						e.printStackTrace();
					}
					request.setAttribute("prices", prices);
					
					//获得商品SKU信息
					Map<String, Long> SKUMap = new HashMap<String, Long>();
					for (GoodsSKU g : goodsSKUs) {
						SKUMap.put(g.getAttributeValueIds(), g.getId());
					}
					String SKUS = "";
					try {
						SKUS = mapper.writeValueAsString(SKUMap);
					} catch (JsonProcessingException e) {
						e.printStackTrace();
					}
					request.setAttribute("SKUS", SKUS);
				}
				// 获得商品描述
				GoodsDesc goodsDesc = new GoodsDesc();
				goodsDesc.setGoodsId(goods.getId());
				goodsDesc.setIsDel(false);
				List<GoodsDesc> goodsDescs = goodsDescService
						.queryByCondition(goodsDesc);
				// 获得商品图片
				GoodsPic goodsPic = new GoodsPic();
				goodsPic.setGoodsId(goods.getId());
				goodsPic.setIsDel(false);
				List<GoodsPic> goodsPics = goodsPicService
						.queryByCondition(goodsPic);
				request.setAttribute("goodsDescs", goodsDescs);
				request.setAttribute("goodsPics", goodsPics);
				request.setAttribute("attrs", attrs);
				request.setAttribute("categorys",
						categoryService.queryAllActiveCategory());
				return "goods/goods_detail";
			}
		}
		request.setAttribute("categorys",
				categoryService.queryAllActiveCategory());
		return "goods/goods_list";
	}
}
