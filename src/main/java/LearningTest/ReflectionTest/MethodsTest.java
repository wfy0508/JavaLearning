package LearningTest.ReflectionTest;

import org.junit.Test;

import java.lang.annotation.Annotation;
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

    /**
     * 权限修饰符
     * 返回值类型
     * 方法名（参数1， 参数2， ...）
     * 注解
     */
    @Test
    public void test2() {
        Class<Peoples> clazz1 = Peoples.class;
        Method[] methods = clazz1.getDeclaredMethods();
        for (Method m : methods) {
            // 获取注解
            Annotation[] annotations = m.getAnnotations();
            for (Annotation anno : annotations) {
                System.out.println(anno);
            }
            // 获取权限修饰符
            System.out.print(Modifier.toString(m.getModifiers()) + '\t');
            // 获取返回值类型
            System.out.print(m.getReturnType().toString() + '\t');
            // 获取方法名
            System.out.print(m.getName() + " (");
            // 获取形参列表
            Class[] parameterTypes = m.getParameterTypes();
            if (!(parameterTypes == null && parameterTypes.length == 0)) {
                for (int i = 0; i < parameterTypes.length; i++) {
                    if (i == parameterTypes.length - 1) {
                        System.out.print(parameterTypes[i] + " args_" + i);
                        break;
                    }
                    System.out.print(parameterTypes[i].getName() + " args_" + i + ",");
                }
            }
            System.out.print(")");
            // 获取抛出的异常
            Class[] exceptionTypes = m.getExceptionTypes();
            if (exceptionTypes.length > 0) {
                System.out.print(" throws ");
                for (int i = 0; i < exceptionTypes.length; i++) {
                    if (i == exceptionTypes.length - 1) {
                        System.out.print(exceptionTypes[i].getName() + " exception_");
                        break;
                    }
                    System.out.print(exceptionTypes[i].getName() + " exception_" + ",");
                }
            }
            else{
                System.out.print(" 无异常抛出！");
            }
            System.out.println();
        }
    }
}
