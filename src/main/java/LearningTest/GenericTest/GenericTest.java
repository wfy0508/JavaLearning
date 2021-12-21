package LearningTest.GenericTest;

import org.junit.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yanlingwang
 */
public class GenericTest {
    @Test
    public void test() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(-90);
        list.add(100);
        list.add(-234);
        list.add(23);
        for (Integer i : list) {
            System.out.println(i);
        }
    }
    @Test
    public void test1(){
        /*
        虽然A是B的父类，但是G<A>和G<B>是并列关系，并不是继承关系
         */
        List<Object> list1 = null;
        List<String> list2 = null;

        // list2不能赋值给list1
        // list1 = list2;

        /*
        A是B的父类，但是B<G>和B<G>是并列关系，可以继承父子类关系的使用
         */
        List<String> list3 = null;
        ArrayList<String> list4 = null;

        // 可以赋值
        list3 = list4;

        /*
        通配符的使用
         */
        List<?> list5 = null;
        //list5 = list1;
        //list5 = list2

        ArrayList<String> list6 = new ArrayList<>();
        list5 = list6;
        list6.add("AA");
        list6.add("BB");
        list6.add("CC");

        // 使用？声明泛型之后，不能添加除了null之外的元素
        //list5.add(null);

        // 但可以获取元素，元素的返回类型为Object
        Object o = list5.get(0);
        System.out.println(o);
    }

    /**
     * 有限制条件的通配符
     */
    @Test
    public void test3(){
        // ? extends表示可以接受后面类型的子类型
        List<? extends Person> list1 = null;
        // ? super表示可以接受后面类型的父类型
        List<? super Person> list2 = null;

        List<Student> list3 = null;
        List<Object> list4 = null;
        List<Person> list5 = null;

        // Student是Person的子类，可以正常赋值
        list1 = list3;

        // Object是Person的父类，不能赋值
        //list4 = list3;
    }

}

class Person<K, V> {
    private K name;
    private V age;

    public Person(K name, V age) {
        this.name = name;
        this.age = age;
    }

    public void setName(K name) {
        this.name = name;
    }

    public void setAge(V age) {
        this.age = age;
    }

    public K getName() {
        return name;
    }

    public V getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                ", age=" + age +
                '}';
    }
}


class Person1 implements Comparable<Object>{
    String name;
    int age;

    @Override
    public int compareTo(Object o) {
        if(o instanceof Person1){
            Person1 person1 = (Person1) o;
            return this.name.compareTo(person1.name);
        }else {
            throw new RuntimeException("输入类型不一致！");
        }
    }
}

class Student extends Person{

    public Student(Object name, Object age) {
        super(name, age);
    }
}
