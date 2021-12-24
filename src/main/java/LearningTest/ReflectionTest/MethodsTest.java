package LearningTest.ReflectionTest;

import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 获取运行时方法结构
 *
 * @author summer
 * @title: MethodsTest
 * @projectName JavaLearning
 * @description: TODO
 * @date 12/24/21 17:22
 */
public class MethodsTest {
    @Test
    public void test1() {
        Class<Peoples> clazz = Peoples.class;

        // 1. getMethods会获取当前类及其父类中定义个所有public访问权限的方法
        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }

        System.out.println("--------");

        // 2. getDeclaredMethods会返回当前类中定义的所有的方法
        Method[] methods1 = clazz.getDeclaredMethods();
        for (Method m : methods1) {
            System.out.println(m);
        }
    }

    @Test
    public void test2() {
        Class<Peoples> clazz1 = Peoples.class;
        Method[] methods = clazz1.getDeclaredMethods();
        for (Method m : methods) {
            System.out.print(Modifier.toString(m.getModifiers()) + '\t');
            System.out.print(m.getReturnType().toString()+'\t');
            System.out.println(m.getName());
        }
    }
}
