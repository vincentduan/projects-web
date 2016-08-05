package com.efubao.core.bigc.controller.order;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.efubao.common.util.Page;
import com.efubao.core.bigc.vo.MeasureInfoVo;
import com.efubao.core.order.domain.BaseOrder;
import com.efubao.core.order.domain.MeasureInfo;
import com.efubao.core.order.domain.MeasureInfoProperty;
import com.efubao.core.order.domain.MeasureOrder;
import com.efubao.core.order.service.BaseOrderService;
import com.efubao.core.order.service.MeasureInfoPropertyService;
import com.efubao.core.order.service.MeasureInfoService;
import com.efubao.core.order.service.MeasureOrderPropertyService;
import com.efubao.core.order.service.MeasureOrderService;

/**
 */
@Controller
@RequestMapping(value = { "/measure" })
public class MeasureController {
	private static final Logger logger = LoggerFactory.getLogger(MeasureController.class);

	@Autowired
	private MeasureOrderService measureOrderService;
	@Autowired
	private MeasureInfoService measureInfoService;
	@Autowired
	private MeasureOrderPropertyService measureOrderPropertyService;
	@Autowired
	private MeasureInfoPropertyService measureInfoPropertyService;
	@Autowired
	public BaseOrderService baseOrderService;

	@RequestMapping("/callmeasure")
	public String callmeasure(HttpServletRequest request) {
		String orderNo = request.getParameter("orderNo");
		// MeasureOrder measureOrder = new MeasureOrder();
		BaseOrder baseOrder = baseOrderService.findByOrderNo(orderNo);
		MeasureOrder measureOrder = measureOrderService.findByMeasureOrderNo(orderNo);
		if (measureOrder != null) {
			request.setAttribute("measureOrder", measureOrder);
		}
		request.setAttribute("baseOrder", baseOrder);
		return "order/wait_measure";
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/mesureInfo", method = RequestMethod.GET)
	public List<MeasureInfoVo> orderList(HttpServletRequest request) {
		List<MeasureInfoVo> measureInfoVos = new LinkedList<>();
		String orderNo = request.getParameter("orderNo");
		MeasureOrder measureOrder = measureOrderService.findByOrderNo(orderNo);
		if (measureOrder == null) {
			System.out.println("measureOrder为空");
		}
		// 根据orderNo 从measure_order表获取measure_order_no
		String measure_order_no = measureOrder.getMeasureOrderNo();
		MeasureInfo measureInfo = new MeasureInfo();
		Page<MeasureInfo> page = new Page<>();
		page.setPageSize(10);
		if (measure_order_no != null) {
			measureInfo.setMeasureOrderNo(measure_order_no);
			measureInfoService.queryByPage(page, measureInfo);
		}
		// 根据，量体订单号，获取量体信息
		List<MeasureInfo> measureInfos = page.getResult();
		for (MeasureInfo temp : measureInfos) {
			MeasureInfoVo measureInfoVo = new MeasureInfoVo();
			Long measure_info_id = temp.getId();
			List<MeasureInfoProperty> measureInfoPropertys = measureInfoPropertyService.queryByMeasureInfoId(measure_info_id);
			// List<MeasureOrderProperty> measureOrderProperties = measureOrderPropertyService.queryByMeasureOrderNo(measure_order_no);
			measureInfoVo.setMeasureInfo(temp);
			measureInfoVo.setMeasureInfoProperty(measureInfoPropertys);
			// measureInfoVo.setMeasureOrderProperty(measureOrderProperties);
			measureInfoVos.add(measureInfoVo);
		}
		return measureInfoVos;
	}
}
