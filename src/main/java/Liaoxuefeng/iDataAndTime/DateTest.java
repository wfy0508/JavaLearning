package Liaoxuefeng.iDataAndTime;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description
 * @Package com.wfy.java.iDataAndTime
 * @Author wfy
 * @Version V1.0.0
 * @Date 2020/12/23 17:23
 */

public class DateTest {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date.getYear() + 1900); // 必须加上1900
        System.out.println(date.getMonth() + 1); //必须加上1
        System.out.println(date.getDate());
        // 转换为String:
        System.out.println(date.toString());
        // 转换为GMT时区:
        System.out.println(date.toGMTString());
        // 转换为本地时区:
        System.out.println(date.toLocaleString());

        // 格式化输出
        var dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("格式化输出: " + dateFormat.format(date));

        // Java的格式化预定义了许多不同的格式，我们以MMM和E为例：
        var dataFormat1 = new SimpleDateFormat("E MMM dd, yyyy");
        System.out.println(dataFormat1.format(date)); //周三 12月 23, 2020, 不同的系统输出的有所不同
        // M：输出9
        // MM：输出09
        // MMM：输出Sep
        // MMMM：输出September

        // Date对象有几个严重的问题：
        // 它不能转换时区，除了toGMTString()可以按GMT+0:00输出外，
        // Date总是以当前计算机系统的默认时区为基础进行输出。
        // 此外，我们也很难对日期和时间进行加减，计算两个日期相差多少天，计算某个月第一个星期一的日期等。
    }
}
