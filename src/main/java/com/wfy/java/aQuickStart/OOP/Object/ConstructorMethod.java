package com.wfy.java.aQuickStart.OOP.Object;

/*
 * @Author wfy
 * @Date 2020/10/12 17:54
 * com.wfy.java.aQuickStart.OOP.Object
 */

public class ConstructorMethod {
    public static void main(String[] args) {
        Person4 person4 = new Person4("Tom", 10);
        System.out.println(person4.getName() + " " + person4.getAge());
    }
}

class Person4 {
    private String name;
    private int age;

    public Person4(String name, int age) {
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