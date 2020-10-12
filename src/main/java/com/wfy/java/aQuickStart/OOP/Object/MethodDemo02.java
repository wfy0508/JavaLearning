package com.wfy.java.aQuickStart.OOP.Object;

/*
 * @Author wfy
 * @Date 2020/10/10 14:57
 * com.wfy.java.aQuickStart.OOP.Object
 */

import java.util.Date;

public class MethodDemo02 {
    public static void main(String[] args) {
        Person1 person = new Person1();
        person.setBirth(1990);
        person.setName("Tom");
        System.out.println(person.getName() + " " + person.getAge());
    }
}


class Person1 {
    private String name;
    private int birth;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setBirth(int birth) {
        this.birth = birth;
    }

    private int calAge(int currentYear) {
        return currentYear - this.birth;
    }

    public int getAge() {
        return calAge(2020);
    }
}