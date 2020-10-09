package com.wfy.java.aQuickStart.ProcessControl;
/*
 * @Author wfy
 * @Date 2020/10/9 15:38
 * com.wfy.java.aQuickStart.ProcessControl
 */

import java.util.Scanner;

public class WhileDemo01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个整数：");
        int input = scanner.nextInt();
        int i = 1;
        while (i < input) {
            System.out.println(i);
            i++;
        }
    }
}
