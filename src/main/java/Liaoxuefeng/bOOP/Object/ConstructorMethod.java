package Liaoxuefeng.bOOP.Object;

/*
 * @Author wfy
 * @Date 2020/10/12 17:54
 * com.wfy.java.aQuickStart.OOP.Object
 */

public class ConstructorMethod {
    public static void main(String[] args) {
        Person4 person4 = new Person4("Tom", 10);
        System.out.println(person4.getName() + " " + person4.getAge());
    }
}

class Person4 {
    private String name;
    private int age;

    //默认构造方法
    //没有在构造方法中初始化字段时，
    // 引用类型的字段默认是null，
    // 数值类型的字段用默认值，
    // int类型默认值是0，
    // 布尔类型默认值是false
    public Person4() {

    }

    //自定义构造方法
    public Person4(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //一个构造方法可以调用其他构造方法，这样做的目的是便于代码复用。调用其他构造方法的语法是this(…)
    public Person4(String name) {
        this(name, 18); //  调用另一个构造方法Person(String, int)
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}