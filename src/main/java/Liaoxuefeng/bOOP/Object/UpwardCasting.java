package Liaoxuefeng.bOOP.Object;

/*
 * @Author wfy
 * @Date 2020/10/14 9:59
 * com.wfy.java.aQuickStart.OOP.Object
 */

public class UpwardCasting {
    public static void main(String[] args) {

        // 如果一个引用变量的类型是Student，那么它可以指向一个Student类型的实例
        Student3 student3 = new Student3();
        Person8 person8 = new Person8();

        // 向上转型
        // Student继承自Person，它拥有Person的全部功能。
        // Person类型的变量，如果指向Student类型的实例，对它进行操作，是没有问题的！
        // 这种把一个子类类型安全地变为父类类型的赋值，被称为向上转型（upcasting）。
        // 向上转型实际上是把一个子类型安全地变为更加抽象的父类型
        Person8 person = new Student3();
        Object object = new Person8();
    }
}


class Person8{

}

class Student3 extends Person8{

}