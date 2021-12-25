package LearningTest.ReflectionTest;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author summer
 * @title: OtherTest
 * @projectName JavaLearning
 * @description: TODO
 * @date 12/24/21 22:36
 */
public class OtherTest {
    @Test
    public void test1() throws NoSuchMethodException {
        Class<Peoples> clazz = Peoples.class;
        // 获取构造器
        Constructor<?>[] constructor = clazz.getConstructors();
        for (Constructor cons : constructor) {
            System.out.println(cons);
        }
        System.out.println("------父类");
        // 获取父类
        Class<? super Peoples> superclass = clazz.getSuperclass();
        System.out.println(superclass);
        System.out.println("------带范型的父类");
        // 获取带范型的父类
        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);
        // 获取实现的接口
        System.out.println("------实现的接口");
        Class<?>[] interfaces = clazz.getInterfaces();
        for(Class<?> c: interfaces){
            System.out.println(c);
        }
    }

    /**
     * 了解即可
     */
    @Test
    public void test2() {
        Class<Peoples> clazz1 = Peoples.class;
        Type genericSuperclass = clazz1.getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) genericSuperclass;
        // 获取范型的类型
        Type[] actualTypeArguments = paramType.getActualTypeArguments();
        System.out.println(actualTypeArguments[0].getTypeName());
    }
}
