package com.wfy.java.bOOP.Object;

/*
 * @Author wfy
 * @Date 2020/10/13 16:30
 * com.wfy.java.aQuickStart.OOP.Object
 */

public class MethodOverload {
    public static void main(String[] args) {
        Hello hello = new Hello();
        hello.hello("Tom");
        hello.hello("Tom", 17);
        hello.hello("Jack", 20);
    }
}


class Hello {
    //方法名相同，但各自的参数不同，称为方法重载（Overload）
    public void hello() {
        System.out.println("Hello, world!");
    }

    public void hello(String name) {
        System.out.println("Hello, " + name + "!");
    }

    public void hello(String name, int age) {
        if (age < 18) {
            System.out.println("Hi, " + name + "!");
        } else {
            System.out.println("Hello, " + name + "!");
        }
    }
}