package com.wfy.java.aQuickStart.ProcessControl;
/*
 * @Author wfy
 * @Date 2020/10/9 15:22
 * com.wfy.java.ProcessControl
 */

import java.util.Scanner;

public class inOutDemo01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input your name: ");
        String name = scanner.nextLine();
        System.out.print("Input your age: ");
        int age = scanner.nextInt();
        System.out.printf("Hi, %s, you are %d\n", name, age);
    }
}
