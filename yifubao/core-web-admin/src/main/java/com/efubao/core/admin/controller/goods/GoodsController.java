package com.efubao.core.admin.controller.goods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.efubao.common.util.Page;
import com.efubao.core.admin.domain.Category;
import com.efubao.core.admin.domain.Goods;
import com.efubao.core.admin.domain.GoodsDesc;
import com.efubao.core.admin.domain.GoodsPic;
import com.efubao.core.admin.domain.GoodsProperty;
import com.efubao.core.admin.domain.GoodsPropertyValue;
import com.efubao.core.admin.domain.GoodsSKU;
import com.efubao.core.admin.service.CategoryService;
import com.efubao.core.admin.service.GoodsDescService;
import com.efubao.core.admin.service.GoodsPicService;
import com.efubao.core.admin.service.GoodsPropertyService;
import com.efubao.core.admin.service.GoodsPropertyValueService;
import com.efubao.core.admin.service.GoodsSKUService;
import com.efubao.core.admin.service.GoodsService;
import com.efubao.core.admin.vo.GoodsInfo;
import com.efubao.core.admin.vo.GoodsSKUAttribute;
import com.efubao.core.admin.vo.GoodsSKUAttributeValue;
import com.efubao.core.sp.domain.ServiceProvider;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping(value = { "/goods" })
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
	@Autowired
	private CategoryService categoryServcie;

	/**
	 * 商品信息列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/goodsList")
	public String goodsList(HttpServletRequest request,
			HttpServletResponse response) {
		// 处理分页
		Integer pageNo = Integer
				.parseInt(StringUtils.isNotBlank(request.getParameter("pageNo"))
						&& StringUtils.isNumeric(request.getParameter("pageNo")) ? request
						.getParameter("pageNo") : "1");
		Page<Goods> page = new Page<Goods>();
		page.setPageSize(10);
		page.setPageNo(pageNo);

		// 查询商品, 所有参数都不存在时，为获取列表，否则为搜索
		// 搜索时，若所有参数都为空时，返回空集
		Goods goodsTmp = new Goods();
		String name = request.getParameter("name");
		String categoryId = request.getParameter("categoryId");
		String status = request.getParameter("status");
		if (name != null || categoryId != null || status != null) {
			if (StringUtils.isEmpty(name) && StringUtils.isEmpty(categoryId)
					&& StringUtils.isEmpty(status)) {
				goodsTmp.setStatus(-1);
			} else {
				if (StringUtils.isNotEmpty(name)) {
					goodsTmp.setName(name);
				}
				if (StringUtils.isNotBlank(categoryId)) {
					goodsTmp.setCategoryId(Long.parseLong(categoryId));
				}
				if (StringUtils.isNotBlank(status)) {
					goodsTmp.setStatus(Integer.parseInt(status));
				}
			}
		}
		goodsTmp.setIsDel(false);
		goodsService.queryByPage(page, goodsTmp);
		List<Goods> items = page.getResult();

		// 分页跳转链接
		String url = "goods/goodsList?";
		if (name != null) {
			url += "name=" + name + "&";
		}
		if (status != null) {
			url += "status=" + status + "&";
		}
		if (categoryId != null) {
			url += "categoryId=" + categoryId + "&";
		}

		request.setAttribute("page", page);
		request.setAttribute("items", items);
		request.setAttribute("categorys",
				categoryService.queryAllActiveCategory());
		request.setAttribute("url", url);
		return "goods/goods_list";
	}

	/**
	 * 商品删除
	 * 
	 * @param request
	 * @param response
	 * @param goods
	 * @return
	 * @author duandingyang
	 */
	@RequestMapping(value = "/goodsDel", method = RequestMethod.GET)
	public String goodsDel(@RequestParam("id") String id,
			HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes attr) {
		// 处理分页
		Integer pageNo = Integer
				.parseInt(StringUtils.isNotBlank(request.getParameter("pageNo"))
						&& StringUtils.isNumeric(request.getParameter("pageNo")) ? request
						.getParameter("pageNo") : "1");
		Page<Goods> page = new Page<Goods>();
		page.setPageSize(10);
		page.setPageNo(pageNo);

		// 删除商品
		if (StringUtils.isNotBlank(id) && StringUtils.isNumeric(id)) {
			Goods goods = new Goods();
			goods.setId(Long.parseLong(id));
			goods.setIsDel(true);
			goodsService.update(goods);
		} else {
			// 报错
		}

		// 保持当前页
		String name = request.getParameter("name");
		String status = request.getParameter("status");
		String categoryId = request.getParameter("categoryId");
		if (name != null) {
			attr.addAttribute("name", name);
		}
		if (status != null) {
			attr.addAttribute("status", status);
		}
		if (categoryId != null) {
			attr.addAttribute("categoryId", categoryId);
		}
		attr.addAttribute("pageNo", pageNo);
		return "redirect:/goods/goodsList";
	}

	/**
	 * 商品状态变更
	 * 
	 * @param request
	 * @param response
	 * @param goods
	 * @return
	 * @author duandingyang
	 */
	@RequestMapping("/changeStatus")
	public String changeStatus(@RequestParam("id") String id,
			HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes attr) {
		// 处理分页
		Integer pageNo = Integer
				.parseInt(StringUtils.isNotBlank(request.getParameter("pageNo"))
						&& StringUtils.isNumeric(request.getParameter("pageNo")) ? request
						.getParameter("pageNo") : "1");
		Page<Goods> page = new Page<Goods>();
		page.setPageSize(10);
		page.setPageNo(pageNo);

		// 变更商品状态
		if (StringUtils.isNotBlank(id) && StringUtils.isNumeric(id)) {
			String toStatus = request.getParameter("toStatus");
			if (StringUtils.isNotBlank(toStatus)
					&& StringUtils.isNumeric(toStatus)) {
				Goods goods = new Goods();
				goods.setId(Long.parseLong(id));
				goods.setStatus(Integer.parseInt(toStatus));
				goodsService.update(goods);
			}
		} else {
			// 报错
		}

		// 保持当前页
		String name = request.getParameter("name");
		String status = request.getParameter("status");
		String categoryId = request.getParameter("categoryId");
		if (name != null) {
			attr.addAttribute("name", name);
		}
		if (status != null) {
			attr.addAttribute("status", status);
		}
		if (categoryId != null) {
			attr.addAttribute("categoryId", categoryId);
		}
		attr.addAttribute("pageNo", pageNo);
		return "redirect:/goods/goodsList";
	}

	/**
	 * 商品详情
	 */
	@RequestMapping(value = "/goodsDetail", method = RequestMethod.GET)
	public String goodsDetail(@RequestParam("id") String id,
			HttpServletRequest request, HttpServletResponse response) {
		if (StringUtils.isNotBlank(id) && StringUtils.isNumeric(id)) {
			Goods goods = goodsService.findById(Long.parseLong(id));
			if (goods != null) {
				// 获得商品属性
				GoodsSKU goodsSKU = new GoodsSKU();
				goodsSKU.setGoodsId(goods.getId());
				goodsSKU.setIsDel(false);
				List<GoodsSKU> goodsSKUs = goodsSKUService
						.queryByCondition(goodsSKU);
				List<GoodsSKUAttribute> attrs = new ArrayList<GoodsSKUAttribute>();
				if (!goodsSKUs.isEmpty()) {
					GoodsSKU goodsSKUTmp = goodsSKUs.get(0);
					String[] attrNames = goodsSKUTmp.getAttributeNames().split(
							",");
					String[] attrIds = goodsSKUTmp.getAttributeIds().split(",");
					for (int i = 0; i < attrIds.length; i++) {
						GoodsSKUAttribute attr = new GoodsSKUAttribute();
						attr.setId(Long.parseLong(attrIds[i]));
						attr.setName(attrNames[i]);
						List<GoodsSKUAttributeValue> attrValues = new ArrayList<GoodsSKUAttributeValue>();
						for (GoodsSKU gSKU : goodsSKUs) {
							Long tmp = Long.parseLong(gSKU
									.getAttributeValueIds().split(",")[i]);
							boolean flag = true;
							for (GoodsSKUAttributeValue attrValueTmp : attrValues) {
								if (attrValueTmp.getId() == tmp) {
									flag = false;
								}
							}
							if (flag) {
								GoodsSKUAttributeValue attrValue = new GoodsSKUAttributeValue();
								attrValue.setId(tmp);
								attrValue.setName(gSKU.getAttributeValueNames()
										.split(",")[i]);
								if (StringUtils.isNotBlank(gSKU.getImagePath()
										.split(",")[i])) {
									attrValue.setImgPath(gSKU.getImagePath()
											.split(",")[i]);
								}
								attrValues.add(attrValue);
							}
						}
						attr.setAttrValues(attrValues);
						attrs.add(attr);
					}

					ObjectMapper mapper = new ObjectMapper();
					// 获得商品价格
					Map<String, String> pricesMap = new HashMap<String, String>();
					for (GoodsSKU g : goodsSKUs) {
						pricesMap.put(g.getAttributeValueIds(),
								"" + g.getPrice());
					}
					String prices = "";
					try {
						prices = mapper.writeValueAsString(pricesMap);
					} catch (JsonProcessingException e) {
						e.printStackTrace();
					}
					request.setAttribute("prices", prices);
				}

				// 获得商品描述
				GoodsDesc goodsDesc = new GoodsDesc();
				goodsDesc.setGoodsId(goods.getId());
				goodsDesc.setIsDel(false);
				List<GoodsDesc> goodsDescs = goodsDescService
						.queryByCondition(goodsDesc);
				for (GoodsDesc goodsDesc2 : goodsDescs) {
					System.out.println("ds:" + goodsDesc2.getDescription());
				}

				// 获得商品图片
				GoodsPic goodsPic = new GoodsPic();
				goodsPic.setGoodsId(goods.getId());
				goodsPic.setIsDel(false);
				List<GoodsPic> goodsPics = goodsPicService
						.queryByCondition(goodsPic);
				request.setAttribute("SKUS", goodsSKUs);
				request.setAttribute("goods", goods);
				request.setAttribute("parentCategorys", categoryService
						.queryParentCategory(goods.getCategoryId()));
				request.setAttribute("attrs", attrs);
				request.setAttribute("goodsDescs", goodsDescs);
				request.setAttribute("goodsPics", goodsPics);
			}
		} else {
			// 报错
		}
		return "goods/goods_detail";
	}

	// @RequestMapping(value = "/goodsUpd", method = RequestMethod.POST)
	// public String goodsUpd(HttpServletRequest request,
	// HttpServletResponse response) {
	// String summary = request.getParameter("content");
	// Long id = Long.parseLong(request.getParameter("id"));
	// Goods good = goodsService.findById(id);
	// good.setSummary(summary);
	// goodsService.update(good);
	// return "redirect:/goods/goodsList";
	// }

	@RequestMapping("/toAdd")
	public String goodsAdd(HttpServletRequest request,
			HttpServletResponse response) {
		Category category = new Category();
		Long parentId = Long
				.parseLong(StringUtils.isNotBlank(request
						.getParameter("parentId"))
						&& StringUtils.isNumeric(request
								.getParameter("parentId")) ? request
						.getParameter("parentId") : "0");
		category.setParentId(parentId);
		category.setIsDel(false);
		List<Category> lists = categoryServcie.queryByCondition(category);
		request.setAttribute("categorys", lists);
		return "goods/add_goods";
	}
	/*
	 * 
	 */
	@RequestMapping("/addGoods")
	public String addGoods(String name, String[] price, String[] attributeIds,
			String[] attributeNames, String[] attributeValueIds,
			String[] attributeValueNames, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("name:"+name);
		for (int i = 0; i < attributeIds.length; i++) {
			System.out.println("attr:"+attributeNames[i]+",value:"+attributeValueNames[i]+",price:"+price[i]);
		}
		return "redirect:/goods/toAdd";
	}
}
