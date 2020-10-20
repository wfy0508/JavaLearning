package com.wfy.java.bOOP.Object;

/*
 * @Author wfy
 * @Date 2020/10/16 11:08
 * com.wfy.java.aQuickStart.OOP.Object
 */

public class AbstractClass {
    public static void main(String[] args) {
        // 这种引用抽象类的好处在于，对其进行方法调用，并不关心Person类型变量的具体子类型
        Person13 person1 = new Student8();
        Person13 person2 = new Teacher();
        // 这种引用抽象类的好处在于，我们对其进行方法调用，并不关心Person类型变量的具体子类型
        person1.run();
        person2.run();
        // 这种尽量引用高层类型，避免引用实际子类型的方式，称之为面向抽象编程。
        // 1. 上层代码只定义规范（例如：abstract class Person）
        // 2. 不需要子类就可以实现业务逻辑（正常编译）
        // 3. 具体的业务逻辑有不同的子类实现，调用者不用关心
    }
}


// 如果父类的方法本身不需要实现任何功能，仅仅是为了定义方法签名，目的是让子类去覆写它，
// 那么，可以把父类的方法声明为抽象方法

// 把一个方法声明为abstract，表示它是一个抽象方法，本身没有实现任何方法语句。
// 因为这个抽象方法本身是无法执行的，所以，Person类也无法被实例化。
// 编译器会告诉我们，无法编译Person类，因为它包含抽象方法。
abstract class Person13 {
    protected abstract void run();
}

// 无法实例化的抽象类有什么用？
// 因为抽象类本身被设计成只能用于被继承，因此，抽象类可以强迫子类实现其定义的抽象方法，否则编译会报错。
// 因此，抽象方法实际上相当于定义了“规范”。
// 例如，Person类定义了抽象方法run()，那么，在实现子类Student的时候，就必须覆写run()方法

class Student8 extends Person13 {
    @Override
    public void run() {
        System.out.println("Student.run");
    }
}

class Teacher extends Person13 {
    @Override
    public void run() {
        System.out.println("Teacher.run");
    }
}