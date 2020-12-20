package com.wfy.java.gCollections;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Package com.wfy.java.gCollections
 * @Author wfy
 * @Version V1.0.0
 * @Date 2020/12/8 17:55
 */

public class equalsMethod {
    public static void main(String[] args) {
        List<String> list = List.of("A", "B", "C");
        System.out.println(list.contains("A")); // true
        System.out.println(list.contains("X")); // false
        System.out.println(list.indexOf("A"));  // 0
        System.out.println(list.indexOf("X"));  // -1 不存在返回-1

        // 新添加的元素和已有元素是否是同一个实例?
        // 是不同的实例，但是仍然返回预期的值
        // 这事因为List内部并不是通过==来判断两个元素是否相等，而是使用equals
        System.out.println(list.contains(new String("C"))); // true
        System.out.println(list.indexOf(new String("C"))); // 2

        // 要正确使用List的contains()、indexOf()这些方法，放入的实例必须正确覆写equals()方法，否则，放进去的实例，查找不到。
        // 我们之所以能正常放入String、Integer这些对象，是因为Java标准库定义的这些类已经正确实现了equals()方法。
        // 下面我们自定义一个Person类（并没有复写equals）
        List<Person> stringList = List.of(
                new Person("Lucy"),
                new Person("Jack")
        );
        System.out.println(stringList.contains(new Person("Jack"))); // false

    }
}

class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }
}