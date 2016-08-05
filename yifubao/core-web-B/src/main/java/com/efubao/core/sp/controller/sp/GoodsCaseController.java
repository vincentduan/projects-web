package com.efubao.core.sp.controller.sp;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.efubao.core.admin.domain.Category;
import com.efubao.core.admin.service.CategoryService;
import com.efubao.core.sp.controller.service.GoodsCaseCommonService;
import com.efubao.core.sp.domain.GoodsCase;
import com.efubao.core.sp.domain.CasePicture;
import com.efubao.core.sp.domain.Industry;
import com.efubao.core.sp.service.CasePictureService;
import com.efubao.core.sp.service.GoodsCaseService;
import com.efubao.core.sp.service.IndustryService;
import com.efubao.core.sp.service.ServiceProviderService;
import com.efubao.core.sp.vo.GoodsCaseVo;

@Controller
@RequestMapping("/case")
public class GoodsCaseController {

	private static final Logger logger = LoggerFactory
			.getLogger(GoodsCaseController.class);

	@Autowired
	private ServiceProviderService spService;
	@Autowired
	private GoodsCaseService caseService;
	@Autowired
	private CasePictureService casePictureService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private IndustryService industryService;
	@Autowired
	private GoodsCaseCommonService goodsCaseCommonService;

	/**
	 * 案例列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/caseinfo")
	public String caseinfo(HttpServletRequest request,
			HttpServletResponse response) {
		// 获得供应商id
		Long spId = (long) 1;
		// 获得case基本信息
		GoodsCase goodsCase = new GoodsCase();
		goodsCase.setSpId(spId);
		goodsCase.setIsDel(false);
		List<GoodsCase> cases = caseService.queryByCondition(goodsCase);
		// 获得case图片、首图、所属品类、行业分类
		List<GoodsCaseVo> goodsCaseVos = new ArrayList<GoodsCaseVo>();
		for (GoodsCase c : cases) {
			goodsCaseVos.add(goodsCaseCommonService
					.combineGoodsCaseVoByGoodsCase(c));
		}
		// 获得所有的顶级品类
		Category tmpCategory = new Category();
		tmpCategory.setIsDel(false);
		tmpCategory.setStatus(1);
		tmpCategory.setParentId((long) 0);
		List<Category> categorys = categoryService
				.queryByCondition(tmpCategory);
		logger.info("categorys:{}", categorys);
		// 获得所有的行业
		List<Industry> industrys = industryService.queryAllActiveIndustry();
		logger.info("industrys:{}", industrys);

		request.setAttribute("goodsCaseVos", goodsCaseVos);
		request.setAttribute("categorys", categorys);
		request.setAttribute("industrys", industrys);
		return "goods_case/goods_case_list";
	}

	/**
	 * 添加案例
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/addcase")
	public String addCase(GoodsCase c, String[] picNames, String[] imagePaths,
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("GoodsCase : {}", c);
		// 获得当前登录的供应商的id
		Long spId = (long) 1;
		c.setSpId(spId);
		if (caseService.save(c) == 0) {
			logger.error("save case fail : {}", c);
			// 返回错误页面
		}
		logger.info("save case success : {}", c);
		if (picNames != null && picNames.length > 0) {
			for (int i = 0; i < picNames.length; i++) {
				logger.info("imagePath : {}", imagePaths[i]);
				logger.info("picName : {}", picNames[i]);
				CasePicture casePicture = new CasePicture();
				casePicture.setCaseId(c.getId());
				casePicture.setImagePath(imagePaths[i]);
				casePicture.setPicName(picNames[i]);
				casePictureService.save(casePicture);
			}
		}
		logger.info("save casePicture success : {}", c);
		return "redirect:/case/caseinfo";
	}

	/**
	 * 案例详情
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/casedetail")
	public String caseDetail(@RequestParam("caseid") Long caseId,
			HttpServletRequest request, HttpServletResponse response) {
		if (caseId == null) {
			logger.error("case id is null");
			// 返回错误页面
		}
		GoodsCase goodsCase = caseService.findById(caseId);
		if (goodsCase == null) {
			logger.error("case is null");
			// 返回错误页面
		}
		GoodsCaseVo goodsCaseVo = goodsCaseCommonService
				.combineGoodsCaseVoByGoodsCase(goodsCase);
		logger.info("goodsCaseVo : {}", goodsCaseVo);
		request.setAttribute("goodsCaseVo", goodsCaseVo);
		return "goods_case/goods_case_detail";
	}

	/**
	 * 跳转更新案例页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/toupdatecase")
	public String toUpdateCase(@RequestParam("caseid") Long caseId,
			HttpServletRequest request, HttpServletResponse response) {
		if (caseId == null) {
			logger.error("case id is null");
			// 返回错误页面
		}
		// 获得案例信息
		GoodsCase goodsCase = caseService.findById(caseId);
		logger.info("goodsCase : {}", goodsCase);
		if (goodsCase == null) {
			logger.error("case is null");
			// 返回错误页面
		}
		// 获得案例图片
		CasePicture casePicture = new CasePicture();
		casePicture.setIsDel(false);
		casePicture.setCaseId(goodsCase.getId());
		List<CasePicture> casePictures = casePictureService
				.queryByCondition(casePicture);
		logger.info("casePictures : {}", casePictures);

		// 获得所有的顶级品类
		Category tmpCategory = new Category();
		tmpCategory.setIsDel(false);
		tmpCategory.setStatus(1);
		tmpCategory.setParentId((long) 0);
		List<Category> categorys = categoryService
				.queryByCondition(tmpCategory);
		logger.info("categorys:{}", categorys);
		// 获得所有的行业
		List<Industry> industrys = industryService.queryAllActiveIndustry();
		logger.info("industrys:{}", industrys);

		request.setAttribute("goodsCase", goodsCase);
		request.setAttribute("casePictures", casePictures);
		request.setAttribute("categorys", categorys);
		request.setAttribute("industrys", industrys);
		return "goods_case/goods_case_update";
	}

	/**
	 * 更新案例信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/updatecase")
	public String updateCase(@ModelAttribute("goodsCase") GoodsCase goodsCase,
			Long[] picIds, String[] picNames, String[] imagePaths,
			HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes attr) {
		logger.info("update case : {}", goodsCase);
		if (caseService.update(goodsCase) == 0) {
			logger.error("update case fail : {}", goodsCase);
			// 返回错误页面
		}
		// 删除图片
		CasePicture tmpCasePicture = new CasePicture();
		tmpCasePicture.setIsDel(false);
		tmpCasePicture.setCaseId(goodsCase.getId());
		List<CasePicture> casePictures = casePictureService
				.queryByCondition(tmpCasePicture);
		for (CasePicture casePicture : casePictures) {
			boolean isDel = true;
			for (Long picId : picIds) {
				if (casePicture.getId() == picId) {
					isDel = false;
				}
			}
			if (isDel) {
				casePicture.setIsDel(true);
				casePictureService.update(casePicture);
			}
		}
		// 增加图片
		if (picNames != null && picNames.length > 0) {
			for (int i = 0; i < picNames.length; i++) {
				logger.info("imagePath : {}", imagePaths[i]);
				logger.info("picName : {}", picNames[i]);
				CasePicture casePicture = new CasePicture();
				casePicture.setCaseId(goodsCase.getId());
				casePicture.setImagePath(imagePaths[i]);
				casePicture.setPicName(picNames[i]);
				casePictureService.save(casePicture);
			}
		}
		attr.addAttribute("caseid", goodsCase.getId());
		return "redirect:/case/casedetail";
	}

}
