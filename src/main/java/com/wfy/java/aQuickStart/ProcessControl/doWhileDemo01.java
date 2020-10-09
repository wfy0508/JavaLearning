package com.wfy.java.aQuickStart.ProcessControl;
/*
 * @Author wfy
 * @Date 2020/10/9 15:56
 * com.wfy.java.aQuickStart.ProcessControl
 */

import java.util.Scanner;

public class doWhileDemo01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个整数：");
        int input = scanner.nextInt();
        int i = 1;
        do {
            System.out.println(i);
            i++;
        } while (i < input);

        //计算从m到n的和
        int sum = 0;
        int m = 20;
        int n = 100;
        do {
            sum += m;
            m++;
        } while (m <= n);
        System.out.println("求和结果为：" + sum);
    }
}
