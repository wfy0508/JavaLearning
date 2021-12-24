package LearningTest.ReflectionTest;

import org.junit.Test;

import java.util.Random;

/**
 * @author summer
 * @title: RuntimeClassTest
 * @projectName JavaLearning
 * @description: TODO
 * @date 12/24/21 14:08
 */
public class RuntimeClassTest {
    @Test
    public void test1() throws Exception {
        int i = new Random().nextInt(3);
        String classPath = "";
        switch (i){
            case 0:
                classPath = "java.util.Date";
                break;
            case 1:
                classPath = "java.lang.Object";
                break;
            case 2:
                classPath = "LearningTest.ReflectionTest.Person";
                break;
            default:
                break;
        }
        Object instance = getInstance(classPath);
        System.out.println(instance);

    }
    /**
     * 创建一个指定类的对象
     * classPath执行一个全类名
     */
    public Object getInstance(String classPath) throws Exception {
        Class<?> clazz = Class.forName(classPath);
        return clazz.getDeclaredConstructor().newInstance();
    }

}
