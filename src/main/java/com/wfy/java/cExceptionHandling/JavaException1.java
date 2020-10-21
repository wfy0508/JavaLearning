package com.wfy.java.cExceptionHandling;

/*
 * @Author wfy
 * @Date 2020/10/21 16:22
 * com.wfy.java.cExceptionHandling
 */

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class JavaException1 {
    public static void main(String[] args) throws Exception {
        // main中直接throws Exception，不在使用try catch，这样写更加简便
        // 因为main()方法声明了可能抛出Exception，也就声明了可能抛出所有的Exception，因此在内部就无需捕获了。
        // 代价就是一旦发生异常，程序会立刻退出。
        byte[] bs3 = toGBK2("中文");
        System.out.println(Arrays.toString(bs3));
    }

    static byte[] toGBK2(String s) throws UnsupportedEncodingException {
        return s.getBytes("GBK");
    }

    static byte[] toGBK3(String s){
        try{
            return s.getBytes("GBK");
        }catch (UnsupportedEncodingException e){
            e.printStackTrace(); // 所有异常都可以调用printStackTrace()方法打印异常栈，这是一个简单有用的快速打印异常的方法。
        }
        return null;
    }
}
