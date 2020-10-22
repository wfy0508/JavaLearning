package com.wfy.java.dReflect;

/*
 * @Author wfy
 * @Date 2020/10/22 14:35
 * com.wfy.java.cExceptionHandling
 */

import org.apache.commons.logging.LogFactory;

public class ReflectClass {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 除了int等基本类型外，Java的其他类型全部都是class（包括interface）。
        // class（包括interface）的本质是数据类型（Type）。无继承关系的数据类型无法赋值：
        Number n = new Double(123.456); // 没问题
        //String s = new Double(123.456); // Double并不是继承自String，不能用Double给String类型赋值

        // 而class是由JVM在执行过程中动态加载的。JVM在第一次读取到一种class类型时，将其加载进内存。
        //每加载一种class，JVM就为其创建一个Class类型的实例，并关联起来。
        // 注意：这里的Class类型是一个名叫Class的class。它长这样：
        /*
        public final class Class{
            private Class{}
        }
         */
        // 以String类为例，当JVM加载String类时，它首先读取String.class文件到内存，
        // 然后，为String类创建一个Class实例并关联起来：
        // Class cls = new Class(String);
        // 这个Class实例是JVM内部创建的，如果我们查看JDK源码，可以发现Class类的构造方法是private，
        // 只有JVM能创建Class实例，我们自己的Java程序是无法创建Class实例的。
        // 所以，JVM持有的每个Class实例都指向一个数据类型（class或interface）

        // 由于JVM为每个加载的class创建了对应的Class实例，并在实例中保存了该class的所有信息，
        // 包括类名、包名、父类、实现的接口、所有方法、字段等，因此，如果获取了某个Class实例，
        // 我们就可以通过这个Class实例获取到该实例对应的class的所有信息。
        //这种通过Class实例获取class信息的方法称为反射（Reflection）。
        // 获取一个class的Class实例
        // 1. 直接通过一个class的静态变量class获取
        Class cls1 = String.class;

        // 2. 如果我们有一个实例变量，可以通过该实例变量提供的getClass()方法获取
        String s = "Hello";
        Class cls2 = s.getClass();

        // 3. 如果知道一个class的完整类名，可以通过静态方法Class.forName()获取
        Class cls3 = Class.forName("java.lang.String");

        // 因为Class实例在JVM中是唯一的，所以，上述方法获取的Class实例是同一个实例。可以用==比较两个Class实例
        Class cls4 = String.class;
        String s1 = "Hello";
        Class cls5 = s1.getClass();
        System.out.println(cls4 == cls5); //true

        // 注意到数组（例如String[]）也是一种Class，
        // 而且不同于String.class，它的类名是[Ljava.lang.String。
        // 此外，JVM为每一种基本类型如int也创建了Class，通过int.class访问。
        // 如果获取到了一个Class实例，我们就可以通过Class实例来创建对应类型的实例：
        Class cls6 = String.class;
        String s2 = (String) cls6.newInstance(); // 等号右边相当于new String()
        // 通过Class.newInstance()可以创建类实例，它的局限是：只能调用public的无参数构造方法。
        // 带参数的构造方法，或者非public的构造方法都无法通过Class.newInstance()被调用。

        // 动态加载
        // JVM在执行java程序的时候，并不是一次性把所有的class都读入内存，而是在第一次使用class时才加载
        // 动态加载class的特性对于Java程序非常重要。利用JVM动态加载class的特性，我们才能在运行期根据条件加载不同的实现类。
        // 例如，Commons Logging总是优先使用Log4j，只有当Log4j不存在时，才使用JDK的logging。

    }

    // 因为反射的目的是为了获得某个实例的信息。
    // 因此，当我们拿到某个Object实例时，我们可以通过反射获取该Object的class信息
    void printObjectInfo(Object obj) {
        Class cls6 = obj.getClass();
    }
}
