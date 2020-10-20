package com.wfy.java.bOOP.CoreClass;

/*
 * @Author wfy
 * @Date 2020/10/20 9:46
 * com.wfy.java.aQuickStart.OOP.CoreClass
 */

// JavaBean主要用来传递数据，即把一组数据组合成一个JavaBean便于传输。
// 此外，JavaBean可以方便地被IDE工具分析，生成读写属性的代码，主要用在图形界面的可视化设计中。

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

public class JavaBean {
    public static void main(String[] args) throws IntrospectionException {
        // 枚举JavaBean属性，可以直接使用Java核心库提供的Introspector
        // 可以列出所有的属性，以及对应的读写方法。注意class属性是从Object继承的getClass()方法带来的。
        BeanInfo info = Introspector.getBeanInfo(Person.class);
        for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
            System.out.println(pd.getName());
            System.out.println("  " + pd.getReadMethod());
            System.out.println("  " + pd.getWriteMethod());
        }

    }
}

// 在Java中，有很多class的定义都符合这样的规范：
// 1. 若干private实例字段；
// 2. 通过public方法来读写实例字段。
class Person {
    private String name;
    private int age;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}

// 如果读写方法符合以下这种命名规范，那么这种class称为JavaBean
// 读方法:
//public Type getXyz()
// 写方法:
//public void setXyz(Type value)

// 字段是xyz，那么读写方法分别以get和set开头，并且后面紧跟大写字母开头的字段名Xyz
// 因此，读写方法就是getXyz()和setXyz()
// boolean字段比较特殊，它的读方法一般命名为isXyz()

// 通常把一组对应的读方法（getter）和写方法（setter）称为属性（property）
// 例如，name属性：
// 对应的读方法是String getName()
// 对应的写方法是setName(String)
// 只有getter的属性称为只读属性（read-only）
// 类似的，只有setter的属性称为只写属性（write-only）

