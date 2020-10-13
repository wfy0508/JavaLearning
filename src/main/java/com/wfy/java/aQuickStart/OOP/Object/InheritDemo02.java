package com.wfy.java.aQuickStart.OOP.Object;

/*
 * @Author wfy
 * @Date 2020/10/13 17:24
 * com.wfy.java.aQuickStart.OOP.Object
 */

public class InheritDemo02 {
    public static void main(String[] args) {
        Person6 person6 = new Person6("Tom", 10);
        Student1 student1 = new Student1("Jack", 20);
        student1.hello();

    }
}

class Person6 {
    protected String name;
    protected int age;

    public Person6(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}

class Student1 extends Person6 {
    protected int score;

    public Student1(String name, int age) {
        // 任何class的构造方法，第一行语句必须是调用父类的构造方法。
        // 如果没有明确地调用父类的构造方法，编译器会帮我们自动加一句super();
        // 但是如果没有默认构造方法的时候，需要显式给出父类构造方法的调用
        super(name, age);
        this.name = name;
        this.age = age;
    }

    // 继承有个特点，就是子类无法访问父类的private字段或者private方法。
    // 例如，Student类就无法访问Person类的name和age字段
    // 可以将父类的private字段，改为projected，这样子类也可以访问
    public void hello() {
        System.out.println(super.name);
        System.out.println(super.age);
    }

}