package Liaoxuefeng.dReflect;

/*
 * @Author wfy
 * @Date 2020/10/22 16:38
 * com.wfy.java.dReflect
 */

import java.lang.reflect.Method;
import java.util.Arrays;

public class InvokeMethod {
    public static void main(String[] args) throws Exception {
        // 1. 获取方法
        // 1.1 Method getMethod(name, Class...)：获取某个public的Method（包括父类）
        // 1.2 Method getDeclaredMethod(name, Class...)：获取当前类的某个Method（不包括父类）
        // 1.3 Method[] getMethods()：获取所有public的Method（包括父类）
        // 1.4 Method[] getDeclaredMethods()：获取当前类的所有Method（不包括父类）
        Class<Student3> stdClass = Student3.class;
        System.out.println(stdClass.getMethod("getScore", String.class)); //参数为String
        System.out.println(stdClass.getMethod("getScore", String.class).getName());
        System.out.println(stdClass.getMethod("getScore", String.class).getReturnType());
        System.out.println(Arrays.toString(stdClass.getMethod("getScore", String.class).getParameterTypes()));
        System.out.println(stdClass.getMethod("getScore", String.class).getModifiers());

        System.out.println(stdClass.getMethod("getName")); //无参数
        System.out.println(stdClass.getDeclaredMethod("getGrade", int.class)); //参数为int

        // 2. 调用方法
        String s = "Hello world!";
        Method m = String.class.getMethod("substring", int.class);
        // 对Method实例调用invoke就相当于调用该方法，
        // invoke的第一个参数是对象实例，即在哪个实例上调用该方法，
        // 后面的可变参数要与方法参数一致，否则将报错。
        String r = (String) m.invoke(s, 6);
        System.out.println(r);

        // 3. 调用静态方法
        // 无需指定实例对象，所以invoke的第一个参数永远为null
        Method m1 = Integer.class.getMethod("parseInt", String.class);
        Integer n = (Integer) m1.invoke(null, "123456");
        System.out.println(n);

        // 4. 调用非public方法
        // 需要设置Method.setAccessible(true)
        Person4 p4 = new Person4();
        Method m2 = p4.getClass().getDeclaredMethod("setName", String.class);
        m2.setAccessible(true); // 有可能会失败
        m2.invoke(p4, "Lucky");
        System.out.println(p4.name);

        // 5. 多态
        // 一个Person类定义了hello()方法，并且它的子类Student也覆写了hello()方法，
        // 那么，从Person.class获取的Method，作用于Student实例时，调用的方法到底是哪个？
        Method h = Person3.class.getMethod("hello");
        h.invoke(new Student3()); // 返回Student.hello，使用反射调用方法时，仍然遵循多态原则：即总是调用实际类型的覆写方法（如果存在）
    }
}

class Person3 {
    public String getName() {
        return "Person";
    }

    public void hello() {
        System.out.println("Person.hello");
    }
}

class Student3 extends Person3 {
    public int getScore(String type) {
        return 99;
    }

    private int getGrade(int year) {
        return 1;
    }

    @Override
    public void hello() {
        System.out.println("Student.hello");
    }
}


class Person4 {
    String name = "";

    private void setName(String name) {
        this.name = name;
    }
}