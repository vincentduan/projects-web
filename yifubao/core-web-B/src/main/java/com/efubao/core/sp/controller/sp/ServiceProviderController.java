package com.efubao.core.sp.controller.sp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.efubao.core.admin.domain.Category;
import com.efubao.core.sp.controller.service.ServiceProviderCommonService;
import com.efubao.core.sp.domain.ServiceProvider;
import com.efubao.core.sp.domain.SpCertificatePicture;
import com.efubao.core.sp.domain.SpContract;
import com.efubao.core.sp.service.ServiceProviderService;
import com.efubao.core.sp.service.SpCertificatePictureService;
import com.efubao.core.sp.service.SpContractService;
import com.efubao.core.sp.service.SpServiceRangeService;

@Controller
@RequestMapping("/sp")
public class ServiceProviderController {

	private static final Logger logger = LoggerFactory
			.getLogger(ServiceProviderController.class);

	@Autowired
	private ServiceProviderService spService;
	@Autowired
	private SpServiceRangeService spServiceRangeService;
	@Autowired
	private SpCertificatePictureService spCertificatePictureService;
	@Autowired
	private SpContractService spContractService;
	@Autowired
	private ServiceProviderCommonService serviceProviderCommonService;

	/**
	 * 获取供应商信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/spinfo")
	public String spList(HttpServletRequest request,
			HttpServletResponse response) {
		Long spId = (long) 1;
		// 基本信息
		ServiceProvider sp = spService.findById(spId);
		// 服务内容
		List<Category> categorys = serviceProviderCommonService.queryCategorysBySpId(spId);
		// 服务区域
		String spRange = spServiceRangeService.querySpRangeBySpId(spId);
		// 证件图片
		SpCertificatePicture spCPTmp = new SpCertificatePicture();
		spCPTmp.setSpId(spId);
		spCPTmp.setIsDel(false);
		List<SpCertificatePicture> spCPs = spCertificatePictureService
				.queryByCondition(spCPTmp);
		// 合同信息
		SpContract spContract = new SpContract();
		spContract.setSpId(spId);
		spContract.setIsDel(false);
		List<SpContract> spContracts = spContractService
				.queryByCondition(spContract);
		if (!spContracts.isEmpty()) {
			spContract = spContracts.get(0);
		}

		request.setAttribute("sp", sp);
		request.setAttribute("categorys", categorys);
		request.setAttribute("spRange", spRange);
		request.setAttribute("spCPs", spCPs);
		request.setAttribute("spContract", spContract);
		return "service_provider/service_provider_info";
	}

}
