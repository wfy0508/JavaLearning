package Liaoxuefeng.aQuickStart.ProcessControl;
/*
 * @Author wfy
 * @Date 2020/10/9 11:34
 * com.wfy.java.ProcessControl
 */

import java.util.Scanner;

public class switchDemo01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入你的选项：");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                System.out.println("Select 1");
                break; //如果不写break，会产生穿透。case语句具有“穿透性”，直到遇到break才会停止
            case 2:
                System.out.println("Select 2");
                break;
            case 3:
                System.out.println("Select 3");
                break;
            default:
                System.out.println("Not selected!");
                break;
        }

        //新版switch
        switch (option) {
            case 1->System.out.println("Select 1");
            case 2->System.out.println("Select 2");
            case 3->System.out.println("Select 3");
            default->System.out.println("Not selected!");
        }
    }
}
