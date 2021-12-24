package LearningTest.ReflectionTest;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author summer
 * @title: ReflectionTest
 * @projectName AlgorithmLearning
 * @description: TODO
 * @date 12/16/21 17:40
 */
public class ReflectionTest {
    @Test
    public void test1() {
        // 创建Person类对象
        Person person = new Person("Tom", 20);
        System.out.println(person.getName());
        System.out.println(person.getAge());
        System.out.println(person);
    }

    @Test
    public void test2() throws Exception {
        // 通过反射，创建Person类的对象
        Class<Person> clazz1 = Person.class;
        System.out.println(clazz1);

        Constructor<Person> constructor = clazz1.getConstructor(String.class, int.class);
        Person person1 = constructor.newInstance("Jack", 30);
        System.out.println(person1);

        // 通过反射调用类的属性和方法
        // 调用属性
        Field age = clazz1.getDeclaredField("age");
        age.set(person1, 22);
        System.out.println(person1);

        // 调用方法
        Method show = clazz1.getDeclaredMethod("show");
        // 打印show方法的输出
        show.invoke(person1);

        // 通过反射，可以调用类的私有方法
        Constructor<Person> cons2 = clazz1.getDeclaredConstructor(String.class);
        cons2.setAccessible(true);
        Person jerry = cons2.newInstance("Jerry");
        System.out.println(jerry);

        // 调用私有方法
        Method showNation = clazz1.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        showNation.invoke(person1, "中国");

        // 调用私有属性
        Field name = clazz1.getDeclaredField("name");
        name.setAccessible(true);
        name.set(person1, "Lucky");
        System.out.println(person1);
    }

    /**
     * 获取Class的实例4种方式
     */
    @Test
    public void test3() throws Exception {
        // 1. 通过运行时类的对象，调用getClass()
        Person person1 = new Person("Lucy", 20);
        Class<? extends Person> clazz1 = person1.getClass();
        System.out.println(clazz1);

        // 2. 通过运行时类 .class
        Class<Person> clazz2 = Person.class;
        System.out.println(clazz2);

        // 3. 使用forName，要写类的全路径
        Class<?> person3 = Class.forName("LearningTest.ReflectionTest.Peoples");
        System.out.println(person3);

        // 4. 通过类加载器
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class<?> person4 = classLoader.loadClass("LearningTest.ReflectionTest.Peoples");
        System.out.println(person4);

    }
}

class Person {

    private String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
    }

    public void show() {
        System.out.println("这是一个Person方法");
    }

    private String showNation(String nation) {
        System.out.println("我的国籍是：" + nation);
        return nation;
    }
}