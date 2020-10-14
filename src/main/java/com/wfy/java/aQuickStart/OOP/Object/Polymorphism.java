package com.wfy.java.aQuickStart.OOP.Object;

/*
 * @Author wfy
 * @Date 2020/10/14 17:58
 * com.wfy.java.aQuickStart.OOP.Object
 */

public class Polymorphism {
    public static void main(String[] args) {
        Person11 person11 = new Person11();
        Student6 student6 = new Student6();
        person11.run();
        student6.run(); // 执行继承自父类的方法
        student6.run("s"); // 有了入参，执行子类自己的方法
    }
}

//在继承关系中，子类如果定义了一个与父类方法签名完全相同的方法，被称为覆写（Override）
class Person11 {
    public void run() {
        System.out.println("Person.run");
    }
}

class Student6 extends Person11 {
    // Override和Overload不同的是，如果方法签名如果不同，就是Overload，Overload方法是一个新方法；
    // 如果方法签名相同，并且返回值也相同，就是Override。
    // 如果方法名相同，方法参数相同，返回值不同，也是不同的方法。出现这种情况，编译器会报错。

    // 加上@Override可以让编译器帮助检查是否进行了正确的覆写。
    // 希望进行覆写，但是不小心写错了方法签名，编译器会报错。
    // public void run(String s) {  // 传参与父类不同，不能Override
    // @Override
    public void run(String s) {
        System.out.println("Student.run");
    }
}