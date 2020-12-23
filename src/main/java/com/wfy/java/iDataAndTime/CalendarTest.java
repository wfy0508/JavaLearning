package com.wfy.java.iDataAndTime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @Description
 * @Package com.wfy.java.iDataAndTime
 * @Author wfy
 * @Version V1.0.0
 * @Date 2020/12/23 17:32
 */

public class CalendarTest {
    public static void main(String[] args) {
        // Calendar可以用于获取并设置年、月、日、时、分、秒，
        // 它和Date比，主要多了一个可以做简单的日期和时间运算的功能。
        Calendar calendar = Calendar.getInstance();
        int y = calendar.get(Calendar.YEAR);
        int m = 1 + calendar.get(Calendar.MONTH);
        int d = calendar.get(Calendar.DAY_OF_MONTH);
        int w = calendar.get(Calendar.DAY_OF_WEEK); // 周日为第一天
        int hh = calendar.get(Calendar.HOUR_OF_DAY);
        int mm = calendar.get(Calendar.MINUTE);
        int ss = calendar.get(Calendar.SECOND);
        int ms = calendar.get(Calendar.MILLISECOND);
        System.out.println(y + "-" + m + "-" + d + " " + w + " " + hh + ":" + mm + ":" + ss + "." + ms);

        // 如果我们想给它设置成特定的一个日期和时间，就必须先清除所有字段
        calendar.clear();
        calendar.set(Calendar.YEAR, 2020);
        calendar.set(Calendar.MONTH, 11); // 11表示12月
        calendar.set(Calendar.DAY_OF_MONTH, 23);
        calendar.set(Calendar.HOUR_OF_DAY, 17);
        calendar.set(Calendar.MINUTE, 40);
        calendar.set(Calendar.SECOND, 50);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime()));

        // Calendar和Date相比，它提供了时区转换的功能。时区用TimeZone对象表示：
        TimeZone timeZoneDefault = TimeZone.getDefault();
        TimeZone gmt9 = TimeZone.getTimeZone("GMT+09:00");
        TimeZone NewYorkZone = TimeZone.getTimeZone("America/New_York");
        System.out.println(timeZoneDefault.getID());
        System.out.println(gmt9.getID());
        System.out.println(NewYorkZone.getID());

        // 有了时区，我们就可以对指定时间进行转换。
        calendar.clear();
        calendar.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        calendar.set(2019, Calendar.NOVEMBER, 20, 8, 15, 0);
        var sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("上海时间：" + sdf.format(calendar.getTime()));
        sdf.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        System.out.println("纽约时间：" + sdf.format(calendar.getTime()));

        // 日期加减
        calendar.clear();
        // 设置年月日时分秒:
        calendar.set(2019, Calendar.NOVEMBER /* 11月 */, 20, 8, 15, 0);
        // 加5天并减去2小时:
        calendar.add(Calendar.DAY_OF_MONTH, 5);
        calendar.add(Calendar.HOUR_OF_DAY, -2);
        // 显示时间:
        var sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1 = calendar.getTime();
        System.out.println(sdf1.format(d1));


    }
}
