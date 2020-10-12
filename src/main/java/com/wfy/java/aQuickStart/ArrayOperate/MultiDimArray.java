package com.wfy.java.aQuickStart.ArrayOperate;
/*
 * @Author wfy
 * @Date 2020/10/10 11:03
 * com.wfy.java.aQuickStart.ArrayOperate
 */

import java.util.Arrays;

public class MultiDimArray {
    public static void main(String[] args) {
        int[][] ns = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(Arrays.toString(ns[0])); //{1, 2, 3}
        System.out.println(ns[0][0]); //1

        // 打印一个二维数组
        for (int[] arr : ns) {
            for (int n : arr) {
                System.out.print(n);
                System.out.print(", ");
            }
            System.out.println();
        }

        //练习： 计算下面数组的平均值
        int[][] scores = {
                {82, 90, 91},
                {68, 72, 64},
                {95, 91, 89},
                {67, 52, 60},
                {79, 81, 85}};
        int l = 0;
        int sum = 0;
        for (int[] score : scores) {
            for (int i : score) {
                sum += i;
                l++;
            }
        }
        double average = sum / l;
        System.out.println(average);
    }
}
