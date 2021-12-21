package Liaoxuefeng.bOOP.Object;

/*
 * @Author wfy
 * @Date 2020/10/14 11:16
 * com.wfy.java.aQuickStart.OOP.Object
 */

public class InheritAndCombine {
    public static void main(String[] args) {
        System.out.println("InheritAndCombine");
    }
}

class Person10 {
    protected String name;
}

class Book {
    protected String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Student5应该继承自Person10，而不应该继承自Book
// 因为Student是Person的一种，它们是is关系，而Student并不是Book。实际上Student和Book的关系是has关系
//class Student5 extends Book {
//    protected int score;
//}

// 具有has关系不应该使用继承，而是使用组合，即Student可以持有一个Book实例
class Student5 extends Person10 {
    protected Book book; //持有一个Book的实例
    protected int score;
}