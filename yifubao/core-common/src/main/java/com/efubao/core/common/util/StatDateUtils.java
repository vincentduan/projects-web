package com.efubao.core.common.util;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

/**
 * Description: StatOrderUtils
 * Author: wangpc (2015-01-10)
 */
public class StatDateUtils {
    public static Date getDayBegin(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        return calendar.getTime();
    }

    public static Date getDayEnd(final Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MILLISECOND, 999);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        return calendar.getTime();
    }

    public static Timestamp getDayBeginTimestamp(Date date) {
        Date d = getDayBegin(date);
        Timestamp t = new Timestamp(d.getTime());
        t.setNanos(0);
        return t;
    }

    public static Timestamp getDayEndTimestamp(final Date date) {
        Date d = getDayEnd(date);
        Timestamp t = new Timestamp(d.getTime());
        t.setNanos(999999999);
        return t;
    }
}
