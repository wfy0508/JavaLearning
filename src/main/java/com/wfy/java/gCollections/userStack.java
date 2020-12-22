package com.wfy.java.gCollections;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description
 * @Package com.wfy.java.gCollections
 * @Author wfy
 * @Version V1.0.0
 * @Date 2020/12/22 15:50
 */

public class userStack {
    public static void main(String[] args) {
        // Stack在计算机中使用非常广泛，JVM在处理Java方法调用的时候就会通过栈这种数据结构维护方法调用的层次。
        // JVM会创建方法调用栈，每调用一个方法时，先将参数压栈，然后执行对应的方法；
        // 当方法返回时，返回值压栈，调用方法通过出栈操作获得方法返回值。
        // 因为方法调用栈有容量限制，嵌套调用过多会造成栈溢出，即引发StackOverflowError
        String hex = toHex(12500);
        System.out.println(hex);
        if (hex.equalsIgnoreCase("30D4")) {
            System.out.println("测试成功！");
        } else {
            System.out.println("测试失败！");
        }
    }

    static String toHex(int x) {
        Deque<String> stack = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        for (; x > 0; x /= 16) {
            if (x % 16 > 9) {
                stack.push(Character.toString(x % 16 + 55));
            } else {
                stack.push(Integer.toString(x % 16));
            }
        }
        for (String s : stack) {
            builder.append(s);
        }
        return builder.toString();
    }
}


