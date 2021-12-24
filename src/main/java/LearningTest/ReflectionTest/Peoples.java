package LearningTest.ReflectionTest;

import org.jetbrains.annotations.NotNull;

import java.lang.annotation.Retention;

/**
 * @author summer
 * @title: Person
 * @projectName JavaLearning
 * @description: TODO
 * @date 12/24/21 15:21
 */
@MyAnnotation(value = "hi")
public class Peoples extends Creature<String> implements Comparable<String>, MyInterface {
    private String name;
    int age;
    public int id;

    public Peoples() {
    }

    @MyAnnotation(value = "abc")
    public Peoples(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @MyAnnotation
    private String show(String nation) {
        System.out.println("我的国籍是: " + nation);
        return nation;
    }

    public String display(String interests) {
        return interests;
    }

    @Override
    public int compareTo(@NotNull String o) {
        return 0;
    }

    @Override
    public void info() {
        System.out.println("我是一个人");
    }
}
