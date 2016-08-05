package com.efubao.core.bigc.controller.sp;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.efubao.core.admin.domain.Category;
import com.efubao.core.admin.service.CategoryService;
import com.efubao.core.bigc.controller.service.SpCommonService;
import com.efubao.core.bigc.vo.MeasureMasterVo;
import com.efubao.core.order.domain.MeasureOrder;
import com.efubao.core.order.service.MeasureOrderService;
import com.efubao.core.sp.domain.MeasureMaster;
import com.efubao.core.sp.domain.ServiceProvider;
import com.efubao.core.sp.domain.SpCategoryRelation;
import com.efubao.core.sp.domain.SpCertificatePicture;
import com.efubao.core.sp.domain.SpContract;
import com.efubao.core.sp.domain.SpServiceRange;
import com.efubao.core.sp.service.MeasureMasterService;
import com.efubao.core.sp.service.ServiceProviderService;
import com.efubao.core.sp.service.SpCategoryRelationService;
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
	private SpCategoryRelationService spCategoryRelation;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private MeasureMasterService measureMasterService;
	@Autowired
	private MeasureOrderService measureOrderService;
	@Autowired
	private SpCommonService spCommonService;

	/**
	 * 获取服务商主页信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/spInfo")
	public String spInfo(@RequestParam("id") Long spId,
			HttpServletRequest request, HttpServletResponse response) {
		if (null == spId) {
			logger.error("spId is null");
			// 返回错误页面
		}
		// 服务商基本信息
		ServiceProvider sp = spService.findById(spId);
		// 服务内容
		List<Category> categorys = spCommonService.queryCategorysBySpId(spId);
		// 服务区域
		String spRange = spServiceRangeService.querySpRangeBySpId(spId);
		// 量体师信息(只取8个)
		List<MeasureMasterVo> mmvs = spCommonService
				.queryMeasureMasterVoBySpId(spId, 8);
		// 案例

		request.setAttribute("sp", sp);
		request.setAttribute("categorys", categorys);
		request.setAttribute("spRange", spRange);
		request.setAttribute("mmvs", mmvs);
		return "sp/sp_info";
	}

	/**
	 * 获得量体师列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/mmList")
	public String mmList(@RequestParam("id") Long spId,
			HttpServletRequest request, HttpServletResponse response) {
		if (null == spId) {
			logger.error("spId is null");
			// 返回错误页面
		}
		// 服务商基本信息，用于导航栏
		ServiceProvider sp = spService.findById(spId);
		// 量体师信息
		request.setAttribute("mmvs",
				spCommonService.queryMeasureMasterVoBySpId(spId));
		request.setAttribute("sp", sp);
		return "sp/mm_list";
	}

	/**
	 * 量体师详情
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/mMDetail")
	public String mMDetail(@RequestParam("id") Long spId,
			@RequestParam("mmId") Long mmId, HttpServletRequest request,
			HttpServletResponse response) {
		if (null == spId || mmId == null) {
			logger.error("spId&mmId is requested, spId : {}, mmId : {}", spId,
					mmId);
			// 返回错误页面
		}
		// 服务商基本信息，用于导航栏
		ServiceProvider sp = spService.findById(spId);
		// 量体师基本信息
		MeasureMaster measureMaster = measureMasterService.findById(mmId);
		logger.info("measureMaster : {}", measureMaster);
		// 量体师案例信息(缺失)
		request.setAttribute("measureMaster", measureMaster);
		request.setAttribute("sp", sp);
		return "sp/mm_detail";
	}

	/**
	 * 获取服务商档案信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/spArchive")
	public String spArchive(@RequestParam("id") Long spId,
			HttpServletRequest request, HttpServletResponse response) {
		if (null == spId) {
			logger.error("spId is null");
			// 返回错误页面
		}
		// 服务商基本信息
		ServiceProvider sp = spService.findById(spId);
		// 证件图片
		SpCertificatePicture spCertificatePicture = new SpCertificatePicture();
		spCertificatePicture.setSpId(spId);
		spCertificatePicture.setIsDel(false);
		List<SpCertificatePicture> spCPs = spCertificatePictureService
				.queryByCondition(spCertificatePicture);
		// 服务内容
		List<Category> categorys = spCommonService.queryCategorysBySpId(spId);
		// 服务区域
		String spRange = spServiceRangeService.querySpRangeBySpId(spId);
		request.setAttribute("sp", sp);
		request.setAttribute("spCPs", spCPs);
		request.setAttribute("categorys", categorys);
		request.setAttribute("spRange", spRange);
		return "sp/sp_archive";
	}

}
