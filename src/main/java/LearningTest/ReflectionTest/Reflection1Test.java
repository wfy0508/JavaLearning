package LearningTest.ReflectionTest;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 获取运行时类指定的属性、方法、构造方法...
 *
 * @author summer
 * @title: Reflection1Test
 * @projectName JavaLearning
 * @description: TODO
 * @date 12/25/21 16:07
 */
public class Reflection1Test {
    /**
     * 获取指定的属性getField
     */
    @Test
    public void test1() throws Exception {
        Class<Peoples> clazz = Peoples.class;
        Peoples peoples = clazz.getDeclaredConstructor(String.class, int.class).newInstance("Tom", 20);

        // getField只能获取生命为public的属性， 通常不采用此方法, 使用getDeclaredField
        Field id = clazz.getField("id");
        // set() 给id设定一个值
        id.set(peoples, 1001);
        // get()
        int id1 = (int) id.get(peoples);
        System.out.println(id1);
    }

    /**
     * 获取指定的属性getDeclaredField
     */
    @Test
    public void test2() throws Exception {
        Class<Peoples> clazz1 = Peoples.class;
        Peoples p = clazz1.getDeclaredConstructor(String.class, int.class).newInstance("Jack", 30);

        Field age = clazz1.getDeclaredField("age");
        // 获取非public的属性，需现开启访问权限
        age.setAccessible(true);
        age.set(p, 2002);
        int i = (int) age.get(p);
        System.out.println(i);
    }

    /**
     * 获取指定的方法，最常用
     */
    @Test
    public void test3() throws Exception {
        Class<Peoples> clazz2 = Peoples.class;
        Peoples p1 = clazz2.getDeclaredConstructor(String.class, int.class).newInstance("Jack", 30);

        Method method = clazz2.getDeclaredMethod("show", String.class);
        method.setAccessible(true);
        String returnValue = (String) method.invoke(p1, "中国");
        System.out.println(returnValue);
        System.out.println("------");

        // 调用静态方法 public static void showDesc()
        Method showDesc = clazz2.getDeclaredMethod("showDesc");
        // 没有参数，就直接引用类即可
        Object invoke = showDesc.invoke(clazz2);
        System.out.println("返回值为：" + invoke);


    }
}
