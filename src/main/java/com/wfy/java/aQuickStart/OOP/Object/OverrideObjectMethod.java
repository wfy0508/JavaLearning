package com.wfy.java.aQuickStart.OOP.Object;

/*
 * @Author wfy
 * @Date 2020/10/16 10:29
 * com.wfy.java.aQuickStart.OOP.Object
 */

public class OverrideObjectMethod {
    public static void main(String[] args) {
        Person12 person12 = new Person12();
        Student7 student7 = new Student7();

        person12.setName("Jack");
        System.out.println(person12.getName());
        System.out.println(student7.hello());
    }
}

// 因为所有的class最终都继承自Object，而Object定义了几个重要的方法：
// 1. toString()：把instance输出为String；
// 2. equals()：判断两个instance是否逻辑相等；
// 3. hashCode()：计算一个instance的哈希值。

class Person12 {
    protected String name = "Tom";

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String hello() {
        return "Hello, " + name;
    }

    public final String helloWorld() {
        return "Hello, world!";
    }

    // 复写Object的toString方法
    @Override
    public String toString() {
        return "Person:name = " + name;
    }

    // 比较相等
    @Override
    public boolean equals(Object obj) {
        // 只有当类型为Person12时
        if (obj instanceof Person12) {
            Person12 p = (Person12) obj;
            // 且name相等时，返回true
            return this.name.equals(p.name);
        }
        return false;
    }

    // 计算hash
    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}

class Student7 extends Person12 {
    @Override
    public String hello() {
        return super.hello() + "!"; // 在子类的覆写方法中，如果要调用父类的被覆写的方法，可以通过super来调用
    }

    // 父类声明为final方法，子类不能复写
//    @Override
//    public String helloWorld(){
//        return "Hello, world!"
//    }
}
