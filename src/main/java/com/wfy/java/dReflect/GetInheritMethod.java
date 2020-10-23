package com.wfy.java.dReflect;

/*
 * @Author wfy
 * @Date 2020/10/23 10:01
 * com.wfy.java.dReflect
 */

import java.awt.desktop.ScreenSleepEvent;

public class GetInheritMethod {
    public static void main(String[] args) throws Exception {
        // 1. 获取某个Class对象时，实际上就获取到了一个类的类型，有3种方式：
        Class cls1 = String.class;
        Class cls2 = "".getClass();
        Class cls3 = Class.forName("java.lang.String");
        // 这三种方式获取的Class实例都是同一个实例，因为JVM对每个加载的Class只创建一个Class实例来表示它的类型。

        // 2. 获取父类的Class
        Class s = Integer.class;
        Class f = s.getSuperclass();
        System.out.println(f); // class java.lang.Number
        Class g = f.getSuperclass();
        System.out.println(g); // class java.lang.Object
        Class gg = g.getSuperclass();
        System.out.println(gg); // null

        System.out.println();

        // 3. 获取interface
        System.out.println("Integer实现的接口如下：");
        Class cls4 = Integer.class;
        // getInterfaces()只返回当前类直接实现的接口类型，并不包括其父类实现的接口类型
        Class[] is = cls4.getInterfaces();
        for (Class i : is) {
            System.out.println(i);
        }

        System.out.println();

        // 4. 获取父类的接口
        System.out.println("Integer的父类实现的接口如下：");
        Class cls5 = Integer.class.getSuperclass();
        // getInterfaces()只返回当前类直接实现的接口类型，并不包括其父类实现的接口类型
        Class[] inf = cls5.getInterfaces();
        for (Class i : inf) {
            System.out.println(i);
        }

        System.out.println();

        // 此外，对所有interface的Class调用getSuperclass()返回的是null，获取接口的父接口要用getInterfaces()：
        System.out.println(java.io.DataInputStream.class.getSuperclass()); //java.io.FilterInputStream，因为DataInputStream继承自FilterInputStream
        System.out.println("对接口的Class调用getSuperClass：");
        System.out.println(java.io.Closeable.class.getSuperclass()); // // null，对接口调用getSuperclass()总是返回null，获取接口的父接口要用getInterfaces()

        // 4. 继承关系
        // 当判断某个实例是否是某个类型时，正常情况下使用instanceof
        Object obj = Integer.valueOf("123");
        boolean isDouble = obj instanceof Double; // false
        boolean isInteger = obj instanceof Integer; // true
        // 如果是两个Class实例，要判断一个向上转型是否成立，可以调用isAssignableFrom方法
        Integer.class.isAssignableFrom(Integer.class); // true，因为Integer可以赋值给Integer
        Number.class.isAssignableFrom(Integer.class);  // true，因为Integer可以赋值给Number
        Object.class.isAssignableFrom(Integer.class);  // true，因为Integer可以赋值给Object
        Integer.class.isAssignableFrom(Number.class);  // false，因为Number不能赋值给Integer
    }
}
