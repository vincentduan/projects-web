package com.efubao.core.sp.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efubao.core.admin.service.CategoryService;
import com.efubao.core.sp.domain.CasePicture;
import com.efubao.core.sp.domain.GoodsCase;
import com.efubao.core.sp.service.CasePictureService;
import com.efubao.core.sp.service.GoodsCaseService;
import com.efubao.core.sp.service.IndustryService;
import com.efubao.core.sp.vo.GoodsCaseVo;
@Service
public class GoodsCaseCommonService{

	@Autowired
	private GoodsCaseService caseService;
	@Autowired
	private CasePictureService casePictureService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private IndustryService industryService;
	
	private CasePicture casePicture = new CasePicture();
	
	private CasePicture defaultCasePicture = new CasePicture();
	
	public GoodsCaseCommonService(){
		defaultCasePicture.setPicName("default");
		defaultCasePicture.setImagePath("http://download.easyicon.net/png/1199812/128/");
	}
	
	/*
	 * 获得:case、case图片、首图、所属品类、行业分类
	 */
	public GoodsCaseVo combineGoodsCaseVoByGoodsCase(GoodsCase goodsCase){
		if (goodsCase == null) {
			return null;
		}
		GoodsCaseVo caseVo = new GoodsCaseVo();
		caseVo.setGoodsCase(goodsCase);
		casePicture.setIsDel(false);
		casePicture.setCaseId(goodsCase.getId());
		List<CasePicture> casePictures= casePictureService.queryByCondition(casePicture);
		if (!casePictures.isEmpty()) {
			caseVo.setFirstPicture(casePictures.get(0));
		}else{
			caseVo.setFirstPicture(defaultCasePicture);
		}
		caseVo.setCasePictures(casePictures);
		caseVo.setCategory(categoryService.findById(goodsCase.getCategoryId()).getName());
		caseVo.setIndustry(industryService.findById(goodsCase.getIndustryId()).getName());
		return caseVo;
	}
	
}
