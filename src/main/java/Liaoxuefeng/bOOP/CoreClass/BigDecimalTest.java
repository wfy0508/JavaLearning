package Liaoxuefeng.bOOP.CoreClass;

/*
 * @Author wfy
 * @Date 2020/10/21 11:13
 * com.wfy.java.bOOP.CoreClass
 */

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalTest {
    public static void main(String[] args) {
        // 1. BigDecimal可以表示一个任意大小且精度完全准确的浮点数。
        BigDecimal bd1 = new BigDecimal("9999");
        System.out.println(bd1.pow(99).floatValue()); // Infinity

        BigDecimal bd2 = new BigDecimal("123.45600");
        System.out.println(bd2.multiply(bd2)); // 完全准确的float数字：15241.3839360000
        System.out.println(bd2.multiply(bd2).scale()); // 小数位数：10
        System.out.println(bd2.multiply(bd2).stripTrailingZeros()); // 去掉末尾的0：15241.383936
        System.out.println(bd2.setScale(2, RoundingMode.HALF_UP)); // 四舍五入，保留两位小数 123.46
        System.out.println(bd2.setScale(2, RoundingMode.DOWN)); // 直接截断，保留两位小数 123.45

        BigDecimal bd3 = new BigDecimal("12300");
        System.out.println(bd3.stripTrailingZeros().scale()); // -2 表示bd3是整数，且末尾有两个0

        // 2. 对BigDecimal做加、减、乘时，精度不会丢失，但是做除法时，存在无法除尽的情况，
        // 这时，就必须指定精度以及如何进行截断
        System.out.println(bd1.divide(bd2, 2, RoundingMode.HALF_UP));

        // 3. 还可以对BigDecimal做除法的同时求余数
        BigDecimal m = new BigDecimal("12.345");
        BigDecimal n = new BigDecimal("0.12");
        BigDecimal[] dr = m.divideAndRemainder(n);
        System.out.println(dr[0]); // 商（总是整数）：102.0
        System.out.println(dr[1]); // 余数（不会大于除数）：0.105

        // 4. 比较两个BigDecimal，要求整数和小数部分完全相等
        BigDecimal bd4 = new BigDecimal("123.456");
        BigDecimal bd5 = new BigDecimal("123.45600");
        System.out.println(bd4.equals(bd5)); // false
        System.out.println(bd4.equals(bd5.stripTrailingZeros())); // true

        // 5. 按照常理来说123.456和123.45600是相等的，
        // 所以，比较两个BigDecimal不要使用equals，要是用compareTo
        // 它根据两个值的大小分别返回负数、正数和0，分别表示小于、大于和等于
        System.out.println(bd4.compareTo(bd5)); // 0

    }
}
