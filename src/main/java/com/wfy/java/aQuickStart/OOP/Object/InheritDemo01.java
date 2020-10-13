package com.wfy.java.aQuickStart.OOP.Object;

/*
 * @Author wfy
 * @Date 2020/10/13 16:42
 * com.wfy.java.aQuickStart.OOP.Object
 */

public class InheritDemo01 {
    public static void main(String[] args) {
        Person5 person5 = new Person5();
        person5.setName("Tom");
        person5.setAge(10);
        System.out.println("Name: " + person5.getName() + ", Age: " + person5.getAge());

        Student student = new Student();
        student.setScore(88);
        student.setName("Lucky");
        System.out.println("Score: " + student.getScore());

    }
}

class Person5 {
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}

// 子类自动获得了父类的所有字段，严禁定义与父类重名的字段！
// Java只允许一个class继承自一个类，因此，一个类有且仅有一个父类。只有Object特殊，它没有父类。
class Student extends Person5 {
    private int score;

    public Student() {

    }

    public Student(String name, int age, int score) {
        this.score = score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}