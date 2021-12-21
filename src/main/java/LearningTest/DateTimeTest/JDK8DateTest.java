package LearningTest.DateTimeTest;
/*
    PROJECT_NAME: AlgorithmLearning
    User: Summer
    Create time: 2021/8/12 12:05
*/

import org.junit.Test;

import java.time.*;
import java.util.Date;

public class JDK8DateTest {

    @Test
    public void testDate() {
        Date date = new Date(2020, 9, 23);
        // 并不是我们期望的日期，是带有偏移量的日期
        System.out.println(date); // Sat Oct 23 00:00:00 CST 3920
        // 想要期望的日期
        Date date1 = new Date(2020 - 1900, 9 - 1, 23);
        System.out.println(date1);
    }

    /*
    LocalDate, LocalTime, LocalDateTime的使用
     */
    @Test
    public void testDate1() {
        // now()获取当前的时间、日期、日期+时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        // of()
        LocalDateTime localDateTime1 = LocalDateTime.of(localDate, localTime);
        LocalDateTime localDateTime2 = LocalDateTime.of(2021, 8, 23, 12, 34, 56);
        System.out.println(localDateTime1);
        System.out.println(localDateTime2);

        // getXxx()
        System.out.println(localDateTime2.getSecond());
        System.out.println(localDateTime2.getHour());
        System.out.println(localDateTime2.getDayOfWeek());
        System.out.println(localDateTime2.getDayOfMonth());
        System.out.println(localDateTime2.getDayOfYear());

        // 不可变性
        LocalDate localDate1 = localDate.withDayOfMonth(22);
        System.out.println(localDate);  // 2021-08-12
        System.out.println(localDate1); // 2021-08-22

        LocalDateTime localDateTime3 = localDateTime2.withHour(23);
        System.out.println(localDateTime2);
        System.out.println(localDateTime3);

        System.out.println(localDateTime);
        System.out.println(localDateTime.plusMonths(3));
        System.out.println(localDateTime.plusDays(100));

    }

    /*
    Instant的使用
     */
    @Test
    public void test1() {
        Instant instant = Instant.now();
        // 本初子午线时间：2021-08-12T05:15:07.815899700Z
        System.out.println(instant);

        // 获取东八区时间
        // 2021-08-12T13:15:07.815899700+08:00
        System.out.println(instant.atOffset(ZoneOffset.ofHours(8)));

        // 获取毫秒数
        long toEpochMilli = instant.toEpochMilli();
        System.out.println(toEpochMilli);
        // 毫秒数转化为时间
        Instant ofEpochMilli = Instant.ofEpochMilli(toEpochMilli);
        System.out.println(ofEpochMilli);
    }
}
