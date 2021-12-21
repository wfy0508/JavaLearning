package Liaoxuefeng.gCollections;

import java.util.Objects;

/**
 * @Description
 * @Package com.wfy.java.gCollections
 * @Author wfy
 * @Version V1.0.0
 * @Date 2020/12/20 19:13
 */

public class selfEqualsMethod {
    public static void main(String[] args) {
        Person1 person1 = new Person1("Bob", 20);
        Person1 person2 = new Person1("", 22);
        Person1 person3 = new Person1("Bob", 20);
        System.out.println(person1.isEquals(person2));
        System.out.println(person1.isEquals(person3));
        System.out.println(person1.isEquals1(person3));
    }
}

class Person1 {
    private String name;
    private int age;

    public Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // 定义第一种equals方法
    public boolean isEquals(Object o) {
        if (o instanceof Person1 p) {
            boolean nameEquals = false;
            if (this.name == null && p.name == null) {
                nameEquals = true;
            }
            if (this.name != null) {
                nameEquals = this.name.equals(p.name);
            }
            return nameEquals && this.age == p.age;
        }
        return false;
    }

    // 如果Person有好几个引用类型的字段，上面的写法就太复杂了。
    // 要简化引用类型的比较，我们使用Objects.equals()静态方法：
    // 2. 定义第一种equals方法
    public boolean isEquals1(Object o) {
        if (o instanceof Person1 p) {
            return Objects.equals(this.name, p.name) && this.age == p.age;
        }
        return false;
    }

    // 总结一下equals()方法的正确编写方法：
    // 1. 先确定实例“相等”的逻辑，即哪些字段相等，就认为实例相等；
    // 2. 用instanceof判断传入的待比较的Object是不是当前类型，如果是，继续比较，否则，返回false；
    // 3. 对引用类型用Objects.equals()比较，对基本类型直接用==比较。
}
