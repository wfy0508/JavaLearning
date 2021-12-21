package Liaoxuefeng.bOOP.Object;

/*
 * @Author wfy
 * @Date 2020/10/12 15:17
 * com.wfy.java.aQuickStart.OOP.Object
 */

public class ParasBind {
    public static void main(String[] args) {
        //1. 基本类型传递
        int n = 10;
        Person2 person2 = new Person2();
        person2.setAge(n); //将n=10的值传给变量
        n = 20; //将n值修改为20
        //输出10：
        //修改外部的局部变量n，不影响实例p的age字段，
        // 原因是setAge()方法获得的参数，复制了n的值，因此，person2.age和局部变量n互不影响。
        //结论：基本类型参数的传递，是调用方值的复制。双方各自的后续修改，互不影响。
        System.out.println(person2.getAge()); //打印出10还是20？

        //2.
        String bob = "Bob";
        person2.setName(bob);
        System.out.println(person2.getName()); //输出Bob
        bob = "Tom"; //指向了新的内存地址，与serName断开连接
        System.out.println(person2.getName()); //还是输出Bob


        //3. 传递引用参数
        //引用类型参数的传递，调用方的变量，和接收方的参数变量，指向的是同一个对象。
        // 双方任意一方对这个对象的修改，都会影响对方（因为指向同一个对象嘛）
        Person3 person3 = new Person3();
        String[] fullName = new String[]{"Tom", "Jack"};
        person3.setName(fullName); // 传入fullName数组
        System.out.println(person3.getName()); //返回 Tom Jack
        fullName[0] = "Luck"; // fullName数组的第一个元素修改为"Luck"
        System.out.println(person3.getName()); //返回 Luck Jack

    }
}

class Person2 {
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}

class Person3 {
    private String[] name;

    public String getName() {
        return this.name[0] + " " + this.name[1];
    }

    public void setName(String[] name) {
        this.name = name;
    }
}