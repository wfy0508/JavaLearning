package com.wfy.java.cExceptionHandling;

/*
 * @Author wfy
 * @Date 2020/10/21 15:21
 * com.wfy.java.cExceptionHandling
 */

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class JavaException {
    public static void main(String[] args) {
        // 捕获异常
        byte[] bs = toGBK("中文");
        System.out.println(Arrays.toString(bs));

        // 这里添加处理toGBK1异常的代码
        try {
            byte[] bs1 = toGBK1("中文");
            System.out.println(Arrays.toString(bs1));
        } catch (UnsupportedEncodingException e) {
            System.out.println(e);
        }
    }

    // 捕获异常使用try...catch语句，把可能发生异常的代码放到try {...}中，然后使用catch捕获对应的Exception及其子类
    static byte[] toGBK(String s) {
        try {
            return s.getBytes("GBK");
        } catch (UnsupportedEncodingException e) { // 必须捕获异常，不然编译器会报错
            System.out.println(e);
            return s.getBytes();
        }
    }

    // 也可以在方法定义处用throws表示toGBK方法可能抛出的错误
    // 这样编译可以通过，但是在main方法中调用toGBK1时，没有捕获方法声明的可能抛出的异常UnsupportedEncodingException
    // 在main方法中使用try catch捕获异常
    static byte[] toGBK1(String s) throws UnsupportedEncodingException {
        return s.getBytes("GBK");
    }
}
