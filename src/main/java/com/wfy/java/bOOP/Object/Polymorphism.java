package com.wfy.java.bOOP.Object;

/*
 * @Author wfy
 * @Date 2020/10/14 17:58
 * com.wfy.java.aQuickStart.OOP.Object
 */

public class Polymorphism {
    public static void main(String[] args) {
        Person11 person11 = new Person11();
        Student6 student6 = new Student6();
        person11.run(); // 执行Person11的方法
        student6.run();

        // 一个实际类型为Student，引用类型为Person的变量，调用其run()方法，
        // 调用的是Person还是Student的run()方法？
        // 实际上调用的方法是Student的run()方法。
        // Java的实例方法调用是基于运行时的实际类型的动态调用，而非变量的声明类型。
        Person11 p1 = new Student6();
        p1.run(); // 输出Student.run

        Income[] income = new Income[]{
                new Income(5000),
                new Salary(7000),
                new StateCouncilSpecialAllowance(10000)
        };
        System.out.println("totalTax: " + totalTax(income));
    }

    // 利用多态，totalTax()方法只需要和Income打交道，
    // 它完全不需要知道Salary和StateCouncilSpecialAllowance的存在，就可以正确计算出总的税。
    // 如果我们要新增一种稿费收入，只需要从Income派生，然后正确覆写getTax()方法就可以。
    // 把新的类型传入totalTax()，不需要修改任何代码。
    // 多态具有一个非常强大的功能，就是允许添加更多类型的子类实现功能扩展，却不需要修改基于父类的代码。
    public static double totalTax(Income... incomes) {
        double total = 0;
        for (Income income : incomes) {
            total = total + income.getTax();
        }
        return total;
    }
}

//在继承关系中，子类如果定义了一个与父类方法签名完全相同的方法，被称为覆写（Override）
class Person11 {
    public void run() {
        System.out.println("Person.run");
    }
}

class Student6 extends Person11 {
    // Override和Overload不同的是，如果方法签名如果不同，就是Overload，Overload方法是一个新方法；
    // 如果方法签名相同，并且返回值也相同，就是Override。
    // 如果方法名相同，方法参数相同，返回值不同，也是不同的方法。出现这种情况，编译器会报错。

    // 加上@Override可以让编译器帮助检查是否进行了正确的覆写。
    // 希望进行覆写，但是不小心写错了方法签名，编译器会报错。
    // public void run(String s) {  // 传参与父类不同，不能Override
    @Override
    public void run() {
        System.out.println("Student.run");
    }

    // 传入的参数类型是Person，但是在调用之前无法确定实际传入的类型究竟是Person，还是Student，还是Person的其他子类
    // 因此，也无法确定调用的是不是Person类定义的run()方法。
    // 多态的特性就是，运行期才能动态决定调用的子类方法。
    // 对某个类型调用某个方法，执行的实际方法可能是某个子类的覆写方法。
    public void runTwice(Person11 p) {
        p.run();
        p.run();
    }
}

class Income {
    protected double income;

    public Income(double income) {
        this.income = income;
    }

    public double getTax() {
        return income * 0.1;
    }
}

class Salary extends Income {
    public Salary(double income) {
        super(income);
    }

    @Override
    public double getTax() {
        if (income <= 5000) {
            return 0;
        } else {
            return (income - 5000) * 0.1;
        }
    }
}

class StateCouncilSpecialAllowance extends Income {
    public StateCouncilSpecialAllowance(double income) {
        super(income);
    }

    @Override
    public double getTax() {
        return 0;
    }
}