package com.wfy.java.aQuickStart.ArrayOperate;
/*
 * @Author wfy
 * @Date 2020/10/10 11:24
 * com.wfy.java.aQuickStart.ArrayOperate
 */

public class CliParas {
    public static void main(String[] args) {
        for (String arg : args) {
            if ("-version".toLowerCase().equals(arg))
                System.out.println("v 15.0");
            break;
        }
    }
}
