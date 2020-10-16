package com.wfy.java.aQuickStart.OOP.Object;

/*
 * @Author wfy
 * @Date 2020/10/16 15:43
 * com.wfy.java.aQuickStart.OOP.Object
 */

public class Interface {
    public static void main(String[] args) {
        Person14 person14 = new Student9("Tom");
        person14.run();
    }
}

// 接口：一个抽象类没有字段，所有方法全部都是抽象方法
//abstract class Person14{
//    public abstract void run();
//    public abstract String getName();
//}

// 所谓interface，就是比抽象类还要抽象的纯抽象接口，因为它连字段都不能有。
// 因为接口定义的所有方法默认都是public abstract的，所以这两个修饰符不需要写出来（写不写效果都一样）。
interface Person14 {
    public abstract void run();

    public abstract String getName();
}

interface SayHello {
    void sayHello();
}

// 当一个具体的class去实现一个interface时，需要使用implements关键字。
class Student9 implements Person14 {
    private String name;

    public Student9(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(this.name + ", run!");
    }

    @Override
    public String getName() {
        return this.name;
    }
}

// 在Java中，一个类只能继承自另一个类，不能从多个类继承。但是，一个类可以实现多个interface
class Student10 implements Person14, SayHello {
    private String name;

    @Override
    public void run() {
        System.out.println("Student10.run");
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void sayHello() {
        System.out.println("Hello, " + this.name);
    }
}