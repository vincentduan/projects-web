package com.efubao.core.sp.vo;

import java.io.Serializable;
import java.util.List;

import com.efubao.core.common.base.BasePo;
import com.efubao.core.sp.domain.CasePicture;
import com.efubao.core.sp.domain.GoodsCase;

public class GoodsCaseVo extends BasePo implements Serializable {

	/**
	 * 案例：信息、图片、所属品类、所属行业、首图
	 */
	private static final long serialVersionUID = 1L;

	public GoodsCase goodsCase;

	public List<CasePicture> casePictures;

	public String category;

	public String industry;

	public CasePicture firstPicture;

	public GoodsCase getGoodsCase() {
		return goodsCase;
	}

	public void setGoodsCase(GoodsCase goodsCase) {
		this.goodsCase = goodsCase;
	}

	public List<CasePicture> getCasePictures() {
		return casePictures;
	}

	public void setCasePictures(List<CasePicture> casePictures) {
		this.casePictures = casePictures;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public CasePicture getFirstPicture() {
		return firstPicture;
	}

	public void setFirstPicture(CasePicture firstPicture) {
		this.firstPicture = firstPicture;
	}

}
