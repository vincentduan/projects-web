package com.efubao.core.common.quartz.dao;

import com.efubao.core.common.quartz.constant.QuartzConstant;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

import java.util.List;
import java.util.Map;

@Repository("quartzDao")
public class QuartzDao {

	private DataSource dataSource;

	@Value("${quartz.tablePrefix}")
	private String tablePrefix;

	@Autowired
	public void setDataSource(
			@Qualifier("quartzDataSource") DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Map<String, Object>> getQrtzTriggers() {

		List<Map<String, Object>> results = getJdbcTemplate()
				.queryForList(
						"select * from "
								+ tablePrefix
								+ "TRIGGERS where trigger_type = 'CRON' order by trigger_name");
		long val = 0;
		String temp = null;
		for (Map<String, Object> map : results) {
			temp = MapUtils.getString(map, "trigger_name");
			if (StringUtils.indexOf(temp, "&") != -1) {
				map.put("display_name", StringUtils.substringBefore(temp, "&"));
			} else {
				map.put("display_name", temp);
			}

			val = MapUtils.getLongValue(map, "next_fire_time");
			if (val > 0) {
				map.put("next_fire_time",
						DateFormatUtils.format(val, "yyyy-MM-dd HH:mm:ss"));
			}

			val = MapUtils.getLongValue(map, "prev_fire_time");
			if (val > 0) {
				map.put("prev_fire_time",
						DateFormatUtils.format(val, "yyyy-MM-dd HH:mm:ss"));
			}

			val = MapUtils.getLongValue(map, "start_time");
			if (val > 0) {
				map.put("start_time",
						DateFormatUtils.format(val, "yyyy-MM-dd HH:mm:ss"));
			}

			val = MapUtils.getLongValue(map, "end_time");
			if (val > 0) {
				map.put("end_time",
						DateFormatUtils.format(val, "yyyy-MM-dd HH:mm:ss"));
			}
			map.put("trigger_state", MapUtils.getString(map, "trigger_state"));
			map.put("statu", QuartzConstant.status.get(MapUtils.getString(map,
					"trigger_state")));
		}

		return results;
	}
	
	public List<Map<String, Object>> getQrtzTriggers(List<String> groupList) {
		StringBuffer sql = new StringBuffer("select * from ");
		sql.append(tablePrefix);
		sql.append("TRIGGERS where trigger_type = 'CRON'");
		if (CollectionUtils.isNotEmpty(groupList)) {
			sql.append(" and trigger_group in (");
			for(String group:groupList){
				sql.append("'"+group+"'");
				sql.append(",");
			}
			int pos = sql.lastIndexOf(",");
			if(pos>0){
				sql.deleteCharAt(pos);
			}
			sql.append(")");
		}
		sql.append(" order by trigger_name");
		List<Map<String, Object>> results = getJdbcTemplate()
				.queryForList(sql.toString());
		long val = 0;
		String temp = null;
		for (Map<String, Object> map : results) {
			temp = MapUtils.getString(map, "trigger_name");
			if (StringUtils.indexOf(temp, "&") != -1) {
				map.put("display_name", StringUtils.substringBefore(temp, "&"));
			} else {
				map.put("display_name", temp);
			}

			val = MapUtils.getLongValue(map, "next_fire_time");
			if (val > 0) {
				map.put("next_fire_time",
						DateFormatUtils.format(val, "yyyy-MM-dd HH:mm:ss"));
			}

			val = MapUtils.getLongValue(map, "prev_fire_time");
			if (val > 0) {
				map.put("prev_fire_time",
						DateFormatUtils.format(val, "yyyy-MM-dd HH:mm:ss"));
			}

			val = MapUtils.getLongValue(map, "start_time");
			if (val > 0) {
				map.put("start_time",
						DateFormatUtils.format(val, "yyyy-MM-dd HH:mm:ss"));
			}

			val = MapUtils.getLongValue(map, "end_time");
			if (val > 0) {
				map.put("end_time",
						DateFormatUtils.format(val, "yyyy-MM-dd HH:mm:ss"));
			}
			map.put("trigger_state", MapUtils.getString(map, "trigger_state"));
			map.put("statu", QuartzConstant.status.get(MapUtils.getString(map,
					"trigger_state")));
		}

		return results;
	}

	public String getQrtzTriggerCron(String triggerGroup, String triggerName) {
		List<Map<String, Object>> results = getJdbcTemplate().queryForList(
				"select cron_expression from " + tablePrefix
						+ "cron_triggers where trigger_group = '"
						+ triggerGroup + "' and trigger_name = '" + triggerName
						+ "'");
		if (results.size() == 0)
			return "0 0 5 ? * *";// 默认每天早晨5点触发
		Map<String, Object> map = results.get(0);
		String cronExpression = MapUtils.getString(map, "cron_expression");
		return cronExpression;
	}

	private JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(this.dataSource);
	}
}
