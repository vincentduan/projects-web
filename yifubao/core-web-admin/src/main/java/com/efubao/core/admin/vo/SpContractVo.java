package com.efubao.core.admin.vo;

import java.util.List;

import com.efubao.core.admin.domain.Category;
import com.efubao.core.sp.domain.SpContract;

public class SpContractVo extends SpContract {

	private static final long serialVersionUID = 1L;
	private String spName;// 服务商名称
	private String check_status_label;// 审核状态
	private String status_label;// 合作状态
	private List<Category> category;

	public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	}

	public String getSpName() {
		return spName;
	}

	public void setSpName(String spName) {
		this.spName = spName;
	}

	public String getCheck_status_label() {
		return check_status_label;
	}

	public void setCheck_status_label(String check_status_label) {
		this.check_status_label = check_status_label;
	}

	public String getStatus_label() {
		return status_label;
	}

	public void setStatus_label(String status_label) {
		this.status_label = status_label;
	}

}
