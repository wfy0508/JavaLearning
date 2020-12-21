package com.wfy.java.gCollections;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Package com.wfy.java.gCollections
 * @Author wfy
 * @Version V1.0.0
 * @Date 2020/12/21 15:16
 */

public class useMap {
    public static void main(String[] args) {
        Student s1 = new Student("xiao ming", 20);
        Map<String, Student> map = new HashMap<>();
        map.put("xiao ming", s1);
        Student s2 = map.get("xiao ming");
        System.out.println(s1 == s2); //true
        System.out.println(s1.getAge()); //20
        Student s3 = map.get("xiao hong");
        System.out.println(s3); //null
        System.out.println(map.containsKey("xiao hong")); // false
        System.out.println(map.containsValue(20)); // false 

        // 要遍历key可以使用for each循环遍历Map实例的keySet()方法返回的Set集合，它包含不重复的key的集合
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("Apple", 1);
        map1.put("Microsoft", 2);
        map1.put("Google", 3);
        map1.put("Netflix", 4);
        for (String s : map1.keySet()) {
            Integer i = map1.get(s);
            System.out.println(s + "\t" + i); // 输出并不一定和put的顺序相同

        }

    }
}

class Student {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}