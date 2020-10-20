package com.wfy.java.bOOP.Object;

/*
 * @Author wfy
 * @Date 2020/10/16 17:23
 * com.wfy.java.aQuickStart.OOP.Object
 */

public class StaticFieldAndMethod {
    public static void main(String[] args) {
        Person16 ming = new Person16("Xiao Ming", 10);
        Person16 hong = new Person16("Xiao Hong", 20);
        // 对于静态字段，无论修改哪个实例的静态字段，效果都是一样的：所有实例的静态字段都被修改了，
        // 原因是静态字段并不属于实例
        // 虽然实例可以访问静态字段，但是它们指向的其实都是Person class的静态字段。
        // 所有实例共享一个静态字段。
        ming.number = 100; // 可以访问number, 会提示修改为Person16.number
        System.out.println(hong.number); // 输出100
        hong.number = 200; // 可以访问number, 会提示修改为Person16.number
        System.out.println(ming.number); // 输出200

        // 因此，不推荐用实例变量.静态字段去访问静态字段，因为在Java程序中，实例对象并没有静态字段。
        // 在代码中，实例对象能访问静态字段只是因为编译器可以根据实例类型自动转换为 类名.静态字段 来访问静态对象。
        Person16.number = 300;
        System.out.println(Person16.number); // 输出300

        // 通过类名就可以调用，不需要实例
        Person16.setNumber(400);
        System.out.println(Person16.number); //输出400

    }
}

class Person16 {
    public String name;
    public int age;
    public static int number; // 定义静态字段

    public Person16(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 定义静态方法
    // 调用实例方法必须通过一个实例变量，而调用静态方法则不需要实例变量，通过类名就可以调用。
    // 静态方法类似其它编程语言的函数。
    // 静态方法内部，无法访问this变量，也无法访问实例字段，它只能访问静态字段
    public static void setNumber(int value) {
        number = value;
    }

    // 通过实例变量也可以调用静态方法，但这只是编译器自动帮我们把实例改写成类名而已。
    // 通常情况下，通过实例变量访问静态字段和静态方法，会得到一个编译警告。
    // 静态方法经常用于工具类。例如：
    // 1. Arrays.sort()
    // 2. Math.random()
    // 静态方法也经常用于辅助方法。注意到Java程序的入口main()也是静态方法。

    // 因为interface是一个纯抽象类，所以它不能定义实例字段。
    // 但是，interface是可以有静态字段的，并且静态字段必须为final类型
    // interface只能定义public static final类型的字段，可以将其去掉
    // 编译器会自动把该字段变为public static final类型
    interface Person17 {
        public static final int MALE = 1;
        int FEMALE = 2;
    }
}
