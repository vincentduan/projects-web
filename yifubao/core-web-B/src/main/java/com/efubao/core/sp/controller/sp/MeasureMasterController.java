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

import com.efubao.core.order.domain.MeasureOrder;
import com.efubao.core.order.service.MeasureOrderService;
import com.efubao.core.sp.domain.MeasureMaster;
import com.efubao.core.sp.service.MeasureMasterService;
import com.efubao.core.sp.vo.MeasureMasterVo;

@Controller
@RequestMapping("/mm")
public class MeasureMasterController {

	private static final Logger logger = LoggerFactory
			.getLogger(MeasureMasterController.class);

	@Autowired
	private MeasureMasterService measureMasterService;
	@Autowired
	private MeasureOrderService measureOrderService;

	/**
	 * 获得量体师列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/mmlist")
	public String getMeasureMasterList(HttpServletRequest request,
			HttpServletResponse response) {
		Long spId = (long) 1;
		MeasureMaster mm = new MeasureMaster();
		mm.setSpId(spId);
		mm.setStatus(1);
		mm.setIsDel(false);
		List<MeasureMaster> mms = measureMasterService.queryByCondition(mm);
		// 获得待量体数量
		MeasureOrder mmOrder = new MeasureOrder();
		mmOrder.setStatus(1);
		mmOrder.setIsDel(false);
		List<MeasureMasterVo> mmvs = new ArrayList<MeasureMasterVo>();
		for (MeasureMaster measureMaster : mms) {
			MeasureMasterVo measureMasterListVo = new MeasureMasterVo();
			mmOrder.setMeasureMasterId(measureMaster.getId());
			measureMasterListVo.setMeasureNum(measureOrderService
					.sumMeasureNumByConditon(mmOrder));
			measureMasterListVo.setMeasureMaster(measureMaster);
			mmvs.add(measureMasterListVo);
		}
		request.setAttribute("mmvs", mmvs);
		return "measure_master/measure_master_list";
	}

	/**
	 * 添加量体师
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/addmm")
	public String addMeasureMaster(MeasureMaster measureMaster,
			HttpServletRequest request, HttpServletResponse response) {
		// 获得当前登录的供应商的id
		Long spId = (long) 1;
		measureMaster.setSpId(spId);
		// 设置量体师初始密码
		measureMaster.setPwd("12345678");
		if (measureMasterService.save(measureMaster) == 0) {
			logger.error("save measureMaster fail : {}", measureMaster);
			// 返回错误页面
		}
		logger.info("save measureMaster success : {}", measureMaster);
		return "redirect:/mm/mmlist";
	}

	/**
	 * 量体师详情
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/mmdetail")
	public String getMeasureMasterDetail(@RequestParam("mmid") Long mmId,
			HttpServletRequest request, HttpServletResponse response) {
		if (mmId == null) {
			logger.error("measureMaster id is null");
			// 返回错误页面
		}
		logger.info("find measureMaster by id : {}", mmId);
		MeasureMaster measureMaster = measureMasterService.findById(mmId);
		logger.info("measureMaster : {}", measureMaster);
		request.setAttribute("measureMaster", measureMaster);
		logger.info("isupdate : {}", request.getParameter("isupdate"));
		if ("1".equals(request.getParameter("isupdate"))) {
			return "measure_master/measure_master_update";
		}
		return "measure_master/measure_master_detail";
	}

	/**
	 * 更新量体师信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/updatemm")
	public String updateMeasureMaster(
			@ModelAttribute("measureMaster") MeasureMaster measureMaster,
			HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes attr) {
		logger.info("update measureMaster : {}", measureMaster);
		if (measureMasterService.update(measureMaster) == 0) {
			logger.error("update measureMaster fail : {}", measureMaster);
			// 返回错误页面
		}
		attr.addAttribute("mmid", measureMaster.getId());
		return "redirect:/mm/mmdetail";
	}

}
