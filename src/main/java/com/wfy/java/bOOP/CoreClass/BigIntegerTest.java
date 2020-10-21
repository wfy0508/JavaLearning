package com.wfy.java.bOOP.CoreClass;

/*
 * @Author wfy
 * @Date 2020/10/21 10:32
 * com.wfy.java.bOOP.CoreClass
 */

import java.math.BigInteger;

public class BigIntegerTest {
    public static void main(String[] args) {
        // long类型最大长度为64位，如果使用的整数超过这个范围，可以使用BigInteger，可以表示任意位数的整数
        // BigInteger内部用一个int[]数组来模拟一个非常大的整数
        BigInteger bi = new BigInteger("1234567890");
        System.out.println(bi.pow(5));

        // 对BigInteger做运算的时候，只能使用实例方法，例如，加法运算：
        BigInteger i1 = new BigInteger("1234567890");
        BigInteger i2 = new BigInteger("12345678901234567890");
        BigInteger sum = i1.add(i2); // 不能写i1 + i2
        System.out.println("sum = " + sum);

        // 和long计算没有限制，就是速度有点慢
        BigInteger i3 = new BigInteger("123456789000");
        System.out.println(i3.longValue());
        // 使用longValueExact，如果超过long型的范围，
        // 就会抛出ArithmeticException: BigInteger out of long range
        /*
         System.out.println(i3.multiply(i3).longValueExact());
         */

        // BigInteger和Integer、Long一样，也是不可变类，并且也继承自Number类。
        // 因为Number定义了转换为基本类型的几个方法
        BigInteger i4 = new BigInteger("1234");
        System.out.println("i4 -> byteValue: " + i4.byteValue());
        System.out.println("i4 -> shortValue: " + i4.shortValue());
        System.out.println("i4 -> intValue: " + i4.intValue());
        System.out.println("i4 -> longValue: " + i4.longValue());
        System.out.println("i4 -> floatValue: " + i4.floatValue());
        System.out.println("i4 -> doubleValue: " + i4.doubleValue());

        // 如果BigInteger表示的范围超过了基本类型的范围，转换时将丢失高位信息，即结果不一定是准确的。
        // 如果需要准确地转换成基本类型，可以使用intValueExact()、longValueExact()等方法，
        // 在转换时如果超出范围，将直接抛出ArithmeticException异常。

        //如果BigInteger的值甚至超过了float的最大范围（3.4x10^38），那么返回的float是什么呢？
        BigInteger i5 = new BigInteger("9999");
        System.out.println(i5.pow(99).floatValue()); // 输出: Infinity

    }
}
