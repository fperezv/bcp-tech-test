package com.bcp.test.tech.utils;

import com.bcp.test.tech.utils.enums.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public final class DateUtils {

    public static Date now() {
        var nowDate = Calendar.getInstance();
        nowDate.setTimeZone(TimeZone.getTimeZone("America/Lima"));
        return nowDate.getTime();
    }

    public static Long toLong(Date date) {
        var nowDate = Calendar.getInstance();
        nowDate.setTimeZone(TimeZone.getTimeZone("America/Lima"));
        nowDate.setTime(date);
        return nowDate.getTimeInMillis();
    }

    public static Date fromLong(Long longDate) {
        var nowDate = Calendar.getInstance();
        nowDate.setTimeZone(TimeZone.getTimeZone("America/Lima"));
        nowDate.setTimeInMillis(longDate);
        return nowDate.getTime();
    }

    public static String format(Date date) {
        return DateUtils.format(date, DateFormat.TIMESTAMP);
    }

    public static String format(Date date, DateFormat format) {
        var formatter = new SimpleDateFormat(format.value());
        return formatter.format(date);
    }

}
