package com.wfy.java.bOOP.Object;

/*
 * @Author wfy
 * @Date 2020/10/19 15:42
 * com.wfy.java.aQuickStart.OOP.Object
 */

import java.util.HashMap;

public class InnerClass {
    public static void main(String[] args) {
        // 1.普通内部类
        Outer outer = new Outer("Jack");
        // 要实例化一个Inner，我们必须首先创建一个Outer的实例outer
        // 然后，调用Outer实例的new来创建Inner实例
        // 这是因为Inner Class除了有一个this指向它自己，还隐含地持有一个Outer Class实例，
        // 可以用Outer.this访问这个实例。所以，实例化一个Inner Class不能脱离Outer实例。
        Outer.Inner inner = outer.new Inner();
        inner.hello();

        // 2.匿名内部类
        HashMap<String, String> map1 = new HashMap<>(); // 普通HashMap实例
        HashMap<String, String> map2 = new HashMap<>() {
        }; // 匿名类，继承自HashMap
        HashMap<String, String> map3 = new HashMap<>() {
            {
                put("A", "1");
                put("B", "1");
            }
        }; // 匿名类，继承自HashMap，并且添加了static代码块来初始化数据
        System.out.println(map3.get("A"));

        // 3.静态内部类（它不再依附于Outer1的实例，而是一个完全独立的类）
        Outer1.StaticNested sn = new Outer1.StaticNested();
        sn.hello();

    }
}


// 被定义在另一个类的内部，所以称为内部类（Nested Class）
// 上述定义的Outer是一个普通类，而Inner是一个Inner Class，它与普通类有个最大的不同，
// 就是Inner Class的实例不能单独存在，必须依附于一个Outer Class的实例。
class Outer {
    private String name;

    Outer(String name) {
        this.name = name;
    }

    // 内部类可以访问并修改Outer的私有字段
    class Inner {
        void hello() {
            System.out.println("Hello, " + Outer.this.name);
        }

    }
}

// 使用匿名类定义Inner class
class Outer1 {
    private String name;
    private static String NAME = "OUTER";

    Outer1(String name) {
        this.name = name;
    }

    // 1. 匿名类asyncHello
    void asyncHello() {
        // Runnable本身是一个接口，不能被实例化，这里就是定义了一个实现了Runnable接口的匿名类
        // 并通过new Runnable来实例化该匿名类，然后转型为Runnable
        // 在定义匿名类时就必须实例化它
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello, " + Outer1.this.name);
            }
        };
        new Thread(r).start();
    }

    // 2. 静态内部类(static nested class)
    // 用static修饰的内部类和Inner Class有很大的不同，它不再依附于Outer的实例，
    // 而是一个完全独立的类，因此无法引用Outer.this，但它可以访问Outer的private静态字段和静态方法。
    // 如果把StaticNested移到Outer之外，就失去了访问private的权限。
    static class StaticNested {
        void hello() {
            System.out.println("Hello " + Outer1.NAME);
        }
    }
}

