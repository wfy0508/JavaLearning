package com.wfy.java.bOOP.Object;

/*
 * @Author wfy
 * @Date 2020/10/14 9:46
 * com.wfy.java.aQuickStart.OOP.Object
 */

public class ForbiddenInherit {
    public static void main(String[] args) {

    }
}


//正常情况下，只要某个class没有final修饰符，那么任何类都可以从该class继承。
//从Java 15开始，允许使用sealed修饰class，并通过permits明确写出能够从该class继承的子类名称。
//sealed class Shape permits Rect, Circle, Triangle {
//    private int attribute;
//}
//
//final class Rect extends Shape {
//    private int length;
//}
//
//final class Circle extends Shape {
//    private int radial;
//}
//
//final class Triangle extends Shape {
//    public int high;
//}

//原因是Ellipse并未出现在Shape的permits列表中。这种sealed类主要用于一些框架，防止继承被滥用。
//final class Ellipse extends Shape{ }