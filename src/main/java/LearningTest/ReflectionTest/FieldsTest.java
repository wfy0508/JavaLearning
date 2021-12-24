package LearningTest.ReflectionTest;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 获取当前运行时类的属性结构
 *
 * @author summer
 * @title: FieldsTest
 * @projectName JavaLearning
 * @description: TODO
 * @date 12/24/21 15:45
 */
public class FieldsTest {
    @Test
    public void test1() {
        Class<Peoples> clazz = Peoples.class;

        // getFields只会返回当前类及其父类public的属性
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("--------");

        // getDeclaredFields会返回当前类中定义的所有属性
        Field[] fields1 = clazz.getDeclaredFields();
        for (Field field : fields1) {
            System.out.println(field);
        }
    }

    /**
     * 权限修饰符
     * 数据类型
     * 变量名
     */
    @Test
    public void test2() {
        Class<Peoples> clazz1 = Peoples.class;
        Field[] fields = clazz1.getDeclaredFields();
        for (Field f : fields) {
            // 1. 默认做了转换，不同类型对应不同的int型数值
            int modifiers = f.getModifiers();
            // Modifier.toString(modifiers)可以转回实际的类型
            System.out.print(Modifier.toString(modifiers) + '\t');

            // 2. 获取属性的类型
            Class<?> type = f.getType();
            System.out.print(type.toString() + '\t');

            // 3. 获取变量名
            String name = f.getName();
            System.out.println(name);
        }
    }


}
