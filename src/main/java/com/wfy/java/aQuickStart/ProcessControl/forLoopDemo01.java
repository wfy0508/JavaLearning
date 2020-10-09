package com.wfy.java.aQuickStart.ProcessControl;
/*
 * @Author wfy
 * @Date 2020/10/9 16:07
 * com.wfy.java.aQuickStart.ProcessControl
 */

public class forLoopDemo01 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum += i;
        }
        System.out.println("sum = " + sum);

        //for each循环
        int[] arr = {1, 3, 5, 7, 9, 11};
        for (int n : arr) {
            System.out.print(n + " ");
        }

        System.out.print("\n");

        //给定一个数组，请用for循环倒序输出每一个元素
        int[] ns = {1, 4, 9, 16, 25};
        for (int i = ns.length - 1; i >= 0; i--) {
            System.out.print(ns[i] + " ");
        }

        System.out.print("\n");

        //圆周率π可以使用公式计算：pi/4 = 1- 1/3 + 1/5 - 1/7 + 1/9 + ...
        double pi = 0;
        double j = -1.0;
        for (int i = 1; i < 100000000; i += 2) {
            j = j * (-1);
            pi = pi + (j / i);
        }
        System.out.print("pi = " + pi * 4);
    }
}
