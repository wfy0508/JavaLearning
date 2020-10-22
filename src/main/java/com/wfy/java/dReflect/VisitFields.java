package com.wfy.java.dReflect;

/*
 * @Author wfy
 * @Date 2020/10/22 16:04
 * com.wfy.java.dReflect
 */

import java.lang.reflect.Field;

public class VisitFields {
    public static void main(String[] args) throws Exception {
        // 1. 对任意的一个Object实例，只要我们获取了它的Class，就可以获取它的一切信息。
        // 1.1. Field getField(name)：根据字段名获取某个public的field（包括父类）
        // 1.2. Field getDeclaredField(name)：根据字段名获取当前类的某个field（不包括父类）
        // 1.3. Field[] getFields()：获取所有public的field（包括父类）
        // 1.4. Field[] getDeclaredFields()：获取当前类的所有field（不包括父类）
        Class <Student> stdClass = Student.class;
        // 获取public字段score
        System.out.println(stdClass.getField("score"));
        System.out.println(stdClass.getField("score").getName()); // 返回名称
        System.out.println(stdClass.getField("score").getType()); // 返回类型
        System.out.println(stdClass.getField("score").getModifiers()); // 返回修饰符，这是一个int，不同的bit表示不同的含义
        // 获取继承的public字段name
        System.out.println(stdClass.getField("name"));
        // 获取private字段grade
        System.out.println(stdClass.getDeclaredField("grade"));

        // 2. 获取字段值
        Object obj = new Person1("Jack");
        Class c = obj.getClass();
        Field f = c.getDeclaredField("name");
        f.setAccessible(true); // 因为name是private，Main方法没有权限访问
        // 如果JVM运行期存在SecurityManager，那么它会根据规则进行检查，有可能阻止setAccessible(true)。
        // 例如，某个SecurityManager可能不允许对java和javax开头的package的类调用setAccessible(true)，
        // 这样可以保证JVM核心库的安全。
        Object value = f.get(obj);
        System.out.println(value);

        // 3. 设置字段值
        Person2 p = new Person2("Tom");
        System.out.println(p.getName());
        Class c1 = p.getClass();
        Field f1 = c1.getDeclaredField("name");
        f1.setAccessible(true);
        f1.set(p, "Cat");
        System.out.println(p.getName());

    }
}

class Person {
    public String name = "";

    public Person(String name) {
        this.name = name;
    }
}

class Student extends Person {

    public int score = 0;
    private int grade;

    public Student(String name) {
        super(name);
        this.name = name;
    }
}

class Person1 {
    private String name="";

    public Person1(String name) {
        this.name = name;
    }
}

class Person2 {
    private String name;

    public Person2(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}