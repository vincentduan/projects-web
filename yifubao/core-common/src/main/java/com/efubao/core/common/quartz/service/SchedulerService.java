package com.efubao.core.common.quartz.service;

import java.util.List;
import java.util.Map;

public interface SchedulerService {

    /**
     * 取得所有调度Triggers
     * 
     * @return
     */
    List<Map<String, Object>> getQrtzTriggers();

    /**
     * 取得所有调度Triggers
     */
    List<Map<String, Object>> getQrtzTriggers(List<String> groupList);
    
    /**
     * 根据名称和组别暂停Tigger
     * 
     * @param triggerName
     * @param group
     */
    void pauseTrigger(String triggerName, String group);

    /**
     * 恢复Trigger
     * 
     * @param triggerName
     * @param group
     */
    void resumeTrigger(String triggerName, String group);

    /**
     * 执行Job
     * 
     * @param triggerName
     * @param group
     */
    void schedulerJob(String triggerName, String group);

    /**
     * 查询定时任务cronExpression
     * 
     * @param triggerGroup
     * @param triggerName
     * @return
     */
    String getCronExpression(String triggerGroup, String triggerName);

    /**
     * 更改定时任务cronExpression
     * 
     * @param triggerGroup
     * @param triggerName
     * @param cronExpression
     * @return
     */
    boolean updateCronExpression(String triggerGroup, String triggerName, String cronExpression);
}
