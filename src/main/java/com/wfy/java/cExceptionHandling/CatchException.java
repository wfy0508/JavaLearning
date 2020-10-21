package com.wfy.java.cExceptionHandling;

/*
 * @Author wfy
 * @Date 2020/10/21 16:32
 * com.wfy.java.cExceptionHandling
 */

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class CatchException {
    public static void main(String[] args) throws Exception {
        // 在Java中，凡是可能抛出异常的语句，都可以用try ... catch捕获。
        // 把可能发生异常的语句放在try { ... }中，然后使用catch捕获对应的Exception及其子类。
        // 有多个catch时，从上到下一次执行，匹配到其中一个就会停止，不再继续匹配
        try {
            byte[] b1 = toGBK("中文");
            System.out.println(Arrays.toString(b1));

            byte[] b2 = toUTF8("中文");
            System.out.println(Arrays.toString(b2));

        } catch (UnsupportedEncodingException e) {
            System.out.println("Bad Encoding");
        } catch (IOException e) {
            System.out.println(e);
        }
        //存在多个catch的时候，catch的顺序非常重要：子类必须写在前面。例如：
        /*
        catch (UnsupportedEncodingException e) { // 写在IOException后面，永远捕获不到
            System.out.println(e);
        }

        // finally语句不是必须的，可写可不写；
        // finally总是最后执行
         */ finally {
            System.out.println("END");
        }

    }

    static byte[] toGBK(String s) throws UnsupportedEncodingException {
        return s.getBytes("GBK");
    }

    static byte[] toUTF8(String s) throws UnsupportedEncodingException {
        return s.getBytes(StandardCharsets.UTF_8);
    }

}
