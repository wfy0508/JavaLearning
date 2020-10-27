package com.wfy.java.eAnnotation;

/*
 * @Author wfy
 * @Date 2020/10/25 11:00
 * com.wfy.java.eAnnotation
 */

import org.jetbrains.annotations.NotNull;

import java.lang.annotation.*;
import java.lang.reflect.Field;

public class HandleAnnotation {
    private String name;

    public static void main(String[] args) {
        // 判断@Report7是否存在于Person1类
        System.out.println(Person1.class.isAnnotationPresent(Report7.class)); // true

        // 使用反射API读取Annotation：
        // 1. Class.getAnnotation(Class)
        // 2. Field.getAnnotation(Class)
        // 3. Method.getAnnotation(Class)
        // 4. Constructor.getAnnotation(Class)
        // 获取Person2定义的@Report7注解：
        Report7 report7 = Person1.class.getAnnotation(Report7.class);
        int type = report7.type();
        String level = report7.level();
        System.out.println("type: " + type + ", level: " + level);

        // 使用反射API读取Annotation有两种方法。
        // 1. 方法一是先判断Annotation是否存在，如果存在，就直接读取：
        Class<Person1> cls = Person1.class;
        if (cls.isAnnotationPresent(Report7.class)) {
            Report7 report71 = cls.getAnnotation(Report7.class);
        }
        // 2. 第二种方法是直接读取Annotation，如果Annotation不存在，将返回null：
        Class<Person1> cls2 = Person1.class;
        Report7 report72 = cls2.getAnnotation(Report7.class);
        if (report72 != null) {
            System.out.println("未找到Annotation。");
        }


    }

    // 读取方法、字段和构造方法的Annotation和Class类似。
    // 但要读取方法参数的Annotation就比较麻烦一点，
    // 因为方法参数本身可以看成一个数组，而每个参数又可以定义多个注解，
    // 所以，一次获取方法参数的所有注解就必须用一个二维数组来表示。例如，对于以下方法定义的注解：
    void hello(@NotNull String name, @NotNull String prefix) {
        System.out.println("Hello, " + name);
    }
    // 要读取方法参数的注解，我们先用反射获取Method实例，然后读取方法参数的所有注解：
    /*
    // 获取Method实例:
    Method m = ...
    // 获取所有参数的Annotation:
    Annotation[][] annotations = m.getParameterAnnotations();
    // 第一个参数（索引为0）的所有Annotation:
    Annotation[] annotationsOfName = annotations[0];
    for (Annotation annotations : annotationsOfName) {
        if (annotations instanceof Range) { // @Range注解
            Range r = (Range) annotations;
        }
        if (annotations instanceof NotNull) { // @NotNull注解
            NotNull n = (NotNull) annotations;
        }
    }
     */
}

// Java的注解对代码本身的逻辑没有任何影响，根据@Retention的配置
// 1. SOURCE类的注解在编译器就被丢弃了
// 2. CLASS类型的注解仅保存在class文件中，他们不会被加载进JVM
// 3. RUNTIME类型的注解会被加载进JVM，并且在运行期间可以被程序读取

// 如何使用注解完全由工具决定。
// 1. SOURCE类型的注解主要由编译器使用，因此我们一般只使用，不编写。
// 2. CLASS类型的注解主要由底层工具库使用，涉及到class的加载，一般我们很少用到。
// 3. 只有RUNTIME类型的注解不但要使用，还经常需要编写。

// 因为注解定义后也是一种class，所有的注解都继承自java.lang.annotation.Annotation，
// 因此，读取注解，需要使用反射API。
// Java提供的使用反射API读取Annotation的方法包括：
// 判断某个注解是否存在于Class、Field、Method或Constructor：
// 1. Class.isAnnotationPresent(Class)
// 2. Field.isAnnotationPresent(Class)
// 3. Method.isAnnotationPresent(Class)
// 4. Constructor.isAnnotationPresent(Class)

@Inherited // 子类可以继承
@Target(ElementType.TYPE) // 指定注解应用的位置：类或接口
@Retention(RetentionPolicy.RUNTIME)
        // 注解类型为RUNTIME
@interface Report7 {
    int type() default 0;

    String level() default "info";

    String value() default "";
}


@Report7(type = 2, level = "warning")
class Person1 {

}

// 注解如何使用，完全由程序自己决定。例如，JUnit是一个测试框架，它会自动运行所有标记为@Test的方法。
//我们来看一个@Range注解，我们希望用它来定义一个String字段的规则：字段长度满足@Range的参数定义：
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Range1 {
    int min() default 0;

    int max() default 255;
}

// 在某个JavaBean中，我们可以使用该注解：
class Person2 {
    @Range1(min = 1, max = 20)
    public String name;

    @Range1(max = 10)
    public String city;

    // 但是，定义了注解，本身对程序逻辑没有任何影响。
    // 我们必须自己编写代码来使用注解。
    // 这里，我们编写一个Person实例的检查方法，它可以检查Person实例的String字段长度是否满足@Range的定义：
    void check(Person2 person) throws IllegalArgumentException, ReflectiveOperationException {
        // 遍历所有Field:
        for (Field field : person.getClass().getFields()) {
            // 获取Field定义的@Range:
            Range1 range = field.getAnnotation(Range1.class);
            // 如果@Range存在:
            if (range != null) {
                // 获取Field的值:
                Object value = field.get(person);
                // 如果值是String:
                if (value instanceof String s) {
                    // 判断值是否满足@Range的min/max:
                    if (s.length() < range.min() || s.length() > range.max()) {
                        throw new IllegalArgumentException("Invalid field: " + field.getName());
                    }
                }
            }
        }
    }
    // 这样一来，我们通过@Range注解，配合check()方法，就可以完成Person实例的检查。
    // 注意检查逻辑完全是我们自己编写的，JVM不会自动给注解添加任何额外的逻辑。
}
