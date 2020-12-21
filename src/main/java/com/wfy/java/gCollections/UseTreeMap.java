package com.wfy.java.gCollections;

import java.util.Comparator;
import java.util.Map;
import java.util.StringJoiner;
import java.util.TreeMap;

/**
 * @Description
 * @Package com.wfy.java.gCollections
 * @Author wfy
 * @Version V1.0.0
 * @Date 2020/12/21 17:32
 */

public class UseTreeMap {
    public static void main(String[] args) {
        // HashMap是一种以空间换时间的映射表，它的实现原理决定了内部的Key是无序的，
        // 即遍历HashMap的Key时，其顺序是不可预测的（但每个Key都会遍历一次且仅遍历一次）。
        // 还有一种Map，它在内部会对Key进行排序，这种Map就是SortedMap。
        // 注意到SortedMap是接口，它的实现类是TreeMap。
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("orange", 10); // 放入key必须实现Comparable接口
        treeMap.put("apple", 20);
        treeMap.put("pear", 30);
        for (String s : treeMap.keySet()) {
            System.out.println(s); // 输入无需，输出是有序的
        }

        // 如果作为KEY的class没有实现Comparable接口，则需要指定一个自定义的排序算法
        Map<Person2, Integer> treeMap1 = new TreeMap<>(new Comparator<Person2>() {
            public int compare(Person2 p1, Person2 p2) {
                return p1.getName().compareTo(p2.getName());
            }
        });

        treeMap1.put(new Person2("Tom"),1);
        treeMap1.put(new Person2("Jack"),2);
        treeMap1.put(new Person2("Ally"),3);
        for (Person2 p : treeMap1.keySet()) {
            System.out.println(p);
        }
        System.out.println(treeMap1.get((new Person2("Bob"))));
    }


}

class Person2 {
    private String name;

    public Person2(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{Person: " + name + "}";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
