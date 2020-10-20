package com.wfy.java.bOOP.Object;

/*
 * @Author wfy
 * @Date 2020/10/14 10:10
 * com.wfy.java.aQuickStart.OOP.Object
 */

public class DownwardCasting {
    public static void main(String[] args) {

        // 和向上转型相反，如果把一个父类类型强制转型为子类类型，就是向下转型（down casting）
        Person9 p1 = new Student4(); // 向上转型，没有问题
        Person9 p2 = new Person9();
        // p1实际指向Student4实例
        Student4 s1 = (Student4) p1; // person9再转型为Student4，没有问题
        // 不能把父类变为子类，因为子类功能比父类多，多的功能无法凭空变出来
        // p2实际指向Person9实例
        // Student4 s2 = (Student4) p2; // runtime error! ClassCastException!

        //为了避免向下转型出错，Java提供了instanceof操作符，可以先判断一个实例究竟是不是某种类型
        System.out.println(p1 instanceof Student4); // true
        System.out.println(p2 instanceof Student4); // false

        // 利用instanceof，在向下转型前可以先判断
        if (p2 instanceof Student4) {
            Student4 s2 = (Student4) p2;
        }

        // 从Java 14开始，判断instanceof后，可以直接转型为指定变量，避免再次强制转型。
        Object obj = "hello";
        if (obj instanceof String s) {
            System.out.println(s.toUpperCase());
        }
    }
}

class Person9 {

}

class Student4 extends Person9 {

}