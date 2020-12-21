package com.wfy.java.gCollections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Package com.wfy.java.gCollections
 * @Author wfy
 * @Version V1.0.0
 * @Date 2020/12/21 15:33
 */

public class MapExercise {
    public static void main(String[] args) {
        List<Student2> list = List.of(
                new Student2("Bob", 20),
                new Student2("Jack", 30),
                new Student2("Lucy", 21));
        Students students = new Students(list);
        System.out.println(students.getScore("Bob")); // 20
        System.out.println(students.getScore("Lily")); // -1
    }
}

class Students {
    private List<Student2> list;
    private Map<String, Integer> cache;

    public Students(List<Student2> list) {
        this.list = list;
        cache = new HashMap<>();
    }

    // 根据name查找score
    int getScore(String name) {
        Integer score = this.cache.get(name);
        if (score == null) {
            score = findList(name);
            if (score != null) {
                cache.put(name, score);
            }
        }
        return score == null ? -1 : score;
    }

    Integer findList(String name) {
        for (var ss : this.list) {
            if (ss.getName().equals(name)) {
                return ss.getScore();
            }
        }
        return null;
    }

}

class Student2 {
    private String name;
    private int score;

    public Student2(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
