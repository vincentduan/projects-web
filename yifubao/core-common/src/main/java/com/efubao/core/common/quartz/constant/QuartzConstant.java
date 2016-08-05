/*
 * @(#)QuartzConstant.java	2013年12月19日
 *
 * @Company <Opportune Technology Development Company LTD.>
 */
package com.efubao.core.common.quartz.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @Project <CL-Allocation tool>
 * @version <1.0>
 * @Author <wangpc>
 * @Date <2014年12月29日>
 * @description
 */
public class QuartzConstant {

    public static final String TRIGGERNAME = "triggerName";

    public static final String TRIGGERGROUP = "triggerGroup";

    public static final String STARTTIME = "startTime";

    public static final String ENDTIME = "endTime";

    public static final String REPEATCOUNT = "repeatCount";

    public static final String REPEATINTERVEL = "repeatInterval";

    public static final Map<String, String> status = new HashMap<String, String>();
    static {
        status.put("ACQUIRED", "运行中");
        status.put("PAUSED", "暂停中");
        status.put("WAITING", "等待中");
    }
}