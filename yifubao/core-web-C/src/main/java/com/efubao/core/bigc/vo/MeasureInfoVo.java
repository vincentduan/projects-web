package com.efubao.core.bigc.vo;

import java.util.List;

import com.efubao.core.order.domain.MeasureInfo;
import com.efubao.core.order.domain.MeasureInfoProperty;
import com.efubao.core.order.domain.MeasureOrderProperty;

public class MeasureInfoVo {
	MeasureInfo measureInfo;
	List<MeasureOrderProperty> measureOrderProperty;
	List<MeasureInfoProperty> measureInfoProperty;

	public MeasureInfo getMeasureInfo() {
		return measureInfo;
	}

	public void setMeasureInfo(MeasureInfo measureInfo) {
		this.measureInfo = measureInfo;
	}

	public List<MeasureOrderProperty> getMeasureOrderProperty() {
		return measureOrderProperty;
	}

	public void setMeasureOrderProperty(List<MeasureOrderProperty> measureOrderProperty) {
		this.measureOrderProperty = measureOrderProperty;
	}

	public List<MeasureInfoProperty> getMeasureInfoProperty() {
		return measureInfoProperty;
	}

	public void setMeasureInfoProperty(List<MeasureInfoProperty> measureInfoProperty) {
		this.measureInfoProperty = measureInfoProperty;
	}

}
