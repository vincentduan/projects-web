package com.efubao.core.admin.controller.sp;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
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

import com.efubao.common.util.Page;
import com.efubao.core.admin.domain.Category;
import com.efubao.core.admin.service.CategoryService;
import com.efubao.core.admin.utils.CheckstatusEnum;
import com.efubao.core.admin.vo.SpContractVo;
import com.efubao.core.sp.domain.ServiceProvider;
import com.efubao.core.sp.domain.SpCategoryRelation;
import com.efubao.core.sp.domain.SpContract;
import com.efubao.core.sp.service.ServiceProviderService;
import com.efubao.core.sp.service.SpContractService;

@Controller
@RequestMapping(value = { "/spcontract" })
public class SpContractController {

	private static final Logger logger = LoggerFactory.getLogger(SpContractController.class);

	@Autowired
	private SpContractService spContractService;
	@Autowired
	private ServiceProviderService serviceProviderService;
	@Autowired
	private CategoryService categoryService;

	/**
	 * 合同列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/spcontractList", method = RequestMethod.GET)
	public String spcontractList(HttpServletRequest request, HttpServletResponse response) {
		Page<SpContract> page = new Page<SpContract>();
		page.setPageSize(10);
		// spContractService.queryAllByPage(page, new SpContract());
		try {
			spContractService.queryByPage(page, new SpContract());
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<SpContract> spContractList = page.getResult();
		List<SpContractVo> listvo = new LinkedList<SpContractVo>();
		for (SpContract temp : spContractList) {
			SpContractVo spContractVo = new SpContractVo();
			spContractVo.setId(temp.getId());
			spContractVo.setContractNum(temp.getContractNum());
			spContractVo.setContractName(temp.getContractName());
			spContractVo.setCreateTime(temp.getCreateTime());
			spContractVo.setCheck_status_label(CheckstatusEnum.getName(temp.getCheckStatus() + ""));
			// spContractVo.setSpName(serviceProviderService.findById(temp.getSpId()).getName());
			Long Spid = temp.getSpId();
			ServiceProvider serviceProvider = serviceProviderService.findById(Spid);
			spContractVo.setSpName(serviceProvider.getName());
			spContractVo.setStatus(temp.getStatus());
			listvo.add(spContractVo);
		}
		request.setAttribute("spContractList", listvo);
		return "sp/spcontract_list";
	}

	/**
	 * 合同添加GET
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/spcontractadd", method = RequestMethod.GET)
	public String spcontractAdd_view(HttpServletRequest request, HttpServletResponse response) {
		String spid = request.getParameter("id");
		ServiceProvider serviceProvider = null;
		if (StringUtils.isNotBlank(spid)) {
			Long id = Long.parseLong(spid);
			serviceProvider = serviceProviderService.findById(id);
			request.setAttribute("isServiceProvider", 1);
			request.setAttribute("serviceProvider", serviceProvider);
		}
		Category category = new Category();
		category.setParentId((long) 0);
		List<Category> li = categoryService.queryByCondition(category);
		List<ServiceProvider> list = serviceProviderService.queryByCondition(new ServiceProvider());
		request.setAttribute("list", list);
		request.setAttribute("category", li);
		return "sp/spcontract_add";
	}

	/**
	 * 合同添加POST
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value = "/spcontractadd", method = RequestMethod.POST)
	public String spcontractAdd(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String hidden_id = request.getParameter("hidden_id");
		String select_id = request.getParameter("spName");
		Long spid = null;
		if (StringUtils.isNotBlank(hidden_id)) {
			spid = Long.parseLong(hidden_id);
		}
		if (StringUtils.isNotBlank(select_id)) {
			spid = Long.parseLong(select_id);
		}
		String contractName = request.getParameter("contractName");
		String contractNum = request.getParameter("contractNum");
		String commissionPercent = request.getParameter("commissionPercent");
		String prepaymentPercent = request.getParameter("prepaymentPercent");
		String creditDepositPercent = request.getParameter("creditDepositPercent");
		String qualityDepositPercent = request.getParameter("qualityDepositPercent");
		String serviceFee = request.getParameter("serviceFee");

		String sp_category = request.getParameter("sp_category");
		String invoice = request.getParameter("invoice");
		SpContract spContract = new SpContract();
		spContract.setContractName(contractName);
		spContract.setContractNum(contractNum);
		spContract.setInvoiceType(invoice);
		spContract.setSpId(spid);
		spContract.setCheckStatus(2);// 审核通过
		spContract.setStatus(1);// 合作

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date validStartDate = sdf.parse(request.getParameter("validStartDate"));
		java.util.Date validEndDate = sdf.parse(request.getParameter("validEndDate"));
		// String validStartDate = request.getParameter("validStartDate");
		// String validEndDate = request.getParameter("validEndDate");
		try {
			spContract.setCommissionPercent(new BigDecimal(Double.parseDouble(commissionPercent) / 100 + ""));
			spContract.setPrepaymentPercent(new BigDecimal(Double.parseDouble(prepaymentPercent) / 100 + ""));
			spContract.setCreditDepositPercent(new BigDecimal(Double.parseDouble(creditDepositPercent) / 100 + ""));
			spContract.setQualityDepositPercent(new BigDecimal(Double.parseDouble(qualityDepositPercent) / 100 + ""));
			spContract.setServiceFee(new BigDecimal(Double.parseDouble(serviceFee) + ""));
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return "redirect:/spcontract/spcontract_list";
		}
		spContract.setValidStartDate(validStartDate);
		spContract.setValidEndDate(validEndDate);
		spContract.setIsDel(false);
		spContractService.save(spContract);
		/**** 服务商，经营品类 ****/
		/************** 需要获取spContractService.save(spContract)的主键id然后保存到SpCategoryRelation表中 *****************/
		// SpCategoryRelation categoryRelation = new SpCategoryRelation();
		// if (StringUtils.isNotBlank(sp_category)) {
		// categoryRelation.setCategoryId(Long.parseLong(sp_category));
		// categoryRelation.setSpContractId(spContractId);
		// }

		return "redirect:/spcontract/spcontractList";
	}

	/**
	 * 合同详情
	 */
	@RequestMapping(value = "/spcontractDetail", method = RequestMethod.GET)
	public String spcontractDetail(HttpServletRequest request, HttpServletResponse response) {
		Long id = Long.parseLong(request.getParameter("id"));
		SpContract spContract = spContractService.findById(id);
		SpContractVo spContractVo = new SpContractVo();
		ServiceProvider serviceProvider = serviceProviderService.findById(spContract.getSpId());
		spContractVo.setSpName(serviceProvider.getName());
		spContractVo.setContractName(spContract.getContractName());
		spContractVo.setContractNum(spContract.getContractNum());
		spContractVo.setValidStartDate(spContract.getValidStartDate());
		spContractVo.setValidEndDate(spContract.getValidEndDate());
		List<SpCategoryRelation> list = spContractService.getSpCategoryRelationList(id);
		List<Category> cat = new LinkedList<>();
		for (SpCategoryRelation temp : list) {
			Category c = categoryService.findById(temp.getCategoryId());
			cat.add(c);
			while (c.getParentId() != 0) {
				cat.add(categoryService.findById(c.getParentId()));
				c = categoryService.findById(c.getParentId());
			}
		}
		Collections.reverse(cat);
		spContractVo.setCategory(cat);
		spContractVo.setInvoiceType(spContract.getInvoiceType());
		spContractVo.setCommissionPercent(spContract.getCommissionPercent());
		spContractVo.setPrepaymentPercent(spContract.getPrepaymentPercent());
		spContractVo.setQualityDepositPercent(spContract.getQualityDepositPercent());
		spContractVo.setCreditDepositPercent(spContract.getCreditDepositPercent());
		spContractVo.setServiceFee(spContract.getServiceFee());
		request.setAttribute("spContractVo", spContractVo);
		return "sp/spcontract_detail";
	}
}
