package com.wfy.java.bOOP.Object;

/*
 * @Author wfy
 * @Date 2020/10/10 14:19
 * com.wfy.java.aQuickStart.OOP.Object
 */

public class MethodDemo01 {
    public static void main(String[] args) {
        Person ming = new Person();
        ming.setName("Tom", "Jack");
        ming.setAge(10);
        System.out.println(ming.getName() + " " + ming.getAge());
    }
}


class Person {
    private String name;
    private String[] names;
    private int age;

    public String getName() {
        //在方法内部，可以使用一个隐含的变量this，它始终指向当前实例。
        // 因此，通过this.field就可以访问当前实例的字段。
        return this.name; // 前面的this不可少，少了就变成局部变量name了(前面已经定义了private String name;)
    }

    //不允许传入null和空字符串
    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("invalid name value");
        }
        this.name = name;
    }

    //接收两个参数
    public void setNameAndAge(String name, int age) {
        this.name = name;
        this.age = age;
    }


    //可变参数用类型...定义，可变参数相当于数组类型
    public void setName(String... names) {
        this.names = names;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("invalid age value");
        }
        this.age = age;
    }

}