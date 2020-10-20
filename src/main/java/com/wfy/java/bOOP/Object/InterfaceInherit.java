package com.wfy.java.bOOP.Object;

/*
 * @Author wfy
 * @Date 2020/10/16 17:09
 * com.wfy.java.aQuickStart.OOP.Object
 */

public class InterfaceInherit {
    public static void main(String[] args) {
        Person15 person15 = new Student15("Tom");
        person15.run();
        person15.showName();
    }
}

interface Hello1 {
    void hello();
}

// 此时的Person15有3个抽象方法的签名
interface Person15 extends Hello1 {
    void run();

    String getName();

    // 定义default方法
    // 实现类可以不必覆写default方法。default方法的目的是，当我们需要给接口新增一个方法时，会涉及到修改全部子类。
    // 如果新增的是default方法，那么子类就不必全部修改，只需要在需要覆写的地方去覆写新增方法。
    // default方法和抽象类的普通方法是有所不同的。
    // 因为interface没有字段，default方法无法访问字段，而抽象类的普通方法可以访问实例字段。
    default void showName() {
        System.out.println("The name is " + getName());
    }
}

class Student15 implements Person15 {
    private String name;

    public Student15(String name) {
        this.name = name;
    }

    @Override
    public void hello() {
        System.out.println("Hello, " + this.name);
    }

    @Override
    public void run() {
        System.out.println("Student.run");
    }

    @Override
    public String getName() {
        return this.name;
    }
}