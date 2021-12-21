package Liaoxuefeng.bOOP.Object;

/*
 * @Author wfy
 * @Date 2020/10/13 17:24
 * com.wfy.java.aQuickStart.OOP.Object
 */

public class InheritDemo02 {
    public static void main(String[] args) {
        Person7 person7 = new Person7();
        Student2 student2 = new Student2();
        student2.superName();
    }
}

class Person6 {
    protected String name;
    protected int age;

    public Person6(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}

class Student1 extends Person6 {
    protected int score;

    public Student1(String name, int age) {
        // 任何class的构造方法，第一行语句必须是调用父类的构造方法。
        // 如果没有明确地调用父类的构造方法，编译器会帮我们自动加一句super();
        // 但是如果没有默认构造方法的时候，需要显式给出父类构造方法的调用
        super(name, age);
        this.name = name;
        this.age = age;
    }
}

class Person7 {
    protected String name = "Lucky";
    protected int age;

}

class Student2 extends Person7 {
    public void superName() {
        //super关键字表示父类（超类）。子类引用父类的字段时，可以用super.fieldName。
        System.out.println(super.name);
    }
}