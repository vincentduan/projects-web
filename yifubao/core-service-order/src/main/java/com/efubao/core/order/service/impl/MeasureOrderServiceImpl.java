package com.efubao.core.order.service.impl;

import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efubao.common.util.Page;
import com.efubao.core.order.domain.MeasureOrder;
import com.efubao.core.order.domain.MeasureOrderExample;
import com.efubao.core.order.domain.MeasureOrderExample.Criteria;
import com.efubao.core.order.mapper.MeasureOrderMapper;
import com.efubao.core.order.service.MeasureOrderService;

@Service
public class MeasureOrderServiceImpl implements MeasureOrderService {

	@Autowired
	private MeasureOrderMapper measureOrderMapper;

	@Override
	public MeasureOrder findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MeasureOrder findByMeasureOrderNo(String measureOrderNo) {
		if (null == measureOrderNo) {
			return null;
		}
		return measureOrderMapper.selectByPrimaryKey(measureOrderNo);
	}

	@Override
	public int save(MeasureOrder t) {
		// TODO Auto-generated method stub
		if (null == t) {
			return 0;
		}
		return measureOrderMapper.insertSelective(t);
	}

	@Override
	public int update(MeasureOrder t) {
		// TODO Auto-generated method stub
		if (null == t) {
			return 0;
		}
		return measureOrderMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int deleteById(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByMeasureOrderNo(String measureOrderNo) {
		if (null == measureOrderNo) {
			return 0;
		}
		return measureOrderMapper.deleteByPrimaryKey(measureOrderNo);
	}

	@Override
	public void queryByPage(Page<MeasureOrder> page, MeasureOrder measureOrder) {
		// TODO Auto-generated method stub
		MeasureOrderExample example = new MeasureOrderExample();
		MeasureOrderExample.Criteria criteria = example.createCriteria();

		if (null != measureOrder) {
			if (null != measureOrder.getMeasureMasterId())
				criteria.andMeasureMasterIdEqualTo(measureOrder.getMeasureMasterId());
			if (null != measureOrder.getStatus())
				criteria.andStatusEqualTo(measureOrder.getStatus());
		}

		page2Exam(page, example);
		if (page.isAutoCount()) {
			int total = measureOrderMapper.countByExample(example);
			page.setTotalCount(total);
		}

		List<MeasureOrder> list = measureOrderMapper.selectByExample(example);
		page.setResult(list);
	}

	private void page2Exam(Page<MeasureOrder> page, MeasureOrderExample example) {
		if (null != page && null != example) {
			example.setLimitEnd(page.getPageSize());
			example.setLimitStart(page.getPageSize() * (page.getPageNo() - 1));
		}

		if (null != page.getOrderBy() && page.getOrderBy().length() < 20) {
			example.setOrderByClause(StringEscapeUtils.escapeSql(page.getOrderBy()));
		}
	}

	@Override
	public int countByParam(MeasureOrder measureOrder) {
		MeasureOrderExample example = new MeasureOrderExample();
		MeasureOrderExample.Criteria criteria = example.createCriteria();

		if (null != measureOrder) {
			if (null != measureOrder.getMeasureMasterId())
				criteria.andMeasureMasterIdEqualTo(measureOrder.getMeasureMasterId());
			if (null != measureOrder.getStatus())
				criteria.andStatusEqualTo(measureOrder.getStatus());
			if (null != measureOrder.getIsDel())
				criteria.andIsDelEqualTo(measureOrder.getIsDel());
		}

		return measureOrderMapper.countByExample(example);
	}

	@Override
	public long sumMeasureNum() {
		// TODO Auto-generated method stub
		return measureOrderMapper.sumMeasureNum();
	}

	@Override
	public Integer sumMeasureNumByConditon(MeasureOrder measureOrder) {
		if (null == measureOrder) {
			return 0;
		}
		Integer num = measureOrderMapper.sumMeasureNumByConditon(measureOrder);
		return num != null ? num : 0;
	}

	@Override
	public MeasureOrder findByOrderNo(String orderNo) {
		MeasureOrderExample measureOrderExample = new MeasureOrderExample();
		Criteria criteria = measureOrderExample.createCriteria();
		criteria.andOrderNoEqualTo(orderNo);
		List<MeasureOrder> measureOrders = measureOrderMapper.selectByExample(measureOrderExample);
		return measureOrders.get(0);
	}

}
