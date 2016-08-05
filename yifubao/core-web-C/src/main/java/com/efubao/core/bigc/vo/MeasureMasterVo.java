package com.efubao.core.bigc.vo;

import java.io.Serializable;

import com.efubao.core.sp.domain.MeasureMaster;

public class MeasureMasterVo implements Serializable {
	
    /**
	 * 量体师及量体数量
	 */
	private static final long serialVersionUID = 1L;

	public MeasureMaster measureMaster;
    
    public Integer measureNum;

	public MeasureMaster getMeasureMaster() {
		return measureMaster;
	}

	public void setMeasureMaster(MeasureMaster measureMaster) {
		this.measureMaster = measureMaster;
	}

	public int getMeasureNum() {
		return measureNum;
	}

	public void setMeasureNum(int measureNum) {
		this.measureNum = measureNum;
	}

}
