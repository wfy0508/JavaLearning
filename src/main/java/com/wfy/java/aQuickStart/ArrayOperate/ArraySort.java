package com.wfy.java.aQuickStart.ArrayOperate;
/*
 * @Author wfy
 * @Date 2020/10/10 10:35
 * com.wfy.java.aQuickStart.ArrayOperate
 */

import java.util.Arrays;

public class ArraySort {
    public static void main(String[] args) {
        int[] ns = {1, 8, 3, 56, 7, 23, 90};
        System.out.println("冒泡排序前数组：" + Arrays.toString(ns));
        // 2. 冒泡排序
        // 冒泡排序的特点是，每一轮循环后，最大的一个数被交换到末尾，
        // 因此，下一轮循环就可以“刨除”最后的数，每一轮循环都比上一轮循环的结束位置靠前一位。
        for (int i = 0; i < ns.length; i++) {
            for (int j = 0; j < ns.length - i - 1; j++) {
                if (ns[j] > ns[j + 1]) {
                    int tmp = ns[j];
                    ns[j] = ns[j + 1];
                    ns[j + 1] = tmp;
                }
            }
        }
        System.out.println("冒泡排序后数组：" + Arrays.toString(ns));

        // 2. 系统内置排序
        int[] ns1 = {1, 8, 3, 56, 7, 23, 90};
        Arrays.sort(ns1);
        System.out.println("系统内置排序后数组：" + Arrays.toString(ns1));

        //3. 练习：实现降序排列
        int[] ns2 = {28, 12, 89, 73, 65, 18, 96, 50, 8, 36};
        for (int i = 0; i < ns2.length; i++) {
            for (int j = 0; j < ns2.length - i - 1; j++) {
                if (ns2[j] < ns2[j + 1]) {
                    int tmp = ns2[j];
                    ns2[j] = ns2[j + 1];
                    ns2[j + 1] = tmp;
                }
            }
        }
        System.out.println("练习冒泡排序后数组：" + Arrays.toString(ns2));
        if (Arrays.toString(ns2).equals("[96, 89, 73, 65, 50, 36, 28, 18, 12, 8]")) {
            System.out.println("测试成功");
        } else {
            System.out.println("测试失败");
        }
    }
}
