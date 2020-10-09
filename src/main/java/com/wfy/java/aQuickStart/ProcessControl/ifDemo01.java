package com.wfy.java.aQuickStart.ProcessControl;

/*
 * @Author wfy
 * @Date 2020/10/9 10:48
 * com.wfy.java.ProcessControl
 */

import java.io.IOException;
import java.util.Scanner;

public class ifDemo01 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入成绩：");
        int n = scanner.nextInt();
        if (n > 100 || n < 0) {
            System.out.println("输入成绩无效");
        } else if (n >= 80) {
            System.out.println("优秀");
        } else if (n >= 60) {
            System.out.println("合格");
        } else {
            System.out.println("不合格");
        }
    }
}
