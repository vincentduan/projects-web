package com.efubao.core.bigc.controller.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efubao.core.admin.domain.Category;
import com.efubao.core.admin.service.CategoryService;
import com.efubao.core.bigc.vo.MeasureMasterVo;
import com.efubao.core.order.domain.MeasureOrder;
import com.efubao.core.order.service.MeasureOrderService;
import com.efubao.core.sp.domain.MeasureMaster;
import com.efubao.core.sp.domain.SpCategoryRelation;
import com.efubao.core.sp.domain.SpContract;
import com.efubao.core.sp.service.MeasureMasterService;
import com.efubao.core.sp.service.SpCategoryRelationService;
import com.efubao.core.sp.service.SpContractService;
@Service
public class SpCommonService{

	@Autowired
	private SpContractService spContractService;
	@Autowired
	private SpCategoryRelationService spCategoryRelationService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private MeasureMasterService measureMasterService;
	@Autowired
	private MeasureOrderService measureOrderService;
	
	
	public List<Category> queryCategorysBySpId(Long spId){
		SpContract spContract = new SpContract();
		spContract.setSpId(spId);
		spContract.setIsDel(false);
		List<SpContract> spContracts = spContractService
				.queryByCondition(spContract);
		List<Category> categorys = new ArrayList<Category>();
		if (!spContracts.isEmpty()) {
			spContract = spContracts.get(0);
			SpCategoryRelation spCategoryRelation = new SpCategoryRelation();
			spCategoryRelation.setSpContractId(spContract.getId());
			spCategoryRelation.setIsDel(false);
			List<SpCategoryRelation> spCRs = spCategoryRelationService
					.queryByCondition(spCategoryRelation);
			for (SpCategoryRelation spCR : spCRs) {
				categorys.add(categoryService.findById(spCR
						.getCategoryId()));
			}
		}
		return categorys;
	}
	
	public List<MeasureMasterVo> queryMeasureMasterVoBySpId(Long spId, int...limit){
		// 获得量体师信息
		MeasureMaster measureMaster = new MeasureMaster();
		measureMaster.setSpId(spId);
		measureMaster.setStatus(1);
		measureMaster.setIsDel(false);
		List<MeasureMaster> measureMasters = measureMasterService.queryByCondition(measureMaster);
		int counts = (limit.length != 0 && limit[0] < measureMasters.size()) ? limit[0] : measureMasters.size();
		// 获得待量体数量
		MeasureOrder measureOrder = new MeasureOrder();
		measureOrder.setStatus(1);
		measureOrder.setIsDel(false);
		List<MeasureMasterVo> measureMasterVos = new ArrayList<MeasureMasterVo>();
		for (int i = 0; i < counts; i++) {
			MeasureMaster mm = measureMasters.get(i);
			MeasureMasterVo mmVo = new MeasureMasterVo();
			measureOrder.setMeasureMasterId(mm.getId());
			mmVo.setMeasureNum(measureOrderService
					.sumMeasureNumByConditon(measureOrder));
			mmVo.setMeasureMaster(mm);
			measureMasterVos.add(mmVo);
		}
		return measureMasterVos;
	}
	
}
