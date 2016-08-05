package com.efubao.core.admin.controller.sp;

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

import com.efubao.common.util.Page;
import com.efubao.core.sp.domain.ServiceProvider;
import com.efubao.core.sp.service.ServiceProviderService;

@Controller
@RequestMapping("/sp")
public class ServiceProviderController {

	private static final Logger logger = LoggerFactory
			.getLogger(ServiceProviderController.class);

	@Autowired
	private ServiceProviderService spService;

	/**
	 * 获取供应商列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/spList")
	public String spList(HttpServletRequest request,
			HttpServletResponse response) {
		Integer pageNo = Integer
				.parseInt(StringUtils.isNotBlank(request.getParameter("pageNo"))
						&& StringUtils.isNumeric(request.getParameter("pageNo")) ? request
						.getParameter("pageNo") : "1");
		Page<ServiceProvider> page = new Page<ServiceProvider>();
		page.setPageSize(10);
		page.setPageNo(pageNo);
		ServiceProvider sp = new ServiceProvider();
		String name = request.getParameter("name");
		sp.setName(name);
		String status = request.getParameter("status");
		if (StringUtils.isNotBlank(status) && StringUtils.isNumeric(status)) {
			sp.setStatus(Integer.parseInt(status));
		}
		String id = request.getParameter("id");
		if (StringUtils.isNotBlank(id) && StringUtils.isNumeric(id)) {
			sp.setId(Long.parseLong(id));
		}
		sp.setIsDel(false);
		spService.queryByPage(page, sp);
		List<ServiceProvider> lists = page.getResult();
		request.setAttribute("page", page);
		String url = "sp/spList?";
		if (name != null) {
			url += "name=" + name + "&";
		}
		if (status != null) {
			url += "status=" + status + "&";
		}
		if (id != null) {
			url += "id=" + id + "&";
		}
		request.setAttribute("url", url);
		request.setAttribute("items", lists);
		return "sp/sp_list";
	}

	/**
	 * 开通账户
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/linkAccount")
	public String linkAccount(@RequestParam("id") String id,
			@RequestParam("phoneNum") String phoneNum,
			HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes attr) {
		Integer pageNo = Integer
				.parseInt(StringUtils.isNotBlank(request.getParameter("pageNo"))
						&& StringUtils.isNumeric(request.getParameter("pageNo")) ? request
						.getParameter("pageNo") : "1");
		if (StringUtils.isNotBlank(phoneNum) && StringUtils.isNumeric(phoneNum)) {
			// 关联账户
			System.out.println("phoneNum:" + phoneNum);
		} else {
			// 报错
		}
		ServiceProvider sp = new ServiceProvider();
		if (StringUtils.isNotBlank(id) && StringUtils.isNumeric(id)) {
			sp.setId(Long.parseLong(id));
		} else {
			// 报错
		}
		sp.setStatus(2);
		spService.update(sp);
		attr.addAttribute("pageNo", pageNo);
		return "redirect:/sp/spList";
	}

	/**
	 * 变更状态
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/changeStatus")
	public String changeStatus(@RequestParam("id") String id,
			HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes attr) {
		Integer pageNo = Integer
				.parseInt(StringUtils.isNotBlank(request.getParameter("pageNo"))
						&& StringUtils.isNumeric(request.getParameter("pageNo")) ? request
						.getParameter("pageNo") : "1");
		ServiceProvider sp = new ServiceProvider();
		if (StringUtils.isNotBlank(id) && StringUtils.isNumeric(id)) {
			sp.setId(Long.parseLong(id));
		} else {
			// 报错
		}
		String status = request.getParameter("status");
		if (StringUtils.isNotBlank(status) && StringUtils.isNumeric(status)) {
			sp.setStatus(Integer.parseInt(status));
		}
		spService.update(sp);
		attr.addAttribute("pageNo", pageNo);
		return "redirect:/sp/spList";
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
			HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes attr) {
		Integer pageNo = Integer
				.parseInt(StringUtils.isNotBlank(request.getParameter("pageNo"))
						&& StringUtils.isNumeric(request.getParameter("pageNo")) ? request
						.getParameter("pageNo") : "1");
		if (StringUtils.isNotBlank(id) && StringUtils.isNumeric(id)) {
			ServiceProvider sp = new ServiceProvider();
			sp.setId(Long.parseLong(id));
			sp.setIsDel(true);
			spService.update(sp);
		} else {
			// 报错
		}
		attr.addAttribute("pageNo", pageNo);
		return "redirect:/sp/spList";
	}

	/**
	 * 增加供应商（页面）
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/addSp")
	public String addSp(HttpServletRequest request, HttpServletResponse response) {
		return "/sp/add_sp";
	}

	/**
	 * 增加供应商（提交）
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/addSpSubmit")
	public String addSpSubmit(HttpServletRequest request, HttpServletResponse response) {

		String[] names = { "文昌服装有限公司", "韩美服装有限公司", "耐得服装有限公司", "海绿服装有限公司",
				"德茂服装有限公司", "凯苏服装有限公司" };
		for (String string : names) {
			ServiceProvider sp = new ServiceProvider();
			sp.setCreatorId((long) 1);
			sp.setUpdator((long) 1);
			sp.setName(string);
			spService.save(sp);
		}
		return "redirect:/sp/spList";
	}

}
