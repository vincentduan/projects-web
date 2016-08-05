package com.efubao.core.common.quartz.service.impl;

import com.efubao.core.common.quartz.dao.QuartzDao;
import com.efubao.core.common.quartz.service.SchedulerService;

import org.quartz.*;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("schedulerService")
public class SchedulerServiceImpl implements SchedulerService {

    private static Logger logger = LoggerFactory.getLogger(SchedulerServiceImpl.class);

    private Scheduler scheduler;

    private QuartzDao quartzDao;

    @Autowired
    public void setScheduler(@Qualifier("quartzScheduler") Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Autowired
    public void setQuartzDao(@Qualifier("quartzDao") QuartzDao quartzDao) {
        this.quartzDao = quartzDao;
    }

    @Override
    public List<Map<String, Object>> getQrtzTriggers() {
        return quartzDao.getQrtzTriggers();
    }
    
    @Override
    public List<Map<String, Object>> getQrtzTriggers(List<String> groupList) {
        return quartzDao.getQrtzTriggers(groupList);
    }

    @Override
    public void pauseTrigger(String triggerName, String group) {
        try {
            TriggerKey triggerKey = new TriggerKey(triggerName, group);
            scheduler.pauseTrigger(triggerKey);//停止触发器
            logger.info(triggerName + "暂停成功");
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void resumeTrigger(String triggerName, String group) {
        try {
            TriggerKey triggerKey = new TriggerKey(triggerName, group);
            scheduler.resumeTrigger(triggerKey);//重启触发器
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void schedulerJob(String triggerName, String group) {
        try {
            TriggerKey triggerKey = new TriggerKey(triggerName, group);
            Trigger trigger = scheduler.getTrigger(triggerKey);
            JobKey jobKey = trigger.getJobKey();
            scheduler.triggerJob(jobKey);
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getCronExpression(String triggerGroup, String triggerName) {
        return quartzDao.getQrtzTriggerCron(triggerGroup, triggerName);
    }

    @Override
    public boolean updateCronExpression(String triggerGroup, String triggerName,
            String cronExpression) {
        try {
            // 得到trigger
            TriggerKey triggerKey = new TriggerKey(triggerName, triggerGroup);
            CronTriggerImpl trigger = (CronTriggerImpl) scheduler.getTrigger(triggerKey);
            // 设置trigger的时间规则 
            trigger.setCronExpression(cronExpression);
            scheduler.rescheduleJob(triggerKey, trigger);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
