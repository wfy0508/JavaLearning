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
        person11.run(); // 执行Person11的方法
        student6.run();

        // 一个实际类型为Student，引用类型为Person的变量，调用其run()方法，
        // 调用的是Person还是Student的run()方法？
        // 实际上调用的方法是Student的run()方法。
        // Java的实例方法调用是基于运行时的实际类型的动态调用，而非变量的声明类型。
        Person11 p1 = new Student6();
        p1.run(); // 输出Student.run
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
    @Override
    public void run() {
        System.out.println("Student.run");
    }
}