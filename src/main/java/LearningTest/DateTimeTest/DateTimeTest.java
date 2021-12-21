package LearningTest.DateTimeTest;
/*
    PROJECT_NAME: AlgorithmLearning
    User: Summer
    Create time: 2021/8/9 11:10
*/


import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author yanlingwang
 */
public class DateTimeTest {

    @Test
    public void testDate() throws ParseException {
        Date date = new Date();
        System.out.println(date);

        SimpleDateFormat sdf = new SimpleDateFormat();
        System.out.println(sdf.format(date));

        String date1 = "2021/8/9 上午11:17";
        Date date2 = sdf.parse(date1);
        System.out.println(date2);

        // 格式化 日期转字符串
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format1 = sdf1.format(date);
        System.out.println(format1);

        // 解析 字符串转日期
        Date parse = sdf1.parse("2021-08-31 12:34:56");
        System.out.println(parse);

    }


    /**
     * 字符串"2021-08-12"转 java.sql.Date
     */
    @Test
    public void testExpr() throws ParseException {
        String str1 = "2021-08-12";
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf1.parse(str1);
        java.sql.Date date2 = new java.sql.Date(date1.getTime());
        System.out.println(date2);
    }

    /**
     * 三天打鱼两天晒网
     */
    @Test
    public void testFish() throws ParseException {
        String str1 = "1990-01-01";
        System.out.println("开始日期：" + str1);
        String str2 = "1990-01-05";
        System.out.println("测算日期: " + str2);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dt1 = sdf.parse(str1);
        long t1 = dt1.getTime();
        Date dt2 = sdf.parse(str2);
        long t2 = dt2.getTime();
        long i = (int) ((t2 - t1) / (1000 * 60 * 60 * 24) + 1);
        if (i % 5 == 1 || i % 5 == 2 || i % 5 == 3) {
            System.out.println(str2 + ": 打鱼");
        } else {
            System.out.println(str2 + ": 晒网");
        }
    }

    @Test
    public void testCalendar() {
        Calendar calendar = Calendar.getInstance();

        // get
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        // set
        calendar.set(Calendar.DAY_OF_YEAR, 66);
        int days1 = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println(days1);

        // getTime()
        Date time = calendar.getTime();
        System.out.println(time);

        // setTime
        Date date1 = new Date();
        calendar.setTime(date1);
        System.out.println(calendar.getTime());
    }

}
