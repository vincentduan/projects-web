package com.efubao.core.admin.controller.goods;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.efubao.core.admin.domain.Property;
import com.efubao.core.admin.domain.PropertyValue;
import com.efubao.core.admin.service.PropertyService;
import com.efubao.core.admin.service.PropertyValueService;

@Controller
@RequestMapping("/property")
public class PropertyController {

	private static final Logger logger = LoggerFactory
			.getLogger(PropertyController.class);

	@Autowired
	private PropertyService propertyService;

	@Autowired
	private PropertyValueService propertyValueService;

	/**
	 * 获取属性列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/propertyList")
	public String propertyList(HttpServletRequest request,
			HttpServletResponse response) {
		Property property = new Property();
		property.setIsDel(false);
		List<Property> lists = propertyService.queryByCondition(property);
		request.setAttribute("items", lists);
		return "property/propertyList";
	}

	/**
	 * 增加属性
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/addProperty")
	public String addProperty(HttpServletRequest request,
			HttpServletResponse response) {
		Property record = new Property();
		record.setName(request.getParameter("name"));
		boolean isSale = StringUtils.isNotBlank(request.getParameter("isSale"))
				&& "1".equals(request.getParameter("isSale")) ? true : false;
		record.setIsSale(isSale);
		Integer sort = Integer
				.parseInt(StringUtils.isNotBlank(request.getParameter("sort"))
						&& StringUtils.isNumeric(request.getParameter("sort")) ? request
						.getParameter("sort") : "1");
		record.setSort(sort);
		propertyService.save(record);
		return "redirect:/property/propertyList";
	}

	/**
	 * 搜索
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/search")
	public String search(HttpServletRequest request,
			HttpServletResponse response) {
		Property property = new Property();
		property.setName(request.getParameter("name"));
		String status = request.getParameter("status");
		if (StringUtils.isNotBlank(status) && StringUtils.isNumeric(status)) {
			property.setStatus(Integer.parseInt(status));
		}
		property.setIsDel(false);
		List<Property> lists = propertyService.queryByCondition(property);
		request.setAttribute("items", lists);
		return "property/propertyList";
	}

	/**
	 * 停用/启用属性
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/changeStatus")
	public String changeStatus(@RequestParam("id") String id,
			HttpServletRequest request,
			HttpServletResponse response) {
		Property property = new Property();
		if (StringUtils.isNotBlank(id) && StringUtils.isNumeric(id)) {
			property.setId(Long.parseLong(id));
		}else{
			//报错
		}
		String status = request.getParameter("status");
		if (StringUtils.isNotBlank(status) && StringUtils.isNumeric(status)) {
			property.setStatus(Integer.parseInt(status));
		}
		propertyService.update(property);
		return "redirect:/property/propertyList";
	}

	/**
	 * 删除属性
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam("id") String id,
			HttpServletRequest request, HttpServletResponse response) {
		if (StringUtils.isNotBlank(id) && StringUtils.isNumeric(id)) {
			Property property = new Property();
			property.setId(Long.parseLong(id));
			property.setIsDel(true);
			propertyService.update(property);
		}else{
			//报错
		}
		return "redirect:/property/propertyList";
	}

	/**
	 * 根据某个属性得出属性值列表
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/propertyValueList")
	public String propertyValueList(@RequestParam("id") String id,
			HttpServletRequest request, HttpServletResponse response) {
		if (StringUtils.isNotBlank(id) && StringUtils.isNumeric(id)) {
			PropertyValue propertyValue = new PropertyValue();
			propertyValue.setPropertyId(Long.parseLong(id));
			propertyValue.setIsDel(false);
			List<PropertyValue> lists = propertyValueService
					.queryByCondition(propertyValue);
			Property property = propertyService.findById(Long.parseLong(id));
			request.setAttribute("property", property);
			request.setAttribute("items", lists);
		}else{
			//报错
		}
		return "property/propertyValueList";
	}

	/**
	 * 增加属性值
	 *
	 * @param request
	 * @param response
	 * @param attr
	 * @return
	 */
	@RequestMapping("/addPropertyValue")
	public String addPropertyValue(@RequestParam("id") String id, HttpServletRequest request,
			HttpServletResponse response, RedirectAttributes attr) {
		if (StringUtils.isNotBlank(id) && StringUtils.isNumeric(id)) {
			PropertyValue propertyValue = new PropertyValue();
			propertyValue.setName(request.getParameter("name"));
			propertyValue.setPropertyId(Long.parseLong(id));
			Integer sort = Integer
					.parseInt(StringUtils.isNotBlank(request.getParameter("sort"))
							&& StringUtils.isNumeric(request.getParameter("sort")) ? request
							.getParameter("sort") : "1");
			propertyValue.setSort(sort);
			propertyValueService.save(propertyValue);
		}else{
			//报错
		}
		attr.addAttribute("id", id);
		return "redirect:/property/propertyValueList";
	}

	/**
	 * 停用/启用属性值
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/changeValueStatus")
	public String changeValueStatus(@RequestParam("valueId") String valueId, HttpServletRequest request,
			HttpServletResponse response, RedirectAttributes attr) {
		PropertyValue propertyValue = new PropertyValue();
		if (StringUtils.isNotBlank(valueId) && StringUtils.isNumeric(valueId)) {
			propertyValue.setId(Long.parseLong(valueId));
		}else{
			//报错
		}
		String status = request.getParameter("status");
		if (StringUtils.isNotBlank(status) && StringUtils.isNumeric(status)) {
			propertyValue.setStatus(Integer.parseInt(status));
		}
		propertyValueService.update(propertyValue);
		attr.addAttribute("id", request.getParameter("id"));
		return "redirect:/property/propertyValueList";
	}

	/**
	 * 删除属性值
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/deleteValue")
	public String deleteValue(@RequestParam("valueId") String valueId,
			HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes attr) {
		if (StringUtils.isNotBlank(valueId) && StringUtils.isNumeric(valueId)) {
			PropertyValue propertyValue = new PropertyValue();
			propertyValue.setId(Long.parseLong(valueId));
			propertyValue.setIsDel(true);
			propertyValueService.update(propertyValue);
		}else{
			//报错
		}
		attr.addAttribute("id", request.getParameter("id"));
		return "redirect:/property/propertyValueList";
	}

}
